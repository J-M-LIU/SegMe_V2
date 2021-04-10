/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo4;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import com.example.android.utils.Constants;

import org.opencv.android.OpenCVLoader;


/** Main {@code Activity} class for the Camera app. */
public class CameraActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String channelName = getIntent().getStringExtra(Constants.ACTION_KEY_CHANNEL_NAME);
    Bundle bundle = new Bundle();
    //3.存入数据到Bundle对象中
    bundle.putString("channel",channelName);
    //4.调用Fragment的setArguments方法，传入Bundle对象

    setContentView(R.layout.activity_camera);
    if (null == savedInstanceState) {
      Camera2BasicFragment fragment=new Camera2BasicFragment();
      fragment.setArguments(bundle);
      getFragmentManager()
          .beginTransaction()
          .replace(R.id.container, fragment)
          .commit();
    }


    if (!OpenCVLoader.initDebug())
      Log.e("OpenCv", "Unable to load OpenCV");
    else
      Log.d("OpenCv", "OpenCV loaded");

  }
}
