package bj2161

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val cards = ArrayDeque<Int>()
    for (i in 0 until n) {
        cards.add(i + 1)
    }
    while (cards.size > 0) {
        print("${cards.removeFirst()} ")
        if (cards.size == 0) {
            break
        }
        cards.add(cards.removeFirst())
    }
    br.close()
    bw.close()
}
