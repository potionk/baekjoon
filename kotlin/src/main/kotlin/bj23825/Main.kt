package bj23825

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (sBlocks, aBlocks) = br.readLine().split(" ").map { it.toInt() }
    println(min(sBlocks / 2, aBlocks / 2))
}
