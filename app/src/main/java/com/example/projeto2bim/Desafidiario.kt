package com.example.projeto2bim

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto2bim.adapters.DadosAdapter
import com.example.projeto2bim.models.DispositivosModelo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.random.Random
import com.example.projeto2bim.databinding.DesadiarBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import androidx.recyclerview.widget.RecyclerView

class Desafidiario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desadiar)

        val generator = UniqueRandomGenerator()
        val x = generator.generateUniqueNumber(1, 5)

        val minhaVariavel = intent.getStringExtra("comi")

        if (x == 1) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Prepare um delicioso almoço para a sua paixão, para que o dia começe mil maravilhas.\n " +
                        "Faça as seguintes tarefas:\n " +
                        "- Arrume o ambiente para ficar o mais cômodo possível;\n" +
                        "- Faça a refeição favorita de seu amor;\n" +
                        "- Evite os alimentos que a pessoa tem alergia;(opcional)\n"
        }

        if (x == 2) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Faça uma noite de filmes na compania do seu coração, para que depois de um longo dia, vocês possam passar um tempo divertido juntos.\n " +
                        "Faça as seguintes tarefas:\n " +
                        "- Arrume o ambiente para ficar o mais cômodo possível;\n" +
                        "- Prepare uma pipoquinha para o filme;\n" +
                        "- Escolha o filme favorito de sua/seu parceira/o\n"
        }

        if (x == 3) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Prepare um espaço para que você e seu xuxu possam se divertir dançando juntos.\n " +
                        "Faça as seguintes tarefas:\n " +
                        "- Arrume o ambiente para ficar o mais cômodo possível;\n" +
                        "- Separe um espaço da casa para poderem dançar;\n" +
                        "- Escolha o filme favorito de sua/seu parceira/o\n"
        }

        if (x == 4) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Separe uma tarde para maratonar a serie favorita do/da seu/sua companheiro/a.\n " +
                        "Faça as seguintes tarefas:\n " +
                        "- Arrume o ambiente para ficar o mais cômodo possível;\n" +
                        "- Prepare uns lanchinhos para acompanhar a série;\n" +
                        "- Escolha a serie favorita da sua pessoa\n"
        }

        if (x == 5) {
            val desafios = findViewById<TextView>(R.id.tvmostrar)
            desafios.text =
                "Faça uma brincadeira os dois para se divertir e ver o quanto um conhece o outro.( causar treta mesmo >:) )\n " +
                        "Faça as seguintes tarefas:\n " +
                        "- Arrume o ambiente para ficar o mais cômodo possível;\n" +
                        "- Pegue duas folhas e coloque topicos pessoais, como: Comida, filme e serie favorita, desgostos, alergias, entre outros;\n" +
                        "- NÃO ERRE, ISSO É OBRIGATÓRIO\n"
        }


        val btnon: Button = findViewById(R.id.btndica)
        btnon.setOnClickListener{
            val intent = Intent(this@Desafidiario, Dica::class.java)
            intent.putExtra("comi", minhaVariavel)
            startActivity(intent)

        }


    }



    class UniqueRandomGenerator {
        private val generatedNumbers = mutableListOf<Int>()

        fun generateUniqueNumber(min: Int, max: Int): Int {
            var randomNumber: Int
            do {
                randomNumber = Random.nextInt(min, max + 1)
            } while (generatedNumbers.contains(randomNumber))

            generatedNumbers.add(randomNumber)
            return randomNumber
        }
    }
}


