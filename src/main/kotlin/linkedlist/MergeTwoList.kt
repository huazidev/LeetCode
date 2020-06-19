package linkedlist

/**
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 *
 *     Input: 1->2->4, 1->3->4
 *     Output: 1->1->2->3->4->4
 *
 * result: test passed
 *
 * @author hua on 2020/06/19.
 */
class MergeTwoList {
    // not use new linkedlist
    // Time Complexity: O(m+n), Space complexity: O(1)
    fun mergeTwoList(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy: ListNode? = ListNode()
        dummy?.next = l1
        var pre = dummy

        var current1 = l1
        var current2 = l2

        while (current1 != null && current2 != null) {
            if (current1.value < current2.value) {
                current1 = current1.next
                pre = pre?.next
            } else {
                val temp = current2.next
                current2.next = null

                current2.next = pre?.next
                pre?.next = current2
                pre = pre?.next

                current2 = temp
            }
        }

        if (current1 == null) {
            pre?.next = current2
        } else {
            pre?.next = current1
        }
        return dummy?.next
    }


}

fun main() {
    println(
        MergeTwoList().mergeTwoList(
            ListNode.quickListNode(arrayListOf(1)),
            ListNode.quickListNode(arrayListOf(1, 2, 3, 4))
        )?.toString()
    )
}