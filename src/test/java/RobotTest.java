import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void rotatLeft(){
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot(plateau);

        robot.setPosition("1 1 N");
        String result = robot.excute("LL");
        assertEquals("1 1 S", result);
    }

    @Test
    public void rotatRight(){
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot(plateau);

        robot.setPosition("1 1 N");
        String result = robot.excute("RRR");
        assertEquals("1 1 W", result);
    }

    @Test
    public void movement(){
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot(plateau);

        robot.setPosition("1 1 N");
        String result = robot.excute("MM");
        assertEquals("1 3 N", result);
    }

    @Test
    public void rotateMovement(){
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot(plateau);

        robot.setPosition("1 1 N");
        String result = robot.excute("MMR");
        assertEquals("1 3 E", result);
    }

   @Test
    public void testCommand(){
        Plateau plateau = new Plateau();
        plateau.plateauCoordinate("5 5");
        Robot robot = new Robot(plateau);

        robot.setPosition("1 2 N");
        String result = robot.excute("LMLMLMLMM");
        assertEquals("1 3 N", result);

       robot.setPosition("3 3 E");
       String result2 = robot.excute("MMRMMRMRRM");
       assertEquals("5 1 E", result2);

    }


}
