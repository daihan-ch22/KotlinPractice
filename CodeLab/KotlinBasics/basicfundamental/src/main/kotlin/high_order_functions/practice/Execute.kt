package high_order_functions.practice

import high_order_functions.forEach

object Execute {
    fun getAllEvents(): List<Event> {
        val event1 =
            Event(title = "Wake up", description = "Time to get up", daypart = DayPart.MORNING, durationInMinutes = 0)
        val event2 = Event(title = "Eat breakfast", daypart = DayPart.MORNING, durationInMinutes = 15)
        val event3 = Event(title = "Learn about Kotlin", daypart = DayPart.AFTERNOON, durationInMinutes = 30)
        val event4 = Event(title = "Practice Compose", daypart = DayPart.AFTERNOON, durationInMinutes = 60)
        val event5 = Event(title = "Watch latest DevBytes video", daypart = DayPart.AFTERNOON, durationInMinutes = 10)
        val event6 =
            Event(title = "Check out latest Android Jetpack library", daypart = DayPart.EVENING, durationInMinutes = 45)

        return mutableListOf(event1, event2, event3, event4, event5, event6)
    }

    fun getShortEvents(list: List<Event>): List<Event> {
        return list.filter {
            it.durationInMinutes < 60
        }
    }

    fun getEventsGroupByDayPart(list: List<Event>): Unit {
        val group = list.groupBy {
            it.daypart
        }
        group.forEach { (daypart, events) ->
            println("$daypart: ${events.size} events")
        }
    }

    fun getLastEvent(list: List<Event>): Unit {
        //println("Last event of the day: ${list[list.size-1].title}")
        println("Last event of the day: ${list.last().title}")
    }

    fun getDurationOfEvent(list: List<Event>): Unit{
        println("Duration of first event of the day: ${list[0].durationOfEvent}")
    }

}

val Event.durationOfEvent: String
    get() =
        if (this.durationInMinutes < 60) {
            "short"
        } else {
            "long"
        }

fun main() {
    val eventList = Execute.getAllEvents()
    val shortEventList = Execute.getShortEvents(eventList)
    println("You have ${shortEventList.size} short events")
    println()
    Execute.getEventsGroupByDayPart(eventList)
    println()
    Execute.getLastEvent(eventList)
    println()
    Execute.getDurationOfEvent(eventList)
}



