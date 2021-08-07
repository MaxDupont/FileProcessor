import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class FileProcessor{

    private CreatorInterface creator;
    private ReaderInterface reader;
    private OutputInterface output;
    private InputInterface input;
    private CheckerInterface checker;

    FileProcessor(CreatorInterface creatable, ReaderInterface readable, OutputInterface output, InputInterface input, CheckerInterface checker) {
        this.creator = creatable;
        this.reader = readable;
        this.output = output;
        this.input = input;
        this.checker = checker;
    }

    void process() throws IOException {
        output.println("Выберите опцию: 1 - create, 2 - open");
        String answer = input.readInput();


        processCase(answer);
    }

    private void processCase(String answer) throws IOException {
        Map<String, ProcessorInterface> caseMap = new HashMap<>();
        caseMap.put("1",  new CreatingProcessor(output, input, creator));
        caseMap.put("2",  new ReadingProcessor(output, input, reader, checker));

        caseMap.get(answer).process();
    }
}
