package com.keronei.android.data.xmlparser

import android.util.Xml
import com.keronei.android.data.helpers.parseDate
import com.keronei.android.domain.models.Article
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import timber.log.Timber
import java.io.IOException
import java.io.InputStream

private val nameSpaces: String? = null

class ArticleXmlParser(var parser: XmlPullParser) {
    @Throws(XmlPullParserException::class, IOException::class)
    fun parse(inputStream: InputStream): List<Article> {
        inputStream.use { inputStreamInstance ->
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(inputStreamInstance, null)
            parser.nextTag()//roll through xml tag

            parser.nextTag()//roll through rss tag
            return readChannel(parser)
        }
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readChannel(parser: XmlPullParser): List<Article> {
        val items = mutableListOf<Article>()

        parser.require(XmlPullParser.START_TAG, nameSpaces, "channel")
        while (parser.next() != XmlPullParser.END_TAG) {

            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }

            //look for item tag
            if (parser.name == "item") {
                val processedItem = readItem(parser)
                items.add(processedItem)
            } else {
                skip(parser, )
            }
        }

        return items
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun skip(parser: XmlPullParser) {

        if (parser.eventType != XmlPullParser.START_TAG) {
            throw IllegalStateException()
        }
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.END_TAG -> depth--
                XmlPullParser.START_TAG -> depth++
            }
        }
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readItem(parser: XmlPullParser): Article {
        parser.require(XmlPullParser.START_TAG, nameSpaces, "item")

        var title: String? = null
        var link: String? = null
        var description: String? = null
        var banner: String? = null
        var guid: String? = null
        var publicationDate: String? = null

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }

            when (parser.name) {
                "title" -> title = readTitle(parser)
                "link" -> link = readLink(parser)
                "description" -> description = readDescription(parser)
                "enclosure" -> banner = readEnclosure(parser)
                "guid" -> guid = readGuid(parser)
                "pubDate" -> publicationDate = readPubDate(parser)

                else -> skip(parser)
            }
        }

        return Article(
            0,
            title ?: "",
            link ?: "",
            description ?: "",
            banner ?: "",
            guid ?: "",
            parseDate(publicationDate ?: "Thu, 20 Jan 2022 16:44:33 +0000")
        )
    }


    @Throws(XmlPullParserException::class, IOException::class)
    private fun readPubDate(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, nameSpaces, "pubDate")
        val pubDate = readText(parser)
        parser.require(XmlPullParser.END_TAG, nameSpaces, "pubDate")
        return pubDate
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }

        return result
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readGuid(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, nameSpaces, "guid")

        val guid: String = readText(parser)

        parser.require(XmlPullParser.END_TAG, nameSpaces, "guid")

        return guid

    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readEnclosure(parser: XmlPullParser): String {
        var bannerUrl = ""
        parser.require(XmlPullParser.START_TAG, nameSpaces, "enclosure")

        val tag = parser.name
        val imageLinkType = parser.getAttributeValue(null, "type")

        if (tag == "enclosure") {
            if (imageLinkType == "image/jpeg") {
                bannerUrl = parser.getAttributeValue(null, "url")
                parser.nextTag()
            }
        }

        // parser.require(XmlPullParser.END_TAG, nameSpaces, "enclosure")

        return bannerUrl

    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readDescription(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, nameSpaces, "description")

        val description: String = readText(parser)

        parser.require(XmlPullParser.END_TAG, nameSpaces, "description")

        return description
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readLink(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, nameSpaces, "link")

        val link: String = readText(parser)

        parser.require(XmlPullParser.END_TAG, nameSpaces, "link")

        return link
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readTitle(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, nameSpaces, "title")

        val title: String = readText(parser)

        parser.require(XmlPullParser.END_TAG, nameSpaces, "title")

        return title

    }
}