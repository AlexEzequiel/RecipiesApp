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
import com.platzi.misrecetas.adapter.*
import com.platzi.misrecetas.model.Recetas
import com.platzi.misrecetas.viewmodel.CrepesViewModel
import com.platzi.misrecetas.viewmodel.RecetasViewModel
import kotlinx.android.synthetic.main.fragment_crepes.*
import kotlinx.android.synthetic.main.fragment_recetas_sencillas.*
import kotlinx.android.synthetic.main.fragment_recetas_sencillas.rlBaseRecetas

class CrepesFragment: Fragment(), CrepesListener {
    private lateinit var crepesAdapter: CrepesAdapter
    private lateinit var viewModel: CrepesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_crepes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CrepesViewModel::class.java)
        viewModel.refresh()

        crepesAdapter = CrepesAdapter(this)
        rvCrepes.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = crepesAdapter
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.listCrepes.observe(viewLifecycleOwner, Observer<List<Recetas>>{
            crepes -> crepesAdapter.updateData(crepes)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
            if(it != null)
                rlBaseCrepes.visibility = View.INVISIBLE
        })
    }
    override fun onCrepesClicked(crepes: Recetas, position: Int) {
        val bundle = bundleOf("crepes" to crepes)
        findNavController().navigate(R.id.detailCrepesFragment, bundle)
    }
}