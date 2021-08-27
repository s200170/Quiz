package jp.ac.it_college.s20017.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity2 : AppCompatActivity() {
    val dataQuiz = mutableListOf<List<String>>()
    var questionNumber = 0
    var userscore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val csv = "s20016.csv"
        val data = BufferedReader(InputStreamReader(assets.open(csv)))
        var line: String?

        while (data.readLine().also { line = it } != null){
            val row: MutableList<String> = line!!.split(",") as MutableList<String>
            dataQuiz.add(row)
        }
        dataQuiz.removeAt(0)

//        Log.d("TAG", dataQuiz.toString())
        gameStart()
    }

    private fun score(choice: Int) {
        val finalScore = "You're score is ${userscore.toString()}"
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("SCORE", finalScore)
        startActivity(intent)
    }

    private fun checkAnswer(userChoice: Int) {
        if (userChoice == 2) {
            ++userscore
        }
    }

    private fun gameStart() {
        val quiztext = findViewById<TextView>(R.id.quiztext)
        val quizbutton1 = findViewById<TextView>(R.id.quizbutton1)
        val quizbutton2 = findViewById<TextView>(R.id.quizbutton2)
        val quizbutton3 = findViewById<TextView>(R.id.quizbutton3)
        val quizbutton4 = findViewById<TextView>(R.id.quizbutton4)

        val random = mutableListOf<Int>(2, 3, 4, 5)
        random.shuffle()

        val random1 = random[0]
        val random2 = random[1]
        val random3 = random[2]
        val random4 = random[3]

//        Log.d("TAG", random.toString())

        quiztext.text = dataQuiz[questionNumber][0]
        quizbutton1.text = dataQuiz[questionNumber][random1]
        quizbutton2.text = dataQuiz[questionNumber][random2]
        quizbutton3.text = dataQuiz[questionNumber][random3]
        quizbutton4.text = dataQuiz[questionNumber][random4]


        questionNumber++

        quizbutton1.setOnClickListener{
            if (questionNumber >= 10) {
                checkAnswer(random1)
                score(1)
            } else {
                checkAnswer(random1)
                gameStart()
            }
        }
        quizbutton2.setOnClickListener{
            if (questionNumber >= 10) {
                checkAnswer(random2)
                score(2)
            } else {
                checkAnswer(random2)
                gameStart()
            }
        }
        quizbutton3.setOnClickListener{
            if (questionNumber >= 10) {
                checkAnswer(random3)
                score(3)
            } else {
                checkAnswer(random3)
                gameStart()
            }
        }
        quizbutton4.setOnClickListener{
            if (questionNumber >= 10) {
                checkAnswer(random4)
                score(4)
            } else {
                checkAnswer(random4)
                gameStart()
            }
        }
    }


}