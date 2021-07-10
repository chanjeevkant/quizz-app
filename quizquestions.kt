
package com.example.moneyforquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class quizquestions : AppCompatActivity(),View.OnClickListener {
    val Questionlist = constants.getques()
    var index = 1
    val question : ArrayList<questions> = Questionlist
    var selectedoption = 0
    var whetheroptionclicked: Boolean = false
    var msg = SmsManager.getDefault()
    var crtans = 0
    var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestions)

        setques()
        val opt1 = findViewById(R.id.option1) as TextView
        val opt2 = findViewById(R.id.option2) as TextView
        val opt3 = findViewById(R.id.option3) as TextView
        val opt4 = findViewById(R.id.option4) as TextView
        val submit = findViewById<Button>(R.id.submitbtn)

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        submit.setOnClickListener(this)

        username = intent.getStringExtra(constants.username)
    }


    private fun setques(){
        val opt1 = findViewById(R.id.option1) as TextView
        val opt2 = findViewById(R.id.option2) as TextView
        val opt3 = findViewById(R.id.option3) as TextView
        val opt4 = findViewById(R.id.option4) as TextView
        val submit = findViewById(R.id.submitbtn) as Button

        val question = question[index-1]
        defaultoption()
        if(index==Questionlist.size){
           submit.text="FINISH"
        }else{
            submit.text="SUBMIT"
        }
        val progbar = findViewById<ProgressBar>(R.id.progressbar)
        progbar.progress= index
        val progtv = findViewById<TextView>(R.id.protv)
        progtv.text="$index"+"/"+progbar.max
        val questiondisp = findViewById<TextView>(R.id.questiontv)
        questiondisp.text= question!!.question
        val image = findViewById<ImageView>(R.id.imageview)
        image.setImageResource(question.image)

        opt1.text=question.optionOne
        opt2.text=question.optionTwo
        opt3.text=question.optionThree
        opt4.text=question.optionFour


    }
   private fun defaultoption(){
       val opt1 = findViewById(R.id.option1) as TextView
       val opt2 = findViewById(R.id.option2) as TextView
       val opt3 = findViewById(R.id.option3) as TextView
       val opt4 = findViewById(R.id.option4) as TextView

       val options = ArrayList<TextView>()
       options.add(0,opt1)
       options.add(0,opt2)
       options.add(0,opt3)
       options.add(0,opt4)

       for (option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
           option.typeface = Typeface.DEFAULT
           option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
       }
   }

    override fun onClick(v: View?) {
        defaultoption()

        val opt1 = findViewById(R.id.option1) as TextView
        val opt2 = findViewById(R.id.option2) as TextView
        val opt3 = findViewById(R.id.option3) as TextView
        val opt4 = findViewById(R.id.option4) as TextView
        val submit = findViewById(R.id.submitbtn) as Button

    when(v?.id){
        R.id.option1 ->{
            selectedoption(opt1,1)
            whetheroptionclicked = true
        }
        R.id.option2 ->{
            selectedoption(opt2,2)
            whetheroptionclicked = true
        }
        R.id.option3 ->{
            selectedoption(opt3,3)
            whetheroptionclicked = true
        }
        R.id.option4 ->{
            selectedoption(opt4,4)
            whetheroptionclicked = true
        }
        R.id.submitbtn->{
            if(whetheroptionclicked){
                if(selectedoption==0){
                index++
                when{
                    index <=question.size->{
                        setques()
                    }else->{
                    val intent = Intent(this,congradulations::class.java)
                    //var msg = SmsManager.getDefault()
                    msg.sendTextMessage("9384359431","","Your savings account is credtied Rs.200 from the moneyforquiz",null,null)

                    intent.putExtra(constants.username,username)
                    intent.putExtra(constants.correct,crtans)
                    intent.putExtra(constants.totalques,Questionlist.size)
                    startActivity(intent)
                    finish()
                }
                }
            }

            else{
                val question = Questionlist[index-1]
                if(question.crctAns != selectedoption){
                    answercheck(selectedoption,R.drawable.wrong_option_border_bg)
                }else{
                    crtans++
                }
                answercheck(question.crctAns,R.drawable.correct_option_border_bg)
                if(index==Questionlist.size){
                    submit.text="FINISH"
                }else{
                    submit.text="GO TO THE NEXT QUESTION"
                }
                selectedoption=0
            }}else{
                Toast.makeText(this,"Please choose a option",Toast.LENGTH_LONG).show()
            }



        }

    }
    }


    private fun selectedoption(tv:TextView, optnum:Int){
        selectedoption = optnum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    private fun answercheck(answer:Int , drawableView:Int){
        val opt1 = findViewById(R.id.option1) as TextView
        val opt2 = findViewById(R.id.option2) as TextView
        val opt3 = findViewById(R.id.option3) as TextView
        val opt4 = findViewById(R.id.option4) as TextView
        when(answer){

            1->{
                opt1.background =ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                opt2.background =ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                opt3.background =ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                opt4.background =ContextCompat.getDrawable(this,drawableView)
            }
        }


    }

}