package com.soywiz.korge.newui

import kotlin.reflect.*

inline fun <T> uiObservable(value: T, noinline observe: () -> Unit) = UiObservable(value, observe)

class UiObservable<T>(val initial: T, val observe: () -> Unit) {
	var currentValue = initial

	operator fun getValue(obj: Any, prop: KProperty<*>): T {
		return currentValue
	}

	operator fun setValue(obj: Any, prop: KProperty<*>, value: T) {
		currentValue = value
		observe()
	}
}
