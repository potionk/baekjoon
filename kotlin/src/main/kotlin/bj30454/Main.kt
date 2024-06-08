package bj30454

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().split(" ").map { it.toInt() }
    var result = 0
    var maxCount = 0
    repeat(n) {
        val zebra = br.readLine().toCharArray()
        var black = false
        var count = 0
        zebra.forEachIndexed { index, c ->
            if (c == '1') {
                if (!black) {
                    count++
                    black = true
                }
            } else {
                black = false
            }
        }
        if (count > maxCount) {
            maxCount = count
            result = 1
        } else if (count == maxCount) {
            result++
        }
    }
    println("$maxCount $result")
}
