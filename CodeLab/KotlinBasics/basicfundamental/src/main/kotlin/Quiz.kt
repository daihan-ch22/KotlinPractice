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

/**
 * 확장 속성 추가
 * 데이터 저장은 안되기때문에 get만 사용 가능하다.
 */
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered."

/**
 * 확장 함수
 * 클래스 내부에는 정의 되어있지 않지만 실제 내부 메서드가 있는 것 처럼 동작한다.
 */
fun Quiz.StudentProgress.printProgressBar(){
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}

fun main(args: Array<String>){
    Quiz.printProgressBar()
}