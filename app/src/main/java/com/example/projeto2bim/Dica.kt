package com.example.projeto2bim

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto2bim.adapters.DadosAdapter
import com.example.projeto2bim.databinding.InformaBinding
import com.example.projeto2bim.models.DispositivosModelo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class Dica: AppCompatActivity() {

    private lateinit var tvComida: TextView
    private lateinit var tvFilme: TextView
    private lateinit var tvSerie: TextView
    private lateinit var tvMusica: TextView
    private lateinit var tvAlergia: TextView
    private lateinit var tvPiorComida: TextView


    private lateinit var dbRef: DatabaseReference
    private var dispList: ArrayList<DispositivosModelo> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dicas)

        val minhaVariavel = intent.getStringExtra("comi")
        tvComida = findViewById(R.id.textView5)
        tvFilme = findViewById(R.id.textView6)
        tvSerie = findViewById(R.id.textView7)
        tvMusica = findViewById(R.id.textView8)
        tvAlergia = findViewById(R.id.textView9)
        tvPiorComida = findViewById(R.id.textView10)

        dbRef = FirebaseDatabase.getInstance().getReference("DadosPessoais")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dispList.clear()
                if (snapshot.exists()) {
                    for (favSnap in snapshot.children) {
                        val favData = favSnap.getValue(DispositivosModelo::class.java)
                        dispList.add(favData!!)
                    }

                    // Atualiza os TextViews após obter os dados
                    if (dispList.isNotEmpty()) {
                        tvComida.text = dispList[0].comifavo.toString()
                        tvFilme.text = dispList[0].filmefavo.toString()
                        tvSerie.text = dispList[0].seriefavo.toString()
                        tvMusica.text = dispList[0].musicfavo.toString()
                        tvAlergia.text = dispList[0].alergias.toString()
                        tvPiorComida.text = dispList[0].comidaruim.toString()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled event
            }
        })
    }
}



