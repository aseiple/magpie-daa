package bths.csa;

public class Persona {
	private String name; 
	private String mood; //possibly create a "mood" class?
	private int age;
	private String favMovie[];
	private String favSports[];
	private String interest[];
	
	public Persona(String name)
	{
		this.name = name;
	}
	
	public void Mood(String mood)
	{
		this.mood = mood;
	}
	
	public void age(int age)
	{
		this.age = age;
	}
	private void favMovie(String[] movies)
	{
		favMovie = movies;
	}
	
	private void favSports(String[] sports)
	{
		favSports = sports;
	}
	
	private void interest(String[] interest)
	{
		this.interest = interest;
	}
}
