import java.io.File;
import java.io.IOException;

public class FileCreator implements CreatorInterface {

    private CheckerInterface checkable;

    public FileCreator(CheckerInterface checkable) {
        this.checkable = checkable;
    }

    @Override
    public boolean create(String name) throws IOException {

        if (checkable.exists(name)) {
            return false;
        }

        File f = new File(name);
        return f.createNewFile();
    }
}
