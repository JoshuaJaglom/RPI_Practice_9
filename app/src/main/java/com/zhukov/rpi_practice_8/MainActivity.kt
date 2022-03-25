package com.zhukov.rpi_practice_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.zhukov.rpi_practice_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        findNumber()
    }

    private fun findNumber() {
        binding.findBtn.setOnClickListener {
            if (binding.leftBorder.text.isNotEmpty() and binding.rightBorder.text.isNotEmpty()) {
                if (binding.leftBorder.text.toString().toInt() <
                    binding.rightBorder.text.toString().toInt()){
                    val intent = Intent(this, FindNumberActivity::class.java)
                    intent.putExtra("leftBorder", binding.leftBorder.text.toString().toInt())
                    intent.putExtra("rightBorder", binding.rightBorder.text.toString().toInt())
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Неверно указан диапозон!", LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Не все поля заполнены!", LENGTH_SHORT).show()
            }
        }
    }
}