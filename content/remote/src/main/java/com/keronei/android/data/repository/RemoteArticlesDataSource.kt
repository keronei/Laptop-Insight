package com.keronei.android.data.repository

import com.keronei.android.data.Constants.FEED_URL
import com.keronei.android.data.xmlparser.ArticleXmlParser
import com.keronei.android.domain.models.Article
import io.ktor.client.*
import io.ktor.client.call.receive
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.xmlpull.v1.XmlPullParser
import java.nio.charset.Charset

class RemoteArticlesDataSource(private val ktorClient: HttpClient
    ) {

    val news = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<rss>" +
            "<channel>" +
            "<title>Laptop Mag</title>" +
            "<link>https://www.laptopmag.com/feeds/all</link>" +
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
            "    <item>\n" +
    "<title>Best weekend deals and sales for home</title>\n" +
            "      <title>Best weekend deals and sales for home</title>\n" +
            "      <link>https://www.laptopmag.com/uk/news/best-weekend-deals-sales</link>\n" +
            "      <description>The best tech deals this weekend from laptops to wearables </description>\n" +
            "      <enclosure url=\"http://cdn.mos.cms.futurecdn.net/i8tp8hqttLgSmuipDuyuSD.jpg\" length=\"0\" type=\"image/jpeg\"></enclosure>\n" +
            "      <guid>https://www.laptopmag.com/uk/news/best-weekend-deals-sales</guid>\n" +
            "      <pubDate>Fri, 21 Jan 2022 00:15:38 +0000</pubDate>\n" +
            "    </item>" +
            "    <item>\n" +
            "      <title>Top deals and sales for home</title>\n" +
            "      <link>https://www.laptopmag.com/uk/news/best-weekend-deals-sales</link>\n" +
            "      <description>The best tech deals this weekend from laptops to wearables </description>\n" +
            "      <enclosure url=\"http://cdn.mos.cms.futurecdn.net/i8tp8hqttLgSmuipDuyuSD.jpg\" length=\"0\" type=\"image/jpeg\"></enclosure>\n" +
            "      <guid>https://www.laptopmag.com/uk/news/best-weekend-deals-sales</guid>\n" +
            "      <pubDate>Fri, 21 Jan 2022 00:15:38 +0000</pubDate>\n" +
            "    </item>" +
            "</channel>" +
            "</rss>"

     fun fetchRemoteArticles(parser: XmlPullParser): Flow<List<Article>> = flow {

         //val articles = ArticleXmlParser(parser).parse(news.byteInputStream(Charset.defaultCharset()))

        // emit(articles)


        ktorClient.use { client ->
            val response: HttpResponse = client.get(FEED_URL)

            if (response.status.isSuccess()) {
                val contentAsString: String = response.receive()
                val stream = contentAsString.byteInputStream()
                val articles = ArticleXmlParser(parser).parse(stream)
                emit(articles)
            } else {
                emit(emptyList<Article>())
            }
        }
    }
}