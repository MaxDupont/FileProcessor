import com.max_dupont.IO.InputInterface;
import com.max_dupont.IO.OutputInterface;
import com.max_dupont.IO.console.ConsoleInput;
import com.max_dupont.IO.console.ConsoleOutput;
import com.max_dupont.existence_ensurance.ExistenceEnsuranceInterface;
import com.max_dupont.file_system.FileChecker;
import com.max_dupont.file_system.FileCreator;
import com.max_dupont.file_system.FileDeleter;
import com.max_dupont.file_system.FileReader;
import com.max_dupont.crud.CreatorInterface;
import com.max_dupont.crud.DeleterInterface;
import com.max_dupont.crud.ReaderInterface;
import com.max_dupont.interactive_processor.*;

import java.io.IOException;

public class FirstApplication {

    public static void main(String[] args) {
        ExistenceEnsuranceInterface checker = new FileChecker();
        CreatorInterface creator = new FileCreator(checker);
        ReaderInterface reader = new FileReader(checker);
        InputInterface input = new ConsoleInput();
        OutputInterface output = new ConsoleOutput();
        DeleterInterface deleter = new FileDeleter(checker);


        InteractiveProcessorSwitcher os = new InteractiveProcessorSwitcher(output, input);

        try {
            os.addOption("1", new InteractiveCreator(output, input, creator));
            os.addOption("2", new InteractiveReader(output, input, reader, checker));
            os.addOption("3", new InteractiveWriter(output, input, checker));
            os.addOption("4", new InteractiveDeleter(output, input, deleter));
            os.process();
        } catch (IOException e) {
            output.println(e.getMessage());
        }
    }
}