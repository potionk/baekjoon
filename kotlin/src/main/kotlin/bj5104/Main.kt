package bj5104

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (w, n) = br.readLine().split(" ").map { it.toInt() }
        if (w == 0 && n == 0) break
        val list = mutableListOf<String>()
        val pointMap = mutableMapOf<String, Int>()
        for (i in 0 until n) {
            val (a, b) = br.readLine().split(" ")
            if (!pointMap.containsKey(a)) {
                list.add(a)
            }
            val before = pointMap[a] ?: 0
            pointMap[a] = before + codeToPoint(b)
        }
        print("Week $w ")
        list.filter { pointMap[it]!! >= 100 }.joinToString(",").let {
            if (it.isEmpty()) {
                println("No phones confiscated")
            } else {
                println(it)
            }
        }
    }
}

fun codeToPoint(code: String): Int {
    return when (code) {
        "TT" -> 75
        "TX" -> 50
        "PR" -> 80
        "RT" -> 30
        "AP" -> 25
        "PX" -> 60
        else -> 0
    }
}
