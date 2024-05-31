package at.fhooe.reneferrari.ex_5_tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton

class TipActivity : AppCompatActivity() {

    private lateinit var etTipAmount: EditText
    private lateinit var tvPercentageOfBill: TextView

    private lateinit var viewModel: TipViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip)

        viewModel = ViewModelProvider(this)[TipViewModel::class.java]

        val billingAmount = intent.extras?.getDouble(MainActivity.KEY_BILLING_AMOUNT)
        viewModel.billingAmount = billingAmount ?: 0.0

        val btnFivePercent = findViewById<MaterialButton>(R.id.btn_activitytip_tipfivepercent)
        val btnTenPercent = findViewById<MaterialButton>(R.id.btn_activitytip_tiptenpercent)
        val btnFifteenPercent = findViewById<MaterialButton>(R.id.btn_activitytip_tipfifteenpercent)
        val btnTwentyPercent = findViewById<MaterialButton>(R.id.btn_activitytip_tiptwentypercent)

        val btnNext = findViewById<MaterialButton>(R.id.btn_activitytip_next)

        etTipAmount = findViewById(R.id.et_activitytip_tipamount)
        tvPercentageOfBill = findViewById(R.id.tv_activitytip_percentageofbill)

        btnFivePercent.setOnClickListener { calculateTipAndUpdateUi(5) }
        btnTenPercent.setOnClickListener { calculateTipAndUpdateUi(10) }
        btnFifteenPercent.setOnClickListener { calculateTipAndUpdateUi(15) }
        btnTwentyPercent.setOnClickListener { calculateTipAndUpdateUi(20) }

        etTipAmount.doAfterTextChanged {
            val percentageTip = viewModel.calculateTipPercentage(etTipAmount.text.toString().toDouble())

            tvPercentageOfBill.text = getString(R.string.percent_of_amount_to_pay, (percentageTip * 100).toInt().toString(), billingAmount.toString())
        }


        btnNext.setOnClickListener {
            startActivity(Intent(
                this,
                SumActivity::class.java
            ).apply {
                putExtra(KEY_BILLING_AMOUNT, viewModel.billingAmount)
                putExtra(KEY_TIP_AMOUNT, viewModel.tipAmount)
            })
        }
    }

    private fun calculateTipAndUpdateUi(tipPercentage: Int) {
        val absoluteTip = viewModel.calculateAbsoluteTip(tipPercentage)

        etTipAmount.setText(String.format("%.2f", absoluteTip))
    }

    companion object {
        const val KEY_BILLING_AMOUNT = "Billing_Amount"
        const val KEY_TIP_AMOUNT = "Tip_Amount"
    }
}