package com.example.tp1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView


class AdapterItem(private val dataset: MutableList<Item>): RecyclerView.Adapter<AdapterItem.ItemViewHolder>()  {
    val checkStatus: HashMap<Int, Boolean> = HashMap() // store the check status for all checkboxes
    val CAT: String = "TODO_ITEM"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(itemView = inflater.inflate(R.layout.list, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind((dataset[position]))
        holder.cbView.setOnCheckedChangeListener(null)
        holder.cbView.setChecked(checkStatus.get(position) == true);
        holder.cbView.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            checkStatus.put(position, isChecked)
        })
    }

    override fun getItemCount() = dataset.size

    public fun addData(text: String) {
        // add data in the list to display
        dataset.add(Item(text))
        checkStatus.put(dataset.size, false)
        notifyItemChanged(dataset.size)
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cbView = itemView.findViewById<CheckBox>(R.id.Object)

        fun bind(item: Item) {
            cbView.text = item.itemTextStr
        }
    }


}
