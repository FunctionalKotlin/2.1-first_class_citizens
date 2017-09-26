// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser

fun parse(string: String): Map<String, Any?> =
    StringBuilder(string).let { Parser().parse(it) as JsonObject }.map

fun main(args: Array<String>) {
    val jsonObject = parse("{\"data\": 42}")

    println(jsonObject)
}