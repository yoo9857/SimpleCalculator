package com.example.calculator


class AddOperation : AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Double = (num1 + num2).toDouble()
}

class SubtractOperation : AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Double = (num1 - num2).toDouble()
}

class MultiplyOperation : AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Double = (num1 * num2).toDouble()
}


