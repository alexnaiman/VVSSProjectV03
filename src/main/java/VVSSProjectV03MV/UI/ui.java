package VVSSProjectV03MV.UI;

import java.io.IOException;
import java.util.Scanner;

import VVSSProjectV03MV.Exceptions.*;
import VVSSProjectV03MV.Service.XMLFileService.AbstractXMLService;
import VVSSProjectV03MV.Service.XMLFileService.GradeXMLService;
import VVSSProjectV03MV.Service.XMLFileService.StudentXMLService;
import VVSSProjectV03MV.Service.XMLFileService.AssignmentXMLService;

public class ui {

    StudentXMLService studentXMLService;
    AssignmentXMLService assignmentXMLService;
    GradeXMLService gradeXMLService;

    public ui(StudentXMLService studentXMLService,
              AssignmentXMLService assignmentXMLService,
              GradeXMLService gradeXMLService) {
        this.studentXMLService = studentXMLService;
        this.assignmentXMLService = assignmentXMLService;
        this.gradeXMLService = gradeXMLService;

    }

    public void printAllEntities(AbstractXMLService srv) {
        srv.findAll().forEach(x -> System.out.println(x));
    }


    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        String id, name, group, email, teacher;
        System.out.println("Student ID:");
        id = scanner.nextLine();
        System.out.println("Student name:");
        name = scanner.nextLine();
        System.out.println("Student group:");
        group = scanner.nextLine();
        System.out.println("Student email:");
        email = scanner.nextLine();
        System.out.println("Student teacher:");
        teacher = scanner.nextLine();
        String[] params = {id, name, group, email, teacher};
        try {
            studentXMLService.add(params);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void addAssignment() {
        Scanner scanner = new Scanner(System.in);
        String id, description, deadline, startline;
        System.out.println("Assignment ID:");
        id = scanner.nextLine();
        System.out.println("Assignment description:");
        description = scanner.nextLine();
        System.out.println("Assignment deadline:");
        deadline = scanner.nextLine();
        System.out.println("Assignment startline:");
        startline = scanner.nextLine();
        String[] params = {id, description, deadline, startline};
        try {
            assignmentXMLService.add(params);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addGrade() {
        Scanner scanner = new Scanner(System.in);
        String id, studentId, assignmentId, value, date;
        System.out.println("Grade ID:");
        id = scanner.nextLine();
        System.out.println("Student ID:");
        studentId = scanner.nextLine();
        System.out.println("Assignment ID:");
        assignmentId = scanner.nextLine();
        System.out.println("Grade value:");
        value = scanner.nextLine();
        System.out.println("Grade date:");
        date = scanner.nextLine();
        String newValue = gradeXMLService.changeGrade(assignmentXMLService, assignmentId, value);
        String[] params = {id, studentId, assignmentId, newValue, date};
        try {
            gradeXMLService.add(params);
            gradeXMLService.printAllGrades(assignmentXMLService);
        } catch (ValidatorException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        String id;
        System.out.println("Student ID:");
        id = scanner.nextLine();
        try {
            studentXMLService.remove(Integer.parseInt(id));
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void deleteAssignment() {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Assignment ID:");
        id = scanner.nextInt();
        try {
            assignmentXMLService.remove(id);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        String id, numenou, grupanou, emailnou, profnou;
        System.out.println("Student ID:");
        id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Student name:");
        numenou = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Student group:");
        grupanou = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Student email:");
        emailnou = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Student teacher:");
        profnou = scanner.nextLine();
        scanner.nextLine();
        String[] params = {id, numenou, grupanou, emailnou, profnou};
        studentXMLService.update(params);
    }


    public void extendDeadline() {
        Scanner scanner = new Scanner(System.in);
        String id, description, deadline, startline;
        int current;
        System.out.println("Assignment ID:");
        id = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Assignment description:");
        description = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Assignment deadline:");
        deadline = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Assignment startline:");
        startline = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Current week:");
        current = scanner.nextInt();
        scanner.nextLine();
        assignmentXMLService.extendDeadline(id, description, deadline, startline, current);
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        label:
        while (true) {
            System.out.println("=======================================================");
            System.out.println("1a--Adaugare student         1b--Adaugare tema");
            System.out.println("2a--Stergere student         2b--Stergere tema");
            System.out.println("3a--Actualizare student      3b--Prelungire termen tema");
            System.out.println("4a--Afisare studenti         4b--Afisare studenti");
            System.out.println("5--Adaugare nota");
            System.out.println("6--Afisare note");
            System.out.println("7--Stop");
            System.out.println("=======================================================");
            System.out.println("Alegeti optiunea:");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1a":
                    this.addStudent();
                    break;
                case "2a":
                    this.deleteStudent();
                    break;
                case "3a":
                    this.updateStudent();
                    break;
                case "4a":
                    this.printAllEntities(studentXMLService);
                    break;
                case "1b":
                    this.addAssignment();
                    break;
                case "2b":
                    this.deleteAssignment();
                    break;
                case "3b":
                    this.extendDeadline();
                    break;
                case "4b":
                    this.printAllEntities(assignmentXMLService);
                    break;
                case "5":
                    this.addGrade();
                    break;
                case "6":
                    //this.printAllNotes();
                    break;
                case "7":
                    break label;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}