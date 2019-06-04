package Exception;

import java.io.FileNotFoundException;


public class NoEnemiesException extends FileNotFoundException {

	public NoEnemiesException(String enemyNumber) {
		super(enemyNumber);
	}
}
