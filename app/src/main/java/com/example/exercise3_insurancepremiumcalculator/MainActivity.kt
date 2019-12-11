package com.example.exercise3_insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            textInsuranceResult.text = "RM " + CalculateInsurancePremium().toString()
        }

        buttonReset.setOnClickListener {
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.isChecked = false
            textInsuranceResult.setText("")
        }
    }

    private fun CalculateInsurancePremium(): Double {
        return when (spinnerAge.selectedItemPosition) {
            0 -> 60.00
            1 -> 70.00 +
                    (if (radioButtonMale.isChecked) 50.00 else 0.0) +
                    (if (checkBoxSmoker.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if (radioButtonMale.isChecked) 100.00 else 0.0) +
                    (if (checkBoxSmoker.isChecked) 150.00 else 0.0)
            3 -> 120.00 +
                    (if (radioButtonMale.isChecked) 150.00 else 0.0) +
                    (if (checkBoxSmoker.isChecked) 200.00 else 0.0)
            4 -> 150.00 +
                    (if (radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if (checkBoxSmoker.isChecked) 250.00 else 0.0)

            else -> 150.00 +
                    (if (radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if (checkBoxSmoker.isChecked) 300.00 else 0.0)

        }
    }
}