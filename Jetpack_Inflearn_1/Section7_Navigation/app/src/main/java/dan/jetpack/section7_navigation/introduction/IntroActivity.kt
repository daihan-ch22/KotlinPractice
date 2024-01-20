package dan.jetpack.section7_navigation.introduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import dan.jetpack.section7_navigation.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)

        val manager = supportFragmentManager

        btn1.setOnClickListener {
//            val transaction1 = manager.beginTransaction()
//            val fragment1 = IntroBlankFragment1()
//            transaction1.replace(R.id.frameArea, fragment1)
//            transaction1.commit()

            val area1: LinearLayout = findViewById(R.id.area1)
            area1.visibility = View.VISIBLE
        }

        btn2.setOnClickListener {
//            val transaction2= manager.beginTransaction()
//            val fragment2 = IntroBlankFragment2()
//            transaction2.replace(R.id.frameArea, fragment2)
//            transaction2.commit()

            val area2: LinearLayout = findViewById(R.id.area2)
            area2.visibility = View.VISIBLE
        }
    }
}