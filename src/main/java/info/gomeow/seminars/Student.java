package info.gomeow.seminars;

import java.util.HashSet;
import javax.swing.JOptionPane;

public class Student {

    String name;
    String grade;
    String choice1;
    String choice2;
    String choice3;
    String choice4;
    String choice5;
    HashSet<String> speakers = new HashSet<String>();
    String one;
    String two;
    String three;

    public Student(String n, String g, String c1, String c2, String c3, String c4, String c5, Main main) {
        name = n;
        grade = g;
        choice1 = c1;//.replace(". ", " ").replace(' ', '_').replaceAll("_$", "").toUpperCase();
        choice2 = c2;//.replace(". ", " ").replace(' ', '_').replaceAll("_$", "").toUpperCase();
        choice3 = c3;//.replace(". ", " ").replace(' ', '_').replaceAll("_$", "").toUpperCase();
        choice4 = c4;//.replace(". ", " ").replace(' ', '_').replaceAll("_$", "").toUpperCase();
        choice5 = c5;//.replace(". ", " ").replace(' ', '_').replaceAll("_$", "").toUpperCase();
        if(!main.speakers.containsKey(choice1)) {
            JOptionPane.showMessageDialog(null, choice1 + " was not found in speakers.txt\nConfirm all names are in speakers.txt");
            System.exit(0);
        }
        if(!main.speakers.containsKey(choice2)) {
            JOptionPane.showMessageDialog(null, choice2 + " was not found in speakers.txt\nConfirm all names are in speakers.txt");
            System.exit(0);
        }
        if(!main.speakers.containsKey(choice3)) {
            JOptionPane.showMessageDialog(null, choice3 + " was not found in speakers.txt\nConfirm all names are in speakers.txt");
            System.exit(0);
        }
        if(!main.speakers.containsKey(choice4)) {
            JOptionPane.showMessageDialog(null, choice4 + " was not found in speakers.txt\nConfirm all names are in speakers.txt");
            System.exit(0);
        }
        if(!main.speakers.containsKey(choice5)) {
            JOptionPane.showMessageDialog(null, choice5 + " was not found in speakers.txt\nConfirm all names are in speakers.txt");
            System.exit(0);
        }
    }

    public String toString() {
        return name + "\t" + grade + "\t" + choice1 + "\t" + choice2 + "\t" + choice3 + "\t" + choice4 + "\t";
    }

    public boolean containsSpeaker(String speaker) {
        return speakers.contains(speaker);
    }

    public void addSpeaker(String speaker) {
        speakers.add(speaker);
        if (one == null) {
            one = speaker;
        } else if (two == null) {
            two = speaker;
        } else {
            three = speaker;
        }
    }

}
