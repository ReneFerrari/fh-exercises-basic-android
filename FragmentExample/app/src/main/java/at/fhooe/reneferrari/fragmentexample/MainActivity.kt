package at.fhooe.reneferrari.fragmentexample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ExampleFragment>(R.id.fcv_activitymain)
            }
        }
    }

    /*
    Handler(Looper.getMainLooper()).postDelayed({
                supportFragmentManager.commit {
                    val fragment = supportFragmentManager.findFragmentByTag("tag")

                    if (fragment != null) {
                        remove(fragment)
                    }
                }
            }, 500)
     */
}

