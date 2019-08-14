package com.bokecc.sdk.mobile.play;

import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import java.util.Map;
import java.util.TreeMap;

class a
  implements Runnable
{
  a(DWMediaPlayer paramDWMediaPlayer)
  {
  }

  public void run()
  {
    try
    {
      Map localMap = DWMediaPlayer.a(this.a, DWMediaPlayer.a(this.a), DWMediaPlayer.b(this.a), DWMediaPlayer.c(this.a));
      DWMediaPlayer.a(this.a, localMap, DWMediaPlayer.d(this.a));
      if (DWMediaPlayer.e(this.a))
      {
        DWMediaPlayer.a(this.a, DWMediaPlayer.f(this.a));
        return;
      }
      if (DWMediaPlayer.g(this.a).isEmpty())
        throw new DreamwinException(ErrorCode.INVALID_REQUEST, new String[] { "视频无播放节点" });
    }
    catch (Exception localException)
    {
      if (localException != null)
      {
        Log.e("play info error", localException + "");
        if ((localException instanceof DreamwinException))
        {
          DWMediaPlayer.a(this.a, ((DreamwinException)localException).getErrorCode());
          return;
          if (!DWMediaPlayer.h(this.a).e())
            throw new DreamwinException(ErrorCode.INVALID_REQUEST, new String[] { "视频无法播放，请检查视频状态" });
          DWMediaPlayer.a(this.a, DWMediaPlayer.c(this.a), DWMediaPlayer.h(this.a).c());
          return;
        }
        DWMediaPlayer.a(this.a, ErrorCode.NETWORK_ERROR);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.play.a
 * JD-Core Version:    0.6.0
 */