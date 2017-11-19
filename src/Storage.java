
import java.util.*;

/**
 * 
 */
public abstract class Storage extends Building {

	/**
	 * Default constructor
	 */
	public Storage() {
	}

	/**
	 * 
	 */
	private int capacity;

	/**
	 * 
	 */
	private Set<Physical> stored;

	/**
	 * @param res 
	 * @param amount 
	 * @return
	 */
	private boolean isStorable(Resource res, int amount) {
		// TODO implement here
		return false;
	}

	/**
	 * @param res 
	 * @param amount 
	 * @param int 
	 * @return
	 */
	public boolean store(Resource res, void amount, void int) {
		// TODO implement here
		return false;
	}

}