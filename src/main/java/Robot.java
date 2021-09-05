public class Robot {


    Direction direction;
    Coordinate coordinate = new Coordinate(0, 0);


    public void setPosition(String command) {
        String[] cmn = command.split(" ");

        try {
            coordinate.setX(Integer.parseInt(cmn[0]));
            coordinate.setY(Integer.parseInt(cmn[1]));

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please enter valid position");
        }

        if (cmn[2].equals("N")) {
            this.direction = Direction.NORTH;
        }
        else if (cmn[2].equals("S")) {
            this.direction = Direction.SOUTH;
        }
        else if (cmn[2].equals("E")) {
            this.direction = Direction.EAST;
        }
        else if (cmn[2].equals("W")) {
            this.direction = Direction.WEST;
        }
        else {
            throw new IllegalArgumentException("Please enter valid direction");
        }
    }

    public String excute(String commands, Plateau plateau) {

        for (char c : commands.toCharArray()) {
            if (c == 'L') {

                direction = direction.left();

            } else if (c == 'R') {
                direction = direction.right();

            } else if (c == 'M') {
                coordinate = plateau.move(coordinate, direction);
            } else {
                throw new IllegalArgumentException("Please enter valid command");
            }
        }


        return coordinate.getX() + " " + coordinate.getY() + " " + direction.current();
    }

}
