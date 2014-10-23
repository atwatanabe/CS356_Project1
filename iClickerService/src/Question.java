/*
 * Describes the behaviors/attributes that all Questions must have: a question in the form of a String,
 * 		an answer in the form of a string
 */


public interface Question 
{	
	
	public String getQuestion();
	public String getAnswer();
	
	public void setQuestion(String newQ);
	public void setAnswer(String newA);
	
}
