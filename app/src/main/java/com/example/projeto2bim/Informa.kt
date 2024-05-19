package com.example.projeto2bim

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto2bim.adapters.DadosAdapter
import com.example.projeto2bim.databinding.InformaBinding
import com.example.projeto2bim.databinding.MainactivityBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.projeto2bim.models.DispositivosModelo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList
class Informa : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var binding: InformaBinding
    private lateinit var dispList: ArrayList<DispositivosModelo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informa)
        binding = InformaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnon: Button = findViewById(R.id.butInfPes)
        btnon.setOnClickListener{
        dbRef = FirebaseDatabase.getInstance().getReference("DadosPessoais")

        val comidafav = findViewById<EditText>(R.id.textcomifav).text.toString()
        val filmefav = findViewById<EditText>(R.id.textfilmfav).text.toString()
        val seriefav = findViewById<EditText>(R.id.textseriefav).text.toString()
        val musifav = findViewById<EditText>(R.id.textmusifav).text.toString()
        val alergias = findViewById<EditText>(R.id.textalergias).text.toString()
        val ComidaRuim = findViewById<EditText>(R.id.textcomiruim).text.toString()
        val Nome = findViewById<EditText>(R.id.textnome).text.toString()

        if (comidafav.isEmpty()){
            findViewById<EditText>(R.id.textcomifav).error ="Insira a sua Comida Favorita pfv :)"
        }
        if (filmefav.isEmpty()){
            findViewById<EditText>(R.id.textfilmfav).error ="Insira seu filme Favorito pfv :)"
        }
        if (seriefav.isEmpty()){
            findViewById<EditText>(R.id.textseriefav).error ="Insira sua série Favorita pfv :)"
        }
        if (musifav.isEmpty()){
            findViewById<EditText>(R.id.textmusifav).error ="Insira sua música Favorita pfv :)"
        }
        if (alergias.isEmpty()){
            findViewById<EditText>(R.id.textalergias).error ="Insira sua Alergia pfv :)"
        }
        if (ComidaRuim.isEmpty()){
            findViewById<EditText>(R.id.textcomiruim).error ="Insira sua Comida que vc não gosta pfv :)"
        }
        if (Nome.isEmpty()){
            findViewById<EditText>(R.id.textnome).error ="Insira seu Nome pfv :)"
        }

        val dispId = dbRef.push().key?: ""


        val dispositivosss = DispositivosModelo(dispId, comidafav,filmefav,seriefav,musifav,alergias,ComidaRuim,Nome)

        dbRef.child(dispId).setValue(dispositivosss)
            .addOnCompleteListener{
                Toast.makeText(this,"Dado inserido com sucesso", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{ err->
                Toast.makeText(this,"Erro ${err.message}", Toast.LENGTH_SHORT).show()
            }



            val intent = Intent(this@Informa, Layout::class.java)
            intent.putExtra("comi", comidafav)
            startActivity(intent)

        }

    }
    /*private fun getEmployeesData() {
    dbRef = FirebaseDatabase.getInstance().getReference("Exemplo_Disp")


    dbRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            dispList.clear()
            if (snapshot.exists()){
                for (empSnap in snapshot.children){
                    val empData = empSnap.getValue(DispositivosModelo::class.java)
                    dispList.add(empData!!)
                }
                val mAdapter = DadosAdapter(dispList)

                mAdapter.setOnItemClickListener(object : DadosAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {

                        val intent = Intent(this@Informa, Layout::class.java)

                        intent.putExtra("dispId", dispList[position].dispId)
                        intent.putExtra("comifavo", dispList[position].comifavo)
                        intent.putExtra("filmefavo", dispList[position].filmefavo)
                        intent.putExtra("seriefavo", dispList[position].seriefavo)
                        intent.putExtra("musicfavo", dispList[position].musicfavo)
                        intent.putExtra("alergias", dispList[position].alergias)
                        intent.putExtra("comidaruim", dispList[position].comidaruim)
                        intent.putExtra("nome", dispList[position].nome)
                        startActivity(intent)
                    }

                })
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })*/
}








