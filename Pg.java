public class Pg implements Runnable{
	public int pathx,pathy;

	public Pg(int x,int y){
		pathx=x;
		pathy=y;
	}

	public void MoveDx(){
		while(!Map.maze[pathx+1][pathy]&&Main.cdir=='d'){
			pathx++;
			try{Thread.sleep(250);}catch(Exception e){}
		}
	}

	public void MoveSx(){
		while(!Map.maze[pathx-1][pathy]&&Main.cdir=='a'){
			pathx--;
			try{Thread.sleep(250);}catch(Exception e){}
		}
	}

	public void MoveUp(){
		while(!Map.maze[pathx][pathy-1]&&Main.cdir=='w'){
			pathy--;
			try{Thread.sleep(250);}catch(Exception e){}
		}
	}

	public void MoveDw(){
		while(!Map.maze[pathx][pathy+1]&&Main.cdir=='s'){
			pathy++;
			try{Thread.sleep(250);}catch(Exception e){}
		}

	}

	public void run(){
		while(true){
			switch(Main.cdir){
				case 'a':MoveSx();break;
				case 'd':MoveDx();break;
				case 's':MoveDw();break;
				case 'w':MoveUp();break;
			}
		}
	}

	

	

}