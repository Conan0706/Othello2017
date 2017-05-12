package com.hatenablog.satuya.othello2017.model.othello2.usecase;

import com.hatenablog.satuya.othello2017.model.othello2.BoardListener;
import com.hatenablog.satuya.othello2017.model.othello2.manager.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

/**
 * Created by Shusei on 2017/04/26.
 */

public interface PutUseCase {

    void put( Point point );

    void addBoardListener( BoardListener boardListener );
    void deleteBoardListener( BoardListener boardListener );
}
