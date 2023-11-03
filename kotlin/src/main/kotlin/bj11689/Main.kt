package bj11689

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    println(eulerPhi(n))
}

fun eulerPhi(n: Long): Long {
    var result = n
    var num = n

    for (i in 2..sqrt(num.toDouble()).toLong()) {
        if (num % i == 0L) {
            while (num % i == 0L) {
                num /= i
            }
            result -= result / i
        }
    }

    if (num > 1) {
        result -= result / num
    }

    return result
}
