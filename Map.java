public class Map {
	static int x=28;
	static int y=31;
	public static int maze[][]=new int[x][y];

	public Map(){
		for(int i=0;i<x;i++){
			for(int l=0;l<y;l++){
				if(i==0||l==0||i==x-1||l==y-1)
					if((i==0&&(l==10||l==11||l==12||l==14||l==16||l==17||l==18))||(i==27&&(l==10||l==11||l==12||l==14||l==16||l==17||l==18)))
						maze[i][l]=0;
					else
					maze[i][l]=1;
				else
					maze[i][l]=2;//Palline
			}
		}


		maze[1][1]=maze[26][1]=3;

		maze[0][9]=maze[1][9]=maze[2][9]=maze[3][9]=maze[4][9]=maze[5][9]=1;
		maze[5][10]=maze[5][11]=maze[5][12]=1;
		maze[22][9]=maze[23][9]=maze[24][9]=maze[25][9]=maze[26][9]=maze[27][9]=1;
		maze[22][10]=maze[22][11]=maze[22][12]=1;
		maze[1][13]=maze[2][13]=maze[3][13]=maze[4][13]=maze[5][13]=1;
		maze[22][13]=maze[23][13]=maze[24][13]=maze[25][13]=maze[26][13]=maze[27][13]=1;
		maze[1][15]=maze[2][15]=maze[3][15]=maze[4][15]=maze[5][15]=1;
		maze[5][16]=maze[5][17]=maze[5][18]=1;
		maze[22][15]=maze[23][15]=maze[24][15]=maze[25][15]=maze[26][15]=maze[27][15]=1;
		maze[22][16]=maze[22][17]=maze[22][18]=1;
		maze[1][19]=maze[2][19]=maze[3][19]=maze[4][19]=maze[5][19]=1;
		maze[22][19]=maze[23][19]=maze[24][19]=maze[25][19]=maze[26][19]=maze[27][19]=1;

		maze[13][1]=maze[13][2]=maze[13][3]=maze[13][4]=maze[14][1]=maze[14][2]=maze[14][3]=maze[14][4]=1;
		maze[2][2]=maze[3][2]=maze[4][2]=maze[5][2]=maze[7][2]=maze[8][2]=maze[9][2]=maze[10][2]=maze[11][2]=maze[16][2]=maze[17][2]=maze[18][2]=maze[19][2]=maze[20][2]=maze[22][2]=maze[23][2]=maze[24][2]=maze[25][2]=1;
		maze[2][3]=maze[3][3]=maze[4][3]=maze[5][3]=maze[7][3]=maze[8][3]=maze[9][3]=maze[10][3]=maze[11][3]=maze[16][3]=maze[17][3]=maze[18][3]=maze[19][3]=maze[20][3]=maze[22][3]=maze[23][3]=maze[24][3]=maze[25][3]=1;
		maze[2][4]=maze[3][4]=maze[4][4]=maze[5][4]=maze[7][4]=maze[8][4]=maze[9][4]=maze[10][4]=maze[11][4]=maze[16][4]=maze[17][4]=maze[18][4]=maze[19][4]=maze[20][4]=maze[22][4]=maze[23][4]=maze[24][4]=maze[25][4]=1;

		maze[2][6]=maze[3][6]=maze[4][6]=maze[5][6]=maze[7][6]=maze[8][6]=maze[10][6]=maze[11][6]=maze[12][6]=maze[13][6]=maze[14][6]=maze[15][6]=maze[16][6]=maze[17][6]=maze[19][6]=maze[20][6]=maze[22][6]=maze[23][6]=maze[24][6]=maze[25][6]=1;
		maze[2][7]=maze[3][7]=maze[4][7]=maze[5][7]=maze[7][7]=maze[8][7]=maze[10][7]=maze[11][7]=maze[12][7]=maze[13][7]=maze[14][7]=maze[15][7]=maze[16][7]=maze[17][7]=maze[19][7]=maze[20][7]=maze[22][7]=maze[23][7]=maze[24][7]=maze[25][7]=1;

		maze[7][8]=maze[8][8]=maze[13][8]=maze[14][8]=maze[19][8]=maze[20][8]=1;
		maze[7][9]=maze[8][9]=maze[9][9]=maze[10][9]=maze[11][9]=maze[13][9]=maze[14][9]=maze[16][9]=maze[17][9]=maze[18][9]=maze[19][9]=maze[20][9]=1;
		maze[7][10]=maze[8][10]=maze[9][10]=maze[10][10]=maze[11][10]=maze[13][10]=maze[14][10]=maze[16][10]=maze[17][10]=maze[18][10]=maze[19][10]=maze[20][10]=1;
		maze[7][11]=maze[8][11]=maze[19][11]=maze[20][11]=1;
		maze[7][12]=maze[8][12]=maze[10][12]=maze[11][12]=maze[12][12]=maze[15][12]=maze[16][12]=maze[17][12]=maze[19][12]=maze[20][12]=1;
		maze[7][13]=maze[8][13]=maze[10][13]=maze[17][13]=maze[19][13]=maze[20][13]=1;
		maze[10][14]=maze[17][14]=1;
		maze[10][15]=maze[17][15]=1;
		maze[10][16]=maze[11][16]=maze[12][16]=maze[13][16]=maze[14][16]=maze[15][16]=maze[16][16]=maze[17][16]=1;
		


		
		

		
	}
}
