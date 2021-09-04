public class Robot {


    Direction direction;
    Coordinate coordinate = new Coordinate(0,0);
    Plateau plateau ;

  //  private boolean free = false;

     public Robot(Plateau plateau){
      this.plateau = plateau;
     }

    public  void setPosition(String command){
      String[] cmn=   command.split(" ");
     
         coordinate.setX(Integer.parseInt(cmn[0]));
         coordinate.setY(Integer.parseInt(cmn[1]));
         if (cmn[2].equals("N")){
             this.direction = Direction.NORTH;
         }
        if (cmn[2].equals("S")){
            this.direction = Direction.SOUTH;
        }
        if (cmn[2].equals("E")){
            this.direction = Direction.EAST;
        }
        if (cmn[2].equals("W")){
            this.direction = Direction.WEST;
        }


    }
    String excute(String commands){



        for (char c : commands.toCharArray()){
            if (c == 'L'){

                direction = direction.left();

            }
            else if (c == 'R'){
                direction = direction.right();

            }
           else  if (c == 'M'){
                 // free = false;
                  coordinate = plateau.move(coordinate,direction);

            }
            else {
                throw new IllegalArgumentException("Please enter valid command");
            }
        }
       // free = true;

        return coordinate.getX()+" "+coordinate.getY()+" "+ direction.current();
    }

}
