import java.awt.image.BufferedImage;

public class Pg implements Runnable{
	public int pathx,pathy;
	public int tX=0;  //Translate x
	public int tY=0;  //Translate y
	public int vel=200;//Inversa in ms
	private BufferedImage[] death=new BufferedImage[13];//1 immagine trasparente
	private BufferedImage[] pac=new BufferedImage[9];
	public BufferedImage Pac;
	private Boolean c=true;


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
		try{
			if(Map.maze[pathx+1][pathy]!=1&&!Main.gOver){
				Trans('d');
				if(Map.maze[pathx][pathy]==5){Main.Eat=true;Map.maze[pathx][pathy]=0;} //Se mangia la palla grossa lui può mangiare i fantasmi e la palla diventa uno spazio vuoto 0
				else if(Map.maze[pathx][pathy]==4){Map.maze[pathx][pathy]=0;Main.score=Main.score+10;}
				else if(Map.maze[pathx][pathy]==2){Map.maze[pathx][pathy]=3;}			
		}}catch(Exception e){Trans('d');}
	}

	public void MoveSx(){
		try{
			if(Map.maze[pathx-1][pathy]!=1&&!Main.gOver){
				Trans('a');
				if(Map.maze[pathx][pathy]==5){Main.Eat=true;Map.maze[pathx][pathy]=0;}//Palla grossa
				else if(Map.maze[pathx][pathy]==4){Map.maze[pathx][pathy]=0;Main.score=Main.score+10;}
				else if(Map.maze[pathx][pathy]==2){Map.maze[pathx][pathy]=3;}
			}}catch(Exception e){Trans('a');}
	}

	public void MoveUp(){
		if(Map.maze[pathx][pathy-1]!=1&&!Main.gOver){
			Trans('w');
			if(Map.maze[pathx][pathy]==5){Main.Eat=true;Map.maze[pathx][pathy]=0;}
			else if(Map.maze[pathx][pathy]==4){Map.maze[pathx][pathy]=0;Main.score=Main.score+10;}
			else if(Map.maze[pathx][pathy]==2){Map.maze[pathx][pathy]=3;}
				
		}
	}

	public void MoveDw(){

		
		if(Map.maze[pathx][pathy+1]!=1&&!Main.gOver){
			Trans('s');
			if(Map.maze[pathx][pathy]==5){Main.Eat=true;Map.maze[pathx][pathy]=0;}//Palla grossa
			else if(Map.maze[pathx][pathy]==4){Map.maze[pathx][pathy]=0;Main.score=Main.score+10;}
			else if(Map.maze[pathx][pathy]==2){Map.maze[pathx][pathy]=3;}
			
					
				
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
			System.out.println(Main.score);
		}
	}

	public Boolean Controllo(){
		switch(Main.cdir){
				case 'a':if(Map.maze[pathx-1][pathy]!=1) return true;
				case 'd':if(Map.maze[pathx+1][pathy]!=1) return true;
				case 's':if(Map.maze[pathx][pathy+1]!=1) return true;
				case 'w':if(Map.maze[pathx][pathy-1]!=1) return true;
			}
			return false;
	}


	//Aumenta i pixel di un quadrato di array grafico(la grandezza di uno spostamento reale) per creare una transizione
	public void Trans(char dir){
		int v;
		if(dir=='w'||dir=='s'){
			v=vel/Frame.dY;
			if(dir=='w'){
				for(tY=0;Math.abs(tY)!=Frame.dY;tY--){
					aSprite(dir);
					try{Thread.sleep(v);}catch(Exception e){}
				}
				tY=0;
				pathy--;}
				else{
					for(tY=0;Math.abs(tY)!=Frame.dY;tY++){
						aSprite(dir);
						try{Thread.sleep(v);}catch(Exception e){}
					}
					tY=0;
					pathy++;
				}
		}

		else {
			v=vel/Frame.dX;
			if(dir=='a'){
				for(tX=0;Math.abs(tX)!=Frame.dX;tX--){
					aSprite(dir);
					try{Thread.sleep(v);}catch(Exception e){}
				}
				tX=0;
				if((pathx-1)!=-1)
					pathx--;
				else
					pathx=27;
				}
			else{
				for(tX=0;Math.abs(tX)!=Frame.dX;tX++){
					aSprite(dir);
					try{Thread.sleep(v);}catch(Exception e){}
				}
				tX=0;
				if((pathx+1)!=28)
					pathx++;
				else
					pathx=0;
			}
		}

			


	}
	
	//Alternate sprite
	public void aSprite(char dir){
		switch(dir){
			case 'd':{if(c){
						Pac=pac[1];
						c=!c;
				      }else{
						Pac=pac[2];
						c=!c;
					 }}break;
			case 'a':{if(c){
						Pac=pac[3];
						c=!c;
					  }else{
						Pac=pac[4];
						c=!c;
						}}break;
			case 'w':{if(c){
						Pac=pac[5];
						c=!c;
					  }else{
						Pac=pac[6];
						c=!c;
						}}break;
			case 's':{if(c){
						Pac=pac[7];
						c=!c;
					  }else{
						Pac=pac[8];
						c=!c;
						}}break;
		}
	}

	

	

}