import java.util.Scanner;

public class GradeCalc
{
	static float		grade;
	static int			totalExams;
	static int			totalStudents;
	static Student 		student[];

	/**
	* The error() method checks to see if the user inputs a valid
	* number of students or exams and returns true or false
	*/
	public boolean error(int value)
	{
		return(value >= 0 && value <= 10);
	}

	/**
	* The errorCheck() method checks to see if the user inputs a valid
	* grade value and returns true or false
	*/
	public boolean errorCheck(double value)
	{
		return(value >= 0 && value <= 100);
	}

	/**
	* The initializeStudents() method instantiates each index of the student array
	* based on the number of students provided
	*/
	public void initializeStudents(Student studentArray[], int totalExams, int totalStudents)
	{
		for(int i = 0; i < totalStudents; i ++)
		{
			studentArray[i] = new Student(totalExams);
		}
	}

	/**
	* The printStudents() method prints off a chart of students and exam scores
	*/
	public void printStudents(Student studentArray[], int totalExams, int totalStudent)
	{
		for(int z = 0; z < totalExams; z ++)
		{
			System.out.print("    Exam  " + (z+1));
		}
		System.out.println(" ");
		for(int x = 0; x < totalStudents; x ++)
		{
			System.out.print("S" + (x+1) + ": ");
			for(int y = 0; y < totalExams; y ++)
			{
				if(studentArray[x].getGrades(y) < 10)
				{
					System.out.print(String.format("%.3f", studentArray[x].getGrades(y)) + "      ");
				}
				else if(studentArray[x].getGrades(y) >= 10 && studentArray[x].getGrades(y) < 100)
				{
					System.out.print(String.format("%.2f", studentArray[x].getGrades(y)) + "      ");
				}
				else
				{
					System.out.print(String.format("%.1f", studentArray[x].getGrades(y)) + "      ");
				}
			}
			System.out.println(" ");
		}
	}

	/**
	* The max() method finds the highest exam score and returns it
	*/
	public static float max(Student myStudent[], int totalExams, int totalStudents)
	{
		float maxVal = 0;
		for(int i = 0; i < totalStudents; i ++)
		{
			for(int j = 0; j < totalExams; j ++)
			{
				if(myStudent[i].getGrades(j) > maxVal)
				{
					maxVal = myStudent[i].getGrades(j);
				}
			}
		}
		return maxVal;
	}

	/**
	* The min() method finds the lowest exam score and returns it
	*/
	public static float min(Student myStudent[], int totalExams, int totalStudents)
	{
		float minVal = 100;
		for(int i = 0; i < totalStudents; i ++)
		{
			for(int j = 0; j < totalExams; j ++)
			{
				if(myStudent[i].getGrades(j) < minVal)
				{
					minVal = myStudent[i].getGrades(j);
				}
			}
		}
		return minVal;
	}

	/**
	* The average() method finds the total score of exams and divides by the number of total exams
	*/
	public static float average(Student myStudent[], int totalExams, int totalStudents)
	{
		float averageGrade = 0;
		for(int i = 0; i < totalStudents; i ++)
		{
			for(int j = 0; j < totalExams; j ++)
			{
				averageGrade += myStudent[i].getGrades(j);
			}
		}
		return averageGrade/(float)(totalExams*totalStudents);
	}

	public static void main(String[] args)
	{
		Scanner user_input = new Scanner(System.in); // Allows for user input

		GradeCalc myGradeCalc;
		myGradeCalc = new GradeCalc(); // Creates a new instance of the GradeCalc program

		System.out.print("Enter the number of students (1-10): ");
		totalStudents = user_input.nextInt(); // User input for totalStudents

		while(myGradeCalc.error(totalStudents) == false)
		{
			System.out.print("Invalid input, please enter valid input: ");
			totalStudents = user_input.nextInt();
		}
		System.out.println(" ");

		System.out.print("Enter the number of exams (1-10): ");
		totalExams = user_input.nextInt(); // User input for exams per person

		while(myGradeCalc.error(totalExams) == false)
		{
			System.out.print("Invalid input, please enter valid input: ");
			totalExams = user_input.nextInt();
		}

		System.out.println(" ");

		Student student[] = new Student[totalStudents]; // Declares an array of students
		myGradeCalc.initializeStudents(student, totalExams, totalStudents); // Instantiates a student in each index of the student array

		/*
		* The nested for loop makes sure there are an equal number of exams per student
		*/
		for(int i = 0; i < totalStudents; i ++) // Loops through the number of students
		{
			for(int j = 0; j < totalExams; j ++) // Loops through the number of exams
			{
				System.out.print("Enter Student " + (i+1) + "'s grade for Exam " + (j+1) + " (0-100): ");
				grade = user_input.nextFloat();

				while(myGradeCalc.errorCheck(grade) == false)
				{
					System.out.print("Invalid input, please enter valid input: ");
					grade = user_input.nextFloat();
				}
				student[i].setGrades(grade, j); // Calls the setGrades() method from the Student class
			}
		}

		myGradeCalc.printStudents(student, totalExams, totalStudents);
		System.out.println(" ");

		System.out.println("Max score is " +String.format("%.2f", myGradeCalc.max(student, totalExams, totalStudents)));
		System.out.println("Min score is " +String.format("%.2f", myGradeCalc.min(student, totalExams, totalStudents)));
		System.out.println("Average score is " +String.format("%.2f", myGradeCalc.average(student, totalExams, totalStudents)));
	}
}