package bj26731

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val char = mutableSetOf<Char>()
    val line = br.readLine()
    for (i in line.indices) {
        char.add(line[i])
    }
    for (i in 'A'..'Z') {
        if (!char.contains(i)) {
            print(i)
        }
    }
}
