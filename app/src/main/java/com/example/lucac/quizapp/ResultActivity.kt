package com.example.lucac.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //full screen
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        //username
        val userame= intent.getStringExtra(Constans.EXTRA_PLAYER)
        usernameTV.text = userame
        // domande corrette e sbagliate
        val totalQuestions= intent.getIntExtra(Constans.EXTRA_QUESTION, 0)
        val CorrectAnswere = intent.getIntExtra(Constans.EXTRA_CORRECT, 0)
        //Punteggio
        pointTV.text= "Il tuo punteggio è stato ${CorrectAnswere} su ${totalQuestions}!"
        //CompleteBtn
        if (CorrectAnswere == totalQuestions ){
            Toast.makeText(this, "Tutte le risposte erano corrette!", Toast.LENGTH_SHORT).show()
            completebtn.text = "COMPLETATO!"
        }else{
            Toast.makeText(this, "Né hai sbagliata qualcuna, riprova!", Toast.LENGTH_SHORT).show()
            completebtn.text = "RIPROVA!"
        }
        completebtn.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}