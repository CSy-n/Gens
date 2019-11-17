
public class Bot {

	GeneralIO g;
	private Position currentPosition = null;
	
	private int general_army_count;
	private boolean is_expedition_active;
	
	
	private Position current_expedition_coordinate;
	private int expedition_army_count;
	private Position target_coordinate;
	private General general;
	
	/**
	 * @symbol Expedition, represents an army on a quest.
	 */

	/**
	 * Represents the minimum to start a new
	 *  Expedition for conquest.
	 */
	private static final int START_MIN_EXPEDITION = 15;
	/**
	 * Represents the minimum army count to end an expedition.
	 * @see EXPEDITION
	 */
	private static final int END_MIN_EXPEDITION = 5;
	
	
	public Bot(GeneralIO generalIO) {
		this.g = generalIO;
	}
	
	
	
	
	/**
	 * Brute force other armies.
	 */
	public void process() {
		
		// Start a new expedition
		if(!this.isOnExpedition() && 
			(general_army_count >= START_MIN_EXPEDITION)) {
			startExpedition();
		} else {
			// Expedition . . .
			
			//Check if our Expedition is required. . .
			if(expedition_army_count <= END_MIN_EXPEDITION) {
				endExpedition();
			} else {
				// move towards target-coordinate
				moveTowards(current_expedition_coordinate, target_coordinate);
				
			}
		}
	}


	/**
	 * Starts a new Expedition, initializing 
	 * the start coordinate.
	 */
	private void startExpedition() {
		current_expedition_coordinate = general.getPosition();
		target_coordinate = generateTargetCoordinate();
		is_expedition_active = true;
	}
	
	private Position generateTargetCoordinate() {
		return Utils.generateRandomCoordinate();
	}




	private void endExpedition() {
		is_expedition_active = false;
	}


	private boolean isOnExpedition() {
		return is_expedition_active;
	}
}
