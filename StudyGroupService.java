package Service;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupService {
    private StudyGroup studyGroup;
    private List<User> userList = new ArrayList<>();

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public StudyGroup studyGroupCreator(Teacher teacher, List<Student> studentList) {
        return this.studyGroup = new StudyGroup(teacher, studentList);
    }

    public void create(String firstName, String secondName, String lastName, Type type) {
        int id = getTypeId(type);
        if (Type.Student == type) {
            Student student = new Student(id, firstName, secondName, lastName);
            userList.add(student);
        }
        if (Type.Teacher == type) {
            Teacher teacher = new Teacher(id, firstName, secondName, lastName);
            userList.add(teacher);
        }
    }

    private int getTypeId(Type type) {
        int id = 0;
        for (User user : userList) {
            if (user instanceof Teacher && type == Type.Teacher) {
                id = ((Teacher) user).getTeacherId();
            }
            if (user instanceof Student && type == Type.Student) {
                id = ((Student) user).getStudentId();
            }
        }
        return ++id;
    }

    private List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                studentList.add((Student) user);
            }
        }
        return studentList;
    }

    private List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Teacher) {
                teacherList.add((Teacher) user);
            }
        }
        return teacherList;
    }

    public List<Student> getStudentsListFromIds(List <Integer> studentsIds) {
        List<Student> studentListFromIds = new ArrayList<>();
        for (Integer id : studentsIds) {
            studentListFromIds.add(getAllStudents().get(id-1));
        }
        return studentListFromIds;
    }

    public Teacher getTeacherFromId(int teacherId) {
        return getAllTeachers().get(teacherId-1);
    }
}
