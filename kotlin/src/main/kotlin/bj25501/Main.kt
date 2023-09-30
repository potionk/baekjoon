package bj25501

import java.io.BufferedReader
import java.io.InputStreamReader

var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        count = 0
        println("${isPalindrome(br.readLine())} $count")
    }
}

fun recursion(s: String, l: Int, r: Int): Int {
    count++
    return if (l >= r) 1 else if (s[l] != s[r]) 0 else recursion(s, l + 1, r - 1)
}

fun isPalindrome(s: String): Int {
    return recursion(s, 0, s.length - 1)
}
