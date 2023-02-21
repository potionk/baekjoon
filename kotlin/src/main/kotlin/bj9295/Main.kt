package bj9295

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val diceResults = br.readLine().split(" ").map { it.toInt() }
        bw.write("Case $i: ${diceResults[0] + diceResults[1]}\n")
    }
    br.close()
    bw.close()
}
