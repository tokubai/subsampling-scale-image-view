package jp.co.tokubai.imagedisplay;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.co.tokubai.ImageSource;
import jp.co.tokubai.SubsamplingScaleImageView;
import jp.co.tokubai.decoder.CompatDecoderFactory;
import jp.co.tokubai.decoder.ImageDecoder;
import jp.co.tokubai.decoder.ImageRegionDecoder;
import jp.co.tokubai.decoder.SkiaImageDecoder;
import jp.co.tokubai.decoder.SkiaImageRegionDecoder;
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
