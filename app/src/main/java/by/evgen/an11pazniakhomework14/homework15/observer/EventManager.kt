package by.evgen.an11pazniakhomework14.homework15.observer

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.set



class EventManager(vararg strings: String) {
    private var listeners: MutableMap<String, MutableList<Listener>> = HashMap()

    init {
        for (operation in strings) {
            listeners[operation] = ArrayList()
        }
    }

    fun subscribe(eventType: String, listener: Listener) {
        val operationListener = listeners[eventType]
        operationListener?.add(listener)
    }

    fun unsubscribe(eventType: String, listener: Listener) {
        val operationListener = listeners[eventType]
        operationListener?.remove(listener)
    }

    fun notify(eventType: String, text: String) {
        val operationListeners: List<Listener>? = listeners[eventType]
        if (operationListeners != null) {
            for (listener in operationListeners) {
                listener.update(eventType, text)
            }
        }
    }
}