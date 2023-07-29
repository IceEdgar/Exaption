package Homework6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main  {
    
         public static void main(String[] args) throws Exception {
        
        Laptop laptop1 = new Laptop("Lenovo V15 IGL ","Intel Core i3 10110U", 8, 256, "Windows 11", "черный", 15.6);
        Laptop laptop2 = new Laptop("Prestigio SmartBook 133C4","Intel Celeron N4020 ", 16, 512, "без ОС", "серый", 14.3);
        Laptop laptop3 = new Laptop("ASUS E410KA","Intel Celeron N4020 ", 4, 128, "Windows 11", "черный", 14.3);
        Laptop laptop4 = new Laptop("HP 250 G7","Intel Celeron N4020 ", 4, 128, "без ОС", "черный", 15.6);
        Laptop laptop5 = new Laptop("Acer Extensa EX215-31-C36W","AMD A4-9120e APU", 4, 256, "Windows 11", "серый", 15.6);
        Laptop laptop6 = new Laptop("Digma EVE 15 P417","AMD Ryzen 5 3500U", 8, 512, "без ОС", "серый", 15.6);
        Laptop laptop7 = new Laptop("HIPER DZEN <46XJDOSU>","Intel Core i5 1135G7", 8, 256, "без ОС", "черный", 15.6);
        Laptop laptop8 = new Laptop("HP 15-dw1006ny","Intel Core i7 10510U", 8, 1000, "без ОС", "серый", 17);

        Set<Laptop> laptop = new HashSet<Laptop>();
        laptop.add(laptop1);
        laptop.add(laptop2);
        laptop.add(laptop3);
        laptop.add(laptop4);
        laptop.add(laptop5);
        laptop.add(laptop6);
        laptop.add(laptop7);
        laptop.add(laptop8);
        System.out.printf("Список ноутбуков: \n\n");
        for(Laptop lap: laptop) {
                System.out.println(lap.toString());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите желаемые характеристики: \nобъем оперативной памяти: ");
        int ram = sc.nextInt();
        System.out.println("объем накопителя: ");
        int storage = sc.nextInt();
        
        for(Laptop lap: laptop) {
            if ((lap.getRam() >= ram) && (lap.getStorageCap() >= storage)) {
                System.out.println(lap.toString());
            }
            
        }
        sc.close();
        
    }
    
}