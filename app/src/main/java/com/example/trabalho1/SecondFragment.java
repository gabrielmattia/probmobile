package com.example.trabalho1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.MotionEvent;

import com.example.trabalho1.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private MediaPlayer mPlayer;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.sons, android.R.layout.simple_spinner_item);
        binding.spinner.setAdapter(adapter);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              System.out.println( binding.spinner.getItemAtPosition( i));
              if(mPlayer!=null){
                  mPlayer.release();
              }
              switch (i){
                  case 1:
                      mPlayer=MediaPlayer.create(getContext(),R.raw.som1);
                      mPlayer.start();
                      break;
                  case 2:
                      mPlayer=MediaPlayer.create(getContext(),R.raw.som2);
                      mPlayer.start();

                      break;
                  case 3:
                      mPlayer=MediaPlayer.create(getContext(),R.raw.som3);
                      mPlayer.start();

                      break;
              }
              if(mPlayer!=null){
                  mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                      @Override
                      public void onCompletion(MediaPlayer mediaPlayer) {
                          mediaPlayer.release();
                      }
                  });
              }
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
        });




    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}