package jp.co.tokubai.subscaleview.test.extension;

import androidx.fragment.app.Fragment;
import android.util.Log;

import jp.co.tokubai.subscaleview.test.AbstractFragmentsActivity;
import jp.co.tokubai.subscaleview.test.Page;
import jp.co.tokubai.subscaleview.test.R.id;
import jp.co.tokubai.subscaleview.test.imagedisplay.ImageDisplayActivity;

import java.util.Arrays;
import java.util.List;

import static jp.co.tokubai.subscaleview.test.R.layout.fragments_activity;
import static jp.co.tokubai.subscaleview.test.R.string.extension_p1_subtitle;
import static jp.co.tokubai.subscaleview.test.R.string.extension_p1_text;
import static jp.co.tokubai.subscaleview.test.R.string.extension_p2_subtitle;
import static jp.co.tokubai.subscaleview.test.R.string.extension_p2_text;
import static jp.co.tokubai.subscaleview.test.R.string.extension_p3_subtitle;
import static jp.co.tokubai.subscaleview.test.R.string.extension_p3_text;
import static jp.co.tokubai.subscaleview.test.R.string.extension_title;

public class ExtensionActivity extends AbstractFragmentsActivity {

    private static final List<Class<? extends Fragment>> FRAGMENTS = Arrays.asList(
            ExtensionPinFragment.class,
            ExtensionCircleFragment.class,
            ExtensionFreehandFragment.class
    );
    
    public ExtensionActivity() {
        super(extension_title, fragments_activity, Arrays.asList(
                new Page(extension_p1_subtitle, extension_p1_text),
                new Page(extension_p2_subtitle, extension_p2_text),
                new Page(extension_p3_subtitle, extension_p3_text)
        ));
    }

    @Override
    protected void onPageChanged(int page) {
        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(id.frame, FRAGMENTS.get(page).newInstance())
                    .commit();
        } catch (Exception e) {
            Log.e(ImageDisplayActivity.class.getName(), "Failed to load fragment", e);
        }
    }

}
