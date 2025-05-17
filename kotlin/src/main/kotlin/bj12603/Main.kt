package bj12603

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val c = br.readLine().toInt()
        val pSize = br.readLine().toInt()
        val pList = br.readLine().split(" ").map { it.toInt() }
        val map = mutableMapOf<Int, Int>()
        for (j in 0 until pSize) {
            val price = pList[j]
            val diff = c - price
            if (map.containsKey(diff)) {
                println("Case #$i: ${map[diff]!! + 1} ${j + 1}")
                break
            }
            map[price] = j
        }
    }
}
