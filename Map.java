public class Map {
	static int segnale=0;
	static int x=28;
	static int y=31;
	//0-Vuoto  1-Muro  2-IncrocioVisibile  3-IncrocioInvisibile  4-Palline  5-Palla
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
					maze[i][l]=4;//Palline
			}
		}



		//POSIZIONAMENTO INCROCI
		maze[6][1]=maze[21][1]=2;
		maze[1][5]=maze[6][5]=maze[9][5]=maze[12][5]=maze[15][5]=maze[18][5]=maze[21][5]=maze[26][5]=2;
		maze[6][8]=maze[21][8]=2;
		maze[12][11]=maze[15][11]=2;
		maze[13][13]=maze[14][13]=3;

		maze[6][14]=maze[21][14]=maze[9][14]=maze[18][14]=2;
		maze[9][17]=maze[18][17]=2;
		maze[6][20]=maze[9][20]=maze[18][20]=maze[21][20]=2;
		maze[6][23]=maze[9][23]=maze[12][23]=maze[15][23]=maze[18][23]=maze[21][23]=2;
		maze[3][26]=maze[24][26]=2;
		maze[12][29]=maze[15][29]=2;

		maze[1][1]=maze[26][1]=5;				//pallagrossa

		

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
		
		maze[7][15]=maze[8][15]=maze[7][16]=maze[8][16]=maze[7][17]=maze[8][17]=maze[7][18]=maze[8][18]=maze[7][19]=maze[8][19]=1;

		maze[19][15]=maze[20][15]=maze[19][16]=maze[20][16]=maze[19][17]=maze[20][17]=maze[19][18]=maze[20][18]=maze[19][19]=maze[20][19]=1;

		maze[10][18]=maze[11][18]=maze[12][18]=maze[13][18]=maze[14][18]=maze[15][18]=maze[16][18]=maze[17][18]=1;
		maze[10][19]=maze[11][19]=maze[12][19]=maze[13][19]=maze[14][19]=maze[15][19]=maze[16][19]=maze[17][19]=1;
		maze[13][20]=maze[14][20]=maze[13][21]=maze[14][21]=maze[13][22]=maze[14][22]=1;

		maze[2][21]=maze[3][21]=maze[4][21]=maze[5][21]=maze[2][22]=maze[3][22]=maze[4][22]=maze[5][22]=1;
		maze[4][23]=maze[5][23]=maze[4][24]=maze[5][24]=maze[4][25]=maze[5][25]=1;

		maze[7][21]=maze[8][21]=maze[9][21]=maze[10][21]=maze[11][21]=maze[7][22]=maze[8][22]=maze[9][22]=maze[10][22]=maze[11][22]=1;

		maze[16][21]=maze[17][21]=maze[18][21]=maze[19][21]=maze[20][21]=maze[16][22]=maze[17][22]=maze[18][22]=maze[19][22]=maze[20][22]=1;

		maze[22][21]=maze[23][21]=maze[24][21]=maze[25][21]=maze[22][22]=maze[23][22]=maze[24][22]=maze[25][22]=1;
		maze[22][23]=maze[23][23]=maze[22][24]=maze[23][24]=maze[22][25]=maze[23][25]=1;

		maze[7][24]=maze[8][24]=maze[7][25]=maze[8][25]=maze[7][26]=maze[8][26]=1;
		maze[2][27]=maze[3][27]=maze[4][27]=maze[5][27]=maze[6][27]=maze[7][27]=maze[8][27]=maze[9][27]=maze[10][27]=maze[11][27]=1;
		maze[2][28]=maze[3][28]=maze[4][28]=maze[5][28]=maze[6][28]=maze[7][28]=maze[8][28]=maze[9][28]=maze[10][28]=maze[11][28]=1;
		
		maze[1][24]=maze[2][24]=maze[1][25]=maze[2][25]=1;

		maze[10][24]=maze[11][24]=maze[12][24]=maze[13][24]=maze[14][24]=maze[15][24]=maze[16][24]=maze[17][24]=1;
		maze[10][25]=maze[11][25]=maze[12][25]=maze[13][25]=maze[14][25]=maze[15][25]=maze[16][25]=maze[17][25]=1;
		maze[13][26]=maze[14][26]=maze[13][27]=maze[14][27]=maze[13][28]=maze[14][28]=1;

		maze[19][24]=maze[20][24]=maze[19][25]=maze[20][25]=maze[19][26]=maze[20][26]=1;
		maze[16][27]=maze[17][27]=maze[18][27]=maze[19][27]=maze[20][27]=maze[21][27]=maze[22][27]=maze[23][27]=maze[24][27]=maze[25][27]=1;
		maze[16][28]=maze[17][28]=maze[18][28]=maze[19][28]=maze[20][28]=maze[21][28]=maze[22][28]=maze[23][28]=maze[24][28]=maze[25][28]=1;

		maze[25][24]=maze[26][24]=maze[25][25]=maze[26][25]=1;


		maze[11][15]=maze[12][15]=maze[13][15]=maze[14][15]=maze[15][15]=maze[16][15]=0;
		maze[11][14]=maze[12][14]=maze[13][14]=maze[14][14]=maze[15][14]=maze[16][14]=0;
		maze[11][13]=maze[12][13]=maze[15][13]=maze[16][13]=0;
		maze[13][12]=maze[14][12]=0;
		
		maze[0][10]=maze[1][10]=maze[2][10]=maze[3][10]=maze[4][10]=maze[23][10]=maze[24][10]=maze[25][10]=maze[26][10]=maze[27][10]=0;
		maze[0][11]=maze[1][11]=maze[2][11]=maze[3][11]=maze[4][11]=maze[23][11]=maze[24][11]=maze[25][11]=maze[26][11]=maze[27][11]=0;
		maze[0][12]=maze[1][12]=maze[2][12]=maze[3][12]=maze[4][12]=maze[23][12]=maze[24][12]=maze[25][12]=maze[26][12]=maze[27][12]=0;

		maze[0][16]=maze[1][16]=maze[2][16]=maze[3][16]=maze[4][16]=maze[23][16]=maze[24][16]=maze[25][16]=maze[26][16]=maze[27][16]=0;		
		maze[0][17]=maze[1][17]=maze[2][17]=maze[3][17]=maze[4][17]=maze[23][17]=maze[24][17]=maze[25][17]=maze[26][17]=maze[27][17]=0;
		maze[0][18]=maze[1][18]=maze[2][18]=maze[3][18]=maze[4][18]=maze[23][18]=maze[24][18]=maze[25][18]=maze[26][18]=maze[27][18]=0;
		
	}
}
