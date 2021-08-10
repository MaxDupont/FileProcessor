package com.max_dupont.IO.console;

import com.max_dupont.IO.OutputInterface;

public class ConsoleOutput implements OutputInterface {
    @Override
    public void println(String line) {
        System.out.println(line);
    }
}
