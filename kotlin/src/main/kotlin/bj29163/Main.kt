package bj29163

fun main() {
    val n = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map { it.toInt() }
    val oddCount = list.count { it % 2 == 1 }
    if (oddCount < list.size - oddCount) {
        println("Happy")
    } else {
        println("Sad")
    }
}
