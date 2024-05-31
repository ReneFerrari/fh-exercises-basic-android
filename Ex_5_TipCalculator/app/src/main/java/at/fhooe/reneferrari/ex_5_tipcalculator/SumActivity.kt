package at.fhooe.reneferrari.ex_5_tipcalculator

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum)

        val billingAmount = intent.extras?.getDouble(TipActivity.KEY_BILLING_AMOUNT) ?: 0.0
        val tipAmount = intent.extras?.getDouble(TipActivity.KEY_TIP_AMOUNT) ?: 0.0

        val tvBillingAmount = findViewById<TextView>(R.id.tv_activitysum_billingamount)
        val tvTip = findViewById<TextView>(R.id.tv_activitysum_tip)
        val tvSum = findViewById<TextView>(R.id.tv_activitysum_sum)
        val btnPay = findViewById<MaterialButton>(R.id.btn_activitymain_pay)

        tvBillingAmount.text = "${String.format("%.2f", billingAmount)} €"
        tvTip.text = "+ ${String.format("%.2f", tipAmount)} €"
        tvSum.text = "= ${String.format("%.2f", billingAmount + tipAmount)} €"

        btnPay.setOnClickListener {
            Toast.makeText(this, getString(R.string.successfully_paid), Toast.LENGTH_SHORT).show()
            finishAndRemoveTask()
        }
    }
}