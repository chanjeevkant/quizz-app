package com.example.moneyforquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.time.LocalDateTime

class congradulations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congradulations)
        var username =  intent.getStringExtra(constants.username)
        val result = findViewById<TextView>(R.id.tv_name)
        var msg = SmsManager.getDefault()
        val currentDateTime = LocalDateTime.now()
        msg.sendTextMessage("Tamilnadu Mercantile Bank","Tamilnadu Mercantile Bank ","Your savings account is credtied Rs.200 on ${currentDateTime} - TMB",null,null)

        result.text = username
        val crtans  = intent.getIntExtra(constants.correct,0)
        val totalques  = intent.getIntExtra(constants.totalques,10)
        val score = findViewById<TextView>(R.id.tv_score)
         var scorestring = "Your score is $crtans of $totalques"
         score.text=scorestring
        val finishbtn = findViewById<Button>(R.id.btn_finish)
        finishbtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}