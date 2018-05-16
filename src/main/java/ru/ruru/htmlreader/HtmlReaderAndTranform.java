package ru.ruru.htmlreader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HtmlReaderAndTranform {

//https://cnclip.net/video/-l8Ji17d65Y/%D0%BF%D0%B0%D1%80%D1%81%D0%B8%D0%BD%D0%B3-html-%D0%B2-java.html
    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<Article>();
        List<String> words = new ArrayList<String>();
        Document doc = Jsoup.connect("http://dnevniki.ykt.ru/П_П/529443").get();
        Elements h = doc.getElementsByAttributeValue("class","post-view__body");
        String s = h.text();
        Pattern pattern = Pattern.compile("[^а-яА-Я0-9_]*([а-яА-Я0-9_]+)[^а-яА-Я0-9_]");
        Matcher m = pattern.matcher(s);
        //m.matches(s);
                //post-view__body
        while (m.find()) {
            words.add(m.group(1));
            System.out.println(words.stream().filter(m.group(1)::equals).count());
            if (words.stream().filter(m.group(1).toLowerCase()::equals).count() > 1) {
                s = s.replace(m.group(1),m.group(1).toUpperCase());
            }
        }
        while (m.find()) {

        }
        System.out.println(s);
        //System.out.println(s.toUpperCase());
        /*
        long ii = words.stream().filter(m.group(1)::equals).count();
        //System.out.println(ii);

        int sum = 0;
        for(String ss : words) {
            for(String gg : words) {
                if (ss.equals(gg)) {

                }
            }
            sum = 0;
        }
        //words.isEmpty()
        //System.out.println(words);
        */
    }
}
