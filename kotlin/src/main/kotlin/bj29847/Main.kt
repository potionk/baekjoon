package bj29847

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<Char, Int>()
    repeat(n) {
        br.readLine().toCharArray().forEach {
            if (it != ' ') {
                map[it] = map.getOrDefault(it, 0) + 1
            }
        }
    }
    map.forEach {
        println("${it.key} ${it.value}")
    }
}
