package toc.ares;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class LauncherActivity extends Activity {
	private static final String NEWLINE = "\n";
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final TextView tv = (TextView) findViewById(R.id.tv);
		final Resources r = getResources();
		final DisplayMetrics metrics = r.getDisplayMetrics();  

		StringBuilder sb = new StringBuilder(256);
		sb.append("1.   Display Metrics").append(NEWLINE);
		sb.append("1-1. density:").append(metrics.density).append(NEWLINE);
		sb.append("1-2. scaledDensity:").append(metrics.scaledDensity).append(NEWLINE);
		sb.append("1-3. widthPixels:").append(metrics.widthPixels).append(NEWLINE);
		sb.append("1-4. heightPixels:").append(metrics.heightPixels).append(NEWLINE);
		sb.append("1-5. densityDpi:").append(metrics.densityDpi).append(NEWLINE);
		sb.append("1-6. xdpi:").append(metrics.xdpi).append(NEWLINE);
		sb.append("1-7. ydpi:").append(metrics.ydpi).append(NEWLINE);

		sb.append("2.   Text metrics for normal TextView").append(NEWLINE);
		sb.append("2-1. TextSize:").append(tv.getTextSize()).append(NEWLINE);
		sb.append("2-2. TextScaleX:").append(tv.getTextScaleX()).append(NEWLINE);

		sb.append("3.   Scaling factor for activity transition animations.").append(NEWLINE);
		sb.append("3-1. ScalinfFactor:");
		float scale = 0f;
		try {
			scale = Settings.System.getFloat(getContentResolver(),
					Settings.System.TRANSITION_ANIMATION_SCALE);
			sb.append(scale);
		} catch (SettingNotFoundException e) {
			sb.append(e.getMessage());
		}
		sb.append(NEWLINE);

		tv.setText(sb.toString());

	}
}