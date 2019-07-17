package org.android.spdy;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Ljava.lang.String;>;>;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class SpdyAgent
{
  private static final boolean HAVE_CLOSE = false;
  private static final int KB32 = 32768;
  private static final int KB8 = 8192;
  private static final int MAX_SPDY_SESSION_COUNT = 50;
  private static final int MB5 = 5242880;
  static final int MODE_QUIC = 256;
  static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
  static final int SPDY_DATA_CHUNK_RECV = 4097;
  static final int SPDY_DATA_RECV = 4098;
  static final int SPDY_DATA_SEND = 4099;
  static final int SPDY_PING_RECV = 4101;
  private static final int SPDY_PROTOCAL = 2;
  static final int SPDY_REQUEST_RECV = 4102;
  static final int SPDY_SESSION_CLOSE = 4103;
  static final int SPDY_SESSION_CREATE = 4096;
  static final int SPDY_SESSION_FAILED_ERROR = 4105;
  static final int SPDY_STREAM_CLOSE = 4100;
  static final int SPDY_STREAM_RESPONSE_RECV = 4104;
  public static volatile boolean enableDebug = false;
  public static volatile boolean enableTimeGaurd = false;
  private static SpdyAgent gSingleInstance;
  private static Object lock;
  private static final Lock r;
  private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
  private static final Lock w;
  private long agentNativePtr;
  private AtomicBoolean closed = new AtomicBoolean();
  private String proxyPassword = null;
  private String proxyUsername = null;
  private HashMap<String, SpdySession> sessionMgr = new HashMap(5);
  private LinkedList<SpdySession> sessionQueue = new LinkedList();

  static
  {
    r = rwLock.readLock();
    w = rwLock.writeLock();
    gSingleInstance = null;
    lock = new Object();
  }

  private SpdyAgent(Context paramContext, SpdyVersion paramSpdyVersion, SpdySessionKind paramSpdySessionKind)
    throws UnsatisfiedLinkError
  {
    try
    {
      SoInstallMgrSdk.init(paramContext);
      SoInstallMgrSdk.initSo("tnet-2.1.20.1-agoo", 1);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        while (true)
        {
          this.agentNativePtr = initAgent(paramSpdyVersion.getInt(), paramSpdySessionKind.getint(), 0);
          this.closed.set(false);
          return;
          localThrowable = localThrowable;
          localThrowable.printStackTrace();
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        while (true)
          localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }

  static void InvlidCharJudge(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k;
    for (int i = 0; ; i++)
    {
      int j = paramArrayOfByte1.length;
      k = 0;
      if (i >= j)
        break;
      if (((0xFF & paramArrayOfByte1[i]) >= 32) && ((0xFF & paramArrayOfByte1[i]) <= 126))
        continue;
      paramArrayOfByte1[i] = 63;
    }
    while (k < paramArrayOfByte2.length)
    {
      if (((0xFF & paramArrayOfByte2[k]) < 32) || ((0xFF & paramArrayOfByte2[k]) > 126))
        paramArrayOfByte2[k] = 63;
      k++;
    }
  }

  private void agentIsOpen()
  {
    if (this.closed.get())
      throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", -1104);
  }

  private native int closeSessionN(long paramLong);

  private static void crashReporter(int paramInt)
  {
  }

  private native long createSession(long paramLong, SpdySession paramSpdySession, byte[] paramArrayOfByte1, char paramChar1, byte[] paramArrayOfByte2, char paramChar2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, Object paramObject, int paramInt1, int paramInt2);

  static byte[] dataproviderToByteArray(SpdyRequest paramSpdyRequest, SpdyDataProvider paramSpdyDataProvider)
  {
    headJudge(paramSpdyRequest.getHeaders());
    byte[] arrayOfByte;
    if (paramSpdyDataProvider == null)
      arrayOfByte = null;
    while (true)
    {
      return arrayOfByte;
      String str = mapBodyToString(paramSpdyDataProvider.postBody);
      if (str != null);
      for (arrayOfByte = str.getBytes(); (arrayOfByte != null) && (arrayOfByte.length >= 5242880); arrayOfByte = paramSpdyDataProvider.data)
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + arrayOfByte.length, -1102);
    }
  }

  private native int freeAgent(long paramLong);

  public static SpdyAgent getInstance(Context paramContext, SpdyVersion paramSpdyVersion, SpdySessionKind paramSpdySessionKind)
    throws UnsatisfiedLinkError, SpdyErrorException
  {
    if (gSingleInstance == null);
    synchronized (lock)
    {
      if (gSingleInstance == null)
        gSingleInstance = new SpdyAgent(paramContext, paramSpdyVersion, paramSpdySessionKind);
      return gSingleInstance;
    }
  }

  private native long getSession(long paramLong, byte[] paramArrayOfByte, char paramChar);

  static void headJudge(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        String str2 = (String)localEntry.getValue();
        InvlidCharJudge(str1.getBytes(), str2.getBytes());
        j = i + (1 + str1.length() + str2.length());
        securityCheck(j, str2.length());
      }
    }
  }

  private native long initAgent(int paramInt1, int paramInt2, int paramInt3);

  static String mapBodyToString(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        String str2 = (String)localEntry.getValue();
        localStringBuilder.append(str1).append('=').append(str2).append('&');
        j = i + (1 + str1.length() + str2.length());
        tableListJudge(j);
      }
      if (localStringBuilder.length() > 0)
        localStringBuilder.setLength(-1 + localStringBuilder.length());
      return localStringBuilder.toString();
    }
    return null;
  }

  static String[] mapToByteArray(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0))
      return null;
    String[] arrayOfString = new String[2 * paramMap.size()];
    Iterator localIterator = paramMap.entrySet().iterator();
    for (int i = 0; localIterator.hasNext(); i += 2)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      arrayOfString[i] = ((String)localEntry.getKey());
      arrayOfString[(i + 1)] = ((String)localEntry.getValue());
    }
    return arrayOfString;
  }

  static void securityCheck(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 32768)
      throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + paramInt1, -1102);
    if (paramInt2 >= 8192)
      throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + paramInt2, -1102);
  }

  private native int setConTimeout(long paramLong, int paramInt);

  private native int setSessionKind(long paramLong, int paramInt);

  private void spdyDataChunkRecvCB(SpdySession paramSpdySession, boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
    long l = 0xFFFFFFFF & paramInt1;
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdyDataChunkRecvCB(paramSpdySession, paramBoolean, l, paramArrayOfByte, paramInt2, paramInt3);
  }

  private void spdyDataRecvCallback(SpdySession paramSpdySession, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
    long l = 0xFFFFFFFF & paramInt1;
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdyDataRecvCallback(paramSpdySession, paramBoolean, l, paramInt2, paramInt3);
  }

  private void spdyDataSendCallback(SpdySession paramSpdySession, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = 0xFFFFFFFF & paramInt1;
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdyDataSendCallback(paramSpdySession, paramBoolean, l, paramInt2, paramInt3);
  }

  private void spdyPingRecvCallback(SpdySession paramSpdySession, int paramInt, Object paramObject)
  {
    spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
    long l = 0xFFFFFFFF & paramInt;
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdyPingRecvCallback(paramSpdySession, l, paramObject);
  }

  private void spdyRequestRecvCallback(SpdySession paramSpdySession, int paramInt1, int paramInt2)
  {
    long l = 0xFFFFFFFF & paramInt1;
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdyRequestRecvCallback(paramSpdySession, l, paramInt2);
  }

  private void spdySessionCloseCallback(SpdySession paramSpdySession, Object paramObject, SuperviseConnectInfo paramSuperviseConnectInfo, int paramInt)
  {
    spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = " + paramInt);
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
      return;
    }
    try
    {
      if (paramSpdySession.intenalcb == null)
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
      while (true)
      {
        return;
        paramSpdySession.intenalcb.spdySessionCloseCallback(paramSpdySession, paramObject, paramSuperviseConnectInfo, paramInt);
      }
    }
    finally
    {
      paramSpdySession.cleanUp();
    }
    throw localObject;
  }

  private void spdySessionConnectCB(SpdySession paramSpdySession, SuperviseConnectInfo paramSuperviseConnectInfo)
  {
    spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdySessionConnectCB(paramSpdySession, paramSuperviseConnectInfo);
  }

  private void spdySessionFailedError(SpdySession paramSpdySession, int paramInt, Object paramObject)
  {
    spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
      return;
    }
    try
    {
      if (paramSpdySession.intenalcb == null)
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
      while (true)
      {
        return;
        paramSpdySession.intenalcb.spdySessionFailedError(paramSpdySession, paramInt, paramObject);
      }
    }
    finally
    {
      paramSpdySession.cleanUp();
    }
    throw localObject;
  }

  private void spdyStreamCloseCallback(SpdySession paramSpdySession, int paramInt1, int paramInt2, int paramInt3, SuperviseData paramSuperviseData)
  {
    spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
    long l = 0xFFFFFFFF & paramInt1;
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdyStreamCloseCallback(paramSpdySession, l, paramInt2, paramInt3, paramSuperviseData);
  }

  private void spdyStreamResponseRecv(SpdySession paramSpdySession, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
    Map localMap = stringArrayToMap(paramArrayOfString);
    long l = 0xFFFFFFFF & paramInt1;
    if (paramSpdySession == null)
    {
      spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
      return;
    }
    if (paramSpdySession.intenalcb == null)
    {
      spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
      return;
    }
    paramSpdySession.intenalcb.spdyOnStreamResponse(paramSpdySession, l, localMap, paramInt2);
  }

  static Map<String, List<String>> stringArrayToMap(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
      return null;
    HashMap localHashMap = new HashMap(5);
    for (int i = 0; i + 2 <= paramArrayOfString.length; i += 2)
    {
      if ((paramArrayOfString[i] == null) || (paramArrayOfString[(i + 1)] == null))
        return null;
      Object localObject = (List)localHashMap.get(paramArrayOfString[i]);
      if (localObject == null)
      {
        localObject = new ArrayList(1);
        localHashMap.put(paramArrayOfString[i], localObject);
      }
      ((List)localObject).add(paramArrayOfString[(i + 1)]);
    }
    return (Map<String, List<String>>)localHashMap;
  }

  private native long submitRequest(long paramLong, SpdySession paramSpdySession, byte[] paramArrayOfByte1, char paramChar1, byte[] paramArrayOfByte2, char paramChar2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte paramByte, String[] paramArrayOfString, byte[] paramArrayOfByte6, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);

  static void tableListJudge(int paramInt)
  {
    if (paramInt >= 5242880)
      throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + paramInt, -1102);
  }

  void clearSpdySession(String paramString)
  {
    if (paramString != null)
    {
      w.lock();
      if (paramString == null);
    }
    try
    {
      this.sessionMgr.remove(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    finally
    {
      w.unlock();
    }
    throw localObject;
  }

  public void close()
  {
  }

  int closeSession(long paramLong)
  {
    return closeSessionN(paramLong);
  }

  public int closeSession(String paramString)
  {
    String[] arrayOfString1 = paramString.split("/");
    "0.0.0.0".getBytes();
    if (arrayOfString1.length != 1)
    {
      String[] arrayOfString2 = arrayOfString1[1].split(":");
      arrayOfString2[0].getBytes();
      (char)Integer.parseInt(arrayOfString2[1]);
    }
    while (true)
    {
      agentIsOpen();
      w.lock();
      try
      {
        localSpdySession = (SpdySession)this.sessionMgr.get(paramString);
        if (localSpdySession == null)
        {
          w.unlock();
          return -1;
          paramString = paramString + "/0.0.0.0:0";
        }
      }
      catch (Throwable localThrowable)
      {
        SpdySession localSpdySession;
        while (true)
          localSpdySession = null;
        try
        {
          int i = localSpdySession.closeSession();
          return i;
        }
        finally
        {
          w.unlock();
        }
      }
    }
    throw localObject;
  }

  public SpdySession createSession(String paramString, Object paramObject, SessionCb paramSessionCb)
    throws SpdyErrorException
  {
    if (paramString == null)
      throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM", -1102);
    String[] arrayOfString1 = paramString.split("/");
    String[] arrayOfString2 = arrayOfString1[0].split(":");
    byte[] arrayOfByte1 = "0.0.0.0".getBytes();
    char c1;
    String str;
    if (arrayOfString1.length != 1)
    {
      String[] arrayOfString3 = arrayOfString1[1].split(":");
      arrayOfByte1 = arrayOfString3[0].getBytes();
      c1 = (char)Integer.parseInt(arrayOfString3[1]);
      str = paramString;
    }
    SpdySession localSpdySession1;
    while (true)
    {
      agentIsOpen();
      r.lock();
      try
      {
        localSpdySession1 = (SpdySession)this.sessionMgr.get(str);
        int i = this.sessionMgr.size();
        int j = 0;
        if (i >= 50)
          j = 1;
        r.unlock();
        if (j != 0)
        {
          throw new SpdyErrorException("SPDY_SESSION_EXCEED_MAXED: session count exceed max", -1105);
          str = paramString + "/0.0.0.0:0";
          c1 = '\000';
        }
      }
      finally
      {
        r.unlock();
      }
    }
    return localSpdySession1;
    w.lock();
    try
    {
      localSpdySession2 = (SpdySession)this.sessionMgr.get(str);
      if (localSpdySession2 != null)
      {
        w.unlock();
        return localSpdySession2;
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
        SpdySession localSpdySession2 = null;
    }
    while (true)
    {
      long l2;
      try
      {
        localSpdySession3 = new SpdySession(0L, this, str, paramSessionCb, paramObject);
        if ((this.proxyUsername == null) || (this.proxyPassword == null))
          continue;
        long l4 = this.agentNativePtr;
        byte[] arrayOfByte3 = arrayOfString2[0].getBytes();
        char c3 = (char)Integer.parseInt(arrayOfString2[1]);
        byte[] arrayOfByte4 = this.proxyUsername.getBytes();
        byte[] arrayOfByte5 = this.proxyPassword.getBytes();
        l2 = createSession(l4, localSpdySession3, arrayOfByte3, c3, arrayOfByte1, c1, arrayOfByte4, arrayOfByte5, paramObject, 2, -1);
        spduLog.Logi("tnet-jni", " create new session: " + paramString);
        if ((1L & l2) != 1L)
          break label553;
        l3 = 0L;
        k = (int)(l2 >> 1);
        if (l3 == 0L)
          continue;
        localSpdySession3.setSessionNativePtr(l3);
        this.sessionMgr.put(str, localSpdySession3);
        this.sessionQueue.add(localSpdySession3);
        return localSpdySession3;
        long l1 = this.agentNativePtr;
        byte[] arrayOfByte2 = arrayOfString2[0].getBytes();
        char c2 = (char)Integer.parseInt(arrayOfString2[1]);
        l2 = createSession(l1, localSpdySession3, arrayOfByte2, c2, arrayOfByte1, c1, null, null, paramObject, 2, -1);
        continue;
        if (k != 0)
          throw new SpdyErrorException("create session error: " + k, k);
      }
      finally
      {
        w.unlock();
      }
      SpdySession localSpdySession3 = null;
      continue;
      label553: long l3 = l2;
      int k = 0;
    }
  }

  public SpdySession getSession(SpdyRequest paramSpdyRequest)
    throws SpdyErrorException
  {
    if (paramSpdyRequest == null)
      throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM", -1102);
    agentIsOpen();
    r.lock();
    try
    {
      SpdySession localSpdySession = (SpdySession)this.sessionMgr.get(paramSpdyRequest.getAuthority());
      return localSpdySession;
    }
    finally
    {
      r.unlock();
    }
    throw localObject;
  }

  void removeSession(SpdySession paramSpdySession)
  {
    w.lock();
    try
    {
      this.sessionQueue.remove(paramSpdySession);
      return;
    }
    finally
    {
      w.unlock();
    }
    throw localObject;
  }

  public int setConnectTimeOut(int paramInt)
  {
    agentIsOpen();
    try
    {
      int i = setConTimeout(this.agentNativePtr, paramInt);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return 0;
  }

  public void setProxyUsernamePassword(String paramString1, String paramString2)
  {
    this.proxyUsername = paramString1;
    this.proxyPassword = paramString2;
  }

  public int setSessionKind(SpdySessionKind paramSpdySessionKind)
  {
    agentIsOpen();
    try
    {
      int i = setSessionKind(this.agentNativePtr, paramSpdySessionKind.getint());
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return -1;
  }

  public SpdySession submitRequest(SpdyRequest paramSpdyRequest, SpdyDataProvider paramSpdyDataProvider, Object paramObject1, Object paramObject2, Spdycb paramSpdycb, SessionCb paramSessionCb, int paramInt)
    throws SpdyErrorException
  {
    SpdySession localSpdySession = createSession(paramSpdyRequest.getAuthority(), paramObject1, paramSessionCb);
    localSpdySession.submitRequest(paramSpdyRequest, paramSpdyDataProvider, paramObject2, paramSpdycb);
    return localSpdySession;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.SpdyAgent
 * JD-Core Version:    0.6.0
 */