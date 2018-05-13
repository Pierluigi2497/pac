import java.awt.image.BufferedImage;
public class Ne implements Runnable {
	public int pathx,pathy;
	private BufferedImage[] i=new BufferedImage[13];
	public BufferedImage n;
	public Ne(int x,int y,String a){
		pathx=x;
		pathy=y;
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
		for(;;){
			if(Main.gOver){
				break;
			}

			Follow();

				
			try{Thread.sleep(300);}catch(Exception e){}
		}
	}

	public void Follow() {
		Boolean c=true;
		if(pathx<Main.pg.pathx){
			while(Map.maze[pathx+1][pathy]!=1&&pathx<Main.pg.pathx){
				try{Thread.sleep(300);}catch(Exception e){}
				if(c){
					n=i[0];
					c=!c;
				}else{
					n=i[1];
					c=!c;
				}
				pathx++;
				
			}}
		else
			if(pathx>Main.pg.pathx){
				while(Map.maze[pathx-1][pathy]!=1&&pathx>Main.pg.pathx){
					try{Thread.sleep(300);}catch(Exception e){}
					if(c){
					n=i[2];
					c=!c;
				}else{
					n=i[3];
					c=!c;
				}
					pathx--;
					
				}}
		else
			if(pathy<Main.pg.pathy){
				while(Map.maze[pathx][pathy+1]!=1&&pathy<Main.pg.pathy){
					try{Thread.sleep(300);}catch(Exception e){}
					if(c){
						n=i[6];
						c=!c;
					}else{
						n=i[7];
						c=!c;
					}
				pathy++;
				
			}}
		else
			if(pathy>Main.pg.pathy){
				while(Map.maze[pathx][pathy-1]!=1&&pathy>Main.pg.pathy){
					try{Thread.sleep(300);}catch(Exception e){}
						if(c){
							n=i[4];
							c=!c;
						}else{
							n=i[5];
							c=!c;
						}
					pathy--;
					
				}}



				if(pathy==Main.pg.pathy&&pathx==Main.pg.pathx){
					Main.gOver=true;
				}

		
				
	}

	
}
