package bj5361

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val android = br.readLine().split(" ").map { it.toInt() }
        bw.write(
            "\$${
                String.format(
                    "%.2f",
                    android[0] * 350.34 + android[1] * 230.90 + android[2] * 190.55 + android[3] * 125.30 + android[4] * 180.90
                )
            }\n"

        )
    }
    bw.close()
}
