package bj27332

import java.io.*
import java.time.LocalDate

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toLong()
    val date = LocalDate.of(2022, 11, a)
    if (date.plusWeeks(b).monthValue == 11) {
        println("1")
    } else {
        println("0")
    }
}
