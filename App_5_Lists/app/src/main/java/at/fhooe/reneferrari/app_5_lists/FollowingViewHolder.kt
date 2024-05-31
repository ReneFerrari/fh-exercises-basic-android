package at.fhooe.reneferrari.app_5_lists

import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FollowingViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val cvFollowing: CardView = view.findViewById(R.id.cv_following)

    fun bind(entry: FollowingEntry) {
        cvFollowing.setCardBackgroundColor(entry.color)
    }
}

data class FollowingEntry(
    val color: Int
)

