package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.service.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application){
    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGest

    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest


    fun save(id: Int, name: String, presence: Boolean){
        val guest = GuestModel(id, name, presence)

        if (id == 0) {
            mSaveGest.value = mGuestRepository.save(guest)
        }else {
            mSaveGest.value = mGuestRepository.update(guest)
        }
    }
    fun load(id:Int){
        mGuest.value = mGuestRepository.get(id)
    }
}