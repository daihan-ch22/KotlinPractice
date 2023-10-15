package practiceSession

class Song_Catalog(
    private val title: String,
    private val artist: String,
    private val year_published: Int,
    private val playCounts: Int
) : AnswerTemplate {

    private var isPopular = false

    override fun executeAnswer() {
        printSongInfo()
    }

    private fun printSongInfo(){

        if(playCounts > 1000){
            isPopular = true
        }

        println("$title, performed by $artist, was released in $year_published.")

        if(isPopular){
            println("Popularity: HIGH, PlayCounts = $playCounts")
        } else {
            println("Popularity: HIGH, PlayCounts = $playCounts")
        }

    }
}