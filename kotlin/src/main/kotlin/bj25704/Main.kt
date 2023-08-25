package bj25704

import java.io.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val p = br.readLine().toInt()
    println(
        if (n >= 20) {
            min((p * 0.75).toInt(), max(p - 2000, 0))
        } else if (n >= 15) {
            min(max(p - 2000, 0), (p * 0.9).toInt())
        } else if (n >= 10) {
            min((p * 0.9).toInt(), max(p - 500, 0))
        } else if (n >= 5) {
            max(p - 500, 0)
        } else {
            p
        }
    )
}
