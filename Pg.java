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
    private int i[]=new int[4];

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
						
		}}catch(Exception e){Trans('d');}
	}

	public void MoveSx(){
		try{
			if(Map.maze[pathx-1][pathy]!=1&&!Main.gOver){
				Trans('a');
			}}catch(Exception e){Trans('a');}
	}

	public void MoveUp(){
		if(Map.maze[pathx][pathy-1]!=1&&!Main.gOver){
			Trans('w');				
		}
	}

	public void MoveDw(){
		if(Map.maze[pathx][pathy+1]!=1&&!Main.gOver){
			Trans('s');			
		}

	}

	public void run(){
		while(true){
			if(Main.gOver){
				for(int i=0;i<13;i++){
					Pac=death[i];
					try{Thread.sleep(75);}catch(Exception e){}
				}
				break;
			}
			switch(Main.cdir){
				case 'a':MoveSx();break;
				case 'd':MoveDx();break;
				case 's':MoveDw();break;
				case 'w':MoveUp();break;
			}
			Score();
		}
	}


	//Aumenta i pixel di un quadrato di array grafico(la grandezza di uno spostamento reale) per creare una transizione
	public void Trans(char dir){
		int v=8;
		if(dir=='w'||dir=='s'){
			if(dir=='w'){
				for(tY=0;Math.abs(tY)!=Main.dY;tY--){
					aSprite(dir);
					try{Thread.sleep(v);}catch(Exception e){}
				}
				tY=0;
				pathy--;}
				else{
					for(tY=0;Math.abs(tY)!=Main.dY;tY++){
						aSprite(dir);
						try{Thread.sleep(v);}catch(Exception e){}
					}
					tY=0;
					pathy++;
				}
		}

		else {
			if(dir=='a'){
				for(tX=0;Math.abs(tX)!=Main.dX;tX--){
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
				for(tX=0;Math.abs(tX)!=Main.dX;tX++){
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


	public void Score(){
		
		i[0]=Main.score%10;
		i[1]=Main.score%100;
		i[1]=i[1]/10;
		System.out.println(i[1]);
		i[2]=Main.score%1000;
		i[2]=i[2]/100;
		i[3]=Main.score/1000;

		for(int l=0;l<4;l++)
			switch(i[l]){
				case 0:{Main.sf[l]=Main.s[0];}break;
				case 1:{System.out.println("ASSADGASFDASDUFHAUSDF");Main.sf[l]=Main.s[1];}break;
				case 2:{Main.sf[l]=Main.s[2];}break;
				case 3:{Main.sf[l]=Main.s[3];}break;
				case 4:{Main.sf[l]=Main.s[4];}break;
				case 5:{Main.sf[l]=Main.s[5];}break;
				case 6:{Main.sf[l]=Main.s[6];}break;
				case 7:{Main.sf[l]=Main.s[7];}break;
				case 8:{Main.sf[l]=Main.s[8];}break;
				case 9:{Main.sf[l]=Main.s[9];}break;
			}


	}

	

	

}