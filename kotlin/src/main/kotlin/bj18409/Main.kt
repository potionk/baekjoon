package bj18409

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val str = br.readLine()
    val vowel = listOf('a', 'e', 'i', 'o', 'u')
    var result = 0
    for (i in 0 until n) {
        if (str[i] in vowel) {
            result++
        }
    }
    print(result)
}
