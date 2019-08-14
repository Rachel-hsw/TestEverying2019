package com.bokecc.sdk.mobile.play;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import com.bokecc.sdk.mobile.util.HttpUtil;
import com.bokecc.sdk.mobile.util.HttpUtil.HttpLogLevel;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnErrorListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DWSpeedMediaPlayer extends MediaPlayer
{
  public static final Integer HIGH_DEFINITION;
  public static final Integer NORMAL_DEFINITION = Integer.valueOf(10);
  private Context R;
  private boolean ak = false;
  private String al;
  private final String am = "http://express.play.bokecc.com";
  private final String an = "转码中";
  private c ao;
  private boolean ap = false;
  private TreeMap<Integer, d> aq;
  private int ar;
  private String as;
  private Integer au;
  private boolean av = false;
  private MediaPlayer.OnErrorListener ax;
  private String h;
  private String i;
  private String j;
  private Thread m;

  static
  {
    HIGH_DEFINITION = Integer.valueOf(20);
  }

  public DWSpeedMediaPlayer(Context paramContext)
  {
    super(paramContext);
  }

  private Map<String, String> a(String paramString1, String paramString2, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", "20140214");
    localHashMap.put("videoid", paramString1);
    localHashMap.put("userid", paramString2);
    localHashMap.put("dt", Build.MODEL);
    localHashMap.put("osversion", Build.VERSION.SDK_INT + "");
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    int k = localWindowManager.getDefaultDisplay().getWidth();
    int n = localWindowManager.getDefaultDisplay().getHeight();
    localHashMap.put("sw", k + "");
    localHashMap.put("sh", n + "");
    localHashMap.put("sn", getSerialNumber());
    if (Build.VERSION.SDK_INT >= 10)
    {
      localHashMap.put("hlssupport", "1");
      return localHashMap;
    }
    localHashMap.put("hlssupport", "0");
    return localHashMap;
  }

  private void a(Context paramContext, int paramInt)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    if (this.aq.containsKey(Integer.valueOf(paramInt)));
    String str;
    d locald;
    for (Map.Entry localEntry = ((d)this.aq.get(Integer.valueOf(paramInt))).b().firstEntry(); ; localEntry = locald.b().firstEntry())
    {
      this.ao.b(paramInt);
      this.ao.c(((Integer)localEntry.getKey()).intValue());
      str = (String)localEntry.getValue() + "&version=" + HttpUtil.urlEncode(HttpUtil.SDK_VERSION);
      if (HttpUtil.LOG_LEVEL == HttpUtil.HttpLogLevel.DETAIL)
        Log.i("play url", str);
      if (str.indexOf(".pcm") >= 0)
        break;
      d(str);
      return;
      paramInt = ((Integer)this.aq.firstKey()).intValue();
      locald = (d)this.aq.firstEntry().getValue();
      if ((locald != null) && (!locald.b().isEmpty()))
        continue;
      Log.e("DWMediaPlayer", "视频无播放节点，请检查视频状态。");
      return;
    }
    this.as = str;
    p();
  }

  private void a(Map<String, String> paramMap, String paramString)
    throws DreamwinException
  {
    this.ak = false;
    c localc1 = new c();
    TreeMap localTreeMap = new TreeMap();
    String str;
    c localc2;
    JSONException localJSONException2;
    try
    {
      str = HttpUtil.getResult("http://p.bokecc.com/servlet/app/playinfo", paramMap, paramString);
      if (str == null)
        throw new DreamwinException(ErrorCode.NETWORK_ERROR, new String[] { "Http Connection Fail." });
    }
    catch (JSONException localJSONException1)
    {
      localc2 = localc1;
      localJSONException2 = localJSONException1;
    }
    while (true)
    {
      Log.e("PlayInfo", localJSONException2.getMessage());
      while (true)
      {
        if (this.au != null)
          localc2.a(this.au.intValue());
        this.ao = localc2;
        this.aq = localTreeMap;
        label110: return;
        JSONObject localJSONObject1 = new JSONObject(str);
        if (localJSONObject1.isNull("response"))
        {
          ErrorCode localErrorCode2 = ErrorCode.PROCESS_FAIL;
          String[] arrayOfString2 = new String[1];
          arrayOfString2[0] = ("Http Response Error. " + str);
          throw new DreamwinException(localErrorCode2, arrayOfString2);
        }
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("response");
        if (localJSONObject2.getInt("result") == 0)
        {
          ErrorCode localErrorCode1 = ErrorCode.INVALID_REQUEST;
          String[] arrayOfString1 = new String[1];
          arrayOfString1[0] = ("Invalid Request. " + str);
          throw new DreamwinException(localErrorCode1, arrayOfString1);
        }
        localc2 = new c(localJSONObject1);
        try
        {
          if (("转码中".equals(localJSONObject2.getJSONObject("video").getString("statusinfo"))) && (PlayConfig.REALTIME_UIDS.contains(this.i)))
          {
            this.ak = true;
            this.al = ("http://express.play.bokecc.com/" + this.i + "/" + this.h + ".mp4");
            if (HttpUtil.LOG_LEVEL != HttpUtil.HttpLogLevel.DETAIL)
              break label110;
            Log.i("play url", this.al);
            return;
          }
          JSONArray localJSONArray = localJSONObject2.getJSONArray("qualities");
          for (int k = 0; k < localJSONArray.length(); k++)
          {
            JSONObject localJSONObject3 = localJSONArray.getJSONObject(k);
            d locald = new d(localJSONObject3);
            localTreeMap.put(Integer.valueOf(localJSONObject3.getInt("quality")), locald);
          }
        }
        catch (JSONException localJSONException3)
        {
        }
      }
    }
  }

  private boolean c(ErrorCode paramErrorCode)
  {
    if (this.ax == null)
      return false;
    return this.ax.onError(this, paramErrorCode.Value(), -1);
  }

  private void d(String paramString)
    throws IllegalStateException, IOException
  {
    if (this.av)
      return;
    super.setDataSource(this.R, Uri.parse(paramString));
    if (this.ap)
    {
      super.prepareAsync();
      return;
    }
    super.prepare();
  }

  private String getSerialNumber()
  {
    if (Build.VERSION.SDK_INT > 8)
      return Build.SERIAL;
    try
    {
      Method localMethod = Class.forName("android.os.Build").getDeclaredMethod("getString", new Class[] { Class.forName("java.lang.String") });
      if (!localMethod.isAccessible())
        localMethod.setAccessible(true);
      String str = (String)localMethod.invoke(new Build(), new Object[] { "ro.serialno" });
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("SerialNumber Error", localIllegalAccessException.getMessage());
      return "";
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.e("SerialNumber Error", localInvocationTargetException.getMessage());
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        Log.e("SerialNumber Error", localNoSuchMethodException.getMessage());
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        Log.e("SerialNumber Error", localClassNotFoundException.getMessage());
    }
  }

  private void o()
  {
    if (this.av);
    do
      return;
    while ((this.m != null) && (this.m.isAlive()));
    this.m = new Thread(new b(this));
    this.m.start();
  }

  private void p()
    throws IllegalArgumentException, SecurityException, IllegalStateException, IOException
  {
    if (this.ar == -1)
      return;
    this.as = "http://127.0.0.1:".concat(this.ar + "/?").concat("url=").concat(HttpUtil.urlEncode(this.as));
    d(this.as);
  }

  public int getDefinitionCode()
  {
    if (this.ao == null)
      return ErrorCode.PROCESS_FAIL.Value();
    return this.ao.d();
  }

  public Map<String, Integer> getDefinitions()
  {
    HashMap localHashMap1 = new HashMap();
    if (this.ak)
    {
      localHashMap1.put("原画质", Integer.valueOf(10));
      return localHashMap1;
    }
    if (this.aq == null)
      return null;
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = this.aq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap2.put(((d)localEntry.getValue()).a(), localEntry.getKey());
    }
    return localHashMap2;
  }

  public String getVideoStatusInfo()
  {
    if (this.ao == null)
      return null;
    return this.ao.a();
  }

  public String getVideoTitle()
  {
    if (this.ao == null)
      return null;
    return this.ao.b();
  }

  public void prepare()
    throws IllegalStateException, IOException
  {
    this.ap = false;
    this.av = false;
    if (this.as != null)
    {
      p();
      return;
    }
    if (this.h == null)
    {
      Log.i("DWMediaPlayer", "local play.");
      super.prepare();
      return;
    }
    o();
  }

  public void prepareAsync()
    throws IllegalStateException
  {
    this.ap = true;
    this.av = false;
    if (this.as != null)
      try
      {
        p();
        return;
      }
      catch (IOException localIOException)
      {
        Log.e("DWMediaPlayer error", localIOException.getMessage());
        return;
      }
    if (this.h == null)
    {
      Log.i("DWMediaPlayer", "local play.");
      super.prepareAsync();
      return;
    }
    o();
  }

  public void setDRMServerPort(int paramInt)
  {
    this.ar = paramInt;
  }

  // ERROR //
  public void setDRMVideoPath(String paramString, Context paramContext)
    throws IllegalArgumentException, SecurityException, IllegalStateException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: putfield 396	com/bokecc/sdk/mobile/play/DWSpeedMediaPlayer:R	Landroid/content/Context;
    //   5: aload_1
    //   6: ldc 241
    //   8: invokevirtual 557	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   11: ifne +14 -> 25
    //   14: ldc_w 258
    //   17: ldc_w 559
    //   20: invokestatic 263	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: return
    //   25: new 561	java/io/FileInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 562	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 565	java/io/FileInputStream:available	()I
    //   38: ifgt +17 -> 55
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 567	io/vov/vitamio/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   46: aload_3
    //   47: ifnull -23 -> 24
    //   50: aload_3
    //   51: invokevirtual 570	java/io/FileInputStream:close	()V
    //   54: return
    //   55: iconst_3
    //   56: newarray byte
    //   58: astore 8
    //   60: aload_3
    //   61: aload 8
    //   63: invokevirtual 574	java/io/FileInputStream:read	([B)I
    //   66: pop
    //   67: ldc_w 576
    //   70: new 212	java/lang/String
    //   73: dup
    //   74: aload 8
    //   76: invokespecial 579	java/lang/String:<init>	([B)V
    //   79: invokevirtual 350	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifne +17 -> 99
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 567	io/vov/vitamio/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   90: aload_3
    //   91: ifnull -67 -> 24
    //   94: aload_3
    //   95: invokevirtual 570	java/io/FileInputStream:close	()V
    //   98: return
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 570	java/io/FileInputStream:close	()V
    //   107: aload_0
    //   108: aload_1
    //   109: putfield 265	com/bokecc/sdk/mobile/play/DWSpeedMediaPlayer:as	Ljava/lang/String;
    //   112: return
    //   113: astore 4
    //   115: aconst_null
    //   116: astore_3
    //   117: ldc_w 581
    //   120: new 100	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   127: aload 4
    //   129: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: ldc 112
    //   134: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 263	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   143: pop
    //   144: aload_0
    //   145: getstatic 321	com/bokecc/sdk/mobile/exception/ErrorCode:PROCESS_FAIL	Lcom/bokecc/sdk/mobile/exception/ErrorCode;
    //   148: invokespecial 393	com/bokecc/sdk/mobile/play/DWSpeedMediaPlayer:c	(Lcom/bokecc/sdk/mobile/exception/ErrorCode;)Z
    //   151: pop
    //   152: aload_3
    //   153: ifnull -129 -> 24
    //   156: aload_3
    //   157: invokevirtual 570	java/io/FileInputStream:close	()V
    //   160: return
    //   161: astore 5
    //   163: aconst_null
    //   164: astore_3
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 570	java/io/FileInputStream:close	()V
    //   173: aload 5
    //   175: athrow
    //   176: astore 5
    //   178: goto -13 -> 165
    //   181: astore 4
    //   183: goto -66 -> 117
    //
    // Exception table:
    //   from	to	target	type
    //   25	34	113	java/lang/Exception
    //   25	34	161	finally
    //   34	46	176	finally
    //   55	90	176	finally
    //   117	152	176	finally
    //   34	46	181	java/lang/Exception
    //   55	90	181	java/lang/Exception
  }

  public void setDefaultDefinition(Integer paramInteger)
  {
    this.au = paramInteger;
  }

  public void setDefinition(Context paramContext, int paramInt)
    throws IOException
  {
    this.ap = true;
    this.av = false;
    if (this.ak)
    {
      d(this.al);
      return;
    }
    a(paramContext, paramInt);
  }

  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.ax = paramOnErrorListener;
    super.setOnErrorListener(paramOnErrorListener);
  }

  public void setPlaybackSpeed(float paramFloat)
  {
    if ((paramFloat > 2.0F) || (paramFloat < 0.5F))
      return;
    super.setPlaybackSpeed(paramFloat);
  }

  public void setVideoPlayInfo(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.R = paramContext;
  }

  public void stop()
  {
    super.stop();
    this.as = null;
    this.av = true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.play.DWSpeedMediaPlayer
 * JD-Core Version:    0.6.0
 */