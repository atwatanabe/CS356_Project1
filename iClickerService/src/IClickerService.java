import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class IClickerService 
{
	
	private Question currentQuestion;
	private String currentAnswer;
	private Set<Student> students;		//students are unique; they have unique ID's
	private Hashtable<String, String> studentAnswers;
	private int[] answerStats;
	
	public IClickerService()
	{
		students = new HashSet<Student>();
		currentQuestion = new SingleAnswerQuestion("The answer to this question is A", "A");
		currentAnswer = currentQuestion.getAnswer();
		studentAnswers = new Hashtable<String, String>();
		answerStats = new int[currentAnswer.length() / 2 + 1];		//the number of times students choose each answer
	}
	
	public IClickerService(Set<Student> stu, Question q)
	{
		students = stu;
		currentQuestion = q;
		currentAnswer = q.getAnswer();
		studentAnswers = new Hashtable<String, String>();
		answerStats = new int[currentAnswer.length() / 2 + 1];
	}
	
	/*
	 * prints the current question to the console
	 */
	public void askQuestion()
	{
		System.out.println(currentQuestion.getQuestion());
	}
	
	/*
	 * pre : @q is a question with the appropriate number of answers
	 * 		 @q's answer is a String of characters separated by single spaces
	 * post: @currentQuestion and @currentAnswer are modified to @q and @q's answer
	 * 		 answerStats is re-initialized 
	 */
	public void setQuestion(Question q)
	{
		currentQuestion = q;
		currentAnswer = q.getAnswer();
		answerStats = new int[currentAnswer.length() / 2 + 1];
	}
	
	
	/*
	 * pre : @ans is a String of uppercase letters separated by single spaces
	 * post: @stu's answer is saved in @studentAnswers
	 * 			if @stu calls this method subsequent times, its answer is overwritten
	 */
	public void collectAnAnswer(Student stu, String ans)
	{
		studentAnswers.put(stu.getID(), ans);
	}
	
	public void reportResults()
	{
		Iterator<Student> iter = students.iterator();
		while (iter.hasNext())
		{
			Student temp = iter.next();
			String stuAnswer = studentAnswers.get(temp.getID());
			
			//this actually ignores invalid and duplicate answer choices
			for (int i = 0; i < answerStats.length; ++i)
			{
				if (stuAnswer.contains(new String(new char[]{(char)((int)('A' + i))})))		//probably should spread this out...
					//if (the student's answer contains A, B, C, ...)
				{
					++answerStats[i];	//increment the number of times students chose answer i
				}
					
			}
		}
		
		System.out.println("Student answers:\n");
		for (int i = 0; i < answerStats.length; ++i)
		{
			System.out.println((char)((int)'A' + i) + ": " + answerStats[i]);
		}
	}
}
