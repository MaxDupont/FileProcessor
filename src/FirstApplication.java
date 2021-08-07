import java.io.IOException;

public class FirstApplication {

    public static void main(String[] args) {
        CheckerInterface checkable = new FileChecker();
        CreatorInterface creatable = new FileCreator(checkable);
        ReaderInterface readable = new FileReader(checkable);
        InputInterface input = new ConsoleInput();
        OutputInterface output = new ConsoleOutput();

        FileProcessor fp = new FileProcessor(creatable, readable, output, input, checkable);

        try {
            fp.process();
        } catch (IOException e) {
            output.println(e.getMessage());
        }
    }
}
