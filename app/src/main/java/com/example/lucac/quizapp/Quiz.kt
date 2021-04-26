package com.example.lucac.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz.*

class Quiz : AppCompatActivity(), View.OnClickListener {
    private var CurrentPosition: Int = 1
    private var questionList: ArrayList<Questions>?= null
    private var mSelectedPosition: Int=0
    private var Correct: Int = 0
    private var USER_NAME: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        USER_NAME = intent.getStringExtra(Constans.EXTRA_PLAYER)
         questionList= Constans.getQuestion()
        //we have an array list and now set di id to -1 becouse we had an arraylist
        setQuestion()
        question1.setOnClickListener(this)
        question2.setOnClickListener(this)
        question3.setOnClickListener(this)
        question4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
        //backBtn
        backImage.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun setQuestion(){

        val quesion= questionList!![CurrentPosition -1]
        DefaultOptionView()

        if (CurrentPosition == questionList!!.size){
            btn_submit.text= "COMPLETATO"
        }else{
            btn_submit.text= "INVIA"
        }
        ProgressBar.progress= CurrentPosition
        tv_progress.text = "$CurrentPosition"+"/" + questionList!!.size
        //domanda
        questionid.text= quesion!!.question
        //imagine
        questionimage.setImageResource(quesion.image)
        //1
        question1.text= quesion.question1
        //2
        question2.text=quesion.question2
        //3
        question3.text=quesion.question3
        //4
        question4.text=quesion.question4
    }
    private fun DefaultOptionView(){
        val options= ArrayList<TextView>()
        options.add(0, question1)
        options.add(1, question2)
        options.add(2, question3)
        options.add(3, question4)
        for(options in options){
            options.setTextColor(Color.parseColor("#7A8089"))
            options.typeface = Typeface.DEFAULT
            options.background= ContextCompat.getDrawable(this, R.drawable.defaoult_option_border)
        }
    }
/*
qui la funzione on click che con la condizioe di when permette
che quado le textView vengono cliccate si avvia la funzione "reset"
 */
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.question1 -> {
                reset(question1, 1)
            }
            R.id.question2 -> {
                reset(question2, 2)
            }
            R.id.question3 -> {
                reset(question3, 3)
            }
            R.id.question4 -> {
                reset(question4, 4)
            }
            //submit btn
            R.id.btn_submit -> {
                if (mSelectedPosition == 0){
                    CurrentPosition++
                when {
                    CurrentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        Toast.makeText(this, "Quiz completato!", Toast.LENGTH_SHORT).show()
                    }
                }
                }else{
                    val question = questionList?.get(CurrentPosition - 1)
                    if (question!!.correctanswer != mSelectedPosition) {
                        aswerView(mSelectedPosition, R.drawable.wrong_option_border)
                        Toast.makeText(this, "Risposta sbagliata", Toast.LENGTH_SHORT).show()
                    }else{
                        Correct++
                        Toast.makeText(this, "Risposta esatta!", Toast.LENGTH_SHORT).show()
                    }
                    aswerView(question.correctanswer, R.drawable.correct_option_border)
                    if (CurrentPosition == questionList!!.size) {
                        btn_submit.text = "COMPLETATO"
                        btn_submit.setOnClickListener {
                        val intent= Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constans.EXTRA_PLAYER, USER_NAME)
                            intent.putExtra(Constans.EXTRA_CORRECT, Correct)
                            intent.putExtra(Constans.EXTRA_QUESTION, questionList!!.size)
                        startActivity(intent)
                        finish()}

                    } else {
                        btn_submit.text = "PROSSIMA DOMANDA"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }
    private fun aswerView(aswer: Int,drawableView: Int ){
        when(aswer){
            1 -> {question1.background = ContextCompat.getDrawable(this, drawableView)}
            2 -> {question2.background = ContextCompat.getDrawable(this, drawableView)}
            3 -> {question3.background = ContextCompat.getDrawable(this, drawableView)}
            4 -> {question4.background = ContextCompat.getDrawable(this, drawableView)}
        }
    }
    /*
    questa funzione permette di cambiare il tipo di testo,
    colore e aggiungere il bordo custom, inoltre
    DefaultOptionView() serve per resettare il  bottone
     */
    private fun reset(tv: TextView, output: Int){
        DefaultOptionView()
        mSelectedPosition= output
            tv.setTextColor(Color.parseColor("#363A43"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background= ContextCompat.getDrawable(this, R.drawable.click_option_border)
    }
}