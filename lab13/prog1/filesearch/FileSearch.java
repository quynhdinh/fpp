package lab13.prog1.filesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSearch {
    static boolean found = false;
    static String discoveredText = "";

    public static boolean searchForFile(String filename, String startDir) throws IOException {
        File startDirFile = new File(startDir);
        File[] listFiles = startDirFile.listFiles();
        if (listFiles == null) return false;
        for (File o : listFiles) {
            if (o.isFile() && o.getName().equals(filename)) {
                found = true;
                FileReader fr = new FileReader(o.getAbsolutePath());
                BufferedReader reader = new BufferedReader(fr);
                String line;
                while ((line = reader.readLine()) != null) {
                    discoveredText += line;
                }
                reader.close();
                return true;
            }
            if (o.isDirectory()) {
                searchForFile(filename, o.getAbsolutePath());
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        String currentDir = System.getProperty("user.dir");
        String filename = "password.txt";
        searchForFile(filename, currentDir + "/prog1");
        if (!found)
            System.out.println("File not found!");
        else System.out.printf("%s found and its content is %s", filename, discoveredText);
    }
}