package com.example.calculator_aues

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.example.calculator_aues.R.layout.activity_main
import com.example.calculator_aues.models.MathOperations
import com.example.calculator_aues.ui.theme.Calculator_auesTheme
import com.example.calculator_aues.views.CalculatorViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_main)

        val previousNumberView: TextView = findViewById(R.id.previous_number)
        val numberInput: EditText = findViewById(R.id.number_input)
        val resultView: TextView = findViewById(R.id.result_view)

        viewModel.previousNumber.observe(this, Observer {value ->
            previousNumberView.text = "Первое число: $value"
        })

        viewModel.result.observe(this, Observer {value ->
            resultView.text = "Результат: $value"
        })

        findViewById<Button>(R.id.button_multiply).setOnClickListener { onOperation("*", numberInput)}
        findViewById<Button>(R.id.button_divide).setOnClickListener { onOperation("/", numberInput)}
        findViewById<Button>(R.id.button_add).setOnClickListener { onOperation("+", numberInput)}
        findViewById<Button>(R.id.button_subtract).setOnClickListener { onOperation("-", numberInput)}
        findViewById<Button>(R.id.button_modulo).setOnClickListener { onOperation("%", numberInput)}
        findViewById<Button>(R.id.button_power).setOnClickListener { onOperation("^", numberInput)}
        findViewById<Button>(R.id.button_clear).setOnClickListener { viewModel.clearAll() }
    }

    private fun onOperation(operation: String, numberInput: EditText) {
        val currentNumber = numberInput.text.toString().toDouble()

        if(currentNumber == null) return

        viewModel.calculate(operation, currentNumber);
        numberInput.text.clear()
    }


}

