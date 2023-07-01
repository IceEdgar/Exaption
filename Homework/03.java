try {
    int d = 0;
    double catchedRes1 = intArray[8] / d;
    System.out.println("catchedRes1 = " + catchedRes1);
 } catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Invalid array index: " + e);
 } catch (ArithmeticException e) {
    System.out.println("Catching exception: " + e);
 }

