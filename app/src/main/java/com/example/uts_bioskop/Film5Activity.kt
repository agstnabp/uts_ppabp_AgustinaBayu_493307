package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_bioskop.databinding.ActivityFilm5Binding

class Film5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityFilm5Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilm5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getticket5.setOnClickListener {
                val intent_main = Intent(this@Film5Activity, PaymentActivity::class.java)
                startActivity(intent_main)
            }
        }
    }
}