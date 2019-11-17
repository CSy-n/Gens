import java.util.Random;

public class Utils {

	
	/**
	 * Generates a new Random Coordinate on the GameMap.
	 * @return
	 */
	public static Position generateRandomCoordinate() {
		Position position;
		Random random = new Random();

		
		return new Position(		
				random.nextInt(GameMap.getHeight()),
				random.nextInt(GameMap.getWidth()));
	}

}
