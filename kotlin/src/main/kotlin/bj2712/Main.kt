package bj2712

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (num, unit) = br.readLine().split(" ")
        when (unit) {
            "lb" -> {
                bw.write("${String.format("%.4f", num.toDouble() * 0.4536)} kg\n")
            }

            "kg" -> {
                bw.write("${String.format("%.4f", num.toDouble() * 2.2046)} lb\n")
            }

            "l" -> {
                bw.write("${String.format("%.4f", num.toDouble() * 0.2642)} g\n")
            }

            "g" -> {
                bw.write("${String.format("%.4f", num.toDouble() * 3.7854)} l\n")
            }
        }
    }
    br.close()
    bw.close()
}
