package interfaces;

import java.io.IOException;

public interface ProcessorInterface {
    void process() throws IOException;
    String getName();
}
