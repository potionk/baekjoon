package bj14656

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val students = br.readLine().split(" ").map { it.toInt() }
    var count = 0
    for (i in 1..n) {
        if (students[i - 1] != i) {
            count++
        }
    }
    println(count)
}
