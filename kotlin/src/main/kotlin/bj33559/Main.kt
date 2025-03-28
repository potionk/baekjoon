package bj33559

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val aMap = mutableMapOf<Int, Int>()
    val aList = br.readLine().split(" ").map { it.toInt() }
    aList.forEach {
        aMap[it] = aMap.getOrDefault(it, 0) + 1
    }
    var count = 0
    val bList = br.readLine().split(" ").map { it.toInt() }
    val aResult = mutableListOf<Int>()
    val bResult = mutableListOf<Int>()
    val bNotContainResult = mutableListOf<Int>()
    bList.forEach {
        if (aMap.containsKey(it) && aMap[it]!! > 0) {
            aResult.add(it)
            aMap[it] = aMap[it]!! - 1
            bResult.add(it)
            count++
        } else {
            bNotContainResult.add(it)
        }
    }
    println(count)
    var stringBuffer = StringBuffer()
    aResult.forEach {
        stringBuffer.append("$it ")
    }
    aMap.forEach {
        if (it.value > 0) {
            stringBuffer.append("${it.key} ".repeat(it.value))
        }
    }
    println(stringBuffer.toString().trim())
    stringBuffer = StringBuffer()
    bResult.forEach {
        stringBuffer.append("$it ")
    }
    bNotContainResult.forEach {
        stringBuffer.append("$it ")
    }
    println(stringBuffer.toString().trim())
}
