package vcmsa.projects.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    // Declare views
    private lateinit var editTextTogether: EditText
    private lateinit var editTextNumPeople: EditText
    private lateinit var buttonContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        editTextTogether = findViewById(R.id.editTextText6)
        editTextNumPeople = findViewById(R.id.editTextText7)
        buttonContinue = findViewById(R.id.button)

        // Handle button click
        buttonContinue.setOnClickListener {
            val isTogether = editTextTogether.text.toString().equals("Yes", ignoreCase = true)
            val numPeople = if (isTogether) 1 else editTextNumPeople.text.toString().toIntOrNull() ?: 1

            // Send data to MainActivity
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("isTogether", isTogether)
                putExtra("numPeople", numPeople)
            }
            startActivity(intent)
        }
    }
}