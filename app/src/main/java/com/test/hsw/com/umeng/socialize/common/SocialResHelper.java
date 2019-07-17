package com.umeng.socialize.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.umeng.socialize.b.b.a;
import com.umeng.socialize.b.b.h.a;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.i;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Stack;

public class SocialResHelper
{
  public static boolean a = false;
  private static final String b = SocialResHelper.class.getName();
  private static final long c = 104857600L;
  private static final long d = 10485760L;
  private static final String e = "/download/.um/";

  static
  {
    a = false;
  }

  private static long a(File paramFile)
  {
    long l1;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
      l1 = 0L;
    while (true)
    {
      return l1;
      Stack localStack = new Stack();
      localStack.clear();
      localStack.push(paramFile);
      l1 = 0L;
      while (!localStack.isEmpty())
      {
        File[] arrayOfFile = ((File)localStack.pop()).listFiles();
        long l2 = l1;
        int i = 0;
        if (i < arrayOfFile.length)
        {
          long l3;
          if (arrayOfFile[i].isDirectory())
          {
            localStack.push(arrayOfFile[i]);
            l3 = l2;
          }
          while (true)
          {
            i++;
            l2 = l3;
            break;
            l3 = l2 + arrayOfFile[i].length();
          }
        }
        l1 = l2;
      }
    }
  }

  // ERROR //
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 82	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   16: aload_1
    //   17: invokestatic 86	com/umeng/socialize/common/SocialResHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 92
    //   25: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore 4
    //   33: invokestatic 99	com/umeng/socialize/utils/c:a	()Z
    //   36: ifeq +173 -> 209
    //   39: invokestatic 105	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   42: invokevirtual 108	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   45: astore 5
    //   47: ldc2_w 12
    //   50: lstore 6
    //   52: new 37	java/io/File
    //   55: dup
    //   56: new 82	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   63: aload 5
    //   65: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 19
    //   70: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 8
    //   81: aload 8
    //   83: invokevirtual 41	java/io/File:exists	()Z
    //   86: ifeq +140 -> 226
    //   89: aload 8
    //   91: invokevirtual 114	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   94: invokestatic 116	com/umeng/socialize/common/SocialResHelper:a	(Ljava/io/File;)J
    //   97: lload 6
    //   99: lcmp
    //   100: ifle +8 -> 108
    //   103: aload 8
    //   105: invokestatic 119	com/umeng/socialize/common/SocialResHelper:b	(Ljava/io/File;)V
    //   108: new 37	java/io/File
    //   111: dup
    //   112: aload 8
    //   114: aload 4
    //   116: invokespecial 122	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   119: astore_3
    //   120: aload_3
    //   121: invokevirtual 125	java/io/File:createNewFile	()Z
    //   124: pop
    //   125: aload_1
    //   126: aload_3
    //   127: invokestatic 128	com/umeng/socialize/common/SocialResHelper:a	(Ljava/lang/String;Ljava/io/File;)V
    //   130: new 37	java/io/File
    //   133: dup
    //   134: aload_3
    //   135: invokevirtual 131	java/io/File:getParent	()Ljava/lang/String;
    //   138: aload_3
    //   139: invokevirtual 132	java/io/File:getName	()Ljava/lang/String;
    //   142: ldc 92
    //   144: ldc 134
    //   146: invokevirtual 140	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   149: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: astore 10
    //   154: aload_3
    //   155: aload 10
    //   157: invokevirtual 147	java/io/File:renameTo	(Ljava/io/File;)Z
    //   160: pop
    //   161: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   164: new 82	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   171: ldc 149
    //   173: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 151
    //   182: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 10
    //   187: invokevirtual 108	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   190: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 155	com/umeng/socialize/utils/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 10
    //   201: invokevirtual 108	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   204: astore 12
    //   206: aload 12
    //   208: areturn
    //   209: aload_0
    //   210: invokevirtual 160	android/content/Context:getCacheDir	()Ljava/io/File;
    //   213: invokevirtual 108	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   216: astore 5
    //   218: ldc2_w 15
    //   221: lstore 6
    //   223: goto -171 -> 52
    //   226: aload 8
    //   228: invokevirtual 163	java/io/File:mkdirs	()Z
    //   231: ifne -123 -> 108
    //   234: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   237: new 82	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   244: ldc 165
    //   246: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 8
    //   251: invokevirtual 168	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   254: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 170
    //   259: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 172	com/umeng/socialize/utils/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: goto -160 -> 108
    //   271: astore_2
    //   272: aconst_null
    //   273: astore_3
    //   274: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   277: new 82	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   284: aload_2
    //   285: invokevirtual 176	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   288: invokevirtual 177	java/lang/Object:toString	()Ljava/lang/String;
    //   291: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 179
    //   296: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 155	com/umeng/socialize/utils/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_3
    //   310: ifnull -303 -> 7
    //   313: aload_3
    //   314: invokevirtual 41	java/io/File:exists	()Z
    //   317: ifeq -310 -> 7
    //   320: aload_3
    //   321: invokevirtual 182	java/io/File:deleteOnExit	()V
    //   324: aconst_null
    //   325: areturn
    //   326: astore_2
    //   327: goto -53 -> 274
    //
    // Exception table:
    //   from	to	target	type
    //   9	47	271	java/lang/Exception
    //   52	108	271	java/lang/Exception
    //   108	120	271	java/lang/Exception
    //   209	218	271	java/lang/Exception
    //   226	268	271	java/lang/Exception
    //   120	206	326	java/lang/Exception
  }

  private static String a(String paramString)
  {
    return a.c(paramString);
  }

  // ERROR //
  private static void a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 190	java/io/FileOutputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 192	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   10: astore_3
    //   11: new 194	java/net/URL
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 195	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 199	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: invokevirtual 204	java/net/URLConnection:getContent	()Ljava/lang/Object;
    //   25: checkcast 206	java/io/InputStream
    //   28: astore 11
    //   30: sipush 4096
    //   33: newarray byte
    //   35: astore 14
    //   37: aload 11
    //   39: aload 14
    //   41: invokevirtual 210	java/io/InputStream:read	([B)I
    //   44: istore 15
    //   46: iload 15
    //   48: iconst_m1
    //   49: if_icmpeq +55 -> 104
    //   52: aload_3
    //   53: aload 14
    //   55: iconst_0
    //   56: iload 15
    //   58: invokevirtual 214	java/io/FileOutputStream:write	([BII)V
    //   61: goto -24 -> 37
    //   64: astore 13
    //   66: aload 11
    //   68: astore_2
    //   69: aload 13
    //   71: astore 4
    //   73: new 216	java/lang/RuntimeException
    //   76: dup
    //   77: aload 4
    //   79: invokespecial 219	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   82: athrow
    //   83: astore 5
    //   85: aload_2
    //   86: ifnull +15 -> 101
    //   89: aload_2
    //   90: invokevirtual 222	java/io/InputStream:close	()V
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   101: aload 5
    //   103: athrow
    //   104: aload_3
    //   105: invokevirtual 226	java/io/FileOutputStream:flush	()V
    //   108: aload 11
    //   110: ifnull +16 -> 126
    //   113: aload 11
    //   115: invokevirtual 222	java/io/InputStream:close	()V
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   126: return
    //   127: astore 20
    //   129: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   132: aload 20
    //   134: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   137: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: return
    //   141: astore 18
    //   143: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   146: aload 18
    //   148: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   151: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_3
    //   155: ifnull -29 -> 126
    //   158: aload_3
    //   159: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   162: return
    //   163: astore 19
    //   165: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   168: aload 19
    //   170: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   173: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: return
    //   177: astore 16
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   187: aload 16
    //   189: athrow
    //   190: astore 17
    //   192: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   195: aload 17
    //   197: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   200: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: goto -16 -> 187
    //   206: astore 10
    //   208: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   211: aload 10
    //   213: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   216: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -118 -> 101
    //   222: astore 8
    //   224: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   227: aload 8
    //   229: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   232: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_3
    //   236: ifnull -135 -> 101
    //   239: aload_3
    //   240: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   243: goto -142 -> 101
    //   246: astore 9
    //   248: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   251: aload 9
    //   253: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   256: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto -158 -> 101
    //   262: astore 6
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   272: aload 6
    //   274: athrow
    //   275: astore 7
    //   277: getstatic 29	com/umeng/socialize/common/SocialResHelper:b	Ljava/lang/String;
    //   280: aload 7
    //   282: invokevirtual 229	java/io/IOException:getMessage	()Ljava/lang/String;
    //   285: invokestatic 231	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -16 -> 272
    //   291: astore 5
    //   293: aconst_null
    //   294: astore_2
    //   295: aconst_null
    //   296: astore_3
    //   297: goto -212 -> 85
    //   300: astore 12
    //   302: aload 11
    //   304: astore_2
    //   305: aload 12
    //   307: astore 5
    //   309: goto -224 -> 85
    //   312: astore 4
    //   314: aconst_null
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_3
    //   318: goto -245 -> 73
    //   321: astore 4
    //   323: aconst_null
    //   324: astore_2
    //   325: goto -252 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   30	37	64	java/lang/Exception
    //   37	46	64	java/lang/Exception
    //   52	61	64	java/lang/Exception
    //   104	108	64	java/lang/Exception
    //   11	30	83	finally
    //   73	83	83	finally
    //   122	126	127	java/io/IOException
    //   113	118	141	java/io/IOException
    //   158	162	163	java/io/IOException
    //   113	118	177	finally
    //   143	154	177	finally
    //   183	187	190	java/io/IOException
    //   97	101	206	java/io/IOException
    //   89	93	222	java/io/IOException
    //   239	243	246	java/io/IOException
    //   89	93	262	finally
    //   224	235	262	finally
    //   268	272	275	java/io/IOException
    //   2	11	291	finally
    //   30	37	300	finally
    //   37	46	300	finally
    //   52	61	300	finally
    //   104	108	300	finally
    //   2	11	312	java/lang/Exception
    //   11	30	321	java/lang/Exception
  }

  private static Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    if (a)
      localCanvas.drawRoundRect(localRectF, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, localPaint);
    while (true)
    {
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
      paramBitmap.recycle();
      return localBitmap;
      localCanvas.drawRoundRect(localRectF, paramBitmap.getWidth() / 6, paramBitmap.getHeight() / 6, localPaint);
    }
  }

  protected static File b(Context paramContext, String paramString)
    throws IOException
  {
    String str1 = a(paramString);
    if (c.a());
    for (String str2 = Environment.getExternalStorageDirectory().getCanonicalPath(); ; str2 = paramContext.getCacheDir().getCanonicalPath())
    {
      File localFile = new File(new File(str2 + "/download/.um/"), str1);
      if (!localFile.exists())
        break;
      return localFile;
    }
    return null;
  }

  private static void b(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.canWrite()) || (!paramFile.isDirectory()))
      return;
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    label33: if (i < arrayOfFile.length)
    {
      if (!arrayOfFile[i].isDirectory())
        break label60;
      b(arrayOfFile[i]);
    }
    while (true)
    {
      i++;
      break label33;
      break;
      label60: if (new Date().getTime() - arrayOfFile[i].lastModified() <= 1800L)
        continue;
      arrayOfFile[i].delete();
    }
  }

  public static abstract interface BindDrawableListener
  {
    public abstract void a(h.a parama, File paramFile, Drawable paramDrawable);

    public abstract void a(SocialResHelper.b paramb);

    public abstract void a(SocialResHelper.c paramc);
  }

  public static class a
  {
    Context a;
    ImageView b;
    String c;
    SocialResHelper.BindDrawableListener d;
    int e = -1;
    Animation f;
    SocialResHelper.c g = SocialResHelper.c.a;
    boolean h = false;
    boolean i = false;

    public a(Context paramContext, ImageView paramImageView, String paramString)
    {
      if ((paramContext == null) || (paramImageView == null) || (TextUtils.isEmpty(paramString)))
        return;
      this.a = paramContext;
      this.b = paramImageView;
      this.c = paramString;
    }

    private void a(Context paramContext, ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, SocialResHelper.BindDrawableListener paramBindDrawableListener, Animation paramAnimation, boolean paramBoolean2, int paramInt)
    {
      if ((paramDrawable == null) || (paramImageView == null))
      {
        if ((paramImageView != null) && (paramInt > 0))
          paramImageView.setImageResource(paramInt);
        if (paramBindDrawableListener != null)
          paramBindDrawableListener.a(h.a.b, null, paramDrawable);
        i.e(SocialResHelper.a(), "bind drawable failed. drawable [" + paramDrawable + "]  imageView[+" + paramImageView + "+]");
      }
      while (true)
      {
        return;
        if (paramBoolean2)
        {
          Bitmap localBitmap = SocialResHelper.a(((BitmapDrawable)paramDrawable).getBitmap());
          paramDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap);
        }
        if (paramBoolean1 == true)
        {
          paramImageView.setBackground(paramDrawable);
          if (paramAnimation != null)
            paramImageView.startAnimation(paramAnimation);
        }
        try
        {
          File localFile2 = SocialResHelper.b(this.a, this.c);
          localFile1 = localFile2;
          if (paramBindDrawableListener == null)
            continue;
          paramBindDrawableListener.a(h.a.a, localFile1, paramDrawable);
          return;
          paramImageView.setImageDrawable(paramDrawable);
        }
        catch (IOException localIOException)
        {
          while (true)
          {
            localIOException.printStackTrace();
            File localFile1 = null;
          }
        }
      }
    }

    private void a(Drawable paramDrawable)
    {
      if (paramDrawable == null)
      {
        new o(this).execute(new Object[0]);
        return;
      }
      a(this.a, this.b, paramDrawable, this.i, this.d, this.f, this.h, this.e);
    }

    public a a(int paramInt)
    {
      this.e = paramInt;
      return this;
    }

    public a a(Animation paramAnimation)
    {
      this.f = paramAnimation;
      return this;
    }

    public a a(SocialResHelper.BindDrawableListener paramBindDrawableListener)
    {
      this.d = paramBindDrawableListener;
      return this;
    }

    public a a(SocialResHelper.c paramc)
    {
      this.g = paramc;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }

    public void a()
    {
      File localFile1;
      try
      {
        File localFile2 = SocialResHelper.b(this.a, this.c);
        localFile1 = localFile2;
        switch (n.a[this.g.ordinal()])
        {
        default:
          return;
        case 1:
        case 2:
        case 3:
        }
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          i.b(SocialResHelper.a(), "can't get from cache.", localIOException);
          if (this.d != null)
            this.d.a(h.a.b, null, null);
          localFile1 = null;
        }
        if (this.d != null)
        {
          this.d.a(SocialResHelper.c.b);
          this.d.a(SocialResHelper.b.a);
        }
        if ((localFile1 != null) && (localFile1.exists()))
        {
          Drawable localDrawable2 = Drawable.createFromPath(localFile1.getAbsolutePath());
          if (localDrawable2 == null)
            localFile1.delete();
          a(this.a, this.b, localDrawable2, this.i, this.d, this.f, this.h, this.e);
          return;
        }
        i.b(SocialResHelper.a(), "cache is not exists");
        return;
      }
      if (this.d != null)
      {
        this.d.a(SocialResHelper.c.a);
        this.d.a(SocialResHelper.b.a);
      }
      if ((localFile1 != null) && (localFile1.exists()))
      {
        Drawable localDrawable1 = Drawable.createFromPath(localFile1.getAbsolutePath());
        if (localDrawable1 == null)
          localFile1.delete();
        a(this.a, this.b, localDrawable1, this.i, this.d, this.f, this.h, this.e);
        return;
      }
      a(null);
      return;
      if (this.d != null)
        this.d.a(SocialResHelper.c.c);
      a(null);
    }

    public a b(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      c = arrayOfb;
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[3];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      d = arrayOfc;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.common.SocialResHelper
 * JD-Core Version:    0.6.0
 */