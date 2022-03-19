package com.example.dhaveduvation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvName : TextView
    private lateinit var tvUsername : TextView
    private lateinit var tvEmail : TextView
    private lateinit var tvPassword : TextView
    private lateinit var tvComfirmpass: TextView
    private lateinit var btnSignUp : Button

    companion object {
       const val EXTRA_Email = "EXTRA_EMAIL"
       const val EXTRA_Password = "EXTRA_PASS"
        const val RESULT_CODE = 110


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tvName = findViewById(R.id.edt_RegisName)
        tvEmail = findViewById(R.id.edt_RegisEmail)
        tvPassword = findViewById(R.id.edt_RegisPassword)
        tvComfirmpass = findViewById(R.id.edt_RegisConfirpass)
        btnSignUp = findViewById(R.id.btn_Signup)

        btnSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_Signup -> {
                val sName = tvName.text.toString().trim()
                val sEmail = tvEmail.text.toString().trim()
                val sPassword = tvPassword.text.toString().trim()
                val sConfirmPass = tvComfirmpass.text.toString().trim()

                var auth = false

                if (sPassword != sConfirmPass){
                    auth = true
                    tvComfirmpass.error = "Password not match"
                }

                if (auth != true){
                    val sHomepage = Intent()
                    sHomepage.putExtra(EXTRA_Email,sEmail)
                    sHomepage.putExtra(EXTRA_Password,sPassword)
                    setResult(RESULT_CODE, sHomepage)
                    finish()
                }
            }


        }

    }
}