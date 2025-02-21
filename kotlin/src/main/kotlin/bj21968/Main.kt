package bj21968

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toLong()
        val binaryStrReverse = n.toString(radix = 2).reversed()
        var result = 0L
        var value = 1L
        for (i in binaryStrReverse.indices) {
            if (binaryStrReverse[i] == '1') {
                result += value
            }
            value *= 3
        }
        println(result)
    }
}
