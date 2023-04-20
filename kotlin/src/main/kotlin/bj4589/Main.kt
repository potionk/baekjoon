package bj4589

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    bw.write("Gnomes:\n")
    for (i in 0 until n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        val sortedList = list.sorted()
        val sortedList2 = list.sortedDescending()
        if (list.joinToString() == sortedList.joinToString() || list.joinToString() == sortedList2.joinToString()) {
            bw.write("Ordered\n")
        } else {
            bw.write("Unordered\n")
        }
    }
    br.close()
    bw.close()
}
