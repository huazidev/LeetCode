package linkedlist

/**
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 *     Given linked list: 1->2->3->4->5, and n = 2.
 *
 *     After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 * result: test pass
 *
 * @author hua on 2020/06/18.
 */
class RemoveNthFromEnd {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val preNode = ListNode()
        preNode.next = head
        var pre: ListNode? = preNode
        var end: ListNode? = preNode
        var index = 0
        while (end?.next != null) {
            end = end.next
            index++
            if (index > n) {
                pre = pre?.next
            }
        }

        // remove node and handle the case where N is greater than the linkedlist length
        if (pre?.next != null && index >= n) {
            pre.next = pre.next?.next
        }

        return preNode.next
    }
}

fun main() {
    val removeNthFromEnd = RemoveNthFromEnd().removeNthFromEnd(ListNode.quickListNode(arrayListOf(1, 2, 3, 4, 5)), 1)
    val removeNthFromEnd1 = RemoveNthFromEnd().removeNthFromEnd(ListNode.quickListNode(arrayListOf(1, 2, 3, 4, 5)), 3)
    val removeNthFromEnd2 = RemoveNthFromEnd().removeNthFromEnd(ListNode.quickListNode(arrayListOf(1, 2, 3, 4, 5)), 5)
    val removeNthFromEnd3 = RemoveNthFromEnd().removeNthFromEnd(ListNode.quickListNode(arrayListOf(1, 2, 3, 4, 5)), 6)
    val removeNthFromEnd4 = RemoveNthFromEnd().removeNthFromEnd(ListNode.quickListNode(arrayListOf(1)), 1)

    println(removeNthFromEnd?.toString())
    println(removeNthFromEnd1?.toString())
    println(removeNthFromEnd2?.toString())
    println(removeNthFromEnd3?.toString())
    println(removeNthFromEnd4?.toString())
}


