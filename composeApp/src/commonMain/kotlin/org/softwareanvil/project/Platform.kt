package org.softwareanvil.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform