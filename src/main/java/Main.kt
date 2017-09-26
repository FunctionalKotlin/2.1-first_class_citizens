// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser

fun parseAsJson(string: String): Map<String, Any?> =
    StringBuilder(string).let { Parser().parse(it) as JsonObject }.map

fun parseAsXML(string: String): Map<String, Any?> = emptyMap()

fun parseAsHTML(string: String): Map<String, Any?> = emptyMap()

fun main(args: Array<String>) {
    val jsonObject = parseAsJson("{\"data\": 42}")

    println(jsonObject)
}