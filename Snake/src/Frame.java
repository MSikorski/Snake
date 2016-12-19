import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	Snake snake = new Snake(6, 600, 600);
	Surface surface = new Surface(snake);
	JPanel menu = new JPanel();
	JPanel help = new JPanel();

	Clock clock = new Clock(this);

	boolean start = false;
	boolean a = false;

	// Graphics g = new Graphics();

	public Frame() {
		super("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(50, 50);
		setSize(800, 600);
		setResizable(false);
		addKeyListener(this);

		setMenu();
		help.add(surface);
		help.add(menu);
		add(help);
		setVisible(true);
		// pack();

		Thread c = new Thread(clock);
		c.start();
	}

	public void setMenu() {
		menu.setPreferredSize(new Dimension(100, 600));
		menu.add(new JLabel("Spacja start/stop"));
		menu.add(new JLabel("win = wiadro"));
		// menu.setLayout(new GridLayout(5, 1));
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if ((key.getKeyCode() == KeyEvent.VK_DOWN) && !(snake.kierunek==3)) {
			snake.kierunek = 1;
		} else if ((key.getKeyCode() == KeyEvent.VK_RIGHT) && !(snake.kierunek==4)) {
			snake.kierunek = 2;
		} else if ((key.getKeyCode() == KeyEvent.VK_UP) && !(snake.kierunek==1)) {
			snake.kierunek = 3;
		} else if ((key.getKeyCode() == KeyEvent.VK_LEFT) && !(snake.kierunek==2)) {
			snake.kierunek = 4;
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if ((key.getKeyCode() == KeyEvent.VK_SPACE) && (!(start))) {
			start = true;
			System.out.println("start");
		} else if ((key.getKeyCode() == KeyEvent.VK_SPACE) && (start)) {
			start = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
