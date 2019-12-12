import java.net.URI

data class Advertisement(
    val title: String,
    val priceLine: String,
    val address: String,
    val link: URI
//    val images: List<URI>
)