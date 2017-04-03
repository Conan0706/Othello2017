package com.hatenablog.satuya.othello2017.domain.othello;

import com.hatenablog.satuya.othello2017.domain.othello.entity.Color;
import com.hatenablog.satuya.othello2017.domain.othello.entity.Disc;

/**
 * Created by Shusei on 2017/03/23.
 */

public final class OthelloUtility {

    public static Color convertColorCodeToColor( int colorCode ) {

        switch ( colorCode ) {
            case Disc.BLACK:
                return Color.BLACK;
            case Disc.WHITE:
                return Color.WHITE;
            case Disc.EMPTY:
                return Color.EMPTY;
            default:
                return Color.UNKNOWN;
        }
    }

//    public static int convertColorToColorCode( Color color ) {
//
//        switch ( color ) {
//            case BLACK:
//                return Disc.BLACK;
//            case WHITE:
//                return Disc.WHITE;
//            default:
//                return Disc.EMPTY;
//        }
//    }
}
