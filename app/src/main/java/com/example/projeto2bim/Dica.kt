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

    private lateinit var tvDispId: TextView

    private lateinit var dbRef: DatabaseReference
    private lateinit var dispList: ArrayList<DispositivosModelo>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dicas)

        val minhaVariavel = intent.getStringExtra("comi")
        tvDispId = findViewById(R.id.textView5)
        tvDispId.text = minhaVariavel




        /*dbRef = FirebaseDatabase.getInstance().getReference("DadosPessoais")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dispList.clear()
                if (snapshot.exists()) {
                    for (empSnap in snapshot.children) {
                        val empData = empSnap.getValue(DispositivosModelo::class.java)
                        dispList.add(empData!!)

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        tvDispId.text = dispList[0].dispId
        //só pra testar*/

    }
}



