//Darren Kong
//AP Java
//December 22, 2016

package bths.csa.games;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//Website "http://www2.20q.net/hang.pl"
public class Hangman 
{
	public static String link1 = "http://www2.20q.net/hang.pl";
	public static int n = 0;
	public static String letters [] = new String[0];
	public static void main(String[] args) 
	{
		
		try 
		{
			// fetch the document over HTTP
			Document doc = Jsoup.connect("http://www2.20q.net/hang.pl?NVjE8BkSJGmYNkzbDMF").get();
			// get the page title
			String title = doc.title();
			System.out.println("title: " + title);
			// get all links in page
			Elements links = doc.select("a[href]");
			// use font[color] for used letters
			// use font[size] to display the word.
			for (Element link : links) 
			{
				System.out.println("\nlink: " + link.attr("href"));
				System.out.println("text: " + link.text());
				n++;
				// get the value from the href attribute
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		//get_letter_response("a");
		//System.out.println(n);
		//System.out.println("error below");
		//printTwDiAr(linklistMaker_letter("http://www2.20q.net/hang.pl?NVjE8BkSJGmYNkzbDMF",n));
		//link1 = twodi_list_search(linklistMaker_difficulty(link1,n),"Hard");
		//System.out.println(display_word(link1));
		//debugging
	}
	public static String display_word(String link)
	//gets a String link and displays the current word
	//Ex: "-o-------"
	{
		String response = "";
		try 
		{
			// fetch the document over HTTP
			Document doc = Jsoup.connect(link).get();
      
			// get the page title
			//String title = doc.title();
			//System.out.println("title: " + title);
      
			// get all links in page
			Elements links = doc.select("font[size]");
			// use font[color] for used letters
			// use font[size] to display the word.
			response = "So far: " + links.text().substring(0,links.text().indexOf(' '));
			//cuts off string at first whitespace
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return response;
	}
	public String getGreeting()
	{
		return "Hello, let's play Hangman.";
	}
	public String getParting()
	{
		return "I hope you enjoyed our game. Bye.";
	}
	public String getDifficulty()
	{
		return "What is the difficulty you want to play in?";
	}
	public String get_letter()
	{
		return "What is the letter?";
	}
	public String get_difficulty_response(String statement)
	{
		String response = "";
		if (statement.toLowerCase().contains("hard")
				||statement.toLowerCase().contains("normal")
				||statement.toLowerCase().contains("bizzare"))
		{
			response = get_letter();
			//System.out.println(link1);
			n=5;
			link1 = twodi_list_search(linklistMaker_difficulty(link1,n),"Hard");
			//System.out.println(link1);
			n=33;
		}
		else
		{
			response = "Fine be that way";
		}
		return response;
	}
	public String get_letter_response(String letter)
	{
		n--;
			//System.out.println(letter);
			link1=twodi_list_search(linklistMaker_letter(link1,n),letter);
			
			//System.out.println("Error" + link1);
			//System.out.println(display_word(link1));
			return display_word(link1);
	}
	public static String[][] linklistMaker_letter(String link2, int i)
	{
		//puts all the difficulty links into a 2-D array
		String useLink = link2.substring(0,19);
		//System.out.println(link2);
		//System.out.println(useLink);
		String[][] linklist = new String [i][2];
		try 
	    {
			// fetch the document over HTTP
			Document doc = Jsoup.connect(link2).get();
	      
			// get the page title
			//String title = doc.title();
			//System.out.println("title: " + title);
	      
			// get all links in page
			Elements links = doc.select("a[href]");
			int m = 0;
			for (Element link : links) 
			{
					linklist [m][0] = link.text();
					linklist [m][1] = useLink + link.attr("href");
					m++;
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return linklist;
	}
	public static String[][] linklistMaker_difficulty(String link2, int i)
	{
		//puts all the difficulty links into a 2-D array
		String useLink = link2.substring(0,19);
		//System.out.println(link2);
		//System.out.println(useLink);
		String[][] linklist = new String [i][2];
		try 
	    {
			// fetch the document over HTTP
			Document doc = Jsoup.connect(link2).get();
	      
			// get the page title
			//String title = doc.title();
			//System.out.println("title: " + title);
	      
			// get all links in page
			Elements links = doc.select("a[href]");
			int m = 0;
			for (Element link : links) 
			{
					linklist [m][0] = link.text();
					linklist [m][1] = useLink + link.attr("href");
					m++;
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return linklist;
	}
	public static String twodi_list_search(String[][] list, String item)
	{
		for(int x = 0; x<list.length ; x++)
		{
			if (list[x][0].compareToIgnoreCase(item)==0)
			{
				//System.out.println(list[x][1]);
				return list[x][1];
				//returns the link address for the search item
			}
		}
		return null;
		//return null because it needs another return value if it cannot be found
	}
	public static void printTwDiAr(String[][] arry2)
	{
		System.out.println();
		for(int a = 0; a < arry2.length; a++)
		{
			for( int b = 0; b < arry2[0].length; b++)
			{
				System.out.print(arry2[a][b]+ " ");
			}
			//System.out.println();
		}
	}
}