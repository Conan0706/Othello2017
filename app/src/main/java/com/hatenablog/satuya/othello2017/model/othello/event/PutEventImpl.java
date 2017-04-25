package com.hatenablog.satuya.othello2017.model.othello.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shusei on 2017/03/15.
 */

public class PutEventImpl implements PutEvent {

    private Color playerColor = null;

    private Disc putDisc = null;
    private ArrayList<Disc> updateDiscs = null;
    private ArrayList<Disc> turnDiscs = new ArrayList<>();

    private int blackNumber = -1;
    private int whiteNumber = -1;

    public PutEventImpl( Color playerColor, ArrayList<Disc> updateDiscs, int blackNumber, int whiteNumber ) {
        //TODO 冗長
        this.playerColor = playerColor;
        this.updateDiscs = updateDiscs;
        this.putDisc = this.updateDiscs.get( 0 );
//        this.turnDiscs = (ArrayList<DiscForCalc>) this.updateDiscs.clone(); //今日はここまで 3/15 4:03 3/15 15:31 終了
        //3/20 23:54 シャローコピーらしいので書き換え

        Iterator<Disc> iterator = this.updateDiscs.iterator();

        while ( iterator.hasNext() ) {

            this.turnDiscs.add( iterator.next().clone() );
        } //3/24 23:56 書き換え完了
        this.turnDiscs.remove( 0 );
        //TODO DiscクラスをClonableにする 完了
    }

    @Override
    public Color getPutPlayerColor() {
        return this.playerColor;
    }

    @Override
    public Disc getPutDisc() {
        return this.putDisc;
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
    public int getDiscNumber( int color ) { //黒と白以外は指定しない

        if ( color == Disc.BLACK ) {
            return this.blackNumber;
        } else {
            return this.whiteNumber;
        }
    }
}
