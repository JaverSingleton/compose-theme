package ru.javersingleton.nested_themes.themes.common

import androidx.compose.runtime.Composable

interface StyleProvider<T> {
    @Composable
    operator fun invoke(): T
    val parent: StyleProvider<T>?
}

fun <T> lazyStyle(factory: @Composable () -> T): StyleProvider<T> =
    LazyStyle { factory() }

fun <T> constStyle(style: T): StyleProvider<T> = ConstStyle(style)

fun <T> lazyStyle(
    parent: StyleProvider<T>,
    factory: @Composable T.() -> T
): StyleProvider<T> =
    LazyStyle(
        parent
    ) { parent -> parent!!.factory() }

internal class LazyStyle<T>(
    override val parent: StyleProvider<T>? = null,
    private val factory: @Composable (parent: T?) -> T
) : StyleProvider<T> {

    @Composable
    override fun invoke(): T = factory(parent?.invoke())

}


internal class ConstStyle<T>(
    private val style: T
) : StyleProvider<T> {
    override val parent: StyleProvider<T>? = null

    @Composable
    override fun invoke(): T = style

}