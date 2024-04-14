package bj9047

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        var count = 0
        var num = n
        while (num != 6174) {
            val asc = fillZero(num).toCharArray().sorted()
            val ascNum = asc.joinToString("").toInt()
            val descNum = asc.reversed().joinToString("").toInt()
            num = descNum - ascNum
            count++
        }
        println(count)
    }
}

fun fillZero(num: Int): String {
    return when (num.toString().length) {
        1 -> "000$num"
        2 -> "00$num"
        3 -> "0$num"
        else -> num.toString()
    }
}
