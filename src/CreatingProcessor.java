import interfaces.CreatorInterface;
import interfaces.InputInterface;
import interfaces.OutputInterface;
import interfaces.ProcessorInterface;

import java.io.IOException;

public class CreatingProcessor implements ProcessorInterface {


    private OutputInterface output;
    private InputInterface input;
    private CreatorInterface creator;

    public CreatingProcessor(OutputInterface output, InputInterface input, CreatorInterface creator) {
        this.output = output;
        this.input = input;
        this.creator = creator;
    }

    @Override
    public void process() throws IOException {
        // создадим новый файл

        output.println("Enter the name of the new file...");

        String fileName = input.readInput();

        if (!creator.create(fileName)) {
            output.println("File is not created");
        }
    }

    @Override
    public String getName() {
        return "Create";
    }
}
