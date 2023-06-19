package bj28235

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(
        when (br.readLine()) {
            "SONGDO" -> "HIGHSCHOOL"
            "CODE" -> "MASTER"
            "2023" -> "0611"
            else -> "CONTEST"
        }
    )
    br.close()
}
