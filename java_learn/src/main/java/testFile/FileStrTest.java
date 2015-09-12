package testFile;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Date;

/**
 *
 * 为了拿到File或Path对象:
 *      from fileStr get File (getFileFromFileStr(), not suggestion)
 *      from fileStr get Path (getPathFromFileStr(), not suggestion)
 *      from fileStr get URL (getURLFromFileStr(), suggestion), then use url2File() or url2Path().
 *
 * 为了读写文件:
 *      from fileStr get InputStream (getInputStreamFromFileStr)
 */

/**
 * Created by yukai on 15-9-10.
 */
public class FileStrTest {
    public static void main(String[] args){
        // to get the path to the current directory with:
        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);

        FileStrTest fileStrTest = new FileStrTest();
//        fileStrTest.getFileFromFileStr();
//        fileStrTest.getPathFromFileStr();
        fileStrTest.getInputStreamFromFileStr();
        fileStrTest.getURLFromFileStr();
    }

    /**
     * Maven standard directory layout guide us to place any non-Java files for testing under src/test/resources/ folder.
     * They are automatically copied over to target/test-classes/ folder during test phase.
     * xyz: so don't suggest direct get File or Path from fileStr in maven project, just get InputStream or URL, then use url2File or url2Path.
     */
    public void getFileFromFileStr(){
        File file = new File("input.txt");
        System.out.println(file.exists()); // false
        System.out.println(file.getAbsoluteFile());// /home/yukai/git/idea-multi-module-example/input.txt

        file = new File("/testFile/input.txt");
        System.out.println(file.exists()); // false
        System.out.println(file.getAbsoluteFile());// /testFile/input.txt

        file = new File("/home/yukai/git/idea-multi-module-example/java_learn/src/main/resources/testFile/input.txt");
        System.out.println(file.exists()); // true
        System.out.println(file.getAbsoluteFile());
    }

    public void getPathFromFileStr(){
        Path path = Paths.get("/home/yukai/git/idea-multi-module-example/java_learn/src/main/resources/testFile/input.txt");
        System.out.println(path.getFileName());
    }

    public void getInputStreamFromFileStr(){
        /**
         * http://stackoverflow.com/questions/3104617/what-is-the-path-to-resource-files-in-a-maven-project
         * You cannot load the file directly like that,
         * you need to use the resource abstraction (a resource could not only be in the file system, but on any place on the classpath - in a jar file or otherwise).
         * This abstraction is what you need to use when loading resources.
         * Resource paths are relative to the location of your class file, so you need to prepend a slash to get to the 'root':
         * [xyz: see target dir to known the path, target/class is root ]
         */
        InputStream inputStream = getClass().getResourceAsStream("/testFile/input.txt");
        ReadFileTest.readFromInputStreamDirect(inputStream);

        inputStream = FileStrTest.class.getResourceAsStream("/testFile/input.txt");
        ReadFileTest.readFromInputStreamUesBufferedReader(inputStream);

        inputStream = FileStrTest.class.getResourceAsStream("/testFile/input.txt");
        ReadFileTest.readFromInputStreamUseIOUtils1(inputStream);

        inputStream = FileStrTest.class.getResourceAsStream("/testFile/input.txt");
        ReadFileTest.readFromInputStreamUseIOUtils2(inputStream);

        inputStream = FileStrTest.class.getResourceAsStream("/testFile/input.txt");
        ReadFileTest.readFromInputStreamUseCharStreams(inputStream);

    }

    public void getURLFromFileStr(){
        try {
            // Common is also to convert resource to java.io.File or its JDK7 successor java.nio.file.Path (from so-called NIO.2)
            URL resourceUrl = getClass().getResource("/testFile/input.txt");

            // get File
            File file = url2File(resourceUrl);
            System.out.println(file.exists()); // true
            System.out.println(file.getAbsoluteFile());
            ReadFileTest.readFromFileUseScanner(file);
            ReadFileTest.readFromFileUseFileUtils(file);
            ReadFileTest.readFromFileUseFiles(file);

            // get Path
            resourceUrl = FileStrTest.class.getResource("/testFile/input.txt");
            Path resourcePath = url2Path(resourceUrl);
            FileTime lmt = Files.getLastModifiedTime(resourcePath);
            System.out.println(new Date(lmt.toMillis()));
            ReadFileTest.readFromPath(resourcePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File url2File(URL url){
        File file = null;
        try {
            file = new File(url.toURI());
            // or
            // url.getFile(), This won't work with files if they have whitespaces or special characters (e.g. #) in their paths. Rather use url.toURI().
            // xyz: suggestion is to use toURI()
            file = new File(url.getFile());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static Path url2Path(URL url){
        Path resourcePath = null;
        try {
            resourcePath = Paths.get(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourcePath;
    }

}
