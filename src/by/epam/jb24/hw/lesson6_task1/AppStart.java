package by.epam.jb24.hw.lesson6_task1;

public class AppStart {
	// To declare array for list of groups
	private static Group[] arrListOfGroup = new Group[6];

	public static void main(String[] args) {

		// Students creation
		Student stud01 = new Student("Ivan", "Ivanov");
		Student stud02 = new Student("Petr", "Petrov");
		Student stud03 = new Student("Nikolay", "Nikolaev");
		Student stud04 = new Student("Vadim", "Vladimirov");
		Student stud05 = new Student("Maria", "Ivanova");
		Student stud06 = new Student("Kate", "Varivonchik");
		Student stud07 = new Student("Artem", "Shelenkov");

		// Add Student's score
		stud01.setScoreMathematics(5);
		stud02.setScoreMathematics(5);
		stud03.setScoreMathematics(3);
		stud04.setScoreMathematics(5);
		stud05.setScoreMathematics(2);
		stud06.setScoreMathematics(3);
		stud07.setScoreMathematics(5);

		stud01.setScoreBiology(5);
		stud02.setScoreBiology(5);
		stud03.setScoreBiology(3);
		stud04.setScoreBiology(2);
		stud05.setScoreBiology(5);
		stud06.setScoreBiology(2);
		stud07.setScoreBiology(5);

		stud01.setScoreChemistry(5);
		stud02.setScoreChemistry(5);
		stud03.setScoreChemistry(3);
		stud04.setScoreChemistry(4);
		stud05.setScoreChemistry(5);
		stud06.setScoreChemistry(3);
		stud07.setScoreChemistry(5);

		stud01.setScorePhysics(5);
		stud02.setScorePhysics(5);
		stud03.setScorePhysics(5);
		stud04.setScorePhysics(3);
		stud05.setScorePhysics(5);
		stud06.setScorePhysics(2);
		stud07.setScorePhysics(5);

		// Group creation & add group to array
		Group group01 = new Group("group01");
		addGroupToArr(group01);

		Group group02 = new Group("group02");
		addGroupToArr(group02);

		Group group03 = new Group("group03");
		addGroupToArr(group03);

		// Add students to group
		group01.addStudentToGroup(stud01);
		group01.addStudentToGroup(stud02);
		group01.addStudentToGroup(stud03);

		group02.addStudentToGroup(stud04);
		group02.addStudentToGroup(stud05);

		group03.addStudentToGroup(stud06);
		group03.addStudentToGroup(stud07);

		// Print average score for each group
		System.out.println("");
		System.out.println(
				"--------------------------------------Average score of Groups-----------------------------------------------------");
		for (int i = 0; i < arrListOfGroup.length; i++) {
			if (arrListOfGroup[i] != null) {
				System.out.println("Average score for " + arrListOfGroup[i].getGroupId() + " = "
						+ arrListOfGroup[i].averageGroupScore());
			}

		}

		// Print average score for each Students
		System.out.println("");
		System.out.println(
				"--------------------------------------Average score of Students-----------------------------------------------------");
		for (int i = 0; i < arrListOfGroup.length; i++) {
			if (!(arrListOfGroup[i] == null)) {
				for (int j = 0; j < arrListOfGroup.length; j++)
					if (!(arrListOfGroup[i].getArrStudentGroup()[j] == null)) {
						System.out.println("Average score for " + arrListOfGroup[i].getArrStudentGroup()[j].firstName
								+ " " + arrListOfGroup[i].getArrStudentGroup()[j].lastName + " = "
								+ arrListOfGroup[i].getArrStudentGroup()[j].averageStudentScore());
					}
			}
		}

		// Print Number of of high Achiever students
		System.out.println("");
		System.out.println(
				"------------------------------------Number of high Achiever-------------------------------------------------");
		System.out.println("Number of high Achiever is " + highAchiever(arrListOfGroup));

		// Print Number of students who has score 2
		System.out.println("");
		System.out.println(
				"------------------------------------Number of Bad students-------------------------------------------------");
		System.out.println("Number of students who has 2 is " + counOfBadStudent(arrListOfGroup));

		// Print List of Students
		System.out.println("");
		System.out.println(
				"------------------------------------List of Students with his score---------------------------------------------");
		for (int i = 0; i < arrListOfGroup.length; i++) {
			if (!(arrListOfGroup[i] == null)) {
				for (int j = 0; j < arrListOfGroup.length; j++) {
					if (!(arrListOfGroup[i].getArrStudentGroup()[j] == null)) {
						System.out.println(arrListOfGroup[i].getGroupId() + ": "
								+ arrListOfGroup[i].getArrStudentGroup()[j].firstName + " "
								+ arrListOfGroup[i].getArrStudentGroup()[j].lastName + " "
								+ arrListOfGroup[i].getArrStudentGroup()[j].scoreBiology + " "
								+ arrListOfGroup[i].getArrStudentGroup()[j].getScgetScoreChemistry() + " "
								+ arrListOfGroup[i].getArrStudentGroup()[j].getScoreMathematics() + " "
								+ arrListOfGroup[i].getArrStudentGroup()[j].getScorePhysics());
					}
				}
			}
		}
	}

	private static int counOfBadStudent(Group[] arrListOfGroup2) {
		int numOfBadStudent = 0;
		boolean checkBadScore = false;
		Group group;
		Student stud;

		for (int i = 0; i < arrListOfGroup.length; i++) {
			if (!(arrListOfGroup[i] == null)) {
				group = arrListOfGroup[i];
				for (int j = 0; j < group.getArrStudentGroup().length; j++) {
					if (!(group.getArrStudentGroup()[j] == null)) {
						stud = group.getArrStudentGroup()[j];
						checkBadScore = stud.isBadStudent();
						if (checkBadScore == true) {
							numOfBadStudent = numOfBadStudent + 1;
						}
					}
				}
			}
		}
		return numOfBadStudent;
	}

	private static int highAchiever(Group[] arrListOfGroup) {
		int achieverCounter = 0;
		double avrStudentScore = 0;
		Group group;
		Student stud;

		for (int i = 0; i < arrListOfGroup.length; i++) {
			if (!(arrListOfGroup[i] == null)) {
				group = arrListOfGroup[i];
				for (int j = 0; j < group.getArrStudentGroup().length; j++)
					if (!(group.getArrStudentGroup()[j] == null)) {
						stud = group.getArrStudentGroup()[j];
						avrStudentScore = stud.averageStudentScore();
						if (avrStudentScore == 5) {
							achieverCounter = achieverCounter + 1;
						}
					}
			}
		}
		return achieverCounter;
	}

	private static void addGroupToArr(Group group) {
		int maxGroup = 0;
		for (int i = 0; i < arrListOfGroup.length; i++) {
			if (arrListOfGroup[i] == null) {
				arrListOfGroup[i] = group;
				break;
			}
			maxGroup = maxGroup + 1;
		}
		if (maxGroup == arrListOfGroup.length) {
			System.out.println("There are not free places for Group");
		}
	}
}