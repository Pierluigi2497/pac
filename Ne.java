import java.awt.image.BufferedImage;
public class Ne implements Runnable {
	public int pathx,pathy;
	private int vel=250;
	public int tX=0;  //Translate x
	public int tY=0;  //Translate y
	private BufferedImage[] i=new BufferedImage[13];
	public BufferedImage n;
	private Boolean c=true;
	private boolean nuovo,uscito;
	public Ne(int x,int y,String a){
		pathx=x;
		pathy=y;
		nuovo=true;
		uscito=false;
		//0-1 Destra  2-3 Sinistra  4-5 Sopra  6-7 Sotto  8-9 Blu  10-11 Bianco-Blu  12 Trasparente
		if(a=="red"){
			i[0]=Main.img.getSubimage(4,65,14,14);
			i[1]=Main.img.getSubimage(20,65,14,14);
			i[2]=Main.img.getSubimage(36,65,14,14);
			i[3]=Main.img.getSubimage(52,65,14,14);
			i[4]=Main.img.getSubimage(68,65,14,14);
			i[5]=Main.img.getSubimage(84,65,14,14);
			i[6]=Main.img.getSubimage(100,65,14,14);
			i[7]=Main.img.getSubimage(116,65,14,14);
			}
		else if(a=="pink"){
			i[0]=Main.img.getSubimage(4,81,14,14);
			i[1]=Main.img.getSubimage(20,81,14,14);
			i[2]=Main.img.getSubimage(36,81,14,14);
			i[3]=Main.img.getSubimage(52,81,14,14);
			i[4]=Main.img.getSubimage(68,81,14,14);
			i[5]=Main.img.getSubimage(84,81,14,14);
			i[6]=Main.img.getSubimage(100,81,14,14);
			i[7]=Main.img.getSubimage(116,81,14,14);
		}
		else if(a=="blue"){
			i[0]=Main.img.getSubimage(4,97,14,14);
			i[1]=Main.img.getSubimage(20,97,14,14);
			i[2]=Main.img.getSubimage(36,97,14,14);
			i[3]=Main.img.getSubimage(52,97,14,14);
			i[4]=Main.img.getSubimage(68,97,14,14);
			i[5]=Main.img.getSubimage(84,97,14,14);
			i[6]=Main.img.getSubimage(100,97,14,14);
			i[7]=Main.img.getSubimage(116,97,14,14);
		}
		else if(a=="yellow"){
			i[0]=Main.img.getSubimage(4,113,14,14);
			i[1]=Main.img.getSubimage(20,113,14,14);
			i[2]=Main.img.getSubimage(36,113,14,14);
			i[3]=Main.img.getSubimage(52,113,14,14);
			i[4]=Main.img.getSubimage(68,113,14,14);
			i[5]=Main.img.getSubimage(84,113,14,14);
			i[6]=Main.img.getSubimage(100,113,14,14);
			i[7]=Main.img.getSubimage(116,113,14,14);
		}
		i[8]=Main.img.getSubimage(132,65,14,14);
		i[9]=Main.img.getSubimage(148,65,14,14);
		i[10]=Main.img.getSubimage(164,65,14,14);
		i[11]=Main.img.getSubimage(180,65,14,14);
		i[12]=Main.img.getSubimage(0,0,1,1);
		n=i[0];
			
	}
	
	public void run(){
		if(nuovo){										//aggiungere nella mappa posizioni particolari "nodi/incroci" dove i nemici possono decidere di girare 
			for(;!uscito;){esci();}							//consentire al pg e ai fantasmini di passare sui nodi
			nuovo=false;
			Map.segnale++;	
			if(Map.segnale==4)Map.maze[13][12]=Map.maze[14][12]=1;}

		for(;;){
			if(Main.gOver){
				break;
			}
			if(radar()){	
				Follow();
				try{Thread.sleep(20);}catch(Exception e){}
				}
			else{	
				cieco();

				}

				
			
		}
	}

	public void Follow() {
		if(Map.maze[pathx+1][pathy]!=1&&pathx<Main.pg.pathx){
			Trans('d');

				if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
					Main.gOver=true;
					}
				
			}
		else
			if(Map.maze[pathx-1][pathy]!=1&&pathx>Main.pg.pathx){
				Trans('a');

					if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
						Main.gOver=true;
					}
					
				}
		else
			if(Map.maze[pathx][pathy+1]!=1&&pathy<Main.pg.pathy){
				Trans('s');

				if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
					Main.gOver=true;
				}
				
			}
		else
			if(Map.maze[pathx][pathy-1]!=1&&pathy>Main.pg.pathy){
				Trans('w');

						if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
							Main.gOver=true;
						}
						
				}



				

		
				
	}


	public void esci() {
		if(pathx<13&&Map.maze[pathx+1][pathy]!=1)
			Trans('d');
		else
			if(pathx>13&&Map.maze[pathx-1][pathy]!=1)
				Trans('a');
		else
			if(pathy<11&&Map.maze[pathx][pathy+1]!=1)
				Trans('s');			
		else
			if(pathy>11&&Map.maze[pathx][pathy-1]!=1)
				Trans('w');
		if(pathx==13&&pathy==11)uscito=true;

	}

	public void cieco(){
		int d;
		d=(int)(Math.random()*10);			//d=decisione, numero casuale che determinerà la direzione del nemico in base a questi criteri: 

		if((d%2)==0){						//se pari si muoverà su asse x
			d=(int)(Math.random()*10);		//ricalcolo
			if((d%2)==0)					//se di nuovo pari andrà a destra
				if(Map.maze[pathx+1][pathy]!=1)
					Trans('d');}

			else						//se è dispari andrà a sinistra
				if(Map.maze[pathx-1][pathy]!=1)
					Trans('a');
		else{								//se dispari si muoverà su asse y
			d=(int)(Math.random()*10);		//ricalcolo
			if((d%2)==0){					//se pari andrà in su
				if(Map.maze[pathx][pathy-1]!=1)
					Trans('w');
			}

			else{							//se dispari andra in giù
				if(Map.maze[pathx][pathy+1]!=1)
					Trans('s');
			}
		}								
	}

	public boolean radar(){
		int r;
		r=15;			//range

		//Se rientra nel raggio
		if(Math.abs(pathx-Main.pg.pathx)<(r/2)&&Math.abs(pathy-Main.pg.pathy)<(r/2))
			return true;
		else
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
					pathy++;}
			}
		else {
			v=vel/Frame.dX;
			if(dir=='a'){
				for(tX=0;Math.abs(tX)!=Frame.dX;tX--){
					aSprite(dir);
					try{Thread.sleep(v);}catch(Exception e){}
				}
				tX=0;
				pathx--;
				System.out.println(pathx);}
			else{
				for(tX=0;Math.abs(tX)!=Frame.dX;tX++){
					aSprite(dir);
					try{Thread.sleep(v);}catch(Exception e){}
				}
				tX=0;
				pathx++;
			}}

			


	}

	public void aSprite(char dir){
		//e=eatable Mangiabile		q=Quasi Mangiabile
		switch(dir){
			case 'w':{if(c){
						n=i[4];
						c=!c;
					  }else{
						n=i[5];
						c=!c;
						}}break;
			case 'a':{if(c){
						n=i[2];
						c=!c;
					  }else{
						n=i[3];
						c=!c;
						}}break;
			case 'd':{if(c){
						n=i[0];
						c=!c;
					  }else{
						n=i[1];
						c=!c;
						}}break;
			case 's':{if(c){
						n=i[6];
						c=!c;
					  }else{
						n=i[7];
						c=!c;
						}}break;
			
		}




		}
	}

	

