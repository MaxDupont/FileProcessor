import interfaces.*;

import java.io.IOException;

public class FirstApplication {

    public static void main(String[] args) {
        CheckerInterface checker = new FileChecker();
        CreatorInterface creator = new FileCreator(checker);
        ReaderInterface reader = new FileReader(checker);
        InputInterface input = new ConsoleInput();
        OutputInterface output = new ConsoleOutput();
        DeleterInterface deleter = new FileDeleter(checker);

        FileProcessor fp = new FileProcessor(creator, reader, output, input, checker, deleter);

        try {
            fp.process();
        } catch (IOException e) {
            output.println(e.getMessage());
        }
    }
}