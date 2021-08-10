import interfaces.CheckerInterface;
import interfaces.DeleterInterface;
import interfaces.InputInterface;
import interfaces.OutputInterface;

import java.io.File;

public class FileDeleter implements DeleterInterface {

    private CheckerInterface checker;

    public FileDeleter(CheckerInterface checker) {
        this.checker = checker;
    }

    @Override
    public boolean delete(String name) {

        if (!checker.exists(name)) {
            throw new RuntimeException("File doesn't exist");
        }

        File file = new File(name);
         return file.delete();
    }
}
