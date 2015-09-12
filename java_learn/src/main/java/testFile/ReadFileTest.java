package testFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * xyz: read file usually should use Readers, InputStreams, etc.
 ASCII is a TEXT file so you would use Readers for reading.
 Java also supports reading from a binary file using InputStreams.
 If the files being read are huge then you would want to use a BufferedReader on top of a FileReader to improve read performance.

 In Java 7
 new String(Files.readAllBytes(...)) or Files.readAllLines(...)

 In Java 8
 Files.lines(..).forEach(...)
 */

/**
 * Created by yukai on 15-9-12.
 */
public class ReadFileTest {

    public static void readFromInputStream(InputStream inputStream){
        System.out.println("===[[[ReadFileTest.readFromInputStream]]]===start===");
        try {
            int data = inputStream.read();
            while (data != -1) {
                System.out.println("data:" + (char)data);
                data = inputStream.read();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // JDK7 try-with-resources ensures to close stream automatically
        /*
        try (InputStream is = getClass().getResourceAsStream("/testFile/input.txt")) {
            int Byte;       // Byte because byte is keyword!
            while ((Byte = is.read()) != -1 ) {
                System.out.print((char) Byte);
            }
        }
        */
        System.out.println("===[[[ReadFileTest.readFromInputStream]]]===end===");
    }

    /**
     * IOUtils is in org.apache.commons.io
     * @param inputStream
     */
    public static void readFromInputStreamUseIOUtils(InputStream inputStream){
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseIOUtils]]]===start===");
        String result = "";
        try {
            result = IOUtils.toString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseIOUtils]]]===end===");
    }


    /**
     * Scanner is in jdk 5.0
     * @param file
     */
    public static void readFromFileUseScanner(File file){
        System.out.println("===[[[ReadFileTest.readFromFileUseScanner]]]===start===");
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != scanner) {
                scanner.close();
            }
        }
        System.out.println(sb);
        System.out.println("===[[[ReadFileTest.readFromFileUseScanner]]]===end===");
    }

    /**
     * FileUtils is in org.apache.commons.io
     * @param file
     */
    public static void readFromFileUseFileUtils(File file){
        System.out.println("===[[[ReadFileTest.readFromFileUseFileUtils]]]===start===");
        try {
            String txt= FileUtils.readFileToString(file);
            System.out.println(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===[[[ReadFileTest.readFromFileUseFileUtils]]]===end===");
    }
}
