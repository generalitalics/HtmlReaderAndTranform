package ru.ruru.htmlreader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlReaderAndTranform {

//https://cnclip.net/video/-l8Ji17d65Y/%D0%BF%D0%B0%D1%80%D1%81%D0%B8%D0%BD%D0%B3-html-%D0%B2-java.html
    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<Article>();
        Document doc = Jsoup.connect("http://dnevniki.ykt.ru/П_П/529443").get();
        Elements h = doc.getElementsByAttributeValue("class","post-view__body");
        String s = h.text();
        System.out.println(s);
        String[] m = s.split(" ");
        System.out.println(m[5]);

                //post-view__body
    }
}
