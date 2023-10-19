package bj7596

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var num = 1
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) {
            break
        }
        val songs = mutableListOf<String>()
        for (i in 0 until n) {
            songs.add(br.readLine())
        }
        bw.write("${num++}\n")
        songs.sorted().forEach { bw.write("$it\n") }
    }
    bw.close()
}
