package com.max_dupont.interactive_processor;

import com.max_dupont.IO.InputInterface;
import com.max_dupont.IO.OutputInterface;
import com.max_dupont.crud.ReaderInterface;
import com.max_dupont.existence_ensurance.ExistenceEnsuranceInterface;

import java.io.IOException;

public class InteractiveReader implements InteractiveProcessorInterface {

    OutputInterface output;
    InputInterface input;
    ReaderInterface reader;
    ExistenceEnsuranceInterface checker;

    public InteractiveReader(OutputInterface output, InputInterface input, ReaderInterface reader, ExistenceEnsuranceInterface checker) {
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

    @Override
    public String getName() {
        return "Read";
    }
}
