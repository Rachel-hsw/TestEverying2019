package com.gensee.download;

import com.gensee.utils.GenseeLog;

public class VodDownLoadImpl
{
  private VodDownLoadCallback vodDownLoadCallback;
  private VodDownLoadImplInterface vodDownLoadImplInterface;

  public VodDownLoadImpl(VodDownLoadCallback paramVodDownLoadCallback, VodDownLoadImplInterface paramVodDownLoadImplInterface)
  {
    this.vodDownLoadCallback = paramVodDownLoadCallback;
    this.vodDownLoadImplInterface = paramVodDownLoadImplInterface;
  }

  public void OnProcess(String paramString, int paramInt)
  {
    this.vodDownLoadImplInterface.updateVodDownLoadProgress(paramString, paramInt);
    if (this.vodDownLoadCallback != null)
      this.vodDownLoadCallback.onDLPosition(paramString, paramInt);
  }

  public void OnStatus(String paramString, int paramInt)
  {
    monitorenter;
    while (true)
    {
      try
      {
        GenseeLog.i("VodDownLoadImpl OnStatus downLoadId = " + paramString + " downLoadStatus = " + paramInt);
        if (paramInt != this.vodDownLoadImplInterface.getVodDownLoadStatusByDlId(paramString))
          continue;
        GenseeLog.w("OnStatus downLoadId = " + paramString + " downLoadStatus = " + paramInt);
        return;
        this.vodDownLoadImplInterface.updateVodDownLoadStatus(paramString, paramInt);
        if (paramInt == VodDownLoadStatus.DENY.getStatus())
        {
          this.vodDownLoadImplInterface.releaseDownloading();
          this.vodDownLoadImplInterface.nextVodDownloading();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (paramInt == VodDownLoadStatus.START.getStatus())
      {
        this.vodDownLoadCallback.onDLStart(paramString);
        continue;
      }
      if (paramInt == VodDownLoadStatus.FINISH.getStatus())
      {
        this.vodDownLoadCallback.onDLFinish(paramString);
        this.vodDownLoadImplInterface.releaseDownloading();
        this.vodDownLoadImplInterface.nextVodDownloading();
        continue;
      }
      if (paramInt == VodDownLoadStatus.FAILED.getStatus())
      {
        this.vodDownLoadImplInterface.updateVodDownLoadStopStatus(paramString, 2);
        this.vodDownLoadCallback.onDLError(paramString, 7);
        this.vodDownLoadImplInterface.releaseDownloading();
        this.vodDownLoadImplInterface.nextVodDownloading();
        continue;
      }
      if (paramInt == VodDownLoadStatus.STOP.getStatus())
      {
        this.vodDownLoadCallback.onDLStop(paramString);
        this.vodDownLoadImplInterface.releaseDownloading();
        this.vodDownLoadImplInterface.nextVodDownloading();
        continue;
      }
      if (paramInt != VodDownLoadStatus.LICENSE.getStatus())
        continue;
      this.vodDownLoadImplInterface.releaseDownloading();
      this.vodDownLoadCallback.onDLError(paramString, 12);
    }
  }

  public void onBegin(String paramString)
  {
    monitorenter;
    try
    {
      this.vodDownLoadCallback.onDLPrepare(paramString);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static abstract interface VodDownLoadImplInterface
  {
    public abstract int getVodDownLoadStatusByDlId(String paramString);

    public abstract void nextVodDownloading();

    public abstract void releaseDownloading();

    public abstract void stopDownLoading(String paramString);

    public abstract void updateVodDownLoadProgress(String paramString, int paramInt);

    public abstract void updateVodDownLoadStatus(String paramString, int paramInt);

    public abstract void updateVodDownLoadStopStatus(String paramString, int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoadImpl
 * JD-Core Version:    0.6.0
 */