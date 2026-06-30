import model.Student;
 import dao.StudentDAO;
import java.util.Scanner;
void main() {
    Scanner ip=new Scanner(System.in);
    System.out.println("-----Student Management System-----");
    System.out.println("1.Add Student \n 2.Exit");
    System.out.print("Enter your Choice:");
    int option=ip.nextInt();
    ip.nextLine();
while(option==2) {
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
            StudentDAO dao = new StudentDAO();
            dao.addStudent(stu);
            break;

        case 2:
            System.out.println("THANK YOU ");
            return;
    }
}



 }

