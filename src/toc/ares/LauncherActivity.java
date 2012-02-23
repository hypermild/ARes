package toc.ares;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class LauncherActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView tv = (TextView)findViewById(R.id.tv);
        final Resources r = getResources();
        tv.setText("TextSize:"+ tv.getTextSize() + "\n");
        tv.append("TextScaleX:" + tv.getTextScaleX() + "\n");
//        tv.append(tv.getTypeface().toString());
        
    }
}