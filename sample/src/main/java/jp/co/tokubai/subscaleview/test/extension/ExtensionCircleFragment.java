package jp.co.tokubai.subscaleview.test.extension;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.tokubai.subscaleview.ImageSource;
import jp.co.tokubai.subscaleview.SubsamplingScaleImageView;
import jp.co.tokubai.subscaleview.test.R.id;
import jp.co.tokubai.subscaleview.test.R.layout;

public class ExtensionCircleFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.extension_circle_fragment, container, false);
        final ExtensionActivity activity = (ExtensionActivity)getActivity();
        if (activity != null) {
            rootView.findViewById(id.next).setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) { activity.next(); }
            });
            rootView.findViewById(id.previous).setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) { activity.previous(); }
            });
        }
        SubsamplingScaleImageView imageView = rootView.findViewById(id.imageView);
        imageView.setImage(ImageSource.asset("sanmartino.jpg"));
        return rootView;
    }

}
