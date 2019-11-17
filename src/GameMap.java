
public class GameMap {
	
	private enum Cell {
		CELL_EMPTY(-1),
		CELL_MOUNTAIN(-2),
		CELL_FOG(-3),
		CELL_FOG_OBSTACLE(-4);
		
		
	    private final int identifier;

	    private Cell(int identifier) {
	        this.identifier = identifier;
	    }
	}
	
	enum S {
		T(1),
				
	}

	public static int getWidth() {
		return 0;
	}

	public static int getHeight() {
		return 0;
	}

}
