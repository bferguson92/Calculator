package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var isDot = false
    var isOp = true
    var numPerent = 0
    val error = "ERROR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.btnOne -> appendNum("1")
            R.id.btnTwo -> appendNum("2")
            R.id.btnThree -> appendNum("3")
            R.id.btnFour -> appendNum("4")
            R.id.btnFive -> appendNum("5")
            R.id.btnSix -> appendNum("6")
            R.id.btnSeven -> appendNum("7")
            R.id.btnEight -> appendNum("8")
            R.id.btnNine -> appendNum("9")
            R.id.btnZero -> appendNum("0")
            R.id.btnPlus -> appendOp("+")
            R.id.btnMinus -> appendOp("-")
            R.id.btnMultiple -> appendOp("*")
            R.id.btnDivide -> appendOp("/")
            R.id.btnLeftPerent -> tvBox.append("(")
            R.id.btnRightPerent -> tvBox.append(")")
            R.id.btnSin -> tvBox.append("sin(")
            R.id.btnCos -> tvBox.append("cos(")
            R.id.btnTan -> tvBox.append("tan(")

            R.id.btnDot -> {
                if(!isDot){
                    tvBox.append(".")
                    isDot = true
                    isOp = false
                }
            }

            R.id.btnClear -> tvBox.text = ""
            R.id.btnEqual -> compute()
        }
    }

    fun appendNum(num: String){
        tvBox.append(num)
        isOp = false
    }

    fun appendOp(op: String){
        if(!isOp) {
            tvBox.append(op)
            isDot = false
            isOp = true
        }

    }

    fun compute(){

        val numTxt =  tvBox.text.toString()
        val expression = ExpressionBuilder(numTxt).build()

        try {
            val answer = expression.evaluate()
            tvBox.text = answer.toString()
        } catch (ex: ArithmeticException) {
            tvBox.text = error
        }
    }


}
