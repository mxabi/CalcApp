package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onDigit(view: View) {
        Toast.makeText(this, "This button works: ${(view as Button).text}", Toast.LENGTH_SHORT)
            .show()
        binding.tvInput.append(view.text)
    }

    fun onClear(view: View) {
        binding.tvInput.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (
            binding.tvInput.text == "" ||
            !binding.tvInput.text.last().isDigit()
        ) {
            // invalid
        } else {
            // valid
            onDigit(view)
        }
    }

    fun onEqual(view: View) {
        //Check if value is numeric
        if (!binding.tvInput.text.last().isDigit()) {
            // invalid
        } else {

            var tvValue = binding.tvInput.text.toString()

            try {
                //valid
                if (tvValue.contains("+")) {

                    val splitValue = binding.tvInput.text.split("+")

                    var one = splitValue[0]
                    var two = splitValue[1]

                    binding.tvInput.text = (one.toDouble() + two.toDouble()).toString()
                } else if (tvValue.contains("-")) {

                    val splitValue = binding.tvInput.text.split("-")

                    var one = splitValue[0].toDouble()
                    var two = splitValue[1].toDouble()

                    if (one > two) {
                        binding.tvInput.text = (one - two).toString()
                    } else {
                        Toast.makeText(this, "Negative Number ", Toast.LENGTH_SHORT).show()
                    }
                } else if (tvValue.contains("*")) {
                    val splitValue = binding.tvInput.text.split("*")

                    var one = splitValue[0].toDouble()
                    var two = splitValue[1].toDouble()

                    binding.tvInput.text = (one * two).toString()
                } else if (tvValue.contains("/")) {
                    val splitValue = binding.tvInput.text.split("/")

                    var one = splitValue[0].toDouble()
                    var two = splitValue[1].toDouble()

                    binding.tvInput.text = (one / two).toString()
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }
        fun onOperand(view: View) {
            if (
                binding.tvInput.text == "" ||
                !binding.tvInput.text.last().isDigit() ||
                !binding.tvInput.text.contains("^([0-9]*[.])?[0-9]+$".toRegex())
            ) {
                //invalid
            } else {
                // valid
                onDigit(view)
            }
        }
        /**
         * if (performing operation) for example a+b
         * you should not be able to append operand
         */
    }
