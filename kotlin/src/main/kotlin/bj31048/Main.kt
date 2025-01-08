package bj31048

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        var num = 1
        val s = br.readLine().toInt()
        for (i in 1..s) {
            num = num * i % 10
        }
        println(num)
    }
}
