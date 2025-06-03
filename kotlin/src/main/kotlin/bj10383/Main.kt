package bj10383

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var idx = 1
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) break
        val original = mutableListOf<String>()
        while (true) {
            original.addAll(br.readLine().trim().split(" "))
            if (original.size == n) break
        }
        val originalIndexMap = original.withIndex().associate { it.value to it.index }
        val sorted = original.sorted()
        val sortedIndexMap = sorted.withIndex().associate { it.value to it.index }
        var count = 0
        sorted.forEach {
            count += Math.abs(originalIndexMap[it]!! - sortedIndexMap[it]!!)
        }
        println("Site $idx: $count")
        idx++
    }
}