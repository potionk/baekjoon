package bj4096

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    while (true) {
        val input = br.readLine()
        if (input == "0") break

        val length = input.length
        var num = input.toInt()
        var count = 0

        while (true) {
            fillZero(num, length, sb)
            if (isPalindrome(sb)) {
                println(count)
                break
            }
            num++
            count++
        }
    }
}

fun fillZero(num: Int, length: Int, sb: StringBuilder) {
    sb.setLength(0)
    val str = num.toString()
    val zeroCount = length - str.length
    for (i in 0 until zeroCount) {
        sb.append('0')
    }
    sb.append(str)
}

fun isPalindrome(sb: StringBuilder): Boolean {
    var start = 0
    var end = sb.length - 1
    while (start < end) {
        if (sb[start] != sb[end]) return false
        start++
        end--
    }
    return true
}
