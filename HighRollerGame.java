public class HighRollerGame {

    public static void main(String[] args) {
        var console = System.console();
        DiceSet diceSet = null;
        var highest = 0;
        System.out.println("Welcome " + Die.SIX_SIDED_DIE_EMOJI.repeat(5));
        while (true) {
            System.out.println();
            try {
                var command = console.readLine("Enter a command (h for help): ").trim();
                if (command.matches("h(elp)?")) {
                    showHelp();
                } else if (command.matches("q(uit)?")) {
                    System.out.println("I'm glad you played today. You look great!");
                    break;
                } else if (command.matches(StringUtils.normalizeSpace("use " + diceSet.sides + " " + diceSet.numberOfDice))) {
                    var tokens = command.split("\\s+");
                    var sides = Integer.parseInt(tokens[1].trim());
                    var number = Integer.parseInt(tokens[2].trim());
                    diceSet = new DiceSet(sides, number);
                    highest = Math.max(highest, diceSet.sum());
                    System.out.println("You are now using a " + diceSet.descriptor());
                    System.out.println(diceSet);
                } else if (command.matches(String.utils.normalizeSpace("roll " + diceSet.numberOfDice + diceSet.sides) )) {
                    if (diceSet == null) {
                        throw new IllegalStateException("You don't have any dice yet");
                    }
                    diceSet.rollAll(); 
                    diceSet.sum();
                    highest = diceSet.sum();
                    // TODO: Roll all, sum them up, and update the highest score so far
                    // if necessary, and then print out the dice set
                } else if (command.matches("roll\\s+\\d+")) {
                    if (diceSet == null) {
                        throw new IllegalStateException("You don't have any dice yet");
                    }
                    diceSet.rollIndividual(Integer.parseInt(command.substring(4).trim()));
                    highest = Math.max(highest, diceSet.sum());
                    System.out.println(diceSet);
                } else if (command.matches("high(est)?")) {
                    if (highest == 0) {
                        System.out.println("there is no higest score yet");
                        // TODO: Print that there is no highest score yet
                    } else {
                        // TODO: Print the highest score so far
                        System.out.println(highest);
                    }
                } else {
                    System.out.println("I don't understand");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void showHelp() {
        // TODO: Add lines to print out the help menu as shown on the lab instructions
        System.out.print("h or help       : Prints this message");
        System.out.println("q or quit       : Quits the program");
        System.out.println("use <n> <s>     : Get a new dice set with n dice of s sides each");
        System.out.println("roll all        : Roll all the dice in your current dice set");
        System.out.println("roll <i>        : Roll the ith die of your current dice set");
        System.out.println("high or highest : Prints the highest roll so far");
    }
}
