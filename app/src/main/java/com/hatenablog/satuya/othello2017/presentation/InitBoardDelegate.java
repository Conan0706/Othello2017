package com.hatenablog.satuya.othello2017.presentation;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hatenablog.satuya.othello2017.R;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.presentation.fragment.GameFragment;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;

import static com.hatenablog.satuya.othello2017.presentation.fragment.GameFragment.BOARD_SIZE;

/**
 * Created by Shusei on 2017/04/02.
 */

public class InitBoardDelegate {

    protected ViewGroup layout = null;

    public InitBoardDelegate( GameFragment fragment ) {

        layout = (ViewGroup) fragment.findViewById( R.id.fragment_board );
    }

    public void initBoard( final ImageButton[][] buttons, final Context context,
                           final GamePresenter presenter, final int size ) {

        Handler handler = new Handler();

        handler.post( new Runnable() {
            @Override
            public void run() {
//                final int size = convertDpToPx( BUTTON_SIZE_DP );

                for ( int i = 0; i < BOARD_SIZE; i++ ) {
                    for ( int j = 0; j < BOARD_SIZE; j++ ) {
                        ImageButton button = buttons[i][j] = new ImageButton( context );
                        button.setScaleType( ImageView.ScaleType.CENTER_CROP );
                        button.setBackgroundColor( Color.TRANSPARENT );
                        button.setImageResource( R.drawable.empty );

                        button.setVisibility( View.VISIBLE );

                        button.setTag( new Disc( i + 1, j + 1, Disc.EMPTY ) );

                        if ( ( i == 3 && j == 3 ) || ( i == 4 && j == 4 ) ) {
                            button.setImageResource( R.drawable.white_stone );
                            button.setTag( new Disc( i + 1, j + 1, Disc.WHITE ) );
                        }

                        if ( ( i == 3 && j == 4 ) || ( i == 4 && j == 3 ) ) {
                            button.setImageResource( R.drawable.black_stone );
                            button.setTag( new Disc( i + 1, j + 1, Disc.BLACK ) );
                        }

                        button.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick( View v ) {
                                presenter.onClick( v );
                            }
                        } );

                        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                        layoutParams.width = size;
                        layoutParams.height = size;
                        layoutParams.columnSpec = GridLayout.spec( i );
                        layoutParams.rowSpec = GridLayout.spec( j );
                        button.setLayoutParams( layoutParams );
                        layout.addView( button );
                    }
                }
            }
        } );
    }
}
