import Controller.Controller;


import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
      // Инициализируем контроллер
        Controller controller = new Controller();

      // Создаём студентов
        controller.createStudent("Иван", "Иванович", "Иванов");
        controller.createStudent("Петр", "Петрович", "Петров");
        controller.createStudent("Сергей", "Сергеевич", "Сергеев");
        controller.createStudent("Антон", "Антонович", "Антонов");
      
      // Создаём учителей
        controller.createTeacher("John", "Kylevich", "Connor");
        controller.createTeacher("Sarah", "Borisovna", "Connor");
        controller.createTeacher("Arnold", "Terminatorovich", "Swartz");

      // Создаём список ID студентов, которых хотим добавить в Учебную группу (Id первого студента = 1).
        List<Integer> studentsIdsList = Arrays.asList(3, 1, 4);
      
      // вызываем метод и в параметры заносим Id учителя и созданный выше список
        controller.createStudyGroup(1, studentsIdsList);
      
      // выводим созданную Учебную группу на печать
        controller.printStudyGroup();

    }
}
