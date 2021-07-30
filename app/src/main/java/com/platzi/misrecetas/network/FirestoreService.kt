package com.platzi.misrecetas.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.misrecetas.model.Recetas

const val RECETAS_COLLECTION_NAME = "recetasSencillas"
const val RECETAS_COMP_COLLECTION_NAME = "recetasComplejas"
const val ARROCES_COLLECTION_NAME = "arroces"
const val CREPES_COLLECTION_NAME = "crepes"



class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getRecetas(callback: Callback<List<Recetas>>) {
        firebaseFirestore.collection(RECETAS_COLLECTION_NAME)
            .orderBy("posicion")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Recetas::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getRecetasComp(callback: Callback<List<Recetas>>) {
        firebaseFirestore.collection(RECETAS_COMP_COLLECTION_NAME)
                .orderBy("posicion")
                .get()
                .addOnSuccessListener { result ->
                    for (doc in result){
                        val list = result.toObjects(Recetas::class.java)
                        callback.onSuccess(list)
                        break
                    }
                }
    }
    fun getArroces(callback: Callback<List<Recetas>>) {
        firebaseFirestore.collection(ARROCES_COLLECTION_NAME)
                .orderBy("posicion")
                .get()
                .addOnSuccessListener { result ->
                    for (doc in result){
                        val list = result.toObjects(Recetas::class.java)
                        callback.onSuccess(list)
                        break
                    }
                }
    }
    fun getCrepes(callback: Callback<List<Recetas>>) {
        firebaseFirestore.collection(CREPES_COLLECTION_NAME)
                .orderBy("posicion")
                .get()
                .addOnSuccessListener { result ->
                    for (doc in result){
                        val list = result.toObjects(Recetas::class.java)
                        callback.onSuccess(list)
                        break
                    }
                }
    }
}