package bj4675

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = mutableMapOf<String, List<String>>()
    while (true) {
        val str = br.readLine()
        if (str == "XXXXXX") {
            break
        }
        val sortedStr = str.toCharArray().sorted().joinToString("")
        if (map.containsKey(sortedStr)) {
            map[sortedStr] = map[sortedStr]!! + str
        } else {
            map[sortedStr] = listOf(str)
        }
    }
    while (true) {
        val str = br.readLine()
        if (str == "XXXXXX") {
            break
        }
        val sortedStr = str.toCharArray().sorted().joinToString("")
        if (map.containsKey(sortedStr)) {
            map[sortedStr]!!.sorted().forEach {
                println(it)
            }
        } else {
            println("NOT A VALID WORD")
        }
        println("******")
    }
}
