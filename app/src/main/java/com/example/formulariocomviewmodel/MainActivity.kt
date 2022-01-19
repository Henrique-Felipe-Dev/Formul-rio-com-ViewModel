package com.example.formulariocomviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.formulariocomviewmodel.data.MainViewModel
import com.example.formulariocomviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)

        binding.buttonCadastro.setOnClickListener {
            cadastrar()
        }

        setDados()

    }

    private fun cadastrar() {
        val nome = binding.editNome.text.toString()
        val idade = binding.editIdade.text.toString()
        val altura = binding.editAltura.text.toString()

        if(nome != "" && idade != "" && altura != ""){
            mainViewModel.setValores(nome, idade.toInt(), altura.toDouble())
            setDados()
        }else{
            Toast.makeText(
                this,
                "Preencha os dados corretamente!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setDados(){
        binding.textNome.text = getString(R.string.nome, mainViewModel.nome)
        binding.textIdade.text = getString(R.string.idade, mainViewModel.idade.toString())
        binding.textAltura.text = getString(R.string.altura, mainViewModel.altura.toString())
    }
}