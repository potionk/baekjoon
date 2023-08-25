package bj11795

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()

    val setAmounts = IntArray(3)
    for (i in 0 until t) {
        val input = br.readLine().split(" ").map { it.toInt() }
        setAmounts[0] += input[0]
        setAmounts[1] += input[1]
        setAmounts[2] += input[2]

        val packages = setAmounts.min()
        if (packages < 30) {
            bw.write("NO\n")
            continue
        }

        bw.write("${packages}\n")

        setAmounts[0] -= packages
        setAmounts[1] -= packages
        setAmounts[2] -= packages
    }
    bw.close()
}
