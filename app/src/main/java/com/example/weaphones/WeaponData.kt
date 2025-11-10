package com.example.weaphones

object WeaponData {
    val allWeapons = listOf(
        // ---- GÉPKARABÉLYOK ----
        Weapon("AK-47", "Gépkarabély", "7.62x39mm", "Szovjetunió", 1947, "Kalashnikov Concern", 4.3, 415, 600, R.drawable.ak47),
        Weapon("AKM", "Gépkarabély", "7.62x39mm", "Szovjetunió", 1959, "Kalashnikov Concern", 3.1, 415, 600, R.drawable.akm),
        Weapon("AK-74", "Gépkarabély", "5.45x39mm", "Szovjetunió", 1974, "Izhmash/Kalashnikov", 3.3, 415, 650, R.drawable.ak74),
        Weapon("AK-103", "Gépkarabély", "7.62x39mm", "Oroszország", 1994, "Kalashnikov Concern", 3.6, 415, 600, R.drawable.ak103),
        Weapon("AK-12", "Gépkarabély", "5.45x39mm", "Oroszország", 2012, "Kalashnikov Concern", 3.3, 415, 650, R.drawable.ak12),
        Weapon("AK-63F", "Gépkarabély", "7.62x39mm", "Magyarország", 1977, "FÉG", 3.8, 415, 650, R.drawable.ak63f),
        Weapon("AK-63D", "Gépkarabély", "7.62x39mm", "Magyarország", 1977, "FÉG", 3.5, 415, 650, R.drawable.ak63d),
        Weapon("M16A1", "Gépkarabély", "5.56x45mm NATO", "USA", 1964, "Colt", 3.4, 508, 700, R.drawable.m16a1),
        Weapon("M4A1", "Gépkarabély", "5.56x45mm NATO", "USA", 1994, "Colt / FN", 3.1, 370, 700, R.drawable.m4a1),
        Weapon("HK416", "Gépkarabély", "5.56x45mm NATO", "Németország", 2005, "Heckler & Koch", 3.6, 368, 850, R.drawable.hk416),
        Weapon("SIG MCX", "Gépkarabély", "5.56x45mm / .300 BLK", "USA", 2015, "SIG Sauer", 3.0, 406, 850, R.drawable.sigmcx),
        Weapon("FAMAS F1", "Gépkarabély", "5.56x45mm NATO", "Franciaország", 1978, "GIAT Industries", 3.6, 488, 900, R.drawable.famas),
        Weapon("FN SCAR", "Gépkarabély", "5.56x45mm / 7.62x51mm", "Belgium / USA", 2004, "FN Herstal / FN America", 3.6, 406, 600, R.drawable.fnscar),
        Weapon("CZ 805 Bren", "Gépkarabély", "5.56x45mm / 7.62x39mm", "Csehország", 2011, "Česká Zbrojovka Uherský Brod", 3.6, 360, 700, R.drawable.cz805bren),
        Weapon("CZ Bren 2", "Gépkarabély", "5.56x45mm / 7.62x39mm", "Csehország", 2016, "Česká Zbrojovka Uherský Brod", 3.3, 357, 850, R.drawable.czbren2),

        // ---- PISZTOLYOK ----
        Weapon("Glock 17", "Pisztoly", "9x19mm", "Ausztria", 1982, "Glock Ges.m.b.H.", 0.905, 114, 1200, R.drawable.glock17),
        Weapon("Beretta M9", "Pisztoly", "9x19mm", "Olaszország / USA", 1985, "Beretta", 0.95, 125, 1100, R.drawable.m9),
        Weapon("Desert Eagle", "Pisztoly", ".50 AE", "Izrael / USA", 1983, "Magnum Research / IMI", 1.99, 152, 500, R.drawable.deagle),
        Weapon("Colt 1911", "Pisztoly", ".45 ACP", "USA", 1911, "Colt", 1.1, 127, 400, R.drawable.colt1911),
        Weapon("Stechkin APS", "Pisztoly", "9x18mm Makarov", "Szovjetunió", 1951, "Izhevsk Mechanical Plant", 1.22, 140, 750, R.drawable.stechkin),

        // ---- GÉPPISZTOLYOK ----
        Weapon("Uzi", "Géppisztoly", "9x19mm", "Izrael", 1954, "IMI", 3.5, 260, 600, R.drawable.uzi),
        Weapon("MP5", "Géppisztoly", "9x19mm", "Németország", 1966, "Heckler & Koch", 2.9, 225, 800, R.drawable.mp5),
        Weapon("P90", "Géppisztoly", "5.7x28mm", "Belgium", 1990, "FN Herstal", 2.6, 263, 900, R.drawable.p90),
        Weapon("CZ Scorpion EVO 3 A1", "Géppisztoly", "9x19mm", "Csehország", 2009, "Česká Zbrojovka Uherský Brod", 2.8, 196, 1150, R.drawable.czscorpion),
        Weapon("Vector SMG", "Géppisztoly", "9x19mm / .45 ACP", "USA", 2009, "KRISS USA", 2.7, 250, 1000, R.drawable.vector),

        // ---- GÉPPUSKÁK ----
        Weapon("PKM", "Géppuska", "7.62x54mmR", "Szovjetunió", 1969, "Kalashnikov Concern", 7.5, 658, 650, R.drawable.pkm),
        Weapon("M240B", "Géppuska", "7.62x51mm NATO", "USA", 1977, "FN Herstal / U.S. Ordnance", 12.5, 630, 650, R.drawable.m240b),

        // ---- MESTERLÖVÉSZ PUSKÁK ----
        Weapon("Dragunov SVD", "Mesterlövész puska", "7.62x54mmR", "Szovjetunió", 1963, "Kalashnikov Concern", 4.3, 620, 30, R.drawable.svd),
        Weapon("M24 SWS", "Mesterlövész puska", "7.62x51mm NATO", "USA", 1988, "Remington Arms", 5.4, 610, 20, R.drawable.m24),
        Weapon("Barrett M82", "Mesterlövész puska", ".50 BMG", "USA", 1989, "Barrett Firearms", 13.6, 737, 40, R.drawable.barret),
        Weapon("Accuracy International AWM", "Mesterlövész puska", ".338 Lapua", "Egyesült Királyság", 1990, "Accuracy International", 6.5, 686, 20, R.drawable.awm),

        // ---- SÖRÉTES PUSKÁK ----
        Weapon("Benelli M4", "Sörétes puska", "12-gauge", "Olaszország", 1999, "Benelli Armi", 3.8, 470, 120, R.drawable.benellim4),
        Weapon("Remington 870", "Sörétes puska", "12-gauge", "USA", 1950, "Remington Arms", 3.2, 470, 40, R.drawable.r870),

        // ---- RAKÉTA- ÉS GRÁNÁTAVETŐK ----
        Weapon("RPG-7", "Páncéltörő (rakétavető)", "40mm (PG-7V)", "Szovjetunió", 1961, "Bazalt / Various", 7.0, 400, 1, R.drawable.rpg7),
        Weapon("AT4", "Páncéltörő (egyszer használatos)", "84mm", "Svédország", 1987, "SAAB Bofors Dynamics", 6.7, 100, 1, R.drawable.at4),
        Weapon("FGM-148 Javelin", "Páncéltörő irányított", "127mm rakéta", "USA", 1996, "Raytheon / Lockheed Martin", 22.3, 1050, 1, R.drawable.javelin),
        Weapon("M203", "Gránátvető (alá szerelhető)", "40mm", "USA", 1969, "Winchester / Various", 1.4, 305, 6, R.drawable.m203),
        Weapon("MK 19", "Automata gránátvető", "40×53mm", "USA", 1968, "Saco Defense / General Dynamics", 35.0, 400, 325, R.drawable.mk19),

        // ---- KLASSZIKUS ----
        Weapon("Thompson M1A1", "Géppisztoly", ".45 ACP", "USA", 1942, "Auto-Ordnance", 4.8, 267, 600, R.drawable.thompson),
        Weapon("M1 Garand", "Félautomata puska", ".30-06", "USA", 1936, "Springfield Armory", 4.3, 610, 40, R.drawable.m1)
    )
}
