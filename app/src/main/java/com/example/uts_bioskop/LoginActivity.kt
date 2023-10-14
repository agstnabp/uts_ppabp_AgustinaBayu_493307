package com.example.uts_bioskop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }

    fun onLoginClick(view: View) {
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (checkCredentials(username, password)) {
            // Login berhasil, arahkan pengguna ke halaman HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {
            // Login gagal, berikan pesan kesalahan kepada pengguna
            Toast.makeText(this, "Login gagal. Periksa username dan password Anda.", Toast.LENGTH_SHORT).show()
        }
    }
    fun checkCredentials(username: String, password: String): Boolean {
        // Periksa kredensial dengan data statis
        return username == "agustina" && password == "493307"
    }

}
