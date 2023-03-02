package bj6840

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val plates = IntArray(3)
    for (i in 0 until 3) {
        plates[i] = br.readLine().toInt()
    }
    println(plates.sorted()[1])
    br.close()
}
