package com.gensee.voiceengine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build.VERSION;

class AudioManagerAndroid
{
  private static final int DEFAULT_FRAMES_PER_BUFFER = 256;
  private static final int DEFAULT_SAMPLING_RATE = 441000;
  private static final String TAG = "AudioManagerAndroid";
  private int mAudioLowLatencyOutputFrameSize;
  private boolean mAudioLowLatencySupported;
  private int mNativeOutputSampleRate;

  @SuppressLint({"NewApi"})
  private AudioManagerAndroid(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    this.mNativeOutputSampleRate = 441000;
    this.mAudioLowLatencyOutputFrameSize = 256;
    if (Build.VERSION.SDK_INT >= 17)
    {
      String str1 = localAudioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
      if (str1 != null)
        this.mNativeOutputSampleRate = Integer.parseInt(str1);
      String str2 = localAudioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
      if (str2 != null)
        this.mAudioLowLatencyOutputFrameSize = Integer.parseInt(str2);
    }
    this.mAudioLowLatencySupported = paramContext.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
  }

  private int getAudioLowLatencyOutputFrameSize()
  {
    return this.mAudioLowLatencyOutputFrameSize;
  }

  private int getNativeOutputSampleRate()
  {
    return this.mNativeOutputSampleRate;
  }

  private boolean isAudioLowLatencySupported()
  {
    return this.mAudioLowLatencySupported;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.voiceengine.AudioManagerAndroid
 * JD-Core Version:    0.6.0
 */