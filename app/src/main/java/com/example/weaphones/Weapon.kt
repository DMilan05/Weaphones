package com.example.weaphones

data class Weapon(
    val name: String,
    val categoryRes: Int,
    val caliber: String,
    val originRes: Int,
    val year: Int,
    val manufacturer: String,
    val weightKg: Double,
    val barrelLengthMm: Int,
    val rateOfFire: Int,
    val imageResId: Int
)