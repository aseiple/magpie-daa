package bths.csa.games;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//Website "http://www2.20q.net/hang.pl"
public class Hangman 
{
	public static void main(String[] args) 
	{
		String link1 = "http://www2.20q.net/hang.pl?pfkG_rM_cnmtggZhh9AydYcsmWD_Ty4lZv_qMDScP.8LzGLydEck_PyMtoX-";
		int n = 0;
		try 
		{
			// fetch the document over HTTP
			Document doc = Jsoup.connect(link1).get();
      
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
		printTwDiAr(linklistMaker(link1, n));
		System.out.println(display_word(link1));
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
			String title = doc.title();
			System.out.println("title: " + title);
      
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
	public String getDifficulty()
	{
		return "What is the difficulty you want to play as?";
	}
	public String get_letter()
	{
		return "letter?";
	}
	public String get_difficulty_response(String statement)
	{
		String response = "";
		if (statement.toLowerCase().contains("hard")
				||statement.toLowerCase().contains("normal")
				||statement.toLowerCase().contains("bizzare"))
		{
			response = "What is the " + get_letter();
			//needs to get the set link to "difficulty link"
		}
		else
		{
			response = "Please pick a difficulty.";
		}
		return response;
	}
	public String get_letter_response(String pickedLink)
	{
		
		return display_word(pickedLink);
	}
	public static String[][] linklistMaker(String link1, int i)
	{
		//puts all the letter links into a 2-D array
		String useLink = link1.substring(0,19);
		System.out.println(link1);
		System.out.println(useLink);
		String[][] linklist = new String [i][2];
		try 
	    {
			// fetch the document over HTTP
			Document doc = Jsoup.connect(link1).get();
	      
			// get the page title
			//String title = doc.title();
			//System.out.println("title: " + title);
	      
			// get all links in page
			Elements links = doc.select("a[href]");
			int m = 0;
			for (Element link : links) 
			{
				if (m<i)
	    	  	{
					linklist [m][0] = link.text();
					linklist [m][1] = useLink + link.attr("href");
					m++;
	    	  	}
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
			if (list[x][0] == item)
			{
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
			System.out.println();
		}
	}
}