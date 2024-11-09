package bj10546

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val str = br.readLine()
        val count = map.getOrDefault(str, 0)
        map[str] = count + 1
    }
    repeat(n - 1) {
        val str = br.readLine()
        val count = map.getOrDefault(str, 0)
        map[str] = count - 1
        if (map[str] == 0) {
            map.remove(str)
        }
    }
    println(map.keys.first())
}
