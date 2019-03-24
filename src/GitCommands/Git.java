package GitCommands;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


public class Git {
    final static Charset ENCODING = StandardCharsets.UTF_8;

    public static void init() {
        File file = new File("C:\\Users\\Asus\\Master");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Folder was successfully created");
            } else {
                System.out.println("Failed to create a folder");
            }
        }
    }

    public static void commit(String filename, String text) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(text.getBytes(ENCODING));
        } catch (IOException e) {
            assert fos != null;
            close(fos);
            throw e;
        }
    }

    private static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException ignored) {
        }
    }

    public static void checkout(String branchName) {

        File file = new File("C:\\Users\\Asus\\Master\\" + branchName);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Branch was successfully created");
            }
            else {
                System.out.println("Failed to create branch!");
            }
        }

    }

    public static void compare(String fileName1, String fileName2) throws IOException {
        FileInputStream fis1 = new FileInputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        BufferedReader bfreader1 = new BufferedReader( new InputStreamReader (fis1));
        BufferedReader bfreader2 = new BufferedReader(new InputStreamReader(fis2));
        String first = bfreader1.readLine();
        String second = bfreader2.readLine();
        int line = 1;
        while (first!=null || second!=null){

            if (!Objects.equals(first, second)){
                System.out.print( line + " First file: "+ first);
                System.out.println("   " + line + " Second file:  " + second);
                line++;
                first = bfreader1.readLine();
                second = bfreader2.readLine();
            }
            else{
                System.out.println(line + " " + first);
                line++;
                first = bfreader1.readLine();
                second = bfreader2.readLine();
            }

        }

        bfreader1.close();
        bfreader2.close();
        fis1.close();
        fis2.close();

    }
}