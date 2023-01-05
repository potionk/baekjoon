package bj14581

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    print(
        ":fan::fan::fan:\n" +
        ":fan::${br.readLine()}::fan:\n" +
        ":fan::fan::fan:"
    )
    br.close()
}

