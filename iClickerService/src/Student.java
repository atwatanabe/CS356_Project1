
import java.util.Random;

public class Student implements Comparable<Student>
{
	private String id;
	
	public Student(String id)
	{
		this.id = id;
	}
	
	public String getID()
	{
		return id;
	}
	
	public void answerSingleQuestion(IClickerService iClick, int numChoices)
	{
		Random rand = new Random((long)(Math.random() * 1000000));
		String ans = "";
		ans += (char)(rand.nextInt(numChoices) + 65);
		iClick.collectAnAnswer(this, ans);
	}
	
	public void answerMultiQuestion(IClickerService iClick, int numChoices)
	{
		//Random rand = new Random(System.currentTimeMillis());
		Random rand = new Random((long)(Math.random() * 1000000));
		
		int numAnswers = rand.nextInt(numChoices) + 1;	//choose a random number of answers to give, up to 
														//the total number of answer choices
		String ans = "";
		for (int i = 0; i < numAnswers; ++i)
		{
			ans += (char)(rand.nextInt(numAnswers) + 65) + " ";		//add a character and a space
		}
		ans = ans.substring(0, ans.length() - 1);					//remove the last space
		iClick.collectAnAnswer(this, ans);
	}
	
	
	
	@Override
	public int compareTo(Student other)
	{
		return id.compareTo(other.getID());
	}
	
	public boolean equals(Student other)
	{
		return compareTo(other) == 0;
	}
	
	@Override
	public int hashCode()
	{
		return id.hashCode();
	}
}
