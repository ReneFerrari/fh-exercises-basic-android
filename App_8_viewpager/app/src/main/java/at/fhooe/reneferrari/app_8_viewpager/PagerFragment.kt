package at.fhooe.reneferrari.app_8_viewpager

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class PagerFragment: Fragment(R.layout.fragment_pager) {

    private lateinit var tvTitle: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvTitle = view.findViewById(R.id.tv_fragmentpager)
        tvTitle.text = "FRAGMENT ${arguments?.getInt("POSITION") ?: 0}"

    }
}