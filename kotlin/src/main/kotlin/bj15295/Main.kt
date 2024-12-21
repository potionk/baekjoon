package bj15295

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (k, n) = br.readLine().split(" ").map { it.toInt() }
        var result = n
        for (i in 1..n) {
            result += i
        }
        println("$k $result")
    }
}
