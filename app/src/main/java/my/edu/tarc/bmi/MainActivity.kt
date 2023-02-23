package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Link UI to code
        //var vs val
        val textViewBMI:TextView=findViewById(R.id.textViewBMI)
        val textViewStatus:TextView = findViewById(R.id.textViewStatus)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)

        buttonCalculate.setOnClickListener{
            if(editTextWeight.text.isEmpty()){
                editTextWeight.setError (getString(R.string.value_required))
                return@setOnClickListener
            }

            if(editTextHeight.text.isEmpty()){
                editTextHeight.setError (getString(R.string.value_required))
                return@setOnClickListener
            }

            var weight = editTextWeight.text.toString().toFloat()
            var height = editTextHeight.text.toString().toFloat()
            var bmi = weight / (height/100).pow(2)

            if (bmi < 18.5){ //Underweight
                imageViewBMI.setImageResource(R.drawable.under)
                textViewBMI.text = String.format("%s:%.2f",getString(R.string.bmi),bmi)
                textViewStatus.text = String.format(getString(R.string.under))
            }

            else if (bmi > 18.5 && bmi < 24.9 ){ //normal
                imageViewBMI.setImageResource(R.drawable.normal)
                textViewBMI.text = String.format("%s:%.2f",getString(R.string.bmi),bmi)
                textViewStatus.text = String.format(getString(R.string.normal))
            }

            else if (bmi > 24.9 ){ //Overweight
                imageViewBMI.setImageResource(R.drawable.over)
                textViewBMI.text = String.format("%s:%.2f",getString(R.string.bmi),bmi)
                textViewStatus.text = String.format(getString(R.string.over))
            }

            else{
                editTextWeight.setError (getString(R.string.invalid_value))
                return@setOnClickListener
            }



        }

        buttonReset.setOnClickListener{

        }
    }
}