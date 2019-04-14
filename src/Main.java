import Classes.Test1;
import Classes.Test2;
import Utilite.Utils;

public class Main {

    public static void main(String[] args) {
        Test1 test1 = new Test1("firstField", "secondField", "ThirdField");
        Utils.convert(test1, Test2.class);

    }
}





