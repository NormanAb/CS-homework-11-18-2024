import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String inputFile = "students.csv";
        String outputFile = "students_with_grades.csv";

        List<Student> students = readStudentsFromFile(inputFile);

        for (Student student : students) {
            student.addGrade("Math", round((Math.random() * 100)));
            student.addGrade("Lithuanian", round((Math.random() * 100)));
            student.addGrade("English", round((Math.random() * 100)));
            student.addGrade("Physics", round((Math.random() * 100)));

        }

        System.out.println(students);


    }

    private static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null) {
                students.add(new Student(line.trim())); //create students from file
            }
        }catch(IOException e){
            System.err.println("Error reading file" + e.getMessage());
        }
        return students;
    }

    private static void writeStudentsToFile(List<Student> students, String filename) {
        try(BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
            br.write("Name, Subject, Score, Average");

        }catch(IOException e) {
            System.err.println("Error writing file" + e.getMessage());
        }
    }
}

