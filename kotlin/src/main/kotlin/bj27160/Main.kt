package bj27160

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val (name, num) = br.readLine().split(" ")
        map[name] = map.getOrDefault(name, 0) + num.toInt()
    }
    map.forEach {
        if (it.value == 5) {
            println("YES")
            return
        }
    }
    println("NO")
}
