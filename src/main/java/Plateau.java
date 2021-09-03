public class Plateau {

    private static  int height ;
    private static  int width ;

    public  Plateau(int height , int width){
        this.height = height;
        this.width = width;
    }

    public  boolean isFree(Coordinate coordinate){
        if((coordinate.getY() == 0) && (coordinate.getX() == 0)){
            return true;
        }else {
            return false;
        }
    }
    public Coordinate move(Coordinate coordinate, Direction direction){

        int x= coordinate.getX();
        int y =coordinate.getY();

        if (direction == Direction.NORTH){
            y = (y >= height) ? (y-height) +1 : y + 1  ;
        }
        if (direction == Direction.SOUTH){
            y = (y > 0) ? y-1 : height -1 ;
        }
        if (direction == Direction.EAST){
            x = (x >= width) ? (x-width) +1 : x + 1  ;
        }
        if (direction == Direction.WEST){
            x = (x > 0) ? x-1 : width -1 ;
        }

        return  new Coordinate(x,y);
    }

    public void dropRobot(Coordinate coordinate){
        coordinate.setX(0);
        coordinate.setY(0);
    }
}
