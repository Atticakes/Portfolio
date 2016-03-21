package games.board;
import java.util.*;
public class Board {
    private Cell[][] cells;
   
    //Constructor
    public Board(int rows, int columns) {
        cells = new Cell[rows][columns];
        for( int r = 0; r < cells[0].length; r++ ) {
            for (int c = 0; c < cells[1].length; c++) {
                cells[r][c] = new Cell(r,c);
            }
        }
    }
    //Mutators
    public void setCell(Mark mark, int row, int column) throws IllegalArgumentException {
        if (cells[row][column].getContent() == Mark.EMPTY)
            cells[row][column].setContent(mark);
        else throw new IllegalArgumentException("Player already there!");
    }
    //Accessors
    public Cell getCell(int row, int column) {return cells[row][column];}
    //Game Methods
    public Outcome checkMate(Outcome toast) {
        int bodies = cells[0].length * cells[1].length;
        for( int r = 0; r < cells[0].length; r++) {
            for (int c = 0; c < cells[1].length; c++) {
                if (cells[r][c].getContent() == Mark.EMPTY){
                }else if (cells[r][c].getContent() == Mark.CROSS || cells[r][c].getContent() == Mark.NOUGHT){
                    bodies--;
                }
            }
        }
        if (bodies == 0){
            toast = Outcome.TIE;
        }
        return toast;
    }
   
    public Mark randomMark(Mark mark){
        int feeble;
        Random randomno = new Random();
        if (mark == Mark.CROSS){
            feeble = randomno.nextInt(1);
            if (feeble == 0){
                mark = Mark.NOUGHT;
            }
        }
        return mark;
    }
    //TTT
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
    public Mark VerticalCheck(Mark victory) {
        int cross=0,nought=0;
        for( int c = 0; c < cells[1].length; c++) {
            for (int r = 0; r < cells[0].length; r++) {
                if (cells[r][c].getContent() == Mark.CROSS) {
                    cross++;
                }else if (cells[r][c].getContent() == Mark.NOUGHT) {
                    nought++;
                }
            }
            if (cross == 3){
                victory = Mark.CROSS;
            }else if (nought == 3){
                victory = Mark.NOUGHT;
            }
        }
        return victory;
    }
    public Mark CrossCheck(Mark victory) {
        int cross=0,nought=0;
        if(cells[0][0].getContent() == cells[1][1].getContent() && cells[0][0].getContent() == cells[2][2].getContent()) {
            if(cells[0][0].getContent() == Mark.EMPTY){
                victory = Mark.EMPTY;
            }else if(cells[0][0].getContent() == Mark.CROSS){
                victory = Mark.CROSS;
            }else if(cells[0][0].getContent() == Mark.NOUGHT){
                victory = Mark.NOUGHT;
            }
        }else if(cells[0][2].getContent() == cells[1][1].getContent() && cells[0][2].getContent() == cells[2][0].getContent()) {
            if(cells[0][2].getContent() == Mark.EMPTY){
                victory = Mark.EMPTY;
            }else if(cells[0][2].getContent() == Mark.CROSS){
                victory = Mark.CROSS;
            }else if(cells[0][2].getContent() == Mark.NOUGHT){
                victory = Mark.NOUGHT;
            }
        }
        return victory;
    }
   
    //CONNECT4
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
    public Mark FourHCheck(Mark victory) {
        Mark first, second, third, fourth;
        first = Mark.EMPTY;
        second = Mark.EMPTY;
        third = Mark.EMPTY;
        fourth = Mark.EMPTY;
       
        int control = 1;
        for(int r = 0; r < cells[0].length; r++){
            for(int c = 0; c < cells[1].length; c++){
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
                if ( c == cells[0].length){
                    first = Mark.EMPTY;
                    second = Mark.EMPTY;
                    third = Mark.EMPTY;
                    fourth = Mark.EMPTY;
                }
            }
        }
        return victory;
    }
    public Mark FourCrossCheck(Mark victory){
        Mark first, second, third, fourth;
        first = Mark.EMPTY;
        second = Mark.EMPTY;
        third = Mark.EMPTY;
        fourth = Mark.EMPTY;
       
        int control = 1;
        for (int r = cells[0].length; r < cells[0].length; r--){
            for (int c = cells[1].length; c < cells[1].length; c--){
                if (r == 5 && c == 6){
                    c = 3;
                }else if (r == 2 && c == 6){
                    r = 5;
                    c = 2;
                }else if (r == 1 && c == 6){
                    r = 5;
                    c = 1;
                }else if (r == 0 && c == 6){
                    r = 5;
                    c = 0;
                }else if ( r == 0 && c == 5){
                    r = 4;
                    c = 0;
                }else if (r == 0 && c == 4){
                    r = 3;
                    c = 0;
                }
                if (r == 0 && c == 3){
                    switch (cells[r][c].getContent()){
                        case RED:
                            switch (control){
                                case 1:
                                    first = Mark.RED;
                                    break;
                                case 2:
                                    second = Mark.RED;
                                    break;
                                case 3:
                                    third = Mark.RED;
                                    break;
                                case 4:
                                    fourth = Mark.RED;
                                    break;
                            }
                            break;
                        case YELLOW:
                            switch (control){
                                case 1:
                                    first = Mark.YELLOW;
                                    break;
                                case 2:
                                    second = Mark.YELLOW;
                                    break;
                                case 3:
                                    third = Mark.YELLOW;
                                    break;
                                case 4:
                                    fourth = Mark.YELLOW;
                                    break;
                            }
                            break;
                    }
                    r = 6;
                    c = 7;
                } else {
                    switch (cells[r][c].getContent()){
                        case RED:
                            switch (control){
                                case 1:
                                    first = Mark.RED;
                                    break;
                                case 2:
                                    second = Mark.RED;
                                    break;
                                case 3:
                                    third = Mark.RED;
                                    break;
                                case 4:
                                    fourth = Mark.RED;
                                    break;
                            }
                            break;
                        case YELLOW:
                            switch (control){
                                case 1:
                                    first = Mark.YELLOW;
                                    break;
                                case 2:
                                    second = Mark.YELLOW;
                                    break;
                                case 3:
                                    third = Mark.YELLOW;
                                    break;
                                case 4:
                                    fourth = Mark.YELLOW;
                                    break;
                            }
                            break;
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
                    r--;
                    c = c + 2;
                }
            }
        }
        return victory;
    }
   
   
    //DISPLAY BOARD METHOD
    public String toString() {
        StringBuilder str = new StringBuilder();
       
        for( int r = 0; r < cells.length; r++ ) {
            str.append("|");
            for (int c = 0; c < cells[r].length; c++) {
                switch(cells[r][c].getContent()) {
                    case NOUGHT:
                        str.append("O");
                        break;
                    case CROSS:
                        str.append("X");
                        break;
                    case YELLOW:
                        str.append("Y");
                        break;
                    case RED:
                        str.append("R");
                        break;
                    case BLUE:
                        str.append("B");
                        break;
                    case GREEN:
                        str.append("G");
                        break;
                    case MAGENTA:
                        str.append("M");
                        break;
                    case ORANGE:
                        str.append("M");
                        break;
                    default:     //EMPTY
                        str.append(" ");
                }
                str.append("|");
            }
            str.append("\n");
        }
        return str.toString();
    }
}