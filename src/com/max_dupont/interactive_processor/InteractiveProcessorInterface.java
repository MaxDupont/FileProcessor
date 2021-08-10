package com.max_dupont.interactive_processor;

import java.io.IOException;

public interface InteractiveProcessorInterface {
    void process() throws IOException;
    String getName();
}
