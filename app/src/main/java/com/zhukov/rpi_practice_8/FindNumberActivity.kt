package com.zhukov.rpi_practice_8

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zhukov.rpi_practice_8.databinding.ActivityFindNumberBinding

class FindNumberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFindNumberBinding
    private var check: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindNumberBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var leftBorder: Int = intent.getIntExtra("leftBorder", 0).toString().toInt()
        var rightBorder: Int = intent.getIntExtra("rightBorder", 0).toString().toInt()
        var middleValue: Int = (leftBorder + rightBorder)/2
        binding.textBorder.text = "Ваше число $middleValue ?"
        binding.btnYes.setOnClickListener {
            when (check) {
                0 -> {
                    Toast.makeText(this, "Вы отгадали число!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    leftBorder = (leftBorder + rightBorder)/2
                    middleValue = (leftBorder + rightBorder)/2
                    binding.textBorder.text = "Ваше число $middleValue ?"
                    check = 0
                }
                2 -> {
                    rightBorder = (leftBorder + rightBorder)/2
                    middleValue = (leftBorder + rightBorder)/2
                    binding.textBorder.text = "Ваше число $middleValue ?"
                    check = 0
                }
            }
        }
        binding.btnNo.setOnClickListener {
            when (check) {
                0 -> {
                    check++
                    binding.textBorder.text = "Ваше число больше чем $middleValue ?"
                }
                1 -> {
                    check++
                    binding.textBorder.text = "Ваше число меньше чем $middleValue ?"
                }
                else -> {
                    check = 0
                    binding.textBorder.text = "Ваше число $middleValue ?"
                }
            }
        }
    }
}