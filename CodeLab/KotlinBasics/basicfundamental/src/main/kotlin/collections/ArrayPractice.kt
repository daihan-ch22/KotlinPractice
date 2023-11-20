package collections

class ArrayPractice {
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    val solarSystem = rockPlanets + gasPlanets

    fun printAllPlanets(){
        println(solarSystem[0])
        println(solarSystem[1])
        println(solarSystem[2])
        println(solarSystem[3])
        println(solarSystem[4])
        println(solarSystem[5])
        println(solarSystem[6])
        println(solarSystem[7])

        println()

        solarSystem[3] = "Little Earth"
        println("solarSystem[3] = ${solarSystem[3]}")
    }
}

fun main(){
    ArrayPractice().apply {
        printAllPlanets()
    }
}