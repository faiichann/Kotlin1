package com.example.kotlin1

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MotionEventCompat
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonMap)
        val number = findViewById<TextView>(R.id.textView2)
        val plus = findViewById<Button>(R.id.plusBth)
        val v1 = findViewById<View>(R.id.view1)

        button.setOnClickListener() {
            val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.resolveActivity(packageManager)?.let {
                startActivity(mapIntent)
            }
        }
        var integer1 = 0
        plus.setOnClickListener() {
            integer1 ++
            number.setText("$integer1")
            if (integer1 > 10) {
                Toast.makeText(applicationContext,"Max value is 10",Toast.LENGTH_SHORT).show()
                var index:Int = 1
                number.setText("MAx \n")
                do{
                    number.text = number.text.toString() + "$index \n"
                    index++ // Increment the value
                }while(index <= 3)
                }
        }
        v1.setOnTouchListener { v, event ->

            return@setOnTouchListener when (MotionEventCompat.getActionMasked(event)) {
                MotionEvent.ACTION_DOWN -> {

                    // Make a Toast when movements captured on the sub-class
                    Toast.makeText(applicationContext, "Move", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        }
    }
