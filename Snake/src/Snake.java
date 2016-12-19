import java.awt.EventQueue;
import java.util.Random;

public class Snake {

	Random random = new Random();

	int xmax, ymax;
	int kierunek;
	Punkt punkt[] = new Punkt[40];
	int dlugosc = 0;

	Punkt jedzenie = new Punkt();

	public void move() {
		for (int i = dlugosc -1; i >0; i--) {
		
			punkt[i].wspx = punkt[i-1].wspx;
			punkt[i].wspy = punkt[i-1].wspy;
		}

		if (kierunek == 1) {
			punkt[0].wspy += 10;
		} else if (kierunek == 2) {
			punkt[0].wspx += 10;
		} else if (kierunek == 3) {
			punkt[0].wspy -= 10;
		} else if (kierunek == 4) {
			punkt[0].wspx -= 10;
		}

	}

	public void create() {
		punkt[dlugosc] = new Punkt(punkt[dlugosc - 1].wspx, punkt[dlugosc - 1].wspy, true);
		dlugosc++;

	}

	public Snake(int n, int xmax, int ymax) {
		this.xmax = xmax;
		this.ymax = ymax;

		int x = (random.nextInt(xmax / 10 - 1) + 1) * 10;
		int y = (random.nextInt(ymax / 10 - 1) + 1) * 10;
		kierunek = random.nextInt(4) + 1;

		punkt[0] = new Punkt(x, y, true);
		dlugosc = n;
		for (int i = 1; i < n; i++) {
			switch (kierunek) {
			case 1:
				punkt[i] = new Punkt(punkt[i - 1].wspx, punkt[i - 1].wspy - 10, true);
			case 2:
				punkt[i] = new Punkt(punkt[i - 1].wspx - 10, punkt[i - 1].wspy, true);
			case 3:
				punkt[i] = new Punkt(punkt[i - 1].wspx, punkt[i - 1].wspy + 10, true);
			case 4:
				punkt[i] = new Punkt(punkt[i - 1].wspx + 10, punkt[i - 1].wspy, true);
			}
		}
	}

	public boolean checkFood() {
		for (int i = 0; i < dlugosc; i++) {
			if ((punkt[i].wspx == jedzenie.wspx) && (punkt[i].wspy == jedzenie.wspy))
				return true;
		}
		return false;
	}

	public boolean checkSnake() {
		for (int i = 0; i < dlugosc; i++) {
			for (int j = 0; j < dlugosc; j++) {
				if ((punkt[i].wspx == punkt[j].wspx) && (punkt[i].wspy == punkt[j].wspy) && !(i==j)) {
					System.out.println("to pier1doli " + i + " " + j + "!");
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkWalls() {
		for (int i = 0; i < dlugosc; i++) {
			if ((punkt[i].wspx < 0) || (punkt[i].wspx > xmax) || (punkt[i].wspy < 0) || (punkt[i].wspy > ymax)) {
				return true;
			}
		}
		return false;
	}

	public void createFood(int xmax, int ymax) {
		int x = (random.nextInt(xmax / 10 - 1) + 1) * 10;
		int y = (random.nextInt(ymax / 10 - 1) + 1) * 10;
		jedzenie = new Punkt(x, y, true);

		while (checkFood()) {
			x = (random.nextInt(xmax / 10 - 1) + 1) * 10;
			y = (random.nextInt(ymax / 10 - 1) + 1) * 10;
			jedzenie = new Punkt(x, y, true);
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Frame();
			}
		});
	}

}
