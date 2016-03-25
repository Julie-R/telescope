package com.mattprecious.telescope.sample.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mattprecious.telescope.EmailLens;
import com.mattprecious.telescope.TelescopeLayout;
import com.mattprecious.telescope.sample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SampleClickListenerEmailView extends FrameLayout {
    @Bind(R.id.telescope)
    TelescopeLayout telescopeView;

    @Bind(R.id.take_screenshot_text_view)
    TextView takeSnapshotTextView;

    public SampleClickListenerEmailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        telescopeView.setLens(new EmailLens(getContext(), "Bug report", "bugs@blackhole.io"));
        takeSnapshotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telescopeView.takeScreenshot();
            }
        });
    }
}
