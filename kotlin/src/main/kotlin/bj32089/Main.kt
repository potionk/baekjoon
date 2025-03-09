package bj32089

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) break
        val list = br.readLine().split(" ").map { it.toInt() }
        var sum = 0
        var max = 0
        for (i in 0 until 3) {
            sum += list[i]
        }
        max = sum
        for (i in 3 until n) {
            sum += list[i] - list[i - 3]
            max = Math.max(max, sum)
        }
        println(max)
    }
}
