package bj17048

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val factoryFrequency = br.readLine().split(" ").map { it.toInt() }
    val needFrequency = br.readLine().split(" ").map { it.toInt() }
    val diffMap = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        val diff = factoryFrequency[i] - needFrequency[i]
        diffMap[diff] = diffMap.getOrDefault(diff, 0) + 1
    }
    println(diffMap.values.max())
}
