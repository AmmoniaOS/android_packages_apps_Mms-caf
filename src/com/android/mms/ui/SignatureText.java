/*
 * Copyright (C) 2015 The OneUI Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.mms.ui;

import android.content.Context;
import android.provider.Settings;
import android.widget.TextView;
import android.text.TextUtils;
import android.view.View;
import android.util.AttributeSet;

public class SignatureText extends TextView {
    private static final String TAG = "SignatureText";

    public SignatureText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String CustomSignatureLabel = Settings.System.getString(getContext().getContentResolver(),
                      Settings.System.CUSTOM_SIGNATURE_LABEL);
        if (!TextUtils.isEmpty(CustomSignatureLabel)) {
            setText(CustomSignatureLabel);
        } else {
            setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}