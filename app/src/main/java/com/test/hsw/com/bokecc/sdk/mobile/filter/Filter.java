package com.bokecc.sdk.mobile.filter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter
{
  private static Filter P;
  private static Context R;
  private a Q;
  private FilterExecuteAsyncTaskListener S;
  private int T = 480;
  private String U = " lutyuv='u=128:v=128' ";
  private String V = " mp=eq2=1.0:2:0.5 ";
  private String W = " hue='h=60:s=-3' ";
  private String X = " tile=3x2:nb_frames=5:padding=7:margin=2 ";
  private String Y = " crop=2/3*in_w:2/3*in_h ";
  private String Z = " boxblur=luma_radius=min(h\\,w)/80:luma_power=1:chroma_radius=min(cw\\,ch)/80:chroma_power=1 ";
  private String aa = " fade=in:0:40 ";
  private String ab = " lutyuv=y=negval ";

  private String a(File paramFile)
    throws IOException
  {
    int[] arrayOfInt = b(paramFile);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
      throw new IOException("获取视频宽高失败");
    if (arrayOfInt[1] > arrayOfInt[0])
    {
      int j = arrayOfInt[0];
      arrayOfInt[0] = arrayOfInt[1];
      arrayOfInt[1] = j;
    }
    int i = 10 * ((int)(this.T / arrayOfInt[0] * arrayOfInt[1]) / 10);
    Locale localLocale = Locale.getDefault();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.T);
    arrayOfObject[1] = Integer.valueOf(i);
    return String.format(localLocale, "%dx%d", arrayOfObject);
  }

  private String a(File paramFile1, File paramFile2, String paramString)
    throws IOException
  {
    String str = l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" -y -i ");
    localStringBuilder.append(paramFile1.getAbsolutePath());
    localStringBuilder.append(" -strict experimental -vf ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" -s " + a(paramFile1) + " -r 30 -aspect 4:3 -ab 48000 -ac 2 -ar 22050 -b 2097k ");
    localStringBuilder.append(paramFile2.getAbsolutePath());
    return localStringBuilder.toString();
  }

  // ERROR //
  @SuppressLint({"NewApi"})
  private int[] b(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: new 129	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 130	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: new 132	java/io/FileInputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_3
    //   17: aload_2
    //   18: aload_3
    //   19: invokevirtual 139	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   22: invokevirtual 143	android/media/MediaMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   25: aload_2
    //   26: invokevirtual 147	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   29: astore 5
    //   31: iconst_2
    //   32: newarray int
    //   34: dup
    //   35: iconst_0
    //   36: aload 5
    //   38: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   41: iastore
    //   42: dup
    //   43: iconst_1
    //   44: aload 5
    //   46: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   49: iastore
    //   50: astore 6
    //   52: aload_3
    //   53: ifnull +7 -> 60
    //   56: aload_3
    //   57: invokevirtual 159	java/io/FileInputStream:close	()V
    //   60: aload 6
    //   62: areturn
    //   63: astore 4
    //   65: aconst_null
    //   66: astore_3
    //   67: aload_3
    //   68: ifnull +7 -> 75
    //   71: aload_3
    //   72: invokevirtual 159	java/io/FileInputStream:close	()V
    //   75: aload 4
    //   77: athrow
    //   78: astore 4
    //   80: goto -13 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   8	17	63	finally
    //   17	52	78	finally
  }

  public static Filter getInstance(Context paramContext)
  {
    if (P == null)
      monitorenter;
    try
    {
      if (P == null)
        P = new Filter();
      monitorexit;
      R = paramContext;
      return P;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  @SuppressLint({"NewApi"})
  private String l()
    throws IOException
  {
    File localFile = new File(R.getFilesDir(), "ffmpeg");
    if ((localFile.exists()) && (localFile.canExecute()))
      return localFile.getAbsolutePath();
    throw new IOException("ffmpeg二进制文件不存在");
  }

  public void cancel()
  {
    if (this.Q != null)
      this.Q.a();
  }

  public void exec(String paramString1, String paramString2)
  {
    this.Q = new a(R, this.S);
    this.Q.execute(new String[] { paramString1, paramString2 });
  }

  public void initFilter(FilterLoadLibraryListener paramFilterLoadLibraryListener)
  {
    new b(R, paramFilterLoadLibraryListener).execute(new Void[0]);
  }

  public void setFilterExecuteListener(FilterExecuteAsyncTaskListener paramFilterExecuteAsyncTaskListener)
  {
    this.S = paramFilterExecuteAsyncTaskListener;
  }

  public void startBlackWhiteFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.U), paramFile1.getAbsolutePath());
  }

  public void startBlurFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.Z), paramFile1.getAbsolutePath());
  }

  public void startExposureFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.ab), paramFile1.getAbsolutePath());
  }

  public void startFadeAnimationFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.aa), paramFile1.getAbsolutePath());
  }

  public void startFocusFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.Y), paramFile1.getAbsolutePath());
  }

  public void startGorgeousFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.W), paramFile1.getAbsolutePath());
  }

  public void startMultiFrameFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.X), paramFile1.getAbsolutePath());
  }

  public void startStrongLightFilter(File paramFile1, File paramFile2)
    throws IOException
  {
    exec(a(paramFile1, paramFile2, this.V), paramFile1.getAbsolutePath());
  }

  private class a extends AsyncTask<String, Integer, Boolean>
  {
    private Context b;
    private FilterExecuteAsyncTaskListener c;
    private Process d;
    private Pattern e = Pattern.compile("Duration:.*(\\d+:\\d+:\\d+\\.\\d+)");
    private Pattern f = Pattern.compile("time=(\\d+:\\d+:\\d+\\.\\d+)");
    private float g;

    public a(Context paramFilterExecuteAsyncTaskListener, FilterExecuteAsyncTaskListener arg3)
    {
      this.b = paramFilterExecuteAsyncTaskListener;
      Object localObject;
      this.c = localObject;
    }

    private int a(String paramString)
      throws Exception
    {
      return (int)(100.0F * (b(paramString) / this.g));
    }

    private boolean a(Process paramProcess)
    {
      if (paramProcess == null)
        return true;
      try
      {
        paramProcess.exitValue();
        return true;
      }
      catch (IllegalThreadStateException localIllegalThreadStateException)
      {
      }
      return false;
    }

    private float b(String paramString)
      throws Exception
    {
      String[] arrayOfString = paramString.split(":");
      return 3600.0F * Float.parseFloat(arrayOfString[0]) + 60.0F * Float.parseFloat(arrayOfString[1]) + Float.parseFloat(arrayOfString[2]);
    }

    protected Boolean a(String[] paramArrayOfString)
    {
      String str1 = FilterUtil.getFilterFile(this.b).getAbsolutePath();
      StringBuilder localStringBuilder;
      try
      {
        BufferedReader localBufferedReader1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str1 + " -i " + paramArrayOfString[1]).getErrorStream()));
        localStringBuilder = new StringBuilder();
        while (true)
        {
          String str2 = localBufferedReader1.readLine();
          if (str2 == null)
            break;
          localStringBuilder.append(str2);
        }
      }
      catch (Exception localException1)
      {
        Log.e("Filter", localException1 + "");
        return Boolean.valueOf(false);
      }
      if (FilterUtil.getFilterLogStatus())
        Log.i("Filter", localStringBuilder.toString() + "");
      Matcher localMatcher1 = this.e.matcher(localStringBuilder.toString());
      if (localMatcher1.find())
        this.g = b(localMatcher1.group(1));
      try
      {
        this.d = Runtime.getRuntime().exec(paramArrayOfString[0]);
        if (this.d == null)
        {
          Log.e("Filter", "process null!");
          Boolean localBoolean2 = Boolean.valueOf(false);
          return localBoolean2;
          Log.e("Filter", "视频文件异常，视频时长不存在");
          Boolean localBoolean1 = Boolean.valueOf(false);
          return localBoolean1;
        }
        if (!a(this.d))
        {
          boolean bool = a(this.d);
          if (!bool);
        }
        else
        {
          return Boolean.valueOf(true);
        }
        BufferedReader localBufferedReader2 = new BufferedReader(new InputStreamReader(this.d.getErrorStream()));
        while (true)
        {
          String str3 = localBufferedReader2.readLine();
          if (str3 == null)
            break;
          Matcher localMatcher2 = this.f.matcher(str3);
          if (localMatcher2.find())
          {
            int i = a(localMatcher2.group(1));
            Integer[] arrayOfInteger = new Integer[1];
            arrayOfInteger[0] = Integer.valueOf(i);
            publishProgress(arrayOfInteger);
          }
          if (!FilterUtil.getFilterLogStatus())
            continue;
          Log.i("Filter", str3 + "");
        }
      }
      catch (Exception localException2)
      {
        Log.e("Filter", localException2 + "");
      }
      return Boolean.valueOf(false);
    }

    public void a()
    {
      if (this.d != null)
        this.d.destroy();
      super.cancel(false);
    }

    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      if (this.c == null)
        return;
      if (paramBoolean.booleanValue())
        this.c.onSuccess();
      while (true)
      {
        this.c.onFinish();
        return;
        this.c.onFailure();
      }
    }

    protected void a(Integer[] paramArrayOfInteger)
    {
      if (this.c == null)
        return;
      this.c.onProgressUpdate(paramArrayOfInteger[0].intValue());
    }

    protected void onCancelled()
    {
      if (this.c == null)
        return;
      this.c.onCancel();
    }

    protected void onPreExecute()
    {
      if (this.c == null)
        return;
      this.c.onStart();
    }
  }

  private class b extends AsyncTask<Void, Void, Boolean>
  {
    private Context b;
    private FilterLoadLibraryListener c;

    public b(Context paramFilterLoadLibraryListener, FilterLoadLibraryListener arg3)
    {
      this.b = paramFilterLoadLibraryListener;
      Object localObject;
      this.c = localObject;
    }

    private boolean a()
    {
      StringBuilder localStringBuilder;
      try
      {
        Process localProcess = Runtime.getRuntime().exec("cat /proc/cpuinfo");
        localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
        while (true)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
            break;
          localStringBuilder.append(str.toLowerCase(Locale.getDefault()));
        }
      }
      catch (IOException localIOException)
      {
        Log.i("Filter", localIOException + "");
        return false;
      }
      if (FilterUtil.getFilterLogStatus())
        Log.i("Filter", localStringBuilder.toString() + "");
      boolean bool = localStringBuilder.toString().contains("armv7");
      return bool;
    }

    // ERROR //
    @SuppressLint({"NewApi"})
    protected Boolean a(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 109	com/bokecc/sdk/mobile/filter/Filter$b:a	()Z
      //   4: ifne +12 -> 16
      //   7: iconst_0
      //   8: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   11: astore 9
      //   13: aload 9
      //   15: areturn
      //   16: aconst_null
      //   17: astore_2
      //   18: aload_0
      //   19: getfield 20	com/bokecc/sdk/mobile/filter/Filter$b:b	Landroid/content/Context;
      //   22: invokestatic 119	com/bokecc/sdk/mobile/filter/FilterUtil:getFilterFile	(Landroid/content/Context;)Ljava/io/File;
      //   25: astore 12
      //   27: aload 12
      //   29: invokevirtual 124	java/io/File:exists	()Z
      //   32: istore 13
      //   34: aconst_null
      //   35: astore_2
      //   36: iload 13
      //   38: ifeq +66 -> 104
      //   41: aload 12
      //   43: invokevirtual 127	java/io/File:canExecute	()Z
      //   46: ifeq +58 -> 104
      //   49: iconst_1
      //   50: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   53: astore 23
      //   55: aload 23
      //   57: astore 9
      //   59: iconst_0
      //   60: ifeq -47 -> 13
      //   63: aconst_null
      //   64: invokevirtual 132	java/io/OutputStream:close	()V
      //   67: aload 9
      //   69: areturn
      //   70: astore 24
      //   72: ldc 78
      //   74: new 39	java/lang/StringBuilder
      //   77: dup
      //   78: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   81: aload 24
      //   83: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
      //   86: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: ldc 83
      //   91: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   97: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   100: pop
      //   101: aload 9
      //   103: areturn
      //   104: aload 12
      //   106: invokevirtual 141	java/io/File:createNewFile	()Z
      //   109: pop
      //   110: aload_0
      //   111: getfield 20	com/bokecc/sdk/mobile/filter/Filter$b:b	Landroid/content/Context;
      //   114: invokevirtual 147	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   117: ldc 149
      //   119: iconst_0
      //   120: invokevirtual 155	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
      //   123: astore 15
      //   125: new 157	java/io/FileOutputStream
      //   128: dup
      //   129: aload 12
      //   131: invokespecial 160	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   134: astore 16
      //   136: sipush 10240
      //   139: newarray byte
      //   141: astore 17
      //   143: aload 15
      //   145: aload 17
      //   147: invokevirtual 166	java/io/InputStream:read	([B)I
      //   150: istore 18
      //   152: iload 18
      //   154: ifle +100 -> 254
      //   157: aload 16
      //   159: aload 17
      //   161: iconst_0
      //   162: iload 18
      //   164: invokevirtual 170	java/io/OutputStream:write	([BII)V
      //   167: goto -24 -> 143
      //   170: astore_3
      //   171: aload 16
      //   173: astore_2
      //   174: ldc 78
      //   176: new 39	java/lang/StringBuilder
      //   179: dup
      //   180: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   183: aload_3
      //   184: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   187: ldc 83
      //   189: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   192: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   195: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   198: pop
      //   199: iconst_0
      //   200: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   203: astore 8
      //   205: aload 8
      //   207: astore 9
      //   209: aload_2
      //   210: ifnull -197 -> 13
      //   213: aload_2
      //   214: invokevirtual 132	java/io/OutputStream:close	()V
      //   217: aload 9
      //   219: areturn
      //   220: astore 10
      //   222: ldc 78
      //   224: new 39	java/lang/StringBuilder
      //   227: dup
      //   228: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   231: aload 10
      //   233: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
      //   236: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: ldc 83
      //   241: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   244: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   247: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   250: pop
      //   251: aload 9
      //   253: areturn
      //   254: aload 12
      //   256: iconst_1
      //   257: invokevirtual 174	java/io/File:setExecutable	(Z)Z
      //   260: pop
      //   261: iconst_1
      //   262: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   265: astore 20
      //   267: aload 20
      //   269: astore 9
      //   271: aload 16
      //   273: ifnull -260 -> 13
      //   276: aload 16
      //   278: invokevirtual 132	java/io/OutputStream:close	()V
      //   281: aload 9
      //   283: areturn
      //   284: astore 21
      //   286: ldc 78
      //   288: new 39	java/lang/StringBuilder
      //   291: dup
      //   292: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   295: aload 21
      //   297: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
      //   300: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   303: ldc 83
      //   305: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   308: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   311: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   314: pop
      //   315: aload 9
      //   317: areturn
      //   318: astore 4
      //   320: aload_2
      //   321: ifnull +7 -> 328
      //   324: aload_2
      //   325: invokevirtual 132	java/io/OutputStream:close	()V
      //   328: aload 4
      //   330: athrow
      //   331: astore 5
      //   333: ldc 78
      //   335: new 39	java/lang/StringBuilder
      //   338: dup
      //   339: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   342: aload 5
      //   344: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
      //   347: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   350: ldc 83
      //   352: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   355: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   358: invokestatic 138	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   361: pop
      //   362: goto -34 -> 328
      //   365: astore 4
      //   367: aload 16
      //   369: astore_2
      //   370: goto -50 -> 320
      //   373: astore_3
      //   374: aconst_null
      //   375: astore_2
      //   376: goto -202 -> 174
      //
      // Exception table:
      //   from	to	target	type
      //   63	67	70	java/io/IOException
      //   136	143	170	java/io/IOException
      //   143	152	170	java/io/IOException
      //   157	167	170	java/io/IOException
      //   254	267	170	java/io/IOException
      //   213	217	220	java/io/IOException
      //   276	281	284	java/io/IOException
      //   18	34	318	finally
      //   41	55	318	finally
      //   104	136	318	finally
      //   174	205	318	finally
      //   324	328	331	java/io/IOException
      //   136	143	365	finally
      //   143	152	365	finally
      //   157	167	365	finally
      //   254	267	365	finally
      //   18	34	373	java/io/IOException
      //   41	55	373	java/io/IOException
      //   104	136	373	java/io/IOException
    }

    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      if (this.c == null)
        return;
      if (paramBoolean.booleanValue())
        this.c.onSucess();
      while (true)
      {
        this.c.onFinish();
        return;
        this.c.onFailure();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.filter.Filter
 * JD-Core Version:    0.6.0
 */