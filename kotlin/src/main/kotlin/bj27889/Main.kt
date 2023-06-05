package bj27889

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(
        when (br.readLine()) {
            "NLCS" -> "North London Collegiate School"
            "BHA" -> "Branksome Hall Asia"
            "KIS" -> "Korea International School"
            else -> "St. Johnsbury Academy"
        }
    )
    br.close()
}
