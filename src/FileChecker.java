import interfaces.CheckerInterface;

import java.io.File;

public class FileChecker implements CheckerInterface {
    @Override
    public boolean exists(String name) {
        File f = new File(name);
        return f.exists();
    }
}
