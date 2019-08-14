package com.gensee.utils.upload;

import android.util.Log;
import android.util.Xml;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.xmlpull.v1.XmlSerializer;

public class UpLoadFileUtil
{
  private static final String CHARSET = "utf-8";
  private static final String TAG = "UpLoadFile";
  private static final int TIME_OUT = 10000;
  String boundary = UUID.randomUUID().toString();
  String content_type = "multipart/form-data";
  String line_end = "\r\n";
  String prefix = "--";

  private String getFileValue(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.prefix);
    localStringBuffer.append(this.boundary);
    localStringBuffer.append(this.line_end);
    localStringBuffer.append("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"" + this.line_end);
    localStringBuffer.append("Content-Type: application/octet-stream; charset=utf-8" + this.line_end);
    localStringBuffer.append(this.line_end);
    return localStringBuffer.toString();
  }

  private String getStringValue(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.prefix);
    localStringBuffer.append(this.boundary);
    localStringBuffer.append(this.line_end);
    localStringBuffer.append("Content-Disposition: form-data; name=\"" + paramString1 + "\"" + this.line_end);
    localStringBuffer.append(this.line_end);
    localStringBuffer.append(paramString2);
    localStringBuffer.append(this.line_end);
    return localStringBuffer.toString();
  }

  private String writeXmlSerial(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    while (true)
    {
      Iterator localIterator2;
      try
      {
        localXmlSerializer.setOutput(localStringWriter);
        localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        localXmlSerializer.startTag(null, "clientDiagnosis");
        Iterator localIterator1 = paramMap1.entrySet().iterator();
        if (localIterator1.hasNext())
          continue;
        localIterator2 = paramMap2.entrySet().iterator();
        if (!localIterator2.hasNext())
        {
          localXmlSerializer.endTag(null, "clientDiagnosis");
          localXmlSerializer.endDocument();
          return localStringWriter.toString();
          Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
          localXmlSerializer.attribute("", (String)localEntry1.getKey(), (String)localEntry1.getValue());
          continue;
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
      String str = (String)localEntry2.getKey();
      localXmlSerializer.startTag(null, str);
      if (str.equals("file"))
        localXmlSerializer.attribute("", "type", "log");
      localXmlSerializer.cdsect((String)localEntry2.getValue());
      localXmlSerializer.endTag(null, str);
    }
  }

  // ERROR //
  public String notifyWeb(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: aload_3
    //   3: invokespecial 180	com/gensee/utils/upload/UpLoadFileUtil:writeXmlSerial	(Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   6: astore 4
    //   8: new 182	java/net/URL
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 183	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 187	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 189	java/net/HttpURLConnection
    //   22: astore 8
    //   24: aload 8
    //   26: sipush 10000
    //   29: invokevirtual 193	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   32: aload 8
    //   34: sipush 10000
    //   37: invokevirtual 196	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   40: aload 8
    //   42: iconst_1
    //   43: invokevirtual 200	java/net/HttpURLConnection:setDoInput	(Z)V
    //   46: aload 8
    //   48: iconst_1
    //   49: invokevirtual 203	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   52: aload 8
    //   54: ldc 205
    //   56: invokevirtual 208	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   59: aload 8
    //   61: ldc 210
    //   63: ldc 8
    //   65: invokevirtual 214	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload 8
    //   70: ldc 216
    //   72: ldc 218
    //   74: invokevirtual 214	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload 8
    //   79: ldc 220
    //   81: new 57	java/lang/StringBuilder
    //   84: dup
    //   85: aload 4
    //   87: invokevirtual 224	java/lang/String:getBytes	()[B
    //   90: arraylength
    //   91: i2l
    //   92: invokestatic 227	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   95: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 214	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: new 229	java/io/DataOutputStream
    //   107: dup
    //   108: aload 8
    //   110: invokevirtual 233	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   113: invokespecial 236	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   116: astore 9
    //   118: aload 9
    //   120: aload 4
    //   122: invokevirtual 237	java/lang/String:toString	()Ljava/lang/String;
    //   125: invokevirtual 224	java/lang/String:getBytes	()[B
    //   128: invokevirtual 241	java/io/DataOutputStream:write	([B)V
    //   131: aload 9
    //   133: invokevirtual 244	java/io/DataOutputStream:flush	()V
    //   136: aload 8
    //   138: invokevirtual 248	java/net/HttpURLConnection:getResponseCode	()I
    //   141: istore 10
    //   143: iload 10
    //   145: sipush 200
    //   148: if_icmpne +104 -> 252
    //   151: aload 8
    //   153: invokevirtual 252	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   156: astore 11
    //   158: new 50	java/lang/StringBuffer
    //   161: dup
    //   162: invokespecial 51	java/lang/StringBuffer:<init>	()V
    //   165: astore 12
    //   167: aload 11
    //   169: invokevirtual 257	java/io/InputStream:read	()I
    //   172: istore 13
    //   174: iload 13
    //   176: iconst_m1
    //   177: if_icmpne +41 -> 218
    //   180: aload 12
    //   182: invokevirtual 73	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   185: astore 14
    //   187: aload 14
    //   189: astore 6
    //   191: ldc 11
    //   193: new 57	java/lang/StringBuilder
    //   196: dup
    //   197: ldc_w 259
    //   200: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   203: aload 6
    //   205: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 265	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   214: pop
    //   215: aload 6
    //   217: areturn
    //   218: iload 13
    //   220: i2c
    //   221: istore 16
    //   223: aload 12
    //   225: iload 16
    //   227: invokevirtual 268	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   230: pop
    //   231: goto -64 -> 167
    //   234: astore 5
    //   236: ldc 144
    //   238: astore 6
    //   240: aload 5
    //   242: astore 7
    //   244: aload 7
    //   246: invokevirtual 271	java/io/IOException:printStackTrace	()V
    //   249: aload 6
    //   251: areturn
    //   252: ldc 11
    //   254: new 57	java/lang/StringBuilder
    //   257: dup
    //   258: ldc_w 273
    //   261: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: iload 10
    //   266: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 279	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: ldc 144
    //   278: areturn
    //   279: astore 7
    //   281: goto -37 -> 244
    //
    // Exception table:
    //   from	to	target	type
    //   8	143	234	java/io/IOException
    //   151	167	234	java/io/IOException
    //   167	174	234	java/io/IOException
    //   180	187	234	java/io/IOException
    //   223	231	234	java/io/IOException
    //   252	276	234	java/io/IOException
    //   191	215	279	java/io/IOException
  }

  public String uploadFile(List<UploadItem> paramList, String paramString)
  {
    if (paramList != null);
    try
    {
      int i = paramList.size();
      if (i <= 0)
        return "";
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Charset", "utf-8");
      localHttpURLConnection.setRequestProperty("connection", "keep-alive");
      localHttpURLConnection.setRequestProperty("Content-Type", this.content_type + ";boundary=" + this.boundary);
      localIterator1 = paramList.iterator();
      if (!localIterator1.hasNext())
      {
        localFile = null;
        if ((localFile == null) || (!localFile.exists()))
          break label708;
        localIterator2 = paramList.iterator();
        str2 = "";
        if (localIterator2.hasNext())
          break label497;
        byte[] arrayOfByte1 = (this.prefix + this.boundary + this.prefix + this.line_end).getBytes();
        localHttpURLConnection.setRequestProperty("Content-Length", str2.getBytes().length + arrayOfByte1.length + localFile.length() + this.line_end.getBytes().length);
        localDataOutputStream = new DataOutputStream(localHttpURLConnection.getOutputStream());
        localDataOutputStream.write(str2.toString().getBytes());
        FileInputStream localFileInputStream = new FileInputStream(localFile);
        arrayOfByte2 = new byte[1024];
        j = localFileInputStream.read(arrayOfByte2);
        if (j != -1)
          break label635;
        localFileInputStream.close();
        localDataOutputStream.write(this.line_end.getBytes());
        localDataOutputStream.write(arrayOfByte1);
        localDataOutputStream.flush();
        k = localHttpURLConnection.getResponseCode();
        if (k != 200)
          break label676;
        InputStream localInputStream = localHttpURLConnection.getInputStream();
        localStringBuffer = new StringBuffer();
        m = localInputStream.read();
        if (m != -1)
          break label648;
        String str4 = localStringBuffer.toString();
        str1 = str4;
      }
    }
    catch (IOException localIOException1)
    {
      try
      {
        Log.i("UpLoadFile", "uploadfile result = " + str1);
        return str1;
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        int k;
        while (true)
        {
          Iterator localIterator1;
          Iterator localIterator2;
          DataOutputStream localDataOutputStream;
          byte[] arrayOfByte2;
          int j;
          StringBuffer localStringBuffer;
          int m;
          localMalformedURLException2.printStackTrace();
          return str1;
          UploadItem localUploadItem2 = (UploadItem)localIterator1.next();
          if (!localUploadItem2.getType().equals("FILE_TYPE"))
            continue;
          File localFile = new File(localUploadItem2.getValue());
          continue;
          UploadItem localUploadItem1 = (UploadItem)localIterator2.next();
          if (localUploadItem1.getType().equals("VALUE_TYPE"))
          {
            str2 = str2 + getStringValue(localUploadItem1.getName(), localUploadItem1.getValue());
            continue;
          }
          if (!localUploadItem1.getType().equals("FILE_TYPE"))
            continue;
          String str3 = localFile.getName();
          if (str3.startsWith("stack-diagnose-android-"))
            str3 = str3.substring(6);
          String str2 = str2 + getFileValue(localUploadItem1.getName(), str3);
          continue;
          localDataOutputStream.write(arrayOfByte2, 0, j);
          continue;
          localStringBuffer.append((char)m);
        }
        localIOException1 = localIOException1;
        IOException localIOException2 = localIOException1;
        str1 = "";
        localIOException2.printStackTrace();
        return str1;
        Log.i("UpLoadFile", "uploadfile getResponseCode = " + k);
        return "";
      }
      catch (IOException localIOException3)
      {
        break label668;
      }
      return "";
    }
    catch (MalformedURLException localMalformedURLException1)
    {
      while (true)
      {
        label497: label635: Object localObject = localMalformedURLException1;
        label648: label668: label676: label708: String str1 = "";
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.upload.UpLoadFileUtil
 * JD-Core Version:    0.6.0
 */