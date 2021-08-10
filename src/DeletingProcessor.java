import interfaces.DeleterInterface;
import interfaces.InputInterface;
import interfaces.OutputInterface;
import interfaces.ProcessorInterface;

import java.io.File;
import java.io.IOException;

public class DeletingProcessor implements ProcessorInterface {

    OutputInterface output;
    InputInterface input;
    DeleterInterface deleter;

    public DeletingProcessor(OutputInterface output, InputInterface input, DeleterInterface deleter) {
        this.output = output;
        this.input = input;
        this.deleter = deleter;
    }

    @Override
    public void process() throws IOException {

        output.println("Enter the name of the file...");

        String fileName = input.readInput();

        if (deleter.delete(fileName)) {
            output.println("Deleting is successful");
        } else {
            output.println("File is not deleted");
        }
    }

    @Override
    public String getName() {
        return "Delete";
    }
}
