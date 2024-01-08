package bj6159

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(br.readLine().toInt())
    }
    list.sort()
    var count = 0
    var start = 0
    var end = n - 1
    while (start < end) {
        if (list[start] + list[end] <= s) {
            count += end - start
            start++
        } else {
            end--
        }
    }
    println(count)
}
