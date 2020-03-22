package com.mslxl.filemanager.core.api.annotation

@MustBeDocumented
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Plugin(
    val name: String,
    val id: String,
    val version: String = "",
    val depOn: Array<String> = [],
    val info: String = ""
)

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Event()

