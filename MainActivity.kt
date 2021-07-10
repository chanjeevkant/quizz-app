package com.example.moneyforquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.startbtn)
        var namefield  = findViewById<EditText>(R.id.namefield)
        btn.setOnClickListener {
            if ((namefield.text).toString().isEmpty()){
                Toast.makeText(this,"Enter your name ",Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(this,quizquestions::class.java)
                intent.putExtra(constants.username,namefield.text.toString())
                startActivity(intent)
                finish()
            }
        }


    }
}