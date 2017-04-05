package com.hatenablog.satuya.othello2017.model.othello2;

/**
 * Created by Shusei on 2017/04/05.
 */

public interface BoardNotifier {

    void addListener( BoardListener listener );
    void deleteListener( BoardListener listener );
}
