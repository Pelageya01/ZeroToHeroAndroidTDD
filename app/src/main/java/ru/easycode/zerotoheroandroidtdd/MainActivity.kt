package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.changeButton)
        var textView = findViewById<TextView>(R.id.titleTextView)


        // Button click updates the text
        button.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
    }
}