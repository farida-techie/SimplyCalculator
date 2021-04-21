package com.malkinfo.simplycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var currs:String
    private lateinit var result:String
    private lateinit var inputTv: EditText
    private lateinit var outputTv:EditText
    private  var dot_inserted:Boolean = false
    private var operator_inserted:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set find id*/
        inputTv = findViewById(R.id.inputTv)
        outputTv = findViewById(R.id.outputTv)
        currs = ""
        result = ""
        dot_inserted = false
        operator_inserted = false
    }

    fun inputShow(){
        inputTv.setText(currs)
    }
    fun outputShow(){
        outputTv.setText(result)
    }


    fun numberOperator(view: View) {

        var num = view as Button
        when(num.id){
            btn0.id ->{
                currs += "0"

            }
            btn1.id ->{
                currs += "1"

            }
            btn2.id ->{
                currs += "2"

            }
            btn3.id ->{
                currs += "3"

            }
            btn4.id ->{
                currs += "4"

            }
            btn5.id ->{
                currs += "5"

            }
            btn6.id ->{
                currs += "6"

            }
            btn7.id ->{
                currs += "7"

            }
            btn8.id ->{
                currs += "8"

            }
            btn9.id ->{
                currs += "9"

            }

        }
        inputShow()


    }

    fun clearAll(view: View) {
        currs = ""
        result = ""
        dot_inserted = false
        operator_inserted = false
        inputShow()
        outputShow()

    }

    fun backSpace(view: View) {
        if (currs.isNotEmpty()){
            if (currs.substring(
                            currs.length-1,
                    currs.length).equals(".")){
                dot_inserted = false
            }

            if (currs.substring(
                            currs.length-1,
                            currs.length
                    ).equals(" ")){
                currs = currs.substring(0,currs.length-3)
                operator_inserted = false
            }
            else{
                currs = currs.substring(0,currs.length-1)
            }
        }
        inputShow()
    }

    fun calculatorOperator(view: View) {
        var calculatBtn = view as Button
        dot_inserted = false
        if (currs.isNotEmpty()){
            //check if the last digit is dot =>
            if (currs.substring(
                            currs.length-1,currs.length
            ).equals(".")){
                backSpace(view)
            }
            if (!operator_inserted){

                when(calculatBtn.id){
                    btnPlus.id ->{
                        currs += " + "
                    }
                    btnMinus.id ->{
                        currs += " - "
                    }
                    btnMultiply.id ->{
                        currs += " * "
                    }
                    btnDivide.id ->{
                        currs += " / "
                    }
                }
                operator_inserted = true
            }
        }
        inputShow()
    }

    fun dotOperator(view: View) {
        if (currs.isEmpty()){
            currs = "0."
            dot_inserted = true
        }
        if (!dot_inserted){
            currs += "."
            dot_inserted =  true
        }
        inputShow()
    }

    fun equalCalculat(view: View) {

        if (operator_inserted && !currs.substring(
                        currs.length-1,currs.length
                ).equals(" ")){
            val tokens = currs.split(" ")
            val firstNumber = java.lang.Double.parseDouble(tokens[0])
            val secondNumber = java.lang.Double.parseDouble(tokens[2])
            when(tokens[1].get(0)){
                '+'-> result = (firstNumber + secondNumber).toString()
                '-'-> result = (firstNumber - secondNumber).toString()
                '*'-> result = (firstNumber * secondNumber).toString()
                '/'-> result = (firstNumber / secondNumber).toString()
            }
        }
        outputShow()

    }


}