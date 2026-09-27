package part2_decomposition;

import java.util.Scanner;

/*
 * Part 2. Decomposition
 *
 * PSEUDOCODE:
 *
 * START
 *
 * Create Scanner for user input.
 *
 * REPEAT
 *     Print welcome message.
 *
 *     Get user's name.
 *     Get user's age.
 *     Get user's preferred game genre.
 *
 *     Select recommendation based on age and genre.
 *
 *     Print greeting.
 *     Print recommendation.
 *
 *     Ask user if they want to repeat.
 *
 * UNTIL user answers N.
 *
 * Print final message.
 *
 * END
 */

public class Part2Decomposition {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Part 2.1. Start the program.
        runGameRecommendation();

        scanner.close();
    }

    // Part 2.2. Main program method.
    public static void runGameRecommendation() {

        boolean repeat;

        do {

            print("\n==========================================");
            print("       PART 2. GAME RECOMMENDATION");
            print("==========================================");

            // Part 2.3. Input user's name.
            String name = getUserString("What is your name? ");

            // Part 2.4. Input user's age.
            int age = getUserInt("How old are you? ");

            // Part 2.5. Input user's preferred genre.
            String genre = getUserString(
                    "What type of game do you like? "
            );

            // Part 2.6. Output greeting.
            print("\nHello, " + name + "!");
            print("Here is my recommendation:");

            // Part 2.7. Get recommendation.
            String recommendation = getRecommendation(age, genre);

            print("I recommend " + recommendation + ".");
            print("Enjoy your game, " + name + "!");

            // Part 2.8. Y/N dialog.
            repeat = askYesNo(
                    "\nDo you want to repeat the conversation? (Y/N): "
            );

        } while (repeat);

        print("\nPart 2 finished.");
    }

    // Part 2.9. Method for output.
    public static void print(String message) {

        System.out.println(message);
    }

    // Part 2.10. Method for String input.
    public static String getUserString(String prompt) {

        System.out.print(prompt);

        return scanner.nextLine();
    }

    // Part 2.11. Method for integer input.
    public static int getUserInt(String prompt) {

        while (true) {

            String input = getUserString(prompt);

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException exception) {

                print("Please enter a valid whole number.");
            }
        }
    }

    // Part 2.12. Y/N dialog method.
    public static boolean askYesNo(String prompt) {

        while (true) {

            String answer = getUserString(prompt);

            if (answer.equalsIgnoreCase("y")) {

                return true;
            }

            if (answer.equalsIgnoreCase("n")) {

                return false;
            }

            print("Please enter Y or N.");
        }
    }

    // Part 2.13. Select recommendation by age.
    public static String getRecommendation(int age, String genre) {

        if (age >= 13 && age <= 16) {

            return getTeenRecommendation(genre);

        } else if (age >= 17 && age <= 25) {

            return getYoungAdultRecommendation(genre);

        } else if (age > 25) {

            return getAdultRecommendation(genre);

        } else {

            return "Minecraft for you";
        }
    }

    // Part 2.14. Recommendation for ages 13-16.
    public static String getTeenRecommendation(String genre) {

        if (genre.equalsIgnoreCase("action")) {

            return "Spider-Man: Miles Morales";

        } else if (genre.equalsIgnoreCase("rpg")) {

            return "Minecraft";

        } else if (genre.equalsIgnoreCase("racing")) {

            return "Forza Horizon 5";

        } else {

            return "Dota 2";
        }
    }

    // Part 2.15. Recommendation for ages 17-25.
    public static String getYoungAdultRecommendation(String genre) {

        if (genre.equalsIgnoreCase("action")) {

            return "Red Dead Redemption 2";

        } else if (genre.equalsIgnoreCase("rpg")) {

            return "The Witcher 3";

        } else if (genre.equalsIgnoreCase("racing")) {

            return "Forza Horizon 5";

        } else {

            return "GTA V";
        }
    }

    // Part 2.16. Recommendation for ages over 25.
    public static String getAdultRecommendation(String genre) {

        if (genre.equalsIgnoreCase("action")) {

            return "Red Dead Redemption 2";

        } else if (genre.equalsIgnoreCase("rpg")) {

            return "The Witcher 3";

        } else if (genre.equalsIgnoreCase("racing")) {

            return "Euro Truck Simulator 2";

        } else {

            return "osu!";
        }
    }
}