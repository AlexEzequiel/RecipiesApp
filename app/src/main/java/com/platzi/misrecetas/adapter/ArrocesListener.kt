package com.platzi.misrecetas.adapter

import com.platzi.misrecetas.model.Recetas

interface ArrocesListener {
    fun onArrocesClicked(recetas: Recetas, position:Int)
}