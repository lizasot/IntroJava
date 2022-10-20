package lesson2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static String getExtension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
    public static void task() throws IOException {
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());

        String currentPath = System.getProperty("user.dir");
        File fileCurrent = new File(currentPath);
        File fileContent = new File(currentPath.concat("/content.txt"));
        File fileFormat = new File(currentPath.concat("/format.txt"));
        try {
            String[] content = fileCurrent.list();
            if (!fileContent.exists()) {
                fileContent.createNewFile();
            }
            if (!fileFormat.exists()) {
                fileFormat.createNewFile();
            }

            FileWriter fileContentWriter = new FileWriter(fileContent);
            FileWriter fileFormatWriter = new FileWriter(fileFormat);
            int i = 1;
            for (String item : content) {
                fileContentWriter.write(item);
                fileContentWriter.write("\n");

                fileFormatWriter.write(i + " Расширение файла: ");
                fileFormatWriter.write(getExtension(item));
                fileFormatWriter.write("\n");
                i++;
            }
            fileContentWriter.flush();
            fileFormatWriter.flush();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }
    public static void main(String[] args) {
        try {
            task();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
