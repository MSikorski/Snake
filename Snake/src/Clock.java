
public class Clock implements Runnable {
	long timer;
	int counter=0;
	
	Frame frame;

	public Clock(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void run() {
		while (counter>=0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			while (frame.start) {
				if(counter>=4 && !frame.snake.jedzenie.vis){
					counter=0;
					frame.snake.createFood(600, 600);
				}
				frame.snake.move();
				
				if(frame.snake.checkFood()){
					frame.snake.create();
					frame.snake.jedzenie.vis=false;
				} else if((frame.snake.checkSnake() || frame.snake.checkWalls())){

					frame.start=false;
				}
				
				frame.repaint();
				counter++;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
