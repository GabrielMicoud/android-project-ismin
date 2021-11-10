package com.ismin.android

class Monumentshelf {

    private val storage = HashMap<String, Monument>()

    fun addMonument(aMonument: Monument) {
        storage[aMonument.objectid] = aMonument
    }

    fun getMonument(objectid: String): Monument? {
        return storage[objectid]
    }

    fun getAllMonuments(): ArrayList<Monument> {
        return ArrayList(storage.values.sortedBy { it.objectid })
    }

    fun getTotalNumberOfMonuments(): Int {
        return storage.size;
    }

    fun clear() {
        storage.clear()
    }

}