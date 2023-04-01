package bj9711

import java.io.*
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val dp = Array<BigInteger>(10001) { BigInteger.ZERO }
    dp[1] = BigInteger.ONE
    dp[2] = BigInteger.ONE
    for (i in 3..10000) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    for (i in 0 until t) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        println("Case #${i + 1}: ${dp[n].remainder(BigInteger.valueOf(k.toLong()))}")
    }
    br.close()
}
