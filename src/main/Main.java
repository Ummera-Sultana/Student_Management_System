import model.Student;
 import dao.StudentDAO;

import java.util.Scanner;
void main() {
    Scanner ip=new Scanner(System.in);
while(true) {
    System.out.println("========================================");
    System.out.println("      Student Management System");
    System.out.println("=========================================");
    System.out.println(" 1.Add Student\n 2.View Students \n3.Search Student \n 4.Update Students Details\n5.Delete Student\n 6.Exit");
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
            System.out.println("Select the way to search\n 1.Search Student By Id \n2.Search student By Name");
            int ops=ip.nextInt();
            ip.nextLine();
            switch(ops) {
                case 1:
                    System.out.print("Enter ID of Student:");
                    int id = ip.nextInt();
                    ip.nextLine();

                    Student sts = daos.searchStudentById(id);
                    if (sts != null) {
                        System.out.println("---------------------");
                        System.out.println("ID: " + sts.getId());
                        System.out.println("Name: " + sts.getName());
                        System.out.println("Age: " + sts.getAge());
                        System.out.println("Course: " + sts.getCourse());
                        System.out.println("Email: " + sts.getEmail());
                        System.out.println("----------------------");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 2:
                    System.out.print("Enter the Name of Student:");
                    String nam = ip.nextLine();

                    List<Student> sts2 = daos.searchStudentByName(nam);
                    if (sts2.isEmpty()) {
                        System.out.println("No Students Found");
                    } else {
                        for (Student student : sts2) {
                            System.out.println("---------------------");
                            System.out.println("ID: " + student.getId());
                            System.out.println("Name: " + student.getName());
                            System.out.println("Age: " + student.getAge());
                            System.out.println("Course: " + student.getCourse());
                            System.out.println("Email: " + student.getEmail());
                            System.out.println("----------------------");
                        }
                    }
                        break;
                        case 3:
                            return;

                default:
                    System.out.println("Invalid choice! Please try again.");

                    }
                    break;



        case 4:
            System.out.println("Enter ID");
            int ids=ip.nextInt();
            ip.nextLine();
            System.out.print("Enter name:");
            String names = ip.nextLine();
            System.out.print("\nEnter Age:");
            int ages = ip.nextInt();
            ip.nextLine();
            System.out.print("\nEnter Course:");
            String courses = ip.nextLine();
            System.out.print("\n Enter email:");
            String emails = ip.nextLine();
            Student st1=new Student(ids,names,ages,courses,emails);

            if(daos.updateStudents(st1)){
                System.out.println("Student Updated Succesfully");
            }else{
                System.out.println("Student ID not found!");
            }
            break;
        case 5:
            System.out.println("Enter ID");
            int ID=ip.nextInt();
            if(daos.deleteStudentsById(ID)){
                System.out.println("Student Deleted Succesfully");
            }else{
                System.out.println("Student Not Found!");
            }
            break;


        case 6:
            System.out.println("THANK YOU ");
            return;
        default:
            System.out.println("Invalid choice! Please try again.");
    }
}



 }

