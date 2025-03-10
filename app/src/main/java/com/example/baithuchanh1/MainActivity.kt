package com.example.baithuchanh1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        nameEditText = findViewById(R.id.editTextName)
        ageEditText = findViewById(R.id.editTextAge)
        checkButton = findViewById(R.id.buttonCheck)

        // Set click listener for the check button
        checkButton.setOnClickListener {
            checkAgeCategory()
        }
    }

    private fun checkAgeCategory() {
        val name = nameEditText.text.toString().trim()
        val ageText = ageEditText.text.toString().trim()

        // Validate inputs
        if (name.isEmpty() || ageText.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val age = ageText.toInt()
            val category = when {
                age > 65 -> "Người già (>65)"
                age in 6..65 -> "Người lớn (6-65)"
                age in 2..6 -> "Trẻ em (2-6)"
                age < 2 -> "Em bé (<2)"
                else -> "Không xác định"
            }

            // Display result
            Toast.makeText(
                this,
                "Xin chào $name, bạn thuộc nhóm: $category",
                Toast.LENGTH_LONG
            ).show()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Tuổi không hợp lệ", Toast.LENGTH_SHORT).show()
        }
    }
}