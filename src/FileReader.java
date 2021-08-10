import interfaces.CheckerInterface;
import interfaces.ReaderInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader implements ReaderInterface {

    private CheckerInterface checker;

    public FileReader(CheckerInterface checkable) {
        this.checker = checkable;
    }

    @Override
    public String read(String name) throws IOException {
        if (!checker.exists(name)) {
            throw new RuntimeException("File already exists");
        }

        return Files.readString(Path.of(name));

    }
}
