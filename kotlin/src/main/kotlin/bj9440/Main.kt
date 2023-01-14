package bj9440

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var readLine = br.readLine()
    while (readLine != "0") {
        var a = 0
        var b = 0
        val n = readLine.split(" ").map { it.toInt() }.toMutableList()
        n.removeFirst()
        var list = n.sorted().toMutableList()
        var isA = true
        while (list.isNotEmpty()) {
            if (isA) {
                val pair = calculate(a, list)
                a = pair.first
                list = pair.second
            } else {
                val pair = calculate(b, list)
                b = pair.first
                list = pair.second
            }
            isA = !isA
        }
        bw.write("${a + b}\n")
        readLine = br.readLine()
    }
    bw.flush()
    br.close()
    bw.close()
}

// todo refactor 불필요한 소팅 제거 필요
private fun calculate(
    a: Int,
    list: MutableList<Int>
): Pair<Int, MutableList<Int>> {
    var a1 = a
    var list1 = list
    if (a1 == 0) {
        while (list1.first() == 0) {
            list1.add(list1.removeFirst())
        }
        a1 = list1.removeFirst()
        list1 = list1.sorted().toMutableList()
    } else {
        a1 = a1 * 10 + list1.removeFirst()
    }
    return Pair(a1, list1)
}

