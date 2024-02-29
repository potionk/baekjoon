package bj26768

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = br.readLine().toCharArray()
    str.forEach { c ->
        bw.write(
            when (c) {
                'a' -> "4"
                'e' -> "3"
                'i' -> "1"
                'o' -> "0"
                's' -> "5"
                else -> c.toString()
            }
        )
    }
    bw.close()
}
