import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

abstract class ErrorWrite{
    public abstract void Phone(String s) throws Exception;
    public abstract void IIN(String s) throws Exception;
    public abstract void Name(String s) throws Exception;
    public void writeError(String s){
        try {
            File file = new File("file.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    s = s + "\n" + myReader.nextLine();
                }
            }
            FileWriter f = new FileWriter("file.txt");
            LocalDateTime d = LocalDateTime.now();
            s = d + " - " + s;
            f.write(s);
            f.close();
        } catch (IOException e) {
            System.out.println("Something happened");
            e.getMessage();
        }
    }
}

