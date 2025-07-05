package org.example.dicerollgame

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform