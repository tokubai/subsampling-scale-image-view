package jp.co.tokubai.subscaleview.test.imagedisplay;

import androidx.fragment.app.Fragment;
import android.util.Log;

import jp.co.tokubai.subscaleview.test.AbstractFragmentsActivity;
import jp.co.tokubai.subscaleview.test.Page;
import jp.co.tokubai.subscaleview.test.R.id;

import java.util.Arrays;
import java.util.List;

import static jp.co.tokubai.subscaleview.test.R.string.*;
import static jp.co.tokubai.subscaleview.test.R.layout.*;

public class ImageDisplayActivity extends AbstractFragmentsActivity {

    private static final List<Class<? extends Fragment>> FRAGMENTS = Arrays.asList(
            ImageDisplayLargeFragment.class,
            ImageDisplayRotateFragment.class,
            ImageDisplayRegionFragment.class
    );

    public ImageDisplayActivity() {
        super(display_title, fragments_activity, Arrays.asList(
                new Page(display_p1_subtitle, display_p1_text),
                new Page(display_p2_subtitle, display_p2_text),
                new Page(display_p3_subtitle, display_p3_text)
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
