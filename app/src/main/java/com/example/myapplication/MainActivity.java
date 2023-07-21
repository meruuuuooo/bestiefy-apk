package com.example.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView githubLinkTextView = findViewById(R.id.githubLinkTextView);
        githubLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGitHubProfile();
            }
        });
    }

    private void openGitHubProfile() {
        // Replace "your_github_username" with your actual GitHub username
        String githubUrl = "https://github.com/meruuuuooo";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
        startActivity(intent);
    }

    public void bestiesBtn(View v){
        EditText inputTxt = (EditText) findViewById(R.id.editTextText);
        TextView resultTxt = (TextView) findViewById(R.id.textView4);
        String str = inputTxt.getText().toString();
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(str);

        String newStr = matcher.replaceAll("\uD83E\uDD38\u200D♀");

        resultTxt.setText(newStr.toString());

        if (!newStr.isEmpty()){
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Copied Text", newStr);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "text copied to clipboard", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "result text is empty", Toast.LENGTH_SHORT).show();
        }

    }



}