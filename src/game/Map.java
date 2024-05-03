		package game;
	
	import java.util.Random;
	
	public class Map {
		private int widthSize = 350;
		private int heightSize = 350;
		private char[][] map = new char[heightSize][widthSize];
		Random r = new Random();
		private int xRadius = 3;
		private int yRadius = 3;
		private int xBorder = 6, yBorder = 6;
		Scene scene = new Scene();
		
		
		public Map() {
			// TODO Auto-generated constructor stub
		}
		
		public boolean isEmpty(int y, int x) {
	//			char[] target = {'#', 'v', 'V', 'O', 'X'};

	//			for(int i = 0; i < target.length; i++) {
	//				if(map[y][x] == target[i]) return false;
	//			}
			
			if(map[y][x] != ' ' && map[y][x] != '#') return false;
			
			return true;
		}
		
		private boolean inRadiusEmpty(int y, int x) {
			for(int i = (xRadius + yBorder) * -1; i < xRadius + yBorder; i++) {
				for(int j = (xRadius + xBorder) * -1; j < xRadius + xBorder; j++) {
					if(!isEmpty(y + i, x + j)) return false;
				}
			}
			
//		    for (int i = -yBorder; i <= yBorder; i++) {
//		        for (int j = -xBorder; j <= xBorder; j++) {
//		            if (i == 0 && j == 0) continue;
//		            if (!isEmpty(y + i, x + j)) return false;
//		        }
//		    }
			
			return true;
		}
		
		private boolean chanceChar(int chance) {
			int random = r.nextInt(100);
			
			if(random > chance) return true;
			
			return false;
		}
		
		private void generate(char value) {
			int xRand = r.nextInt(heightSize) ;
			int yRand = r.nextInt(widthSize);
			if(xRand < 10) xRand += r.nextInt(10); 
			if(yRand < 10) yRand += r.nextInt(10);  
			if(xRand > heightSize - 10) xRand += heightSize - 10; 
			if(yRand > widthSize - 10) yRand += widthSize - 10; 
			
			boolean bigGrass = false;
			
			if(value != 'O') {
				if(inRadiusEmpty(yRand,xRand)) {
					for(int i = 0; i < yRadius; i++) {
						for(int j = 0; j < xRadius; j++) {
							if(chanceChar(30)) {
								if(value == 'v' && !bigGrass) {
									if(chanceChar(40))
									{
										value = 'V';
										bigGrass = true;
									}
								}
								
								map[i + yRand][j + xRand] = value; 
								if(value == 'V') value = 'v';
							}
						}
					}
				}
			} else {
				if(isEmpty(yRand, xRand) && chanceChar(10)) {
					map[yRand][xRand] = 'O';
				}
			}
		}
		
		public void initMap() {
			for(int i = 0; i < heightSize; i++) {
				for(int j = 0; j < widthSize; j++) {
					if(i == heightSize - 1 || j == widthSize - 1 || i == 0 || j == 0) {
						map[i][j] = '#';
					} else {
						map[i][j] = ' ';
					}
				}
			}
			
			for(int i = 0; i < 300; i++) {
				generate('v');
				generate('O');
				generate('#');
			}
		}
		
		public void printMap() {
			for(int i = 0; i < heightSize; i++) {
				for(int j = 0; j < widthSize; j++) {
					if(i == heightSize - 1 || j == widthSize - 1 || i == 0 || j == 0) {
						System.out.print("#");
					} else {
						System.out.print(map[i][j]);
					}
				}
				System.out.println();
			}
		}
		
		public void printCamera(int y, int x) {
			int yCamera = 15;
			int xCamera = 35;
			
			for(int i = 0; i <= yCamera; i++) {
				for(int j = 0; j <= xCamera; j++) {
					if(i == yCamera / 2 && j == xCamera / 2) {
						System.out.print("X");
					} else if((j == 0 && i == 0) || (i == yCamera && j == 0) || (i == 0 && j == xCamera) || (i == yCamera && j == xCamera)) {
						System.out.print("+");
					} else if(j == xCamera || j == 0) {
						System.out.print("|");
					} else if(i == 0 || i == yCamera) {
						System.out.print("-");
					} else {
						System.out.print(map[y + i][x + j]);
					}
				}
				System.out.println();
			}
		}
		
		public void checker(int y, int x) {
			if(map[y][x] == 'v' || map[y][x] == 'V' && chanceChar(30)) {
				scene.shopMenu();
			}		
		}
		
		public int getWidthSize() {
			return widthSize;
		}
		
		public int getHeightSize() {
			return heightSize;
		}
	}
