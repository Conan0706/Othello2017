package com.hatenablog.satuya.othello2017.domain.othello;

import com.hatenablog.satuya.othello2017.domain.othello.engine.Board;
import com.hatenablog.satuya.othello2017.domain.othello.entity.Color;
import com.hatenablog.satuya.othello2017.domain.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.domain.othello.entity.Point;
import com.hatenablog.satuya.othello2017.domain.othello.event.FinishEvent;
import com.hatenablog.satuya.othello2017.domain.othello.event.FinishEventImpl;
import com.hatenablog.satuya.othello2017.domain.othello.event.PassEvent;
import com.hatenablog.satuya.othello2017.domain.othello.event.PassEventImpl;
import com.hatenablog.satuya.othello2017.domain.othello.event.PutEventImpl;
import com.hatenablog.satuya.othello2017.domain.othello.event.TryWrongPosPutEvent;
import com.hatenablog.satuya.othello2017.domain.othello.event.TryWrongPosPutEventImpl;
import com.hatenablog.satuya.othello2017.domain.othello.observer.BoardObserver;
import com.hatenablog.satuya.othello2017.domain.othello.player.PlayerGroup;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import static com.hatenablog.satuya.othello2017.domain.othello.OthelloUtility.convertColorCodeToColor;

/**
 * Created by Shusei on 2017/03/15.
 */

public class BoardManagerImpl implements BoardManager {

//    public static final int PLAYER_NUMBER = 2;

    public static final int DUMMY_SCORE = 50; //ダミーのスコア

    private ArrayList<BoardObserver> observers = null;

//    private BoardFactory boardFactory = null; //TODO null 3/20 23:57 ファクトリは使わずDIで統一する方針

    private PlayerGroup playerGroup = null; //TODO null

    private Board board = null; //TODO null

    private int currentColorCode = Integer.MIN_VALUE; //MIN_VALUEに意味はない

    @Inject
    public BoardManagerImpl( Board board, PlayerGroup group ) {

        this.observers = new ArrayList<>();
//        this.board = this.boardFactory.getBoard();
        this.board = board;
        this.playerGroup = group;
        playerGroup.setManager( this );
        initBoard();
    }

    @Override
    public void initBoard() {
        this.board.init();
        this.currentColorCode = this.board.getCurrentColor();
        turnChange( this.currentColorCode );
    }

    @Override
    public void addObserver( BoardObserver observer ) {
        this.observers.add( observer );
    }

    @Override
    synchronized public boolean put( Point point ) { //TODO 排他制御確認

        boolean canPut = board.put( point );

        if ( !canPut ) {
            onTryWrongPosPut( point );
            return false;
        } else {
            onPut(); //本処理 returnしていないのは正常
        }

        if ( board.isGameOver() ) {
            onFinished();
            return true;
        }

        if ( board.pass() ) {
            this.currentColorCode = board.getCurrentColor();
            onPassed();
        }

        this.currentColorCode = board.getCurrentColor();

        new Thread( new Runnable() {
            @Override
            public void run() {
                turnChange( BoardManagerImpl.this.currentColorCode );
            }
        } ).start();

        return true;
    }

    synchronized public boolean undo() { //TODO 未実装

        boolean canPut = board.undo();

        if ( canPut ) {
            return false;
        }

        return true;
    }

    @Override
    public Board getBoard() { //TODO 削除する

        return this.board;
    }

    private void onTryWrongPosPut( Point point ) {

        TryWrongPosPutEvent event =
                new TryWrongPosPutEventImpl( point, convertColorCodeToColor( currentColorCode ) );

        Iterator<BoardObserver> iterator = observers.iterator();
        while ( iterator.hasNext() ) {
            BoardObserver observer = iterator.next();
            observer.onTryWrongPosPut( event );
        }
    }

    private void onFinished() {

        int blackNumber = this.board.countDisc( Disc.BLACK );
        int whiteNumber = this.board.countDisc( Disc.WHITE );

        Color winnerColor = null;
        Color loserColor = null;
        if ( blackNumber == whiteNumber ) {
            winnerColor = Color.UNKNOWN;
            loserColor = Color.UNKNOWN;
        } else if ( blackNumber > whiteNumber ) {
            winnerColor = Color.BLACK;
            loserColor = Color.WHITE;
        } else if ( blackNumber < whiteNumber ) {
            winnerColor = Color.WHITE;
            loserColor = Color.BLACK;
        }

        FinishEvent event = new FinishEventImpl( winnerColor, loserColor, DUMMY_SCORE );

        Iterator<BoardObserver> iterator = observers.iterator();
        while ( iterator.hasNext() ) {
            BoardObserver observer = iterator.next();
            observer.onFinished( event );
        }
    }

    private void onPassed() {

        PassEvent event = new PassEventImpl( convertColorCodeToColor( -currentColorCode ) );

        Iterator<BoardObserver> iterator = observers.iterator();
        while ( iterator.hasNext() ) {
            BoardObserver observer = iterator.next();
            observer.onPassed( event );
        }
    }

    private void onPut() {

        PutEventImpl event = new PutEventImpl( convertColorCodeToColor( this.currentColorCode ),
                this.board.getUpdateDiscs(), this.board.countDisc( Disc.BLACK ), this.board.countDisc( Disc.WHITE ) );
        //冗長すぎる

        Iterator<BoardObserver> iterator = observers.iterator();
        while ( iterator.hasNext() ) {
            BoardObserver observer = iterator.next();
            observer.onPut( event );
        }
    }

//    private Color convertColorCodeToColor( int color ) {
//
//        switch ( color ) {
//            case Disc.BLACK:
//                return Color.BLACK;
//            case Disc.WHITE:
//                return Color.WHITE;
//            case Disc.EMPTY:
//                return Color.EMPTY;
//            default:
//                return Color.UNKNOWN;
//        }
//    }

    private void turnChange( int colorCode ) {

        if ( colorCode == Disc.BLACK ) {
            playerGroup.getBlackPlayer().onTurn();
        } else {
            playerGroup.getWhitePlayer().onTurn();
        }
    }
}
