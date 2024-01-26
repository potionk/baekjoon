package bj28290

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(
        when (br.readLine()) {
            "fdsajkl;", "jkl;fdsa" -> "in-out"
            "asdf;lkj", ";lkjasdf" -> "out-in"
            "asdfjkl;" -> "stairs"
            ";lkjfdsa" -> "reverse"
            else -> "molu"
        }
    )
}
