package com.example.projeto2bim

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto2bim.databinding.MainactivityBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainactivityBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)


        firebaseAuth = FirebaseAuth.getInstance()

        val btn: Button = findViewById(R.id.butCada)

        btn.setOnClickListener{
            val email = findViewById<EditText>(R.id.textemail).text.toString()
            val senha = findViewById<EditText>(R.id.textsenha).text.toString()
            val confsenha = findViewById<EditText>(R.id.textconfsen).text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty() && confsenha.isNotEmpty()) {

                if (senha == confsenha) {

                    firebaseAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, Informa::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "A senha não corresponde", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Campos vazios não são permitidos!!", Toast.LENGTH_SHORT).show()




            }
        }
    }
}
