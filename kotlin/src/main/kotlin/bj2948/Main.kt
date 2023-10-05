package bj2948

import java.io.*
import java.time.LocalDate

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (day, month) = br.readLine().split(" ").map { it.toInt() }
    val date = LocalDate.of(2009, month, day)
    println(date.dayOfWeek.name.lowercase().capitalize())
}
