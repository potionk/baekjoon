package bj25314

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    print("long ".repeat(br.readLine().toInt() / 4) + "int")
    br.close()
}
