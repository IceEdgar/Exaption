
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.time.LocalDate;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;


class Main {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);

 UserInputReader inputReader = new UserInputConsoleReader(scanner);
 UserDataFileWriter fileWriter = new UserDataFileWriterImpl();

 try {
 UserData userData = inputReader.readUserData();
 fileWriter.writeUserData(userData);
 } catch (UserDataException | IOException e) {
 System.out.println("Ошибка: " + e.getMessage());
    }
  }
}

enum Gender {
 MALE,
 FEMALE
}
class UserDataException extends DataFormatException {

 public UserDataException(String message) {
    super(message);
  }
}
class ParseException extends NumberFormatException {

 public ParseException(String message) {
 super(message);
  }
}
class UserData {

 private String lastName;
 private String firstName;
 private String middleName;
 private LocalDate dateOfBirth;
 private long phoneNumber;
 private Gender gender;

 public UserData(String lastName, String firstName, String middleName, LocalDate dateOfBirth,
 long phoneNumber, Gender gender) {
 this.lastName = lastName;
 this.firstName = firstName;
 this.middleName = middleName;
 this.dateOfBirth = dateOfBirth;
 this.phoneNumber = phoneNumber;
 this.gender = gender;
  }

 public String getLastName() {
 return lastName;
  }

 public String getFirstName() {
 return firstName;
  }

 public String getMiddleName() {
 return middleName;
  }

 public LocalDate getDateOfBirth() {
 return dateOfBirth;
  }

 public long getPhoneNumber() {
 return phoneNumber;
  }

 public Gender getGender() {
 return gender;
  }
}


class UserDataFileWriterImpl implements UserDataFileWriter {

 @Override
 public void writeUserData(UserData userData) throws IOException {
 Scanner scanner = new Scanner(System.in);
 System.out.println("Введите имя файла для записи данных: ");
 String fileName = scanner.nextLine();
 FileWriter writer = new FileWriter(fileName, true);
 String userDataString = String.join(" ",
 userData.getLastName(),
 userData.getFirstName(),
 userData.getMiddleName(),
 userData.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
 String.valueOf(userData.getPhoneNumber()),
 userData.getGender().toString());
 writer.write(userDataString + "\n");
 writer.close();
 System.out.println("Данные успешно записаны в файл: " +
 fileName);
  }
}

class UserInputConsoleReader implements UserInputReader {
 private Scanner scanner;

 public UserInputConsoleReader(Scanner scanner) {
 this.scanner = scanner;
  }

 @Override
 public UserData readUserData() throws UserDataException {
 while (true) {
 System.out.println("Введите данные в следующем порядке, разделяя их пробелом: Фамилия Имя Отчество Дата рождения (dd.mm.yyyy) Номер телефона Пол (f или m)");

 try {
 String input = scanner.nextLine();
 String[] data = input.split(" ");

 if (data.length != 6) {
 throw new UserDataException("Введено неверное количество данных");
        }

 LocalDate dateOfBirth = parseDateOfBirth(data[3]);
 long phoneNumber = parsePhoneNumber(data[4]);
 Gender gender = parseGender(data[5]);

 return new UserData(data[0], data[1], data[2], dateOfBirth, phoneNumber, gender);
 } catch (ParseException e) {
 System.out.println("Ошибка: " + e.getMessage());
      }
    }
  }

 private LocalDate parseDateOfBirth(String dateOfBirthString) throws ParseException {
 try {
 return LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
 } catch (NumberFormatException e) {
 throw new ParseException("Неверный формат даты рождения");
    }
  }

 private long parsePhoneNumber(String phoneNumberString) throws ParseException {
 try {
 return Long.parseLong(phoneNumberString);
 } catch (ParseException e) {
 throw new ParseException("Неверный формат номера телефона");
    }
  }

 private Gender parseGender(String genderString) throws ParseException {
 if (genderString.equalsIgnoreCase("m")) {
 return Gender.MALE;
 } else if (genderString.equalsIgnoreCase("f")) {
 return Gender.FEMALE;
 } else {
 throw new ParseException("Неверный формат пола");
    }
  }
}
interface UserDataFileWriter {

 void writeUserData(UserData userData) throws IOException;
}
interface UserInputReader {
 UserData readUserData() throws UserDataException;
}