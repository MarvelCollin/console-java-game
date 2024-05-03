		package game;
	
	import java.util.Random;
	
	public class Map {
		private int widthSize = 301;
		private int heightSize = 301;
		private char[][] map = new char[heightSize][widthSize];
		Random r = new Random();
		private int xRadius = 3;
		private int yRadius = 3;
	//	private int xRand, yRand;
		
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
	//				System.out.println(y + i - 3);
	//				System.out.println(x + j - 3);
					if(!isEmpty(y + i - 3, x + j - 3)) return false;
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
			int xRand = r.nextInt(heightSize);
			int yRand = r.nextInt(widthSize);
//			System.out.println(xRand + " " + yRand + " ");
			
			if(inRadiusEmpty(yRand,xRand)) {
//				System.out.print("asda");
				for(int i = 0; i < yRadius; i++) {
					for(int j = 0; j < xRadius; j++) {
						if(chanceChar(30)) {
							map[i + yRand][j + xRand] = value; 
						}
					}
				}
//				System.out.println(" Pass");
			} else {
//				System.out.println(" Fail");
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
			
			for(int i = 0; i < 10; i++) {
				generate('v');
			}
//			for(int i = 0; i < 30; i++) {
//				generate('O');
//			}
//			for(int i = 0; i < 30; i++) {
//				generate('#');
//			}
			System.out.println("Done");
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
	
	}
