package com.umeng.message.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class ep
{
  public static final String A = "POST";
  public static final String B = "PUT";
  public static final String C = "TRACE";
  public static final String D = "charset";
  private static final String E = "00content0boundary00";
  private static final String F = "multipart/form-data; boundary=00content0boundary00";
  private static final String G = "\r\n";
  private static final String[] H = new String[0];
  private static SSLSocketFactory I;
  private static HostnameVerifier J;
  private static c K = c.a;
  public static final String a = "UTF-8";
  public static final String b = "application/x-www-form-urlencoded";
  public static final String c = "application/json";
  public static final String d = "gzip";
  public static final String e = "Accept";
  public static final String f = "Accept-Charset";
  public static final String g = "Accept-Encoding";
  public static final String h = "Authorization";
  public static final String i = "Cache-Control";
  public static final String j = "Content-Encoding";
  public static final String k = "Content-Length";
  public static final String l = "Content-Type";
  public static final String m = "Date";
  public static final String n = "ETag";
  public static final String o = "Expires";
  public static final String p = "If-None-Match";
  public static final String q = "Last-Modified";
  public static final String r = "Location";
  public static final String s = "Proxy-Authorization";
  public static final String t = "Referer";
  public static final String u = "Server";
  public static final String v = "User-Agent";
  public static final String w = "DELETE";
  public static final String x = "GET";
  public static final String y = "HEAD";
  public static final String z = "OPTIONS";
  private HttpURLConnection L = null;
  private final URL M;
  private final String N;
  private g O;
  private boolean P;
  private boolean Q;
  private boolean R = true;
  private boolean S = false;
  private int T = 8192;
  private String U;
  private int V;

  public ep(CharSequence paramCharSequence, String paramString)
    throws ep.e
  {
    try
    {
      this.M = new URL(paramCharSequence.toString());
      this.N = paramString;
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
    throw new e(localMalformedURLException);
  }

  public ep(URL paramURL, String paramString)
    throws ep.e
  {
    this.M = paramURL;
    this.N = paramString;
  }

  private static SSLSocketFactory R()
    throws ep.e
  {
    TrustManager[] arrayOfTrustManager;
    if (I == null)
    {
      arrayOfTrustManager = new TrustManager[1];
      arrayOfTrustManager[0] = new eq();
    }
    IOException localIOException;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, arrayOfTrustManager, new SecureRandom());
      I = localSSLContext.getSocketFactory();
      return I;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localIOException = new IOException("Security exception configuring SSL context");
      localIOException.initCause(localGeneralSecurityException);
    }
    throw new e(localIOException);
  }

  private static HostnameVerifier S()
  {
    if (J == null)
      J = new et();
    return J;
  }

  private Proxy T()
  {
    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.U, this.V));
  }

  private HttpURLConnection U()
  {
    try
    {
      if (this.U != null);
      HttpURLConnection localHttpURLConnection;
      for (Object localObject = K.a(this.M, T()); ; localObject = localHttpURLConnection)
      {
        ((HttpURLConnection)localObject).setRequestMethod(this.N);
        return localObject;
        localHttpURLConnection = K.a(this.M);
      }
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public static ep a(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean)
      str = a(str);
    return b(str);
  }

  public static ep a(CharSequence paramCharSequence, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = a(paramCharSequence, paramArrayOfObject);
    if (paramBoolean)
      str = a(str);
    return b(str);
  }

  public static ep a(URL paramURL)
    throws ep.e
  {
    return new ep(paramURL, "GET");
  }

  // ERROR //
  public static String a(CharSequence paramCharSequence)
    throws ep.e
  {
    // Byte code:
    //   0: new 157	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokeinterface 163 1 0
    //   10: invokespecial 166	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 275	java/net/URL:getHost	()Ljava/lang/String;
    //   18: astore_2
    //   19: aload_1
    //   20: invokevirtual 279	java/net/URL:getPort	()I
    //   23: istore_3
    //   24: iload_3
    //   25: iconst_m1
    //   26: if_icmpeq +30 -> 56
    //   29: new 281	java/lang/StringBuilder
    //   32: dup
    //   33: aload_2
    //   34: invokestatic 285	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: bipush 58
    //   42: invokevirtual 290	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   45: iload_3
    //   46: invokestatic 295	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   49: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_2
    //   56: new 301	java/net/URI
    //   59: dup
    //   60: aload_1
    //   61: invokevirtual 304	java/net/URL:getProtocol	()Ljava/lang/String;
    //   64: aload_2
    //   65: aload_1
    //   66: invokevirtual 307	java/net/URL:getPath	()Ljava/lang/String;
    //   69: aload_1
    //   70: invokevirtual 310	java/net/URL:getQuery	()Ljava/lang/String;
    //   73: aconst_null
    //   74: invokespecial 313	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: invokevirtual 316	java/net/URI:toASCIIString	()Ljava/lang/String;
    //   80: astore 7
    //   82: aload 7
    //   84: bipush 63
    //   86: invokevirtual 320	java/lang/String:indexOf	(I)I
    //   89: istore 8
    //   91: iload 8
    //   93: ifle +65 -> 158
    //   96: iload 8
    //   98: iconst_1
    //   99: iadd
    //   100: aload 7
    //   102: invokevirtual 323	java/lang/String:length	()I
    //   105: if_icmpge +53 -> 158
    //   108: new 281	java/lang/StringBuilder
    //   111: dup
    //   112: aload 7
    //   114: iconst_0
    //   115: iload 8
    //   117: iconst_1
    //   118: iadd
    //   119: invokevirtual 327	java/lang/String:substring	(II)Ljava/lang/String;
    //   122: invokestatic 285	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 7
    //   130: iload 8
    //   132: iconst_1
    //   133: iadd
    //   134: invokevirtual 329	java/lang/String:substring	(I)Ljava/lang/String;
    //   137: ldc_w 331
    //   140: ldc_w 333
    //   143: invokevirtual 337	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   146: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: astore 9
    //   154: aload 9
    //   156: astore 7
    //   158: aload 7
    //   160: areturn
    //   161: astore 10
    //   163: new 143	com/umeng/message/b/ep$e
    //   166: dup
    //   167: aload 10
    //   169: invokespecial 173	com/umeng/message/b/ep$e:<init>	(Ljava/io/IOException;)V
    //   172: athrow
    //   173: astore 4
    //   175: new 204	java/io/IOException
    //   178: dup
    //   179: ldc_w 339
    //   182: invokespecial 207	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   185: astore 5
    //   187: aload 5
    //   189: aload 4
    //   191: invokevirtual 211	java/io/IOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   194: pop
    //   195: new 143	com/umeng/message/b/ep$e
    //   198: dup
    //   199: aload 5
    //   201: invokespecial 173	com/umeng/message/b/ep$e:<init>	(Ljava/io/IOException;)V
    //   204: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	161	java/io/IOException
    //   56	91	173	java/net/URISyntaxException
    //   96	154	173	java/net/URISyntaxException
  }

  public static String a(CharSequence paramCharSequence, Map<?, ?> paramMap)
  {
    String str = paramCharSequence.toString();
    if ((paramMap == null) || (paramMap.isEmpty()))
      return str;
    StringBuilder localStringBuilder = new StringBuilder(str);
    a(str, localStringBuilder);
    b(str, localStringBuilder);
    Iterator localIterator = paramMap.entrySet().iterator();
    Map.Entry localEntry1 = (Map.Entry)localIterator.next();
    localStringBuilder.append(localEntry1.getKey().toString());
    localStringBuilder.append('=');
    Object localObject1 = localEntry1.getValue();
    if (localObject1 != null)
      localStringBuilder.append(localObject1);
    while (true)
    {
      if (!localIterator.hasNext())
        return localStringBuilder.toString();
      localStringBuilder.append('&');
      Map.Entry localEntry2 = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry2.getKey().toString());
      localStringBuilder.append('=');
      Object localObject2 = localEntry2.getValue();
      if (localObject2 == null)
        continue;
      localStringBuilder.append(localObject2);
    }
  }

  public static String a(CharSequence paramCharSequence, Object[] paramArrayOfObject)
  {
    String str = paramCharSequence.toString();
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
      return str;
    if (paramArrayOfObject.length % 2 != 0)
      throw new IllegalArgumentException("Must specify an even number of parameter names/values");
    StringBuilder localStringBuilder = new StringBuilder(str);
    a(str, localStringBuilder);
    b(str, localStringBuilder);
    localStringBuilder.append(paramArrayOfObject[0]);
    localStringBuilder.append('=');
    Object localObject1 = paramArrayOfObject[1];
    if (localObject1 != null)
      localStringBuilder.append(localObject1);
    for (int i1 = 2; ; i1 += 2)
    {
      if (i1 >= paramArrayOfObject.length)
        return localStringBuilder.toString();
      localStringBuilder.append('&');
      localStringBuilder.append(paramArrayOfObject[i1]);
      localStringBuilder.append('=');
      Object localObject2 = paramArrayOfObject[(i1 + 1)];
      if (localObject2 == null)
        continue;
      localStringBuilder.append(localObject2);
    }
  }

  private static StringBuilder a(String paramString, StringBuilder paramStringBuilder)
  {
    if (2 + paramString.indexOf(':') == paramString.lastIndexOf('/'))
      paramStringBuilder.append('/');
    return paramStringBuilder;
  }

  public static void a(int paramInt)
  {
    String str = Integer.toString(paramInt);
    j("http.proxyPort", str);
    j("https.proxyPort", str);
  }

  public static void a(c paramc)
  {
    if (paramc == null)
    {
      K = c.a;
      return;
    }
    K = paramc;
  }

  public static void a(String paramString)
  {
    j("http.proxyHost", paramString);
    j("https.proxyHost", paramString);
  }

  public static void a(boolean paramBoolean)
  {
    j("http.keepAlive", Boolean.toString(paramBoolean));
  }

  public static void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = -1 + paramArrayOfString.length;
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= i1)
        {
          localStringBuilder.append(paramArrayOfString[i1]);
          j("http.nonProxyHosts", localStringBuilder.toString());
          return;
        }
        localStringBuilder.append(paramArrayOfString[i2]).append('|');
      }
    }
    j("http.nonProxyHosts", null);
  }

  public static ep b(CharSequence paramCharSequence)
    throws ep.e
  {
    return new ep(paramCharSequence, "GET");
  }

  public static ep b(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean)
      str = a(str);
    return c(str);
  }

  public static ep b(CharSequence paramCharSequence, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = a(paramCharSequence, paramArrayOfObject);
    if (paramBoolean)
      str = a(str);
    return c(str);
  }

  public static ep b(URL paramURL)
    throws ep.e
  {
    return new ep(paramURL, "POST");
  }

  private static StringBuilder b(String paramString, StringBuilder paramStringBuilder)
  {
    int i1 = paramString.indexOf('?');
    int i2 = -1 + paramStringBuilder.length();
    if (i1 == -1)
      paramStringBuilder.append('?');
    do
      return paramStringBuilder;
    while ((i1 >= i2) || (paramString.charAt(i2) == '&'));
    paramStringBuilder.append('&');
    return paramStringBuilder;
  }

  public static ep c(CharSequence paramCharSequence)
    throws ep.e
  {
    return new ep(paramCharSequence, "POST");
  }

  public static ep c(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean)
      str = a(str);
    return d(str);
  }

  public static ep c(CharSequence paramCharSequence, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = a(paramCharSequence, paramArrayOfObject);
    if (paramBoolean)
      str = a(str);
    return d(str);
  }

  public static ep c(URL paramURL)
    throws ep.e
  {
    return new ep(paramURL, "PUT");
  }

  public static ep d(CharSequence paramCharSequence)
    throws ep.e
  {
    return new ep(paramCharSequence, "PUT");
  }

  public static ep d(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean)
      str = a(str);
    return e(str);
  }

  public static ep d(CharSequence paramCharSequence, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = a(paramCharSequence, paramArrayOfObject);
    if (paramBoolean)
      str = a(str);
    return e(str);
  }

  public static ep d(URL paramURL)
    throws ep.e
  {
    return new ep(paramURL, "DELETE");
  }

  public static ep e(CharSequence paramCharSequence)
    throws ep.e
  {
    return new ep(paramCharSequence, "DELETE");
  }

  public static ep e(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean)
      str = a(str);
    return f(str);
  }

  public static ep e(CharSequence paramCharSequence, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    String str = a(paramCharSequence, paramArrayOfObject);
    if (paramBoolean)
      str = a(str);
    return f(str);
  }

  public static ep e(URL paramURL)
    throws ep.e
  {
    return new ep(paramURL, "HEAD");
  }

  public static ep f(CharSequence paramCharSequence)
    throws ep.e
  {
    return new ep(paramCharSequence, "HEAD");
  }

  public static ep f(URL paramURL)
    throws ep.e
  {
    return new ep(paramURL, "OPTIONS");
  }

  public static ep g(CharSequence paramCharSequence)
    throws ep.e
  {
    return new ep(paramCharSequence, "OPTIONS");
  }

  public static ep g(URL paramURL)
    throws ep.e
  {
    return new ep(paramURL, "TRACE");
  }

  public static ep h(CharSequence paramCharSequence)
    throws ep.e
  {
    return new ep(paramCharSequence, "TRACE");
  }

  private static String j(String paramString1, String paramString2)
  {
    if (paramString2 != null);
    for (Object localObject = new eu(paramString1, paramString2); ; localObject = new ev(paramString1))
      return (String)AccessController.doPrivileged((PrivilegedAction)localObject);
  }

  private static String v(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
      return paramString;
    return "UTF-8";
  }

  public String A()
  {
    return e("Cache-Control");
  }

  public String B()
  {
    return e("ETag");
  }

  public long C()
  {
    return f("Expires");
  }

  public long D()
  {
    return f("Last-Modified");
  }

  public String E()
  {
    return e("Location");
  }

  public String F()
  {
    return e("Content-Type");
  }

  public int G()
  {
    return g("Content-Length");
  }

  public ep H()
  {
    return t("application/json");
  }

  protected ep I()
    throws IOException
  {
    if (this.O == null)
      return this;
    if (this.P)
      this.O.a("\r\n--00content0boundary00--\r\n");
    if (this.R);
    try
    {
      this.O.close();
      while (true)
      {
        label41: this.O = null;
        return this;
        this.O.close();
      }
    }
    catch (IOException localIOException)
    {
      break label41;
    }
  }

  protected ep J()
    throws ep.e
  {
    try
    {
      ep localep = I();
      return localep;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  protected ep K()
    throws IOException
  {
    if (this.O != null)
      return this;
    a().setDoOutput(true);
    String str = c(a().getRequestProperty("Content-Type"), "charset");
    this.O = new g(a().getOutputStream(), str, this.T);
    return this;
  }

  protected ep L()
    throws IOException
  {
    if (!this.P)
    {
      this.P = true;
      r("multipart/form-data; boundary=00content0boundary00").K();
      this.O.a("--00content0boundary00\r\n");
      return this;
    }
    this.O.a("\r\n--00content0boundary00\r\n");
    return this;
  }

  public OutputStreamWriter M()
    throws ep.e
  {
    try
    {
      K();
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(this.O, g.a(this.O).charset());
      return localOutputStreamWriter;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep N()
    throws ep.e
  {
    HttpURLConnection localHttpURLConnection = a();
    if ((localHttpURLConnection instanceof HttpsURLConnection))
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(R());
    return this;
  }

  public ep O()
  {
    HttpURLConnection localHttpURLConnection = a();
    if ((localHttpURLConnection instanceof HttpsURLConnection))
      ((HttpsURLConnection)localHttpURLConnection).setHostnameVerifier(S());
    return this;
  }

  public URL P()
  {
    return a().getURL();
  }

  public String Q()
  {
    return a().getRequestMethod();
  }

  public int a(String paramString, int paramInt)
    throws ep.e
  {
    J();
    return a().getHeaderFieldInt(paramString, paramInt);
  }

  public long a(String paramString, long paramLong)
    throws ep.e
  {
    J();
    return a().getHeaderFieldDate(paramString, paramLong);
  }

  public ep a(long paramLong)
  {
    a().setIfModifiedSince(paramLong);
    return this;
  }

  public ep a(File paramFile)
    throws ep.e
  {
    try
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile), this.T);
      return (ep)new ew(this, localBufferedOutputStream, this.R, localBufferedOutputStream).call();
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    throw new e(localFileNotFoundException);
  }

  public ep a(InputStream paramInputStream)
    throws ep.e
  {
    try
    {
      K();
      a(paramInputStream, this.O);
      return this;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  protected ep a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return (ep)new ez(this, paramInputStream, this.R, paramInputStream, paramOutputStream).call();
  }

  public ep a(OutputStream paramOutputStream)
    throws ep.e
  {
    try
    {
      ep localep = a(q(), paramOutputStream);
      return localep;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep a(PrintStream paramPrintStream)
    throws ep.e
  {
    return a(paramPrintStream);
  }

  public ep a(Reader paramReader)
    throws ep.e
  {
    try
    {
      K();
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(this.O, g.a(this.O).charset());
      return (ep)new es(this, localOutputStreamWriter, paramReader, localOutputStreamWriter).call();
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  protected ep a(Reader paramReader, Writer paramWriter)
    throws IOException
  {
    return (ep)new er(this, paramReader, this.R, paramReader, paramWriter).call();
  }

  public ep a(Writer paramWriter)
    throws ep.e
  {
    BufferedReader localBufferedReader = t();
    return (ep)new ey(this, localBufferedReader, this.R, localBufferedReader, paramWriter).call();
  }

  public ep a(Appendable paramAppendable)
    throws ep.e
  {
    BufferedReader localBufferedReader = t();
    return (ep)new ex(this, localBufferedReader, this.R, localBufferedReader, paramAppendable).call();
  }

  public ep a(Object paramObject1, Object paramObject2)
    throws ep.e
  {
    return a(paramObject1, paramObject2, "UTF-8");
  }

  public ep a(Object paramObject1, Object paramObject2, String paramString)
    throws ep.e
  {
    int i1;
    if (this.Q)
      i1 = 0;
    while (true)
    {
      if (i1 != 0)
      {
        f("application/x-www-form-urlencoded", paramString);
        this.Q = true;
      }
      String str = v(paramString);
      try
      {
        K();
        if (i1 == 0)
          this.O.write(38);
        this.O.a(URLEncoder.encode(paramObject1.toString(), str));
        this.O.write(61);
        if (paramObject2 != null)
          this.O.a(URLEncoder.encode(paramObject2.toString(), str));
        return this;
        i1 = 1;
      }
      catch (IOException localIOException)
      {
      }
    }
    throw new e(localIOException);
  }

  public ep a(String paramString, File paramFile)
    throws ep.e
  {
    return a(paramString, null, paramFile);
  }

  public ep a(String paramString, InputStream paramInputStream)
    throws ep.e
  {
    return a(paramString, null, null, paramInputStream);
  }

  public ep a(String paramString, Number paramNumber)
  {
    if (paramNumber != null);
    for (String str = paramNumber.toString(); ; str = null)
      return a(paramString, str);
  }

  public ep a(String paramString1, String paramString2)
  {
    a().setRequestProperty(paramString1, paramString2);
    return this;
  }

  public ep a(String paramString1, String paramString2, File paramFile)
    throws ep.e
  {
    return a(paramString1, paramString2, null, paramFile);
  }

  public ep a(String paramString1, String paramString2, Number paramNumber)
    throws ep.e
  {
    if (paramNumber != null);
    for (String str = paramNumber.toString(); ; str = null)
      return b(paramString1, paramString2, str);
  }

  protected ep a(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"").append(paramString1);
    if (paramString2 != null)
      localStringBuilder.append("\"; filename=\"").append(paramString2);
    localStringBuilder.append('"');
    i("Content-Disposition", localStringBuilder.toString());
    if (paramString3 != null)
      i("Content-Type", paramString3);
    return i("\r\n");
  }

  public ep a(String paramString1, String paramString2, String paramString3, File paramFile)
    throws ep.e
  {
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
      return a(paramString1, paramString2, paramString3, localBufferedInputStream);
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
    throws ep.e
  {
    try
    {
      L();
      a(paramString1, paramString2, paramString3);
      a(paramInputStream, this.O);
      return this;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep a(String paramString1, String paramString2, String paramString3, String paramString4)
    throws ep.e
  {
    try
    {
      L();
      a(paramString1, paramString2, paramString3);
      this.O.a(paramString4);
      return this;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep a(Map.Entry<String, String> paramEntry)
  {
    return a((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }

  public ep a(Map.Entry<?, ?> paramEntry, String paramString)
    throws ep.e
  {
    return a(paramEntry.getKey(), paramEntry.getValue(), paramString);
  }

  public ep a(Map<String, String> paramMap)
  {
    Iterator localIterator;
    if (!paramMap.isEmpty())
      localIterator = paramMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return this;
      a((Map.Entry)localIterator.next());
    }
  }

  public ep a(Map<?, ?> paramMap, String paramString)
    throws ep.e
  {
    Iterator localIterator;
    if (!paramMap.isEmpty())
      localIterator = paramMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return this;
      a((Map.Entry)localIterator.next(), paramString);
    }
  }

  public ep a(AtomicInteger paramAtomicInteger)
    throws ep.e
  {
    paramAtomicInteger.set(c());
    return this;
  }

  public ep a(AtomicReference<String> paramAtomicReference)
    throws ep.e
  {
    paramAtomicReference.set(n());
    return this;
  }

  public ep a(AtomicReference<String> paramAtomicReference, String paramString)
    throws ep.e
  {
    paramAtomicReference.set(b(paramString));
    return this;
  }

  public ep a(byte[] paramArrayOfByte)
    throws ep.e
  {
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }

  public HttpURLConnection a()
  {
    if (this.L == null)
      this.L = U();
    return this.L;
  }

  public ep b(int paramInt)
  {
    a().setChunkedStreamingMode(paramInt);
    return this;
  }

  public ep b(File paramFile)
    throws ep.e
  {
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
      return a(localBufferedInputStream);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    throw new e(localFileNotFoundException);
  }

  public ep b(String paramString, int paramInt)
  {
    if (this.L != null)
      throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
    this.U = paramString;
    this.V = paramInt;
    return this;
  }

  public ep b(String paramString, Number paramNumber)
    throws ep.e
  {
    return a(paramString, null, paramNumber);
  }

  public ep b(String paramString1, String paramString2, String paramString3)
    throws ep.e
  {
    return a(paramString1, paramString2, null, paramString3);
  }

  public ep b(Map.Entry<?, ?> paramEntry)
    throws ep.e
  {
    return a(paramEntry, "UTF-8");
  }

  public ep b(Map<?, ?> paramMap)
    throws ep.e
  {
    return a(paramMap, "UTF-8");
  }

  public ep b(boolean paramBoolean)
  {
    this.R = paramBoolean;
    return this;
  }

  public String b(String paramString)
    throws ep.e
  {
    ByteArrayOutputStream localByteArrayOutputStream = m();
    try
    {
      a(q(), localByteArrayOutputStream);
      String str = localByteArrayOutputStream.toString(v(paramString));
      return str;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public String b(String paramString1, String paramString2)
  {
    return c(e(paramString1), paramString2);
  }

  public boolean b()
  {
    return this.R;
  }

  public int c()
    throws ep.e
  {
    try
    {
      I();
      int i1 = a().getResponseCode();
      return i1;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep c(int paramInt)
  {
    if (paramInt < 1)
      throw new IllegalArgumentException("Size must be greater than zero");
    this.T = paramInt;
    return this;
  }

  public ep c(boolean paramBoolean)
  {
    this.S = paramBoolean;
    return this;
  }

  public InputStreamReader c(String paramString)
    throws ep.e
  {
    try
    {
      InputStreamReader localInputStreamReader = new InputStreamReader(r(), v(paramString));
      return localInputStreamReader;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new e(localUnsupportedEncodingException);
  }

  protected String c(String paramString1, String paramString2)
  {
    String str;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      str = null;
      return str;
    }
    int i1 = paramString1.length();
    int i2 = 1 + paramString1.indexOf(';');
    if ((i2 == 0) || (i2 == i1))
      return null;
    int i3 = paramString1.indexOf(';', i2);
    int i5;
    int i6;
    if (i3 == -1)
    {
      i5 = i2;
      i6 = i1;
    }
    while (true)
    {
      if (i5 >= i6)
        return null;
      int i7 = paramString1.indexOf('=', i5);
      if ((i7 != -1) && (i7 < i6) && (paramString2.equals(paramString1.substring(i5, i7).trim())))
      {
        str = paramString1.substring(i7 + 1, i6).trim();
        int i8 = str.length();
        if (i8 != 0)
        {
          if ((i8 <= 2) || ('"' != str.charAt(0)) || ('"' != str.charAt(i8 - 1)))
            break;
          return str.substring(1, i8 - 1);
        }
      }
      i2 = i6 + 1;
      i3 = paramString1.indexOf(';', i2);
      if (i3 == -1)
      {
        i5 = i2;
        i6 = i1;
        continue;
      }
      int i4 = i3;
      i5 = i2;
      i6 = i4;
    }
  }

  public ep d(int paramInt)
  {
    a().setReadTimeout(paramInt);
    return this;
  }

  public ep d(String paramString1, String paramString2)
  {
    return o("Basic " + a.a(new StringBuilder(String.valueOf(paramString1)).append(':').append(paramString2).toString()));
  }

  public ep d(boolean paramBoolean)
  {
    a().setUseCaches(paramBoolean);
    return this;
  }

  public BufferedReader d(String paramString)
    throws ep.e
  {
    return new BufferedReader(c(paramString), this.T);
  }

  public boolean d()
    throws ep.e
  {
    return 200 == c();
  }

  public ep e(int paramInt)
  {
    a().setConnectTimeout(paramInt);
    return this;
  }

  public ep e(String paramString1, String paramString2)
  {
    return p("Basic " + a.a(new StringBuilder(String.valueOf(paramString1)).append(':').append(paramString2).toString()));
  }

  public ep e(boolean paramBoolean)
  {
    a();
    HttpURLConnection.setFollowRedirects(paramBoolean);
    return this;
  }

  public String e(String paramString)
    throws ep.e
  {
    J();
    return a().getHeaderField(paramString);
  }

  public boolean e()
    throws ep.e
  {
    return 201 == c();
  }

  public long f(String paramString)
    throws ep.e
  {
    return a(paramString, -1L);
  }

  public ep f(int paramInt)
  {
    a().setFixedLengthStreamingMode(paramInt);
    return this;
  }

  public ep f(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
      return a("Content-Type", paramString1 + "; charset=" + paramString2);
    return a("Content-Type", paramString1);
  }

  public boolean f()
    throws ep.e
  {
    return 500 == c();
  }

  public int g(String paramString)
    throws ep.e
  {
    return a(paramString, -1);
  }

  protected ep g(String paramString1, String paramString2)
    throws IOException
  {
    return a(paramString1, paramString2, null);
  }

  public boolean g()
    throws ep.e
  {
    return 400 == c();
  }

  public ep h(String paramString1, String paramString2)
  {
    return b(paramString1, null, paramString2);
  }

  public boolean h()
    throws ep.e
  {
    return 404 == c();
  }

  public String[] h(String paramString)
  {
    Map localMap = u();
    if ((localMap == null) || (localMap.isEmpty()))
      return H;
    List localList = (List)localMap.get(paramString);
    if ((localList != null) && (!localList.isEmpty()))
      return (String[])localList.toArray(new String[localList.size()]);
    return H;
  }

  public ep i(CharSequence paramCharSequence)
    throws ep.e
  {
    try
    {
      K();
      this.O.a(paramCharSequence.toString());
      return this;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep i(String paramString1, String paramString2)
    throws ep.e
  {
    return i(paramString1).i(": ").i(paramString2).i("\r\n");
  }

  public Map<String, String> i(String paramString)
  {
    return j(e(paramString));
  }

  public boolean i()
    throws ep.e
  {
    return 304 == c();
  }

  public String j()
    throws ep.e
  {
    try
    {
      I();
      String str = a().getResponseMessage();
      return str;
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  protected Map<String, String> j(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return Collections.emptyMap();
    int i1 = paramString.length();
    int i2 = 1 + paramString.indexOf(';');
    if ((i2 == 0) || (i2 == i1))
      return Collections.emptyMap();
    int i3 = paramString.indexOf(';', i2);
    if (i3 == -1)
      i3 = i1;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (i2 >= i3)
      return localLinkedHashMap;
    int i4 = paramString.indexOf('=', i2);
    String str1;
    String str2;
    if ((i4 != -1) && (i4 < i3))
    {
      str1 = paramString.substring(i2, i4).trim();
      if (str1.length() > 0)
      {
        str2 = paramString.substring(i4 + 1, i3).trim();
        int i5 = str2.length();
        if (i5 != 0)
        {
          if ((i5 <= 2) || ('"' != str2.charAt(0)) || ('"' != str2.charAt(i5 - 1)))
            break label224;
          localLinkedHashMap.put(str1, str2.substring(1, i5 - 1));
        }
      }
    }
    while (true)
    {
      i2 = i3 + 1;
      i3 = paramString.indexOf(';', i2);
      if (i3 != -1)
        break;
      i3 = i1;
      break;
      label224: localLinkedHashMap.put(str1, str2);
    }
  }

  public ep k()
  {
    a().disconnect();
    return this;
  }

  public ep k(String paramString)
  {
    return a("User-Agent", paramString);
  }

  public int l()
  {
    return this.T;
  }

  public ep l(String paramString)
  {
    return a("Referer", paramString);
  }

  public ep m(String paramString)
  {
    return a("Accept-Encoding", paramString);
  }

  protected ByteArrayOutputStream m()
  {
    int i1 = G();
    if (i1 > 0)
      return new ByteArrayOutputStream(i1);
    return new ByteArrayOutputStream();
  }

  public ep n(String paramString)
  {
    return a("Accept-Charset", paramString);
  }

  public String n()
    throws ep.e
  {
    return b(v());
  }

  public ep o(String paramString)
  {
    return a("Authorization", paramString);
  }

  public boolean o()
    throws ep.e
  {
    return G() == 0;
  }

  public ep p(String paramString)
  {
    return a("Proxy-Authorization", paramString);
  }

  public byte[] p()
    throws ep.e
  {
    ByteArrayOutputStream localByteArrayOutputStream = m();
    try
    {
      a(q(), localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
    }
    throw new e(localIOException);
  }

  public ep q(String paramString)
  {
    return a("If-None-Match", paramString);
  }

  public BufferedInputStream q()
    throws ep.e
  {
    return new BufferedInputStream(r(), this.T);
  }

  public ep r(String paramString)
  {
    return f(paramString, null);
  }

  public InputStream r()
    throws ep.e
  {
    if (c() < 400);
    Object localObject;
    while (true)
    {
      try
      {
        InputStream localInputStream2 = a().getInputStream();
        localObject = localInputStream2;
        if ((this.S) && ("gzip".equals(x())))
          break;
        return localObject;
      }
      catch (IOException localIOException3)
      {
        throw new e(localIOException3);
      }
      localObject = a().getErrorStream();
      if (localObject != null)
        continue;
      try
      {
        InputStream localInputStream1 = a().getInputStream();
        localObject = localInputStream1;
      }
      catch (IOException localIOException1)
      {
        throw new e(localIOException1);
      }
    }
    try
    {
      GZIPInputStream localGZIPInputStream = new GZIPInputStream((InputStream)localObject);
      return localGZIPInputStream;
    }
    catch (IOException localIOException2)
    {
    }
    throw new e(localIOException2);
  }

  public ep s(String paramString)
  {
    return f(Integer.parseInt(paramString));
  }

  public InputStreamReader s()
    throws ep.e
  {
    return c(v());
  }

  public ep t(String paramString)
  {
    return a("Accept", paramString);
  }

  public BufferedReader t()
    throws ep.e
  {
    return d(v());
  }

  public String toString()
  {
    return Q() + ' ' + P();
  }

  public Map<String, List<String>> u()
    throws ep.e
  {
    J();
    return a().getHeaderFields();
  }

  public String v()
  {
    return b("Content-Type", "charset");
  }

  public ep w()
  {
    return m("gzip");
  }

  public String x()
  {
    return e("Content-Encoding");
  }

  public String y()
  {
    return e("Server");
  }

  public long z()
  {
    return f("Date");
  }

  public static class a
  {
    private static final byte a = 61;
    private static final String b = "US-ASCII";
    private static final byte[] c = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };

    public static String a(String paramString)
    {
      try
      {
        byte[] arrayOfByte2 = paramString.getBytes("US-ASCII");
        arrayOfByte1 = arrayOfByte2;
        return a(arrayOfByte1);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (true)
          byte[] arrayOfByte1 = paramString.getBytes();
      }
    }

    public static String a(byte[] paramArrayOfByte)
    {
      return a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2);
      try
      {
        String str = new String(arrayOfByte, "US-ASCII");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
      return new String(arrayOfByte);
    }

    private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    {
      byte[] arrayOfByte = c;
      int i;
      if (paramInt2 > 0)
      {
        i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
        label20: if (paramInt2 <= 1)
          break label108;
      }
      int n;
      label108: for (int j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16; ; j = 0)
      {
        int k = j | i;
        int m = 0;
        if (paramInt2 > 2)
          m = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
        n = m | k;
        switch (paramInt2)
        {
        default:
          return paramArrayOfByte2;
          i = 0;
          break label20;
        case 3:
        case 2:
        case 1:
        }
      }
      paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
      paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & n >>> 6)];
      paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(n & 0x3F)];
      return paramArrayOfByte2;
      paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
      paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & n >>> 6)];
      paramArrayOfByte2[(paramInt3 + 3)] = 61;
      return paramArrayOfByte2;
      paramArrayOfByte2[paramInt3] = arrayOfByte[(n >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & n >>> 12)];
      paramArrayOfByte2[(paramInt3 + 2)] = 61;
      paramArrayOfByte2[(paramInt3 + 3)] = 61;
      return paramArrayOfByte2;
    }

    public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null)
        throw new NullPointerException("Cannot serialize a null array.");
      if (paramInt1 < 0)
        throw new IllegalArgumentException("Cannot have negative offset: " + paramInt1);
      if (paramInt2 < 0)
        throw new IllegalArgumentException("Cannot have length offset: " + paramInt2);
      if (paramInt1 + paramInt2 > paramArrayOfByte.length)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        arrayOfObject[1] = Integer.valueOf(paramInt2);
        arrayOfObject[2] = Integer.valueOf(paramArrayOfByte.length);
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", arrayOfObject));
      }
      int i = 4 * (paramInt2 / 3);
      int j;
      byte[] arrayOfByte1;
      int k;
      int m;
      int n;
      if (paramInt2 % 3 > 0)
      {
        j = 4;
        arrayOfByte1 = new byte[j + i];
        k = paramInt2 - 2;
        m = 0;
        n = 0;
      }
      while (true)
      {
        if (n >= k)
        {
          if (n < paramInt2)
          {
            a(paramArrayOfByte, n + paramInt1, paramInt2 - n, arrayOfByte1, m);
            m += 4;
          }
          if (m > -1 + arrayOfByte1.length)
            break label250;
          byte[] arrayOfByte2 = new byte[m];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, m);
          return arrayOfByte2;
          j = 0;
          break;
        }
        a(paramArrayOfByte, n + paramInt1, 3, arrayOfByte1, m);
        n += 3;
        m += 4;
      }
      label250: return arrayOfByte1;
    }
  }

  public static abstract class b<V> extends ep.f<V>
  {
    private final Closeable a;
    private final boolean b;

    protected b(Closeable paramCloseable, boolean paramBoolean)
    {
      this.a = paramCloseable;
      this.b = paramBoolean;
    }

    protected void c()
      throws IOException
    {
      if ((this.a instanceof Flushable))
        ((Flushable)this.a).flush();
      if (this.b);
      try
      {
        this.a.close();
        return;
        this.a.close();
        return;
      }
      catch (IOException localIOException)
      {
      }
    }
  }

  public static abstract interface c
  {
    public static final c a = new fa();

    public abstract HttpURLConnection a(URL paramURL)
      throws IOException;

    public abstract HttpURLConnection a(URL paramURL, Proxy paramProxy)
      throws IOException;
  }

  public static abstract class d<V> extends ep.f<V>
  {
    private final Flushable a;

    protected d(Flushable paramFlushable)
    {
      this.a = paramFlushable;
    }

    protected void c()
      throws IOException
    {
      this.a.flush();
    }
  }

  public static class e extends RuntimeException
  {
    private static final long a = -1170466989781746231L;

    protected e(IOException paramIOException)
    {
      super();
    }

    public IOException a()
    {
      return (IOException)super.getCause();
    }
  }

  public static abstract class f<V>
    implements Callable<V>
  {
    protected abstract V b()
      throws ep.e, IOException;

    protected abstract void c()
      throws IOException;

    // ERROR //
    public V call()
      throws ep.e
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: invokevirtual 21	com/umeng/message/b/ep$f:b	()Ljava/lang/Object;
      //   6: astore 6
      //   8: aload_0
      //   9: invokevirtual 23	com/umeng/message/b/ep$f:c	()V
      //   12: aload 6
      //   14: areturn
      //   15: astore 7
      //   17: new 15	com/umeng/message/b/ep$e
      //   20: dup
      //   21: aload 7
      //   23: invokespecial 26	com/umeng/message/b/ep$e:<init>	(Ljava/io/IOException;)V
      //   26: athrow
      //   27: astore 5
      //   29: aload 5
      //   31: athrow
      //   32: astore_2
      //   33: aload_0
      //   34: invokevirtual 23	com/umeng/message/b/ep$f:c	()V
      //   37: aload_2
      //   38: athrow
      //   39: astore 4
      //   41: new 15	com/umeng/message/b/ep$e
      //   44: dup
      //   45: aload 4
      //   47: invokespecial 26	com/umeng/message/b/ep$e:<init>	(Ljava/io/IOException;)V
      //   50: athrow
      //   51: astore_3
      //   52: iload_1
      //   53: ifne -16 -> 37
      //   56: new 15	com/umeng/message/b/ep$e
      //   59: dup
      //   60: aload_3
      //   61: invokespecial 26	com/umeng/message/b/ep$e:<init>	(Ljava/io/IOException;)V
      //   64: athrow
      //   65: astore_2
      //   66: iconst_0
      //   67: istore_1
      //   68: goto -35 -> 33
      //
      // Exception table:
      //   from	to	target	type
      //   8	12	15	java/io/IOException
      //   2	8	27	com/umeng/message/b/ep$e
      //   29	32	32	finally
      //   41	51	32	finally
      //   2	8	39	java/io/IOException
      //   33	37	51	java/io/IOException
      //   2	8	65	finally
    }
  }

  public static class g extends BufferedOutputStream
  {
    private final CharsetEncoder a;

    public g(OutputStream paramOutputStream, String paramString, int paramInt)
    {
      super(paramInt);
      this.a = Charset.forName(ep.u(paramString)).newEncoder();
    }

    public g a(String paramString)
      throws IOException
    {
      ByteBuffer localByteBuffer = this.a.encode(CharBuffer.wrap(paramString));
      super.write(localByteBuffer.array(), 0, localByteBuffer.limit());
      return this;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ep
 * JD-Core Version:    0.6.0
 */