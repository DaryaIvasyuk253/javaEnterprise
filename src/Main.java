import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Git.init();
        Git.commit("C:\\Users\\Asus\\Master\\Dev5\\mmaster", "hello, first compare" + "\n"  +
                "program" + "\n" + "java" );
        Git.commit("C:\\Users\\Asus\\Master\\Dev7\\mmaster2", "hello, first compare" + "\n"  +
                "program" + "\n" + "python"+ "\n" + "git" + "\n" + "commands");

        Git.checkout("Dev5");
        Git.checkout("Dev7");
        Git.compare("C:\\Users\\Asus\\Master\\Dev5\\mmaster", "C:\\Users\\Asus\\Master\\Dev7\\mmaster2");


    }
}
