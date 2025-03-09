package bj32778

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val split = str.split("(")
    if (split.size == 1) {
        println("$str\n-")
    } else {
        println(split[0].trim())
        println(split[1].split(")")[0].trim())
    }
}
