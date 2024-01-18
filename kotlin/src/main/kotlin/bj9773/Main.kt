package bj9773

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val numStr = br.readLine()
        val stepOne = numStr.toCharArray().sumOf { it.toString().toInt() }
        val stepTwo = numStr.drop(10).toInt() * 10
        val id = stepOne + stepTwo
        bw.write(
            "${
                if (id < 1000) {
                    id + 1000
                } else {
                    val result = (id % 10000).toString()
                    "0".repeat(4 - result.length) + result
                }
            }\n"
        )
    }
    bw.close()
}
