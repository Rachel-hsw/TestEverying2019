package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONObject;

public class UmengDownloadResourceService extends Service
{
  public static final String TAG = UmengDownloadResourceService.class.getSimpleName();
  private static final String d = ".tmp";
  private static final String e = "RETRY_TIME";
  private static final String f = "OPERATIOIN";
  private static final int g = 1;
  private static final int h = 2;
  private static final long i = 1048576L;
  private static final long j = 86400000L;
  private static final int k = 300000;
  private static final int l = 3;
  private static Thread m;
  ScheduledThreadPoolExecutor a;
  Context b;
  ArrayList<String> c;

  private static long a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
    {
      l1 = 0L;
      return l1;
    }
    Stack localStack = new Stack();
    localStack.clear();
    localStack.push(paramFile);
    long l1 = 0L;
    label42: File[] arrayOfFile;
    int n;
    long l2;
    if (!localStack.isEmpty())
    {
      arrayOfFile = ((File)localStack.pop()).listFiles();
      n = arrayOfFile.length;
      l2 = l1;
    }
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= n)
      {
        l1 = l2;
        break label42;
        break;
      }
      File localFile = arrayOfFile[i1];
      if (localFile.isDirectory())
        continue;
      l2 += localFile.length();
    }
  }

  private PendingIntent a(com.umeng.message.a.a parama, int paramInt)
  {
    String str = parama.a().toString();
    int n = parama.h.hashCode();
    Intent localIntent = new Intent(this.b, UmengDownloadResourceService.class);
    localIntent.putExtra("body", str);
    localIntent.putExtra("id", parama.i);
    localIntent.putExtra("task_id", parama.j);
    localIntent.putExtra("OPERATIOIN", 2);
    localIntent.putExtra("RETRY_TIME", paramInt);
    PendingIntent localPendingIntent = PendingIntent.getService(this.b, n, localIntent, 134217728);
    com.umeng.b.a.a.a(TAG, "PendingIntent: msgId:" + parama.h + ",requestCode:" + n + ",retryTime:" + paramInt);
    return localPendingIntent;
  }

  private static void b(File paramFile, long paramLong)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.canWrite()) || (!paramFile.isDirectory()));
    while (true)
    {
      return;
      for (File localFile : paramFile.listFiles())
      {
        if ((localFile.isDirectory()) || (System.currentTimeMillis() - localFile.lastModified() <= paramLong))
          continue;
        localFile.delete();
      }
    }
  }

  public static void checkDir(File paramFile, long paramLong1, long paramLong2)
    throws IOException
  {
    if ((paramFile.exists()) && (a(paramFile.getCanonicalFile()) > paramLong1))
    {
      if (m == null)
        m = new Thread(new UmengDownloadResourceService.1(paramFile, paramLong2));
      synchronized (m)
      {
        m.start();
        return;
      }
    }
  }

  public static String getMessageResourceFolder(Context paramContext, com.umeng.message.a.a parama)
  {
    String str = paramContext.getCacheDir() + "/umeng_push/";
    if ((parama != null) && (parama.h != null))
      str = str + parama.h + "/";
    return str;
  }

  public void checkCache()
  {
    try
    {
      checkDir(new File(getMessageResourceFolder(this.b, null)), 1048576L, 86400000L);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void close(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void deleteAlarm(com.umeng.message.a.a parama, int paramInt)
  {
    com.umeng.b.a.a.a(TAG, "deleteAlarm");
    PendingIntent localPendingIntent = a(parama, paramInt);
    ((AlarmManager)getSystemService("alarm")).cancel(localPendingIntent);
  }

  @SuppressLint({"NewApi"})
  public void downloadResource(com.umeng.message.a.a parama, int paramInt)
  {
    DownloadResourceTask localDownloadResourceTask = new DownloadResourceTask(parama, paramInt);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localDownloadResourceTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
    localDownloadResourceTask.execute(new Void[0]);
  }

  public void notification(com.umeng.message.a.a parama)
  {
    UHandler localUHandler = PushAgent.getInstance(this).getMessageHandler();
    if (localUHandler != null)
    {
      if (!TextUtils.equals("autoupdate", parama.k))
        break label53;
      UmengMessageHandler localUmengMessageHandler = (UmengMessageHandler)PushAgent.getInstance(this.b).getMessageHandler();
      if (localUmengMessageHandler != null)
        localUmengMessageHandler.dealWithNotificationMessage(this.b, parama);
    }
    return;
    label53: localUHandler.handleMessage(this, parama);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    this.a = new ScheduledThreadPoolExecutor(4 * Runtime.getRuntime().availableProcessors());
    this.b = this;
    this.c = new ArrayList();
  }

  @SuppressLint({"NewApi"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    int n = paramIntent.getIntExtra("OPERATIOIN", 2);
    int i1 = paramIntent.getIntExtra("RETRY_TIME", 3);
    String str = paramIntent.getStringExtra("body");
    try
    {
      locala = new com.umeng.message.a.a(new JSONObject(str));
      locala.i = paramIntent.getStringExtra("id");
      locala.j = paramIntent.getStringExtra("task_id");
      if (this.c.contains(locala.h))
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      this.c.add(locala.h);
      switch (n)
      {
      default:
      case 2:
        while (true)
        {
          return super.onStartCommand(paramIntent, paramInt1, paramInt2);
          com.umeng.b.a.a.a(TAG, "Start Download Resource");
          int i2 = i1 - 1;
          setAlarm(locala, i2);
          checkCache();
          downloadResource(locala, i2);
        }
      case 1:
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        com.umeng.message.a.a locala;
        localException.printStackTrace();
        continue;
        deleteAlarm(locala, i1);
        com.umeng.b.a.a.a(TAG, "Show Notification After Downloaded Resource");
        notification(locala);
        this.c.remove(locala.h);
        if (this.c.size() != 0)
          continue;
        stopSelf();
      }
    }
  }

  public void setAlarm(com.umeng.message.a.a parama, int paramInt)
  {
    com.umeng.b.a.a.a(TAG, "setAlarm");
    PendingIntent localPendingIntent = a(parama, paramInt);
    ((AlarmManager)getSystemService("alarm")).set(1, 300000L + System.currentTimeMillis(), localPendingIntent);
  }

  public class DownloadResourceTask extends AsyncTask<Void, Void, Boolean>
  {
    com.umeng.message.a.a a;
    ArrayList<String> b;
    int c;

    public DownloadResourceTask(com.umeng.message.a.a paramInt, int arg3)
    {
      this.a = paramInt;
      this.b = new ArrayList();
      if (paramInt.c())
        this.b.add(paramInt.x);
      if (paramInt.d())
        this.b.add(paramInt.w);
      int i;
      this.c = i;
    }

    protected Boolean a(Void[] paramArrayOfVoid)
    {
      Iterator localIterator = this.b.iterator();
      boolean bool = true;
      while (true)
      {
        if (!localIterator.hasNext())
          return Boolean.valueOf(bool);
        bool &= download((String)localIterator.next());
      }
    }

    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      UmengDownloadResourceService.this.c.remove(this.a.h);
      if ((paramBoolean.booleanValue()) || (this.c <= 0))
      {
        MessageSharedPrefs.getInstance(UmengDownloadResourceService.this.b).c(this.a.h);
        String str = this.a.a().toString();
        Intent localIntent = new Intent(UmengDownloadResourceService.this.b, UmengDownloadResourceService.class);
        localIntent.putExtra("body", str);
        localIntent.putExtra("id", this.a.i);
        localIntent.putExtra("task_id", this.a.j);
        localIntent.putExtra("OPERATIOIN", 1);
        localIntent.putExtra("RETRY_TIME", this.c);
        UmengDownloadResourceService.this.startService(localIntent);
      }
      do
        return;
      while (UmengDownloadResourceService.this.c.size() != 0);
      UmengDownloadResourceService.this.stopSelf();
    }

    // ERROR //
    public boolean download(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aload_1
      //   3: invokestatic 166	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   6: ifeq +5 -> 11
      //   9: iconst_1
      //   10: ireturn
      //   11: new 168	java/lang/StringBuilder
      //   14: dup
      //   15: aload_1
      //   16: invokevirtual 171	java/lang/String:hashCode	()I
      //   19: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   22: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   25: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   28: astore 7
      //   30: aload_0
      //   31: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   34: getfield 95	com/umeng/message/UmengDownloadResourceService:b	Landroid/content/Context;
      //   37: aload_0
      //   38: getfield 23	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:a	Lcom/umeng/message/a/a;
      //   41: invokestatic 181	com/umeng/message/UmengDownloadResourceService:getMessageResourceFolder	(Landroid/content/Context;Lcom/umeng/message/a/a;)Ljava/lang/String;
      //   44: astore 8
      //   46: new 183	java/io/File
      //   49: dup
      //   50: aload 8
      //   52: new 168	java/lang/StringBuilder
      //   55: dup
      //   56: aload 7
      //   58: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   61: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   64: ldc 188
      //   66: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   72: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   75: astore 9
      //   77: new 183	java/io/File
      //   80: dup
      //   81: aload 8
      //   83: aload 7
      //   85: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   88: astore 10
      //   90: aload 10
      //   92: invokevirtual 198	java/io/File:exists	()Z
      //   95: istore 11
      //   97: iload 11
      //   99: ifeq +21 -> 120
      //   102: aload_0
      //   103: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   106: aconst_null
      //   107: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   110: aload_0
      //   111: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   114: aconst_null
      //   115: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   118: iconst_1
      //   119: ireturn
      //   120: new 183	java/io/File
      //   123: dup
      //   124: aload 8
      //   126: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
      //   129: astore 12
      //   131: aload 12
      //   133: invokevirtual 198	java/io/File:exists	()Z
      //   136: ifne +9 -> 145
      //   139: aload 12
      //   141: invokevirtual 206	java/io/File:mkdirs	()Z
      //   144: pop
      //   145: aload 9
      //   147: invokevirtual 198	java/io/File:exists	()Z
      //   150: ifeq +9 -> 159
      //   153: aload 9
      //   155: invokevirtual 209	java/io/File:delete	()Z
      //   158: pop
      //   159: new 211	java/net/URL
      //   162: dup
      //   163: new 213	java/net/URI
      //   166: dup
      //   167: aload_1
      //   168: invokespecial 214	java/net/URI:<init>	(Ljava/lang/String;)V
      //   171: invokevirtual 217	java/net/URI:toASCIIString	()Ljava/lang/String;
      //   174: invokespecial 218	java/net/URL:<init>	(Ljava/lang/String;)V
      //   177: invokevirtual 222	java/net/URL:openStream	()Ljava/io/InputStream;
      //   180: astore 13
      //   182: aload 13
      //   184: astore 6
      //   186: new 224	java/io/FileOutputStream
      //   189: dup
      //   190: aload 9
      //   192: invokespecial 227	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   195: astore 14
      //   197: sipush 10240
      //   200: newarray byte
      //   202: astore 15
      //   204: aload 6
      //   206: aload 15
      //   208: invokevirtual 233	java/io/InputStream:read	([B)I
      //   211: istore 16
      //   213: iload 16
      //   215: ifgt +31 -> 246
      //   218: aload 9
      //   220: aload 10
      //   222: invokevirtual 237	java/io/File:renameTo	(Ljava/io/File;)Z
      //   225: pop
      //   226: aload_0
      //   227: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   230: aload 6
      //   232: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   235: aload_0
      //   236: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   239: aload 14
      //   241: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   244: iconst_1
      //   245: ireturn
      //   246: aload 14
      //   248: aload 15
      //   250: iconst_0
      //   251: iload 16
      //   253: invokevirtual 241	java/io/FileOutputStream:write	([BII)V
      //   256: goto -52 -> 204
      //   259: astore_3
      //   260: aload 14
      //   262: astore_2
      //   263: aload 6
      //   265: astore 4
      //   267: aload_3
      //   268: invokevirtual 244	java/lang/Exception:printStackTrace	()V
      //   271: aload_0
      //   272: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   275: aload 4
      //   277: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   280: aload_0
      //   281: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   284: aload_2
      //   285: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   288: iconst_0
      //   289: ireturn
      //   290: astore 5
      //   292: aconst_null
      //   293: astore 6
      //   295: aload_0
      //   296: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   299: aload 6
      //   301: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   304: aload_0
      //   305: getfield 18	com/umeng/message/UmengDownloadResourceService$DownloadResourceTask:d	Lcom/umeng/message/UmengDownloadResourceService;
      //   308: aload_2
      //   309: invokevirtual 202	com/umeng/message/UmengDownloadResourceService:close	(Ljava/io/Closeable;)V
      //   312: aload 5
      //   314: athrow
      //   315: astore 5
      //   317: aconst_null
      //   318: astore_2
      //   319: goto -24 -> 295
      //   322: astore 5
      //   324: aload 14
      //   326: astore_2
      //   327: goto -32 -> 295
      //   330: astore 5
      //   332: aload 4
      //   334: astore 6
      //   336: goto -41 -> 295
      //   339: astore_3
      //   340: aconst_null
      //   341: astore_2
      //   342: aconst_null
      //   343: astore 4
      //   345: goto -78 -> 267
      //   348: astore_3
      //   349: aload 6
      //   351: astore 4
      //   353: aconst_null
      //   354: astore_2
      //   355: goto -88 -> 267
      //
      // Exception table:
      //   from	to	target	type
      //   197	204	259	java/lang/Exception
      //   204	213	259	java/lang/Exception
      //   218	226	259	java/lang/Exception
      //   246	256	259	java/lang/Exception
      //   11	97	290	finally
      //   120	145	290	finally
      //   145	159	290	finally
      //   159	182	290	finally
      //   186	197	315	finally
      //   197	204	322	finally
      //   204	213	322	finally
      //   218	226	322	finally
      //   246	256	322	finally
      //   267	271	330	finally
      //   11	97	339	java/lang/Exception
      //   120	145	339	java/lang/Exception
      //   145	159	339	java/lang/Exception
      //   159	182	339	java/lang/Exception
      //   186	197	348	java/lang/Exception
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengDownloadResourceService
 * JD-Core Version:    0.6.0
 */