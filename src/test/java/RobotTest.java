import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void rotatLeft() {
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot();
        robot.setPosition("1 1 N");
        plateau.addRover(robot);
        String result = robot.excute("LL", plateau);
        assertEquals("1 1 S", result);
    }

    @Test
    public void rotatRight() {
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot();
        plateau.addRover(robot);
        robot.setPosition("1 1 N");
        String result = robot.excute("RRR", plateau);
        assertEquals("1 1 W", result);
    }

    @Test
    public void movement() {
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot();

        robot.setPosition("1 1 N");
        plateau.addRover(robot);
        String result = robot.excute("MM", plateau);
        assertEquals("1 3 N", result);
    }

    @Test
    public void rotateMovement() {
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot();

        robot.setPosition("1 1 N");
        plateau.addRover(robot);
        String result = robot.excute("MMR", plateau);
        assertEquals("1 3 E", result);
    }

    @Test
    public void testCommand() {
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot();

        robot.setPosition("1 2 N");
        plateau.addRover(robot);
        plateau.isFree(robot.coordinate);
        plateau.move(robot.coordinate, robot.direction);
        String result = robot.excute("LMLMLMLMM", plateau);
        assertEquals("1 3 N", result);
        robot.setPosition("3 3 E");
        String result2 = robot.excute("MMRMMRMRRM", plateau);
        assertEquals("5 1 E", result2);

    }


}
