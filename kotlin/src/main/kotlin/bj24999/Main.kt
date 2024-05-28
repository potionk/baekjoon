package bj24999

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    val doubleArr = arr + arr
    var sum = doubleArr.subList(0, n).sum()
    var max = sum
    for (i in 0 until 2 * k - n) {
        sum += doubleArr[i + n] - doubleArr[i]
        max = max.coerceAtLeast(sum)
    }
    println(max)
}
