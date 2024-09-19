package bj29267

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    var count = 0
    var save = 0
    repeat(n) {
        val cmd = br.readLine()
        when (cmd) {
            "save" -> {
                save = count
                println(count)
            }

            "load" -> {
                count = save
                println(count)
            }

            "shoot" -> {
                if (count != 0) {
                    count--
                }
                println(count)
            }

            "ammo" -> {
                count += k
                println(count)
            }
        }
    }
}
