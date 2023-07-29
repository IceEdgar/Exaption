package Homework6;

public class Laptop {
    private String name;
    private String processor;
    private int ram;
    private int storageCap;
    private String os;
    private String colour;
    private double diagonal;

    public Laptop(String name, String processor, int ram, int storageCap, String os, String colour, double diagonal){
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storageCap = storageCap;
        this.os = os;
        this.colour = colour;
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return String.format("Модель ноутбука: %s \n Процессор: %s \n объем оперативной памяти: %d Гб \n объем накопителя: %d Гб \n ОС: %s \n Цвет: %s \n Диагональ: %.1f \n", 
                    this.name, this.processor, this.ram, this.storageCap, this.os, this.colour, this.diagonal);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Laptop) {
            return this.name.equals(((Laptop) obj).name) && this.processor.equals(((Laptop) obj).processor) && this.ram == ((Laptop) obj).ram 
                                && this.storageCap == ((Laptop) obj).storageCap && this.os.equals(((Laptop) obj).os) 
                                && this.colour.equals(((Laptop) obj).colour) && this.diagonal == ((Laptop) obj).diagonal;
        }
        return false;
        
    }
    public String getProcessor(){
        return this.processor;
    }
    public int getRam(){
        return this.ram;
    }
    public int getStorageCap(){
        return this.storageCap;
    }
    public String getOS(){
        return this.os;
    }
    public double getDiagonal(){
        return this.diagonal;
    }
    
}