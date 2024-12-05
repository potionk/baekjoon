package bj7241

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val abc = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    for (i in 0 until 3) {
        val a = abc[i]
        for (j in 0 until 3) {
            if (i == j) continue
            val b = abc[j]
            for (k in 0 until 3) {
                if (i == k || j == k) continue
                val c = abc[k]
                list.add(a * 100 + b * 10 + c)
            }
        }
    }
    val x = br.readLine().toInt()
    var result = 1
    list.toSet().toList().sorted().forEach {
        if (x == it) {
            println(result)
            return
        }
        result++
    }
}
