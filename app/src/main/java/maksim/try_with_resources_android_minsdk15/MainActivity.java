package maksim.try_with_resources_android_minsdk15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "TryWithResources";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.read_line).setOnClickListener(view -> logLine(readFromByteStream()));
    }

    private void logLine(String line) {
        Log.d(LOG_TAG, line);
    }

    private String readFromByteStream() {
        String line = "Failed to read";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ByteArrayInputStream(
                        new byte[] {
                                104, 101, 108, 108, 111,
                                32,
                                119, 111, 114, 108, 100
                        })
                ))) {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
