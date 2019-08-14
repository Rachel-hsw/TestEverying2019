package com.gensee.media;

import android.os.Environment;
import com.gensee.entity.DocInfo;
import com.gensee.entity.VodObject;
import com.gensee.entity.VodParam;
import com.gensee.entity.VodPlayParam;
import com.gensee.utils.GenseeLog;
import com.gensee.vod.VodMr;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class GSOLPlayer extends AbsPlayer
  implements IOLPlayerCallback
{
  public static final String CATCH_DEF_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/GSVod/online/catch/";
  private static final String TAG = "GSOLPlayer";
  protected static long nativePlayer;
  private String filePath;
  private boolean isVideoStart = false;
  private int lastTms = 0;
  private OnOLPlayListener mListener;

  public GSOLPlayer()
  {
  }

  private GSOLPlayer(long paramLong)
  {
    nativePlayer = paramLong;
  }

  public GSOLPlayer(String paramString, OnOLPlayListener paramOnOLPlayListener)
  {
    this();
    this.filePath = paramString;
    this.mListener = paramOnOLPlayListener;
  }

  private native long createOfflinePlayer();

  private native long createOnlinePlayer(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3);

  private native int destroyOfflinePlayer(long paramLong);

  private native int nativePause(long paramLong);

  private native int nativePlay(long paramLong, String paramString1, IOLPlayerCallback paramIOLPlayerCallback, boolean paramBoolean, String paramString2, String paramString3);

  private native int nativeResume(long paramLong);

  private native int nativeStop(long paramLong);

  private boolean play(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, OnOLPlayListener paramOnOLPlayListener, String paramString4, String paramString5, String paramString6)
  {
    this.mListener = paramOnOLPlayListener;
    this.filePath = paramString3;
    this.lastTms = 0;
    return addTask(new GSOLPlayer.1(this, paramString6, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramString5));
  }

  private void postionNotify(int paramInt)
  {
    if (this.mListener == null)
      GenseeLog.w("GSOLPlayer postionNotify listener is null");
    int i;
    do
    {
      return;
      i = paramInt - this.lastTms;
    }
    while ((i < 1000) && (i > -1000));
    this.lastTms = paramInt;
    this.mListener.onPosition(paramInt);
  }

  private native int seek(long paramLong, int paramInt);

  private void startPlayer(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    int i = -1;
    String str1;
    String str2;
    label71: String str3;
    if (paramLong != 0L)
    {
      initAudioPlayer();
      GenseeLog.d("GSOLPlayer", "startPlayer filePath = " + paramString1 + " vodId = " + paramString2 + " tId =  " + paramString3);
      if (paramString1 == null)
      {
        str1 = "";
        if (paramString2 != null)
          break label124;
        str2 = "";
        if (paramString3 != null)
          break label131;
        str3 = "";
        label80: i = nativePlay(paramLong, str1, this, false, str2, str3);
      }
    }
    while (true)
    {
      if ((i != 0) && (this.mListener != null))
        this.mListener.onError(1);
      return;
      str1 = paramString1;
      break;
      label124: str2 = paramString2;
      break label71;
      label131: str3 = paramString3;
      break label80;
      GenseeLog.w("GSOLPlayer -> startPlayer player is 0");
    }
  }

  public void onAnimation(int paramInt)
  {
    GenseeLog.d("GSOLPlayer", "onAnimation nStep = " + paramInt);
    renderPageAnimation(paramInt);
  }

  public void onAnnotaion(int paramInt, String paramString)
  {
    GenseeLog.d("GSOLPlayer", "onAnnotaion dwTimeStamp");
    renderAnno(paramString);
  }

  public void onAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, short paramShort)
  {
    audioDataPlay(paramArrayOfByte, paramInt2);
    if (this.mListener != null)
      this.mListener.onAudioLevel(paramShort);
    postionNotify(paramInt1);
  }

  public void onBuffer(boolean paramBoolean)
  {
    GenseeLog.d("GSOLPlayer", "onBuffer isCaching = " + paramBoolean);
    if (this.mListener != null)
      this.mListener.onCaching(paramBoolean);
  }

  public void onInit(int paramInt1, boolean paramBoolean1, int paramInt2, DocInfo[] paramArrayOfDocInfo, int paramInt3, boolean paramBoolean2)
  {
    GenseeLog.d("GSOLPlayer", "onInit result = " + paramInt1 + " hasVideo = " + paramBoolean1 + " duration = " + paramInt2 + " docs = " + paramArrayOfDocInfo + " isDocbySwf = " + paramBoolean2);
    OnOLPlayListener localOnOLPlayListener;
    if (this.mListener != null)
    {
      if (paramInt1 != 0)
        break label107;
      localOnOLPlayListener = this.mListener;
      if (paramArrayOfDocInfo != null)
        break label97;
    }
    label97: for (List localList = null; ; localList = Arrays.asList(paramArrayOfDocInfo))
    {
      localOnOLPlayListener.onInit(paramInt1, paramBoolean1, paramInt2, localList);
      return;
    }
    label107: if (paramInt1 == 12)
    {
      this.mListener.onError(12);
      return;
    }
    this.mListener.onError(7);
  }

  public void onPage(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    GenseeLog.d("GSOLPlayer", "onPage dwTimeStamp = " + paramInt1 + " dwLen = " + paramInt2 + " dwPageW = " + paramInt3 + " dwPageH = " + paramInt4);
    if (this.mListener != null)
      this.mListener.onPageSize(paramInt1, paramInt3, paramInt4);
    renderPage(paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }

  public void onPage(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    GenseeLog.d("GSOLPlayer", "onPage swf dwTimeStamp = " + paramInt1 + " dwLen = " + paramInt2 + " dwPageW = " + paramInt3 + " dwPageH = " + paramInt4);
    if (this.mListener != null)
      this.mListener.onPageSize(paramInt1, paramInt3, paramInt4);
    renderPage(paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramString);
  }

  public void onSeek(int paramInt)
  {
    GenseeLog.d("GSOLPlayer", "onSeek dwTimeStamp = " + paramInt);
    if (this.mListener != null)
      this.mListener.onSeek(paramInt);
  }

  public void onStop()
  {
    GenseeLog.d("GSOLPlayer", "onStop ");
    audioStop();
    if (this.mListener != null)
      this.mListener.onPlayStop();
  }

  public void onVideo(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    postionNotify(paramInt1);
    renderVideo(paramArrayOfByte);
    if (!this.isVideoStart)
    {
      this.isVideoStart = true;
      if (this.mListener != null)
        this.mListener.onVideoStart();
    }
  }

  public void onVideoParam(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    GenseeLog.d("GSOLPlayer", "onVideoParam dwTimeStamp = " + paramInt1 + " dwHeight = " + paramInt3 + " dwWidth = " + paramInt2 + " real = " + paramBoolean);
    if (!paramBoolean);
    do
    {
      return;
      setVideoSize(paramInt2, paramInt3);
    }
    while (this.mListener == null);
    this.mListener.onVideoSize(paramInt1, paramInt2, paramInt3);
  }

  public boolean pause()
  {
    GenseeLog.d("GSOLPlayer", "pause nativePlayer = " + nativePlayer);
    return addTask(new GSOLPlayer.2(this));
  }

  public boolean play(String paramString1, OnOLPlayListener paramOnOLPlayListener, String paramString2)
  {
    if (((paramString1 == null) || ("".equals(paramString1))) && (this.mListener != null))
      this.mListener.onError(6);
    if (paramString1.endsWith(".xml"))
    {
      play(paramString1, paramOnOLPlayListener, "", "", "");
      return true;
    }
    VodObject localVodObject = (VodObject)VodMr.getIns().getVodObjById(paramString1);
    if (localVodObject != null)
      return playOnline(localVodObject, paramOnOLPlayListener, paramString2);
    if (this.mListener != null)
      this.mListener.onError(-201);
    return false;
  }

  public boolean play(String paramString1, OnOLPlayListener paramOnOLPlayListener, String paramString2, String paramString3, String paramString4)
  {
    return play(0L, 0L, "", "", paramString1, paramOnOLPlayListener, paramString2, paramString3, paramString4);
  }

  public boolean playOffline(String paramString, OnOLPlayListener paramOnOLPlayListener)
  {
    return play(paramString, paramOnOLPlayListener, "", "", "");
  }

  public boolean playOnline(VodPlayParam paramVodPlayParam, OnOLPlayListener paramOnOLPlayListener, String paramString)
  {
    if ((paramVodPlayParam instanceof VodParam))
    {
      VodParam localVodParam = (VodParam)paramVodPlayParam;
      String str1 = localVodParam.getXmlUrl();
      String str2 = localVodParam.getVodId();
      String str3 = localVodParam.getTid();
      if ((str1 == null) || (str2 == null) || (str3 == null))
      {
        GenseeLog.w("path = " + str1 + ",vodId = " + str2 + ",tid = " + str3);
        return false;
      }
      long l1 = getLongValue(localVodParam.getSiteId());
      long l2 = getLongValue(localVodParam.getUserId());
      String str4 = VodMr.getVodAlb(localVodParam.getConnectSvr());
      return play(l1, l2, localVodParam.getNickName(), str4, str1, paramOnOLPlayListener, str2, str3, paramString);
    }
    return false;
  }

  public boolean release()
  {
    audioRelease();
    return addTask(new GSOLPlayer.6(this));
  }

  public boolean resume()
  {
    audioResume();
    return addTask(new GSOLPlayer.3(this));
  }

  public boolean seekTo(int paramInt)
  {
    return addTask(new GSOLPlayer.5(this, paramInt));
  }

  public boolean stop()
  {
    audioStop();
    return addTask(new GSOLPlayer.4(this));
  }

  public static abstract interface OnOLPlayListener
  {
    public static final int ERR_INIT_FAILURE = 7;
    public static final int ERR_PAUSE = 2;
    public static final int ERR_PLAY = 1;
    public static final int ERR_RESUME = 3;
    public static final int ERR_SEEK = 5;
    public static final int ERR_STOP = 4;
    public static final int ERR_UN_INVOKE_GETOBJECT = -201;
    public static final int ERR_VODID_OR_LOCALPATH = 6;
    public static final int RESULT_LICENSE = 12;
    public static final int RESULT_OK;

    public abstract void onAudioLevel(int paramInt);

    public abstract void onCaching(boolean paramBoolean);

    public abstract void onError(int paramInt);

    public abstract void onInit(int paramInt1, boolean paramBoolean, int paramInt2, List<DocInfo> paramList);

    public abstract void onPageSize(int paramInt1, int paramInt2, int paramInt3);

    public abstract void onPlayPause();

    public abstract void onPlayResume();

    public abstract void onPlayStop();

    public abstract void onPosition(int paramInt);

    public abstract void onSeek(int paramInt);

    public abstract void onVideoSize(int paramInt1, int paramInt2, int paramInt3);

    public abstract void onVideoStart();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.GSOLPlayer
 * JD-Core Version:    0.6.0
 */