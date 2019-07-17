package com.bokecc.sdk.mobile.play;

import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import java.util.Map;
import java.util.TreeMap;

class b
  implements Runnable
{
  b(DWSpeedMediaPlayer paramDWSpeedMediaPlayer)
  {
  }

  public void run()
  {
    try
    {
      Map localMap = DWSpeedMediaPlayer.a(this.a, DWSpeedMediaPlayer.a(this.a), DWSpeedMediaPlayer.b(this.a), DWSpeedMediaPlayer.c(this.a));
      DWSpeedMediaPlayer.a(this.a, localMap, DWSpeedMediaPlayer.d(this.a));
      if (DWSpeedMediaPlayer.e(this.a))
      {
        DWSpeedMediaPlayer.a(this.a, DWSpeedMediaPlayer.f(this.a));
        return;
      }
      if (DWSpeedMediaPlayer.g(this.a).isEmpty())
        throw new DreamwinException(ErrorCode.INVALID_REQUEST, new String[] { "视频无播放节点" });
    }
    catch (Exception localException)
    {
      if (localException != null)
      {
        Log.e("play info error", localException + "");
        if ((localException instanceof DreamwinException))
        {
          DWSpeedMediaPlayer.a(this.a, ((DreamwinException)localException).getErrorCode());
          return;
          if (!DWSpeedMediaPlayer.h(this.a).e())
            throw new DreamwinException(ErrorCode.INVALID_REQUEST, new String[] { "视频无法播放，请检查视频状态" });
          DWSpeedMediaPlayer.a(this.a, DWSpeedMediaPlayer.c(this.a), DWSpeedMediaPlayer.h(this.a).c());
          return;
        }
        DWSpeedMediaPlayer.a(this.a, ErrorCode.NETWORK_ERROR);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.play.b
 * JD-Core Version:    0.6.0
 */