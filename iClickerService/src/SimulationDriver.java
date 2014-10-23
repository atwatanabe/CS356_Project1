
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SimulationDriver 
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to the iClicker Service!\n");
		Set<Student> students = new HashSet<Student>();
		
		Random rand = new Random(System.currentTimeMillis());
		//use while loop to ensure that we fill the set (in case we happen to create two identical students)
		while (students.size() < 10)	//change number to add more students
		{
			Student stu = new Student(String.valueOf(rand.nextInt(10000)));
			students.add(stu);
		}
		
		Question q = new SingleAnswerQuestion("The answer is A.", "A");
		IClickerService iClick = new IClickerService(students, q);
		
		System.out.println("Question 1:");
		iClick.askQuestion();
		for (Student stu : students)
		{
			stu.answerSingleQuestion(iClick, 4);
		}
		iClick.reportResults();
		
		
		//ask more questions, report answers
	}
}
