package bj4606

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val input = br.readLine()
        if (input == "#") {
            break
        }
        println(encode(input))
    }
}

fun encode(input: String): String {
    val sb = StringBuilder()
    input.forEach {
        when (it) {
            ' ' -> sb.append("%20")
            '!' -> sb.append("%21")
            '$' -> sb.append("%24")
            '%' -> sb.append("%25")
            '(' -> sb.append("%28")
            ')' -> sb.append("%29")
            '*' -> sb.append("%2a")
            else -> sb.append(it)
        }
    }
    return sb.toString()
}
