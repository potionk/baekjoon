package bj24072

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    if (c < a || b <= c)
        print(0)
    else
        print(1)
    br.close()
}
