public class ConsoleOutput implements OutputInterface {
    @Override
    public void println(String line) {
        System.out.println(line);
    }
}
