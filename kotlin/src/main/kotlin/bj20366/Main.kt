package bj20366

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    var result = Int.MAX_VALUE
    fun findMin(selectIdx1: Int, selectIdx2: Int, selectedTotal: Int): Int {
        var left = 0
        var right = arr.size - 1
        var minDiff = Int.MAX_VALUE
        while (left < right) {
            if (left == selectIdx1 || left == selectIdx2) {
                left++
                continue
            }
            if (right == selectIdx2 || right == selectIdx1) {
                right--
                continue
            }
            val diff = selectedTotal - arr[left] - arr[right]
            if (diff < 0) {
                right--
            } else {
                left++
            }
            minDiff = minOf(minDiff, abs(diff))
        }
        return minDiff
    }
    for (i in 0 until arr.size - 1) {
        for (j in i + 1 until arr.size) {
            result = minOf(result, findMin(i, j, arr[i] + arr[j]))
        }
    }
    println(result)
}
