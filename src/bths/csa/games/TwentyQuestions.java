package bths.csa.games;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class TwentyQuestions {
 
  public static void main(String[] args) {
    try {
      // fetch the document over HTTP
      Document doc = Jsoup.connect("http://y.20q.net/gsq-en?VFykQuOfVG9PCQEuPKxgjIo9tjcv.b.z9OEkCUQSe").get();
      
      // get the page title
      String title = doc.title();
      System.out.println("title: " + title);
      
      // get all links in page
      Elements links = doc.select("a[href]");
      for (Element link : links) {
        // get the value from the href attribute
        System.out.println("\nlink: " + link.attr("href"));
        System.out.println("text: " + link.text());
      }
    } catch (IOException e) {
    e.printStackTrace();
    }
  }
}
//i don't know how this works
/*
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements; 


public class TwentyQuestions {

    public static void main(String args[]) throws IOException{
        Document doc = Jsoup.connect("http://y.20q.net/gsq-en?bwoVjpPYKNCr_jMprOwhA2fuI.ajIq_y.fZ8QW1").get();  
        Elements links = doc.select("a[href]");  
        for (Element link : links) 
        {  
            System.out.println("\nlink : " + link.attr("href"));  
            System.out.println("text : " + link.text());
        }
    }
}
*/