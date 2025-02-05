package bj33277

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val currentMin = 1440.0 * m / n
    fun minToTime(min: Int): String {
        val h = min / 60
        val m = min % 60
        return "${h.toString().padStart(2, '0')}:${m.toString().padStart(2, '0')}"
    }
    println(minToTime(currentMin.toInt()))
}
