import java.awt.image.BufferedImage;

public class Pg implements Runnable{
	public int pathx,pathy;
	private BufferedImage[] death=new BufferedImage[13];//1 immagine trasparente
	private BufferedImage[] pac=new BufferedImage[9];
	static BufferedImage Pac;


	public Pg(int x,int y){
		pathx=x;
		pathy=y;
		


		 pac[0]=Main.img.getSubimage(36,1,13,13);
	  	 Pac=pac[0];
	  	 pac[1]=Main.img.getSubimage(20,1,13,13);
	  	 pac[2]=Main.img.getSubimage(4,1,13,13);
	  	 pac[3]=Main.img.getSubimage(20,17,13,13);
	  	 pac[4]=Main.img.getSubimage(4,17,13,13);
	  	 pac[5]=Main.img.getSubimage(20,33,13,13);
	  	 pac[6]=Main.img.getSubimage(4,33,13,13);
	  	 pac[7]=Main.img.getSubimage(20,49,13,13);
	  	 pac[8]=Main.img.getSubimage(4,49,13,13);


	  	 death[0]=Main.img.getSubimage(36,1,13,13);
	  	 death[1]=Main.img.getSubimage(52,1,13,13);
	  	 death[2]=Main.img.getSubimage(67,1,15,13);
	  	 death[3]=Main.img.getSubimage(83,1,15,13);
	  	 death[4]=Main.img.getSubimage(99,1,15,13);
	  	 death[5]=Main.img.getSubimage(115,1,15,13);
	  	 death[6]=Main.img.getSubimage(131,1,15,13);
	  	 death[7]=Main.img.getSubimage(148,1,13,13);
	  	 death[8]=Main.img.getSubimage(163,1,13,13);
	  	 death[9]=Main.img.getSubimage(178,1,13,13);
	  	 death[10]=Main.img.getSubimage(189,1,13,13);
	  	 death[11]=Main.img.getSubimage(203,1,13,13);
	  	 death[12]=Main.img.getSubimage(0,0,1,1);
	}

	public void MoveDx(){
		Boolean c=true;
		while(Map.maze[pathx+1][pathy]!=1&&Main.cdir=='d'&&!Main.gOver){
			if(c){
				Pac=pac[1];
				c=!c;
			}else{
				Pac=pac[2];
				c=!c;
				}
			pathx++;
			if(Map.maze[pathx][pathy]==4){Main.Eat=true;}//Palla grossa
			Map.maze[pathx][pathy]=0;
			try{Thread.sleep(250);}catch(Exception e){}
			
		}
	}

	public void MoveSx(){
		Boolean c=true;
		while(Map.maze[pathx-1][pathy]!=1&&Main.cdir=='a'&&!Main.gOver){
			if(c){
				Pac=pac[3];
				c=!c;
			}else{
				Pac=pac[4];
				c=!c;
				}
			pathx--;
			if(Map.maze[pathx][pathy]==4){Main.Eat=true;}//Palla grossa
			Map.maze[pathx][pathy]=0;
			try{Thread.sleep(250);}catch(Exception e){}
		}
	}

	public void MoveUp(){
		Boolean c=true;
		while(Map.maze[pathx][pathy-1]!=1&&Main.cdir=='w'&&!Main.gOver){
			if(c){
				Pac=pac[5];
				c=!c;
			}else{
				Pac=pac[6];
				c=!c;
				}
			pathy--;
			if(Map.maze[pathx][pathy]==4){Main.Eat=true;}//Palla grossa
			Map.maze[pathx][pathy]=0;
			try{Thread.sleep(250);}catch(Exception e){}
		}
	}

	public void MoveDw(){

		Boolean c=true;
		while(Map.maze[pathx][pathy+1]!=1&&Main.cdir=='s'&&!Main.gOver){
			if(c){
				Pac=pac[7];
				c=!c;
			}else{
				Pac=pac[8];
				c=!c;
				}
			pathy++;
			if(Map.maze[pathx][pathy]==4){Main.Eat=true;}//Palla grossa
			Map.maze[pathx][pathy]=0;
			try{Thread.sleep(250);}catch(Exception e){}
		}

	}

	public void run(){
		while(true){
			if(Main.gOver){
				for(int i=0;i<13;i++){
					Pac=death[i];
					try{Thread.sleep(100);}catch(Exception e){}
				}
				break;
			}
			switch(Main.cdir){
				case 'a':MoveSx();break;
				case 'd':MoveDx();break;
				case 's':MoveDw();break;
				case 'w':MoveUp();break;
			}
		}
	}

	

	

}