package jp.co.tokubai.viewpager;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.tokubai.ImageSource;
import jp.co.tokubai.SubsamplingScaleImageView;
import jp.co.tokubai.subscaleview.test.R.id;
import jp.co.tokubai.subscaleview.test.R.layout;

public class ViewPagerFragment extends Fragment {

    private static final String BUNDLE_ASSET = "asset";

    private String asset;

    public ViewPagerFragment() {
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.view_pager_page, container, false);

        if (savedInstanceState != null) {
            if (asset == null && savedInstanceState.containsKey(BUNDLE_ASSET)) {
                asset = savedInstanceState.getString(BUNDLE_ASSET);
            }
        }
        if (asset != null) {
            SubsamplingScaleImageView imageView = rootView.findViewById(id.imageView);
            imageView.setImage(ImageSource.asset(asset));
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        View rootView = getView();
        if (rootView != null) {
            outState.putString(BUNDLE_ASSET, asset);
        }
    }

}
