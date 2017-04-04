package com.hatenablog.satuya.othello2017.usecase;

import com.hatenablog.satuya.othello2017.model.othello.entity.Point;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface PosInputUseCase {

    void onClick( Point point );

    void onUIPutFinished();
}
