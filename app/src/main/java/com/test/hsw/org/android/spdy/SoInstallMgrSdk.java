package org.android.spdy;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SoInstallMgrSdk
{
  private static final String ARMEABI = "armeabi";
  private static final int EventID_SO_INIT = 21033;
  static final String LOGTAG = "INIT_SO";
  private static final String MIPS = "mips";
  private static final String X86 = "x86";
  static Context mContext = null;

  private static String _cpuType()
  {
    String str = _getFieldReflectively(new Build(), "CPU_ABI");
    if ((str == null) || (str.length() == 0) || (str.equals("Unknown")))
      str = "armeabi";
    return str.toLowerCase();
  }

  private static String _getFieldReflectively(Build paramBuild, String paramString)
  {
    try
    {
      String str = Build.class.getField(paramString).get(paramBuild).toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return "Unknown";
  }

  static boolean _loadUnzipSo(String paramString, int paramInt, ClassLoader paramClassLoader)
  {
    int i = 1;
    try
    {
      if (isExist(paramString, paramInt))
      {
        if (paramClassLoader == null)
        {
          System.load(_targetSoFile(paramString, paramInt));
          return i;
        }
        Runtime localRuntime = Runtime.getRuntime();
        Method localMethod = Runtime.class.getDeclaredMethod("load", new Class[] { String.class, ClassLoader.class });
        localMethod.setAccessible(true);
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = _targetSoFile(paramString, paramInt);
        arrayOfObject[1] = paramClassLoader;
        localMethod.invoke(localRuntime, arrayOfObject);
        return i;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      return false;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      i = 0;
    }
    return i;
  }

  static String _targetSoFile(String paramString, int paramInt)
  {
    Context localContext = mContext;
    if (localContext == null)
      return "";
    String str = "/data/data/" + localContext.getPackageName() + "/files";
    File localFile = localContext.getFilesDir();
    if (localFile != null)
      str = localFile.getPath();
    return str + "/lib" + paramString + "bk" + paramInt + ".so";
  }

  public static void init(Context paramContext)
  {
    mContext = paramContext;
  }

  public static boolean initSo(String paramString, int paramInt)
  {
    return initSo(paramString, paramInt, null);
  }

  // ERROR //
  public static boolean initSo(String paramString, int paramInt, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_2
    //   3: ifnonnull +37 -> 40
    //   6: aload_0
    //   7: invokestatic 169	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   10: iload_3
    //   11: ifne +156 -> 167
    //   14: aload_0
    //   15: iload_1
    //   16: invokestatic 82	org/android/spdy/SoInstallMgrSdk:isExist	(Ljava/lang/String;I)Z
    //   19: ifeq +119 -> 138
    //   22: aload_0
    //   23: iload_1
    //   24: aload_2
    //   25: invokestatic 171	org/android/spdy/SoInstallMgrSdk:_loadUnzipSo	(Ljava/lang/String;ILjava/lang/ClassLoader;)Z
    //   28: istore 13
    //   30: iload 13
    //   32: ifeq +101 -> 133
    //   35: iload 13
    //   37: istore_3
    //   38: iload_3
    //   39: ireturn
    //   40: invokestatic 98	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   43: astore 16
    //   45: ldc 94
    //   47: ldc 172
    //   49: iconst_2
    //   50: anewarray 59	java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc 42
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc 101
    //   62: aastore
    //   63: invokevirtual 105	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   66: astore 17
    //   68: aload 17
    //   70: iconst_1
    //   71: invokevirtual 111	java/lang/reflect/Method:setAccessible	(Z)V
    //   74: aload 17
    //   76: aload 16
    //   78: iconst_2
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_2
    //   89: aastore
    //   90: invokevirtual 115	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: goto -84 -> 10
    //   97: astore 15
    //   99: aload 15
    //   101: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   104: iconst_0
    //   105: istore_3
    //   106: goto -96 -> 10
    //   109: astore 14
    //   111: aload 14
    //   113: invokevirtual 119	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   116: iconst_0
    //   117: istore_3
    //   118: goto -108 -> 10
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 120	java/lang/Error:printStackTrace	()V
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -120 -> 10
    //   133: aload_0
    //   134: iload_1
    //   135: invokestatic 176	org/android/spdy/SoInstallMgrSdk:removeSoIfExit	(Ljava/lang/String;I)V
    //   138: invokestatic 178	org/android/spdy/SoInstallMgrSdk:_cpuType	()Ljava/lang/String;
    //   141: astore 8
    //   143: aload 8
    //   145: ldc 17
    //   147: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   150: ifne +17 -> 167
    //   153: aload 8
    //   155: ldc 20
    //   157: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: istore 9
    //   162: iload 9
    //   164: ifeq +9 -> 173
    //   167: iload_3
    //   168: ifne -130 -> 38
    //   171: iload_3
    //   172: ireturn
    //   173: aload_0
    //   174: iload_1
    //   175: aload_2
    //   176: invokestatic 185	org/android/spdy/SoInstallMgrSdk:unZipSelectedFiles	(Ljava/lang/String;ILjava/lang/ClassLoader;)Z
    //   179: istore 12
    //   181: iload 12
    //   183: istore_3
    //   184: goto -17 -> 167
    //   187: astore 11
    //   189: aload 11
    //   191: invokevirtual 186	java/util/zip/ZipException:printStackTrace	()V
    //   194: goto -27 -> 167
    //   197: astore 7
    //   199: aload 7
    //   201: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   204: iconst_0
    //   205: istore_3
    //   206: goto -39 -> 167
    //   209: astore 10
    //   211: aload 10
    //   213: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   216: goto -49 -> 167
    //   219: astore 6
    //   221: aload 6
    //   223: invokevirtual 119	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -61 -> 167
    //   231: astore 5
    //   233: aload 5
    //   235: invokevirtual 120	java/lang/Error:printStackTrace	()V
    //   238: iconst_0
    //   239: istore_3
    //   240: goto -73 -> 167
    //
    // Exception table:
    //   from	to	target	type
    //   6	10	97	java/lang/Exception
    //   40	94	97	java/lang/Exception
    //   6	10	109	java/lang/UnsatisfiedLinkError
    //   40	94	109	java/lang/UnsatisfiedLinkError
    //   6	10	121	java/lang/Error
    //   40	94	121	java/lang/Error
    //   173	181	187	java/util/zip/ZipException
    //   14	30	197	java/lang/Exception
    //   133	138	197	java/lang/Exception
    //   138	162	197	java/lang/Exception
    //   173	181	197	java/lang/Exception
    //   189	194	197	java/lang/Exception
    //   211	216	197	java/lang/Exception
    //   173	181	209	java/io/IOException
    //   14	30	219	java/lang/UnsatisfiedLinkError
    //   133	138	219	java/lang/UnsatisfiedLinkError
    //   138	162	219	java/lang/UnsatisfiedLinkError
    //   173	181	219	java/lang/UnsatisfiedLinkError
    //   189	194	219	java/lang/UnsatisfiedLinkError
    //   211	216	219	java/lang/UnsatisfiedLinkError
    //   14	30	231	java/lang/Error
    //   133	138	231	java/lang/Error
    //   138	162	231	java/lang/Error
    //   173	181	231	java/lang/Error
    //   189	194	231	java/lang/Error
    //   211	216	231	java/lang/Error
  }

  static boolean isExist(String paramString, int paramInt)
  {
    return new File(_targetSoFile(paramString, paramInt)).exists();
  }

  static void removeSoIfExit(String paramString, int paramInt)
  {
    File localFile = new File(_targetSoFile(paramString, paramInt));
    if (localFile.exists())
      localFile.delete();
  }

  // ERROR //
  static boolean unZipSelectedFiles(String paramString, int paramInt, ClassLoader paramClassLoader)
    throws java.util.zip.ZipException, java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 124	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   9: ldc 198
    //   11: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 157
    //   20: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore 4
    //   28: ldc 122
    //   30: astore 5
    //   32: getstatic 26	org/android/spdy/SoInstallMgrSdk:mContext	Landroid/content/Context;
    //   35: astore 7
    //   37: aload 7
    //   39: ifnonnull +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload 7
    //   46: invokevirtual 202	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +10 -> 63
    //   56: aload 8
    //   58: getfield 207	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   61: astore 5
    //   63: new 209	java/util/zip/ZipFile
    //   66: dup
    //   67: aload 5
    //   69: invokespecial 210	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   72: astore 9
    //   74: aload 9
    //   76: invokevirtual 214	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   79: astore 10
    //   81: aload 10
    //   83: invokeinterface 219 1 0
    //   88: ifeq +215 -> 303
    //   91: aload 10
    //   93: invokeinterface 223 1 0
    //   98: checkcast 225	java/util/zip/ZipEntry
    //   101: astore 11
    //   103: aload 11
    //   105: invokevirtual 228	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   108: aload 4
    //   110: invokevirtual 231	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   113: istore 12
    //   115: iload 12
    //   117: ifeq -36 -> 81
    //   120: aload_0
    //   121: iload_1
    //   122: invokestatic 176	org/android/spdy/SoInstallMgrSdk:removeSoIfExit	(Ljava/lang/String;I)V
    //   125: aload 9
    //   127: aload 11
    //   129: invokevirtual 235	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   132: astore 19
    //   134: aload 19
    //   136: astore 15
    //   138: aload 7
    //   140: new 124	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   147: ldc 237
    //   149: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 152
    //   158: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload_1
    //   162: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: ldc 157
    //   167: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: iconst_0
    //   174: invokevirtual 241	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   177: astore 20
    //   179: aload 20
    //   181: astore 14
    //   183: aload 14
    //   185: invokevirtual 247	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   188: astore_3
    //   189: sipush 1024
    //   192: newarray byte
    //   194: astore 21
    //   196: iconst_0
    //   197: istore 22
    //   199: aload 15
    //   201: aload 21
    //   203: invokevirtual 253	java/io/InputStream:read	([B)I
    //   206: istore 23
    //   208: iload 23
    //   210: ifle +26 -> 236
    //   213: aload_3
    //   214: aload 21
    //   216: iconst_0
    //   217: iload 23
    //   219: invokestatic 259	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   222: invokevirtual 265	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   225: pop
    //   226: iload 22
    //   228: iload 23
    //   230: iadd
    //   231: istore 22
    //   233: goto -34 -> 199
    //   236: aload 15
    //   238: ifnull +8 -> 246
    //   241: aload 15
    //   243: invokevirtual 268	java/io/InputStream:close	()V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 269	java/nio/channels/FileChannel:close	()V
    //   254: aload 14
    //   256: ifnull +8 -> 264
    //   259: aload 14
    //   261: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   264: aload 9
    //   266: ifnull +8 -> 274
    //   269: aload 9
    //   271: invokevirtual 271	java/util/zip/ZipFile:close	()V
    //   274: iload 22
    //   276: ifle +128 -> 404
    //   279: aload_0
    //   280: iload_1
    //   281: aload_2
    //   282: invokestatic 171	org/android/spdy/SoInstallMgrSdk:_loadUnzipSo	(Ljava/lang/String;ILjava/lang/ClassLoader;)Z
    //   285: ireturn
    //   286: astore 27
    //   288: aload 27
    //   290: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   293: goto -47 -> 246
    //   296: astore 6
    //   298: aload 6
    //   300: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore 26
    //   307: aload 26
    //   309: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   312: goto -58 -> 254
    //   315: astore 25
    //   317: aload 25
    //   319: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   322: goto -58 -> 264
    //   325: astore 13
    //   327: aconst_null
    //   328: astore 14
    //   330: aconst_null
    //   331: astore 15
    //   333: aload 15
    //   335: ifnull +8 -> 343
    //   338: aload 15
    //   340: invokevirtual 268	java/io/InputStream:close	()V
    //   343: aload_3
    //   344: ifnull +7 -> 351
    //   347: aload_3
    //   348: invokevirtual 269	java/nio/channels/FileChannel:close	()V
    //   351: aload 14
    //   353: ifnull +8 -> 361
    //   356: aload 14
    //   358: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   361: aload 9
    //   363: ifnull +8 -> 371
    //   366: aload 9
    //   368: invokevirtual 271	java/util/zip/ZipFile:close	()V
    //   371: aload 13
    //   373: athrow
    //   374: astore 18
    //   376: aload 18
    //   378: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   381: goto -38 -> 343
    //   384: astore 17
    //   386: aload 17
    //   388: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   391: goto -40 -> 351
    //   394: astore 16
    //   396: aload 16
    //   398: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   401: goto -40 -> 361
    //   404: iconst_0
    //   405: ireturn
    //   406: astore 13
    //   408: aconst_null
    //   409: astore_3
    //   410: aconst_null
    //   411: astore 14
    //   413: goto -80 -> 333
    //   416: astore 13
    //   418: goto -85 -> 333
    //
    // Exception table:
    //   from	to	target	type
    //   241	246	286	java/lang/Exception
    //   32	37	296	java/io/IOException
    //   44	51	296	java/io/IOException
    //   56	63	296	java/io/IOException
    //   63	81	296	java/io/IOException
    //   81	115	296	java/io/IOException
    //   241	246	296	java/io/IOException
    //   250	254	296	java/io/IOException
    //   259	264	296	java/io/IOException
    //   269	274	296	java/io/IOException
    //   279	286	296	java/io/IOException
    //   288	293	296	java/io/IOException
    //   307	312	296	java/io/IOException
    //   317	322	296	java/io/IOException
    //   338	343	296	java/io/IOException
    //   347	351	296	java/io/IOException
    //   356	361	296	java/io/IOException
    //   366	371	296	java/io/IOException
    //   371	374	296	java/io/IOException
    //   376	381	296	java/io/IOException
    //   386	391	296	java/io/IOException
    //   396	401	296	java/io/IOException
    //   250	254	305	java/lang/Exception
    //   259	264	315	java/lang/Exception
    //   120	134	325	finally
    //   338	343	374	java/lang/Exception
    //   347	351	384	java/lang/Exception
    //   356	361	394	java/lang/Exception
    //   138	179	406	finally
    //   183	196	416	finally
    //   199	208	416	finally
    //   213	226	416	finally
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.SoInstallMgrSdk
 * JD-Core Version:    0.6.0
 */