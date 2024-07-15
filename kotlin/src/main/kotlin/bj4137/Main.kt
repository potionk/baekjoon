package bj4137

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    val mappingTable = mutableMapOf<Char, Char>()
    var num = 2
    var count = 0
    for (i in 'A'..'Y') {
        if (i == 'Q') {
            continue
        }
        mappingTable[i] = num.toString()[0]
        count++
        if (count % 3 == 0) {
            num++
        }
    }
    repeat(n) {
        val str = br.readLine()
        var decode = ""
        str.forEach {
            if (it.isDigit()) {
                decode += it
            }
            if (it.isLetter()) {
                decode += mappingTable[it]!!
            }
        }
        map[decode] = map.getOrDefault(decode, 0) + 1
    }
    val result = map.filter { it.value > 1 }.toSortedMap()
    if (result.size == 0) {
        println("No duplicates.")
        return
    }
    result.forEach {
        println("${it.key.substring(0, 3)}-${it.key.substring(3)} ${it.value}")
    }
}
