package net.workingdev.ch8_implicitintents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  private final String TAG = getClass().getName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add("View Apress");
    menu.add("View Map");
    menu.add("Call number");
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    Intent intent = null;
    Uri uri;
    switch(item.toString()) {
      case "View Apress":
        Log.d(TAG, "View Action");
        uri = Uri.parse("https://apress.com");
        intent = new Intent(Intent.ACTION_VIEW, uri);
        break;
      case "View Map":
        uri = Uri.parse(("geo:40.7113399,-74.0263469"));
        intent = new Intent(Intent.ACTION_VIEW, uri);
        break;
      case "Call number":
        Log.d(TAG, "Call number");
        uri = Uri.parse(("tel:639285083333"));
        intent = new Intent(Intent.ACTION_CALL, uri);
    }
    startActivity(intent);

    return true;
  }
}