package com.keronei.android.data

import com.keronei.android.data.helpers.parseDate
import com.keronei.android.domain.models.Article
import java.io.ByteArrayInputStream
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

object TestData {
    const val news = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<rss>" +
                "<channel>" +
                    "<title>Laptop Mag</title>" +
                    " <link>https://www.laptopmag.com/feeds/all</link>" +
                    "<description>Find the Perfect Laptop, Tablet or 2-in-1 for You</description>" +
                    "<pubDate>Tue, 25 Jan 2022 07:51:38 +0000</pubDate>" +
                    "    <item>\n" +
                    "      <title>Best weekend deals and sales to shop now</title>\n" +
                    "      <link>https://www.laptopmag.com/uk/news/best-weekend-deals-sales</link>\n" +
                    "      <description>The best tech deals this weekend from laptops to wearables </description>\n" +
                    "      <enclosure url=\"http://cdn.mos.cms.futurecdn.net/i8tp8hqttLgSmuipDuyuSD.jpg\" length=\"0\" type=\"image/jpeg\"></enclosure>\n" +
                    "      <guid>https://www.laptopmag.com/uk/news/best-weekend-deals-sales</guid>\n" +
                    "      <pubDate>Fri, 21 Jan 2022 00:15:38 +0000</pubDate>\n" +
                    "    </item>" +
                "</channel>" +
            "</rss>"

    val newsAsStream = news.byteInputStream(Charset.defaultCharset())

    private const val pubDate = "Fri, 21 Jan 2022 00:15:38 +0000"

    val article = Article(
        0,
        "Best weekend deals and sales to shop now",
        "https://www.laptopmag.com/uk/news/best-weekend-deals-sales",
        "The best tech deals this weekend from laptops to wearables",
        "http://cdn.mos.cms.futurecdn.net/i8tp8hqttLgSmuipDuyuSD.jpg",
        "https://www.laptopmag.com/uk/news/best-weekend-deals-sales",
        parseDate(pubDate)


    )
}