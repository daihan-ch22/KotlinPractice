package practiceSession

class MovieTicketPrice : AnswerTemplate {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    override fun executeAnswer() {
        println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
        println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
        println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
    }

    private fun ticketPrice(age: Int, isMonday: Boolean): Int {
        when(isMonday){
            true -> return rate(age, isMonday)
            false -> return rate(age, isMonday)
            else -> return -1
        }
    }

    private fun rate(age: Int, isMonday: Boolean): Int{
        var rate = 0
        if(age in 1..12){
            rate = 15
        } else if(age in 13..60){
            rate = 30
            if(isMonday) rate = 25
        } else if(age < 100){
            rate = 20
        } else {
            rate = -1
        }
        return rate
    }
}