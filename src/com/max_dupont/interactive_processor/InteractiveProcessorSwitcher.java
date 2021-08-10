package com.max_dupont.interactive_processor;

import com.max_dupont.IO.InputInterface;
import com.max_dupont.IO.OutputInterface;
import com.max_dupont.interactive_processor.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InteractiveProcessorSwitcher {


    private OutputInterface output;
    private InputInterface input;
    private Map<String, InteractiveProcessorInterface> options = new HashMap<>();

    public InteractiveProcessorSwitcher(OutputInterface output, InputInterface input) {
        this.output = output;
        this.input = input;
    }

    public void process() throws IOException {
        Appendable s = new StringBuilder("Выберите опцию: ");

        for(Map.Entry<String, InteractiveProcessorInterface> entry : options.entrySet()) {
            String key = entry.getKey();
            InteractiveProcessorInterface processor = entry.getValue();

            s.append(key).append(" - ").append(processor.getName()).append(" ");
        }
        output.println(s.toString());

        String answer = input.readInput();

        options.get(answer).process();
    }

    public void addOption(String key, InteractiveProcessorInterface processor) {
        options.put(key, processor);
    }
}
