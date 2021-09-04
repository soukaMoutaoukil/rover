import java.util.Scanner;

public class Program {

    public static void main(String args[]){
        System.out.println("Plateau dimensions : ");
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate(dimensions);

        Robot robot = new Robot(plateau);

        System.out.println("Rover Initialization");
        String pos1 = scanner.nextLine();
        robot.setPosition(pos1);

        System.out.println("Please enter command");
        String firstCommand = scanner.nextLine();
        String position1 = robot.excute(firstCommand);


        System.out.println("Rover position after command : \n"+ position1);

        System.out.println("Rover Initialization");
        String pos2 = scanner.nextLine();
        robot.setPosition(pos2);

        System.out.println("Please enter command");
        String secondCommand = scanner.nextLine();
        String position2 = robot.excute(secondCommand);

        System.out.println("Rover position after command : \n"+ position2);


    }
}
