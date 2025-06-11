package bj9202

import java.util.*
import kotlin.Comparator

fun main() {
    val lengthComparator = Comparator<String> { a, b ->
        b.length.compareTo(a.length) // 문자열 길이에 따라 내림차순 정렬
    }

    val treeSet = TreeSet(lengthComparator)

    treeSet.add("Hello")
    treeSet.add("World")
    treeSet.add("Kotlin")
    treeSet.add("Programming")

    for (str in treeSet) {
        println(str)
    }
}
