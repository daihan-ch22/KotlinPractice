package classesAndObjects

class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory){

    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    override val deviceType: String = "Smart Light"

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("Smart Light turned on. The brightness level is set to $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off.")
    }

    fun increaseBrightness(){
        brightnessLevel++
    }

    fun decreaseBrightness(){
        brightnessLevel--
    }
}