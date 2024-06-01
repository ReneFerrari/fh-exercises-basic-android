package at.fhooe.reneferrari.ex_7_simple_notetaking

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val notes: MutableList<String> = mutableListOf()
}