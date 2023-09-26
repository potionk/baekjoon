package bj21591

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (wc, hc, ws, hs) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (wc - ws >= 2 && hc - hs >= 2) {
            "1"
        } else {
            "0"
        }
    )
}
