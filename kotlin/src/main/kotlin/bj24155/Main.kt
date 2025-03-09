package bj24155

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    for (i in 1..n) {
        val num = br.readLine().toInt()
        list.add(num)
    }
    val sortedList = list.sortedDescending()
    val resultMap = mutableMapOf<Int, Int>()
    var rank = 1
    resultMap[sortedList[0]] = rank
    for (i in 1 until n) {
        if (sortedList[i] == sortedList[i - 1]) {
            resultMap[sortedList[i]] = rank
        } else {
            rank = i + 1
            resultMap[sortedList[i]] = rank
        }
    }
    for (i in 0 until n) {
        println(resultMap[list[i]])
    }
}
