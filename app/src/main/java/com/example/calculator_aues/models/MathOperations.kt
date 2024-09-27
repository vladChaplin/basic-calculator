package com.example.calculator_aues.models

class MathOperations {
    fun performOperation(operation: String, num1: Double, num2: Double) : Double {
        return when(operation) {
            "*" -> num1 * num2
            "/" -> if(num1 != 0.0) num1 / num2 else Double.NaN
            "+" -> num1 + num2
            "-" -> num1 + num2
            "%" -> num1 % num2
            "^" -> Math.pow(num1, num2)
            else -> throw IllegalArgumentException("Неизвестная операция!")
        }
    }
}