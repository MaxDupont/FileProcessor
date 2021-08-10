import interfaces.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class FileProcessor {

    private CreatorInterface creator;
    private ReaderInterface reader;
    private OutputInterface output;
    private InputInterface input;
    private CheckerInterface checker;
    private DeleterInterface deleter;

    FileProcessor(CreatorInterface creator, ReaderInterface reader, OutputInterface output, InputInterface input, CheckerInterface checker, DeleterInterface deleter) {
        this.creator = creator;
        this.reader = reader;
        this.output = output;
        this.input = input;
        this.checker = checker;
        this.deleter = deleter;
    }

    void process() throws IOException {
        Appendable s = new StringBuilder("Выберите опцию: ");

        Map<String, ProcessorInterface> caseMap = new HashMap<>();
        caseMap.put("1",  new CreatingProcessor(output, input, creator));
        caseMap.put("2",  new ReadingProcessor(output, input, reader, checker));
        //caseMap.put("3",  new WritingProcessor(output, input, checker));
        caseMap.put("4", new DeletingProcessor(output, input, deleter));

        for(Map.Entry<String, ProcessorInterface> entry : caseMap.entrySet()) {
            String key = entry.getKey();
            ProcessorInterface processor = entry.getValue();

            s.append(key).append(" - ").append(processor.getName()).append(" ");
        }
        output.println(s.toString());

        String answer = input.readInput();

        caseMap.get(answer).process();
    }
}
