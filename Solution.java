package def;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Gaurav kumar
 *
 */
public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 */

    private static void printList(ArrayList<Student> students,double avrg) {
     for (Student temp : students) {
        if(temp.getMarks()>avrg){} System.out.println(temp.getId() + " : " + temp.getName() + " -- " + temp.getMarks());
        }
     }
 
 
 public static double getAverageMarks(ArrayList<Student> students) {
     double retAvr = 0;
    
     for (int k = 0; k < students.size(); k++) {
         retAvr += students.get(k).getMarks();
     }
     return (retAvr / students.size());
 }
 public static void main(String args[] ) throws Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String line = br.readLine();
     String ids, names, markss;

     ArrayList<Student> students = new ArrayList<>();
     int anoOfObject = Integer.parseInt(line);
     for (int i = 0; i < anoOfObject; i++) {
         ids = br.readLine();
         names = br.readLine();
         markss = br.readLine();
         students.add(new Student(Integer.parseInt(ids), names, Double.parseDouble(markss)));

     }
     double avr = Solution.getAverageMarks(students);
     System.out.println(avr);
    printList(students,avr);
     
 }

}
