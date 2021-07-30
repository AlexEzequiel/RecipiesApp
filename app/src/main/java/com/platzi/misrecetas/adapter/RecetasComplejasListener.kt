package com.platzi.misrecetas.adapter

import com.platzi.misrecetas.model.Recetas

interface RecetasComplejasListener {
    fun onRecetaComplejaClicked(recetas: Recetas, position:Int)
}