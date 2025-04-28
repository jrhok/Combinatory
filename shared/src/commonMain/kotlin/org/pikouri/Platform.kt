package org.pikouri

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform