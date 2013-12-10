public class Student
{
	int exams = 0;
	float gradeArray[];

	public Student(int totalExams)
	{
		exams = totalExams;
		gradeArray = new float[exams];
	}

	/**
	* Sets the value of studentGrade to gradeArray
	*/
	public void setGrades(float studentGrade, int counter)
	{
		gradeArray[counter] = studentGrade;
	}

	/**
	* Returns the gradeArray value
	*/
	public float getGrades(int counter)
	{
		return gradeArray[counter];
	}
}

