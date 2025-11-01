package com.example.weaphones

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class WeaponAdapter(private val context: Context, private val weapons: List<Weapon>) : BaseAdapter() {

    override fun getCount(): Int = weapons.size
    override fun getItem(position: Int): Any = weapons[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_weapon, parent, false)

        val weapon = weapons[position]

        val nameText: TextView = view.findViewById(R.id.weaponName)
        val detailsText: TextView = view.findViewById(R.id.weaponDetails)

        nameText.text = weapon.name
        detailsText.text = "${weapon.caliber} • ${weapon.origin} • ${weapon.year}"

        view.setOnClickListener {
            val intent = Intent(context, WeaponDetailActivity::class.java)
            intent.putExtra("name", weapon.name)
            intent.putExtra("category", weapon.category)
            intent.putExtra("caliber", weapon.caliber)
            intent.putExtra("origin", weapon.origin)
            intent.putExtra("year", weapon.year)
            intent.putExtra("manufacturer", weapon.manufacturer)
            intent.putExtra("weight", weapon.weightKg)
            intent.putExtra("barrel", weapon.barrelLengthMm)
            intent.putExtra("rof", weapon.rateOfFire)
            intent.putExtra("imageResId", weapon.imageResId)
            context.startActivity(intent)
        }

        return view
    }
}
