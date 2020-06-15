package com.dsw.algorithm

import org.junit.Test
import java.util.*


/**
 * 排序
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SortUnitTest {

    /**
     * 冒泡
     */
    @Test
    fun maoPaoTest() {
        val dataList = generateRandomArray(30)
        println("before: ${dataList.toList()}")

        for (i in dataList.indices) {
            for (j in 0 until (dataList.size - i - 1)) {
                if (dataList[j] > dataList[j + 1]) {
                    swap(dataList, j, j + 1)
                }
            }
        }
        println("after: ${dataList.toList()}")
    }


    /**
     * 快排
     */
    @Test
    fun quickSortTest() {
        val list = generateRandomArray(30)
        println("before: ${list.toList()}")
        performQuickSort(list, 0, list.size - 1)
        println("after: ${list.toList()}")
    }


    private fun performQuickSort(list: Array<Int>, left: Int, right: Int) {
        if (left > right) {
            return
        }
        var i = left
        var j = right
        var temp = list[left]
        var t: Int
        while (i != j) {
            while (list[j] >= temp && i < j) {
                j--
            }
            while (list[i] <= temp && i < j) {
                i++
            }

            if (i < j) {
                t = list[i]
                list[i] = list[j]
                list[j] = t
            }
        }

        list[left] = list[i]
        list[i] = temp

        performQuickSort(list, left, j - 1)

        performQuickSort(list, j + 1, right)
    }

    private inline fun swap(array: Array<Int>, index: Int, othIndex: Int) {
        var temp = array[othIndex]
        array[othIndex] = array[index]
        array[index] = temp
    }

    private inline fun generateRandomArray(capacity: Int, bound: Int = 100): Array<Int> {
        val random = Random()
        return Array(capacity) {
            random.nextInt(bound)
        }
    }
}
