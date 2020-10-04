package net.workingdev.eventhandling;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn = (Button) findViewById(R.id.button);

    btn.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View view) {
        Context ctx =  MainActivity.this;
        Toast.makeText(ctx, "Hello", Toast.LENGTH_LONG).show();
      }
    });

    btn.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View view) {
        View vtemp = findViewById(R.id.root_layout);
        Snackbar.make(vtemp,"Long click", Snackbar.LENGTH_LONG).show();
        return true;
      }
    });
  }
}