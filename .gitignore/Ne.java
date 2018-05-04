public class Ne {
	public int pathx,pathy;

	public Ne(int x,int y){
		pathx=x;
		pathy=y;
	}
	
	public void Follow(int x,int y) {
		int i=-1;
		int cyu=0;
		int cyd=0;
		int cxl=0;
		int cxr=0;
		i=Calc(i,x,y,pathx,pathy,0,0,0,0);
		System.out.println(i);		
	}

	public int Calc(int i,int x,int y,int tx,int ty,int cyu,int cyd,int cxr,int cxl){
		i++;
		
		if(tx==x&&ty==y)
			return i;

		if(tx-x>ty-y)
			{
				System.out.println(Map.maze[ty][tx]);
			if(!Map.maze[ty][tx+1]){
				System.out.println("x+1");
				Calc(i,x,y,tx+1,ty,cyu,cyd,cxr,cxl);
			}
			if(!Map.maze[ty-1][tx]&&cyu==0){
				System.out.println("y-1");
				Calc(i,x,y,tx,ty-1,cyu,cyd,cxr,cxl);
			}
			cyu=1;
			if(!Map.maze[ty+1][tx]&&cyd==0){
				System.out.println(tx+ty);
				Calc(i,x,y,tx,ty+1,cyu,cyd,cxr,cxl);
			}
			cyd=1;
			if(!Map.maze[ty][tx-1]){
				System.out.println("x-1");
				Calc(i,x,y,tx-1,ty,cyu,cyd,cxr,cxl);
			}
			}
		else{

			if(!Map.maze[ty-1][tx])
				Calc(i,x,y,tx,ty-1,cyu,cyd,cxr,cxl);
			if(!Map.maze[ty][tx+1]&&cxr==0)
				Calc(i,x,y,tx+1,ty,cyu,cyd,cxr,cxl);
			cxr=1;
			if(!Map.maze[ty][tx-1]&&cxl==0)
				Calc(i,x,y,tx-1,ty,cyu,cyd,cxr,cxl);
			cxl=1;
			if(!Map.maze[ty+1][tx])
				Calc(i,x,y,tx,ty+1,cyu,cyd,cxr,cxl);
			
		}
		return i;

	}
}
