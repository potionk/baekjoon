package bj4714

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val data = br.readLine().toDouble()
        if (data == -1.0) {
            break
        }
        println(
            "Objects weighing ${String.format("%.2f", data)} on Earth will weigh ${
                String.format(
                    "%.2f",
                    data * 0.167
                )
            } on the moon."
        )
    }
    br.close()
}
