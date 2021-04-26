package com.example.lucac.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Full screenn
         */
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        //button start with toast and new category if the text si filled
        StartBtn.setOnClickListener {
            if (UserName.text.toString().isEmpty()) {
                Toast.makeText(this, "Scrivi il tuo Username", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this, Quiz::class.java)
                intent.putExtra(Constans.EXTRA_PLAYER, UserName.text.toString())
                startActivity(intent)
                finish()

            }
        }
    }
}