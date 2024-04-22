package jp.co.tokubai.subscaleview.test.imagedisplay;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.tokubai.subscaleview.ImageSource;
import jp.co.tokubai.subscaleview.SubsamplingScaleImageView;
import jp.co.tokubai.subscaleview.decoder.CompatDecoderFactory;
import jp.co.tokubai.subscaleview.decoder.ImageDecoder;
import jp.co.tokubai.subscaleview.decoder.ImageRegionDecoder;
import jp.co.tokubai.subscaleview.decoder.SkiaImageDecoder;
import jp.co.tokubai.subscaleview.decoder.SkiaImageRegionDecoder;
import jp.co.tokubai.subscaleview.test.R.id;
import jp.co.tokubai.subscaleview.test.R.layout;

public class ImageDisplayRegionFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout.imagedisplay_region_fragment, container, false);
        final SubsamplingScaleImageView imageView = rootView.findViewById(id.imageView);
        imageView.setBitmapDecoderFactory(new CompatDecoderFactory<ImageDecoder>(SkiaImageDecoder.class, Bitmap.Config.ARGB_8888));
        imageView.setRegionDecoderFactory(new CompatDecoderFactory<ImageRegionDecoder>(SkiaImageRegionDecoder.class, Bitmap.Config.ARGB_8888));
        imageView.setOrientation(SubsamplingScaleImageView.ORIENTATION_90);
        imageView.setImage(ImageSource.asset("card.png").region(new Rect(5200, 651, 8200, 3250)));
        final ImageDisplayActivity activity = (ImageDisplayActivity)getActivity();
        if (activity != null) {
            rootView.findViewById(id.previous).setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) { activity.previous(); }
            });
        }
        rootView.findViewById(id.rotate).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { imageView.setOrientation((imageView.getOrientation() + 90) % 360); }
        });
        return rootView;
    }

}
