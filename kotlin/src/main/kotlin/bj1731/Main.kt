package bj1731

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = IntArray(n)
    for (i in 0 until n) {
        numbers[i] = br.readLine().toInt()
    }
    print(
        if (numbers[1] - numbers[0] == numbers[2] - numbers[1]) {
            val diff = numbers[1] - numbers[0]
            numbers[n - 1] + diff
        } else {
            val diff = numbers[1] / numbers[0]
            numbers[n - 1] * diff
        }
    )
}
