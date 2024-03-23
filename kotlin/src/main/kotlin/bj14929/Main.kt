package bj14929

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toLong() }
    var sum = arr.sum()
    var result = 0L
    for (i in 0 until n) {
        sum -= arr[i]
        result += arr[i] * sum
    }
    println(result)
}
