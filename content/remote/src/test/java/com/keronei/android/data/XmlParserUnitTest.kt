package com.keronei.android.data


import android.util.Xml
import com.keronei.android.data.xmlparser.ArticleXmlParser
import com.keronei.android.domain.models.Article
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class XmlParserUnitTest {

    @Test
    fun parserParsersGivenStream() {

        val mockParser  = Xml.newPullParser()

        val parserMock = ArticleXmlParser(mockParser)

        val result = parserMock.parse(TestData.newsAsStream)

        val list = mock<List<Article>>()

        verify(parserMock)

        assertEquals( result.size, 0)
    }
}