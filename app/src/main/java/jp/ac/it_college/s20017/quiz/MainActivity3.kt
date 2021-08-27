package jp.ac.it_college.s20017.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val scoretext = findViewById<TextView>(R.id.scoretext)

        val score = intent.getStringExtra("SCORE")
        val restart = findViewById<Button>(R.id.restart)
        val home = findViewById<Button>(R.id.homebutton)

        scoretext.text = score



        restart.setOnClickListener{
            Intent(this, MainActivity2::class.java).also{
                startActivity(it)
            }
        }
        home.setOnClickListener{
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}