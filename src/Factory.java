
import java.util.*;

/**
 * 
 */
public abstract class Factory extends Building {

	/**
	 * Default constructor
	 */
	public Factory() {
	}

	/**
	 * 
	 */
	private double percentage;

	/**
	 * 
	 */
	private double ratio;

	/**
	 * 
	 */
	private Set<Primary> toTransform;

	/**
	 * 
	 */
	private Set<Manufactured> transformed;

	/**
	 * @return
	 */
	public boolean isWorking() {
		// TODO implement here
		return false;
	}

}