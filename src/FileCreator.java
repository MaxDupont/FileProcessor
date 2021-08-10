import interfaces.CheckerInterface;
import interfaces.CreatorInterface;

import java.io.File;
import java.io.IOException;

public class FileCreator implements CreatorInterface {

    private CheckerInterface checker;

    public FileCreator(CheckerInterface checkable) {
        this.checker = checkable;
    }

    @Override
    public boolean create(String name) throws IOException {

        if (checker.exists(name)) {
            return false;
        }

        File f = new File(name);
        return f.createNewFile();
    }
}
