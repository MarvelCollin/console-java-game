		package game;

import helper.Helper;

public class Map implements Helper {
		private int xRadius = 3;
		private int yRadius = 3;
		private int xBorder = 6, yBorder = 6;
		private int yCamera = 15;
		private int xCamera = 35;
		
		public int getYCamera() {
			return yCamera;
		}

		public int getXCamera() {
			return xCamera;
		}
		
		public Map() {
			// TODO Auto-generated constructor stub
		}
		
		public boolean isPreMoveEmpty(int y, int x) {
			if(mapChar[y][x] == ' ') return true;
		
			return false;
		}
		
		public boolean isEmpty(int y, int x) {
	//			char[] target = {'#', 'v', 'V', 'O', 'X'};

	//			for(int i = 0; i < target.length; i++) {
	//				if(map[y][x] == target[i]) return false;
	//			}
			
			if(mapChar[y][x] != ' ') return false;
			
			return true;
		}
		
		private boolean inRadiusEmpty(int y, int x) {
			for(int i = -2; i < xRadius + yBorder; i++) {
				for(int j = -2; j < xRadius + xBorder; j++) {
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
		    int xRand = r.nextInt(heightSize - 20) + 10;
		    int yRand = r.nextInt(widthSize - 20) + 10;

		    if (value == 'O') {
		        if (isEmpty(yRand, xRand) && chanceChar(10)) {
		        	mapChar[yRand][xRand] = 'O';
		        }
		        return;
		    }

		    boolean bigGrass = false;
		    if (!inRadiusEmpty(yRand, xRand)) return;

		    for (int i = 0; i < yRadius; i++) {
		        for (int j = 0; j < xRadius; j++) {
		            if (chanceChar(30)) {
		                if (value == 'v' && !bigGrass && chanceChar(40)) {
		                    value = 'V';
		                    bigGrass = true;
		                }
		                mapChar[i + yRand][j + xRand] = value;
		                if (value == 'V') value = 'v';
		            }
		        }
		    }
		}

		public void initMap() {
			for(int i = 0; i < heightSize; i++) {
				for(int j = 0; j < widthSize; j++) {
					if(i == heightSize - 10 || j == widthSize - 10 || i == 10 || j == 10) {
						mapChar[i][j] = '#';
					} else {
						mapChar[i][j] = ' ';
					}
				}
			}
			
			for(int i = 0; i < 480; i++) {
				generate('v');
				generate('#');
			}
			
			for (int i = 0; i < 2250; i++) {
				generate('O');
			}
		}
		
		public void printMap() {
			for(int i = 0; i < heightSize; i++) {
				for(int j = 0; j < widthSize; j++) {
					if(i == heightSize - 1 || j == widthSize - 1 || i == 0 || j == 0) {
						System.out.print("#");
					} 
					else {
						System.out.print(mapChar[i][j]);
					}
				}
				System.out.println();
			}
			
			
		}
		
		public void printCamera(int y, int x) {
			for(int i = 0; i <= yCamera; i++) {
				for(int j = 0; j <= xCamera; j++) {
					if(i == yCamera / 2 && j == xCamera / 2) {
						System.out.print("X");
					} else if((j == 0 && i == 0) || (i == yCamera && j == 0) || (i == 0 && j == xCamera) || (i == yCamera && j == xCamera)) {
						System.out.print("+");
//						System.out.print(c.YELLOW + "+" + c.RESET);
					} else if(j == xCamera || j == 0) {
						System.out.print("|");
//						System.out.print(c.BRIGHT_RED + "|" + c.RESET);
					} else if(i == 0 || i == yCamera) {
						System.out.print("-");
//						System.out.print(c.BRIGHT_RED + "-" + c.RESET);
					} else {
						System.out.print(mapChar[y + i][x + j]);
					}
				}
				System.out.println();
			}
			
			currPlayer.printStats();	
		}
		
		public void checker(int y, int x) {
			if((mapChar[y][x] == 'v' || mapChar[y][x] == 'V') && chanceChar(30)) {
			battle.init(currPlayer);
			f.clr();
			battle.menuBattle();
			setValue(' ', y, x);
			
			} else if(mapChar[y][x] == 'O') {
				currPlayer.setHealth(currPlayer.getMoney() + 5);
			}
		}

		public void setValue(char v, int y, int x) {
			mapChar[y][x] = v;
		}
		
		public char getValue(int y, int x) {
			return mapChar[y][x];
		}
		
		public int getWidthSize() {
			return widthSize;
		}
		
		public int getHeightSize() {
			return heightSize;
		}
	}
