package bj22862

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    var answer = 0
    var oddCount = 0
    var left = 0
    var right = 0
    while (right < n) {
        if (list[right] % 2 == 1) {
            oddCount++
        }
        if (oddCount > k) {
            while (list[left] % 2 == 0) {
                left++
            }
            left++
            oddCount--
        }
        answer = maxOf(answer, right - left + 1 - oddCount)
        right++
    }
    println(answer)
}
