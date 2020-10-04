package net.workingdev.ch15contextregistration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    Toast.makeText(context, "Got it", Toast.LENGTH_LONG).show();
  }
}
