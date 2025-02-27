package vcmsa.projects.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declare views
    private lateinit var editTextBill: EditText
    private lateinit var editTextTip: EditText
    private lateinit var textViewResult: TextView
    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views using findViewById
        editTextBill = findViewById(R.id.editTextText)
        editTextTip = findViewById(R.id.editTextText2)
        textViewResult = findViewById(R.id.textView)
        buttonCalculate = findViewById(R.id.button)


        buttonCalculate.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {

        val billAmountStr = editTextBill.text.toString()
        val tipPercentStr = editTextTip.text.toString()

        // Check if both fields are not empty
        if (billAmountStr.isNotEmpty() && tipPercentStr.isNotEmpty()) {
            try {
                val billAmount = billAmountStr.toDouble() // Convert bill amount to Double
                val tipPercent = tipPercentStr.toDouble() // Convert tip percentage to Double

                // Calculate the tip
                val tipAmount = (billAmount * tipPercent) / 100
                val totalAmount = billAmount + tipAmount

                
                textViewResult.text = "Tip: R${"%.2f".format(tipAmount)}\nTotal: R${"%.2f".format(totalAmount)}"
            } catch (e: NumberFormatException) {
                textViewResult.text = "Invalid input. Please enter valid numbers."
            }
        } else {
            textViewResult.text = "Please fill out both fields."
        }
    }
}