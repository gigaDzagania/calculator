package com.example.calculartor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private  var secOperand: Double = 0.0
    private var operation: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView: View) {

        if (clickedView is TextView){

            val number: String = clickedView.text.toString()
            val resultText: String = resultTextView.text.toString()


            resultTextView.text = resultText + number
        }

    }

    fun operationClick(view: View){

        if (view is TextView){

        var result: String = resultTextView.text.toString()

            if (result.isNotEmpty()){

                this.operand = result.toDouble()
            }

            resultTextView.text = ""

            this.operation = view.text.toString()


        }
    }

    fun equalsClick(view: View){

        val secOperandText: String = resultTextView.text.toString()


        if (secOperandText.isNotEmpty()){

            secOperand = secOperandText.toDouble()
        }

        when (this.operation){

            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "×" -> resultTextView.text = (operand * secOperand).toString()
            "÷" -> resultTextView.text = (operand / secOperand).toString()
            "%" -> resultTextView.text = ((operand / 100) * secOperand).toString()



        }

    }

    fun erase(eraseClick: View){
        resultTextView.text = ""
        this.operand = 0.0
        this.secOperand = 0.0


    }

}