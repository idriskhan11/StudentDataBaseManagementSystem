package p1;

import java.util.Comparator;

public class SortStudentById implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getId()-y.getId();
	}

}
