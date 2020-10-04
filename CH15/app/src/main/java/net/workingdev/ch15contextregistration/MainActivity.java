package net.workingdev.ch15contextregistration;

import androidx.appcompat.app.AppCompatActivity;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  MyReceiver receiver = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    receiver = new MyReceiver();
  }

  @Override
  protected void onResume() {
    super.onResume();

    IntentFilter filter = new IntentFilter("com.workingdev.SOMETHINGHAPPENED");
    registerReceiver(receiver, filter);
  }

  @Override
  protected void onPause() {
    super.onPause();
    unregisterReceiver(receiver);
  }
}