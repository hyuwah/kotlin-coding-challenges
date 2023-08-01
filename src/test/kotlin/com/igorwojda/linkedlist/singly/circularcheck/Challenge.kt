package com.igorwojda.linkedlist.singly.circularcheck

import com.igorwojda.linkedlist.singly.base.Solution1.Node
import com.igorwojda.linkedlist.singly.base.Solution1.SinglyLinkedList
import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun circularCheck(list: SinglyLinkedList<Char>): Boolean {
    return logExecutionTimeNano { SolutionA.circularCheck(list) }
}

/**
 * Two pointer same direction, slow & fast approach
 */
private object SolutionA {
    fun circularCheck(list: SinglyLinkedList<Char>): Boolean {
        var slow = list.head
        var fast = list.head

        while (slow != null && fast != null) { // if any pointer point to null then definitely not cyclic
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) return true // if the fast pointer catch up to / meet the slow pointer, then it's cyclic
        }
        return false
    }
}

private class Test {
    @Test
    fun `circular detects circular linked lists`() {
        val l = SinglyLinkedList<Char>()
        val a = Node('a')
        val b = Node('b')
        val c = Node('c')

        l.head = a
        a.next = b
        b.next = c
        c.next = b

        circularCheck(l) shouldBeEqualTo true
    }

    @Test
    fun `circular detects circular linked lists linked at the head`() {
        val l = SinglyLinkedList<Char>()
        val a = Node('a')
        val b = Node('b')
        val c = Node('c')

        l.head = a
        a.next = b
        b.next = c
        c.next = a

        circularCheck(l) shouldBeEqualTo true
    }

    @Test
    fun `circular detects non-circular linked lists`() {
        val l = SinglyLinkedList<Char>()
        val a = Node('a')
        val b = Node('b')
        val c = Node('c')

        l.head = a
        a.next = b
        b.next = c
        c.next = null

        circularCheck(l) shouldBeEqualTo false
    }
}
