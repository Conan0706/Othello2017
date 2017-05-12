package com.hatenablog.satuya.othello2017.model.othello2.usecase;

import com.hatenablog.satuya.othello2017.model.othello2.BoardListener;
import com.hatenablog.satuya.othello2017.model.othello2.manager.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.PutNotifier;
import com.hatenablog.satuya.othello2017.model.othello2.player.UIPlayer;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

/**
 * Created by Shusei on 2017/04/26.
 */

public class PutUseCaseImpl implements PutUseCase, PutNotifier {

    private BoardManager boardManager = null;
    private UIPlayer player = null;

    public PutUseCaseImpl( BoardManager boardManager ) {

        this.boardManager = boardManager;
    }

    @Override
    public void put( Point point ) {

        if ( !( player == null ) ) {
            this.player.put( this.boardManager, point );
        }
    }

    @Override
    public void addBoardListener( BoardListener boardListener ) {

         this.boardManager.addListener( boardListener );
    }

    @Override
    public void deleteBoardListener( BoardListener boardListener ) {

        this.boardManager.deleteListener( boardListener );
    }

    @Override
    public void onTurn( UIPlayer player ) {

        this.player = player;
    }
}
