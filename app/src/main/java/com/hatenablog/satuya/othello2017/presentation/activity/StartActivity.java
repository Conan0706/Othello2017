package com.hatenablog.satuya.othello2017.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hatenablog.satuya.othello2017.R;
import com.hatenablog.satuya.othello2017.presentation.presenter.StartPresenter;

public class StartActivity extends AppCompatActivity {

    private StartPresenter presenter = null;

    private Button startButton = null;
    private Button pastResultsButton = null;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start );

        presenter = new StartPresenter();
        presenter.setStartActivity( this );

        startButton = (Button) findViewById( R.id.start_button );
        pastResultsButton = (Button) findViewById( R.id.past_results );
        startButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                presenter.startButtonClicked();
            }
        } );
        pastResultsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Log.d( "debug", "under development" );
            }
        } );
    }

    public void moveGameView() {

        Intent intent = new Intent( this, AnimationSampleActivity.class );
        startActivity( intent );
    }
}
