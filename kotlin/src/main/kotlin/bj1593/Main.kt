package bj1593

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (g, s) = br.readLine().split(" ").map { it.toInt() }
    val gWord = br.readLine()
    val sWord = br.readLine()
    val gWordMap = mutableMapOf<Char, Int>()
    gWord.forEach {
        gWordMap[it] = gWordMap.getOrDefault(it, 0) + 1
    }
    var count = 0
    val subMap = mutableMapOf<Char, Int>()
    for (i in 0 until g) {
        subMap[sWord[i]] = subMap.getOrDefault(sWord[i], 0) + 1
    }
    if (subMap == gWordMap) count++
    for (i in g until s) {
        subMap[sWord[i - g]] = subMap.getOrDefault(sWord[i - g], 0) - 1
        if (subMap[sWord[i - g]] == 0) subMap.remove(sWord[i - g])
        subMap[sWord[i]] = subMap.getOrDefault(sWord[i], 0) + 1
        if (subMap == gWordMap) count++
    }
    println(count)
}
