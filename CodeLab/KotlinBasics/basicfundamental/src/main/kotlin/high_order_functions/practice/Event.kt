package high_order_functions.practice

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: DayPart,
    val durationInMinutes: Int
)