package com.malkinfo.simplycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge


class MainActivity : AppCompatActivity() {

    private lateinit var currs:String
    private lateinit var result:String
    private lateinit var inputTv: EditText
    private lateinit var outputTv:EditText
    private  var dot_inserted:Boolean = false
    private var operator_inserted:Boolean = false
    private var btnEnble : Boolean = false
   
    /**set Id*/
    private lateinit var btn1: Button
    private lateinit var btn0: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnDivide: Button
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnEqual: Button
    private lateinit var delete: Button
    private lateinit var clear: Button

    /**=====================*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()



    }
    private fun init(){
        /**set find id*/
        inputTv = findViewById(R.id.inputTv)
        outputTv = findViewById(R.id.outputTv)
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnDivide = findViewById(R.id.btnDivide)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnEqual  = findViewById(R.id.btnEqual)
        delete = findViewById(R.id.delete)
        clear  = findViewById(R.id.clear)
        currs = ""
        result = ""
        dot_inserted = false
        operator_inserted = false
        btnEnble = false
       /* btn1.setOnClickListener {
           currs  +="1"
            inputTv.setText(currs)
        }*/
        //numberOperator()
        operatoClick()
        btnClick()
    }
    fun operatoClick(){
        btnEqual.setOnClickListener {
            equalCalculat(it)
        }
        btnDivide.setOnClickListener {
            calculatorOperator(it)
        }
        btnPlus.setOnClickListener {
            calculatorOperator(it)
        }
        btnMinus.setOnClickListener {
            calculatorOperator(it)
        }
        btnMultiply.setOnClickListener { calculatorOperator(it) }
        delete.setOnClickListener { backSpace(it) }
        clear.setOnClickListener { clearAll(it) }

    }

    fun inputShow(){
        inputTv.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                setCalTextChange(s.toString())

            }

        })
        inputTv.setText(currs)
    }

    private fun setCalTextChange(cals: String){
        when(cals.length){
            9 -> {
                btnEnble = false
                inputTv.textSize = 45f
            }
            10 -> {
                btnEnble = true
                inputTv.textSize = 19f
            }
            23 ->{
                btnEnble = true
            }

        }

    }


    fun outputShow(){

        outputTv.setText(result)
    }


    fun numberOperator(curs: String) {

        if (!btnEnble){
            currs += curs
        }

        inputShow()


    }
    private fun btnClick(){
        btn0.setOnClickListener{
            numberOperator("0")
           /* currs += "0"
            inputTv.setText(currs)*/

        }
        btn1.setOnClickListener{
            numberOperator("1")
        }
        btn2.setOnClickListener{
            numberOperator("2")


        }
        btn3.setOnClickListener{
            numberOperator("3")


        }
        btn4.setOnClickListener{
            numberOperator("4")

        }
        btn5.setOnClickListener{
            numberOperator("5")
        }
        btn6.setOnClickListener{
            numberOperator("6")

        }
        btn7.setOnClickListener{
            numberOperator("7")

        }
        btn8.setOnClickListener{
            numberOperator("8")

        }
        btn9.setOnClickListener{
            numberOperator("9")
        }

    }

    fun clearAll(view: View) {
        currs = ""
        result = ""
        dot_inserted = false
        operator_inserted = false
        btnEnble = false
        inputTv.textSize = 45f
        outputTv.textSize = 45f
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
                btnEnble = false
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
            setOutSize()
        }
        outputShow()

    }
    private fun  setOutSize(){
         if ( result.length >= 10){
             outputTv.textSize = 23f
         }
    }


}