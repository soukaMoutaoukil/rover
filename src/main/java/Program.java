import java.util.Scanner;

public class Program {

    public static void main(String args[]) {
        System.out.println("Plateau dimensions : ");
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();

        // Create Plateau
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate(dimensions);
        while (true) {
            //add robot to plateau
            Robot robot = new Robot();
            System.out.println("Rover Initialization");
            String position = scanner.nextLine();
            robot.setPosition(position);
            if (plateau.isFree(robot.coordinate)) {
                plateau.addRover(robot);
            } else {
                System.out.println("Rover already exist in this position");
                break;
            }
            System.out.println("Please enter command");
            String firstCommand = scanner.nextLine();
            String finalPosition;
            finalPosition = robot.excute(firstCommand, plateau);
            System.out.println("Rover position after movement : \n" + finalPosition);

        }

    }
}
