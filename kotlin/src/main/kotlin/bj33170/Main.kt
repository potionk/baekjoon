package bj33170

import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(if (br.readLine().toInt() + br.readLine().toInt() + br.readLine().toInt() <= 21) 1 else 0)
}
