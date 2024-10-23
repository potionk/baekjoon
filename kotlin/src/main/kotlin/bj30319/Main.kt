package bj30319

import java.io.*
import java.time.LocalDate

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (y, m, d) = br.readLine().split("-").map { it.toInt() }
    val date = LocalDate.of(y, m, d)
    if (date.isAfter(LocalDate.of(2023, 10, 21).minusDays(35))) {
        println("TOO LATE")
    } else {
        println("GOOD")
    }
}
