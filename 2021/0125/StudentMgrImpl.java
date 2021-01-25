
public class StudentMgrImpl {
	private static StudentMgrImpl instance = new StudentMgrImpl();
	private StudentMgrImpl() {
		
	}
	public static StudentMgrImpl getinstance() {
		return instance;
	}
	
	/** 교육생정보를 저장하기 위한 배열 */
	private Student[] students = new Student[100];
	/** 저장된 교육생 정보의 갯수를 기억하는 변수 */
	private int index = 0;

	/** 교육생 정보를 저장하는 메서드 */
	public void add(Student student) {
		if(index<100) {
			students[index] = student;
			index++;
		} else {
			System.out.println("학생 수가 너무 많습니다.");
		}
	}

	/** 모든 교육생 정보를 리턴하는 메서드 */
	public Student[] search() {
		Student[] newStudents = new Student[index];
		for(int i=0; i<index; i++) {
			newStudents[i] = students[i];
		}
		return newStudents;
	}

	/** 저장된 교육생정보 중 교육생번호를 검색하여 리턴하는 메서드 */
	public Student search(int studentNo) {
		for(int i=0; i<index; i++) {
			if(students[i].getStudentNo()==studentNo) return students[i];
		}
		return null;
	}

	/** 저장된 교육생정보 중 교육생이름을 검색하여 리턴하는 메서드 */
	public Student[] search(String name) {
		Student[] newStudents = null;
		int count = 0;
		for(int i=0; i<index; i++) {
			if(students[i].getName().equals(name)) {
				count++;
			}
		}
		newStudents = new Student[count];
		int index_new=0;
		for(int i=0; i<index; i++) {
			if(students[i].getName().equals(name)) {
				newStudents[index_new] = students[i];
				index_new++;
			}
		}

		return newStudents;
	}

	/** 저장된 교육생정보 중 교육생번호를 검색하여 지역과 반번호를 수정하는 메서드 */
	public boolean update(int studentNo, String area, int classNo) {
		for(int i=0; i<index; i++) {
			if(students[i].getStudentNo() == studentNo) {
				students[i].setArea(area);
				students[i].setClassNo(classNo);
				return true;
			}
		}
		return false;
	}

	/** 저장된 교육생정보 중 교육생번호를 검색하여 교육생을 삭제하는 메서드 */
	public boolean delete(int studentNo) {
		for(int i=0; i<index; i++) {
			if(students[i].getStudentNo() == studentNo) {
				students[i] = students[index-1];
				students[index] = null;
				index--;
				return true;
			}
		}
		// 구현 하세요.

		return false;
	}

}

