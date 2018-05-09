public class Ne implements Runnable {
	public int pathx,pathy;

	public Ne(int x,int y){
		pathx=x;
		pathy=y;
	}
	
	public void run(){
		for(;;){
			Follow();
			try{Thread.sleep(300);}catch(Exception e){}
		}
	}

	public void Follow() {
		if(pathx<Main.pg.pathx&&Map.maze[pathx+1][pathy]==0){
			while(Map.maze[pathx+1][pathy]==0&&pathx<Main.pg.pathx){
				pathx++;
				try{Thread.sleep(300);}catch(Exception e){}
			}}
			else
			if(pathx>Main.pg.pathx&&Map.maze[pathx-1][pathy]==0){
				while(Map.maze[pathx-1][pathy]==0&&pathx>Main.pg.pathx){
					pathx--;
					try{Thread.sleep(300);}catch(Exception e){}
				}}
		else
		if(pathy<Main.pg.pathy&&Map.maze[pathx][pathy+1]==0){
			while(Map.maze[pathx][pathy+1]==0&&pathy<Main.pg.pathy){
				pathy++;
				try{Thread.sleep(300);}catch(Exception e){}
			}}
			else
			if(pathy>Main.pg.pathy&&Map.maze[pathx][pathy-1]==0){
				while(Map.maze[pathx][pathy-1]==0&&pathy>Main.pg.pathy){
					pathy--;
					try{Thread.sleep(300);}catch(Exception e){}
				}}

		
				
	}

	
}
