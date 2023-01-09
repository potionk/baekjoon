package bj12933

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sound = br.readLine().toCharArray()
    val check = mutableSetOf<Int>()
    val quack = "quack".toCharArray()
    var quackIdx = 0
    var duckCount = 0
    for (idx in 0 until sound.size - 4) {
        if (!check.contains(idx)) {
            val tempCheck = mutableListOf<Int>()
            for (checkIdx in idx until sound.size) {
                if (!check.contains(checkIdx) && sound[checkIdx] == quack[quackIdx % 5]) {
                    quackIdx++
                    tempCheck.add(checkIdx)
                }
            }
            duckCount++
            for (tempIdx in 0 until quackIdx / 5 * 5) {
                check.add(tempCheck[tempIdx])
            }
            quackIdx = 0
        }
    }
    if (sound.size != check.size) {
        bw.write("-1")
    } else {
        bw.write("$duckCount")
    }
    br.close()
    bw.close()
}
