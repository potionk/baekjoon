package bj15828

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val packets = ArrayDeque<Int>()
    var readPacket = br.readLine().toInt()

    while (readPacket != -1) {
        if (readPacket != 0) {
            if (packets.size < n) {
                packets.add(readPacket)
            }
        } else {
            packets.removeFirst()
        }
        readPacket = br.readLine().toInt()
    }
    if (packets.size == 0) {
        print("empty")
    } else {
        packets.forEach {
            print("$it ")
        }
    }
    br.close()
    bw.close()
}
