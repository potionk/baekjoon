package bj27245

import java.io.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val w = br.readLine().toInt()
    val l = br.readLine().toInt()
    val h = br.readLine().toInt()
    println(
        if (min(w, l) / h >= 2 && max(w, l) / min(w, l) <= 2) {
            "good"
        } else {
            "bad"
        }
    )
}
