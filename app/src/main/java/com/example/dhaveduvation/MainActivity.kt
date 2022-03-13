package com.example.dhaveduvation

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private  lateinit var tvClickSign : TextView
    private  lateinit var tvEmail : TextView
    private  lateinit var tvPassword : TextView
    private  lateinit var btnLogin : Button
//    private lateinit var loginLayout : androidx.constraintlayout.widget.ConstraintLayout
    companion object {
       var AuthUsername = "EXTRA_NAME"
        var Authpassword = "EXTRA_PASS"
    }

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == SignUpActivity.RESULT_CODE && result.data != null) {
            val selectedEmail = result.data?.getStringExtra(SignUpActivity.EXTRA_Email)
            val selectedPass = result.data?.getStringExtra(SignUpActivity.EXTRA_Password)

            AuthUsername = selectedEmail.toString()
            Authpassword= selectedPass.toString()

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
//        loginLayout = findViewById(R.id.ly_login)
//        loginLayout.setBackgroundColor(Color.parseColor("#6f551c"))
        tvClickSign = findViewById(R.id.tv_clicksignUp)
        tvClickSign.setOnClickListener(this)

        tvEmail = findViewById(R.id.edt_loginUser)
        tvPassword = findViewById(R.id.edt_loginPass)
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when ( v.id){
            R.id.btn_login -> {

                val Username = tvEmail.text.toString().trim()
                val Password = tvPassword.text.toString().trim()
                print(Password)

                var empty = false
                var auth = false

                if(Username.isEmpty() || Username != AuthUsername ){
                    empty = true
                    auth = true
                    tvEmail.error = "TextField Tidak Boleh kosong"
                }
                if(Password.isEmpty() ||  Password != Authpassword){
                    empty = true
                    auth = true
                    tvPassword.error = "TextField Tidak Boleh kosong"
                }

                if (empty != true && auth != true){
                    val mHomepage = Intent(this@MainActivity , HomePage::class.java)
                    startActivity(mHomepage)
                }
            }
            R.id.tv_clicksignUp -> {
                val mSignupPage = Intent(this@MainActivity , SignUpActivity::class.java)
                resultLauncher.launch(mSignupPage)
            }
        }

    }
}