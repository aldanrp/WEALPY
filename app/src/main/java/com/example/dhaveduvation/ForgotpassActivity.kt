package com.example.dhaveduvation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ForgotpassActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var fEmail: EditText
    private lateinit var fSubmit: Button
    private lateinit var fBack : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass)

        fEmail= findViewById(R.id.edt_ForgotEmailUser)
        fSubmit= findViewById(R.id.btn_ForgotSubmit)
        fBack = findViewById(R.id.tv_forgotBack)

        fBack.setOnClickListener(this)
        fSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_ForgotSubmit -> {
                val getEmail = fEmail.text.toString().trim()

                Toast.makeText(this,"Data berhasil di input",Toast.LENGTH_SHORT).show()
            }
            R.id.tv_forgotBack -> {
                val fogotBack = Intent(this@ForgotpassActivity, MainActivity::class.java)
                startActivity(fogotBack)
            }
        }
    }
}