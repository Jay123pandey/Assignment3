package com.jay.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstBtn: Button = findViewById(R.id.btnFirst)
        val secondBtn: Button = findViewById(R.id.btnSecond)
        val resultTxtView: TextView = findViewById(R.id.tvResult)
        val correctTxtView : TextView = findViewById(R.id.tvCorrect)
        val incorrectTxtView : TextView = findViewById(R.id.tvIncorrect)
        val restartBtn: Button = findViewById(R.id.btnRestart)

        randomNumberGen(firstBtn,secondBtn)
        var count: Int = 0
        var correctAns = 0
        var incorrectAns = 0

        firstBtn.setOnClickListener{
            count++
            val userClick = firstBtn.text.toString().toInt()
            val btnFirstVal = firstBtn.text.toString().toInt()
            val btnSecondVal = secondBtn.text.toString().toInt()
            if (btnFirstVal>btnSecondVal && btnFirstVal == userClick){
                correctAns++


            }
            else{
                incorrectAns++
            }
            randomNumberGen(firstBtn, secondBtn)
            autoDisable(count, firstBtn,secondBtn, correctAns,incorrectAns,correctTxtView,incorrectTxtView,resultTxtView,restartBtn)
        }

        secondBtn.setOnClickListener{
            count++
            val userClick = secondBtn.text.toString().toInt()
            val btnFirstVal = firstBtn.text.toString().toInt()
            val btnSecondVal = secondBtn.text.toString().toInt()
            if (btnSecondVal>btnFirstVal && btnSecondVal == userClick){
                correctAns++

            }
            else{
                incorrectAns++
            }
            randomNumberGen(firstBtn, secondBtn)
            autoDisable(count, firstBtn,secondBtn, correctAns,incorrectAns,correctTxtView,incorrectTxtView,resultTxtView,restartBtn)
        }

        restartBtn.setOnClickListener{
            count = 0
            secondBtn.isClickable = true
            secondBtn.isClickable=true
            restartBtn.isVisible = false
            resultTxtView.visibility= View.INVISIBLE
            correctTxtView.visibility = View.INVISIBLE
            incorrectTxtView.visibility = View.INVISIBLE
            correctTxtView.visibility = View.INVISIBLE
            correctAns = 0
            incorrectAns = 0

            randomNumberGen(firstBtn, secondBtn)
        }
    }

    private fun randomNumberGen(btnFirst: Button, btnSecond:Button){
        btnFirst.text = (0..100).shuffled().random().toString()
        btnSecond.text = (0..100).shuffled().random().toString()
    }
    private fun autoDisable(count : Int, btnFirst: Button, btnSecond: Button, correctAns:Int, incorrectAns:Int,tvCorrect:TextView,tvIncorrect:TextView, tvResult:TextView, btnRestart:Button){
        if (count == 10){
            btnFirst.isClickable = false
            btnFirst.text=""
            btnSecond.isClickable = false
            btnSecond.text =""
            if (correctAns<incorrectAns) tvResult.text = "Sorry, you lost"
            else tvResult.text = "Congrats, you won"
            tvCorrect.text = "Your score is : $correctAns "
            tvIncorrect.text = "You have made $incorrectAns mistakes"
            tvCorrect.visibility = View.VISIBLE
            tvIncorrect.visibility = View.VISIBLE
            tvResult.visibility = View.VISIBLE
            btnRestart.visibility = View.VISIBLE
        }
    }


}