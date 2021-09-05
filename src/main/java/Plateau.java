import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private static int maxHeight;
    private static int maxWidth;
    private static int minHeight = 0;
    private static int minWidth = 0;

    private List<Robot> robots = new ArrayList<Robot>();

    public void plateauCoordinate(String command) {
        String[] cmnd = command.split(" ");

        this.maxHeight = Integer.parseInt(cmnd[0]);
        this.maxWidth = Integer.parseInt(cmnd[1]);


    }

    public void addRover(Robot robot) {
        robots.add(robot);
    }

    public Coordinate move(Coordinate coordinate, Direction direction) {

        int x = coordinate.getX();
        int y = coordinate.getY();

        // check if coordinate are inside plateau

        if ((x > maxWidth) || (y > maxHeight) || (x < minWidth) || (y < minHeight)) {
            throw new IllegalArgumentException("Rover is outside plateau");
        }

        if (direction == Direction.NORTH) {
            y = (y >= maxHeight) ? (y - maxHeight) + 1 : y + 1;
        }
        if (direction == Direction.SOUTH) {
            y = (y > minHeight) ? y - 1 : maxHeight - 1;
        }
        if (direction == Direction.EAST) {
            x = (x >= maxWidth) ? (x - maxWidth) + 1 : x + 1;
        }
        if (direction == Direction.WEST) {
            x = (x > minWidth) ? x - 1 : maxWidth - 1;
        }

        return new Coordinate(x, y);
    }

    public boolean isFree(Coordinate coordinate) {
        for (Robot robot : robots) {

            if ((robot.coordinate.getX() == coordinate.getX()) && (robot.coordinate.getY() == coordinate.getY())) {
                return false;
            }
        }
        return true;
    }


}
