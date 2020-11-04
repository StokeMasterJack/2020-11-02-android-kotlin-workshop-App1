package com.smartsoft.util

fun <T> List<T>.shuffledIf(shuffle: Boolean) = if (shuffle) this.shuffled() else this
typealias VF = () -> Unit