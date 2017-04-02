package com.hatenablog.satuya.othello2017.presentation.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.hatenablog.satuya.othello2017.R;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Point;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;
import com.hatenablog.satuya.othello2017.presentation.view.GameView;

import javax.inject.Inject;

import static com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc.BLACK;
import static com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc.EMPTY;
import static com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc.WHITE;


public class GameActivity extends AppCompatActivity implements GameView {

    @Inject
    GamePresenter presenter = null;

    public static final int BOARD_SIZE = 8;
    public static final int BOARD_SIZE_DP = 300;
    public static final float BUTTON_SIZE_DP = 37.5f;

    private ImageButton[][] buttons = new ImageButton[BOARD_SIZE][BOARD_SIZE];
    private GridLayout layout = null;

    private Handler handler = new Handler(); //TODO インスタンス化

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_board );

        this.layout = (GridLayout) findViewById( R.id.board );

//        ( (Othello2017) getApplication() ).getAppComponent().inject( this );
        presenter.setGameView( this );

        initBoard();
    }

    @Override
    public void initBoard() {

        handler.post( new Runnable() {
            @Override
            public void run() {
                final int size = convertDpToPx( BUTTON_SIZE_DP );

                for ( int i = 0; i < BOARD_SIZE; i++ ) {
                    for ( int j = 0; j < BOARD_SIZE; j++ ) {

                        ImageButton button = buttons[i][j] = new ImageButton( GameActivity.this );
                        button.setScaleType( ImageView.ScaleType.CENTER_CROP );
                        button.setBackgroundColor( Color.TRANSPARENT );
                        button.setImageResource( R.drawable.empty );

                        button.setTag( new Point( i + 1, j + 1 ) );

                        if ( ( i == 3 && j == 3 ) || ( i == 4 && j == 4 ) ) {
                            button.setImageResource( R.drawable.white_stone );
                        }

                        if ( ( i == 3 && j == 4 ) || ( i == 4 && j == 3 ) ) {
                            button.setImageResource( R.drawable.black_stone );
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

//        final int size = convertDpToPx( BUTTON_SIZE_DP );
//
//        for ( int i = 0; i < BOARD_SIZE; i++ ) {
//            for ( int j = 0; j < BOARD_SIZE; j++ ) {
//
//                ImageButton button = buttons[i][j] = new ImageButton( this );
//                button.setScaleType( ImageView.ScaleType.CENTER_CROP );
//                button.setBackgroundColor( Color.TRANSPARENT );
////                button.setVisibility( View.INVISIBLE );
//                button.setImageResource( R.drawable.empty );
//
//                button.setTag( new Point( i + 1, j + 1 ) );
//
//                if ( ( i == 3 && j == 3 ) || ( i == 4 && j == 4 ) ) {
//                    button.setImageResource( R.drawable.white_stone );
////                    button.setVisibility( View.VISIBLE );
//                }
//
//                if ( ( i == 3 && j == 4 ) || ( i == 4 && j == 3 ) ) {
//                    button.setImageResource( R.drawable.black_stone );
////                    button.setVisibility( View.VISIBLE );
//                }
//
//                button.setOnClickListener( new View.OnClickListener() {
//                    @Override
//                    public void onClick( View v ) {
//                        presenter.onClick( v );
//                    }
//                } );
//
//                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
//                layoutParams.width = size;
//                layoutParams.height = size;
//                layoutParams.columnSpec = GridLayout.spec( i );
//                layoutParams.rowSpec = GridLayout.spec( j );
//                button.setLayoutParams( layoutParams );
//                layout.addView( button );
//            }
//        }

//        buttons[3][3].setImageResource( R.drawable.black_stone );
//        buttons[4][4].setImageResource( R.drawable.black_stone );
//        buttons[3][4].setImageResource( R.drawable.white_stone );
//        buttons[4][3].setImageResource( R.drawable.white_stone );
    }

    @Override
    public void showBoard() { //TODO 削除する

        layout.setVisibility( View.VISIBLE );
    }

    @Override
    public void hideBoard() { //TODO 削除する

        layout.setVisibility( View.INVISIBLE );
    }

    @Override
    public void putDisc( Disc disc ) {
        setButtonColor( disc );
    }

    @Override
    public void turnDisc( Disc turnDisc ) {
        setButtonColor( turnDisc );
    }

    private void setButtonColor( final Disc disc ) {

        handler.post( new Runnable() {
            @Override
            public void run() {
                int i = disc.x - 1;
                int j = disc.y - 1;

                if ( disc.color == BLACK ) {
                    buttons[i][j].setImageResource( R.drawable.black_stone );
                } else if ( disc.color == WHITE ) {
                    buttons[i][j].setImageResource( R.drawable.white_stone );
                } else if ( disc.color == EMPTY ) {
                    buttons[i][j].setImageResource( R.drawable.empty );
                }
            }
        } );

//        int i = disc.x - 1;
//        int j = disc.y - 1;
//
//        if ( disc.color == BLACK ) {
//            buttons[i][j].setImageResource( R.drawable.black_stone );
//        } else if ( disc.color == WHITE ) {
//            buttons[i][j].setImageResource( R.drawable.white_stone );
//        }
//
//        if ( disc.color == EMPTY ) {
//            buttons[i][j].setVisibility( View.INVISIBLE );
//            buttons[i][j].setImageResource( R.drawable.empty );
//        } else {
//            buttons[i][j].setVisibility( View.VISIBLE );
//        }
    }

    @Override
    public void showResult( String result ) {

        showText( result );
    }

    @Override
    public void showPassed( String text ) {

        showText( text );
    }

    @Override
    public void showWrongPosPut( String text ) {

        showText( text );
    }

    private void showText( String text ) {

        Toast.makeText( this, text, Toast.LENGTH_SHORT ).show();
    }

    private int convertDpToPx( float dp ) {

        Context context = this.getApplicationContext();
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float result = dp * metrics.density;
        return (int) result;
    }
}
