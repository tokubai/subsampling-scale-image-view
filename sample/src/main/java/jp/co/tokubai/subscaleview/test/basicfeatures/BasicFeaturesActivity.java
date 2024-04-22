package jp.co.tokubai.basicfeatures;

import android.os.Bundle;
import androidx.annotation.Nullable;

import jp.co.tokubai.ImageSource;
import jp.co.tokubai.SubsamplingScaleImageView;
import jp.co.tokubai.AbstractPagesActivity;
import jp.co.tokubai.Page;
import jp.co.tokubai.subscaleview.test.R.id;

import java.util.Arrays;

import static jp.co.tokubai.subscaleview.test.R.string.*;
import static jp.co.tokubai.subscaleview.test.R.layout.*;

public class BasicFeaturesActivity extends AbstractPagesActivity {

    public BasicFeaturesActivity() {
        super(basic_title, pages_activity, Arrays.asList(
                new Page(basic_p1_subtitle, basic_p1_text),
                new Page(basic_p2_subtitle, basic_p2_text),
                new Page(basic_p3_subtitle, basic_p3_text),
                new Page(basic_p4_subtitle, basic_p4_text),
                new Page(basic_p5_subtitle, basic_p5_text)
        ));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SubsamplingScaleImageView view = findViewById(id.imageView);
        view.setImage(ImageSource.asset("sanmartino.jpg"));
    }

}
