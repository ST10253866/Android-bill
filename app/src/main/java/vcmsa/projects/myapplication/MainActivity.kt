package vcmsa.projects.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var editTextBill: EditText
    private lateinit var editTextTip: EditText
    private lateinit var textViewResult: TextView
    private lateinit var buttonCalculate: Button
    private var numPeople: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextBill = findViewById(R.id.editTextText)
        editTextTip = findViewById(R.id.editTextText2)
        textViewResult = findViewById(R.id.textView)
        buttonCalculate = findViewById(R.id.button)


        val isTogether = intent.getBooleanExtra("isTogether", true)
        numPeople = intent.getIntExtra("numPeople", 1)


        // Show info in TextView
        textViewResult.text = "Number of people: $numPeople"

        // Handle button click
        buttonCalculate.setOnClickListener {
            calculateTip(isTogether)
        }
    }

    private fun calculateTip(isTogether: Boolean) {
        val billAmountStr = editTextBill.text.toString()
        val tipPercentStr = editTextTip.text.toString()

        // Check if both fields are not empty
        if (billAmountStr.isNotEmpty() && tipPercentStr.isNotEmpty()) {
            try {
                val billAmount = billAmountStr.toDouble()
                val tipPercent = tipPercentStr.toDouble()

                // Calculate the tip
                val tipAmount = (billAmount * tipPercent) / 100
                val totalAmount = billAmount + tipAmount
                val tipPerPerson = tipAmount / numPeople
                val totalPerPerson = totalAmount / numPeople


                textViewResult.text = "Tip: R${"%.2f".format(tipAmount)}\nTotal: R${"%.2f".format(totalAmount)}\n" +
                        "Tip per person: R${"%.2f".format(tipPerPerson)}\n" +
                        "Total per person: R${"%.2f".format(totalPerPerson)}"

            } catch (e: NumberFormatException) {
                textViewResult.text = "Invalid input. Please enter valid numbers."
            }
        } else {
            textViewResult.text = "Please fill out both fields."
        }
    }
}