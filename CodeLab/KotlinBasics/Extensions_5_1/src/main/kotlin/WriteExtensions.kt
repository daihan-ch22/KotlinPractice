object WriteExtensions {

    fun writeExtensions(){
        println("Does it have spaces?".simplifyHasSpaces())
    }

    fun String.hasSpaces(): Boolean {
        val found = this.find { it == ' ' }
        return found != null
    }

    fun String.simplifyHasSpaces() = find { it.equals(' ') } != null
}