package bj27527

import java.io.*
import java.util.TreeMap
import kotlin.math.ceil

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val street = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    val countMap = TreeMap<Int, Int>()
    val window = ceil(9 * m / 10.0).toInt()
    for (i in 0 until m) {
        map[street[i]] = map.getOrDefault(street[i], 0) + 1
    }
    map.forEach {
        countMap[it.value] = countMap.getOrDefault(it.value, 0) + 1
    }
    if (countMap.lastKey() >= window) {
        println("YES")
        return
    }
    for (i in m until n) {
        val before = street[i - m]
        val beforeCount = map[before]!!
        if (beforeCount == 1) {
            map.remove(before)
        } else {
            map[before] = beforeCount - 1
        }
        if (countMap[beforeCount] == 1) {
            countMap.remove(beforeCount)
        } else {
            countMap[beforeCount] = countMap[beforeCount]!! - 1
        }
        countMap[beforeCount - 1] = countMap.getOrDefault(beforeCount - 1, 0) + 1

        val nextCount = map.getOrDefault(street[i], 0)
        if (nextCount > 0) {
            if (countMap[nextCount] == 1) {
                countMap.remove(nextCount)
            } else {
                countMap[nextCount] = countMap[nextCount]!! - 1
            }
        }
        map[street[i]] = map.getOrDefault(street[i], 0) + 1
        countMap[map[street[i]]!!] = countMap.getOrDefault(map[street[i]], 0) + 1
        if (countMap.lastKey() >= window) {
            println("YES")
            return
        }
    }
    println("NO")
}
