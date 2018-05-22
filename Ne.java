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
	private char ldir;	//last direction (l'ultima rotta che ha preso il png)
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
		System.out.println("partito");
		//AZIONI PRELIMINARI
		if(nuovo){										//aggiungere nella mappa posizioni particolari "nodi/incroci" dove i nemici possono decidere di girare 
			for(;uscito!=true;){corri(esci());if(Map.segnale==4)Map.maze[13][12]=Map.maze[14][12]=1;}							
			nuovo=false;
			
			System.out.println(""+Map.segnale);	
			
			System.out.println("uscito");}				
		//corri(cieco());									//fa un ciclo di cieco per trovare la direzione in cui muoversi e andare in quella
		//SVOLGIMENTO
		for(;;){
			if(Main.gOver){
				break;
			} 

			if(Map.maze[pathx][pathy]==2||Map.maze[pathx][pathy]==3){ //SE INCONTRA UNNODO
						if(radar()){	
							corri(Follow());
							try{Thread.sleep(20);}catch(Exception e){}
						}
						else{	
							char a=cieco();
							System.out.println(a);
							corri(a);
						}
					}

			if(radar()){	
				corri(Follow());
				try{Thread.sleep(20);}catch(Exception e){}
				}
			else{	
				char a=cieco();
				corri(a);

				}

				
			
		}
	}

	public char Follow() {
		if(Map.maze[pathx+1][pathy]!=1&&pathx<Main.pg.pathx){
			return('d');

				//if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
				//	Main.gOver=true;
				//	}
				
			}
		else
			if(Map.maze[pathx-1][pathy]!=1&&pathx>Main.pg.pathx){
				return('a');

				//	if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
				//		Main.gOver=true;
				//	}
					
				}
		else
			if(Map.maze[pathx][pathy+1]!=1&&pathy<Main.pg.pathy){
				return('s');

				//if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
				//	Main.gOver=true;
				//}
				
			}
		else
			if(Map.maze[pathx][pathy-1]!=1&&pathy>Main.pg.pathy){
				return('w');

				//		if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
				//			Main.gOver=true;
				//		}
						
				}
		else{return 'o';}	
	}


	public char esci() {
		if(pathy==11){uscito=true;Map.segnale++;return 'o';}
		

		if(Map.maze[pathx][pathy]==3){
			return('w');}

		else{
			if(Map.maze[pathx][pathy-1]!=1&&pathy>11){
				return('w');}
			else
				if(Map.maze[pathx][pathy+1]!=1&&pathy<11){
					return('s');}
			else
				if(Map.maze[pathx+1][pathy]!=1&&pathx<13){
					return('d');}
			else
				if(Map.maze[pathx-1][pathy]!=1&&pathx>13){
					return('a');}
		}
		return 'o';
	}
	

	public char cieco(){							//funzione che trova una direzione da prendere per il png in maniera casuale
		int d;
		d=(int)(Math.random()*10);
		d++;					//d=decisione, numero casuale che determinerà la direzione del nemico in base a questi criteri: 
		if((d%2)==0){								//se pari si muoverà su asse x
			d=(int)(Math.random()*10);
			d++;									//ricalcolo
			if((d%2)==0){							//se di nuovo pari andrà a destra
				if(Map.maze[pathx+1][pathy]!=1)return 'd';}
			else									//se è dispari andrà a sinistra
				if(Map.maze[pathx-1][pathy]!=1)return'a';}
		else{										//se dispari si muoverà su asse y
			d=(int)(Math.random()*10);	
			d++;									//ricalcolo
			if((d%2)==0){							//se pari andrà in su
				if(Map.maze[pathx][pathy-1]!=1)return'w';
			}
			else{									//se dispari andra in giù
				if(Map.maze[pathx][pathy+1]!=1)return's';
			}
		}
		return 'o';								
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
				while(Map.maze[pathx][pathy-1]!=1){
					for(tY=0;Math.abs(tY)!=Frame.dY;tY--){
						aSprite(dir);
						try{Thread.sleep(v);}catch(Exception e){}
					}
					tY=0;
					pathy--;
					if(Map.maze[pathx][pathy]==2||Map.maze[pathx][pathy]==3)
						break;}
				
			}
				else{
					while(Map.maze[pathx][pathy+1]!=1){
						for(tY=0;Math.abs(tY)!=Frame.dY;tY++){
							aSprite(dir);
							try{Thread.sleep(v);}catch(Exception e){}
						}
						tY=0;
						pathy++;
						if(Map.maze[pathx][pathy]==2||Map.maze[pathx][pathy]==3)
							break;
					}

				}
			}
		else {
			v=vel/Frame.dX;
			if(dir=='a'){
				while(Map.maze[pathx-1][pathy]!=1){
					for(tX=0;Math.abs(tX)!=Frame.dX;tX--){
						aSprite(dir);
						try{Thread.sleep(v);}catch(Exception e){}
					}
					tX=0;
					pathx--;
					if(Map.maze[pathx][pathy]==2||Map.maze[pathx][pathy]==3)
						break;
				}
			}
			else{
				while(Map.maze[pathx+1][pathy]!=1){
					for(tX=0;Math.abs(tX)!=Frame.dX;tX++){
						aSprite(dir);
						try{Thread.sleep(v);}catch(Exception e){}
					}
					tX=0;
					pathx++;
					if(Map.maze[pathx][pathy]==2||Map.maze[pathx][pathy]==3)
						break;
				}
			}
		}
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


		public void corri(char direzione){												//Valori Direzione:
																						//w=su  d=destra  s=giù  a=sinistra
			switch(direzione){
				case 'w':{Trans('w');
						if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
							Main.gOver=true;
						}}break;

				case 'd':{Trans('d');
						if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
							Main.gOver=true;
						}}break;

				case 's':{Trans('s');
						if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
							Main.gOver=true;
						}}break;

				case 'a':{Trans('a');
						if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
							Main.gOver=true;
						}}break;
			}		
		}

	}

	

