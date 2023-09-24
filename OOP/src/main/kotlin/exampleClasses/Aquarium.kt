package exampleClasses

import java.lang.StringBuilder

class Aquarium (
    private var length: Int = 100,
    private var width: Int = 20,
    private var height: Int = 100) {

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
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

}