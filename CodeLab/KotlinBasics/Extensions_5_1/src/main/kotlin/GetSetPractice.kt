class GetSetPractice(val name: String, val category: String){
    var speakerVolumn = 2
        get() = field
        set(value) {
            if(value in 1..100){
                field = value
            }
        }

    var deviceStatus: String = "Online"

    constructor(name: String, category: String, statusCode: Int) : this(name, category){
        deviceStatus = when(statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    fun getDeviceStatus1(): String {
        return deviceStatus
    }
}