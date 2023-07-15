package com.example.tipcalculator
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        val editTextAmount = findViewById<EditText>(R.id.editTextAmount)
        val button15 = findViewById<Button>(R.id.button15)
        val button18 = findViewById<Button>(R.id.button18)
        val button20 = findViewById<Button>(R.id.button20)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        button15.setOnClickListener {
            calculateTipAndTotal(editTextAmount, textViewResult, 0.15)
        }

        button18.setOnClickListener {
            calculateTipAndTotal(editTextAmount, textViewResult, 0.18)
        }

        button20.setOnClickListener {
            calculateTipAndTotal(editTextAmount, textViewResult, 0.20)
        }

        buttonClear.setOnClickListener {
            val firstName = editTextFirstName.text.toString()
            val lastName = editTextLastName.text.toString()
            editTextFirstName.text.clear()
            editTextLastName.text.clear()
            editTextAmount.text.clear()
            textViewResult.text = getString(R.string.hello_user, firstName, lastName)
        }
    }

    private fun calculateTipAndTotal(editTextAmount: EditText, textViewResult: TextView, percentage: Double) {
        val amount = editTextAmount.text.toString().toDoubleOrNull()
        if (amount != null) {
            val tip = amount * percentage
            val total = amount + tip
            textViewResult.text = getString(R.string.tip_and_total, tip, total)
        } else {
            textViewResult.text = getString(R.string.invalid_amount)
        }
    }
}
