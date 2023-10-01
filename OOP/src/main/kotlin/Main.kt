import exampleClasses.Aquarium
import exampleClasses.GoldColor
import exampleClasses.Plecostomus
import exampleClasses.Shark

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
    val shark = Shark("sardine")
    val pleco = Plecostomus()
    GoldColor.color = "GOLD"

    println("Shark: ${shark.color}")
    shark.eat()

    println("Plecostomus: ${pleco.color}")
    pleco.eat()

}