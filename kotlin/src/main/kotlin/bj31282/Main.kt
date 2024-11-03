package bj31282

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    var rabbit = n
    var hunter = 0
    var count = 0
    while (hunter < rabbit) {
        hunter += k
        rabbit += m
        count++
    }
    println(count)
}
