package exampleClasses

import java.lang.StringBuilder
import kotlin.math.PI

/**
 * Use 'Open' keyword that the class can be a Subclass
 */
open class Aquarium (
    open var length: Int = 100,
    open var width: Int = 20,
    open var height: Int = 100) {

    var setterVals: String = ""

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    val valForGetter: String
        get() = "valForGetter"

    var varForSetter: String
        get() = "varForSetter"
        private set(value) {
            varForSetter = value
        }

    init {
        println("Initializing Aquarium Class.....")
    }

    init {
        println("Volume: ${width * length * height / 1000} 1")
    }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

    // order of the params can be ignored when you inset with variable named.
    fun buildAquarium(){
        val mAquarium1 = Aquarium()
        mAquarium1.printSize("mAquarium1")

        val mAquarium2 = Aquarium(width = 25)
        mAquarium2.printSize("mAquarium2")

        val mAquarium3 = Aquarium(length = 110, height = 35)
        mAquarium3.printSize("mAquarium3")

        val mAquarium4 = Aquarium(length = 110, width = 25, height = 35)
        mAquarium4.printSize("mAquarium4")

        // Secondary Constructor
        val mAquarium6 = Aquarium(numberOfFish = 29)
        mAquarium6.printSize("mAquarium6")
        mAquarium6.volume = 70
        mAquarium6.printSize("mAquarium6")
    }

    fun printSize(currentVariable: String){

        val sb: StringBuilder = StringBuilder()

        sb.append("currentClassVar: $currentVariable \n" +
                "Width: $width cm \n" +
                "Height: $height cm \n" +
                "Length: $length cm \n")

        println(sb.toString())
        println("Volume : $volume 1")
    }

    fun buildAquariumWithShape(){
        val aquarium7 = Aquarium(length = 25, width = 25, height = 40)
        aquarium7.printSizeWithShape()

        val towerTank = TowerTank(diameter = 25, height = 40)
        towerTank.printSizeWithShape()
    }
    fun printSizeWithShape(){
        println(shape)

        val sb: StringBuilder = StringBuilder()
        sb.append(
                "Width: $width cm \n" +
                "Height: $height cm \n" +
                "Length: $length cm \n")
        println(sb.toString())

        println("Volume: $volume 1 Water: $water 1 (${water/volume*100.0})% full")
    }

}

class TowerTank(override var height: Int, var diameter: Int) : Aquarium(height = height, width = diameter, length = diameter){

    override var volume: Int
        get() = (width/2 * length/2 * height/1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8

    override var shape = "cylinder"

}