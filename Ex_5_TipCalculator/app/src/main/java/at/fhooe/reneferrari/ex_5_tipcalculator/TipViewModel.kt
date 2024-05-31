package at.fhooe.reneferrari.ex_5_tipcalculator

import androidx.lifecycle.ViewModel

class TipViewModel: ViewModel() {
    var billingAmount: Double = 0.0
    var tipAmount: Double = 0.0

    fun calculateAbsoluteTip(tipPercentage: Int): Double {
        val tip = billingAmount * (tipPercentage / 100f)
        tipAmount = tip

        return tip
    }

    fun calculateTipPercentage(tipAmount: Double): Double {
        this.tipAmount = tipAmount

        return tipAmount / billingAmount
    }
}