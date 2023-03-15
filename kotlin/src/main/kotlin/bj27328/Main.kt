package bj27328

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    print(if (a > b) 1 else if (a < b) -1 else 0)
    br.close()
}
