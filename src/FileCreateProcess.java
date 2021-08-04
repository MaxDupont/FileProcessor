import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCreateProcess {

    public static void main(String[] args) throws IOException {

        FileCreator creator = new FileCreator();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // создадим новый файл
        System.out.println("Enter the name of the new file...");

        String fileName = reader.readLine();

        creator.createNewFile(fileName);

        //creator.writeInFile(fileName);
    }

}