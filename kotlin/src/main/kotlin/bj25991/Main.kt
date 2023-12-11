package bj25991

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.cbrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val length = br.readLine().split(" ").map { it.toDouble() }
    var total = 0.0
    for (l in length) {
        total += l * l * l
    }
    println(cbrt(total))
}
