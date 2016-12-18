
public class Snake {

	int kierunek;
	Punkt punkt[] = new Punkt[40];
	int dlugosc;

	public void move(){
		if(kierunek==1){
			punkt[0].wspy++;
		} else if(kierunek==2){
			punkt[0].wspx++;
		} else if(kierunek==3){
			punkt[0].wspy--;
		} else if(kierunek==4){
			punkt[0].wspx--;
		}
		
		for(int i=1;i<punkt.length;i++){
			punkt[i].wspx=punkt[i-1].wspx;
			punkt[i].wspy=punkt[i-1].wspy;
		}
	}
}
