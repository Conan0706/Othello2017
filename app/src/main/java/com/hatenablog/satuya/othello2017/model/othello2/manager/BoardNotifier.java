package com.hatenablog.satuya.othello2017.model.othello2.manager;

import com.hatenablog.satuya.othello2017.model.othello2.BoardListener;
import com.hatenablog.satuya.othello2017.model.othello2.event.Event;

/**
 * Created by Shusei on 2017/04/05.
 */

public interface BoardNotifier {

    void addListener( BoardListener listener );
    void deleteListener( BoardListener listener );

    void igniteEvent( Event event );
}
