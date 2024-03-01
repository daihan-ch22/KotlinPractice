package dan.jetpack.section8_paginglv3.new_data

data class GitHubResponse(
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<NewItems>
)