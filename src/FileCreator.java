import java.io.*;

public class FileCreator {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void writeInFile(String name) {
        String text;
        int i = 0;
        try(FileWriter writer = new FileWriter(name, false))
        {
            while (true) {
                i++;
                System.out.println("Enter " + i + " line");
                text = reader.readLine();
                if (text.equals("quit") || text.equals("")) {
                    break;
                }
                writer.write(text);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Save the file");
    }

    public void createNewFile(String name) throws IOException {
        try {
            if (!checkFileExistence(name)) {
                File f = new File(name);
                if (f.createNewFile()) System.out.println("File is created");
            }
            else {
                System.out.println("File already exists. Try again...");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    private void readFromFile(String name) {

    }

    private boolean checkFileExistence(String name) {
        File f = new File(name);
        return f.exists();
    }
}
