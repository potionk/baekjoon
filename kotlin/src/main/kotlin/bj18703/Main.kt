package bj18703

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val files = mutableListOf<Pair<String, Int>>()
        for (j in 0 until n) {
            val (name, id) = br.readLine().split(" ")
            files.add(Pair(name, id.toInt()))
        }
        val set = mutableSetOf<String>()
        files.sortBy { it.second }
        files.forEach {
            if (!set.contains(it.first)) {
                bw.write("${it.second} ")
                set.add(it.first)
            }
        }
        bw.write("\n")
    }
    bw.close()
}
