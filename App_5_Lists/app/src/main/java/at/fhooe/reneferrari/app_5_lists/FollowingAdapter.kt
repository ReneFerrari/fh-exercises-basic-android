package at.fhooe.reneferrari.app_5_lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FollowingAdapter(private val followingEntries: List<FollowingEntry>): RecyclerView.Adapter<FollowingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        return FollowingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.vh_following, //layout
                parent, //root
                false //attachToRoot
            )
        )
    }

    override fun getItemCount(): Int = followingEntries.count()

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        holder.bind(followingEntries[position])
    }
}
