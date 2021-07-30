package com.platzi.misrecetas.view.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.platzi.misrecetas.R
import com.platzi.misrecetas.model.Recetas
import kotlinx.android.synthetic.main.detail_fragment_arroces.*
import kotlinx.android.synthetic.main.detail_fragment_crepes.*
import kotlinx.android.synthetic.main.detail_fragment_recetas_complejas.*
import kotlinx.android.synthetic.main.detail_fragment_recetas_sencillas.*

class DetailRecetasComplejasFragment : DialogFragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_fragment_recetas_complejas, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBarRecetasComplejas.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolBarRecetasComplejas.setTitleTextColor(Color.WHITE)
        toolBarRecetasComplejas.setNavigationOnClickListener{
            dismiss()
        }
        val recetasComplejas = arguments?.getSerializable("recetasComplejas") as Recetas
        toolBarRecetasComplejas.title = recetasComplejas.nombreRecetas
        Glide.with(ivDetailRecetasCmplejas.context)
                .load(recetasComplejas.fotoRecetas)
                .into(ivDetailRecetasCmplejas)
        tvNombreRecetaComplejaDetalle.text = recetasComplejas.nombreRecetas
        tvDetailRecetaComplejaIngredientes.text = recetasComplejas.ingredientesReceta
        tvDetailRecetaComplejaPreparacion.text = recetasComplejas.preparacionReceta
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}