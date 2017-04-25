package com.hatenablog.satuya.othello2017.model.engine;

import com.hatenablog.satuya.othello2017.model.engine.point.DiscForCalc;
import com.hatenablog.satuya.othello2017.model.engine.point.PointForCalc;

import java.util.ArrayList;

import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.BLACK;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.BOARD_SIZE;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.EMPTY;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.MAX_TURNS;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.WALL;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.WHITE;

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
    private int currentColor = EMPTY;

    //ボード
    private int board[][] = new int[BOARD_SIZE + 2][BOARD_SIZE + 2];

    //各方向のフラグ
    private int flags[][] = {
            { UPPER_LEFT, LEFT, LOWER_LEFT },
            { UPPER, NONE, LOWER },
            { UPPER_RIGHT, RIGHT, LOWER_RIGHT }
    };

    private int movableDir[][][] = new int[MAX_TURNS + 1][BOARD_SIZE + 2][BOARD_SIZE + 2];

    private ArrayList<DiscForCalc>[] movablePos = new ArrayList[MAX_TURNS + 1];
    private ArrayList<ArrayList<DiscForCalc>> updateLog = new ArrayList<>();

    private ColorStorage discs = new ColorStorage();

    public BoardImpl() {

        for ( int i = 0; i <= MAX_TURNS; i++ ) {
            movablePos[i] = new ArrayList<DiscForCalc>();
        }

        init();
    }

    @Override
    public void init() {

        for ( int x = 1; x <= BOARD_SIZE; x++ ) {
            for ( int y = 1; y <= BOARD_SIZE; y++ ) {

                board[x][y] = EMPTY;
            }
        }

        for ( int y = 0; y < BOARD_SIZE + 2; y++ ) {
            board[0][y] = WALL;
            board[BOARD_SIZE + 1][y] = WALL;
        }

        for ( int x = 0; x < BOARD_SIZE + 2; x++ ) {
            board[x][0] = WALL;
            board[x][BOARD_SIZE + 1] = WALL;
        }

        board[4][4] = WHITE;
        board[5][5] = WHITE;
        board[4][5] = BLACK;
        board[5][4] = BLACK;

        discs.set( BLACK, 2 );
        discs.set( WHITE, 2 );
        discs.set( EMPTY, BOARD_SIZE * BOARD_SIZE - 4 );

        turns = 0;
        currentColor = BLACK;

        updateLog.clear();

        initMovable();
    }

    @Override
    public boolean put( PointForCalc pointForCalc ) {

        if ( pointForCalc.x <= 0 || pointForCalc.x > BOARD_SIZE )
            return false;
        if ( pointForCalc.y <= 0 || pointForCalc.y > BOARD_SIZE )
            return false;
        if ( movableDir[turns][pointForCalc.x][pointForCalc.y] == NONE )
            return false;

        turnOver( pointForCalc );

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

        updateLog.add( new ArrayList<DiscForCalc>() );

        initMovable();

        return true;
    }

    @Override
    public boolean undo() {

        if ( turns == 0 )
            return false;

        currentColor = -currentColor;

        ArrayList<DiscForCalc> update = updateLog.remove( updateLog.size() - 1 );

        if ( update.isEmpty() ) {
            movablePos[turns].clear();

            for ( int x = 1; x <= BOARD_SIZE; x++ ) {
                for ( int y = 1; y <= BOARD_SIZE; y++ ) {
                    movableDir[turns][x][y] = NONE;
                }
            }
        } else {
            turns++;

            PointForCalc pointForCalc = update.get( 0 );
            board[pointForCalc.x][pointForCalc.y] = EMPTY;

            for ( int i = 1; i < update.size(); i++ ) {
                pointForCalc = update.get( i );
                board[pointForCalc.x][pointForCalc.y] = -currentColor;
            }

            int stoneQty = update.size();
            discs.set( currentColor, discs.get( currentColor ) - stoneQty );
            discs.set( -currentColor, discs.get( -currentColor ) + ( stoneQty - 1 ) );
            discs.set( EMPTY, discs.get( EMPTY ) + 1 );
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

        DiscForCalc discForCalc = new DiscForCalc();
        discForCalc.color = -currentColor;
        for ( int x = 1; x <= BOARD_SIZE; x++ ) {
            discForCalc.x = x;

            for ( int y = 1; y <= BOARD_SIZE; y++ ) {
                discForCalc.y = y;

                if ( checkMobility( discForCalc ) != NONE )
                    return false;
            }
        }

        return true;
    }

    @Override
    public ArrayList<DiscForCalc> getMovablePos() {

        return movablePos[turns];
    }

    @Override
    public int getColor( PointForCalc pointForCalc ) {

        return board[pointForCalc.x][pointForCalc.y];
    }

    @Override
    public int getColor( int x, int y ) {

        return board[x][y];
    }

    @Override
    public ArrayList<DiscForCalc> getUpdateDiscs() {

        if ( updateLog.isEmpty() )
            return new ArrayList<DiscForCalc>();
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

    @Override
    public ColorStorage getColorStorage() {
        return discs;
    }

    private int checkMobility( DiscForCalc discForCalc ) {

        if ( board[discForCalc.x][discForCalc.y] != EMPTY )
            return NONE;

        int dir = NONE;

        for ( int i = -1; i < 2; i++ ) {
            for ( int j = -1; j < 2; j++ ) {
                dir |= checkEachDir( discForCalc, i, j ); //ビットマスク
            }
        }

        return dir;
    }

    private int checkEachDir( DiscForCalc discForCalc, int xDir, int yDir ) {

        int x, y;

        if ( board[discForCalc.x + xDir][discForCalc.y + yDir] == -discForCalc.color ) {
            x = discForCalc.x + xDir * 2;
            y = discForCalc.y + yDir * 2;

            while ( board[x][y] == -discForCalc.color ) {
                x += xDir;
                y += yDir;
            }

            if ( board[x][y] == discForCalc.color ) {

                return getDir( xDir, yDir );
            }
        }
        return NONE;
    }

//    private void initMovable() {
//
//        DiscForCalc disc;
//        int dir;
//        movablePos[turns].clear();
//
//        for ( int y = 1; y <= BOARD_SIZE; y++ ) {
//            for ( int x = 1; x <= BOARD_SIZE; x++ ) {
//                disc = new DiscForCalc( x, y, currentColor );
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

        DiscForCalc discForCalc;
        int dir;
        movablePos[turns].clear();

        for ( int y = 0; y <= BOARD_SIZE; y++ ) {
            for ( int x = 0; x <= BOARD_SIZE; x++ ) {
                discForCalc = new DiscForCalc( x, y, currentColor );
                dir = checkMobility( discForCalc );

                if ( dir != NONE ) {
                    movablePos[turns].add( discForCalc );
                }
                movableDir[turns][x][y] = dir;
            }
        }
    }

    private void turnOver( PointForCalc pointForCalc ) {

        ArrayList<DiscForCalc> update = new ArrayList<>();

        board[pointForCalc.x][pointForCalc.y] = currentColor;
        update.add( new DiscForCalc( pointForCalc.x, pointForCalc.y, currentColor ) );

        for ( int i = -1; i < 2; i++ ) {
            for ( int j = -1; j < 2; j++ ) {
                turnEachStone( pointForCalc, i, j, update );
            }
        }

        int stoneQty = update.size();

        discs.set( currentColor, discs.get( currentColor ) + stoneQty );
        discs.set( -currentColor, discs.get( -currentColor ) - ( stoneQty - 1 ) );
        discs.set( EMPTY, discs.get( EMPTY ) - 1 );

        updateLog.add( update );
    }

    private void turnEachStone( PointForCalc pointForCalc, int xDir, int yDir, ArrayList<DiscForCalc> update ) {

        int x = pointForCalc.x;
        int y = pointForCalc.y;
        int dir = movableDir[turns][pointForCalc.x][pointForCalc.y];

        if ( ( dir & getDir( xDir, yDir ) ) != NONE ) {
            while ( board[x + xDir][y + yDir] != currentColor ) {
                board[x + xDir][y + yDir] = currentColor;
                update.add( new DiscForCalc( x + xDir, y + yDir, currentColor ) );

                x += xDir;
                y += yDir;
            }
        }
    }

    private int getDir( int xDir, int yDir ) {

        return flags[xDir + 1][yDir + 1];
    }

}