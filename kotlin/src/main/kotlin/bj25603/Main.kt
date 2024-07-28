package bj25603

import java.io.*
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val cost = br.readLine().split(" ").map { it.toInt() }
    val treeMap = TreeMap<Int, Int>()
    for (i in 0 until k) {
        treeMap[cost[i]] = treeMap.getOrDefault(cost[i], 0) + 1
    }
    var result = 0
    for (i in k until n) {
        result = max(result, treeMap.firstKey())

        val before = cost[i - k]
        if (treeMap[before] == 1) {
            treeMap.remove(before)
        } else {
            treeMap[before] = treeMap.getOrDefault(before, 0) - 1
        }

        val after = cost[i]
        treeMap[after] = treeMap.getOrDefault(after, 0) + 1
    }
    result = max(result, treeMap.firstKey())
    println(result)
}
