/**
 * Data만 포함하는 케이스기 때문에 data class로 만든다.
 * data 클래스인 경우 코틀린 컴파일러가 특정 가정을 하여 일부 메서드의 자동 구현을 해준다.
 *
 * 구현해주는 메서드
 * equals() <br>
 * hashCode(): 특정 컬렉션 유형을 사용할 때 이 메서드가 표시 <br>
 * toString() <br>
 * componentN(): component1(), component2() 등 <br>
 * copy() <br>
 *
 * 예: println(question1.toString()) <br>
 * 결과: Question(questionText=Quoth the raven ___, answer=nevermore, difficulty=MEDIUM)
 */
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
) {
    //data 클래스는 반드시 매개변수가 하나 이상 들어와야하며
    //val 또는 var로 표시되어야 한다.
    //abstract, open, sealed, inner로 만들 수 없다.
}