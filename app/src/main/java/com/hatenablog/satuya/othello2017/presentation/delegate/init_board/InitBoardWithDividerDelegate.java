package com.hatenablog.satuya.othello2017.presentation.delegate.init_board;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hatenablog.satuya.othello2017.R;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.presentation.fragment.GameFragment;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;

import static com.hatenablog.satuya.othello2017.presentation.fragment.GameFragment.BOARD_SIZE;

/**
 * Created by Shusei on 2017/04/03.
 */

public class InitBoardWithDividerDelegate implements InitBoardDelegate {

    private int id;
    private LinearLayout board = null;

    private GameFragment fragment = null;

    private float linearWidth;

    private Context context = null;

    public InitBoardWithDividerDelegate( GameFragment fragment ) {

        this.fragment = fragment;
        this.board = (LinearLayout) fragment.findViewById( R.id.base_board );

        this.context = fragment.getContext();
    }

    @Override
    public int getLayoutID() {
        return 0;
    }

    @Override
    public void initBoard( final ImageButton[][] imageButtons,
                           final GamePresenter presenter, final int size ) {

        int divideColor = R.drawable.divider;
        board.setDividerDrawable( ContextCompat.getDrawable( fragment.getContext(), divideColor ) );

        board.setShowDividers( LinearLayout.SHOW_DIVIDER_MIDDLE );
        board.getViewTreeObserver().addOnGlobalLayoutListener( new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewGroup.LayoutParams layout = board.getLayoutParams();
                layout.height = board.getWidth();
                InitBoardWithDividerDelegate.this.linearWidth = board.getWidth();
                board.setLayoutParams( layout );
                board.getViewTreeObserver().removeOnGlobalLayoutListener( this );
            }
        } );

        for ( int i = 0; i < BOARD_SIZE; i++ ) {

            LinearLayout rowLayout = new LinearLayout( context );
            rowLayout.setOrientation( LinearLayout.HORIZONTAL );
            rowLayout.setDividerDrawable( ContextCompat.getDrawable( context, divideColor ) );
            rowLayout.setShowDividers( LinearLayout.SHOW_DIVIDER_MIDDLE );
            board.addView( rowLayout, new LinearLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, 0, 1 ) );

            for ( int j = 0; j < BOARD_SIZE; j++ ) {
                ImageButton button = imageButtons[i][j] = new ImageButton( context );
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

                button.setOnClickListener( fragment );

                rowLayout.addView( imageButtons[i][j], new LinearLayout.LayoutParams(
                        0, ViewGroup.LayoutParams.MATCH_PARENT, 1 ) );
            }
        }
    }
}
