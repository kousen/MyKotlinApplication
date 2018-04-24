package com.kousenit.mykotlinapplication

data class IcndbResult(val type: String, val value: JokeWrapper)

data class JokeWrapper(val id: Int, val joke: String, val categories: List<String>)
