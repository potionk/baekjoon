package bj13144

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val set = mutableSetOf<Int>()
    var left = 0
    var right = 0
    var count = 0L
    while (right < n) {
        if (set.contains(list[right])) {
            set.remove(list[left])
            left++
        } else {
            set.add(list[right])
            right++
            count += right - left
        }
    }
    println(count)
}
