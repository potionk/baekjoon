package bj1019

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val countArray = IntArray(10)
    var mul = 1
    var start = 1
    var end = n
    while (start <= end) {
        while (start < 10 && start <= end) {
            count(start, mul, countArray)
            start++
        }
        if (start > end) {
            break
        }
        while (end % 10 != 9 && start <= end) {
            count(end, mul, countArray)
            end--
        }
        val diff = end / 10 - start / 10 + 1
        for (i in countArray.indices) {
            countArray[i] += diff * mul
        }
        mul *= 10
        start /= 10
        end /= 10
    }
    println(countArray.joinToString(" "))
}

private fun count(n: Int, mul: Int, countArray: IntArray) {
    var num = n
    while (num > 0) {
        countArray[num % 10] += mul
        num /= 10
    }
}
