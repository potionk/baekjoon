package bj14729

import java.io.*
import java.text.DecimalFormat
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val labTarget = DoubleArray(7)
    var max = -1.0
    for (i in 0 until 7) {
        labTarget[i] = br.readLine().toDouble()
        max = max(labTarget[i], max)
    }
    labTarget.sort()
    for (i in 7 until n) {
        val next = br.readLine().toDouble()
        if (next < max) {
            labTarget[6] = next
            labTarget.sort()
            max = labTarget[6]
        }
    }
    val decimalFormat = DecimalFormat("0.000")
    labTarget.forEach {
        bw.write("${decimalFormat.format(it)}\n")
    }
    br.close()
    bw.close()
}
