package com.example.weaphones

object WeaponData {
    val allWeapons = listOf(
        // ---- GÉPKARABÉLYOK ----
        Weapon("AK-47", "Gépkarabély", "7.62x39mm", "Szovjetunió", 1947, "Kalashnikov Concern", 4.3, 415, 600,R.drawable.ak47),
        Weapon("M16A1", "Gépkarabély", "5.56x45mm NATO", "USA", 1964, "Colt", 3.4, 508, 700,R.drawable.m16a1),
        Weapon("FAMAS F1", "Gépkarabély", "5.56x45mm NATO", "Franciaország", 1978, "GIAT Industries", 3.6, 488, 900,R.drawable.famas),

        // ---- PISZTOLYOK ----
        Weapon("Glock 17", "Pisztoly", "9x19mm", "Ausztria", 1982, "Glock Ges.m.b.H.", 0.905, 114, 1200,R.drawable.glock17),
        Weapon("Beretta M9", "Pisztoly", "9x19mm", "Olaszország / USA", 1985, "Beretta", 0.95, 125, 1100,R.drawable.m9),
        Weapon("Desert Eagle", "Pisztoly", ".50 AE", "Izrael / USA", 1983, "Magnum Research / IMI", 1.99, 152, 500,R.drawable.deagle),

        // ---- GÉPPISZTOLYOK ----
        Weapon("Uzi", "Géppisztoly", "9x19mm", "Izrael", 1954, "IMI", 3.5, 260, 600,R.drawable.uzi),
        Weapon("MP5", "Géppisztoly", "9x19mm", "Németország", 1966, "Heckler & Koch", 2.9, 225, 800,R.drawable.mp5),
        Weapon("P90", "Géppisztoly", "5.7x28mm", "Belgium", 1990, "FN Herstal", 2.6, 263, 900,R.drawable.p90),

        // ---- GÉPPUSKÁK ----
        Weapon("PKM", "Géppuska", "7.62x54mmR", "Szovjetunió", 1969, "Kalashnikov Concern", 7.5, 658, 650,R.drawable.pkm),
        Weapon("M240B", "Géppuska", "7.62x51mm NATO", "USA", 1977, "FN Herstal / U.S. Ordnance", 12.5, 630, 650,R.drawable.m240b),

        // ---- MESTERLÖVÉSZ PUSKÁK ----
        Weapon("Dragunov SVD", "Mesterlövész puska", "7.62x54mmR", "Szovjetunió", 1963, "Kalashnikov Concern", 4.3, 620, 30,R.drawable.svd),
        Weapon("M24 SWS", "Mesterlövész puska", "7.62x51mm NATO", "USA", 1988, "Remington Arms", 5.4, 610, 20,R.drawable.m24),
        Weapon("Barrett M82", "Mesterlövész puska", ".50 BMG", "USA", 1989, "Barrett Firearms", 13.6, 737, 40,R.drawable.barret),

        // ---- SÖRÉTES PUSKÁK ----
        Weapon("Benelli M4", "Sörétes puska", "12-gauge", "Olaszország", 1999, "Benelli Armi", 3.8, 470, 120,R.drawable.benellim4),
        Weapon("Remington 870", "Sörétes puska", "12-gauge", "USA", 1950, "Remington Arms", 3.2, 470, 40,R.drawable.r870)
    )

}
