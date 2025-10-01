package com.rafael.firstapplication_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication_2.databinding.ActivityMainBinding

// Atividade principal do app
class MainActivity : AppCompatActivity() {

    // Variável para o view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)  // Define a view principal da atividade

        // Habilita modo de tela cheia com bordas estendidas (edge-to-edge)
        enableEdgeToEdge()

        // Ajusta padding da view para não sobrepor barras do sistema (status bar, navbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Acessando os componentes do layout via binding
        val editTextEmail = binding.editText
        val editTextPassword = binding.editTextPassword
        val button = binding.button

        // Ação ao clicar no botão
        button.setOnClickListener {
            val email = editTextEmail.text.toString()       // Pega o texto do campo de e-mail
            val senha = editTextPassword.text.toString()    // Pega o texto do campo de senha

            // Cria mensagem para exibir em Toast
            val mensagem = "Email: $email\nSenha: $senha"
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show() // Exibe a mensagem
        }
    }
}
