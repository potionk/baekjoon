package bj28353

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted()
    var startIdx = 0
    var endIdx = n - 1
    var result = 0
    while (startIdx < endIdx) {
        if (arr[startIdx] + arr[endIdx] <= k) {
            result++
            startIdx++
            endIdx--
        } else {
            endIdx--
        }
    }
    println(result)
}
