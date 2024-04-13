package bj17263

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    print(br.readLine().split(" ").maxOfOrNull { it.toInt() })
}
