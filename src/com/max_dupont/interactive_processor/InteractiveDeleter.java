package com.max_dupont.interactive_processor;

import com.max_dupont.crud.DeleterInterface;
import com.max_dupont.IO.InputInterface;
import com.max_dupont.IO.OutputInterface;

import java.io.IOException;

public class InteractiveDeleter implements InteractiveProcessorInterface {

    OutputInterface output;
    InputInterface input;
    DeleterInterface deleter;

    public InteractiveDeleter(OutputInterface output, InputInterface input, DeleterInterface deleter) {
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
