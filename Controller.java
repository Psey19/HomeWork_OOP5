package Controller;


import Model.Student;
import Model.StudyGroup;
import Model.Teacher;
import Model.Type;
import Service.StudyGroupService;
import View.StudyGroupView;

import java.util.List;


public class Controller {
    private StudyGroupService service = new StudyGroupService();
    private StudyGroupView view = new StudyGroupView();

    public void createStudent(String firstName, String secondName, String lastName){
        service.create(firstName, secondName, lastName, Type.Student);
    }

    public void createTeacher(String firstName, String secondName, String lastName){
        service.create(firstName, secondName, lastName, Type.Teacher);
    }
  
// Метод по созданию Учебной группы по заданным Id учителя из списка всех созданных учителей
// и списка выбранных Id студентов из списка всех созданных студентов
// (перед запуском метода, нужно будет в main создать список Id студентов вручную).
  
    public StudyGroup createStudyGroup(int teacherId, List <Integer> studentsIds){
        Teacher teacher = service.getTeacherFromId(teacherId);
        List<Student> studentList = service.getStudentsListFromIds(studentsIds);
        return service.studyGroupCreator(teacher, studentList);
    }


    public void printStudyGroup() {
        view.printStudyGroup(service.getStudyGroup());
    }
}

