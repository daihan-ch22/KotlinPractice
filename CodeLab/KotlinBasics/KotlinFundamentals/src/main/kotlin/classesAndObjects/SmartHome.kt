package classesAndObjects

class SmartHome (
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv(){
        smartTvDevice.turnOn()
    }

    fun turnOffTv(){
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext(){
        smartTvDevice.nextChannel()
    }

    fun turnOnLight(){
        smartLightDevice.turnOn()
    }

    fun turnOffLight(){
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices(){
        smartTvDevice.turnOff()
        smartLightDevice.turnOff()
    }
}