package classesAndObjects

open class SmartDevice protected constructor(val name: String, val category: String) {

    var deviceStatus = "Online"
        protected set(value) {
            field = value
        }
    //or just protected set

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "Offline"
            1 -> "Online"
            else -> "Unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = Constants.DEVICE_ON
    }

    open fun turnOff() {
        deviceStatus = Constants.DEVICE_OFF
    }

    open fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

