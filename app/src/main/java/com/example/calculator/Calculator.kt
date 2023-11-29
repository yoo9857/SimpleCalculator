package com.example.calculator

class Calculator(private val operation: AbstractOperation) {
    fun operate(num1: Int, num2: Int): Double {
        return operation.operate(num1, num2)
    }
    fun main() {
        val addOperation = AddOperation()
        val calculator = Calculator(addOperation)

        print("숫자를 입력하세요: ")
        val num1 = readLine()?.toIntOrNull() ?: return

        print("숫자를 입력하세요: ")
        val num2 = readLine()?.toIntOrNull() ?: return

        val result = calculator.operate(num1, num2)
        println("Result: $result")
    }

}