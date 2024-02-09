package com.gabiscode;


/**
 *
 * @author gabri
 */


/**
 *
 * @author gabri
 */
public class SField {
    int[][] field = {
        {0,8,0,0,0,7,6,0,0},
        {0,0,1,6,5,0,0,0,2},
        {5,0,0,0,0,3,0,0,0},
        {4,0,0,5,2,0,8,0,0},
        {0,0,7,0,0,0,0,4,0},
        {0,0,0,0,3,0,0,0,0},
        {0,0,0,0,0,6,0,0,0},
        {0,9,0,0,0,0,0,0,1},
        {7,0,0,8,4,0,2,0,0}
    };



    public int[][] getField() {
		return this.field;
	}

    public void setField(int[][] field) {
		this.field = field;
	}

    public void setFieldSpec(int x, int y, int inp){
        field[x][y] = inp;
    }

    public boolean checkSquare(int x, int y, int number) {
        int startx = x - (x % 3);
        int starty = y - (y % 3);

        for (int i = startx; i < startx + 3; i++) {
            for (int j = starty; j < starty + 3; j++) {
                if (field[i][j] == number) {
                    return true;
                }
            }
        }
    
        return false;
    }

    public boolean checkRow(int y, int number){//checks if number is in the row
        for(int i = 0;i<field[0].length;i++){
            if(field[i][y]==number){
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn(int x, int number){//checks if number is in the column
        for(int i = 0;i<field[x].length;i++){
            if(field[x][i]==number){
                return true;
            }
        }
        return false;
    }
    public boolean isPossible(int x,int y,int number){//checks whether a number is allowed to be placed or not
        if(checkSquare(x, y, number)==false
            &&checkRow(y, number)==false
            &&checkColumn(x, number)==false){
                return true;
        }
        return false;
    }
    public boolean check(){//checks if solved
        for (int[] row : field) {
            for (int num : row) {
                if (num == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solveField(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isPossible(i, j, num)) {
                            field[i][j] = num;
                            if (solveField()) {
                                return true;
                            }
                            field[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public void printField(){
        for (int j = 0; j < field[0].length; j++) {
            for (int i = 0; i < field.length; i++) {
                System.out.print(field[j][i] + " ");
            }
            System.out.println("");
        }
    }
}
