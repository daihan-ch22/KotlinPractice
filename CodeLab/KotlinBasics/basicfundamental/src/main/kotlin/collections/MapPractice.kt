package collections

class MapPractice {

    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )


    fun setPluto(): Unit {
        solarSystem["Pluto"] = 5
    }

    fun getSolarSystemSize(): Unit{
        println(solarSystem.size)
    }

}

fun main(){
    MapPractice().apply {
        getSolarSystemSize()
        setPluto()
        getSolarSystemSize()
        println(solarSystem["Pluto"])
        println(solarSystem["2"])
    }
}