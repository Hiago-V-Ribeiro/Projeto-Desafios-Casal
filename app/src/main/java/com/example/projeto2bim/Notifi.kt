package com.example.projeto2bim

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Notifi: AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notificacao)
        /*textView = findViewById(R.id.textviewData)
        val data = intent.getStringExtra("data")
        textView.setText(data)*/
    }
}