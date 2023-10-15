package practiceSession

class Mobile_Notification: AnswerTemplate {
    private val morningNotification = 51
    private val eveningNotification = 135

    override fun executeAnswer() {
        printNotificationSummary(morningNotification)
        printNotificationSummary(eveningNotification)
    }

    private fun printNotificationSummary(numberOfMessages: Int){
        if(numberOfMessages < 100){
            println("You have $numberOfMessages notifications.")
        } else {
            println("Your phone is blowing up! You have 99+ notifications")
        }
    }
}

