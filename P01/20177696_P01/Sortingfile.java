import java.util.*;
import java.io.*;

import java.util.Scanner;
import java.io.*;

class Sortingfile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter name of file: ");
        String inputFile = input.nextLine();

        String outFile = "output.txt";
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileWriter(outFile));
            readFileExample(inputFile, pw);
        } catch (IOException e) {
            System.out.println("Error opening the file: " + e.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private static void readFileExample(String inputFile, PrintWriter pw) {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;
        try {
            fileStrm = new FileInputStream(inputFile);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            int lineNum = 0;
            line = bufRdr.readLine();
            while (line != null) {
                lineNum++;
                processLine(line, pw);
                line = bufRdr.readLine();
            }
            fileStrm.close();
        } catch (IOException e) {
            if (fileStrm != null) {
                try {
                    fileStrm.close();
                } catch (IOException ex2) {
                }
            }
            System.out.println("Error in file processing: " + e.getMessage());

        }
    }

    private static void processLine(String csvRow, PrintWriter pw) throws IllegalStateException {
        int id;
        String name;

        String[] tokens = csvRow.split(",");
        try {
            id = Integer.parseInt(tokens[0]);
            name = tokens[1];

            System.out.println(" ID:" + id + "Name:" + name);

            pw.println(id + "," + name);
        } catch (Exception e) {
            throw new IllegalStateException("CSV row had invalid format");
        }
    }
}
