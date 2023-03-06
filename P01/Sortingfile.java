import java.util.*;
import java.io.*;

class Sortingfile
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter name of file: ");
        String inputFile = input.nextLine();

        writeOneRow(outFile, id, name);
    }
    private void readFileExample(String inputFile)
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;
        try
        {
            fileStrm = new FileInputStream(inputFile);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            int lineNum = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                lineNum++;
                processLine(line);
                line = bufRdr.readLine();
                //writeOneLine//
            }
            fileStrm.close();
        }
        catch (IOException e) {
            if (fileStrm != null) {
                try { fileStrm.close(); } catch (IOException ex2) { }
            }
            System.out.println("Error in file processing: " + e.getMessage());

        }
    }

    private void processLine(String csvRow) throws IllegalStateException
    {
        int id;
        String name;

        String[] tokens = csvRow.split(",");
        try
        {
            id = Integer.parseInt(tokens[0]);
            name = tokens[1];

            System.out.println(" ID:" + id + "Name:" + name);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("CSV row had invalid format");
        }
    }

    private void writeOneRow(String output, int id, String name)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;

        try {
            fileStrm = new FileOutputStream(output);
            pw = new PrintWriter(fileStrm);

            pw.println(id + "," + name);
            pw.close();
        }
        catch (IOException e) {
            if (fileStrm != null) {
                try { fileStrm.close(); } catch (IOException ex2) { }
            }
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }
}