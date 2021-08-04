import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCreateProcess {

    public static void main(String[] args) throws IOException {

        FileCreator creator = new FileCreator();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Выберите опцию: 1 - create, 2 - open");
        String answer = reader.readLine();

        switch (answer) {
            case("1") : {
                // создадим новый файл
                System.out.println("Enter the name of the new file...");

                String fileName = reader.readLine();

                creator.createNewFile(fileName);

                break;
            }
            case("2"): {
                System.out.println("Enter the name of the file...");

                String fileName = reader.readLine();

                creator.readFromFile(fileName);
                break;
            }
        }


    }

}