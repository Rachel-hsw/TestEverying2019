package com.gensee.utils;

import android.os.Environment;
import android.util.Log;
import com.gensee.common.GenseeConfig;
import com.gensee.report.ReportInfo;
import com.gensee.utils.upload.UpLoadFileUtil;
import com.gensee.utils.upload.UploadItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GenseeLog
{
  private static final String GS_TAG = "Gensee";
  private static final String LOG_APP = "app-";
  private static final String LOG_DIAGNOSE = "diagnose-android-";
  public static final String LOG_DIAGNOSE_STACK = "stack-diagnose-android-";
  private static final String LOG_INFO = "info-";
  private static final String LOG_STACK = "stack-";
  private static String MYLOG_PATH_SDCARD_DIR;
  public static String UPLOAD_URL;
  private static String curZipDest;
  private static boolean isInited;
  public static boolean isWriteTestLog;
  public static String logAppFileName;
  public static String logCrashFileName;
  public static String logInfoFileName;
  private static SimpleDateFormat myLogFileNameSdf;
  private static SimpleDateFormat myLogTimeSdf;
  public static ReportInfo reportInfo = null;

  static
  {
    MYLOG_PATH_SDCARD_DIR = "/sdcard/gensee/log/";
    myLogFileNameSdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    myLogTimeSdf = new SimpleDateFormat("HH:mm:ss.SSS");
    isWriteTestLog = false;
    isInited = false;
    logInfoFileName = "";
    logAppFileName = "";
    logCrashFileName = "";
    UPLOAD_URL = "";
    curZipDest = "";
  }

  public static boolean containsStackFile()
  {
    File localFile1 = new File(MYLOG_PATH_SDCARD_DIR);
    File[] arrayOfFile;
    if (localFile1.exists())
      arrayOfFile = localFile1.listFiles();
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfFile.length)
        return false;
      File localFile2 = arrayOfFile[i];
      if ((localFile2.isFile()) && (localFile2.getName().startsWith("stack-")))
        return true;
    }
  }

  public static boolean containsZipStackFile()
  {
    File localFile1 = new File(MYLOG_PATH_SDCARD_DIR);
    File[] arrayOfFile;
    if (localFile1.exists())
      arrayOfFile = localFile1.listFiles();
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfFile.length)
        return false;
      File localFile2 = arrayOfFile[i];
      if ((localFile2.isFile()) && (localFile2.getName().startsWith("stack-diagnose-android-")))
        return true;
    }
  }

  public static void d(String paramString)
  {
    if (isLoggable(3))
      Log.d("Gensee", paramString);
    writeLogtoFile("D", "Gensee", paramString);
  }

  public static void d(String paramString1, String paramString2)
  {
    d(paramString1 + " -> " + paramString2);
  }

  public static void d(String paramString1, String paramString2, String paramString3)
  {
    d(paramString1, paramString2 + " -> " + paramString3);
  }

  public static void e(Exception paramException)
  {
    e(paramException.toString());
  }

  public static void e(String paramString)
  {
    if (isLoggable(6))
      Log.e("Gensee", paramString);
    writeLogtoFile("E", "Gensee", paramString);
  }

  public static void e(String paramString, Exception paramException)
  {
    e(paramString, paramException.toString());
  }

  public static void e(String paramString1, String paramString2)
  {
    e(paramString1 + " -> " + paramString2);
  }

  public static boolean hasSdcard()
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      Log.w("GenseeLog", "sdcard is not exists ,write log failed!");
      return false;
    }
    return true;
  }

  public static void i(String paramString)
  {
    Log.i("Gensee", paramString);
    writeLogtoFile("I", "Gensee", paramString);
  }

  public static void i(String paramString1, String paramString2)
  {
    i(paramString1 + " -> " + paramString2);
  }

  public static void initLog()
  {
    initLog(null);
  }

  public static void initLog(String paramString)
  {
    File localFile;
    if (hasSdcard())
    {
      localFile = new File(MYLOG_PATH_SDCARD_DIR);
      if ((localFile.exists()) || (localFile.mkdirs()));
    }
    else
    {
      return;
    }
    FileUtil.deleteFileByTime(localFile, System.currentTimeMillis(), 259200000L);
    loadlibrary();
    logAppFileName = MYLOG_PATH_SDCARD_DIR + "app-" + myLogFileNameSdf.format(new Date()) + ".log";
    if (paramString == null);
    for (String str = logAppFileName; ; str = MYLOG_PATH_SDCARD_DIR + paramString)
    {
      stdLog(str);
      i(GenseeConfig.getSDKVersionInfo());
      isInited = true;
      return;
    }
  }

  public static boolean isInited()
  {
    return isInited;
  }

  private static boolean isLoggable(int paramInt)
  {
    return Log.isLoggable("Gensee", paramInt);
  }

  private static void loadlibrary()
  {
    try
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("gensee-log");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private static String reportDiagonse(File paramFile, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    UploadItem localUploadItem1 = new UploadItem();
    localUploadItem1.setName("test");
    localUploadItem1.setType("VALUE_TYPE");
    localUploadItem1.setValue("value");
    UploadItem localUploadItem2 = new UploadItem();
    localUploadItem2.setName("submit");
    localUploadItem2.setType("VALUE_TYPE");
    localUploadItem2.setValue("Upload");
    UploadItem localUploadItem3 = new UploadItem();
    localUploadItem3.setName("file1");
    localUploadItem3.setType("FILE_TYPE");
    localUploadItem3.setValue(paramFile.getAbsolutePath());
    localArrayList.add(localUploadItem1);
    localArrayList.add(localUploadItem2);
    localArrayList.add(localUploadItem3);
    String str = new UpLoadFileUtil().uploadFile(localArrayList, paramString);
    paramFile.delete();
    return str;
  }

  public static String reportDiagonse(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if (paramBoolean2)
    {
      boolean bool4 = "".equals(curZipDest);
      str1 = null;
      if (!bool4)
      {
        File localFile3 = new File(curZipDest);
        boolean bool5 = localFile3.exists();
        str1 = null;
        if (bool5)
        {
          String str3 = reportDiagonse(localFile3, paramString1);
          boolean bool6 = "".equals(str3);
          str1 = null;
          if (!bool6)
          {
            str1 = null;
            if (paramString2 != null)
            {
              boolean bool7 = "".equals(paramString2);
              str1 = null;
              if (!bool7)
              {
                str1 = null;
                if (paramMap1 != null)
                {
                  str1 = null;
                  if (paramMap2 != null)
                  {
                    paramMap2.put("file", str3);
                    str1 = new UpLoadFileUtil().notifyWeb(paramString2, paramMap1, paramMap2);
                  }
                }
              }
            }
          }
        }
      }
    }
    File localFile1;
    boolean bool1;
    do
    {
      return str1;
      localFile1 = new File(MYLOG_PATH_SDCARD_DIR);
      bool1 = localFile1.exists();
      str1 = null;
    }
    while (!bool1);
    File[] arrayOfFile = localFile1.listFiles();
    int i = 0;
    File localFile2 = null;
    if (i >= arrayOfFile.length);
    while (true)
    {
      str1 = null;
      if (localFile2 == null)
        break;
      String str2 = reportDiagonse(localFile2, paramString1);
      boolean bool2 = "".equals(str2);
      str1 = null;
      if (bool2)
        break;
      str1 = null;
      if (paramString2 == null)
        break;
      boolean bool3 = "".equals(paramString2);
      str1 = null;
      if (bool3)
        break;
      str1 = null;
      if (paramMap1 == null)
        break;
      str1 = null;
      if (paramMap2 == null)
        break;
      paramMap2.put("file", str2);
      return new UpLoadFileUtil().notifyWeb(paramString2, paramMap1, paramMap2);
      localFile2 = arrayOfFile[i];
      if (paramBoolean1)
        if (localFile2.getName().startsWith("stack-diagnose-android-"))
          continue;
      do
      {
        i++;
        break;
      }
      while (!localFile2.getName().startsWith("diagnose-android-"));
    }
  }

  private static native void stdLog(String paramString);

  public static void v(String paramString)
  {
    if (isLoggable(2))
      Log.v("Gensee", paramString);
  }

  public static void v(String paramString1, String paramString2)
  {
    v(paramString1 + " -> " + paramString2);
  }

  public static void w(String paramString)
  {
    if (isLoggable(5))
      Log.w("Gensee", paramString);
    writeLogtoFile("W", "Gensee", paramString);
  }

  public static void w(String paramString1, String paramString2)
  {
    w(paramString1 + " -> " + paramString2);
  }

  // ERROR //
  public static void wirteCrashInfo(String paramString)
  {
    // Byte code:
    //   0: new 128	java/lang/StringBuilder
    //   3: dup
    //   4: getstatic 45	com/gensee/utils/GenseeLog:MYLOG_PATH_SDCARD_DIR	Ljava/lang/String;
    //   7: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: ldc 23
    //   15: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: getstatic 55	com/gensee/utils/GenseeLog:myLogFileNameSdf	Ljava/text/SimpleDateFormat;
    //   21: new 213	java/util/Date
    //   24: dup
    //   25: invokespecial 214	java/util/Date:<init>	()V
    //   28: invokevirtual 218	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   31: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 220
    //   36: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: putstatic 71	com/gensee/utils/GenseeLog:logCrashFileName	Ljava/lang/String;
    //   45: aconst_null
    //   46: astore_1
    //   47: new 87	java/io/File
    //   50: dup
    //   51: getstatic 45	com/gensee/utils/GenseeLog:MYLOG_PATH_SDCARD_DIR	Ljava/lang/String;
    //   54: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_2
    //   58: new 87	java/io/File
    //   61: dup
    //   62: getstatic 71	com/gensee/utils/GenseeLog:logCrashFileName	Ljava/lang/String;
    //   65: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_3
    //   69: aload_2
    //   70: invokevirtual 91	java/io/File:exists	()Z
    //   73: ifne +8 -> 81
    //   76: aload_2
    //   77: invokevirtual 194	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_3
    //   82: invokevirtual 91	java/io/File:exists	()Z
    //   85: ifne +8 -> 93
    //   88: aload_3
    //   89: invokevirtual 322	java/io/File:createNewFile	()Z
    //   92: pop
    //   93: new 324	java/io/FileOutputStream
    //   96: dup
    //   97: getstatic 71	com/gensee/utils/GenseeLog:logCrashFileName	Ljava/lang/String;
    //   100: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   103: astore 4
    //   105: aload 4
    //   107: aload_0
    //   108: invokevirtual 329	java/lang/String:getBytes	()[B
    //   111: invokevirtual 333	java/io/FileOutputStream:write	([B)V
    //   114: aload 4
    //   116: ifnull +8 -> 124
    //   119: aload 4
    //   121: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   124: return
    //   125: astore 12
    //   127: aload 12
    //   129: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   132: goto -39 -> 93
    //   135: astore 5
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 5
    //   142: invokevirtual 338	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload 4
    //   147: ifnull -23 -> 124
    //   150: aload 4
    //   152: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   155: return
    //   156: astore 8
    //   158: aload 8
    //   160: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   163: return
    //   164: astore 9
    //   166: aload 9
    //   168: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   171: aload_1
    //   172: ifnull -48 -> 124
    //   175: aload_1
    //   176: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   179: return
    //   180: astore 10
    //   182: aload 10
    //   184: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: astore 6
    //   190: aload_1
    //   191: ifnull +7 -> 198
    //   194: aload_1
    //   195: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   198: aload 6
    //   200: athrow
    //   201: astore 7
    //   203: aload 7
    //   205: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   208: goto -10 -> 198
    //   211: astore 11
    //   213: aload 11
    //   215: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   218: return
    //   219: astore 6
    //   221: aload 4
    //   223: astore_1
    //   224: goto -34 -> 190
    //   227: astore 9
    //   229: aload 4
    //   231: astore_1
    //   232: goto -66 -> 166
    //   235: astore 5
    //   237: goto -97 -> 140
    //
    // Exception table:
    //   from	to	target	type
    //   88	93	125	java/io/IOException
    //   93	105	135	java/io/FileNotFoundException
    //   150	155	156	java/io/IOException
    //   93	105	164	java/io/IOException
    //   175	179	180	java/io/IOException
    //   93	105	188	finally
    //   166	171	188	finally
    //   194	198	201	java/io/IOException
    //   119	124	211	java/io/IOException
    //   105	114	219	finally
    //   140	145	219	finally
    //   105	114	227	java/io/IOException
    //   105	114	235	java/io/FileNotFoundException
  }

  // ERROR //
  public static void writeAppInfo(String paramString)
  {
    // Byte code:
    //   0: new 128	java/lang/StringBuilder
    //   3: dup
    //   4: getstatic 45	com/gensee/utils/GenseeLog:MYLOG_PATH_SDCARD_DIR	Ljava/lang/String;
    //   7: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: ldc 20
    //   15: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: getstatic 55	com/gensee/utils/GenseeLog:myLogFileNameSdf	Ljava/text/SimpleDateFormat;
    //   21: new 213	java/util/Date
    //   24: dup
    //   25: invokespecial 214	java/util/Date:<init>	()V
    //   28: invokevirtual 218	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   31: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 220
    //   36: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: putstatic 67	com/gensee/utils/GenseeLog:logInfoFileName	Ljava/lang/String;
    //   45: aconst_null
    //   46: astore_1
    //   47: new 87	java/io/File
    //   50: dup
    //   51: getstatic 45	com/gensee/utils/GenseeLog:MYLOG_PATH_SDCARD_DIR	Ljava/lang/String;
    //   54: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_2
    //   58: new 87	java/io/File
    //   61: dup
    //   62: getstatic 67	com/gensee/utils/GenseeLog:logInfoFileName	Ljava/lang/String;
    //   65: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_3
    //   69: aload_2
    //   70: invokevirtual 91	java/io/File:exists	()Z
    //   73: ifne +8 -> 81
    //   76: aload_2
    //   77: invokevirtual 194	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_3
    //   82: invokevirtual 91	java/io/File:exists	()Z
    //   85: ifne +8 -> 93
    //   88: aload_3
    //   89: invokevirtual 322	java/io/File:createNewFile	()Z
    //   92: pop
    //   93: new 324	java/io/FileOutputStream
    //   96: dup
    //   97: getstatic 67	com/gensee/utils/GenseeLog:logInfoFileName	Ljava/lang/String;
    //   100: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   103: astore 4
    //   105: aload 4
    //   107: aload_0
    //   108: invokevirtual 329	java/lang/String:getBytes	()[B
    //   111: invokevirtual 333	java/io/FileOutputStream:write	([B)V
    //   114: aload 4
    //   116: ifnull +8 -> 124
    //   119: aload 4
    //   121: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   124: return
    //   125: astore 12
    //   127: aload 12
    //   129: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   132: goto -39 -> 93
    //   135: astore 5
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 5
    //   142: invokevirtual 338	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload 4
    //   147: ifnull -23 -> 124
    //   150: aload 4
    //   152: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   155: return
    //   156: astore 8
    //   158: aload 8
    //   160: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   163: return
    //   164: astore 9
    //   166: aload 9
    //   168: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   171: aload_1
    //   172: ifnull -48 -> 124
    //   175: aload_1
    //   176: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   179: return
    //   180: astore 10
    //   182: aload 10
    //   184: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: astore 6
    //   190: aload_1
    //   191: ifnull +7 -> 198
    //   194: aload_1
    //   195: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   198: aload 6
    //   200: athrow
    //   201: astore 7
    //   203: aload 7
    //   205: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   208: goto -10 -> 198
    //   211: astore 11
    //   213: aload 11
    //   215: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   218: return
    //   219: astore 6
    //   221: aload 4
    //   223: astore_1
    //   224: goto -34 -> 190
    //   227: astore 9
    //   229: aload 4
    //   231: astore_1
    //   232: goto -66 -> 166
    //   235: astore 5
    //   237: goto -97 -> 140
    //
    // Exception table:
    //   from	to	target	type
    //   88	93	125	java/io/IOException
    //   93	105	135	java/io/FileNotFoundException
    //   150	155	156	java/io/IOException
    //   93	105	164	java/io/IOException
    //   175	179	180	java/io/IOException
    //   93	105	188	finally
    //   166	171	188	finally
    //   194	198	201	java/io/IOException
    //   119	124	211	java/io/IOException
    //   105	114	219	finally
    //   140	145	219	finally
    //   105	114	227	java/io/IOException
    //   105	114	235	java/io/FileNotFoundException
  }

  private static native void writeLog(String paramString);

  protected static void writeLogtoFile(String paramString1, String paramString2, String paramString3)
  {
    if (!isInited);
    do
      return;
    while (paramString3 == null);
    ThreadPool.getInstance().execute(new GenseeLog.1(paramString1, paramString2, paramString3));
  }

  public static void zipFile(boolean paramBoolean)
  {
    curZipDest = MYLOG_PATH_SDCARD_DIR + "diagnose-android-" + myLogFileNameSdf.format(new Date()) + ".zip";
    if (containsStackFile())
      curZipDest = MYLOG_PATH_SDCARD_DIR + "stack-diagnose-android-" + myLogFileNameSdf.format(new Date()) + ".zip";
    Object localObject1 = null;
    try
    {
      File localFile1 = new File(MYLOG_PATH_SDCARD_DIR);
      boolean bool1 = localFile1.exists();
      localObject1 = null;
      if (bool1)
      {
        arrayOfFile = localFile1.listFiles();
        localArrayList = new ArrayList();
        i = 0;
        if (i >= arrayOfFile.length)
        {
          localIterator = localArrayList.iterator();
          boolean bool2 = localIterator.hasNext();
          if (bool2)
            break label595;
        }
      }
      else if (localObject1 == null);
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
    }
    finally
    {
      while (true)
      {
        File[] arrayOfFile;
        ArrayList localArrayList;
        int i;
        Iterator localIterator;
        File localFile2;
        FileNotFoundException localFileNotFoundException1;
        Object localObject2;
        label595: continue;
        Object localObject4 = localObject1;
        continue;
        localObject4 = localObject1;
        continue;
        localObject4 = localObject1;
        continue;
        localObject4 = localObject1;
        continue;
        localObject4 = localObject1;
        continue;
        localObject4 = localObject1;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.GenseeLog
 * JD-Core Version:    0.6.0
 */