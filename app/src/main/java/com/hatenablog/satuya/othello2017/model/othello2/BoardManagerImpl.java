package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.engine.point.DiscForCalc;
import com.hatenablog.satuya.othello2017.model.othello2.event.FinishEventImpl;
import com.hatenablog.satuya.othello2017.model.othello2.event.PassEventImpl;
import com.hatenablog.satuya.othello2017.model.othello2.event.PutEventImpl;
import com.hatenablog.satuya.othello2017.model.othello2.event.UndoEventImpl;
import com.hatenablog.satuya.othello2017.model.othello2.mode_state.ComputerModeState;
import com.hatenablog.satuya.othello2017.model.othello2.mode_state.GameModeState;
import com.hatenablog.satuya.othello2017.model.othello2.mode_state.HumanModeState;
import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.other.EventType;
import com.hatenablog.satuya.othello2017.model.othello2.other.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.other.PlayerType;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;
import com.hatenablog.satuya.othello2017.model.othello2.player.PlayerData;
import com.hatenablog.satuya.othello2017.model.othello2.player.PlayerDataImpl;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

import java.util.ArrayList;

import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.BLACK;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.WHITE;

/**
 * Created by Shusei on 2017/04/05.
 */

public class BoardManagerImpl implements BoardManager {

    private GameMode gameMode = null;

    private BoardNotifier notifier = null;

    private Board board = null;
    private GameModeState modeState = null;

    private PlayerType currentPlayerType = null;
    private PlayerData currentPlayerData = null;
    private Move currentMove = null;

    private Player blackPlayer = null;
    private Player whitePlayer = null;

    public BoardManagerImpl( Board board, GameMode mode, Player blackPlayer, Player whitePlayer ) {

        this.board = board;
        init( mode, blackPlayer, whitePlayer );
    }

    @Override
    public void init( GameMode mode, Player blackPlayer, Player whitePlayer ) {

        this.notifier = new BoardNotifierImpl();
        this.gameMode = mode;
        this.board.init();

        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;

        switch ( mode ) {
            case HUMAN_MODE:
                this.modeState = HumanModeState.getInstance();
                break;
            case COMPUTER_MODE:
                this.modeState = ComputerModeState.getInstance();
                break;
        }
    }

    @Override
    public void addObserver( BoardListener listener ) {

        this.notifier.addListener( listener );
    }

    @Override
    public void deleteObserver( BoardListener listener ) {

        this.notifier.deleteListener( listener );
    }

    @Override
    public boolean put( Move move ) {

        boolean canPut = this.modeState.put( this, this.board, move );

        if ( canPut ) {
            if ( move.getColor() == Color.BLACK ) {
                new Thread( new Runnable() {
                    @Override
                    public void run() {
                        whitePlayer.onTurn();
                    }
                } ).start();
            }
            if ( move.getColor() == Color.WHITE ) {
                new Thread( new Runnable() {
                    @Override
                    public void run() {
                        blackPlayer.onTurn();
                    }
                } ).start();
            }
        }

        return canPut;
    }

    @Override
    public boolean undo( PlayerData playerData ) {

        boolean canPut = this.modeState.undo( this, this.board );

        return canPut;
    }

    @Override
    public boolean check( Move move ) {

        ArrayList<DiscForCalc> discs = this.board.getMovablePos();

        for ( DiscForCalc dfc : discs ) {
            if ( dfc.equals( OthelloUtilities.Disc2ForCalcDisc( move ) ) ) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void igniteEvent( EventType type ) {

        switch ( type ) {
            case PUT:
                notifier.igniteEvent(
                        new PutEventImpl( makeBVG(), currentMove, this.board.getColorStorage(), this.board.getUpdateDiscs() ) );
                break;
            case PASS:
                notifier.igniteEvent(
                        new PassEventImpl( makeBVG(), this.currentPlayerData ) );
                break;
            case FINISH:
                notifier.igniteEvent(
                        new FinishEventImpl(
                                makeBVG(), getWinnerOrLoser( true ), getWinnerOrLoser( false ), this.board.getColorStorage() ) );
                break;
            case UNDO:
                notifier.igniteEvent(
                        new UndoEventImpl( makeBVG(), this.currentPlayerData ) );
                break;
        }
    }

    private BoardValueGroup makeBVG() {

        return new BoardValueGroup() {
            @Override
            public PlayerType getCurrentPlayerType() {
                return BoardManagerImpl.this.currentPlayerType;
            }

            @Override
            public PlayerType getPlayerType( Color color ) {
                if ( color == Color.BLACK ) {
                    return blackPlayer.getPlayerData().getPlayerType();
                } else {
                    return whitePlayer.getPlayerData().getPlayerType();
                }
            }

            @Override
            public Color getCurrentColorType() {
                return OthelloUtilities.colorCode2Color( BoardManagerImpl.this.board.getCurrentColor() );
            }

            @Override
            public Color getColorType( Point point ) {
                return OthelloUtilities.colorCode2Color(
                        BoardManagerImpl.this.board.getColor( OthelloUtilities.point2ForCalcPoint( point ) ) );
            }

            @Override
            public GameMode getCurrentMode() {
                return BoardManagerImpl.this.gameMode;
            }

            @Override
            public int getTurns() {
                return BoardManagerImpl.this.board.getTurns();
            }
        };
    }

    private PlayerData getWinnerOrLoser( boolean isWinner ) {

        int score1 = isWinner ? this.board.countDisc( BLACK ) : this.board.countDisc( WHITE );
        int score2 = isWinner ? this.board.countDisc( WHITE ) : this.board.countDisc( BLACK );

        if ( score1 > score2 ) {
            return blackPlayer.getPlayerData();
        } else if ( score2 > score1 ) {
            return whitePlayer.getPlayerData();
        } else {
            return new PlayerDataImpl( null, Color.DRAW ); //TODO null
        }
    }
}
