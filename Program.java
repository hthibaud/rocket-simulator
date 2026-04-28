import core.Simulator;
import utils.utils;

public class Program {
    public static void main(String[] args) {

        Simulator simulator = new Simulator();

        utils.clearConsole();
        simulator.startMenu();
        simulator.mainMenu();

    }
}
