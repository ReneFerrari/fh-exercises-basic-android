package at.fhooe.reneferrari.app_4_relativelayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Can go through all examples by switching layout:
         * R.layout.ex_1
         * R.layout.ex_2
         * R.layout.ex_3
         * R.layout.ex_4
         */
        setContentView(R.layout.ex_4)
    }
}