package com.example.calculator_aues.views

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator_aues.models.MathOperations

class CalculatorViewModel : ViewModel() {
    private val mathOperations = MathOperations()

    val previousNumber = MutableLiveData<Double>().apply { value = 0.0 }
    val result = MutableLiveData<Double>().apply { value = 0.0 }

    fun calculate(operation: String, currentNumber: Double) {
        val prevNumber = previousNumber.value ?: 0.0
        val operationResult = mathOperations.performOperation(operation, prevNumber, currentNumber)
        result.value = operationResult
        previousNumber.value = operationResult
    }

    fun clearAll() {
        previousNumber.value = 0.0
        result.value = 0.0
    }

    fun addNewPrevElement(currentNumber: Double) {
        previousNumber.value = currentNumber
    }
}