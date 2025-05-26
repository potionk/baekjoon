package bj33540

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val info = br.readLine().trim().split(" ")
        val name = info[0]
        val score = info[1].toInt()
        map[name] = map.getOrDefault(name, 0) + score
    }
    map.keys.sorted().forEach { name ->
        println("$name ${map[name]}")
    }
}