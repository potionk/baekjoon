package bj32751

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (a, b, c, d) = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine()
    if (s.first() != 'a' || s.last() != 'a') {
        println("No")
        return
    }
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            println("No")
            return
        }
    }
    val countMap = s.groupingBy { it }.eachCount()
    if ((countMap['a'] ?: 0) > a ||
        (countMap['b'] ?: 0) > b ||
        (countMap['c'] ?: 0) > c ||
        (countMap['d'] ?: 0) > d
    ) {
        println("No")
        return
    }
    println("Yes")
}
