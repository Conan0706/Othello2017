package com.hatenablog.satuya.othello2017.model.othello2.manager;

import com.hatenablog.satuya.othello2017.model.othello2.BoardListener;
import com.hatenablog.satuya.othello2017.model.othello2.event.Event;
import com.hatenablog.satuya.othello2017.model.othello2.event.FinishEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PassEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PutEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.UndoEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.WrongMoveEvent;

import java.util.ArrayList;

/**
 * Created by Shusei on 2017/04/05.
 */

public class BoardNotifierImpl implements BoardNotifier {

    private ArrayList<BoardListener> listeners = new ArrayList<>();

    @Override
    public void addListener( BoardListener listener ) {

        this.listeners.add( listener );
    }

    @Override
    public void deleteListener( BoardListener listener ) {

        this.listeners.remove( listener );
    }

    @Override
    public void igniteEvent( final Event event ) {

                for ( BoardListener listener : listeners ) {
                    if ( event instanceof FinishEvent ) {
                        finish( (FinishEvent) event );
                    } else if ( event instanceof PassEvent ) {
                        pass( (PassEvent) event );
                    } else if ( event instanceof PutEvent ) {
                        put( (PutEvent) event );
                    } else if ( event instanceof UndoEvent ) {
                        undo( (UndoEvent) event );
                    } else if ( event instanceof WrongMoveEvent ) {
                        wrongPut( (WrongMoveEvent) event );
                    }
                }

    }

    private void put( final PutEvent event ) {

        for ( final BoardListener listener : listeners ) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    listener.onPut( event );
                }
            } ).start();
        }
    }

    private void finish( final FinishEvent event ) {

        for ( final BoardListener listener : listeners ) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    listener.onFinish( event );
                }
            } ).start();
        }
    }

    private void pass( final PassEvent event ) {

        for ( final BoardListener listener : listeners ) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    listener.onPass( event );
                }
            } ).start();
        }
    }

    private void undo( final UndoEvent event ) {

        for ( final BoardListener listener : listeners ) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    listener.onUndo( event );
                }
            } ).start();
        }
    }

    private void wrongPut( final WrongMoveEvent event ) {

        for ( final BoardListener listener : listeners ) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    listener.onWrongPut( event );
                }
            } ).start();
        }
    }
}
