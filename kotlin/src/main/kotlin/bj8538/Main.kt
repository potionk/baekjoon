package bj8538

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val names = mutableSetOf<String>()
    repeat(n) {
        names.add(
            br.readLine()
                .replace("-", "")
                .uppercase()
        )
    }
    println(names.size)
}
