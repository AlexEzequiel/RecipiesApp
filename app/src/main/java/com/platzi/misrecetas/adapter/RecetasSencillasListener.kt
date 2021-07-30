package com.platzi.misrecetas.adapter

import com.platzi.misrecetas.model.Recetas

interface RecetasSencillasListener {
    fun onRecetaClicked(recetas: Recetas, position:Int) }