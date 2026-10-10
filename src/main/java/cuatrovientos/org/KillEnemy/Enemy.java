package cuatrovientos.org.KillEnemy;

public class Enemy implements Character {
	
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void kill() {
		System.out.println("¡Ahhhggg, me mataste, bastardo!");
	}
	
	@Override
	public void heal() {
		System.out.println("¡Has curado a un enemigo!");
	}

}
