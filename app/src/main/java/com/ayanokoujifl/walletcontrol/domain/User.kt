package com.ayanokoujifl.walletcontrol.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var email: String,
    var password: String,

    var createdAt: Long = System.currentTimeMillis(),
    var updatedAt: Long = System.currentTimeMillis(),

    var currency: String = "BRL",
    var notificationsOn: Boolean = true,
    var avatarUrl: String? = null
)