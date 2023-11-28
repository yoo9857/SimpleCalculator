package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var lastNumeric = false
    var stateError = false
    var lastDot = false

    private  lateinit var expression: Expression
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
// 먼저 build.grader에서 변경하기
    fun onAllclearClick(view: View) {
        binding.dateTv.text = ""
            binding.resultTv.text = ""
        stateError = false
          lastDot = false
           lastNumeric = false
    binding.dateTv.visibility = View.GONE
    }
    fun onEqualClick(view: View) {
        binding.dateTv.text = binding.resultTv.text.toString().drop(1)
    }
    fun onDigitClick(view: View) {
        if(stateError){
            binding.dateTv.text = ( view as Button).text
            stateError = false}
        else{
            binding.dateTv.append((view as Button).text)
        }
        lastNumeric = true
        onEqual()

    }
    fun onOperatorClick(view: View) {
        if(!stateError&&lastNumeric){

            binding.dateTv.append((view as Button).text)
            lastDot = false
            lastNumeric = false
            onEqual()
        }

    }
    fun onBackClick(view: View) {

        binding.dateTv.text = binding.dateTv.text.toString().dropLast(1)
                try{
                    val lastChar = binding.dateTv.text.toString().last()

                    if(lastChar.isDigit()){
                        onEqual()
                    }
                }catch (e : Exception){
                    binding.resultTv.text = ""
                    binding.resultTv.visibility = View.GONE
                    Log.e("last char error",e.toString())
                }
    }


    fun onClearClick(view: View) {
        binding.dateTv.text = ""
        lastNumeric = false

    }

    fun onEqual(){
        if(lastNumeric && !stateError){
            var txt = binding.dateTv.text.toString()

            expression = ExpressionBuilder(txt).build()
            try{
                val result = expression.evaluate()

                binding.resultTv.visibility = View.VISIBLE

                binding.resultTv.text = "=" +result.toString()
            }catch(ex: ArithmeticException){
                Log.e("evaluate error", ex.toString())
                binding.resultTv.text = "Erorr"
                stateError = true
                lastNumeric = false
            }
        }


    }
}