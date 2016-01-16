package info.gomeow.seminars;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

@Deprecated
public class Fun {

    public static class Stud {
        String one;
        String two;
        String three;

        @Override
        public String toString() {
            return one + ", " + two + ", " + three;
        }
    }

    static HashMap<String, Stud> list = new HashMap<String, Stud>();

    public static void main(String[] args) {
        try {
            getStudentsFromFile();
            new File("newdata.csv").createNewFile();
            CSVWriter writer = new CSVWriter(new FileWriter("newdata.csv"));
            for (Map.Entry<String, Stud> entry : list.entrySet()) {
                String[] peeps = new String[4];
                peeps[0] = entry.getKey();
                peeps[1] = entry.getValue().one;
                peeps[2] = entry.getValue().two;
                peeps[3] = entry.getValue().three;
                writer.writeNext(peeps);
            }
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(list);
        System.out.println(list.size());
    }

    public static void getStudentsFromFile() throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        String[] line;
        while ((line = reader.readNext()) != null) {
            String speaker = line[0];
            String num = line[1];
            int people = line.length;
            for (int x = 2; x < people; x++) {
                String person = line[x];
                if (list.containsKey(person)) {
                    Stud s = list.get(person);
                    if (num.equals("1")) {
                        s.one = speaker;
                    } else if (num.equals("2")) {
                        s.two = speaker;
                    } else {
                        s.three = speaker;
                    }
                } else {
                    Stud s = new Stud();
                    if (num.equals("1")) {
                        s.one = speaker;
                    } else if (num.equals("2")) {
                        s.two = speaker;
                    } else {
                        s.three = speaker;
                    }
                    list.put(person, s);
                }
            }
        }
    }
}
