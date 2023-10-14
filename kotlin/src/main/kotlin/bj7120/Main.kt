package bj7120

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toCharArray()
    val result = StringBuilder()
    var lastChar = input[0]
    result.append(lastChar)
    for (idx in 1..input.lastIndex) {
        if (input[idx] != lastChar) {
            result.append(input[idx])
        }
        lastChar = input[idx]
    }
    println(result.toString())
}
