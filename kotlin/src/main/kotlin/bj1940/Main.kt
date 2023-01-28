package bj1940

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val materials = br.readLine().split(" ").map { it.toInt() }.sorted()
    var count = 0
    var left = 0
    var right = materials.size - 1
    while (left < right) {
        if (materials[left] + materials[right] == M) {
            left++
            right--
            count++
        } else if (materials[left] + materials[right] < M) {
            left++
        } else {
            right--
        }
    }
    bw.write("$count")
    bw.flush()
    br.close()
    bw.close()
}
