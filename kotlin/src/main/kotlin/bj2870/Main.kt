package bj2870

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<String>()
    for (i in 0 until n) {
        val s = br.readLine()
        val sb = StringBuilder()
        for (c in s) {
            if (c.isDigit()) {
                sb.append(c)
            } else if (sb.isNotEmpty()) {
                list.add(removeFirstZero(sb.toString()))
                sb.clear()
            }
        }
        if (sb.isNotEmpty()) {
            list.add(removeFirstZero(sb.toString()))
        }
    }
    list.sortWith(compareBy({ it.length }, { it }))
    list.forEach(::println)
}

fun removeFirstZero(s: String): String {
    var i = 0
    while (i < s.length && s[i] == '0') {
        i++
    }
    return s.substring(i).ifEmpty { "0" }
}