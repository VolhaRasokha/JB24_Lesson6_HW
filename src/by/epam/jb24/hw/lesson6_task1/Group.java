package by.epam.jb24.hw.lesson6_task1;

public class Group {
	private String groupId;
	private Student[] arrStudentGroup = new Student[6];

	public Group(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupId() {
		return groupId;
	}

	public Student[] getArrStudentGroup() {
		return arrStudentGroup;
	}

	public void addStudentToGroup(Student student) {
		int maxStudent = 0;
		for (int i = 0; i < arrStudentGroup.length; i++) {
			if (arrStudentGroup[i] == null) {
				arrStudentGroup[i] = student;
				maxStudent = maxStudent + 1;
				break;
			}
		}
		if (maxStudent == arrStudentGroup.length) {
			System.out.println("There are not free places");
		}

	}

	public double averageGroupScore() {
		double averageGroupScore = 0;
		double groupScore = 0;
		int countOfStudent = 0;

		for (int i = 0; i < this.getArrStudentGroup().length; i++) {
			Student stud = this.getArrStudentGroup()[i];
			if (stud != null) {
				groupScore = groupScore + stud.averageStudentScore();
				countOfStudent = countOfStudent + 1;
			}
		}
		averageGroupScore = groupScore / countOfStudent;
		return averageGroupScore;
	}

}
