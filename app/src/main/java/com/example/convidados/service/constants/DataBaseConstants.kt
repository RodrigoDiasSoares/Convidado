package com.example.convidados.service.constants

import android.content.Context

class DataBaseConstants {
    object  GUEST{
        const val TABLE_NAME = "Guest"

        object COLUMNS{
            const val  ID = "id"
            const val NAME = "name"
            const val  PRESENCE = "presence"
        }
    }
}