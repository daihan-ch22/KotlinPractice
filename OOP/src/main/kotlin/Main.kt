import exampleClasses.Aquarium
import exampleClasses.Plecostomus
import exampleClasses.Shark


interface FishAction{
    fun eat()
}

fun main(args: Array<String>) {
    println("=== Kotlin Class Practice - Aquarium ===")

    var mAquarium = Aquarium()

    mAquarium.buildAquarium().run {

    }

    mAquarium.buildAquariumWithShape()

    println("==========ABSTRACT CLASS STARTS===========")
    makeFish()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}