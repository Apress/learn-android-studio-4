package com.example.ch9fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import static com.example.ch9fragments.R.layout.*;

public class BookTitle extends Fragment {
  
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(fragment_booktitles, container, false);
    return view;
  }
  
  
}
