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
import com.platzi.misrecetas.adapter.ArrocesAdapter
import com.platzi.misrecetas.adapter.ArrocesListener
import com.platzi.misrecetas.adapter.RecetasSencillasAdapter
import com.platzi.misrecetas.adapter.RecetasSencillasListener
import com.platzi.misrecetas.model.Recetas
import com.platzi.misrecetas.viewmodel.ArrocesViewModel
import com.platzi.misrecetas.viewmodel.RecetasViewModel
import kotlinx.android.synthetic.main.fragment_arroces.*
import kotlinx.android.synthetic.main.fragment_recetas_sencillas.*

class ArrocesFragment: Fragment(), ArrocesListener {
    private lateinit var arrocesAdapter: ArrocesAdapter
    private lateinit var viewModel: ArrocesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_arroces, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArrocesViewModel::class.java)
        viewModel.refresh()

        arrocesAdapter = ArrocesAdapter(this)
        rvArroces.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = arrocesAdapter
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.listArroces.observe(viewLifecycleOwner, Observer<List<Recetas>>{
            arroces -> arrocesAdapter.updateData(arroces)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
            if(it != null)
                rlBaseArroces.visibility = View.INVISIBLE
        })
    }
    override fun onArrocesClicked(arroces: Recetas, position: Int) {
        val bundle = bundleOf("arroces" to arroces)
        findNavController().navigate(R.id.detailArrocesFragment, bundle)
    }
}