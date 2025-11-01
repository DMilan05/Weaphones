package com.example.weaphones

data class Weapon(
    val name: String,
    val category: String,
    val caliber: String,
    val origin: String,
    val year: Int,
    val manufacturer: String,
    val weightKg: Double,
    val barrelLengthMm: Int,
    val rateOfFire: Int
)