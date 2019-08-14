package com.a.a.b.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Video.Thumbnails;
import com.a.a.c.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class a
  implements b
{
  public static final int a = 5000;
  public static final int b = 20000;
  protected static final int c = 32768;
  protected static final String d = "@#&=*+-_.,:!?()/~'%";
  protected static final int e = 5;
  protected static final String f = "content://com.android.contacts/";
  private static final String j = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
  protected final Context g;
  protected final int h;
  protected final int i;

  public a(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    this.h = 5000;
    this.i = 20000;
  }

  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.g = paramContext.getApplicationContext();
    this.h = paramInt1;
    this.i = paramInt2;
  }

  private boolean a(Uri paramUri)
  {
    String str = this.g.getContentResolver().getType(paramUri);
    if (str == null)
      return false;
    return str.startsWith("video/");
  }

  public InputStream a(String paramString, Object paramObject)
    throws IOException
  {
    switch (1.a[b.a.a(paramString).ordinal()])
    {
    default:
      return h(paramString, paramObject);
    case 1:
    case 2:
      return b(paramString, paramObject);
    case 3:
      return d(paramString, paramObject);
    case 4:
      return e(paramString, paramObject);
    case 5:
      return f(paramString, paramObject);
    case 6:
    }
    return g(paramString, paramObject);
  }

  protected InputStream b(String paramString, Object paramObject)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = c(paramString, paramObject);
    for (int k = 0; (localHttpURLConnection.getResponseCode() / 100 == 3) && (k < 5); k++)
      localHttpURLConnection = c(localHttpURLConnection.getHeaderField("Location"), paramObject);
    try
    {
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      return new com.a.a.b.a.a(new BufferedInputStream(localInputStream, 32768), localHttpURLConnection.getContentLength());
    }
    catch (IOException localIOException)
    {
      c.a(localHttpURLConnection.getErrorStream());
    }
    throw localIOException;
  }

  protected HttpURLConnection c(String paramString, Object paramObject)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%")).openConnection();
    localHttpURLConnection.setConnectTimeout(this.h);
    localHttpURLConnection.setReadTimeout(this.i);
    return localHttpURLConnection;
  }

  protected InputStream d(String paramString, Object paramObject)
    throws IOException
  {
    String str = b.a.c.c(paramString);
    return new com.a.a.b.a.a(new BufferedInputStream(new FileInputStream(str), 32768), (int)new File(str).length());
  }

  protected InputStream e(String paramString, Object paramObject)
    throws FileNotFoundException
  {
    ContentResolver localContentResolver = this.g.getContentResolver();
    Uri localUri = Uri.parse(paramString);
    if (a(localUri))
    {
      Bitmap localBitmap = MediaStore.Video.Thumbnails.getThumbnail(localContentResolver, Long.valueOf(localUri.getLastPathSegment()).longValue(), 1, null);
      if (localBitmap != null)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
        return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
      }
    }
    else if (paramString.startsWith("content://com.android.contacts/"))
    {
      return ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, localUri);
    }
    return localContentResolver.openInputStream(localUri);
  }

  protected InputStream f(String paramString, Object paramObject)
    throws IOException
  {
    String str = b.a.e.c(paramString);
    return this.g.getAssets().open(str);
  }

  protected InputStream g(String paramString, Object paramObject)
  {
    int k = Integer.parseInt(b.a.f.c(paramString));
    return this.g.getResources().openRawResource(k);
  }

  protected InputStream h(String paramString, Object paramObject)
    throws IOException
  {
    throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] { paramString }));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.d.a
 * JD-Core Version:    0.6.0
 */