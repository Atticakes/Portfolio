public Mark HorizontalCheck(Mark victory) {
        int cross=0,nought=0;
        for( int r = 0; r < cells[0].length; r++) {
            for (int c = 0; c < cells[1].length; c++) {
                if (cells[r][c].getContent() == Mark.CROSS) {
                    cross++;
                }else if (cells[r][c].getContent() == Mark.NOUGHT) {
                    nought++;
                }
                if (cross == 3){
                    victory = Mark.CROSS;
                }else if (nought == 3){
                    victory = Mark.NOUGHT;
                }
                if (victory == Mark.CROSS || victory == Mark.NOUGHT){
                    r = cells[0].length+1;
                }
            }  
        }
        return victory;
    }