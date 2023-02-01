package bj11637

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val list = mutableListOf<Pair<Int, Int>>()
        var total = 0
        for (j in 1..n) {
            val num = br.readLine().toInt()
            total += num
            list.add(Pair(num, j))
        }
        val sortedList = list.sortedBy { it.first }.reversed()
        if (sortedList[0].first == sortedList[1].first) {
            bw.write("no winner\n")
        } else if (sortedList[0].first * 2 > total) {
            bw.write("majority winner ${sortedList[0].second}\n")
        } else {
            bw.write("minority winner ${sortedList[0].second}\n")
        }
    }
    br.close()
    bw.close()
}
