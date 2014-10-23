/*
 * A question that has more than one correct answer
 * 
 * inv1 : @answer is a series of letters separated by single spaces
 * inv2 : @question is a question with more than one correct answer
 */

public class MultiAnswerQuestion implements Question 
{
	
	private String question;
	private String answer;
	
	public MultiAnswerQuestion(String q, String a)
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
