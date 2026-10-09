package cuatrovientos.org.KillEnemy;

public class Friend implements Character {

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void heal() {
		System.out.println("¡Has curado al aliado!");
	}

}
