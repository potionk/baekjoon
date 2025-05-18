package bj21945

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    var sum = 0L
    for (i in list) {
        if (isPalindrome(i)) {
            sum += i
        }
    }
    println(sum)
}

fun isPalindrome(n: Int): Boolean {
    val str = n.toString()
    val len = str.length
    for (i in 0 until len / 2) {
        if (str[i] != str[len - i - 1]) {
            return false
        }
    }
    return true
}
