package at.fhooe.reneferrari.ex_5_tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etBillingAmount = findViewById<EditText>(R.id.et_activitymain_billingamount)
        val btnNext = findViewById<MaterialButton>(R.id.btn_activitymain_next)

        btnNext.setOnClickListener {
            val billingAmount = etBillingAmount.text.toString()

            if (billingAmount.isNotEmpty()) {
                startActivity(Intent(this, TipActivity::class.java).apply { putExtra(KEY_BILLING_AMOUNT, billingAmount.toDouble())})
            }
        }
    }

    companion object {
        const val KEY_BILLING_AMOUNT = "KEY_BILLING_AMOUNT"
    }
}