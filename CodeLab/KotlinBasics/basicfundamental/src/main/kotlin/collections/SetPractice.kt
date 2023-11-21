package collections

import java.util.*

class SetPractice {

    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")



    fun printSolarSystem(): Unit{
        println("Solar System normal = $solarSystem")
    }

    fun getSolarSystemSize(): Unit{
        solarSystem.add("Pluto")
        println("Solar System Size = ${solarSystem.size}")
    }

    fun deletePluto(): Unit{
        solarSystem.remove("Pluto")
    }

}


fun main(){
    SetPractice().apply {
        printSolarSystem()
        getSolarSystemSize()
        deletePluto()
        printSolarSystem()
    }

}