package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		//1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		//2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		int newX = 0;
		int newY = 0;
		//1. use an if statement to check on the currentDirection
		//   of the snake and calculate its next x and y position.
		if(currentDirection == Direction.RIGHT) {
			newX = head.getLocation().x + 1;
			newY = head.getLocation().y;
		}
		if(currentDirection == Direction.LEFT) {
			newX = head.getLocation().x - 1;
			newY = head.getLocation().y;
		}
		if(currentDirection == Direction.UP) {
			newX = head.getLocation().x;
			newY = head.getLocation().y - 1;
		}
		if(currentDirection == Direction.DOWN) {
			newX = head.getLocation().x;
			newY = head.getLocation().y + 1;
		}
		

		//2. Iterate through the SnakeSegments in reverse order
		//2a. Update each snake segment to the location of the segment 
		//    in front of it.
		for(int i = snake.size() - 1; i > 1; i--) {
			snake.get(i).setLocation(snake.get(i-1).getLocation());
		}
		
		
		//3. set the location of the head to the new location calculated in step 1
		head.setLocation(new Location(newX, newY));

		//4. set canMove to true
		canMove = true;
		
	}

	public void setDirection(Direction d) {
		if(canMove == true) {
			currentDirection = d;
			canMove = false;
		}
		//1. set the current direction equal to the passed in Direction only if canMove is true.
		//   set canMove equal to false.
		//   make sure the snake cannot completely reverse directions.	
	}

	public void reset(Location loc) {
		//1. clear the snake
		snake.clear();
		
		//2. set the location of the head
		head.setLocation(new Location(_00_SnakeGame.WINDOW_WIDTH/2, _00_SnakeGame.WINDOW_HEIGHT/2));
		
		//3. add the head to the snake
		snake.add(head);
	}

	public boolean isOutOfBounds() {
		//1. complete the method so it returns true if the head of the snake is outside of the window
		//   and false otherwise
		if(head.getLocation().x > _00_SnakeGame.WINDOW_WIDTH) {
			return true;
		}
		if(head.getLocation().x < 0) {
			return true;
		}
		if(head.getLocation().y > _00_SnakeGame.WINDOW_HEIGHT) {
			return true;
		}
		if(head.getLocation().y < 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean isHeadCollidingWithBody() {
		//1. complete the method so it returns true if the head is located
		//   in the same location as any other body segment
		for(int i = 1; i < snake.size(); i++) {
			if(snake.get(0).getLocation().equals(snake.get(i).getLocation())) {
				return true;
			}
		}
		
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		//1. complete the method so it returns true if the passed in
		//   location is located on the snake
		for(int i = 0; i < snake.size(); i++) {
			if(snake.get(i).getLocation().equals(loc)) {
				return true;
			}
		}
		
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
