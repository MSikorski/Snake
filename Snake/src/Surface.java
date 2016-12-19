import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Surface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int xmax = 600;
	private static final int ymax = 600;
	Snake snake;
	Rectangle2D rectangle[] = new Rectangle2D[40];
	Rectangle2D jedzenie;
	Graphics g1;

	public Surface(Snake snake) {
		setPreferredSize(new Dimension(xmax, ymax));
		setBackground(Color.BLACK);
		snake.createFood(xmax, ymax);
		update(snake);
	}

	@Override
	protected void paintComponent(Graphics g) {
		update(snake);
		//System.out.println("cos sie wgl odpierdala?");
		super.paintComponent(g);
		maluj(g);
	}

	public void update(Snake snake) {
		this.snake = snake;
		for (int i = 0; i < snake.dlugosc; i++) {
			rectangle[i] = new Rectangle2D.Double(snake.punkt[i].wspx, snake.punkt[i].wspy, 9, 9);
			System.out.println(snake.punkt[i].wspx + " " + snake.punkt[i].wspy);
		}
		jedzenie = new Rectangle2D.Double(snake.jedzenie.wspx, snake.jedzenie.wspy, 9, 9);
	}

	public void maluj(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		if (snake.jedzenie.vis) {
			g2d.setColor(Color.RED);
			g2d.fill(jedzenie);
		}
		g2d.setColor(Color.WHITE);
		g2d.fill(rectangle[0]);
		g2d.setColor(Color.GRAY);
		for (int i = 1; i < snake.dlugosc; i++) {
			g2d.fill(rectangle[i]);
		}
	}
}
