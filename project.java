import java.util.Scanner;/

class InvalidMapException extends Exception{
    public InvalidMapException(String error){
        super(error);
    }
}
class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean equals(Position equ_1) {
        if (this.x == equ_1.x && this.y == equ_1.y) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}

class Map {
    private int n;
    private char[][] map;

    public Map(Scanner read) throws InvalidMapException {


        n = read.nextInt();
        if (n == 0) {
            throw new InvalidMapException("Map size can not be zero!");
        } else {
            map = new char[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    map[i][j] = read.next().charAt(0);
                    if (map[i][j] != '0' && map[i][j] != '1' && map[i][j] != 'P') {
                        throw new InvalidMapException("Not enough map elements");
                    }
                }
            }
        }

    }
    public void print(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int getSize() {
        return n;
    }

    public char getValueAt(int x, int y) {
        return map[x][y];
    }
}

interface Player {
    void onGame();
    void setMap(Map m);

    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();

    Position getPosition();
}

class MyPlayer implements Player {
    private Map map;
    Position position;
    public void onGame() {
        position = new Position(0,0);
        int n = this.map.getSize();
        for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j) if (this.map.getValueAt(i, j) == 'P') {
            position.setX(j);
            position.setY(i);
            return;
        }
        System.out.println("We didn't find player! :(");
    }

    @Override
    public void setMap(Map m) {
        this.map = m;
    }

    private boolean checkPosition(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x >= map.getSize() || y >= map.getSize()) return false;
        if (map.getValueAt(y, x) == '1') return false;
        return true;
    }

    @Override
    public void moveDown() {
        if (checkPosition(position.getX(), position.getY() + 1)) {
            position.setY(position.getY() + 1);
        }
    }

    @Override
    public void moveUp() {
        if (checkPosition(position.getX(), position.getY() - 1)) {
            position.setY(position.getY() - 1);
        }
    }

    @Override
    public void moveLeft() {
        if (checkPosition(position.getX() - 1, position.getY())) {
            position.setX(position.getX() - 1);
        }

    }

    @Override
    public void moveRight() {
        if (checkPosition(position.getX() + 1, position.getY())) {
            position.setX(position.getX() + 1);
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }
}

class Game{
    private Map map;

    public Map getMap() {
        return map;
    }

    public void addPlayer(Player p){
        p.setMap(map);
        p.onGame();
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Game(Map map){
        this.map = map;
    }
}


public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();


// Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());

            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));
        }

        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);
                System.out.println(map.getValueAt(size/2, size/2));
            }
            catch(Exception e){}
        }

        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }

        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }

        // Checking the Game class and all of its components
        else if(className.equals("Game")){

            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getY());
            System.out.println("Col: " + playerPosition.getX());
        }
    }
}