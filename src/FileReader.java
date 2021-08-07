import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader implements ReaderInterface {

    private CheckerInterface checkable;

    public FileReader(CheckerInterface checkable) {
        this.checkable = checkable;
    }

    @Override
    public String read(String name) throws IOException {
        if (!checkable.exists(name)) {
            throw new RuntimeException("File already exists");
        }

        return Files.readString(Path.of(name));

    }
}
