package cuatrovientos.org.KillEnemy;

public class Friend implements Character {
	
	private static final long serialVersionUID = 1L;

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
