package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        button = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE

            // Simulate a delay
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.GONE
                textView.visibility = View.VISIBLE
                button.isEnabled = true
            }, 3000)
        }
    }
}