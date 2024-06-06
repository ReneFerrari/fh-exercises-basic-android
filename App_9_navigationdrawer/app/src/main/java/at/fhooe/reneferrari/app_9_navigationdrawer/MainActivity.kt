package at.fhooe.reneferrari.app_9_navigationdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigation)

        toolbar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.inbox_item -> showInboxFragment()
                R.id.outbox_item -> showOutboxFragment()
                else -> Unit
            }
            drawerLayout.close()
            true
        }
    }

    fun showInboxFragment() = supportFragmentManager.commit {
        setReorderingAllowed(true)
        replace<InboxFragment>(R.id.fcv_activitymain, InboxFragment.TAG)
        addToBackStack(InboxFragment.TAG)
    }

    fun showOutboxFragment() = supportFragmentManager.commit {
        setReorderingAllowed(true)
        replace<OutboxFragment>(R.id.fcv_activitymain, OutboxFragment.TAG)
        addToBackStack(OutboxFragment.TAG)
    }
}