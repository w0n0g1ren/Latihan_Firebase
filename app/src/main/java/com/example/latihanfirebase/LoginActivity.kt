package com.example.latihanfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.latihanfirebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToRegister.setOnClickListener {
            val intent = Intent (this,RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.forgotPassword.setOnClickListener {
            val intent = Intent (this,ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()

            if (email.isEmpty()){
                binding.edtEmailLogin.error = "Email Harus Diisi"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailLogin.error = "Email Tidak Valid"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                binding.edtPasswordLogin.error = "Password Harus Diisi"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
       auth.signInWithEmailAndPassword(email, password)
           .addOnCompleteListener(this){
           if(it.isSuccessful){
               Toast.makeText(this,"Selamat Datang $email",Toast.LENGTH_SHORT).show()
               val intent = Intent(this,MainActivity::class.java)
               startActivity(intent)
               onStop()

           }else{
               Toast.makeText(this,"email anda tidak terdaftar",Toast.LENGTH_SHORT).show()
           }
       }
    }
}
