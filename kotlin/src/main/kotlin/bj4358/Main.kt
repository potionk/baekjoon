package bj4358

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var name = br.readLine()
    val map = mutableMapOf<String, Int>()
    var totalSize = 0
    while (name != null) {
        map[name] = map.getOrDefault(name, 0) + 1
        name = br.readLine()
        totalSize++
    }
    val names = map.keys.sorted()
    names.forEach {
        bw.write("$it ${String.format("%.4f", map[it]!! * 100.0 / totalSize)}\n")
    }
    br.close()
    bw.close()
}
