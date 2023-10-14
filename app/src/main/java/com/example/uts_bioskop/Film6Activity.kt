package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_bioskop.databinding.ActivityFilm6Binding

class Film6Activity : AppCompatActivity() {
    private lateinit var binding: ActivityFilm6Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilm6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            getticket6.setOnClickListener {
                val intent_main = Intent(this@Film6Activity, PaymentActivity::class.java)
                startActivity(intent_main)
            }
        }
    }
}