package bj15841

import java.io.*
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dp = mutableListOf<BigInteger>()
    dp.add(BigInteger.ZERO)
    dp.add(BigInteger.ONE)
    dp.add(BigInteger.ONE)
    for (i in 3 until 491) {
        dp.add(dp[i - 1].add(dp[i - 2]))
    }
    while (true) {
        val n = br.readLine().toInt()
        if (n == -1) break
        println("Hour $n: ${dp[n]} cow(s) affected")
    }
}
