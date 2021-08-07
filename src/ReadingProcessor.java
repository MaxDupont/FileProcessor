import java.io.IOException;

public class ReadingProcessor implements ProcessorInterface{

    OutputInterface output;
    InputInterface input;
    ReaderInterface reader;
    CheckerInterface checker;

    public ReadingProcessor(OutputInterface output, InputInterface input, ReaderInterface reader, CheckerInterface checker) {
        this.output = output;
        this.input = input;
        this.reader = reader;
        this.checker = checker;
    }

    @Override
    public void process() throws IOException {
        output.println("Enter the name of the file...");

        String fileName = input.readInput();

        if (!checker.exists(fileName)) {
            output.println("File does not exist");
            return;
        }

        String content = reader.read(fileName);

        output.println(content);
    }
}
