package com.platzi.misrecetas.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.platzi.misrecetas.R
import com.platzi.misrecetas.adapter.RecetasComplejasAdapter
import com.platzi.misrecetas.adapter.RecetasComplejasListener
import com.platzi.misrecetas.adapter.RecetasSencillasAdapter
import com.platzi.misrecetas.model.Recetas
import com.platzi.misrecetas.viewmodel.RecetasComplejasViewModel
import com.platzi.misrecetas.viewmodel.RecetasViewModel
import kotlinx.android.synthetic.main.fragment_complejas.*
import kotlinx.android.synthetic.main.fragment_recetas_sencillas.*

class RecetasComplejasFragment: Fragment(), RecetasComplejasListener {
    private lateinit var recetasComplejasAdapter: RecetasComplejasAdapter
    private lateinit var viewModel: RecetasComplejasViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_complejas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecetasComplejasViewModel::class.java)
        viewModel.refresh()

        recetasComplejasAdapter = RecetasComplejasAdapter(this)
        rvRecetasComplejas.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = recetasComplejasAdapter
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.listRecetasComplejas.observe(viewLifecycleOwner, Observer<List<Recetas>>{
            recetasComplejas -> recetasComplejasAdapter.updateData(recetasComplejas)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
            if(it != null)
                rlBaseRecetasComplejas.visibility = View.INVISIBLE
        })
    }
    override fun onRecetaComplejaClicked(recetasComplejas: Recetas, position: Int) {
        val bundle = bundleOf("recetasComplejas" to recetasComplejas)
        findNavController().navigate(R.id.detailRecetasComplejasFragment, bundle)
    }
}