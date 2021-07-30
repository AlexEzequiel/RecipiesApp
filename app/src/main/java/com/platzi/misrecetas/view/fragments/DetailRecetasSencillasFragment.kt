package com.platzi.misrecetas.view.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.misrecetas.R
import com.platzi.misrecetas.model.Recetas
import kotlinx.android.synthetic.main.detail_fragment_crepes.*
import kotlinx.android.synthetic.main.detail_fragment_recetas_complejas.*
import kotlinx.android.synthetic.main.detail_fragment_recetas_sencillas.*

class DetailRecetasSencillasFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_fragment_recetas_sencillas, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBarRecetasSencillas.navigationIcon = ContextCompat.getDrawable(view.context,R.drawable.ic_close)
        toolBarRecetasSencillas.setTitleTextColor(Color.WHITE)
        toolBarRecetasSencillas.setNavigationOnClickListener{
            dismiss()
        }
        val recetasSencillas = arguments?.getSerializable("recetasSencillas") as Recetas
        toolBarRecetasSencillas.title = recetasSencillas.nombreRecetas
        Glide.with(ivDetailRecetasSencillas.context)
            .load(recetasSencillas.fotoRecetas)
            .into(ivDetailRecetasSencillas)
        tvNombreRecetaSencillaDetalle.text = recetasSencillas.nombreRecetas
        tvDetailRecetaSencillaIngredientes.text = recetasSencillas.ingredientesReceta
        tvDetailRecetaSencillaPreparacion.text = recetasSencillas.preparacionReceta
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}