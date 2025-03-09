package bj20818

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val length = str.length / 2
    val necklace = str + str
    var max = 0
    var count = 0
    for (i in 0 until length) {
        if (necklace[i] == 'B') {
            count++
        }
    }
    max = count
    for (i in length until necklace.length) {
        if (necklace[i] == 'B') {
            count++
        }
        if (necklace[i - length] == 'B') {
            count--
        }
        max = max.coerceAtLeast(count)
    }
    println(max)
}
