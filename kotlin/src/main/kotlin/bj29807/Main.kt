package bj29807

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    var score = 0
    if (arr.size >= 3) {
        score += if (arr[0] > arr[2]) {
            (arr[0] - arr[2]) * 508
        } else {
            (arr[2] - arr[0]) * 108
        }
    } else {
        score += arr[0] * 508
    }
    if (arr.size >= 4) {
        score += if (arr[1] > arr[3]) {
            (arr[1] - arr[3]) * 212
        } else {
            (arr[3] - arr[1]) * 305
        }
    } else {
        if (arr.size >= 2) {
            score += arr[1] * 212
        }
    }
    if (arr.size >= 5) {
        score += arr[4] * 707
    }
    println(score * 4763)
}
