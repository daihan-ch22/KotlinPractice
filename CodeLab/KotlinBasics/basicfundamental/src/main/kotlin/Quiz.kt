class Quiz : ProgressPrintable {
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

    override val progressText: String
        get() = "${answered} of ${total} answered."

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    /**
     * 범위함수 let, apply ...등 정리할것
     */
    fun printQuiz(){
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

}

/**
 * 확장 속성 추가
 * 데이터 저장은 안되기때문에 get만 사용 가능하다.
 * ** 확장 속성 추가는 이미 정의된 클래스에 기능을 추가할 수 있는 방법이지만
 * ** 소스에 접근이 가능한 경우 꼭 필요하진 않다.
 * ** 오히려 소스를 이해하는데 추가적인 어려움이 있을 수 있다.
 * ** 확장 속성 추가는 인터페이스 사용으로 대체 가능하다.
 */
//val Quiz.StudentProgress.progressText: String
//    get() = "${answered} of ${total} answered."

/**
 * 확장 함수
 * 클래스 내부에는 정의 되어있지 않지만 실제 내부 메서드가 있는 것 처럼 동작한다.
 * ** 확장 속성 추가처럼 인터페이스로 대체 가능
 */
//fun Quiz.StudentProgress.printProgressBar(){
//    repeat(Quiz.answered) { print("▓") }
//    repeat(Quiz.total - Quiz.answered) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}



fun main(args: Array<String>){

    val quiz = Quiz().apply {
        printQuiz()
    }

    quiz.printProgressBar()

}