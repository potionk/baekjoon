package bj15723

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val requires = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val xIsY = br.readLine().split(" is ")
        requires[xIsY[0]] = xIsY[1]
    }
    val m = br.readLine().toInt()
    for (i in 0 until m) {
        val isVisited = mutableSetOf<String>()
        val result = br.readLine().split(" is ")
        var a = result[0]
        val target = result[1]
        while (true) {
            if (requires[a] == null || isVisited.contains(a)) {
                bw.write("F\n")
                break
            } else if (requires[a] == target) {
                bw.write("T\n")
                break
            } else {
                isVisited.add(a)
                a = requires[a]!!
            }
        }
    }
    br.close()
    bw.close()
}
