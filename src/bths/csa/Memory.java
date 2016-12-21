package bths.csa;

import java.util.LinkedList;
import java.util.Queue;

public class Memory {
	
	private Queue questions = new LinkedList();
	private Queue answers = new LinkedList();
	
	public void getQuestion(String question)
	{
		questions.offer(question);
	}
	
	public void getAnswer(String answer)
	{
		answers.offer(answer);
	}
	
	public String giveAnswerTo(String question)
	{
		String[] questions = new String[questions.length];
		return question;
	}
}
