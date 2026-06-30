import model.Student;
 import dao.StudentDAO;
import java.util.Scanner;
void main() {
    Scanner ip=new Scanner(System.in);
while(true) {
    System.out.println("-----Student Management System-----");
    System.out.println("1.Add Student\n 2.View Students \n 3.Exit");
    System.out.print("Enter your Choice:");
    int option=ip.nextInt();
    ip.nextLine();
    StudentDAO daos=new StudentDAO();
    switch (option) {
        case 1:
            System.out.print("Enter name:");
            String name = ip.nextLine();
            System.out.print("\nEnter Age:");
            int age = ip.nextInt();
            ip.nextLine();
            System.out.print("\nEnter Course:");
            String course = ip.nextLine();
            System.out.print("\n Enter email:");
            String email = ip.nextLine();

            Student stu = new Student(name, age, course, email);
            daos.addStudent(stu);
            break;
        case 2:
            List<Student> list=daos.viewStudents();
            if(list.isEmpty()){
                System.out.println("No Students Found ");
                break;
            }

            for (Student student : list) {
                System.out.println("---------------------");
                System.out.println("ID: "+student.getId());
                System.out.println("Name: "+student.getName());
                System.out.println("Age: "+ student.getAge());
                System.out.println("Course: "  +student.getCourse());
                System.out.println("Email: "+student.getEmail());
                System.out.println("----------------------");
            }
            break;
        case 3:
            System.out.println("THANK YOU ");
            return;
    }
}



 }

