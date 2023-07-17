package bj4696

import java.io.*
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val n = br.readLine().toDouble()
        if (n == 0.0) {
            break
        }
        println(String.format("%.2f", 1 + n + n * n + n * n * n + n * n * n * n))
    }
    br.close()
}
