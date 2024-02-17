package bj5648

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val list = mutableListOf<Long>()
    val readLine = br.readLine().split(" ")
    for (i in 1 until readLine.size) {
        list.add(readLine[i].reversed().toLong())
    }
    var line = br.readLine()
    while (line != null) {
        if (line.isNotEmpty()) {
            line.split(" ").forEach { list.add(it.reversed().toLong()) }
        }
        line = br.readLine()
    }
    list.sorted().forEach { bw.write("$it\n") }
    bw.close()
}
