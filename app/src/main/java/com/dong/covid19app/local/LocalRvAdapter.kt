package com.dong.covid19app.local

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dong.covid19app.R
import com.dong.covid19app.local.models.LocalCountyResponse
import com.dong.covid19app.local.models.LocalResponse

class LocalRvAdapter(val context: Context, val local: ArrayList<LocalCountyResponse>) :
    RecyclerView.Adapter<LocalRvAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val newCasenewCase = itemView?.findViewById<TextView>(R.id.newCasenewCase)
        val totalCasetotalCase = itemView?.findViewById<TextView>(R.id.totalCasetotalCase)
        val recoveredrecovered = itemView?.findViewById<TextView>(R.id.recoveredrecovered)
        val deathdeath = itemView?.findViewById<TextView>(R.id.deathdeath)
        val newFcasenewFcase = itemView?.findViewById<TextView>(R.id.newFcasenewFcase)
        val newCcasenewCcase = itemView?.findViewById<TextView>(R.id.newCcasenewCcase)
        val countyName = itemView?.findViewById<TextView>(R.id.countryName)

        fun bind(local: LocalCountyResponse, context: Context) {
            newCasenewCase?.text = local.newCase
            totalCasetotalCase?.text = local.totalCase
            recoveredrecovered?.text = local.recovered
            deathdeath?.text = local.death
            newFcasenewFcase?.text = local.newFcase
            newCcasenewCcase?.text = local.newCcas
            countyName?.text = local.countryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //화면을 최초 로딩하여 만들어진 View가 없는 경우, xml파일을 inflate하여 ViewHolder를 생성한다.
        val view = LayoutInflater.from(context).inflate(R.layout.local_recycler_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(local[position], context)
    }

    override fun getItemCount(): Int {
        //RecyclerView로 만들어지는 item의 총 개수를 반환한다.
        return local.size
    }

}