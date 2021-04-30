package com.example.convidados.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application){
    private val mGuestRepository: GuestRepository =
        GuestRepository.getInstance(application.applicationContext)
    private var mSaveGest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGest

    fun save(name: String, presence: Boolean){
        val guest = GuestModel(name = name, presence =  presence)
        mSaveGest.value = mGuestRepository.save(guest)
    }
}