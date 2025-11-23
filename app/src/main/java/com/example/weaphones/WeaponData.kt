package com.example.weaphones

object WeaponData {
    val allWeapons = listOf(
        // ---- GÉPKARABÉLYOK ----
        Weapon("AK-47", R.string.cat_ar, "7.62x39mm", R.string.country_ussr, 1947, "Kalashnikov Concern", 4.3, 415, 600, R.drawable.ak47),
        Weapon("AKM", R.string.cat_ar, "7.62x39mm", R.string.country_ussr, 1959, "Kalashnikov Concern", 3.1, 415, 600, R.drawable.akm),
        Weapon("AK-74", R.string.cat_ar, "5.45x39mm", R.string.country_ussr, 1974, "Izhmash/Kalashnikov", 3.3, 415, 650, R.drawable.ak74),
        Weapon("AK-103", R.string.cat_ar, "7.62x39mm", R.string.country_russia, 1994, "Kalashnikov Concern", 3.6, 415, 600, R.drawable.ak103),
        Weapon("AK-12", R.string.cat_ar, "5.45x39mm", R.string.country_russia, 2012, "Kalashnikov Concern", 3.3, 415, 650, R.drawable.ak12),
        Weapon("AK-63F", R.string.cat_ar, "7.62x39mm", R.string.country_hungary, 1977, "FÉG", 3.8, 415, 650, R.drawable.ak63f),
        Weapon("AK-63D", R.string.cat_ar, "7.62x39mm", R.string.country_hungary, 1977, "FÉG", 3.5, 415, 650, R.drawable.ak63d),
        Weapon("M16A1", R.string.cat_ar, "5.56x45mm NATO", R.string.country_usa, 1964, "Colt", 3.4, 508, 700, R.drawable.m16a1),
        Weapon("M4A1", R.string.cat_ar, "5.56x45mm NATO", R.string.country_usa, 1994, "Colt / FN", 3.1, 370, 700, R.drawable.m4a1),
        Weapon("HK416", R.string.cat_ar, "5.56x45mm NATO", R.string.country_germany, 2005, "Heckler & Koch", 3.6, 368, 850, R.drawable.hk416),
        Weapon("SIG MCX", R.string.cat_ar, "5.56x45mm / .300 BLK", R.string.country_usa, 2015, "SIG Sauer", 3.0, 406, 850, R.drawable.sigmcx),
        Weapon("FAMAS F1", R.string.cat_ar, "5.56x45mm NATO", R.string.country_france, 1978, "GIAT Industries", 3.6, 488, 900, R.drawable.famas),
        Weapon("FN SCAR", R.string.cat_ar, "5.56x45mm / 7.62x51mm", R.string.country_belgium, 2004, "FN Herstal", 3.6, 406, 600, R.drawable.fnscar),
        Weapon("CZ 805 Bren", R.string.cat_ar, "5.56x45mm / 7.62x39mm", R.string.country_czech, 2011, "CZUB", 3.6, 360, 700, R.drawable.cz805bren),
        Weapon("CZ Bren 2", R.string.cat_ar, "5.56x45mm / 7.62x39mm", R.string.country_czech, 2016, "CZUB", 3.3, 357, 850, R.drawable.czbren2),

        // ---- PISZTOLYOK ----
        Weapon("Glock 17", R.string.cat_pistol, "9x19mm", R.string.country_austria, 1982, "Glock Ges.m.b.H.", 0.905, 114, 1200, R.drawable.glock17),
        Weapon("Beretta M9", R.string.cat_pistol, "9x19mm", R.string.country_italy, 1985, "Beretta", 0.95, 125, 1100, R.drawable.m9),
        Weapon("Desert Eagle", R.string.cat_pistol, ".50 AE", R.string.country_israel, 1983, "Magnum Research", 1.99, 152, 500, R.drawable.deagle),
        Weapon("Colt 1911", R.string.cat_pistol, ".45 ACP", R.string.country_usa, 1911, "Colt", 1.1, 127, 400, R.drawable.colt1911),
        Weapon("Stechkin APS", R.string.cat_pistol, "9x18mm Makarov", R.string.country_ussr, 1951, "Izhevsk", 1.22, 140, 750, R.drawable.stechkin),

        // ---- GÉPPISZTOLYOK ----
        Weapon("Uzi", R.string.cat_smg, "9x19mm", R.string.country_israel, 1954, "IMI", 3.5, 260, 600, R.drawable.uzi),
        Weapon("MP5", R.string.cat_smg, "9x19mm", R.string.country_germany, 1966, "Heckler & Koch", 2.9, 225, 800, R.drawable.mp5),
        Weapon("P90", R.string.cat_smg, "5.7x28mm", R.string.country_belgium, 1990, "FN Herstal", 2.6, 263, 900, R.drawable.p90),
        Weapon("CZ Scorpion EVO 3", R.string.cat_smg, "9x19mm", R.string.country_czech, 2009, "CZUB", 2.8, 196, 1150, R.drawable.czscorpion),
        Weapon("Vector SMG", R.string.cat_smg, "9x19mm / .45 ACP", R.string.country_usa, 2009, "KRISS USA", 2.7, 250, 1000, R.drawable.vector),

        // ---- GÉPPUSKÁK ----
        Weapon("PKM", R.string.cat_lmg, "7.62x54mmR", R.string.country_ussr, 1969, "Kalashnikov Concern", 7.5, 658, 650, R.drawable.pkm),
        Weapon("M240B", R.string.cat_lmg, "7.62x51mm NATO", R.string.country_usa, 1977, "FN Herstal", 12.5, 630, 650, R.drawable.m240b),

        // ---- MESTERLÖVÉSZ ----
        Weapon("Dragunov SVD", R.string.cat_sniper, "7.62x54mmR", R.string.country_ussr, 1963, "Kalashnikov Concern", 4.3, 620, 30, R.drawable.svd),
        Weapon("M24 SWS", R.string.cat_sniper, "7.62x51mm NATO", R.string.country_usa, 1988, "Remington Arms", 5.4, 610, 20, R.drawable.m24),
        Weapon("Barrett M82", R.string.cat_sniper, ".50 BMG", R.string.country_usa, 1989, "Barrett Firearms", 13.6, 737, 40, R.drawable.barret),
        Weapon("Accuracy Int. AWM", R.string.cat_sniper, ".338 Lapua", R.string.country_uk, 1990, "Accuracy Int.", 6.5, 686, 20, R.drawable.awm),

        // ---- SÖRÉTES ----
        Weapon("Benelli M4", R.string.cat_shotgun, "12-gauge", R.string.country_italy, 1999, "Benelli Armi", 3.8, 470, 120, R.drawable.benellim4),
        Weapon("Remington 870", R.string.cat_shotgun, "12-gauge", R.string.country_usa, 1950, "Remington Arms", 3.2, 470, 40, R.drawable.r870),

        // ---- RAKÉTAVETŐK ----
        Weapon("RPG-7", R.string.cat_launcher, "40mm (PG-7V)", R.string.country_ussr, 1961, "Bazalt", 7.0, 400, 1, R.drawable.rpg7),
        Weapon("AT4", R.string.cat_launcher, "84mm", R.string.country_sweden, 1987, "SAAB Bofors", 6.7, 100, 1, R.drawable.at4),
        Weapon("FGM-148 Javelin", R.string.cat_launcher, "127mm", R.string.country_usa, 1996, "Raytheon", 22.3, 1050, 1, R.drawable.javelin),

        // ---- GRÁNÁTVETŐK  ----
        Weapon("M203", R.string.cat_gl, "40mm", R.string.country_usa, 1969, "Various", 1.4, 305, 6, R.drawable.m203),
        Weapon("MK 19", R.string.cat_gl, "40×53mm", R.string.country_usa, 1968, "General Dynamics", 35.0, 400, 325, R.drawable.mk19),

        // ---- KLASSZIKUS ----
        Weapon("Thompson M1A1", R.string.cat_classic, ".45 ACP", R.string.country_usa, 1942, "Auto-Ordnance", 4.8, 267, 600, R.drawable.thompson),
        Weapon("M1 Garand", R.string.cat_classic, ".30-06", R.string.country_usa, 1936, "Springfield", 4.3, 610, 40, R.drawable.m1)
    )
}