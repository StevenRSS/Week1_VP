package Adapter

import Database.GlobalVar
import Model.Hewan
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1_vp.FormActivity
import com.example.week1_vp.R
import com.example.week1_vp.databinding.CardHewanBinding

class ListHewanAdapter(val listHewan: ArrayList<Hewan>):
        RecyclerView.Adapter<ListHewanAdapter.viewHolder>() {

        class viewHolder (val itemView: View): RecyclerView.ViewHolder(itemView) {
            val binding = CardHewanBinding.bind(itemView)

            fun setData(data: Hewan){
                binding.NamaHewanCard.text = data.namaHewan
                binding.JenisHewanCard.text = data.jenisHewan
                binding.UsiaHewanCard.text = data.usiaHewan.toString()

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHewanAdapter.viewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.card_hewan, parent, false)
            return viewHolder(view)
        }

        override fun onBindViewHolder(holder: ListHewanAdapter.viewHolder, position: Int) {
            holder.setData(listHewan[position])

            with(holder) {
                binding.DeleteButton.setOnClickListener() {
                    GlobalVar.listHewan.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemChanged(position, itemCount)
                }
                binding.EditButton.setOnClickListener() {
                    val myIntent = Intent(it.context, FormActivity::class.java)
                    myIntent.putExtra("position", position)

                    it.context.startActivity(myIntent)

                }
            }
        }

    override fun getItemCount(): Int {
        return listHewan.size
    }
}
