package com.example.uts_bioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import com.example.uts_bioskop.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding

    companion object {
        var jenis_seats = "jenis seats"
        var nama_bioskop = "bioskop"
        var metode_pembayaran = "metode"
        var via_bank = "bank"


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bioskop = resources.getStringArray(R.array.bioskop)
        val jenis = resources.getStringArray(R.array.jenis)
        val metode = resources.getStringArray(R.array.metode)
        val bank = resources.getStringArray(R.array.bank)

        with(binding) {

            val bioskopAdapter = ArrayAdapter(
                this@PaymentActivity,
                android.R.layout.simple_spinner_dropdown_item,
                bioskop
            )
            bioskopAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinBioskop.adapter = bioskopAdapter
            spinBioskop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val selectedItemPos = parent.getItemAtPosition(position).toString()
                    nama_bioskop = selectedItemPos
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            val jenisAdapter = ArrayAdapter(
                this@PaymentActivity,
                android.R.layout.simple_spinner_dropdown_item,
                jenis
            )
            jenisAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinJenis.adapter = jenisAdapter
            spinJenis.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val selectedItemPos = parent.getItemAtPosition(position).toString()
                    jenis_seats = selectedItemPos
                    binding.jenisdipilih.text = jenis_seats
                    if (jenis_seats == "Regular Seats") {
                        binding.Harga.text = "Rp. 35000"
                    } else {
                        binding.Harga.text = "Rp. 60000"
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            val metodeAdapter = ArrayAdapter(
                this@PaymentActivity,
                android.R.layout.simple_spinner_dropdown_item, metode
            )
            metodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinMetode.adapter = metodeAdapter
            spinMetode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val selectedItemPos = parent.getItemAtPosition(position).toString()
                    metode_pembayaran = selectedItemPos
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            val bankAdapter = ArrayAdapter(
                this@PaymentActivity,
                android.R.layout.simple_spinner_dropdown_item, bank
            )
            bankAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinBank.adapter = bankAdapter
            spinBank.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val selectedItemPos = parent.getItemAtPosition(position).toString()
                    via_bank = selectedItemPos
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            pesan.setOnClickListener {
                val intent_main = Intent(this@PaymentActivity, OrderActivity::class.java)
                val namaBioskop = spinBioskop.selectedItem.toString()
                val jenisSeats = spinJenis.selectedItem.toString()
                // Ambil tanggal dari DatePicker
                val datePicker = findViewById<DatePicker>(R.id.date_pick)
                val tanggal = "${datePicker.dayOfMonth}/${datePicker.month + 1}/${datePicker.year}"
                val bank = spinBank.selectedItem.toString()
                // Ambil nomor rekening dari EditText
                val nomorRekening = norek.text.toString()
                if (nomorRekening.isEmpty()) {
                    // Tampilkan Toast jika nomor rekening tidak diisi
                    Toast.makeText(
                        this@PaymentActivity,
                        "Nomor rekening harus diisi",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val timePicker = findViewById<TimePicker>(R.id.timepick)
                    var jam = 0
                    var menit = 0
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        // Untuk API level 23 (M) atau lebih tinggi
                        jam = timePicker.hour
                        menit = timePicker.minute
                    }

                    // Sisipkan nilai-nilai ini ke dalam Intent
                    intent_main.putExtra("namaBioskop", namaBioskop)
                    intent_main.putExtra("jenisSeats", jenisSeats)
                    intent_main.putExtra("tanggal", tanggal)
                    intent_main.putExtra("bank", bank)
                    intent_main.putExtra("nomorRekening", nomorRekening)
                    intent_main.putExtra("jam", jam)
                    intent_main.putExtra("menit", menit)


                    startActivity(intent_main)
                }

            }

        }
    }
}


