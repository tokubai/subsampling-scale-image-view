package jp.co.tokubai.imagedisplay;

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

public class ImageDisplayLargeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.imagedisplay_large_fragment, container, false);
        final ImageDisplayActivity activity = (ImageDisplayActivity)getActivity();
        if (activity != null) {
            rootView.findViewById(id.next).setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) { activity.next(); }
            });
        }
        SubsamplingScaleImageView imageView = rootView.findViewById(id.imageView);
        imageView.setImage(ImageSource.asset("card.png"));
        return rootView;
    }

}
