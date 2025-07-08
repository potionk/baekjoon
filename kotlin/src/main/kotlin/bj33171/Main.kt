package bj33171

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    var count = 0
    for (i in 1..n) {
        if ((i % a == 0) xor (i % b == 0)) count++
    }
    println(count)
}
