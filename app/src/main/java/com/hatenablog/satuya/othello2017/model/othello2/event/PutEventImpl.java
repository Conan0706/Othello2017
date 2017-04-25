package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.engine.ColorStorage;
import com.hatenablog.satuya.othello2017.model.engine.point.DiscForCalc;
import com.hatenablog.satuya.othello2017.model.othello2.BoardValueGroup;
import com.hatenablog.satuya.othello2017.model.othello2.OthelloUtilities;
import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Disc;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shusei on 2017/03/15.
 */

public class PutEventImpl implements PutEvent {

    private BoardValueGroup boardValueGroup = null;

    private Move move = null;
    private ColorStorage colorStorage = null;
    private ArrayList<Disc> updateDiscs = null;
    private ArrayList<Disc> turnDiscs = null;

    public PutEventImpl( BoardValueGroup group, Move move, ColorStorage storage, ArrayList<DiscForCalc> updateDiscs ) {

        this.boardValueGroup = group;
        this.move = move;
        this.colorStorage = storage;

        for ( DiscForCalc dfc : updateDiscs ) {
            this.updateDiscs.add( OthelloUtilities.forCalcDisc2Disc( dfc ) );
            this.turnDiscs.add( OthelloUtilities.forCalcDisc2Disc( dfc ) );
        }
        this.turnDiscs.remove( 0 );
    }

    @Override
    public Move getMove() {
        return this.move;
    }

    @Override
    public ArrayList<Disc> getTurnDiscs() {
        return this.turnDiscs;
    }

    @Override
    public ArrayList<Disc> getUpdateDiscs() {
        return this.updateDiscs;
    }

    @Override
    public int getColorNumber( Color color ) {
        return this.colorStorage.get( OthelloUtilities.color2ColorCode( color ) );
    }

    @Override
    public BoardValueGroup getBoardValueGroup() {
        return this.boardValueGroup;
    }
}
