package info.gomeow.seminars;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class Main {

    static Random rand = new Random();
    HashMap<String, Seminar> seminars = new HashMap<String, Seminar>();
    HashMap<String, Integer> speakers = new HashMap<String, Integer>();
    List<Student> grade09 = new ArrayList<Student>();
    List<Student> grade10 = new ArrayList<Student>();
    List<Student> grade11 = new ArrayList<Student>();
    List<Student> grade12 = new ArrayList<Student>();

    int studentCount = 0;

    public Main() throws Exception {
        // generateSampleData();
        if (!getOK()) {
            System.exit(0);
        }
        loadSpeakers();
        setupSeminars();
        HashMap<String, Student> students = getStudentsFromFile();
        for (Student student : students.values()) {
            //System.out.println(student.name + " " + student.choice1 + " " + student.choice2 + " " + student.choice3 + " " + student.choice4 + " " + student.choice5);
            if (student.grade.equals("12")) {
                grade12.add(student);
            } else if (student.grade.equals("11")) {
                grade11.add(student);
            } else if (student.grade.equals("10")) {
                grade10.add(student);
            } else if (student.grade.equals("9")) {
                grade09.add(student);
            }
        }

        for (Student student : grade12) {
            String choice = student.choice1;
            Seminar seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice2;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice3;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            if (student.speakers.size() < 3) {
                choice = student.choice4;
                seminar = seminars.get(choice);
                if (!seminar.isFull()) {
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                } else {
                    choice = student.choice5;
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                }
                while (student.speakers.size() < 3) {
                    String speaker = randSpeaker();
                    while (student.containsSpeaker(speaker)) {
                        speaker = randSpeaker();
                    }
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(speaker);
                }

            }
        }
        for (Student student : grade11) {
            String choice = student.choice1;
            Seminar seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice2;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice3;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            if (student.speakers.size() < 3) {
                choice = student.choice4;
                seminar = seminars.get(choice);
                if (!seminar.isFull()) {
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                } else {
                    choice = student.choice5;
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                }
                while (student.speakers.size() < 3) {
                    String speaker = randSpeaker();
                    while (student.containsSpeaker(speaker)) {
                        speaker = randSpeaker();
                    }
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(speaker);
                }

            }
        }
        for (Student student : grade10) {
            String choice = student.choice1;
            Seminar seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice2;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice3;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            if (student.speakers.size() < 3) {
                choice = student.choice4;
                seminar = seminars.get(choice);
                if (!seminar.isFull()) {
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                } else {
                    choice = student.choice5;
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                }
                while (student.speakers.size() < 3) {
                    String speaker = randSpeaker();
                    while (student.containsSpeaker(speaker)) {
                        speaker = randSpeaker();
                    }
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(speaker);
                }

            }
        }
        for (Student student : grade09) {
            String choice = student.choice1;
            Seminar seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice2;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            choice = student.choice3;
            seminar = seminars.get(choice);
            if (!seminar.isFull()) {
                seminar.addStudent(student);
                student.addSpeaker(choice);
            }
            if (student.speakers.size() < 3) {
                choice = student.choice4;
                seminar = seminars.get(choice);
                if (!seminar.isFull()) {
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                } else {
                    choice = student.choice5;
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(choice);
                }
                while (student.speakers.size() < 3) {
                    String speaker = randSpeaker();
                    while (student.containsSpeaker(speaker)) {
                        speaker = randSpeaker();
                    }
                    seminar = seminars.get(choice);
                    seminar.addStudent(student);
                    student.addSpeaker(speaker);
                }

            }
        }

        new File("output.csv").createNewFile();
        CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
        Map<String, Seminar> newSeminars = new HashMap<String, Seminar>();
        for (String speaker : speakers.keySet()) {
            newSeminars.put(speaker, new Seminar(speaker, this));
        }
        for (Student student : students.values()) {
            studentCount++;
            for (String speaker : student.speakers) {
                Seminar seminar = newSeminars.get(speaker);
                seminar.addStudent(student);
            }
        }

        HashMap<String, TimeData> timeData = new HashMap<String, TimeData>();

        for (Seminar seminar : newSeminars.values()) {
            String speaker = seminar.name;
            TimeData data = new TimeData();
            List<Student> students1 = new ArrayList<Student>(seminar.getStudents());
            for (Student student : students1) {
                if (speaker.equals(student.one)) {
                    data.period1.add(student);
                } else if (speaker.equals(student.two)) {
                    data.period2.add(student);
                } else {
                    data.period3.add(student);
                }
            }
            timeData.put(speaker, data);
        }

        for (Map.Entry<String, TimeData> dataEntry : timeData.entrySet()) {
            String speaker = dataEntry.getKey();
            TimeData data = dataEntry.getValue();

            String[] period1 = new String[data.period1.size() + 3];
            period1[0] = "";
            //System.out.println(speaker + " 1");
            for (int x = 0; x < data.period1.size(); x++) {
                Student student = data.period1.get(x);
                period1[x + 3] = student.name;
                //System.out.println(student.grade + " " + student.name);
            }

            String[] period2 = new String[data.period2.size() + 3];
            period2[0] = speaker;
            //System.out.println(speaker + " 2");
            for (int x = 0; x < data.period2.size(); x++) {
                Student student = data.period2.get(x);
                period2[x + 3] = student.name;
                //System.out.println(student.grade + " " + student.name);
            }

            String[] period3 = new String[data.period3.size() + 3];
            period3[0] = "";
            //System.out.println(speaker + " 3");
            for (int x = 0; x < data.period3.size(); x++) {
                Student student = data.period3.get(x);
                period3[x + 3] = student.name;
                //System.out.println(student.grade + " " + student.name);
            }


            writer.writeNext(period1);
            writer.writeNext(period2);
            writer.writeNext(period3);
        }
        writer.close();

        HashMap<String, TimeData.StudentTimeData> studentTimeMap = new HashMap<String, TimeData.StudentTimeData>();
        for (Map.Entry<String, TimeData> dataEntry : timeData.entrySet()) {
            // Create student list
            String speaker = dataEntry.getKey();
            for (Student student : dataEntry.getValue().period1) {
                TimeData.StudentTimeData data = studentTimeMap.get(student.name);
                if (data == null) data = new TimeData().new StudentTimeData();
                data.period1 = speaker;
                studentTimeMap.put(student.name, data);
            }
            for (Student student : dataEntry.getValue().period2) {
                TimeData.StudentTimeData data = studentTimeMap.get(student.name);
                if (data == null) data = new TimeData().new StudentTimeData();
                data.period2 = speaker;
                studentTimeMap.put(student.name, data);
            }
            for (Student student : dataEntry.getValue().period3) {
                TimeData.StudentTimeData data = studentTimeMap.get(student.name);
                if (data == null) data = new TimeData().new StudentTimeData();
                data.period3 = speaker;
                studentTimeMap.put(student.name, data);
            }
        }

        /* Error Checking and Students.csv Printing */


        new File("students.csv").createNewFile();
        writer = new CSVWriter(new FileWriter("students.csv"));

        List<String> errorList = new ArrayList<String>();

        for (Map.Entry<String, TimeData.StudentTimeData> entry : studentTimeMap.entrySet()) {
            String studentName = entry.getKey();
            TimeData.StudentTimeData data = entry.getValue();


            if (data.period1 == null || data.period2 == null || data.period3 == null) {
                errorList.add(studentName);
            }

            String[] line = new String[4];
            line[0] = studentName;
            line[1] = data.period1;
            line[2] = data.period2;
            line[3] = data.period3;
            writer.writeNext(line);
        }
        writer.close();

        if (errorList.size() != 0) {
            new File("errors.txt").createNewFile();
            BufferedWriter errorWriter = new BufferedWriter(new FileWriter("errors.txt"));
            for (String errorStudent : errorList) {
                errorWriter.write(errorStudent + "\n");
            }
            errorWriter.close();
            JOptionPane.showMessageDialog(null, studentCount + " students sorted with " + errorList.size() + " errors.\nCulprit students have been exported to errors.txt\n" +
                    "\n" +
                    "Created by Davis Mariotti");
        } else {
            JOptionPane.showMessageDialog(null, studentCount + " students sorted with " + errorList.size() + " errors.\n\nCreated by Davis Mariotti");
        }

        System.exit(0);
    }


    public void setupSeminars() {
        for (String speaker : speakers.keySet()) {
            seminars.put(speaker, new Seminar(speaker, this));
        }
    }

    /**
     * Loads students and their seminar choices from the data.csv file
     * @return A set of Student objects, including their seminar choices
     * @throws IOException An IOException
     */
    public HashMap<String, Student> getStudentsFromFile() throws IOException {
        HashMap<String, Student> studentsFromFile = new HashMap<String, Student>();
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        String[] line;
        Integer i = 0;
        while ((line = reader.readNext()) != null) {
            Student student = new Student(capitalizeString(line[0].replaceAll(" $", "")), line[1], line[2], line[3], line[4], line[5], line[6], this);
            studentsFromFile.put(student.name, student);
        }
        return studentsFromFile;
    }

    /**
     * Loads speakers from speakers.txt file
     */
    public void loadSpeakers() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("speakers.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#")) {
                    String[] parts = line.split("-");
                    speakers.put(parts[1], Integer.parseInt(parts[0]));
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error parsing speakers.txt. Check formatting.");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This function checks to see if the required files are present.
     * @return whether or not to continue running the program
     */
    public boolean getOK() {

        File dataFile = new File("data.csv");
        if (!dataFile.exists()) {
            JOptionPane.showMessageDialog(null, "Make sure the data input file is named data.csv");
            return false;
        }

        File speakersFile = new File("speakers.txt");
        if (!speakersFile.exists()) {
            try {
                speakersFile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter("speakers.txt"));
                writer.write("# Format to input speakers:\n# ROOM_CAPACITY*3-SPEAKER_NAME-\n#\n# Example:\n# 45-Mr. Runyon");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "speakers.txt file not found. It has been created for you.");
            return false;
        }

        JDialog.setDefaultLookAndFeelDecorated(true);
        return true;
    }

    /* Static code */

    public static void main(String[] args) throws Exception {
        new Main();
    }

    private void generateSampleData() throws Exception {
        File file = new File("sampledata.csv");
        file.createNewFile();
        CSVWriter writer = new CSVWriter(new FileWriter("sampledata.csv"));
        for (int i = 0; i < 420; i++) {
            String[] line = new String[7];
            line[0] = String.valueOf(i);
            if (i >= 0 && i <= 100) line[1] = "09";
            if (i > 100 && i <= 200) line[1] = "10";
            if (i > 200 && i <= 300) line[1] = "11";
            if (i > 300 && i <= 420) line[1] = "12";
            line[2] = randSpeaker().replace('_', ' ');
            line[3] = randSpeaker().replace('_', ' ');
            line[4] = randSpeaker().replace('_', ' ');
            line[5] = randSpeaker().replace('_', ' ');
            line[6] = randSpeaker().replace('_', ' ');
            writer.writeNext(line);
            l.clear();
        }
        writer.close();
    }

    static List<String> l = new ArrayList<String>();

    public String randSpeaker() {
        List<String> keys = new ArrayList<String>(speakers.keySet());
        return keys.get(rand.nextInt(keys.size()));
    }

    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}
