package com.rafael.firstapplication_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Acessando os componentes via binding
        val editTextEmail = binding.editText
        val editTextPassword = binding.editTextPassword
        val button = binding.button

        button.setOnClickListener {
            val email = editTextEmail.text.toString()
            val senha = editTextPassword.text.toString()

            val mensagem = "Email: $email\nSenha: $senha"
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
        }
    }
}
