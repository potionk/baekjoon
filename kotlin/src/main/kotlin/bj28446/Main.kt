package bj28446

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val map = mutableMapOf<Int, Int>()
    repeat(n) {
        val input = br.readLine().split(" ")
        val op = input[0].toInt()
        val x = input[1].toInt()
        when (op) {
            1 -> map[input[2].toInt()] = x
            2 -> map[x]?.let { bw.write("$it\n") }
        }
    }
    bw.close()
}
