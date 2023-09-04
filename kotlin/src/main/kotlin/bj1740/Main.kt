package bj1740

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val binaryN = br.readLine().toLong().toString(radix = 2).toCharArray()
    var result = 0L
    binaryN.forEachIndexed { index, c ->
        if (c == '1') {
            result += pow(3, binaryN.size - index - 1)
        }
    }
    println(result)
    br.close()
}

fun pow(a: Int, b: Int): Long {
    return if (b == 0) {
        1
    } else {
        a * pow(a, b - 1)
    }
}
