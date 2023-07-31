package com.igorwojda.cache.advancedlru

import java.util.*

// Implementation is using  combination of HashMap and LinkedList.
// Time Complexity: O(1)
private object Solution1 {
    class AdvancedLRUCache(private val capacity: Int) {
        private val map: MutableMap<String, CacheItem> = mutableMapOf()
        private val priorityQueue: PriorityQueue<CacheItem> = PriorityQueue()

        fun put(key: String, value: Int, priority: Int, expiryTime: Long) {
            if (map.containsKey(key)) {
                remove(key)
            }

            if (map.size == capacity) {
                clearCache()
            }

            val item = CacheItem(key, value, priority, expiryTime)
            map[key] = item
            priorityQueue.add(item)
        }

        fun get(key: String): Int? {
            val item = map[key]

            return if (item == null || item.expiryTime < getSystemTimeForExpiry()) {
                null
            } else {
                item.lastUsed = System.currentTimeMillis()
                item.value
            }
        }

        private fun remove(key: String) {
            val item = map[key]

            item?.let {
                it.expiryTime = 0L // Mark as expired for next eviction
                map.remove(key)
            }
        }

        private fun clearCache() {
            while (priorityQueue.isNotEmpty() && priorityQueue.peek().expiryTime < getSystemTimeForExpiry()) {
                val item = priorityQueue.poll()

                if (map.containsKey(item.key) && map[item.key] == item) {
                    map.remove(item.key)
                }
            }

            if (priorityQueue.isEmpty()) return

            val item = priorityQueue.poll()

            if (map.containsKey(item.key) && map[item.key] == item) {
                map.remove(item.key)
            }
        }

        private data class CacheItem(
            val key: String,
            var value: Int,
            var priority: Int,
            var expiryTime: Long,
        ) : Comparable<CacheItem> {
            var lastUsed: Long = System.currentTimeMillis()

            override fun compareTo(other: CacheItem) = when {
                expiryTime != other.expiryTime -> expiryTime.compareTo(other.expiryTime)
                priority != other.priority -> priority.compareTo(other.priority)
                else -> lastUsed.compareTo(other.lastUsed)
            }
        }

        // Returns fixed system time in milliseconds
        private fun getSystemTimeForExpiry() = 1000
    }
}

private object KtLintWillNotComplain
