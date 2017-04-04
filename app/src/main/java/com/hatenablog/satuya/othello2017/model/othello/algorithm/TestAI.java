package com.hatenablog.satuya.othello2017.model.othello.algorithm;

import com.hatenablog.satuya.othello2017.model.othello.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello.player.Player;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Shusei on 2017/03/19.
 */

public class TestAI implements AI, Player {

    private BoardManager manager = null;
    private Board board = null;

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void onTurn() {

        ArrayList<Disc> discs = board.getPuttablePos();

        Random random = new Random();
        int index = random.nextInt( discs.size() );
        manager.put( discs.get( index ) );
    }

    @Override
    public void setManager( BoardManager manager ) {

        this.manager = manager;
        this.board = this.manager.getBoard();
    }
}
