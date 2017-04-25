package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.engine.point.DiscForCalc;
import com.hatenablog.satuya.othello2017.model.engine.point.PointForCalc;
import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Disc;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.BLACK;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.EMPTY;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.WALL;
import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.WHITE;

/**
 * Created by Shusei on 2017/04/22.
 */

public final class OthelloUtilities {

    public static Point forCalcPoint2Point( PointForCalc pointForCalc ) {

        return new Point( pointForCalc.x, pointForCalc.y );
    }

    public static PointForCalc point2ForCalcPoint( Point point ) {

        return new PointForCalc( point.getX(), point.getY() );
    }

    public static Disc forCalcDisc2Disc( DiscForCalc discForCalc ) {

        return new Disc( discForCalc.x, discForCalc.y, colorCode2Color( discForCalc.color ) );
    }

    public static DiscForCalc Disc2ForCalcDisc( Disc disc ) {

        return new DiscForCalc( disc.getX(), disc.getY(), color2ColorCode( disc.getColor() ) );
    }

    public static Color colorCode2Color( int colorCode ) {

        Color color = null;
        switch ( colorCode ) {
            case BLACK:
                color = Color.BLACK;
                break;
            case WHITE:
                color = Color.WHITE;
                break;
            case EMPTY:
                color = Color.EMPTY;
                break;
            case WALL:
                color = Color.WALL;
                break;
        }
        return color;
    }

    public static int color2ColorCode( Color color ){

        int colorCode = 0;
        switch ( color ) {
            case BLACK:
                colorCode = BLACK;
                break;
            case WHITE:
                colorCode = WHITE;
                break;
            case EMPTY:
                colorCode = EMPTY;
                break;
            case WALL:
                colorCode = WALL;
                break;
        }
        return colorCode;
    }

    private OthelloUtilities() {}
}
