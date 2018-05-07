public class Ne implements Runnable {
	public int pathx,pathy;

	public Ne(int x,int y){
		pathx=x;
		pathy=y;
	}
	
	public void run(){
		for(;;){
			System.out.println("S");
			Follow();
			try{Thread.sleep(300);}catch(Exception e){}
		}
	}

	public void Follow() {
		if(pathx<Main.pg.pathx){
			if(!Map.maze[pathx+1][pathy]){
				pathx++;
				return;
			}}
			else
			if(pathx>Main.pg.pathx){
				if(!Map.maze[pathx-1][pathy]){
					pathx--;
					return;
				}}

		if(pathy<Main.pg.pathy){
			if(!Map.maze[pathx][pathy+1]){
				pathy++;
				return;
			}}
			else
			if(pathy>Main.pg.pathy){
				if(!Map.maze[pathx][pathy-1]){
					pathy--;
					return;
				}}

		
				
	}

	
}
