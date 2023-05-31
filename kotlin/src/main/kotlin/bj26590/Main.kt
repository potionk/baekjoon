package bj26590

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (a, b) = br.readLine().split(" ")
    var isA = true
    for (i in 0 until min(a.length, b.length)) {
        bw.write(
            if (isA) {
                isA = false
                a[i].toString()
            } else {
                isA = true
                b[i].toString()
            }
        )
    }
    br.close()
    bw.close()
}
