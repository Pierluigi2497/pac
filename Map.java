import java.io.Serializable;
public class Map implements Serializable{
	public static boolean maze[][]=new boolean[11][11];

	public Map(){
		for(int i=0;i<maze.length;i++){
			for(int l=0;l<maze[0].length;l++){
				if(i==0||l==0||i==10||l==10)
					maze[i][l]=true;
				else
					maze[i][l]=false;
			}
		}

		maze[4][1]=true;
		maze[4][2]=true;
		maze[4][3]=true;
		maze[4][4]=true;
		maze[4][6]=maze[4][7]=maze[4][8]=maze[4][9]=maze[4][10]=true;
		maze[2][6]=maze[2][7]=maze[2][8]=maze[2][9]=maze[2][10]=true;
		maze[2][1]=maze[2][2]=maze[2][3]=maze[2][4]=true;
		maze[1][4]=maze[1][6]=true;
		maze[5][4]=maze[6][4]=maze[7][4]=maze[8][4]=maze[9][4]=maze[10][4]=true;
		maze[5][6]=maze[6][6]=maze[7][6]=maze[8][6]=maze[9][6]=maze[10][6]=true;
		

		System.out.println("X:  "+maze.length+"Y:   "+maze[0].length);
	}
}
