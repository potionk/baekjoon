package bj2547

import java.io.*
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        br.readLine()
        val m = br.readLine().toInt()
        var sum = BigInteger.ZERO
        for (j in 0 until m) {
            sum += br.readLine().toBigInteger()
        }
        if (sum % m.toBigInteger() == BigInteger.ZERO) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
