package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_bioskop.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            val username = "agustina"
            with(binding) {
                nama.text = "Welcome $username"

            cardview1.setOnClickListener{
                val intent_main = Intent(this@HomeActivity, Film1Activity::class.java)
                startActivity(intent_main)
            }
            cardview2.setOnClickListener{
                val intent_main = Intent(this@HomeActivity, Film2Activity::class.java)
                startActivity(intent_main)
            }
            cardview3.setOnClickListener{
                val intent_main = Intent(this@HomeActivity, Film3Activity::class.java)
                startActivity(intent_main)
            }
            cardview4.setOnClickListener{
                val intent_main = Intent(this@HomeActivity, Film4Activity::class.java)
                startActivity(intent_main)
            }
            cardview5.setOnClickListener{
                val intent_main = Intent(this@HomeActivity, Film5Activity::class.java)
                startActivity(intent_main)
            }
            cardview6.setOnClickListener{
                val intent_main = Intent(this@HomeActivity, Film6Activity::class.java)
                startActivity(intent_main)
            }

            }
        }
    }
}