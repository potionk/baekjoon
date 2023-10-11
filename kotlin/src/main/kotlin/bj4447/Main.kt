package bj4447

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    repeat(n) {
        val s = br.readLine()
        var g = 0
        var b = 0
        s.forEach {
            when (it) {
                'g', 'G' -> g++
                'b', 'B' -> b++
            }
        }
        bw.write("${s.trim()} is ")
        when {
            g > b -> bw.write("GOOD\n")
            g < b -> bw.write("A BADDY\n")
            else -> bw.write("NEUTRAL\n")
        }
    }
    bw.close()
}
