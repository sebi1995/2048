import java.util.Random;

public class Board {

    public Piece[][] board;
    public int score;
    private int size = 4;

    Board() {
        score = 0;
        initBoard();
        board[0][3] = new Piece();
        board[0][2] = new Piece();
        board[0][1] = new Piece();
    }

    private void initBoard() {
        board = new Piece[size][size];
        board[new Random().nextInt(size)][new Random().nextInt(size)] = new Piece();
    }

    public String getBoard() {
        StringBuilder sb = new StringBuilder();

        Integer longest = 0;

        for (int y = 0; y < size; ++y) {
            for (int x = 0; x < size; ++x) {
                if (board[y][x] != null) {
                    String placeHolder = board[y][x].getNumber() + "";
                    longest = (placeHolder.length() > longest) ? placeHolder.length() : longest;
                }
            }
        }

        for (int y = 0; y < size; ++y) {
            for (int x = 0; x < size; ++x) {
                if (board[y][x] != null) {
                    String placeHolder = board[y][x].getNumber() + "";
                    sb.append(placeHolder);
                    for (int i = placeHolder.length(); i < longest; ++i) {
                        sb.append("_");
                    }
                    sb.append(" ");
                } else {
                    for (int i = 0; i < longest; ++i) {
                        sb.append("_");
                    }
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void move(String direction) {

        boolean wasMoveMade = false;

        switch (direction) {
            case "u":
                wasMoveMade = canMoveUp(true);
                break;
            case "r":
                wasMoveMade = canMoveRight(true);
                break;
            case "d":
                wasMoveMade = canMoveDown(true);
                break;
            case "l":
                wasMoveMade = canMoveLeft(true);
                break;
            default:
                System.out.println("Wrong input");
                break;
        }

        //this part adds a new piece to board
        if (wasMoveMade) {
            while (true) {
                int y = new Random().nextInt(size);
                int x = new Random().nextInt(size);
                if (board[y][x] == null) {
                    board[y][x] = new Piece();
                    break;
                }
            }
        }
    }

    private boolean canMoveUp(boolean move) {

        boolean returnBool = false;

        for (int y = 1; y < size; ++y) {
            for (int x = 0; x < size; ++x) {
                if (board[y][x] != null) {
                    for (int i = y - 1; i >= 0; --i) {
                        if (i == 0 || board[i][x] != null) {
                            if (board[i][x] == null) {
                                if (move) {
                                    board[i][x] = board[y][x];
                                    board[y][x] = null;
                                }
                                returnBool = true;
                                break;
                            } else {
                                if (board[i][x].getNumber() == board[y][x].getNumber()) {
                                    if (move) {
                                        board[i][x].setNumber(board[i][x].getNumber() * 2);
                                        board[y][x] = null;
                                    }
                                    returnBool = true;
                                    break;
                                } else {
                                    if (i + 1 != y) {
                                        if (move) {
                                            board[i + 1][x] = board[y][x];
                                            board[y][x] = null;
                                        }
                                        returnBool = true;
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnBool;
    }
    private boolean canMoveRight(boolean move) {

        boolean returnBool = false;

        for (int x = size-2; x >= 0; --x) {
            for (int y = 0; y < size; ++y) {
                if (board[y][x] != null) {
                    for (int i = x + 1; i <size; ++i) {
                        if (i == size-1 || board[y][i] != null) {
                            if (board[y][i] == null) {
                                if (move) {
                                    board[y][i] = board[y][x];
                                    board[y][x] = null;
                                }
                                returnBool = true;
                                break;
                            } else {
                                if (board[y][i].getNumber() == board[y][x].getNumber()) {
                                    if (move) {
                                        board[y][i].setNumber(board[y][i].getNumber() * 2);
                                        board[y][x] = null;
                                    }
                                    returnBool = true;
                                    break;
                                } else {
                                    if (i - 1 != x) {
                                        if (move) {
                                            board[y][i - 1] = board[y][x];
                                            board[y][x] = null;
                                        }
                                        returnBool = true;
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnBool;
    }
    private boolean canMoveDown(boolean move) {

        boolean returnBool = false;

        for (int y = size-2; y >= 0; --y) {
            for (int x = 0; x < size; ++x) {
                if (board[y][x] != null) {
                    for (int i = y + 1; i <size; ++i) {
                        if (i == size-1 || board[i][x] != null) {
                            if (board[i][x] == null) {
                                if (move) {
                                    board[i][x] = board[y][x];
                                    board[y][x] = null;
                                }
                                returnBool = true;
                                break;
                            } else {
                                if (board[i][x].getNumber() == board[y][x].getNumber()) {
                                    if (move) {
                                        board[i][x].setNumber(board[i][x].getNumber() * 2);
                                        board[y][x] = null;
                                    }
                                    returnBool = true;
                                    break;
                                } else {
                                    if (i - 1 != y) {
                                        if (move) {
                                            board[i - 1][x] = board[y][x];
                                            board[y][x] = null;
                                        }
                                        returnBool = true;
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnBool;
    }
    private boolean canMoveLeft(boolean move) {

        boolean returnBool = false;

        for (int x = 1; x < size; ++x) {
            for (int y = 0; y < size; ++y) {
                if (board[y][x] != null) {
                    for (int i = x - 1; i >= 0; --i) {
                        if (board[y][i] != null || i == 0) {
                            if (board[y][i] == null) {
                                if (move) {
                                    board[y][i] = board[y][x];
                                    board[y][x] = null;
                                }
                                returnBool = true;
                                break;
                            } else {
                                if (board[y][i].getNumber() == board[y][x].getNumber()) {
                                    if (move) {
                                        board[y][i].setNumber(board[y][i].getNumber() * 2);
                                        board[y][x] = null;
                                    }
                                    returnBool = true;
                                    break;
                                } else {
                                    if (i + 1 != x) {
                                        if (move) {
                                            board[y][i + 1] = board[y][x];
                                            board[y][x] = null;
                                        }
                                        returnBool = true;
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnBool;
    }

    public boolean gameIsNotOver() {
        if (!canMoveUp(false) && !canMoveRight(false) && !canMoveDown(false) && !canMoveLeft(false)){
            return false;
        } else return true;
    }

    public int getScore() {
        Integer score = 0;

        for (int y = 0; y <size; ++y) {
            for (int x = 0; x <size; ++x) {
                score += board[y][x].getNumber();
            }
        }

        return score;
    }
}
