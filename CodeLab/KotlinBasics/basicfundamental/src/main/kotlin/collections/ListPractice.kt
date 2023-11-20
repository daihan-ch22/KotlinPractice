package collections

/**
 * List는 기본적으로 val로 설정되는데 수정하거나 하고 싶으면 MutableList를 사용한다.
 *
 * element가 있는지 찾아보려면 in 키워드 사용한다.
 */
class ListPractice {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    fun iteration(){
        for(planet in solarSystem){
            println(planet)
        }
    }
}

fun main(){
    ListPractice().apply {
        println(solarSystem.size)
        println(solarSystem[2])
        println(solarSystem.get(3))

        println()

        println("solarSystem.indexOf(Earth) = ${solarSystem.indexOf("Earth")}")
        println("solarSystem.indexOf(Pluto) = ${solarSystem.indexOf("Pluto")}") //no element returns -1

        iteration()
    }
}