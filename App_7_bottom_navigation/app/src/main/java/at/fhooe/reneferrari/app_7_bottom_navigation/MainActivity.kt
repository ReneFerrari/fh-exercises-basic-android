package at.fhooe.reneferrari.app_7_bottom_navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bnv_activitymain)

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_bookmark -> showFragmentBookmark()
                R.id.item_profile -> showFragmentProfile()
                else -> Unit //won't happen
            }

            true
        }

        if (savedInstanceState == null) {
            bottomNavigation.selectedItemId = R.id.item_bookmark
        }
    }

    private fun showFragmentBookmark() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FragmentBookmark>(R.id.fcv_activitymain, FragmentBookmark.TAG)
            addToBackStack(FragmentBookmark.TAG)
        }
    }

    private fun showFragmentProfile() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FragmentProfile>(R.id.fcv_activitymain, FragmentProfile.TAG)
            addToBackStack(FragmentProfile.TAG)
        }
    }
}