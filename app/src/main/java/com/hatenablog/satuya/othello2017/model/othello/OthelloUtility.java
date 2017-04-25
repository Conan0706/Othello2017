package com.hatenablog.satuya.othello2017.model.othello;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;

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
//                return DiscForCalc.BLACK;
//            case WHITE:
//                return DiscForCalc.WHITE;
//            default:
//                return DiscForCalc.EMPTY;
//        }
//    }
}
