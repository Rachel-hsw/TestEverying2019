package com.gensee.voiceengine;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

class WebRtcAudioTrack
{
  private AudioManager _audioManager;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private Context _context;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private byte[] _tempBufPlay;
  final String logTag = "WebRTC AD java";

  WebRtcAudioTrack()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(960);
      this._tempBufPlay = new byte[960];
      return;
    }
    catch (Exception localException)
    {
      while (true)
        DoLog(localException.getMessage());
    }
  }

  private void DoLog(String paramString)
  {
    Log.d("WebRTC AD java", paramString);
  }

  private void DoLogErr(String paramString)
  {
    Log.e("WebRTC AD java", paramString);
  }

  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null))
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    int i = -1;
    if (this._audioManager != null)
      i = this._audioManager.getStreamVolume(3);
    return i;
  }

  private int InitPlayback(int paramInt)
  {
    int i = AudioTrack.getMinBufferSize(paramInt, 4, 2);
    if (i < 6000)
      i *= 2;
    this._bufferedPlaySamples = 0;
    if (this._audioTrack != null)
    {
      this._audioTrack.release();
      this._audioTrack = null;
    }
    try
    {
      this._audioTrack = new AudioTrack(3, paramInt, 4, 2, i, 1);
      if (this._audioTrack.getState() != 1)
        return -1;
    }
    catch (Exception localException)
    {
      DoLog(localException.getMessage());
      return -1;
    }
    if ((this._audioManager == null) && (this._context != null))
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    if (this._audioManager == null)
      return 0;
    return this._audioManager.getStreamMaxVolume(3);
  }

  private int PlayAudio(int paramInt)
  {
    this._playLock.lock();
    try
    {
      AudioTrack localAudioTrack = this._audioTrack;
      if (localAudioTrack == null)
        return -2;
      boolean bool = this._doPlayInit;
      if (bool);
      try
      {
        Process.setThreadPriority(-19);
        this._doPlayInit = false;
        this._playBuffer.get(this._tempBufPlay);
        int i = this._audioTrack.write(this._tempBufPlay, 0, paramInt);
        this._playBuffer.rewind();
        this._bufferedPlaySamples += (i >> 1);
        int j = this._audioTrack.getPlaybackHeadPosition();
        if (j < this._playPosition)
          this._playPosition = 0;
        this._bufferedPlaySamples -= j - this._playPosition;
        this._playPosition = j;
        if (i != paramInt)
        {
          this._playLock.unlock();
          return -1;
        }
      }
      catch (Exception localException)
      {
        while (true)
          DoLog("Set play thread priority failed: " + localException.getMessage());
      }
    }
    finally
    {
      this._playLock.unlock();
    }
    this._playLock.unlock();
    return this._bufferedPlaySamples;
  }

  private int SetPlayoutSpeaker(boolean paramBoolean)
  {
    if ((this._audioManager == null) && (this._context != null))
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    if (this._audioManager == null)
    {
      DoLogErr("Could not change audio routing - no audio manager");
      return -1;
    }
    int i = Build.VERSION.SDK_INT;
    if ((3 == i) || (4 == i))
      if (paramBoolean)
        this._audioManager.setMode(0);
    while (true)
    {
      return 0;
      this._audioManager.setMode(2);
      continue;
      if (((Build.BRAND.equals("Samsung")) || (Build.BRAND.equals("samsung"))) && ((5 == i) || (6 == i) || (7 == i)))
      {
        if (paramBoolean)
        {
          this._audioManager.setMode(2);
          this._audioManager.setSpeakerphoneOn(paramBoolean);
          continue;
        }
        this._audioManager.setSpeakerphoneOn(paramBoolean);
        this._audioManager.setMode(0);
        continue;
      }
      this._audioManager.setSpeakerphoneOn(paramBoolean);
    }
  }

  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null))
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(3, paramInt, 0);
      i = 0;
    }
    return i;
  }

  private int StartPlayback()
  {
    try
    {
      this._audioTrack.play();
      this._isPlaying = true;
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
    }
    return -1;
  }

  private int StopPlayback()
  {
    this._playLock.lock();
    try
    {
      int i = this._audioTrack.getPlayState();
      if (i == 3);
      try
      {
        this._audioTrack.stop();
        this._audioTrack.flush();
        this._audioTrack.release();
        this._audioTrack = null;
        this._doPlayInit = true;
        this._playLock.unlock();
        this._isPlaying = false;
        return 0;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        this._doPlayInit = true;
        this._playLock.unlock();
        return -1;
      }
    }
    finally
    {
      this._doPlayInit = true;
      this._playLock.unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.voiceengine.WebRtcAudioTrack
 * JD-Core Version:    0.6.0
 */