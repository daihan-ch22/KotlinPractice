class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)


    /**
     * Singleton 객체를 만들려면 앞에 object만 붙여주면 된다. (object class StudentProgress X)
     *
     * 다른 클래스나 외부에서 singleton객체를 사용하려면 그 앞에 companion키워드를 붙여준다.
     */
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main(args: Array<String>){
    println("${Quiz.answered} of ${Quiz.total} answered.")
}