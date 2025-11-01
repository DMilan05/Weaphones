package com.example.weaphones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class WeaponAdapter(
    context: Context,
    private val weapons: List<Weapon>
) : ArrayAdapter<Weapon>(context, 0, weapons) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_weapon, parent, false)

        val weapon = weapons[position]

        val nameText: TextView = itemView.findViewById(R.id.weaponName)
        val caliberText: TextView = itemView.findViewById(R.id.weaponCaliber)
        val originText: TextView = itemView.findViewById(R.id.weaponOrigin)

        nameText.text = weapon.name
        caliberText.text = "Kaliber: ${weapon.caliber}"
        originText.text = "Származás: ${weapon.origin}\n" +
                "Gyártó: ${weapon.manufacturer}\n" +
                "Gyártás éve: ${weapon.year}\n" +
                "Súly: ${weapon.weightKg} kg\n" +
                "Tűzgyorsaság: ${weapon.rateOfFire} lövés/perc"


        return itemView
    }
}
