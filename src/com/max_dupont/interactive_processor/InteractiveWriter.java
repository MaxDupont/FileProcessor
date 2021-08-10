package com.max_dupont.interactive_processor;

import com.max_dupont.existence_ensurance.ExistenceEnsuranceInterface;
import com.max_dupont.IO.InputInterface;
import com.max_dupont.IO.OutputInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class InteractiveWriter implements InteractiveProcessorInterface {

    OutputInterface output;
    InputInterface input;
    ExistenceEnsuranceInterface checker;

    public InteractiveWriter(OutputInterface output, InputInterface input, ExistenceEnsuranceInterface checker) {
        this.output = output;
        this.input = input;
        this.checker = checker;
    }

    @Override
    public void process() throws IOException {
        output.println("Enter the name of the file");

        String fileName = input.readInput();

        if (!checker.exists(fileName)) {
            output.println("File doesn't exist");
            return;
        }

        String text;
        int i = 0;
        try(Writer writer = new FileWriter(fileName, false))
        {
            while (true) {
                i++;
                output.println("Enter " + i + " line");
                text = input.readInput();
                if (text.equals("quit") || text.equals("")) {
                    break;
                }
                writer.write(text + "\n");
            }
        }
        catch(IOException ex){
            output.println(ex.getMessage());
        }

        output.println("Save the file");
    }

    @Override
    public String getName() {
        return "Write";
    }
}
