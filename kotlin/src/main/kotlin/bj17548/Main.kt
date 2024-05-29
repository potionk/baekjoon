package bj17548

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val charArray = br.readLine().toCharArray()
    charArray.forEach {
        if (it == 'e') {
            bw.write("ee")
        } else {
            bw.write("$it")
        }
    }
    bw.flush()
}
