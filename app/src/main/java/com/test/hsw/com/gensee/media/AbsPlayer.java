package com.gensee.media;

import android.media.AudioTrack;
import android.os.Handler;
import com.gensee.heartbeat.GSWork;
import com.gensee.parse.AnnotaionParse;
import com.gensee.pdu.AbsAnno;
import com.gensee.pdu.GSDocView;
import com.gensee.pdu.PduPage;
import com.gensee.utils.GenseeLog;
import com.gensee.view.GSDocViewGx;
import com.gensee.view.IVideoIndication;
import java.io.File;
import java.util.LinkedList;

public class AbsPlayer extends GSWork
{
  private static final String TAG = "AbsPlayer";
  private int audioEncoding = 2;
  protected String cachDir;
  private int channelConfig = 2;
  private int frequence = 16000;
  private int mAudioQueueSize = 0;
  protected GSDocView mDocView;
  protected GSDocViewGx mGlDocView;
  private Handler mHandler;
  protected PduPage mPage;
  private SynThread mSynThread;
  private AudioTrack mTrack;
  private int mVideoHeight;
  protected IVideoIndication mVideoView;
  private int mVideoWidth;
  private int nPlayerType = 0;
  protected long nativeSink;
  protected AnnotaionParse parse;

  private boolean addAnno(AbsAnno paramAbsAnno)
  {
    int i = this.mPage.addAnno(paramAbsAnno, false);
    if (i != -1)
    {
      if (paramAbsAnno.getType() != 16)
        break label44;
      removeMessages(136);
      sendMessageDelayed(136, paramAbsAnno, 100L);
    }
    label44: 
    do
    {
      return false;
      if (i != 0)
        continue;
      sendMessage(136, paramAbsAnno);
      return false;
    }
    while (i != 1);
    sendMessage(141, paramAbsAnno);
    return false;
  }

  private boolean audioDataWrite(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramInt > 0) && (this.mTrack != null) && (3 == this.mTrack.getPlayState()))
      this.mTrack.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    return true;
  }

  private String checkPng(String paramString)
  {
    if ((paramString != null) && (paramString.endsWith(".png.1")) && (!new File(paramString).exists()))
      paramString = paramString.substring(0, -2 + paramString.length());
    return paramString;
  }

  private boolean cleanAnno(AbsAnno paramAbsAnno)
  {
    if (this.mPage.delAnno(paramAbsAnno))
    {
      if (this.mHandler != null)
        sendMessage(144, null);
      return true;
    }
    return false;
  }

  private void setHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }

  protected boolean audioDataPlay(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null);
    do
      return false;
    while (this.mSynThread == null);
    return this.mSynThread.putPkg(new AudioPkg(0L, paramArrayOfByte, null));
  }

  protected void audioPause()
  {
    if ((this.mTrack != null) && (3 == this.mTrack.getPlayState()))
    {
      this.mTrack.pause();
      GenseeLog.d("audioPause pause mTrack.pause()");
    }
  }

  protected void audioRelease()
  {
    SynThread localSynThread = this.mSynThread;
    this.mSynThread = null;
    if (localSynThread != null)
      localSynThread.release();
    if (this.mTrack != null)
      this.mTrack.release();
    this.mTrack = null;
  }

  protected void audioResume()
  {
    if ((this.mTrack != null) && (2 == this.mTrack.getPlayState()))
    {
      this.mTrack.play();
      GenseeLog.d("audioResume mTrack.play()");
    }
  }

  protected void audioStop()
  {
    if ((this.mTrack != null) && (1 != this.mTrack.getPlayState()))
      this.mTrack.stop();
  }

  protected void drawAnno(AbsAnno paramAbsAnno)
  {
    switch (paramAbsAnno.getType())
    {
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    default:
    case 16:
    case 3:
    case 1:
    case 9:
      do
      {
        return;
        addAnno(paramAbsAnno);
        return;
        cleanAnno(paramAbsAnno);
        return;
      }
      while ((!this.mPage.changePoint(paramAbsAnno)) || (this.mHandler == null));
      removeMessages(135);
      sendMessage(135, null);
      return;
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    addAnno(paramAbsAnno);
  }

  protected int getAudioQueueLen()
  {
    return this.mAudioQueueSize;
  }

  protected int getAudioState()
  {
    if (this.mTrack == null)
      return -1;
    return this.mTrack.getPlayState();
  }

  protected int getIntValue(String paramString)
  {
    if (paramString != null)
      try
      {
        int i = Integer.valueOf(paramString).intValue();
        return i;
      }
      catch (Exception localException)
      {
        GenseeLog.w(localException.toString());
      }
    return 0;
  }

  protected long getLongValue(String paramString)
  {
    if (paramString != null)
      try
      {
        long l = Long.valueOf(paramString).longValue();
        return l;
      }
      catch (Exception localException)
      {
        GenseeLog.w(localException.toString());
      }
    return 0L;
  }

  protected void initAudioPlayer()
  {
    if (this.mSynThread == null)
    {
      this.mSynThread = new SynThread("AudioSynThread");
      this.mSynThread.start();
    }
    if (this.mTrack == null)
    {
      this.frequence = 16000;
      this.frequence = AudioTrack.getNativeOutputSampleRate(3);
      int i = AudioTrack.getMinBufferSize(this.frequence, this.channelConfig, this.audioEncoding);
      this.mTrack = new AudioTrack(3, this.frequence, this.channelConfig, this.audioEncoding, i, 1);
    }
    if (3 != this.mTrack.getPlayState())
      this.mTrack.play();
  }

  protected void post(Runnable paramRunnable)
  {
    if (this.mHandler != null)
    {
      this.mHandler.post(paramRunnable);
      return;
    }
    GenseeLog.w("AbsPlayer post faild");
  }

  protected void removeMessages(int paramInt)
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(paramInt);
      return;
    }
    GenseeLog.w("AbsPlayer there is a msg " + paramInt + " arived,but the ui handler is null");
  }

  protected void renderAnno(String paramString)
  {
    if (this.mPage == null)
      return;
    if (this.parse == null)
      this.parse = new AnnotaionParse();
    AbsAnno localAbsAnno = this.parse.parseAnnoXml(paramString);
    if (localAbsAnno == null)
    {
      GenseeLog.w("onAnnotaion anno is null!");
      return;
    }
    drawAnno(localAbsAnno);
  }

  protected void renderPage(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mPage != null)
      this.mPage.clear();
    this.mPage = new PduPage();
    if (this.nPlayerType == 0)
    {
      this.mPage.setSdkType(1);
      this.mPage.setPageId((int)System.currentTimeMillis());
      this.mPage.setImgWidth((short)paramInt1);
      this.mPage.setImgHeight((short)paramInt2);
      if (paramString == null)
        break label115;
      this.mPage.setPath(checkPng(paramString));
    }
    while (true)
    {
      if (this.mDocView != null)
        this.mDocView.setDocPage(this.mPage);
      return;
      this.mPage.setSdkType(2);
      break;
      label115: GenseeLog.w("renderPage path data is null");
    }
  }

  protected void renderPage(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.mPage != null)
      this.mPage.clear();
    this.mPage = new PduPage();
    if (this.nPlayerType == 0)
    {
      this.mPage.setSdkType(1);
      this.mPage.setPageId((int)System.currentTimeMillis());
      this.mPage.setImgWidth((short)paramInt1);
      this.mPage.setImgHeight((short)paramInt2);
      if (paramString1 == null)
        break label124;
      this.mPage.setPath(checkPng(paramString1));
      this.mPage.setAnimationPath(paramString2);
    }
    while (true)
    {
      if (this.mHandler != null)
        sendMessage(138, this.mPage);
      return;
      this.mPage.setSdkType(2);
      break;
      label124: GenseeLog.w("renderPage path data is null");
    }
  }

  protected void renderPage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte != null) && (paramInt1 > 0))
    {
      renderPage(new String(paramArrayOfByte), paramInt2, paramInt3);
      return;
    }
    GenseeLog.w("renderPage data is null");
  }

  protected void renderPage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramInt1 > 0))
    {
      String str = new String(paramArrayOfByte);
      renderPage(str, paramInt2, paramInt3, paramString);
      GenseeLog.d("AbsPlayer", "renderPage swf swfpath = " + str + " sAnimationPath = " + paramString);
      return;
    }
    GenseeLog.w("renderPage data is null");
  }

  protected void renderPageAnimation(int paramInt)
  {
    if ((this.mHandler != null) && (this.mPage != null))
    {
      this.mPage.setAniStep(paramInt);
      sendMessage(142, this.mPage);
    }
  }

  protected void renderVideo(byte[] paramArrayOfByte)
  {
    if (this.mVideoView != null)
      if (paramArrayOfByte != null)
        break label64;
    label64: for (int i = 0; i == 0; i = paramArrayOfByte.length)
    {
      GenseeLog.w("renderVideo fail , videoData length err " + i + " w = " + this.mVideoWidth + " h = " + this.mVideoHeight);
      return;
    }
    this.mVideoView.onReceiveFrame(paramArrayOfByte, this.mVideoWidth, this.mVideoHeight);
  }

  protected void sendMessage(int paramInt, Object paramObject)
  {
    if (this.mHandler != null)
    {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(paramInt, paramObject));
      return;
    }
    GenseeLog.w("AbsPlayer there is a msg " + paramInt + " arived,but the ui handler is null");
  }

  protected void sendMessageDelayed(int paramInt, Object paramObject, long paramLong)
  {
    if (this.mHandler != null)
    {
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(paramInt, paramObject), paramLong);
      return;
    }
    GenseeLog.w("AbsPlayer there is a msg " + paramInt + " arived,but the ui handler is null");
  }

  public void setDocView(GSDocView paramGSDocView)
  {
    setGSDocView(paramGSDocView);
  }

  public void setGSDocView(GSDocView paramGSDocView)
  {
    this.mDocView = paramGSDocView;
    if (this.mDocView != null)
    {
      setHandler(this.mDocView.getHandler());
      if (this.mPage != null)
        this.mDocView.setDocPage(this.mPage);
      return;
    }
    setHandler(null);
  }

  public void setGSDocViewGx(GSDocViewGx paramGSDocViewGx)
  {
    this.mGlDocView = paramGSDocViewGx;
    if (this.mGlDocView != null)
    {
      setHandler(this.mGlDocView.getHandler());
      if (this.mPage != null)
        sendMessage(138, this.mPage);
      return;
    }
    setHandler(null);
  }

  public void setGSVideoView(IVideoIndication paramIVideoIndication)
  {
    this.mVideoView = paramIVideoIndication;
  }

  protected void setPlayerType(int paramInt)
  {
    this.nPlayerType = paramInt;
  }

  protected void setVideoSize(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }

  private class AudioPkg
  {
    private byte[] buffer;

    private AudioPkg(long arg2, byte[] arg4)
    {
      Object localObject;
      this.buffer = localObject;
    }
  }

  public class PlayerType
  {
    public static final int RTMP_PLAYER_TYPE = 0;
    public static final int VOD_PLAYER_TYPE = 1;

    public PlayerType()
    {
    }
  }

  private class SynThread extends Thread
  {
    LinkedList<AbsPlayer.AudioPkg> audioQue = new LinkedList();
    private boolean isRunning = false;
    private Object lock = new Object();

    public SynThread(String arg2)
    {
      super();
    }

    public boolean putPkg(AbsPlayer.AudioPkg paramAudioPkg)
    {
      synchronized (this.lock)
      {
        boolean bool = this.audioQue.add(paramAudioPkg);
        AbsPlayer.this.mAudioQueueSize = this.audioQue.size();
        this.lock.notifyAll();
        return bool;
      }
    }

    public void release()
    {
      this.isRunning = false;
      synchronized (this.lock)
      {
        this.audioQue.clear();
        this.lock.notifyAll();
        return;
      }
    }

    public void run()
    {
      this.isRunning = true;
      this.audioQue.clear();
      while (true)
      {
        if (!this.isRunning)
          return;
        synchronized (this.lock)
        {
          AbsPlayer.this.mAudioQueueSize = this.audioQue.size();
          int i = AbsPlayer.this.mAudioQueueSize;
          if (i == 0)
            try
            {
              this.lock.wait();
              localAudioPkg = null;
              if ((localAudioPkg == null) || (localAudioPkg.buffer == null))
                continue;
              AbsPlayer.this.audioDataWrite(localAudioPkg.buffer, localAudioPkg.buffer.length);
            }
            catch (InterruptedException localInterruptedException)
            {
              while (true)
              {
                localInterruptedException.printStackTrace();
                localAudioPkg = null;
              }
            }
          AbsPlayer.AudioPkg localAudioPkg = (AbsPlayer.AudioPkg)this.audioQue.pop();
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.AbsPlayer
 * JD-Core Version:    0.6.0
 */