package com.max_dupont.interactive_processor;

import com.max_dupont.crud.CreatorInterface;
import com.max_dupont.IO.InputInterface;
import com.max_dupont.IO.OutputInterface;

import java.io.IOException;

public class InteractiveCreator implements InteractiveProcessorInterface {


    private OutputInterface output;
    private InputInterface input;
    private CreatorInterface creator;

    public InteractiveCreator(OutputInterface output, InputInterface input, CreatorInterface creator) {
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
