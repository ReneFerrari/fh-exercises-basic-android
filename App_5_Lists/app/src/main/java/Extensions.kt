import android.content.Context
import android.util.TypedValue

fun Number.dp(context: Context) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics).toInt()