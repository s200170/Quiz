package jp.ac.it_college.s20017.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import jp.ac.it_college.s20017.quiz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val start = findViewById<Button>(R.id.nextbutton)

        start.setOnClickListener{
            Intent(this, MainActivity2::class.java).also {
                startActivity(it)
            }
        }
    }
}