package at.fhooe.reneferrari.ex_8_convertimagetoblackandwhite

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConvert = findViewById<Button>(R.id.btn_activitymain_convert)
        val imageView = findViewById<ImageView>(R.id.iv_activitymain_image)

        btnConvert.setOnClickListener {
            Thread {
                val bitmap = getDrawable(R.drawable.image)!!.toBitmap()
                val bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true)
                var currentPixel: Int = 0
                var greyscalePixel: Int = 0

                for (i in 0 until bitmap.width) {
                    for (j in 0 until bitmap.height) {
                        currentPixel = bitmap.getPixel(i, j)
                        greyscalePixel = (Color.red(currentPixel) * 0.299).toInt() + (Color.green(currentPixel) * 0.587).toInt() + (Color.blue(currentPixel) * 0.114).toInt()

                        bitmapCopy.setPixel(i, j, Color.rgb(
                                greyscalePixel,
                                greyscalePixel,
                                greyscalePixel
                            )
                        )
                    }
                }
                imageView.post {
                    imageView.setImageBitmap(bitmapCopy)
                }
            }.start()
        }
    }
}