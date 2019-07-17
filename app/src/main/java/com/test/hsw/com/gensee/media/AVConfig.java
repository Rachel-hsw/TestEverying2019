package com.gensee.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build.VERSION;

public class AVConfig
{
  public static final int GS_I420 = 3;
  public static final int GS_NV12 = 5;
  public static final int GS_RGB16 = 1;
  public static final int GS_RGB24 = 0;
  public static final int GS_RGB32 = 2;
  public static final int GS_YUY2 = 4;
  public static final int M16K = 0;
  public static final int M32K = 1;
  public static final int M44K = 2;
  public static final int M48K = 3;
  public static final int S16K = 4;
  public static final int S32K = 5;
  public static final int S44K = 6;
  public static final int S48K = 7;

  public static int getSampleRate(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    int i = AudioTrack.getNativeOutputSampleRate(3);
    String str;
    if (Build.VERSION.SDK_INT >= 17)
    {
      str = localAudioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
      if (str == null);
    }
    for (int j = Integer.parseInt(str); ; j = i)
    {
      switch (j / 1000)
      {
      default:
        return 0;
      case 16:
        return 0;
      case 32:
        return 1;
      case 44:
        return 2;
      case 48:
      }
      return 3;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.AVConfig
 * JD-Core Version:    0.6.0
 */