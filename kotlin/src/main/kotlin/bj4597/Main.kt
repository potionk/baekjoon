package bj4597

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val line = br.readLine()
        if (line == "#") {
            break
        }
        val count = line.count { it == '1' }
        bw.write(
            if (line.last() == 'e') {
                if (count % 2 == 0) {
                    "${line.replace("e", "0")}\n"
                } else {
                    "${line.replace("e", "1")}\n"
                }
            } else {
                if (count % 2 == 0) {
                    "${line.replace("o", "1")}\n"
                } else {
                    "${line.replace("o", "0")}\n"
                }
            }
        )
    }
    bw.close()
}
