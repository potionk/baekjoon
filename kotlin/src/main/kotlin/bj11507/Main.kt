package bj11507

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cards = br.readLine().toCharArray()
    val set = mutableSetOf<String>()
    for (i in cards.indices step 3) {
        set.add(cards.sliceArray(i until i + 3).joinToString(""))
    }
    if (set.size != cards.size / 3) {
        println("GRESKA")
    } else {
        val p = 13 - set.count { it.startsWith("P") }
        val k = 13 - set.count { it.startsWith("K") }
        val h = 13 - set.count { it.startsWith("H") }
        val t = 13 - set.count { it.startsWith("T") }
        println("$p $k $h $t")
    }
}
