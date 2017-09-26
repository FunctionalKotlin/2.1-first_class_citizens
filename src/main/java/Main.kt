// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import java.net.URL

fun parseAsJson(string: String): Map<String, Any?> =
    StringBuilder(string).let { Parser().parse(it) as JsonObject }.map

fun parseAsXML(string: String): Map<String, Any?> = emptyMap()

fun parseAsHTML(string: String): Map<String, Any?> = emptyMap()

fun dataFrom(url: URL, parserType: Int): Map<String, Any?> =
    url.readText().let {
        when (parserType) {
            1 -> parseAsJson(it)
            2 -> parseAsHTML(it)
            3 -> parseAsXML(it)
            else -> emptyMap()
        }
    }

fun main(args: Array<String>) {
    val url = URL("https://api.github.com")

    val jsonObject = dataFrom(url, 1)

    println(jsonObject)
}