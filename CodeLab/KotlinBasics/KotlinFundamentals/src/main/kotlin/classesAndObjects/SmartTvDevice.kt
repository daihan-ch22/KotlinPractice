package classesAndObjects

class SmartTvDevice (deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    override val deviceType: String = "Smart TV"

    override fun turnOn() {
        super.turnOn()
        println("Smart TV turned on. Speaker volume set to $speakerVolume.")
    }

    override fun turnOff() {
        super.turnOff()
        println("Smart TV turned off.")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume(){
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel(){
        channelNumber++
    }

    fun previousChannel(){
        channelNumber--
    }

}