package cuatrovientos.org.KillEnemy;

public class Enemy implements Character {

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void kill() {
		System.out.println("¡Ahhhggg, me mataste, bastardo!");
	}

}
