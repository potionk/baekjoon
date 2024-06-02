package bj1446

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d) = br.readLine().split(" ").map { it.toInt() }
    val shortCuts = mutableMapOf<Int, List<Pair<Int, Int>>>() // start, end, distance
    val dp = IntArray(d + 1) { it }
    repeat(n) {
        val (start, end, distance) = br.readLine().split(" ").map { it.toInt() }
        shortCuts[start] = shortCuts.getOrDefault(start, emptyList()) + Pair(end, distance)
    }
    shortCuts.getOrDefault(0, emptyList()).forEach { (end, distance) ->
        if (end > d) return@forEach
        dp[end] = min(dp[end], distance)
    }
    for (i in 1..d) {
        dp[i] = min(dp[i], dp[i - 1] + 1)
        if (shortCuts.containsKey(i)) {
            shortCuts[i]!!.forEach { (end, distance) ->
                if (end > d) return@forEach
                dp[end] = min(dp[end], dp[i] + distance)
            }
        }
    }
    println(dp[d])
}
