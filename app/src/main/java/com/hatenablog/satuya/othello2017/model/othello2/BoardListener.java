package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.othello2.event.FinishEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PassEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PutEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.UndoEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.WrongMoveEvent;

/**
 * Created by Shusei on 2017/04/05.
 */

public interface BoardListener {

    void onFinish( FinishEvent event );

    void onPass( PassEvent event );

    void onPut( PutEvent event );

    void onUndo( UndoEvent event );

    void onWrongPut( WrongMoveEvent event );
}
