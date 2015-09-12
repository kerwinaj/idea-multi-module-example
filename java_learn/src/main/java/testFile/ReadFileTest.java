package testFile;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public static void readFromInputStreamDirect(InputStream inputStream){
        System.out.println("===[[[ReadFileTest.readFromInputStreamDirect]]]===start===");
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
        System.out.println("===[[[ReadFileTest.readFromInputStreamDirect]]]===end===");
    }


    public static void readFromInputStreamUesBufferedReader(InputStream inputStream){
        System.out.println("===[[[ReadFileTest.readFromInputStreamUesBufferedReader]]]===start===");
        try{
            InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(inputStreamReader);
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println("===[[[ReadFileTest.readFromInputStreamUesBufferedReader]]]===end===");
    }

    /**
     * IOUtils is in org.apache.commons.io
     * @param inputStream
     */
    public static void readFromInputStreamUseIOUtils1(InputStream inputStream){
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseIOUtils1]]]===start===");
        String result = "";
        try {
            result = IOUtils.toString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseIOUtils1]]]===end===");
    }

    public static void readFromInputStreamUseIOUtils2(InputStream inputStream){
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseIOUtils2]]]===start===");
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(inputStream, writer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(writer.toString());
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseIOUtils2]]]===end===");
    }
    /**
     * CharStreams is in guava
     * @param inputStream
     */
    public static void readFromInputStreamUseCharStreams(InputStream inputStream){
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseCharStreams]]]===start===");
        String stringFromStream = "";
        try {
            stringFromStream = CharStreams.toString(new InputStreamReader(inputStream, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringFromStream);
        System.out.println("===[[[ReadFileTest.readFromInputStreamUseCharStreams]]]===end===");
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
            // or
            scanner = new Scanner(file, "UTF-8");
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

    /**
     * Files is in guava
     * @param file
     */
    public static void readFromFileUseFiles(File file){
        System.out.println("===[[[ReadFileTest.readFromFileUseFiles]]]===start===");
        String text = "";
        try {
            text = com.google.common.io.Files.toString(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(text);
        System.out.println("===[[[ReadFileTest.readFromFileUseFiles]]]===end===");
    }


    public static void readFromPath(Path path){
        System.out.println("===[[[ReadFileTest.readFromPath]]]===start===");
        try {
            Charset charset = Charset.defaultCharset();
            // or
            charset = Charset.forName("UTF-8");
            // or
            charset = StandardCharsets.UTF_8;
            for (String line : Files.readAllLines(path, charset)) {
                System.out.println(line);
            }
        } catch (Exception e){
          e.printStackTrace();
        }
        System.out.println("===[[[ReadFileTest.readFromPath]]]===end===");
    }
}
