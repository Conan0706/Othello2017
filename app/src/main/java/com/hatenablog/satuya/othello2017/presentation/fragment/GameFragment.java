package com.hatenablog.satuya.othello2017.presentation.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hatenablog.satuya.othello2017.R;
import com.hatenablog.satuya.othello2017.application.Othello2017;
import com.hatenablog.satuya.othello2017.di.component.AppComponent;
import com.hatenablog.satuya.othello2017.domain2.othello.OthelloUtility;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Point;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;
import com.hatenablog.satuya.othello2017.presentation.view.GameView;

import javax.inject.Inject;

import static com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc.BLACK;
import static com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc.EMPTY;
import static com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc.WHITE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment implements GameView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static final int BOARD_SIZE = 8;
    public static final int BOARD_SIZE_DP = 300;
    public static final float BUTTON_SIZE_DP = 37.5f;

    private ImageButton[][] buttons = new ImageButton[BOARD_SIZE][BOARD_SIZE];
    private GridLayout layout = null; //TODO null

    private Handler handler = new Handler();

    private Context context = null;

    private Animation appearanceAnimation, scaleUpAnimation, scaleDownAnimation;

    private boolean hasAnimated = true;

    @Inject
    GamePresenter presenter = null;

    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance( String param1, String param2 ) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        if ( getArguments() != null ) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }

        appearanceAnimation = AnimationUtils.loadAnimation( getContext(), R.anim.appearance );
        scaleDownAnimation = AnimationUtils.loadAnimation( getContext(), R.anim.scale_down );
        scaleUpAnimation = AnimationUtils.loadAnimation( getContext(), R.anim.scale_up );

        initBoard();

        Othello2017 app = (Othello2017) context.getApplicationContext();
        AppComponent component = app.getAppComponent();
        component.inject( this );
        presenter.setBoardView( this );
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment

        return inflater.inflate( R.layout.fragment_game, container, false );
    }

    @Override
    public void onViewCreated( View view, Bundle bundle ) {

        super.onViewCreated( view, bundle );

        layout = (GridLayout) view.findViewById( R.id.fragment_board );
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed( Uri uri ) {
        if ( mListener != null ) {
            mListener.onFragmentInteraction( uri );
        }
    }

    @Override
    public void onAttach( Context context ) {
        super.onAttach( context );
        if ( context instanceof OnFragmentInteractionListener ) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException( context.toString()
                    + " must implement OnFragmentInteractionListener" );
        }

        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void initBoard() {

        handler.post( new Runnable() {
            @Override
            public void run() {
                final int size = convertDpToPx( BUTTON_SIZE_DP );

                for ( int i = 0; i < BOARD_SIZE; i++ ) {
                    for ( int j = 0; j < BOARD_SIZE; j++ ) {
                        ImageButton button = buttons[i][j] = new ImageButton( getContext() );
                        button.setScaleType( ImageView.ScaleType.CENTER_CROP );
                        button.setBackgroundColor( Color.TRANSPARENT );
                        button.setImageResource( R.drawable.empty );

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

    @Override
    public void showBoard() {

    }

    @Override
    public void hideBoard() {

    }

    @Override
    public void putDisc( Disc disc ) {

        animateButtonColor( disc );

        Log.d( "putDisc", "x:" + disc.x + "\ny:" + disc.y );
    }

    @Override
    public void turnDisc( Disc turnDisc ) {

        animateButtonColor( turnDisc );
        Log.d( "turnDisc", "x:" + turnDisc.x + "\ny:" + turnDisc.y );
    }

    @Override
    public void showResult( String result ) {

    }

    @Override
    public void showPassed( String text ) {

    }

    @Override
    public void showWrongPosPut( String text ) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction( Uri uri );
    }

    synchronized private void animateButtonColor( final Disc putDisc ) {

        hasAnimated = false;

        final int i = putDisc.x - 1;
        final int j = putDisc.y - 1;
        final Disc beforeDisc = (Disc) buttons[i][j].getTag();

        if ( beforeDisc.color == BLACK || beforeDisc.color == WHITE ) {
            handler.post( new Runnable() {
                @Override
                public void run() {
                    scaleDownAnimation = AnimationUtils.loadAnimation( getContext(), R.anim.scale_down );
                    scaleDownAnimation.setAnimationListener( new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart( Animation animation ) {

                        }

                        @Override
                        public void onAnimationEnd( Animation animation ) {

                            if ( beforeDisc.color == BLACK ) {
                                buttons[i][j].setImageResource( R.drawable.white_stone );
                                buttons[i][j].setTag( putDisc );
                            } else {
                                buttons[i][j].setImageResource( R.drawable.black_stone );
                                buttons[i][j].setTag( putDisc );
                            }

                            scaleUpAnimation = AnimationUtils.loadAnimation( getContext(), R.anim.scale_up );
                            scaleUpAnimation.setAnimationListener( new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart( Animation animation ) {

                                }

                                @Override
                                public void onAnimationEnd( Animation animation ) {
                                    buttons[i][j].clearAnimation();
                                }

                                @Override
                                public void onAnimationRepeat( Animation animation ) {

                                }
                            } );

                            buttons[i][j].startAnimation( scaleUpAnimation );
                        }

                        @Override
                        public void onAnimationRepeat( Animation animation ) {

                        }
                    } );
                    buttons[i][j].startAnimation( scaleDownAnimation );
                    Log.d( "discAnim", "scaleStart\nx:" + i + "y:" + j );
                }
            } );
        } else if ( beforeDisc.color == EMPTY ) {
            handler.post( new Runnable() {
                @Override
                public void run() {
                    appearanceAnimation = AnimationUtils.loadAnimation( getContext(), R.anim.appearance );
                    appearanceAnimation.setAnimationListener( new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart( Animation animation ) {
                            buttons[i][j].setVisibility( View.VISIBLE );
                        }

                        @Override
                        public void onAnimationEnd( Animation animation ) {
                            buttons[i][j].clearAnimation();
                        }

                        @Override
                        public void onAnimationRepeat( Animation animation ) {

                        }
                    } );

                    if ( putDisc.color == BLACK ) {
                        buttons[i][j].setVisibility( View.INVISIBLE );
                        buttons[i][j].setImageResource( R.drawable.black_stone );
                    } else if ( putDisc.color == WHITE ) {
                        buttons[i][j].setVisibility( View.INVISIBLE );
                        buttons[i][j].setImageResource( R.drawable.white_stone );
                    }

                    buttons[i][j].startAnimation( appearanceAnimation );
                    Log.d( "discAnim", "appearanceStart\nx:" + i + "y:" + j );
                }
            } );
        }
    }

    private int convertDpToPx( float dp ) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float result = dp * metrics.density;
        return (int) result;
    }
}
