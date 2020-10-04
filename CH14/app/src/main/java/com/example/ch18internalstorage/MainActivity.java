package com.example.ch18internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

  private Button btn;
  private TextView txtoutput;
  private EditText txtinput;
  
  private String filename = "myfile.txt";
  private String TAG = getClass().getName();
  
  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtoutput = findViewById(R.id.txtoutput);
    txtinput = findViewById(R.id.txtinput);
    
    btn = findViewById(R.id.btn);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        saveData();
      }
    });
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    loadData();
  }
  
  private void loadData() {
    StringBuilder sb = new StringBuilder();
    try (FileInputStream in = openFileInput(filename)) {
      int read = 0;
      while ((read = in.read()) != -1) {
        sb.append((char) read);
      }
      txtoutput.setText(sb.toString());
      txtinput.setText(sb.toString());
      
    }
    catch(IOException ie) {
      Log.e(TAG, ie.getMessage());
    }
  }
  
  private void saveData() {
    String str = txtinput.getText().toString();
    try (FileOutputStream out = openFileOutput(filename, Context.MODE_PRIVATE)) {
      out.write(str.getBytes());
      loadData();
    } catch (IOException e) {
      Log.e(TAG, e.getMessage());
    }
  }
  
}