package net.workingdev.runninginbackground;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.workingdev.runninginbackground.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

  private final String TAG = getClass().getName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

//    setContentView(R.layout.activity_main);

    final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();

    setContentView(view);

    binding.button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Log.d(TAG, fetch("tedhagos"));
      }
    });

    binding.btngcf.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int firstno = Integer.parseInt(binding.txt1.getText().toString());
        int secondno = Integer.parseInt(binding.txt2.getText().toString());

        gcfCalculate(firstno, secondno);

      }
    });

    binding.btnnestedcall.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        nestedCall();
      }
    });
  }

  private void nestedCall() {
    for(int i = 1; i < 10000; i++) {
      for(int j = 1; j < 10000; j++) {
        for(int k = 1; k < 10000; k++) {
          System.out.printf("%d", i * j * k);
        }
      }
    }
  }

  private void gcfCalculate(int firstNo, int secondNo) {
    int rem, bigno, smallno = 1;

    if (firstNo > secondNo) { bigno = firstNo; smallno = secondNo;}
    else {bigno = secondNo; smallno = firstNo;}

    while(!((rem = bigno  % smallno) == 0)) {
      bigno = smallno;
      smallno = rem;
    }
    String msg = String.format("GCF = %s", smallno);
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
  }

  private String fetch(String gitHubId) {

    String userInfo = "";
    String url = String.format("https://api.github.com/users/%s", gitHubId);

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url(url)
        .build();

    try(Response response = client.newCall(request).execute()) {
      userInfo = response.body().string();
    }
    catch(IOException ioe) {
      Log.e(TAG, ioe.getMessage());
    }
    return userInfo;
  }

}