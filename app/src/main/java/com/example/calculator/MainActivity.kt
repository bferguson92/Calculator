package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var pressed = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.btnOne -> tvBox.append("1")
            R.id.btnTwo -> tvBox.append("2")
            R.id.btnThree -> tvBox.append("3")
            R.id.btnFour -> tvBox.append("4")
            R.id.btnFive -> tvBox.append("5")
            R.id.btnSix -> tvBox.append("6")
            R.id.btnSeven -> tvBox.append("7")
            R.id.btnEight -> tvBox.append("8")
            R.id.btnNine -> tvBox.append("9")
            R.id.btnZero -> tvBox.append("0")
            R.id.btnPlus -> tvBox.append("+")
            R.id.btnMinus -> tvBox.append(" - ")
            R.id.btnDivide -> tvBox.append(" / ")
            R.id.btnMultiple -> tvBox.append(" * ")
            R.id.btnClear -> tvBox.text = ""
            R.id.btnEqual -> computate()
        }
    }

    fun computate(){

    }
}
