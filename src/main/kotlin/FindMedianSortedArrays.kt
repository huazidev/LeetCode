import kotlin.math.min

/**
 *
 * 4. Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 *   nums1 = [1, 3]
 *   nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *
 *   nums1 = [1, 2]
 *   nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * @author hua on 2020/04/17.
 */
class FindMedianSortedArrays {

    // Time Complexity: O(max(m,n)), Space complexity: O(m + n)
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.isEmpty() && nums2.isEmpty()) return 0.0
        val array = arrayListOf<Int>()
        var i = 0 // nums1 indicator
        var j = 0 // nums2 indicator
        while (true) {
            if (i < nums1.size && j < nums2.size) {
                val value1 = nums1[i]
                val value2 = nums2[j]
                if (value1 <= value2) {
                    array.add(value1)
                    i++
                } else {
                    array.add(value2)
                    j++
                }
            } else if (i < nums1.size) {
                array.add(nums1[i])
                i++
            } else if (j < nums2.size) {
                array.add(nums2[j])
                j++
            } else {
                break
            }
        }

        return if (array.size % 2 == 0) {
            (array[array.size / 2 - 1] + array[array.size / 2]) / 2.0
        } else {
            array[array.size / 2].toDouble()
        }
    }

}

fun main() {
    println(FindMedianSortedArrays().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)) == 2.0)
    println(FindMedianSortedArrays().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)) == 2.5)
}