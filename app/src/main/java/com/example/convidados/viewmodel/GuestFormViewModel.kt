package com.example.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class GuestFormViewModel : ViewModel(){
    private val mGuestRepository: GuestRepository = GuestRepository()
    private var mSaveGest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGest

    fun save(name: String, presence: Boolean){
        val guest = GuestModel(name, presence)
        mGuestRepository.save(guest)
    }
}