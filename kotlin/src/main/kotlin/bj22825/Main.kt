package bj22825

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val z = br.readLine().toInt()
        if (z == 0) break
        val z3 = z * z * z
        var maxSum = 0
        for (x in 1..z) {
            val x3 = x * x * x
            if (x3 > z3) break
            for (y in 1..z) {
                val y3 = y * y * y
                val sum = x3 + y3
                if (sum > z3) break
                if (sum > maxSum) {
                    maxSum = sum
                }
            }
        }
        println(z3 - maxSum)
    }
}

