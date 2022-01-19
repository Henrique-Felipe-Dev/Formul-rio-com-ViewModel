package com.example.formulariocomviewmodel.data

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var nome = "Fulano"
    var idade = 0
    var altura = 0.0

    fun setValores(n: String, i: Int, a: Double){
        nome = n
        idade = i
        altura = a
    }

}