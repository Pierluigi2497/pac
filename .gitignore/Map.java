import java.io.Serializable;
public class Map implements Serializable{
	public static boolean maze[][]=new boolean[11][7];

	public Map(){
		for(int i=0;i<maze.length;i++){
			for(int l=0;l<maze[0].length;l++){
				if(i==0||l==0||i==10||l==6)
					maze[i][l]=true;
				else
					maze[i][l]=false;
			}
		}

		maze[4][1]=true;
		maze[4][2]=true;
		maze[4][3]=true;
		maze[4][4]=true;
		

		System.out.println("X:  "+maze.length+"Y:   "+maze[0].length);
	}
}
