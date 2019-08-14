package com.baidu.location.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import com.baidu.location.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static volatile e a = null;
  private static final String jdField_do = "test.0";
  public static String jdField_int = jdField_do().jdMethod_for() + "/baidu/tempdata";
  private final List jdField_for = new ArrayList();
  private Context jdField_if;

  private e(Context paramContext)
  {
    this.jdField_if = paramContext;
  }

  // ERROR //
  private List a()
  {
    // Byte code:
    //   0: new 45	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 46	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: new 45	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 46	java/util/ArrayList:<init>	()V
    //   15: astore_2
    //   16: new 55	java/io/File
    //   19: dup
    //   20: ldc 57
    //   22: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 64	java/io/File:exists	()Z
    //   30: ifeq +106 -> 136
    //   33: new 66	java/util/Scanner
    //   36: dup
    //   37: aload_3
    //   38: invokespecial 69	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   41: astore 7
    //   43: aload 7
    //   45: invokevirtual 72	java/util/Scanner:hasNext	()Z
    //   48: ifeq +83 -> 131
    //   51: aload 7
    //   53: invokevirtual 75	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   56: astore 19
    //   58: aload 19
    //   60: ldc 77
    //   62: invokevirtual 83	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   65: ifeq -22 -> 43
    //   68: aload 19
    //   70: bipush 9
    //   72: bipush 32
    //   74: invokevirtual 87	java/lang/String:replace	(CC)Ljava/lang/String;
    //   77: ldc 89
    //   79: invokevirtual 93	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   82: astore 20
    //   84: aload 20
    //   86: ifnull -43 -> 43
    //   89: aload 20
    //   91: arraylength
    //   92: ifle -49 -> 43
    //   95: aload_1
    //   96: aload 20
    //   98: iconst_1
    //   99: aaload
    //   100: invokeinterface 99 2 0
    //   105: pop
    //   106: goto -63 -> 43
    //   109: astore 6
    //   111: aload 6
    //   113: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   116: aload 7
    //   118: ifnull +8 -> 126
    //   121: aload 7
    //   123: invokevirtual 105	java/util/Scanner:close	()V
    //   126: aload_0
    //   127: getfield 48	com/baidu/location/b/e:jdField_for	Ljava/util/List;
    //   130: areturn
    //   131: aload 7
    //   133: invokevirtual 105	java/util/Scanner:close	()V
    //   136: new 55	java/io/File
    //   139: dup
    //   140: ldc 107
    //   142: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore 8
    //   147: aload 8
    //   149: invokevirtual 64	java/io/File:exists	()Z
    //   152: ifeq +133 -> 285
    //   155: new 66	java/util/Scanner
    //   158: dup
    //   159: aload 8
    //   161: invokespecial 69	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   164: astore 7
    //   166: aload 7
    //   168: invokevirtual 72	java/util/Scanner:hasNext	()Z
    //   171: ifeq +109 -> 280
    //   174: aload 7
    //   176: invokevirtual 75	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   179: astore 15
    //   181: aload 15
    //   183: ldc 109
    //   185: invokevirtual 83	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   188: ifeq -22 -> 166
    //   191: aload 15
    //   193: bipush 9
    //   195: bipush 32
    //   197: invokevirtual 87	java/lang/String:replace	(CC)Ljava/lang/String;
    //   200: ldc 89
    //   202: invokevirtual 93	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   205: astore 16
    //   207: aload 16
    //   209: ifnull -43 -> 166
    //   212: aload 16
    //   214: arraylength
    //   215: ifle -49 -> 166
    //   218: aload 16
    //   220: iconst_2
    //   221: aaload
    //   222: astore 17
    //   224: aload 17
    //   226: ldc 111
    //   228: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   231: ifeq +18 -> 249
    //   234: aload 17
    //   236: iconst_0
    //   237: aload 17
    //   239: ldc 111
    //   241: invokevirtual 119	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   244: invokevirtual 123	java/lang/String:substring	(II)Ljava/lang/String;
    //   247: astore 17
    //   249: aload_2
    //   250: aload 17
    //   252: invokeinterface 99 2 0
    //   257: pop
    //   258: goto -92 -> 166
    //   261: astore 4
    //   263: aload 7
    //   265: astore 5
    //   267: aload 5
    //   269: ifnull +8 -> 277
    //   272: aload 5
    //   274: invokevirtual 105	java/util/Scanner:close	()V
    //   277: aload 4
    //   279: athrow
    //   280: aload 7
    //   282: invokevirtual 105	java/util/Scanner:close	()V
    //   285: invokestatic 129	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   288: invokevirtual 132	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   291: astore 9
    //   293: aload_0
    //   294: getfield 48	com/baidu/location/b/e:jdField_for	Ljava/util/List;
    //   297: new 134	com/baidu/location/b/a
    //   300: dup
    //   301: aload 9
    //   303: iconst_0
    //   304: ldc 136
    //   306: invokespecial 139	com/baidu/location/b/a:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   309: invokeinterface 99 2 0
    //   314: pop
    //   315: aload_1
    //   316: invokeinterface 143 1 0
    //   321: astore 11
    //   323: aload 11
    //   325: invokeinterface 146 1 0
    //   330: ifeq +104 -> 434
    //   333: aload 11
    //   335: invokeinterface 150 1 0
    //   340: checkcast 79	java/lang/String
    //   343: astore 12
    //   345: aload_2
    //   346: aload 12
    //   348: invokeinterface 152 2 0
    //   353: ifeq -30 -> 323
    //   356: aload 12
    //   358: aload 9
    //   360: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   363: ifne -40 -> 323
    //   366: new 55	java/io/File
    //   369: dup
    //   370: aload 12
    //   372: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   375: astore 13
    //   377: aload 13
    //   379: invokevirtual 64	java/io/File:exists	()Z
    //   382: ifeq -59 -> 323
    //   385: aload 13
    //   387: invokevirtual 158	java/io/File:isDirectory	()Z
    //   390: ifeq -67 -> 323
    //   393: aload 13
    //   395: invokevirtual 161	java/io/File:canWrite	()Z
    //   398: ifeq -75 -> 323
    //   401: aload_0
    //   402: getfield 48	com/baidu/location/b/e:jdField_for	Ljava/util/List;
    //   405: new 134	com/baidu/location/b/a
    //   408: dup
    //   409: aload 12
    //   411: iconst_0
    //   412: ldc 136
    //   414: invokespecial 139	com/baidu/location/b/a:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   417: invokeinterface 99 2 0
    //   422: pop
    //   423: goto -100 -> 323
    //   426: astore 6
    //   428: aconst_null
    //   429: astore 7
    //   431: goto -320 -> 111
    //   434: iconst_0
    //   435: ifeq -309 -> 126
    //   438: aconst_null
    //   439: invokevirtual 105	java/util/Scanner:close	()V
    //   442: goto -316 -> 126
    //   445: astore 4
    //   447: aconst_null
    //   448: astore 5
    //   450: goto -183 -> 267
    //   453: astore 4
    //   455: aload 7
    //   457: astore 5
    //   459: goto -192 -> 267
    //   462: astore 4
    //   464: aload 7
    //   466: astore 5
    //   468: goto -201 -> 267
    //
    // Exception table:
    //   from	to	target	type
    //   43	84	109	java/lang/Exception
    //   89	106	109	java/lang/Exception
    //   131	136	109	java/lang/Exception
    //   166	207	109	java/lang/Exception
    //   212	249	109	java/lang/Exception
    //   249	258	109	java/lang/Exception
    //   280	285	109	java/lang/Exception
    //   166	207	261	finally
    //   212	249	261	finally
    //   249	258	261	finally
    //   280	285	261	finally
    //   16	43	426	java/lang/Exception
    //   136	166	426	java/lang/Exception
    //   285	323	426	java/lang/Exception
    //   323	423	426	java/lang/Exception
    //   16	43	445	finally
    //   136	166	445	finally
    //   285	323	445	finally
    //   323	423	445	finally
    //   43	84	453	finally
    //   89	106	453	finally
    //   131	136	453	finally
    //   111	116	462	finally
  }

  // ERROR //
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 55	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: ldc 10
    //   7: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 64	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_2
    //   19: invokevirtual 167	java/io/File:delete	()Z
    //   22: pop
    //   23: aload_2
    //   24: invokevirtual 170	java/io/File:createNewFile	()Z
    //   27: istore 6
    //   29: iload 6
    //   31: istore 4
    //   33: aload_2
    //   34: invokevirtual 64	java/io/File:exists	()Z
    //   37: ifeq +8 -> 45
    //   40: aload_2
    //   41: invokevirtual 167	java/io/File:delete	()Z
    //   44: pop
    //   45: iload 4
    //   47: ireturn
    //   48: astore_3
    //   49: iconst_0
    //   50: istore 4
    //   52: aload_3
    //   53: astore 5
    //   55: aload 5
    //   57: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   60: iload 4
    //   62: ireturn
    //   63: astore 5
    //   65: goto -10 -> 55
    //
    // Exception table:
    //   from	to	target	type
    //   0	23	48	java/lang/Exception
    //   23	29	48	java/lang/Exception
    //   33	45	63	java/lang/Exception
  }

  public static e jdField_do()
  {
    if (a == null)
      monitorenter;
    try
    {
      if (a == null)
        a = new e(f.getServiceContext());
      return a;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private List jdField_int()
  {
    try
    {
      StorageManager localStorageManager = (StorageManager)this.jdField_if.getSystemService("storage");
      Method localMethod1 = localStorageManager.getClass().getMethod("getVolumeList", new Class[0]);
      Method localMethod2 = localStorageManager.getClass().getMethod("getVolumeState", new Class[] { String.class });
      Class localClass = Class.forName("android.os.storage.StorageVolume");
      Method localMethod3 = localClass.getMethod("isRemovable", new Class[0]);
      Method localMethod4 = localClass.getMethod("getPath", new Class[0]);
      Object[] arrayOfObject = (Object[])(Object[])localMethod1.invoke(localStorageManager, new Object[0]);
      label199: label233: File[] arrayOfFile;
      ArrayList localArrayList;
      if (arrayOfObject != null)
      {
        int i = arrayOfObject.length;
        j = 0;
        if (j < i)
        {
          Object localObject = arrayOfObject[j];
          String str1 = (String)localMethod4.invoke(localObject, new Object[0]);
          if ((str1 == null) || (str1.length() <= 0))
            break label471;
          if (!"mounted".equals(localMethod2.invoke(localStorageManager, new Object[] { str1 })))
            break label471;
          if (((Boolean)localMethod3.invoke(localObject, new Object[0])).booleanValue())
            break label477;
          k = 1;
          if ((Build.VERSION.SDK_INT > 19) || (!a(str1)))
            break label471;
          List localList = this.jdField_for;
          if (k != 0)
            break label483;
          bool = true;
          break label458;
          localList.add(new a(str1, bool, str2));
          break label471;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          arrayOfFile = this.jdField_if.getExternalFilesDirs(null);
          localArrayList = new ArrayList();
          localArrayList.addAll(this.jdField_for);
        }
      }
      for (int m = 0; ; m++)
      {
        if ((m >= arrayOfFile.length) || (arrayOfFile[m] == null))
        {
          this.jdField_for.clear();
          this.jdField_for.addAll(localArrayList);
          return this.jdField_for;
        }
        String str3 = arrayOfFile[m].getAbsolutePath();
        Iterator localIterator = this.jdField_for.iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (!str3.startsWith(((a)localIterator.next()).jdField_do()));
        n = 1;
        if ((n != 0) || (str3.indexOf(this.jdField_if.getPackageName()) == -1))
          continue;
        localArrayList.add(new a(str3, true, "External Storage"));
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        int j;
        int k;
        boolean bool;
        localException.printStackTrace();
        continue;
        int n = 0;
        continue;
        while (true)
        {
          label458: if (k == 0)
            break label489;
          str2 = "Internal Storage";
          break label233;
          label471: j++;
          break;
          label477: k = 0;
          break label199;
          label483: bool = false;
        }
        label489: String str2 = "External Storage";
      }
    }
  }

  public String jdField_for()
  {
    List localList = jdField_if();
    if ((localList == null) || (localList.size() == 0))
      return null;
    return ((a)localList.get(0)).jdField_do();
  }

  public List jdField_if()
  {
    int i = Build.VERSION.SDK_INT;
    List localList = null;
    if (i >= 14)
      localList = jdField_int();
    if ((localList != null) && (localList.size() > 0))
      return localList;
    return a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.e
 * JD-Core Version:    0.6.0
 */