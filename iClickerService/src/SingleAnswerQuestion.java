/*
 * A question that has a single answer
 * 
 * inv1 : @answer is a single letter
 * inv2 : @question is a question that only has one correct answer
 */


public class SingleAnswerQuestion implements Question 
{

	private String question;
	private String answer;
	//private int numAnswerChoices;
	
	public SingleAnswerQuestion(String q, String a)
	{
		question = q;
		answer = a;
	}
	
	@Override
	public String getQuestion() 
	{
		return question;
	}

	@Override
	public String getAnswer() 
	{
		return answer;
	}
	
	@Override
	public void setQuestion(String newQ)
	{
		question = newQ;
	}
	
	@Override
	public void setAnswer(String newA)
	{
		answer = newA;
	}

	

}
