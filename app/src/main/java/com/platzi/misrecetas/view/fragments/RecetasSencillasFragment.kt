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
import com.platzi.misrecetas.adapter.RecetasSencillasAdapter
import com.platzi.misrecetas.adapter.RecetasSencillasListener
import com.platzi.misrecetas.model.Recetas
import com.platzi.misrecetas.viewmodel.RecetasViewModel
import kotlinx.android.synthetic.main.fragment_recetas_sencillas.*

class RecetasSencillasFragment: Fragment(), RecetasSencillasListener {
    private lateinit var recetasAdapter: RecetasSencillasAdapter
    private lateinit var viewModel: RecetasViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recetas_sencillas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecetasViewModel::class.java)
        viewModel.refresh()

        recetasAdapter = RecetasSencillasAdapter(this)
        rvRecetasSencillas.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = recetasAdapter
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.listRecetas.observe(viewLifecycleOwner, Observer<List<Recetas>>{
                recetasSencillas -> recetasAdapter.updateData(recetasSencillas)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
            if(it != null)
                rlBaseRecetas.visibility = View.INVISIBLE
        })
    }
    override fun onRecetaClicked(recetasSencillas: Recetas, position: Int) {
        val bundle = bundleOf("recetasSencillas" to recetasSencillas)
        findNavController().navigate(R.id.detailRecetasSencillasFragment, bundle)
    }
}