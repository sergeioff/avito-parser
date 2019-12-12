import org.jsoup.Jsoup
import java.net.URI

val HOST = "https://www.avito.ru/"
val QUERY = "kaluga/kvartiry/sdam/na_dlitelnyy_srok/1-komnatnye?pmax=10000"

fun main() {
    val document = Jsoup.connect(HOST + QUERY).get()
    val items = document?.select(".item__line")?.map {
//        val photos = it.select("[data-marker=item-photo] img")
//            .map { "https:" + it.attr("src") }
//            .filter { it.endsWith("jpg") }

        val title = it.select("[data-marker=item-title] > a").attr("title")
        val link = HOST + it.select("[data-marker=item-title] > a").attr("href")
        val price = it.select("[data-marker=item-price]").text()
        val address = it.select("[data-marker=item-address]").text()

        Advertisement(title, price, address, URI.create(link))
    }

    println(items)
}