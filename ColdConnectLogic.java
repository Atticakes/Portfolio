public Mark FourVCheck(Mark victory){
        Mark first, second, third, fourth;
        first = Mark.EMPTY;
        second = Mark.EMPTY;
        third = Mark.EMPTY;
        fourth = Mark.EMPTY;
       
        int control = 1;
        for(int c = 0; c < cells[1].length; c++){
            for(int r = 0; r < cells[0].length; r++){
                switch(control){
                    case 1:
                        switch (cells[r][c].getContent()){
                            case RED:
                                first = Mark.RED;
                                break;
                            case YELLOW:
                                first = Mark.YELLOW;
                                break;
                            case EMPTY:
                                first = Mark.EMPTY;
                                break;
                        }
                    case 2:
                        switch (cells[r][c].getContent()){
                            case RED:
                                second = Mark.RED;
                                break;
                            case YELLOW:
                                second = Mark.YELLOW;
                                break;
                            case EMPTY:
                                second = Mark.EMPTY;
                                break;
                        }
                    case 3:
                        switch (cells[r][c].getContent()){
                            case RED:
                                third = Mark.RED;
                                break;
                            case YELLOW:
                                third = Mark.YELLOW;
                                break;
                            case EMPTY:
                                third = Mark.EMPTY;
                                break;
                        }
                    case 4:
                        switch (cells[r][c].getContent()){
                            case RED:
                                fourth = Mark.RED;
                                break;
                            case YELLOW:
                                fourth = Mark.YELLOW;
                                break;
                            case EMPTY:
                                fourth = Mark.EMPTY;
                                break;
                        }
                }
                if (control == 4){
                    if(first == second && second == third && third == fourth && first != Mark.EMPTY){
                        switch (cells[r][c].getContent()){
                            case RED:
                                victory = Mark.RED;
                                break;
                            case YELLOW:
                                victory = Mark.YELLOW;
                                break;
                        }
                    }else{
                        first = second;
                        second = third;
                        third = fourth;
                        control = 3;
                    }
                }
                control ++;
                if ( r == cells[0].length){
                    first = Mark.EMPTY;
                    second = Mark.EMPTY;
                    third = Mark.EMPTY;
                    fourth = Mark.EMPTY;
                }
            }
        }
        return victory;
    }