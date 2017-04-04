package com.hatenablog.satuya.othello2017.usecase;

import com.hatenablog.satuya.othello2017.domain.othello.entity.Point;
import com.hatenablog.satuya.othello2017.domain.othello.player.Player;
import com.hatenablog.satuya.othello2017.domain.othello.player.PlayerGroup;
import com.hatenablog.satuya.othello2017.domain.othello.player.UIPlayer;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

/**
 * Created by Shusei on 2017/03/15.
 */

public class PosInputUseCaseImpl implements PosInputUseCase {

//    private TestPlayerGroupFactory factory = null; //TODO null

    private PlayerGroup playerGroup = null;

    private ArrayList<UIPlayer> uiPlayers = new ArrayList<>();

    @Inject
    public PosInputUseCaseImpl( PlayerGroup playerGroup ) {

//        this.playerGroup = this.factory.getPlayerGroup();

        this.playerGroup = playerGroup;

        Player blackP = playerGroup.getBlackPlayer();
        Player whiteP = playerGroup.getWhitePlayer();

        if ( blackP instanceof UIPlayer ) {
            uiPlayers.add( (UIPlayer) blackP );
        }

        if ( whiteP instanceof UIPlayer ) {
            uiPlayers.add( (UIPlayer) whiteP );
        }
    }

    @Override
    public void onClick( Point point ) {

        Iterator<UIPlayer> iterator = uiPlayers.iterator();

        while ( iterator.hasNext() ) {
            UIPlayer player = iterator.next();
            player.putClicked( point );
        }
    }

    @Override
    public void onUIPutFinished() {

        uiPlayers.get( 0 ).onUIPutFinished();
    }
}
