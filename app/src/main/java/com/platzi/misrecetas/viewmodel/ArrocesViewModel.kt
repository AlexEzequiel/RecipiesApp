package com.platzi.misrecetas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.misrecetas.model.Recetas
import com.platzi.misrecetas.network.Callback
import com.platzi.misrecetas.network.FirestoreService

class ArrocesViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listArroces: MutableLiveData<List<Recetas>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getArrocesFromFirebase()
    }
    fun getArrocesFromFirebase(){
        firestoreService.getArroces(object: Callback<List<Recetas>> {
            override fun onSuccess(result: List<Recetas>?) {
                listArroces.postValue(result)
                processFinished()
            }
            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }
}