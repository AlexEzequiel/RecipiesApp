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
import kotlinx.android.synthetic.main.detail_fragment_crepes.*
import kotlinx.android.synthetic.main.detail_fragment_recetas_sencillas.*

class DetailCrepesFragment: DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_fragment_crepes, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBarCrepes.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolBarCrepes.setTitleTextColor(Color.WHITE)
        toolBarCrepes.setNavigationOnClickListener{
            dismiss()
        }
        val crepes = arguments?.getSerializable("crepes") as Recetas
        toolBarCrepes.title = crepes.nombreRecetas
        Glide.with(ivDetailCrepe.context)
                .load(crepes.fotoRecetas)
                .into(ivDetailCrepe)
        tvNombreCrepeDetalle.text = crepes.nombreRecetas
        tvDetailCrepeIngredientes.text = crepes.ingredientesReceta
        tvDetailCrepePreparacion.text = crepes.preparacionReceta
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}