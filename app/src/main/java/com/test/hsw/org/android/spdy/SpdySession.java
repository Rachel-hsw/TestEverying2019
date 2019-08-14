package org.android.spdy;

import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.message.b.cr;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SpdySession
{
  private static volatile int count = 0;
  private SpdyAgent agent;
  private String authority;
  private AtomicBoolean closed = new AtomicBoolean();
  private Handler handler;
  Intenalcb intenalcb;
  private Object lock = new Object();
  public SessionCb sessionCallBack = null;
  private boolean sessionClearedFromSessionMgr = false;
  private volatile long sessionNativePtr;
  private NetSparseArray<SpdyStreamContext> spdyStream = null;
  private int streamcount = 1;
  private HandlerThread thread;
  private Object userData = null;

  SpdySession(long paramLong, SpdyAgent paramSpdyAgent, String paramString, SessionCb paramSessionCb, Object paramObject)
  {
    this.sessionNativePtr = paramLong;
    this.agent = paramSpdyAgent;
    this.authority = paramString;
    this.intenalcb = new cr();
    this.spdyStream = new NetSparseArray(5);
    this.sessionCallBack = paramSessionCb;
    this.userData = paramObject;
    this.closed.set(false);
  }

  private int closeprivate()
  {
    synchronized (this.lock)
    {
      if (!this.sessionClearedFromSessionMgr)
      {
        this.agent.clearSpdySession(this.authority);
        this.sessionClearedFromSessionMgr = true;
      }
      this.sessionNativePtr = 0L;
    }
    synchronized (this.lock)
    {
      this.spdyStream.clear();
      return 0;
      localObject2 = finally;
      monitorexit;
      throw localObject2;
    }
  }

  private native int sendHeadersN(long paramLong, int paramInt, String[] paramArrayOfString, boolean paramBoolean);

  private native int setOptionN(long paramLong, int paramInt1, int paramInt2);

  private native int streamCloseN(long paramLong, int paramInt1, int paramInt2);

  private native int streamSendDataN(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean);

  private native int submitPingN(long paramLong);

  private native int submitRequestN(long paramLong, String paramString, byte paramByte, String[] paramArrayOfString, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt1, int paramInt2);

  public int cleanUp()
  {
    spduLog.Logd("tnet-jni", "[SpdySession.cleanUp] - ");
    boolean bool = this.closed.getAndSet(true);
    int i = 0;
    if (!bool)
    {
      this.agent.removeSession(this);
      i = closeprivate();
    }
    return i;
  }

  public void clearAllStreamCb()
  {
    spduLog.Logd("tnet-jni", "[SpdySession.clearAllStreamCb] - ");
    synchronized (this.lock)
    {
      this.spdyStream.clear();
      return;
    }
  }

  int closeInternal()
  {
    boolean bool = this.closed.getAndSet(true);
    int i = 0;
    if (!bool)
      i = closeprivate();
    return i;
  }

  public int closeSession()
  {
    spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ");
    while (true)
    {
      synchronized (this.lock)
      {
        if (!this.sessionClearedFromSessionMgr)
        {
          spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - " + this.authority);
          this.agent.clearSpdySession(this.authority);
          this.sessionClearedFromSessionMgr = true;
          try
          {
            int j = this.agent.closeSession(this.sessionNativePtr);
            i = j;
            return i;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            localUnsatisfiedLinkError.printStackTrace();
          }
        }
      }
      int i = 0;
    }
  }

  public SpdyStreamContext[] getAllStreamCb()
  {
    synchronized (this.lock)
    {
      int i = this.spdyStream.size();
      SpdyStreamContext[] arrayOfSpdyStreamContext = null;
      if (i > 0)
      {
        arrayOfSpdyStreamContext = new SpdyStreamContext[i];
        this.spdyStream.toArray(arrayOfSpdyStreamContext);
      }
      return arrayOfSpdyStreamContext;
    }
  }

  public String getAuthority()
  {
    return this.authority;
  }

  Handler getMsgHandler()
  {
    return this.handler;
  }

  long getSessionNativePtr()
  {
    return this.sessionNativePtr;
  }

  SpdyAgent getSpdyAgent()
  {
    return this.agent;
  }

  public SpdyStreamContext getSpdyStream(int paramInt)
  {
    if (paramInt > 0)
      synchronized (this.lock)
      {
        SpdyStreamContext localSpdyStreamContext = (SpdyStreamContext)this.spdyStream.get(paramInt);
        return localSpdyStreamContext;
      }
    return null;
  }

  public Object getUserData()
  {
    return this.userData;
  }

  int putSpdyStreamCtx(SpdyStreamContext paramSpdyStreamContext)
  {
    synchronized (this.lock)
    {
      int i = this.streamcount;
      this.streamcount = (i + 1);
      this.spdyStream.put(i, paramSpdyStreamContext);
      return i;
    }
  }

  public void removeSpdyStream(int paramInt)
  {
    if (paramInt > 0)
      synchronized (this.lock)
      {
        this.spdyStream.remove(paramInt);
        return;
      }
  }

  void sessionIsOpen()
  {
    if (this.closed.get())
      throw new SpdyErrorException("session is already closed: -1104", -1104);
  }

  public int setOption(int paramInt1, int paramInt2)
    throws SpdyErrorException
  {
    sessionIsOpen();
    int i = setOptionN(this.sessionNativePtr, paramInt1, paramInt2);
    if (i != 0)
      throw new SpdyErrorException("setOption error: " + i, i);
    return i;
  }

  void setSessionNativePtr(long paramLong)
  {
    this.sessionNativePtr = paramLong;
  }

  public int streamReset(long paramLong, int paramInt)
    throws SpdyErrorException
  {
    sessionIsOpen();
    spduLog.Logd("tnet-jni", "[SpdySession.streamReset] - ");
    int i = streamCloseN(this.sessionNativePtr, (int)paramLong, paramInt);
    if (i != 0)
      throw new SpdyErrorException("streamReset error: " + i, i);
    return i;
  }

  public int submitPing()
    throws SpdyErrorException
  {
    sessionIsOpen();
    int i = submitPingN(this.sessionNativePtr);
    if (i != 0)
      throw new SpdyErrorException("submitPing error: " + i, i);
    return i;
  }

  public int submitRequest(SpdyRequest paramSpdyRequest, SpdyDataProvider paramSpdyDataProvider, Object paramObject, Spdycb paramSpdycb)
    throws SpdyErrorException
  {
    if ((paramSpdyRequest == null) || (paramObject == null) || (paramSpdyRequest.getAuthority() == null))
      throw new SpdyErrorException("submitRequest error: -1102", -1102);
    sessionIsOpen();
    byte[] arrayOfByte = SpdyAgent.dataproviderToByteArray(paramSpdyRequest, paramSpdyDataProvider);
    if ((arrayOfByte != null) && (arrayOfByte.length <= 0))
      arrayOfByte = null;
    boolean bool = true;
    if (paramSpdyDataProvider != null)
      bool = paramSpdyDataProvider.finished;
    if (!paramSpdyRequest.getAuthority().equals(this.authority))
      throw new SpdyErrorException("submitPing error: -1102", -1102);
    int i = putSpdyStreamCtx(new SpdyStreamContext(paramObject, paramSpdycb));
    String[] arrayOfString = SpdyAgent.mapToByteArray(paramSpdyRequest.getHeaders());
    spduLog.Logi("tnet-jni", "index=" + i + "  " + "starttime=" + System.currentTimeMillis());
    int j = submitRequestN(this.sessionNativePtr, paramSpdyRequest.getUrlPath(), (byte)paramSpdyRequest.getPriority(), arrayOfString, arrayOfByte, bool, i, paramSpdyRequest.getRequestTimeoutMs());
    spduLog.Logi("tnet-jni", "index=" + i + "  " + " calltime=" + System.currentTimeMillis());
    if (j < 0)
      removeSpdyStream(i);
    if (j != 0)
      throw new SpdyErrorException("submitRequest error: " + j, j);
    return j;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.SpdySession
 * JD-Core Version:    0.6.0
 */