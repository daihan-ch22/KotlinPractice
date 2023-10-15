package practiceSession

class Internet_Profile : AnswerTemplate {

    override fun executeAnswer() {

        val amanda = Person("Amanda", 33, "play tennis", null)
        val atiqah = Person("Atiqah", 28, "climb", amanda)

        amanda.showProfile()
        atiqah.showProfile()
    }

    private class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?){
        fun showProfile(){
            println("Name: $name")
            println("Age: $age")
            print("Likes to $hobby. ")

            if(referrer != null){
                print("Has a referrer named ${referrer.name}")
                    if(hobby != null) {
                        println(", who likes to play ${ referrer.hobby }.")
                    }
            } else {
                println("Doesn't have a referrer.")
            }

        }
    }
}