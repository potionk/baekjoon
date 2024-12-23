package bj9728

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1..t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val list = br.readLine().split(" ").map { it.toInt() }
        var start = 0
        var end = n - 1
        var result = 0
        while (start <= end) {
            if (list[start] + list[end] == m) {
                result++
                start++
                end--
            } else if (list[start] + list[end] < m) {
                start++
            } else {
                end--
            }
        }
        println("Case #$i: $result")
    }
}
