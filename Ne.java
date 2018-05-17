import java.awt.image.BufferedImage;
public class Ne implements Runnable {
	public int pathx,pathy;
	private BufferedImage[] i=new BufferedImage[13];
	public BufferedImage n;
	private int c=0;
	private boolean nuovo,uscito;
	public Ne(int x,int y,String a){
		pathx=x;
		pathy=y;
		nuovo=true;
		uscito=false;
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
		i[12]=Main.img.getSubimage(0,0,1,1);//trasparente
		n=i[0];
			
	}
	
	public void run(){
		if(nuovo){	
			System.out.println(""+uscito);										//aggiungere nella mappa posizioni particolari "nodi/incroci" dove i nemici possono decidere di girare 
			for(;!uscito;){System.out.println(""+uscito);esci();}							//consentire al pg e ai fantasmini di passare sui nodi
			nuovo=false;
			Map.segnale++;
			System.out.println("incrementa segnale");	
			if(Map.segnale==4)Map.maze[13][12]=Map.maze[14][12]=1;}

		for(;;){
			if(Main.gOver){
				break;
			}
			if(radar(pathx,pathy)){	
				Follow();
				try{Thread.sleep(300);}catch(Exception e){}}
			else{	
				cieco();
				try{Thread.sleep(300);}catch(Exception e){}}

				
			try{Thread.sleep(300);}catch(Exception e){}
		}
	}

	public void Follow() {
		if(pathx<Main.pg.pathx){
			while(Map.maze[pathx+1][pathy]!=1&&pathx<Main.pg.pathx){
				Eat();
				try{Thread.sleep(300);}catch(Exception e){}
				if(c==0){
					n=i[0];
					c=0;
				}else if(c==1){
					n=i[1];
					c=0;
				}

				else if(c==3){
					n=i[8];
					c=4;
				}
				else if(c==4){
					n=i[9];
				}
				pathx++;
				
			}}
		else
			if(pathx>Main.pg.pathx){
				while(Map.maze[pathx-1][pathy]!=1&&pathx>Main.pg.pathx){
					Eat();
					try{Thread.sleep(300);}catch(Exception e){}
					if(c==0){
					n=i[2];
					c=0;
				}else if(c==1){
					n=i[3];
					c=0;
				}

				else if(c==3){
					n=i[8];
					c=4;
				}
				else if(c==4){
					n=i[9];
				}
					pathx--;
					
				}}
		else
			if(pathy<Main.pg.pathy){
				while(Map.maze[pathx][pathy+1]!=1&&pathy<Main.pg.pathy){
					Eat();
					try{Thread.sleep(300);}catch(Exception e){}
					if(c==0){
						n=i[6];
						c=0;
					}else if(c==1){
						n=i[7];
						c=0;
					}

					else if(c==3){
					n=i[8];
					c=4;
				}
				else if(c==4){
					n=i[9];
				}
				pathy++;
				
			}}
		else
			if(pathy>Main.pg.pathy){
				while(Map.maze[pathx][pathy-1]!=1&&pathy>Main.pg.pathy){
					Eat();
					try{Thread.sleep(300);}catch(Exception e){}
						if(c==0){
							n=i[4];
							c=1;
						}else if(c==1){
							n=i[5];
							c=0;
						}

						else if(c==3){
							n=i[8];
							c=4;
						}
						else if(c==4){
							n=i[9];
						}

						
						pathy--;
						
				}}



				if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
					Main.gOver=true;
				}

		
				
	}

	public void Eat(){
		if(Main.Eat){
			this.c=3;
		}
	}


	public void esci() {
		if(pathx<13&&Map.maze[pathx+1][pathy]!=1){
			while(Map.maze[pathx+1][pathy]!=1&&pathx<13){
				pathx++;
				try{Thread.sleep(300);}catch(Exception e){}
			}}
			else
			if(pathx>13&&Map.maze[pathx-1][pathy]!=1){
				while(Map.maze[pathx-1][pathy]!=1&&pathx>13){
					pathx--;
					try{Thread.sleep(300);}catch(Exception e){}
				}}
		else
		if(pathy<11&&Map.maze[pathx][pathy+1]!=1){
			while(Map.maze[pathx][pathy+1]!=1&&pathy<11){
				pathy++;
				try{Thread.sleep(300);}catch(Exception e){}
			}}
			else
			if(pathy>11&&Map.maze[pathx][pathy-1]!=1){
				while(Map.maze[pathx][pathy-1]!=1&&pathy>11){
					pathy--;
					try{Thread.sleep(300);}catch(Exception e){}
				}}
		if(pathx==13&&pathy==11)uscito=true;

	}

	public void cieco(){
		int d;
		d=(int)(Math.random()*10);			//d=decisione, numero casuale che determinerà la direzione del nemico in base a questi criteri: 

		if((d%2)==0){						//se pari si muoverà su asse x
			d=(int)(Math.random()*10);		//ricalcolo
			if((d%2)==0){					//se di nuovo pari andrà a destra
				while(Map.maze[pathx+1][pathy]!=1){
				pathx++;
				try{Thread.sleep(300);}catch(Exception e){}}
			}

			else{							//se è dispari andrà a sinistra
				while(Map.maze[pathx-1][pathy]!=1){
					pathx--;
					try{Thread.sleep(300);}catch(Exception e){}}}
		}
		else{								//se dispari si muoverà su asse y
			d=(int)(Math.random()*10);		//ricalcolo
			if((d%2)==0){					//se pari andrà in su
				while(Map.maze[pathx][pathy-1]!=1){
					pathy--;
					try{Thread.sleep(300);}catch(Exception e){}}
			}

			else{							//se dispari andra in giù
				while(Map.maze[pathx][pathy+1]!=1){
				pathy++;
				try{Thread.sleep(300);}catch(Exception e){}}
			}
		}								
	}

	public boolean radar(int posx,int posy){
		int x,y,i,j,r;
		r=9;			//range
		i=j=0;			//indici
		x=posx-4;	
		y=posy-4;
		for(;i<r;i++,x++){
			for(;j<r;j++,y++){
				if(Main.pg.pathx==x&&Main.pg.pathy==y){
					return true;
				}
			}
		}
		return false;
	}

	
}
