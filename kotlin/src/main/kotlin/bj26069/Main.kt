package bj26069

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = mutableSetOf<String>()
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        if (a == "ChongChong" || b == "ChongChong" || set.contains(a) || set.contains(b)) {
            set.add(a)
            set.add(b)
        }
    }
    println(set.size)
    br.close()
}
