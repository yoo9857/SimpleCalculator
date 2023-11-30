package com.example.calculator

class cct {

    fun main(){
    var number1 = 4
    var operator = "*"
    var number2 = 3

    fun main(number1: Int, operator: String, number2: Int):Double {
        var answer = 0

        when(operator) {
            in "+" -> answer = number1 + number2
            in "-" -> answer = number1 - number2
            in "/" -> answer = number1 / number2
            in "*" -> answer = number1 * number2
        }
        return answer.toDouble()
    }
        }
}
//