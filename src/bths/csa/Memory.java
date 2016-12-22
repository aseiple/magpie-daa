package bths.csa;

import java.util.LinkedList;
import java.util.Queue;

public class Memory {
	
	private Queue<String> questions = new LinkedList();
	private Queue <String> answers = new LinkedList();
	
	public void storeQuestions(String question)
	{
		//String[] questions = new String[questions.length];
		questions.offer(question);
	}
	
	public boolean alreadyAsked (String question)
	{
		return questions.contains(question);
	}
}
