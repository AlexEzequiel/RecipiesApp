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
import kotlinx.android.synthetic.main.detail_fragment_recetas_sencillas.*

class DetailArrocesFragment: DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_fragment_arroces, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBarArroces.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolBarArroces.setTitleTextColor(Color.WHITE)
        toolBarArroces.setNavigationOnClickListener{
            dismiss()
        }
        val arroces = arguments?.getSerializable("arroces") as Recetas
        toolBarArroces.title = arroces.nombreRecetas
        Glide.with(ivDetailArroz.context)
                .load(arroces.fotoRecetas)
                .into(ivDetailArroz)
        tvNombreArrozDetalle.text = arroces.nombreRecetas
        tvDetailArrozIngredientes.text = arroces.ingredientesReceta
        tvDetailArrozPreparacion.text = arroces.preparacionReceta
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}