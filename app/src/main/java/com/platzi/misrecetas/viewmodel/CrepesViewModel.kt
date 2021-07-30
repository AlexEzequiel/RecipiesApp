package com.platzi.misrecetas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.misrecetas.model.Recetas
import com.platzi.misrecetas.network.Callback
import com.platzi.misrecetas.network.FirestoreService

class CrepesViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listCrepes: MutableLiveData<List<Recetas>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getCrepesFromFirebase()
    }
    fun getCrepesFromFirebase(){
        firestoreService.getCrepes(object: Callback<List<Recetas>> {
            override fun onSuccess(result: List<Recetas>?) {
                listCrepes.postValue(result)
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