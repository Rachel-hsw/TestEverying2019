package com.gensee.voiceengine;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

class WebRtcAudioRecord
{
  private AudioRecord _audioRecord = null;
  private int _bufferedRecSamples = 0;
  private Context _context;
  private boolean _doRecInit = true;
  private boolean _isRecording = false;
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private byte[] _tempBufRec;
  final String logTag = "WebRTC AD java";

  WebRtcAudioRecord()
  {
    try
    {
      this._recBuffer = ByteBuffer.allocateDirect(960);
      this._tempBufRec = new byte[960];
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

  private int InitRecording(int paramInt1, int paramInt2)
  {
    int i = 2 * AudioRecord.getMinBufferSize(paramInt2, 16, 2);
    this._bufferedRecSamples = (paramInt2 / 200);
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    try
    {
      this._audioRecord = new AudioRecord(1, paramInt2, 16, 2, i);
      if (this._audioRecord.getState() != 1)
        return -1;
    }
    catch (Exception localException)
    {
      DoLog(localException.getMessage());
      return -1;
    }
    return this._bufferedRecSamples;
  }

  private int RecordAudio(int paramInt)
  {
    this._recLock.lock();
    while (true)
    {
      try
      {
        AudioRecord localAudioRecord = this._audioRecord;
        if (localAudioRecord == null)
          return -2;
        boolean bool = this._doRecInit;
        if (!bool)
          continue;
        try
        {
          Process.setThreadPriority(-19);
          this._doRecInit = false;
          this._recBuffer.rewind();
          int i = this._audioRecord.read(this._tempBufRec, 0, paramInt);
          this._recBuffer.put(this._tempBufRec);
          if (i != paramInt)
          {
            this._recLock.unlock();
            return -1;
          }
        }
        catch (Exception localException2)
        {
          DoLog("Set rec thread priority failed: " + localException2.getMessage());
          continue;
        }
      }
      catch (Exception localException1)
      {
        DoLogErr("RecordAudio try failed: " + localException1.getMessage());
        return this._bufferedRecSamples;
      }
      finally
      {
        this._recLock.unlock();
      }
      this._recLock.unlock();
    }
  }

  private int StartRecording()
  {
    try
    {
      this._audioRecord.startRecording();
      this._isRecording = true;
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
    }
    return -1;
  }

  private int StopRecording()
  {
    this._recLock.lock();
    try
    {
      int i = this._audioRecord.getRecordingState();
      if (i == 3);
      try
      {
        this._audioRecord.stop();
        this._audioRecord.release();
        this._audioRecord = null;
        this._doRecInit = true;
        this._recLock.unlock();
        this._isRecording = false;
        return 0;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        this._doRecInit = true;
        this._recLock.unlock();
        return -1;
      }
    }
    finally
    {
      this._doRecInit = true;
      this._recLock.unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.voiceengine.WebRtcAudioRecord
 * JD-Core Version:    0.6.0
 */