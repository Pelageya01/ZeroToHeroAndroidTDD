package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val viewModel = (application as App).viewModel

            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            val button = findViewById<Button>(R.id.actionButton)
            val textView = findViewById<TextView>(R.id.titleTextView)


            button.setOnClickListener {
                viewModel.load() // triggers the method in ViewModel
            }

            // Observe the LiveData for UI state updates
            viewModel.liveData().observe(this) {
                it.apply(textView, button, progressBar)
            }
        }
    }

