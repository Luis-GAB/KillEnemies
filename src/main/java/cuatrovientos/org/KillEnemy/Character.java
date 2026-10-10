package cuatrovientos.org.KillEnemy;

import java.io.Serializable;

public interface Character extends Serializable {
	
	public boolean isEnemy();

	public void kill();
	
	public void heal();

}
