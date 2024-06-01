package com.tractive.android.app_6_kmeme

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var ivMeme: ImageView
    private lateinit var tietTopCaption: TextInputEditText
    private lateinit var tietBottomCaption: TextInputEditText
    private lateinit var tvTopCaption: TextView
    private lateinit var tvBottomCaption: TextView
    private lateinit var fabAddImage: FloatingActionButton
    private lateinit var btnShare: MaterialButton

    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                ivMeme.setImageURI(uri)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        applyScreenPadding()

        ivMeme = findViewById(R.id.iv_activitymain_image)
        tietTopCaption = findViewById(R.id.tiet_activitymain_captiontop)
        tietBottomCaption = findViewById(R.id.tiet_activitymain_captionbottom)
        tvTopCaption = findViewById(R.id.tv_activitymain_captiontop)
        tvBottomCaption = findViewById(R.id.tv_activitymain_captionbottom)
        fabAddImage = findViewById(R.id.fab_activitymain_addimage)
        btnShare = findViewById(R.id.btn_activitymain_share)

        tietTopCaption.doAfterTextChanged { text ->
            tvTopCaption.text = text
        }

        tietBottomCaption.doAfterTextChanged { text ->
            tvBottomCaption.text = text
        }

        fabAddImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        btnShare.setOnClickListener {
            val file = generateMeme(
                tvTopCaption,
                tvBottomCaption,
                ivMeme
            )

            shareImage(file)
        }
    }

    private fun applyScreenPadding() {
        val sixteenDp = resources.getDimensionPixelSize(R.dimen.large)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left + sixteenDp,
                systemBars.top + sixteenDp,
                systemBars.right + sixteenDp,
                systemBars.bottom + sixteenDp
            )
            insets
        }
    }

    private fun shareImage(file: File) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            putExtra(
                Intent.EXTRA_STREAM,
                FileProvider.getUriForFile(
                    this@MainActivity,
                    getString(R.string.authority),
                    file
                )
            )
            type = "image/png"
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }

        startActivity(Intent.createChooser(shareIntent, null))
    }

    private fun generateMeme(
        topCaption: TextView,
        bottomCaption: TextView,
        imageView: ImageView
    ): File {
        val bitmap = Bitmap.createBitmap(
            imageView.width,
            imageView.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)

        imageView.draw(canvas)
        canvas.save()

        canvas.translate(
            (imageView.width + topCaption.width) / 2f - topCaption.width,
            topCaption.marginTop.toFloat()
        )
        topCaption.draw(canvas)

        canvas.restore()
        canvas.translate(
            (imageView.width + bottomCaption.width) / 2f - bottomCaption.width,
            imageView.height - bottomCaption.height - bottomCaption.marginBottom.toFloat()
        )
        bottomCaption.draw(canvas)

        val file = File(cacheDir, "meme.png")

        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 70, out)
        }

        return file
    }
}