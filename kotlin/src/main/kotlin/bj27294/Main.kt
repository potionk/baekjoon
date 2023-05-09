package bj27294

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (t, s) = br.readLine().split(" ").map { it.toInt() }
    if (s == 1 || !isLunch(t)) {
        println(280)
    } else {
        println(320)
    }
    br.close()
}

fun isLunch(time: Int): Boolean {
    return time in 12..16
}
