package com.hatenablog.satuya.othello2017.domain.othello2.exception;

import static com.hatenablog.satuya.othello2017.domain.othello2.utility.OthelloConstants.BOARD_SIZE;

/**
 * Created by Shusei on 2017/04/03.
 */

public class PointOutOfBoundsException extends OthelloException {

    public PointOutOfBoundsException( int index ) {

        super( "ポイントに指定できる範囲は" + 0 + "〜" + BOARD_SIZE + "までです。\nindex: "
                + index + " は不正です。" );
    }
}
