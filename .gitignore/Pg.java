public class Pg{
	public int pathx,pathy;

	public Pg(int x,int y){
		pathx=x;
		pathy=y;
	}

	public void MoveDx(boolean map[][]){
		if(!map[pathx+1][pathy])
			pathx++;
	}

	public void MoveSx(boolean map[][]){
		if(!map[pathx-1][pathy])
			pathx--;
	}

	public void MoveUp(boolean map[][]){
		if(!map[pathx][pathy-1])
			pathy--;
	}

	public void MoveDw(boolean map[][]){
		if(!map[pathx][pathy+1])
			pathy++;
	}

}