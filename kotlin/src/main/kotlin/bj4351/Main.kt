package bj4351

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val (name, price) = br.readLine().split(" ")
        map[name] = price.toInt()
    }
    repeat(m) {
        var s = br.readLine()
        var result = 0
        while (s != ".") {
            s.split(" ").forEach {
                result += map[it] ?: 0
            }
            s = br.readLine()
        }
        println(result)
    }
}
