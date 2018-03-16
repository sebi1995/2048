import java.util.Random;

public class Board {

    public Piece[][] board;
    public int score;

    Board() {
        score = 0;
        initBoard();
//        board[0][4] = new Piece();
//        board[0][3] = new Piece();
//        board[0][2] = new Piece();
//        board[0][1] = new Piece();
    }

    private void initBoard() {
        board = new Piece[6][6];
        board[new Random().nextInt(6)][new Random().nextInt(6)] = new Piece();
    }

    public void printBoard() {
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getNumber() + " ");
                } else System.out.print("_ ");
            }
            System.out.println();
        }
    }

    public void move(String direction) {

        int YY, XX;
        boolean wasMoveMade = false;

        switch (direction) {
            case "l":
                for (int x = 1; x < 6; ++x) {
                    for (int y = 0; y < 6; ++y) {
                        if (board[y][x] != null) {
                            for (int X = x - 1; X >= 0; --X) {
                                if (X == 0 || board[y][X] != null) {
                                    if (board[y][X] == null) {
                                        board[y][X] = board[y][x];
                                        board[y][x] = null;
                                        wasMoveMade = true;
                                        break;
                                    } else {
                                        if (board[y][X].getNumber() == board[y][x].getNumber()) {
                                            board[y][X].setNumber(board[y][X].getNumber() * 2);
                                            board[y][x] = null;
                                            wasMoveMade = true;
                                            break;
                                        } else {
                                            if (X + 1 != x) {
                                                board[y][X + 1] = board[y][x];
                                                board[y][x] = null;
                                            }
                                            wasMoveMade = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "u":
                for (int y = 1; y <= 5; ++y) {
                    for (int x = 0; x <= 5; ++x) {
                        if (board[y][x] != null) {
                            for (int Y = y - 1; Y >= 0; --Y) {
                                if (Y == 0 || board[Y][x] != null) {
                                    if (board[Y][x] == null) {
                                        board[Y][x] = board[y][x];
                                        board[y][x] = null;
                                        wasMoveMade = true;
                                        break;
                                    } else {
                                        if (board[Y][x].getNumber() == board[y][x].getNumber()) {
                                            board[Y][x].setNumber(board[Y][x].getNumber() * 2);
                                            board[y][x] = null;
                                            wasMoveMade = true;
                                            break;
                                        } else {
                                            if (Y + 1 != y) {
                                                board[Y + 1][x] = board[y][x];
                                                board[y][x] = null;
                                            }
                                            wasMoveMade = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "r":
                for (int x = 4; x >= 0; --x) {
                    for (int y = 0; y < 6; ++y) {
                        if (board[y][x] != null) {
                            for (int X = x + 1; X <= 5; ++X) {
                                if (X == 5 || board[y][X] != null) {
                                    if (board[y][X] == null) {
                                        board[y][X] = board[y][x];
                                        board[y][x] = null;
                                        wasMoveMade = true;
                                        break;
                                    } else {
                                        if (board[y][X].getNumber() == board[y][x].getNumber()) {
                                            board[y][X].setNumber(board[y][X].getNumber() * 2);
                                            board[y][x] = null;
                                            wasMoveMade = true;
                                            break;
                                        } else {
                                            if (X - 1 != y) {
                                                board[y][X - 1] = board[y][x];
                                                board[y][x] = null;
                                            }
                                            wasMoveMade = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "d":
                for (int y = 4; y >= 0; --y) {
                    for (int x = 0; x < 6; ++x) {
                        if (board[y][x] != null) {
                            for (int Y = y + 1; Y <= 5; ++Y) {
                                if (Y == 5 || board[Y][x] != null) {
                                    if (board[Y][x] == null) {
                                        board[Y][x] = board[y][x];
                                        board[y][x] = null;
                                        wasMoveMade = true;
                                        break;
                                    } else {
                                        if (board[Y][x].getNumber() == board[y][x].getNumber()) {
                                            board[Y][x].setNumber(board[Y][x].getNumber() * 2);
                                            board[y][x] = null;
                                            wasMoveMade = true;
                                            break;
                                        } else {
                                            if (Y - 1 != y) {
                                                board[Y - 1][x] = board[y][x];
                                                board[y][x] = null;
                                            }
                                            wasMoveMade = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Wrong input");
                break;
        }


        //this part adds a new piece to board
        if (wasMoveMade) {
            while (true) {
                YY = new Random().nextInt(6);
                XX = new Random().nextInt(6);
                if (board[YY][XX] == null) {
                    board[YY][XX] = new Piece();
                    break;
                }
            }
        }
    }
}
