package com.hatenablog.satuya.othello2017.model.othello2;

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
}
