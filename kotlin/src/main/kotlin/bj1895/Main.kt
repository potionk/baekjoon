package bj1895

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val image = Array(r) { br.readLine().trim().split(" ").map { it.toInt() }.toIntArray() }
    val t = br.readLine().toInt()
    var count = 0
    for (i in 0 until r - 2) {
        for (j in 0 until c - 2) {
            val subImage = image
                .sliceArray(i..i + 2)
                .map { it.sliceArray(j..j + 2) }
                .toTypedArray()
            if (subImage.flatMap { it.toList() }.sorted()[4] >= t) {
                count++
            }
        }
    }
    println(count)
}
