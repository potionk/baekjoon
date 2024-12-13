package bj32684

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list1 = br.readLine().split(" ").map { it.toInt() }
    val list2 = br.readLine().split(" ").map { it.toInt() }
    val choScore = 13 * list1[0] + 7 * list1[1] + 5 * list1[2] + 3 * list1[3] + 3 * list1[4] + 2 * list1[5]
    val hanScore = 1.5 +  13 * list2[0] + 7 * list2[1] + 5 * list2[2] + 3 * list2[3] + 3 * list2[4] + 2 * list2[5]
    if (choScore > hanScore) {
        println("cocjr0208")
    } else {
        println("ekwoo")
    }
}
