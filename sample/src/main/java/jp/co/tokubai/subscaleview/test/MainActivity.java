package jp.co.tokubai.subscaleview.test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import jp.co.tokubai.subscaleview.test.R.id;
import jp.co.tokubai.subscaleview.test.animation.AnimationActivity;
import jp.co.tokubai.subscaleview.test.basicfeatures.BasicFeaturesActivity;
import jp.co.tokubai.subscaleview.test.configuration.ConfigurationActivity;
import jp.co.tokubai.subscaleview.test.eventhandling.EventHandlingActivity;
import jp.co.tokubai.subscaleview.test.eventhandlingadvanced.AdvancedEventHandlingActivity;
import jp.co.tokubai.subscaleview.test.extension.ExtensionActivity;
import jp.co.tokubai.subscaleview.test.imagedisplay.ImageDisplayActivity;
import jp.co.tokubai.subscaleview.test.viewpager.ViewPagerActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.main_title);
        }
        setContentView(R.layout.main);
        findViewById(id.basicFeatures).setOnClickListener(this);
        findViewById(id.imageDisplay).setOnClickListener(this);
        findViewById(id.eventHandling).setOnClickListener(this);
        findViewById(id.advancedEventHandling).setOnClickListener(this);
        findViewById(id.viewPagerGalleries).setOnClickListener(this);
        findViewById(id.animation).setOnClickListener(this);
        findViewById(id.extension).setOnClickListener(this);
        findViewById(id.configuration).setOnClickListener(this);
        findViewById(id.github).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case id.basicFeatures: startActivity(BasicFeaturesActivity.class); break;
            case id.imageDisplay: startActivity(ImageDisplayActivity.class); break;
            case id.eventHandling: startActivity(EventHandlingActivity.class); break;
            case id.advancedEventHandling: startActivity(AdvancedEventHandlingActivity.class); break;
            case id.viewPagerGalleries: startActivity(ViewPagerActivity.class); break;
            case id.animation: startActivity(AnimationActivity.class); break;
            case id.extension: startActivity(ExtensionActivity.class); break;
            case id.configuration: startActivity(ConfigurationActivity.class); break;
            case id.github: openGitHub(); break;
        }
    }

    private void startActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void openGitHub() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://github.com/davemorrissey/subsampling-scale-image-view"));
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
