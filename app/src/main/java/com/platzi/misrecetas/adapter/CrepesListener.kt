package com.platzi.misrecetas.adapter

import com.platzi.misrecetas.model.Recetas

interface CrepesListener {
    fun onCrepesClicked(recetas: Recetas, position:Int)
}