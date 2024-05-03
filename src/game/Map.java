		package game;
	
	import java.util.Random;
	
	public class Map {
		private int widthSize = 350;
		private int heightSize = 350;
		private char[][] map = new char[heightSize][widthSize];
		Random r = new Random();
		private int xRadius = 3;
		private int yRadius = 3;
		
		public Map() {
			// TODO Auto-generated constructor stub
		}
		
		private boolean isEmpty(int y, int x) {
	//			char[] target = {'#', 'v', 'V', 'O', 'X'};
	//			
	//			for(int i = 0; i < target.length; i++) {
	//				if(map[y][x] == target[i]) return false;
	//			}
			
			if(map[y][x] != ' ' && map[y][x] != '#') return false;
			
			return true;
		}
		
		private boolean inRadiusEmpty(int y, int x) {
			for(int i = 0; i < yRadius; i++) {
				for(int j = 0; j < xRadius; j++) {
					if(!isEmpty(y + i, x + j)) return false;
				}
			}
			
			return true;
		}
		
		private boolean chanceChar(int chance) {
			int random = r.nextInt(100);
			
			if(random > chance) return true;
			
			return false;
		}
		
		private void generate(char value) {
			int xRand = r.nextInt(heightSize - 8) + 1 ;
			int yRand = r.nextInt(widthSize - 8) + 1;
			
			if(inRadiusEmpty(yRand,xRand)) {
				for(int i = 0; i < yRadius; i++) {
					for(int j = 0; j < xRadius; j++) {
						if(chanceChar(30)) {
							map[i + yRand][j + xRand] = value; 
						}
					}
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
			
			for(int i = 0; i < 30; i++) {
				generate('v');
				generate('O');
				generate('X');
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
					if(i == 0 || i == yCamera || j == 0 || j == xCamera) {
						System.out.print("#");
					} else {
						System.out.print(map[y + i][x + j]);
					}
				}
				System.out.println();
			}
		}
	}
