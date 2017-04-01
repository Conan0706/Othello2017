package com.hatenablog.satuya.othello2017.presentation.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hatenablog.satuya.othello2017.R;
import com.hatenablog.satuya.othello2017.application.Othello2017;
import com.hatenablog.satuya.othello2017.presentation.fragment.GameFragment;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;

import javax.inject.Inject;

public class AnimationSampleActivity extends AppCompatActivity implements GameFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_animation_sample );

        GameFragment fragment = new GameFragment();
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add( R.id.container, fragment );
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction( Uri uri ) {

    }
}
