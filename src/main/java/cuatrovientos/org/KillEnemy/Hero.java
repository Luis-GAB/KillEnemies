package cuatrovientos.org.KillEnemy;

public class Hero implements Character {

	public int enemigosMat;
	public int aliadosDef;
	
	public Hero() {
		this.enemigosMat = 0;
		this.aliadosDef = 0;
	}

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void kill() {}
	
	public void attack(Enemy enemy) {
		System.out.println("¡Has matado a un enemigo!");
		enemy.kill();
		enemigosMat++;
	}
	
	public void attack(Friend friend) {
		System.out.println("¡Has matado a un amigo!");
		friend.kill();
	}
	
	public void defend(Enemy enemy) {
		System.out.println("¡Has defendido a un enemigo!");
	}
	
	public void defend(Friend friend) {
		System.out.println("¡Has defendido a un amigo!");
		aliadosDef++;
	}

}
