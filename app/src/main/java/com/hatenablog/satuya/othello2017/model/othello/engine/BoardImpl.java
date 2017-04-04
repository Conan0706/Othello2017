package com.hatenablog.satuya.othello2017.model.othello.engine;

import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;

import java.util.ArrayList;

import static com.hatenablog.satuya.othello2017.model.othello2.OthelloConstants.BOARD_SIZE;
import static com.hatenablog.satuya.othello2017.model.othello2.OthelloConstants.MAX_TURNS;

public final class BoardImpl implements Board {

    private static final int NONE = 0;
    private static final int UPPER = 1;
    private static final int UPPER_LEFT = 2;
    private static final int LEFT = 4;
    private static final int LOWER_LEFT = 8;
    private static final int LOWER = 16;
    private static final int LOWER_RIGHT = 32;
    private static final int RIGHT = 64;
    private static final int UPPER_RIGHT = 128;

    private int turns = 0;
    private int currentColor = Disc.EMPTY;

    //ボード
    private int board[][] = new int[BOARD_SIZE + 2][BOARD_SIZE + 2];

    //各方向のフラグ
    private int flags[][] = {
            { UPPER_LEFT, LEFT, LOWER_LEFT },
            { UPPER, NONE, LOWER },
            { UPPER_RIGHT, RIGHT, LOWER_RIGHT }
    };

    private int movableDir[][][] = new int[MAX_TURNS + 1][BOARD_SIZE + 2][BOARD_SIZE + 2];

    //	@SuppressWarnings( "unchecked" )
    private ArrayList<Disc>[] movablePos = new ArrayList[MAX_TURNS + 1];
    private ArrayList<ArrayList<Disc>> updateLog = new ArrayList<>();

    private ColorStorage discs = new ColorStorage();

    public BoardImpl() {

        for ( int i = 0; i <= MAX_TURNS; i++ ) {
            movablePos[i] = new ArrayList<Disc>();
        }

        init();
    }

    @Override
    public void init() {

        for ( int x = 1; x <= BOARD_SIZE; x++ ) {
            for ( int y = 1; y <= BOARD_SIZE; y++ ) {

                board[x][y] = Disc.EMPTY;
            }
        }

        for ( int y = 0; y < BOARD_SIZE + 2; y++ ) {
            board[0][y] = Disc.WALL;
            board[BOARD_SIZE + 1][y] = Disc.WALL;
        }

        for ( int x = 0; x < BOARD_SIZE + 2; x++ ) {
            board[x][0] = Disc.WALL;
            board[x][BOARD_SIZE + 1] = Disc.WALL;
        }

        board[4][4] = Disc.WHITE;
        board[5][5] = Disc.WHITE;
        board[4][5] = Disc.BLACK;
        board[5][4] = Disc.BLACK;

        discs.set( Disc.BLACK, 2 );
        discs.set( Disc.WHITE, 2 );
        discs.set( Disc.EMPTY, BOARD_SIZE * BOARD_SIZE - 4 );

        turns = 0;
        currentColor = Disc.BLACK;

        updateLog.clear();

        initMovable();
    }

    @Override
    public boolean put( Point point ) {

        if ( point.x <= 0 || point.x > BOARD_SIZE )
            return false;
        if ( point.y <= 0 || point.y > BOARD_SIZE )
            return false;
        if ( movableDir[turns][point.x][point.y] == NONE )
            return false;

        turnOver( point );

        turns++;
        currentColor = -currentColor;

        initMovable();

        return true;
    }

    @Override
    public boolean pass() {

        if ( movablePos[turns].size() != 0 )
            return false;
        if ( isGameOver() )
            return false;

        currentColor = -currentColor;

        updateLog.add( new ArrayList<Disc>() );

        initMovable();

        return true;
    }

    @Override
    public boolean undo() {

        if ( turns == 0 )
            return false;

        currentColor = -currentColor;

        ArrayList<Disc> update = updateLog.remove( updateLog.size() - 1 );

        if ( update.isEmpty() ) {
            movablePos[turns].clear();

            for ( int x = 1; x <= BOARD_SIZE; x++ ) {
                for ( int y = 1; y <= BOARD_SIZE; y++ ) {
                    movableDir[turns][x][y] = NONE;
                }
            }
        } else {
            turns++;

            Point point = update.get( 0 );
            board[point.x][point.y] = Disc.EMPTY;

            for ( int i = 1; i < update.size(); i++ ) {
                point = update.get( i );
                board[point.x][point.y] = -currentColor;
            }

            int stoneQty = update.size();
            discs.set( currentColor, discs.get( currentColor ) - stoneQty );
            discs.set( -currentColor, discs.get( -currentColor ) + ( stoneQty - 1 ) );
            discs.set( Disc.EMPTY, discs.get( Disc.EMPTY ) + 1 );
        }
        return true;
    }

    @Override
    public int countDisc( int color ) {

        return discs.get( color );
    }

    @Override
    public boolean isGameOver() {

        if ( turns == MAX_TURNS )
            return true;
        if ( movablePos[turns].size() != 0 )
            return false;

        Disc disc = new Disc();
        disc.color = -currentColor;
        for ( int x = 1; x <= BOARD_SIZE; x++ ) {
            disc.x = x;

            for ( int y = 1; y <= BOARD_SIZE; y++ ) {
                disc.y = y;

                if ( checkMobility( disc ) != NONE )
                    return false;
            }
        }

        return true;
    }

    @Override
    public ArrayList<Disc> getPuttablePos() {

        return movablePos[turns];
    }

    @Override
    public int getColor( Point point ) {

        return board[point.x][point.y];
    }

    @Override
    public int getColor( int x, int y ) {

        return board[x][y];
    }

    @Override
    public ArrayList<Disc> getUpdateDiscs() {

        if ( updateLog.isEmpty() )
            return new ArrayList<Disc>();
        else
            return updateLog.get( updateLog.size() - 1 );
    }

    @Override
    public int getCurrentColor() {

        return currentColor;
    }

    @Override
    public int getTurns() {

        return turns;
    }

    private int checkMobility( Disc disc ) {

        if ( board[disc.x][disc.y] != Disc.EMPTY )
            return NONE;

        int dir = NONE;

        for ( int i = -1; i < 2; i++ ) {
            for ( int j = -1; j < 2; j++ ) {
                dir |= checkEachDir( disc, i, j ); //ビットマスク
            }
        }

        return dir;
    }

    private int checkEachDir( Disc disc, int xDir, int yDir ) {

        int x, y;

        if ( board[disc.x + xDir][disc.y + yDir] == -disc.color ) {
            x = disc.x + xDir * 2;
            y = disc.y + yDir * 2;

            while ( board[x][y] == -disc.color ) {
                x += xDir;
                y += yDir;
            }

            if ( board[x][y] == disc.color ) {

                return getDir( xDir, yDir );
            }
        }
        return NONE;
    }

//    private void initMovable() {
//
//        Disc disc;
//        int dir;
//        movablePos[turns].clear();
//
//        for ( int y = 1; y <= BOARD_SIZE; y++ ) {
//            for ( int x = 1; x <= BOARD_SIZE; x++ ) {
//                disc = new Disc( x, y, currentColor );
//                dir = checkMobility( disc );
//
//                if ( dir != NONE ) {
//                    movablePos[turns].add( disc );
//                }
//                movableDir[turns][x][y] = dir;
//            }
//        }
//    }

    private void initMovable() { //TODO 3/21 2:02 for文中の代入する数字を訂正

        Disc disc;
        int dir;
        movablePos[turns].clear();

        for ( int y = 0; y <= BOARD_SIZE; y++ ) {
            for ( int x = 0; x <= BOARD_SIZE; x++ ) {
                disc = new Disc( x, y, currentColor );
                dir = checkMobility( disc );

                if ( dir != NONE ) {
                    movablePos[turns].add( disc );
                }
                movableDir[turns][x][y] = dir;
            }
        }
    }

    private void turnOver( Point point ) {

        ArrayList<Disc> update = new ArrayList<>();

        board[point.x][point.y] = currentColor;
        update.add( new Disc( point.x, point.y, currentColor ) );

        for ( int i = -1; i < 2; i++ ) {
            for ( int j = -1; j < 2; j++ ) {
                turnEachStone( point, i, j, update );
            }
        }

        int stoneQty = update.size();

        discs.set( currentColor, discs.get( currentColor ) + stoneQty );
        discs.set( -currentColor, discs.get( -currentColor ) - ( stoneQty - 1 ) );
        discs.set( Disc.EMPTY, discs.get( Disc.EMPTY ) - 1 );

        updateLog.add( update );
    }

    private void turnEachStone( Point point, int xDir, int yDir, ArrayList<Disc> update ) {

        int x = point.x;
        int y = point.y;
        int dir = movableDir[turns][point.x][point.y];

        if ( ( dir & getDir( xDir, yDir ) ) != NONE ) {
            while ( board[x + xDir][y + yDir] != currentColor ) {
                board[x + xDir][y + yDir] = currentColor;
                update.add( new Disc( x + xDir, y + yDir, currentColor ) );

                x += xDir;
                y += yDir;
            }
        }
    }

    private int getDir( int xDir, int yDir ) {

        return flags[xDir + 1][yDir + 1];
    }

}