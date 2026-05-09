package com.example.coffeshop.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeshop.Domain.BannerModel
import com.example.coffeshop.Domain.CategoryModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        val listData= MutableLiveData<MutableList<BannerModel>>()
        val ref= firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                val list =mutableListOf<BannerModel>()
                for(childSnapShot in snapshot.children){
                    val item=childSnapShot.getValue(BannerModel::class.java)
                    item?.let{list.add(it)}
                }
            listData.value = list
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return listData
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        val listData= MutableLiveData<MutableList<CategoryModel>>()
        val ref= firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                val list =mutableListOf<CategoryModel>()
                for(childSnapShot in snapshot.children){
                    val item=childSnapShot.getValue(CategoryModel::class.java)
                    item?.let{list.add(it)}
                }
                listData.value = list
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return listData
    }
}