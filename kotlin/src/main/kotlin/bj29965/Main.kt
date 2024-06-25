package bj29965

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var mCount = 0
    var jCount = 0
    var mTotal = 0L
    var jTotal = 0L
    val n = br.readLine().toInt()
    repeat(n) {
        val (person, score) = br.readLine().split(" ")
        if (person == "M") {
            mCount++
            mTotal += score.toLong()
        } else if (person == "J") {
            jCount++
            jTotal += score.toLong()
        }
    }
    if (mCount == 0) {
        mCount = 1
    }
    if (jCount == 0) {
        jCount = 1
    }
    val mAvg = mTotal.toDouble() / mCount
    val jAvg = jTotal.toDouble() / jCount
    println(
        if (mAvg > jAvg) {
            "M"
        } else if (mAvg < jAvg) {
            "J"
        } else {
            "V"
        }
    )
}
