package com.example.diploma.khaiid.SignUp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import java.util.*
import android.app.DatePickerDialog
import android.widget.Toast
import com.example.diploma.khaiid.R
import java.text.SimpleDateFormat
import kotlinx.android.synthetic.main.sign_up_student_activity.*



class SignUpCourseActivity : AppCompatActivity() {

    private var buttonDate: Button? = null
    var textviewDate: TextView? = null
    var cal = Calendar.getInstance()



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_student_activity)

        // get the references from layout file
        textviewDate = this.text_view_date_1
        buttonDate = this.button_date_1

        textviewDate!!.text = "Date of Birth"

        // create an OnDateSetListener
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        buttonDate!!.setOnClickListener {
            DatePickerDialog(this@SignUpCourseActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }

//        val edit: EditText =editText
//        val edit2: EditText =editText2
//        val edit3: EditText =editText3
//        val edit4: EditText =editText4
//        val edit5: EditText =editText5
//        val edit6: EditText =editText6
//        val edit7: EditText =editText7
//        val edit8: EditText =editText8
//        val edit9: EditText =editText9
//        val edit10: EditText =editText10
//        val edit11: EditText =editText11
//        val edit12: EditText =editText12
//        val birthDate: TextView=text_view_date_1


//        val user0= User(edit.toString(),edit2.toString(),edit3.toString(),edit4.toString(),edit5.toString(),edit6.toString(),
//                edit7.toString(),edit8.toString(),edit9.toString(),edit10.toString(),edit11.toString(),edit12.toString(),birthDate.toString())
//
//       var registrationData=mutableListOf<User>()


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
//           registrationData.add(user0)
//
//            val gson = GsonBuilder().setPrettyPrinting().create()
//            val person = user0
//            val jsonPerson: String = gson.toJson(person)

            Toast.makeText(this@SignUpCourseActivity, "Almost done!",Toast.LENGTH_SHORT).show()
        }



//        var i = Intent(this,MainActivity::class.java)
//
//        i.putExtra("user","user0")
//        startActivity(i)
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textviewDate!!.text = sdf.format(cal.getTime())
    }






}