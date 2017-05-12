package com.hatenablog.satuya.othello2017.model.othello2.usecase;

import com.hatenablog.satuya.othello2017.model.othello2.manager.BoardManager;

/**
 * Created by Shusei on 2017/05/02.
 */

public class UndoUseCaseImpl implements UndoUseCase {

    private BoardManager boardManager = null;

    public UndoUseCaseImpl( BoardManager boardManager ) {

        this.boardManager = boardManager;
    }

    @Override
    public void undo() {

        //TODO 未実装
    }
}
