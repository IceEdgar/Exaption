import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {

        Scanner numer = new Scanner(System.in);
        boolean a = true;

        while (a==true){
            System.out.print("Введите дробное число: ");
            String num = number.nextLine();
            try {
                float floatnumber = Float.parseFloat(num);
                a = false;
                System.out.println("Ваше число: " + floatnumber);
            } catch (NumberFormatException e) {
                System.out.println("Введённое число не дробное! \n Повторите ввод:");
            }
        }
    }
}
