package net.workingdev.activitysample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ((TextView) findViewById(R.id.textHello)).setText("1");
  }

  public void addNumber(View v) {
    TextView tv = ((TextView) findViewById(R.id.textHello));
    int currVal = Integer.parseInt(tv.getText().toString());
    tv.setText((++currVal) + "");
    System.out.println("Hello");
  }
}