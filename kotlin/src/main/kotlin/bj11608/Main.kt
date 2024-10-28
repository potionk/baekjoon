package bj11608

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val countMap = mutableMapOf<Char, Int>()
    val str = br.readLine()
    str.toCharArray().forEach {
        countMap[it] = countMap.getOrDefault(it, 0) + 1
    }
    val countList = countMap.values.sortedDescending()
    var result = 0
    for (i in 0 until minOf(countList.size, 2)) {
        result += countList[i]
    }
    println(str.length - result)
}
