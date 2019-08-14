package com.gensee.download;

import android.content.Context;
import com.gensee.common.PlayerWork;
import com.gensee.utils.GenseeLog;
import java.util.List;

public class VodDownLoader extends PlayerWork
  implements VodDownLoadCallback
{
  private static final String TAG = "VodDownLoader";
  private static VodDownLoader downLoader;
  private VodDownLoad mDownLoad;
  private OnDownloadListener mListener;

  private VodDownLoader(Context paramContext, String paramString1, OnDownloadListener paramOnDownloadListener, String paramString2)
  {
    this.mListener = paramOnDownloadListener;
    this.mDownLoad = VodDownLoad.initVodDownLoad(paramContext, paramString1, this, paramString2);
  }

  public static VodDownLoader instance(Context paramContext, OnDownloadListener paramOnDownloadListener, String paramString)
  {
    return instance(paramContext, "0", paramOnDownloadListener, paramString);
  }

  public static VodDownLoader instance(Context paramContext, String paramString1, OnDownloadListener paramOnDownloadListener, String paramString2)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (downLoader != null)
          continue;
        if ((paramString1 != null) && (!"".equals(paramString1)))
        {
          downLoader = new VodDownLoader(paramContext, paramString1, paramOnDownloadListener, paramString2);
          return downLoader;
        }
      }
      finally
      {
        monitorexit;
      }
      paramString1 = "0";
    }
  }

  public void delete(String paramString)
  {
    GenseeLog.d("VodDownLoader", "delete vodId = " + paramString);
    this.mDownLoad.delete(paramString);
  }

  public void delete(List<String> paramList)
  {
    this.mDownLoad.delete(paramList);
  }

  public int download(String paramString)
  {
    GenseeLog.d("VodDownLoader", "download vodId = " + paramString);
    return this.mDownLoad.download(paramString);
  }

  public void download()
  {
    GenseeLog.d("VodDownLoader", "download autoStart");
    this.mDownLoad.autoStart();
  }

  public List<VodDownLoadEntity> getDownloadList()
  {
    return this.mDownLoad.getVdlList();
  }

  public void onDLError(String paramString, int paramInt)
  {
    if (this.mListener != null)
      this.mListener.onDLError(paramString, paramInt);
  }

  public void onDLFinish(String paramString)
  {
    if (this.mListener != null)
      this.mListener.onDLFinish(paramString, this.mDownLoad.getPlayUrl(paramString));
  }

  public void onDLPosition(String paramString, int paramInt)
  {
    if (this.mListener != null)
      this.mListener.onDLPosition(paramString, paramInt);
  }

  public void onDLPrepare(String paramString)
  {
    if (this.mListener != null)
      this.mListener.onDLPrepare(paramString);
  }

  public void onDLStart(String paramString)
  {
    if (this.mListener != null)
      this.mListener.onDLStart(paramString);
  }

  public void onDLStop(String paramString)
  {
    if (this.mListener != null)
      this.mListener.onDLStop(paramString);
  }

  public void release()
  {
    GenseeLog.d("VodDownLoader", "release");
    VodDownLoad.releaseVodDownLoad();
    this.mDownLoad = null;
    downLoader = null;
  }

  public void setAutoDownloadNext(boolean paramBoolean)
  {
    this.mDownLoad.setAutoDownloadNext(paramBoolean);
  }

  public void stop(String paramString)
  {
    GenseeLog.d("VodDownLoader", "stop vodId = " + paramString);
    this.mDownLoad.setStopStatus(paramString, 1);
    this.mDownLoad.stop(paramString);
  }

  public static abstract interface OnDownloadListener extends IDownloadCallback
  {
    public abstract void onDLFinish(String paramString1, String paramString2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoader
 * JD-Core Version:    0.6.0
 */