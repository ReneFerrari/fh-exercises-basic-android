package at.fhooe.reneferrari.app_5_lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StaggeredGridAdapter(
    val texts: List<String>,
    val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<GridEntryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridEntryViewHolder {
        return GridEntryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_gridentry, parent, false)
        )
    }

    override fun getItemCount(): Int = texts.count()

    override fun onBindViewHolder(holder: GridEntryViewHolder, position: Int) {
        holder.bind(texts[position], onItemClick)
    }
}

