// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import java.net.URL

interface MyParser {
    fun parse(string: String): Map<String, Any?>
}

class JsonParser: MyParser {
    override fun parse(string: String): Map<String, Any?> =
        StringBuilder(string).let { Parser().parse(it) as JsonObject }.map
}

class XMLParser: MyParser {
    override fun parse(string: String): Map<String, Any?> = emptyMap()
}

class HTMLParser: MyParser {
    override fun parse(string: String): Map<String, Any?> = emptyMap()
}

fun dataFrom(url: URL, parser: MyParser): Map<String, Any?> =
    url.readText().let { parser.parse(it) }

fun main(args: Array<String>) {
    val url = URL("https://api.github.com")

    val jsonObject = dataFrom(url, JsonParser())

    println(jsonObject)
}