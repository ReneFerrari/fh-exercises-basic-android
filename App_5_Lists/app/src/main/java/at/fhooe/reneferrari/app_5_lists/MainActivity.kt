package at.fhooe.reneferrari.app_5_lists

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    /**
     *
     * How to run each example (currently the most complex one is "enabled"):
     *
     * To show scrollview just use
     * R.layout.activity_main_vertical_finite_list
     *
     * To show scrollview w. horizontalscrollview combined just use
     * R.layout.activity_main_vertical_and_horizontal_list_combined
     *
     * For all the other examples use
     * R.layout.activity_main
     *
     *
     * Vertical list w items sharing design
     *         recyclerView.layoutManager = LinearLayoutManager(
     *             this,
     *             LinearLayoutManager.VERTICAL,
     *             false
     *         )
     *
     *        recyclerView.adapter = ChatAdapter(
     *             chatEntries = generateDummyData()
     *         )
     *
     * Horizontal list w items sharing design
     *         recyclerView.layoutManager = LinearLayoutManager(
     *             this,
     *             LinearLayoutManager.HORIZONTAL,
     *             false
     *         )
     *        recyclerView.adapter = FollowingAdapter(
     *             followingEntries = generateDummyDataFollowing()
     *         )
     *
     *
     * Vertical list w items w different designs
     *         recyclerView.layoutManager = LinearLayoutManager(
     *             this,
     *             LinearLayoutManager.VERTICAL,
     *             false
     *         )
     *         recyclerView.adapter = ChatMessagesAdapter(
     *             chatMessages = generateDummyDataChatMessage()
     *         )
     *
     * Complex vertical list with multiple columns in which each entry differs in size
     *        recyclerView.layoutManager = StaggeredGridLayoutManager(
     *             2,
     *             StaggeredGridLayoutManager.VERTICAL
     *         )
     *         recyclerView.adapter = StaggeredGridAdapter(
     *             texts = generateDummyDataTexts(),
     *             onItemClick = {}
     *         )
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_activitymain)

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val items: MutableList<ChatMessage> = generateDummyDataChatMessage().toMutableList()
        val adapter =  ChatMessagesAdapter(
            chatMessages = items
        )
        recyclerView.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fab_activitymain).setOnClickListener {
            items.add(ChatMessage(
                message = "CLICKED :)",
                time = "infinite",
                wasReceived = false
            ))

            adapter.notifyItemInserted(
                items.count() - 1
            )
            recyclerView.scrollToPosition(items.count() - 1)
        }

        recyclerView.addItemDecoration(
            VerticalMarginItemDecoration(8.asDp())
        )
    }

    private class VerticalMarginItemDecoration(private val verticalSpacing: Int): ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {

            if (parent.getChildAdapterPosition(view) != state.itemCount -1) {
                outRect.bottom = verticalSpacing
            }
        }
    }

    private fun Int.asDp(): Int = (this * this@MainActivity.resources.displayMetrics.density).toInt()

    private fun generateDummyData() = (1..1000).map { index ->
        ChatEntry(
            avatarColor = Random.nextInt(),
            name = "Chat $index",
            lastMessage = "Last message $index",
            timeOfLastMessage = "$index pm"
        )
    }

    private fun generateDummyDataFollowing() = (1..1000).map { index ->
        FollowingEntry(
            color = Random.nextInt()
        )
    }

    private fun generateDummyDataChatMessage() = (1..20).map { index ->
        ChatMessage(
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.".take(
                (index % 100).coerceAtLeast(20)
            ),
            time = "$index pm",
            wasReceived = Random.nextBoolean()
        )
    }

    private val texts = listOf(
        "asdf",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed ",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    )

    private fun generateDummyDataTexts() = (1..1000).map { index ->
        texts[index % texts.count()]
    }

}

