package com.gensee.parse;

import com.gensee.utils.GenseeLog;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class PullBase
{
  private static final String TAG = "PullBase";

  // ERROR //
  protected XmlPullParser builXmlPullParser(InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 22	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   3: invokevirtual 26	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   6: astore 5
    //   8: aload 5
    //   10: astore_3
    //   11: aload_3
    //   12: new 28	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 31	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokeinterface 37 2 0
    //   25: aload_3
    //   26: areturn
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_2
    //   31: astore 4
    //   33: ldc 8
    //   35: aload 4
    //   37: invokestatic 43	com/gensee/utils/GenseeLog:e	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   40: aload_3
    //   41: areturn
    //   42: astore 4
    //   44: goto -11 -> 33
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	27	org/xmlpull/v1/XmlPullParserException
    //   11	25	42	org/xmlpull/v1/XmlPullParserException
  }

  // ERROR //
  protected XmlPullParser builXmlPullParser(String paramString)
  {
    // Byte code:
    //   0: invokestatic 22	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   3: invokevirtual 26	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   6: astore 5
    //   8: aload 5
    //   10: astore_3
    //   11: aload_3
    //   12: new 46	java/io/StringReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 49	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   20: invokeinterface 37 2 0
    //   25: aload_3
    //   26: areturn
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_2
    //   31: astore 4
    //   33: ldc 8
    //   35: aload 4
    //   37: invokestatic 43	com/gensee/utils/GenseeLog:e	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   40: aload_3
    //   41: areturn
    //   42: astore 4
    //   44: goto -11 -> 33
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	27	org/xmlpull/v1/XmlPullParserException
    //   11	25	42	org/xmlpull/v1/XmlPullParserException
  }

  protected boolean getAttrBitBoolValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    return getAttrByteValue(paramXmlPullParser, paramString) > 0;
  }

  protected byte getAttrByteValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    String str = getAttrStrValue(paramXmlPullParser, paramString);
    if ((str == null) || ("".equals(str)))
      return -1;
    try
    {
      int i = Byte.valueOf(str).byteValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      GenseeLog.e("PullBase", paramString + localNumberFormatException);
    }
    return 0;
  }

  protected float getAttrFloatValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    String str = getAttrStrValue(paramXmlPullParser, paramString);
    if ((str == null) || ("".equals(str)))
      return 0.0F;
    try
    {
      float f = Float.valueOf(str).floatValue();
      return f;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      GenseeLog.e("PullBase", paramString + localNumberFormatException);
    }
    return 0.0F;
  }

  protected int getAttrIntValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    String str = getAttrStrValue(paramXmlPullParser, paramString);
    if ((str == null) || ("".equals(str)))
      return 0;
    try
    {
      int i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      GenseeLog.e("PullBase", paramString + localNumberFormatException);
    }
    return 0;
  }

  protected long getAttrLongMcValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    return ()(1000.0F * getAttrFloatValue(paramXmlPullParser, paramString));
  }

  protected long getAttrLongValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    String str = getAttrStrValue(paramXmlPullParser, paramString);
    if ((str == null) || ("".equals(str)));
    while (true)
    {
      return 0L;
      try
      {
        long l2 = Long.valueOf(str).longValue();
        return l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if ((str.contains("E")) || (str.contains("e")))
          try
          {
            Number localNumber = DecimalFormat.getInstance().parse(str);
            if (localNumber == null)
              continue;
            long l1 = localNumber.longValue();
            return l1;
          }
          catch (ParseException localParseException)
          {
            localParseException.printStackTrace();
            return 0L;
          }
        GenseeLog.e("PullBase", paramString + localNumberFormatException);
      }
    }
    return 0L;
  }

  protected short getAttrShortValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    String str = getAttrStrValue(paramXmlPullParser, paramString);
    if ((str == null) || ("".equals(str)))
      return -1;
    try
    {
      int i = Short.valueOf(str).shortValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      GenseeLog.e("PullBase", paramString + localNumberFormatException);
    }
    return 0;
  }

  protected boolean getAttrStrBoolValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    return "true".equalsIgnoreCase(getAttrStrValue(paramXmlPullParser, paramString));
  }

  protected String getAttrStrValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString == null)
    {
      GenseeLog.e("PullBase", "getAttributeValue AttributeName  is null!");
      return null;
    }
    try
    {
      String str = paramXmlPullParser.getAttributeValue(null, paramString);
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      GenseeLog.e("PullBase", "getAttributeValue IndexOutOfBoundsException  that attr is " + paramString);
    }
    return paramString;
  }

  protected int getEventType(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser != null)
      try
      {
        int i = paramXmlPullParser.getEventType();
        return i;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        localXmlPullParserException.printStackTrace();
      }
    return 1;
  }

  protected int nextEventType(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser != null);
    try
    {
      int i = paramXmlPullParser.next();
      return i;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      localXmlPullParserException.printStackTrace();
      return 1;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  protected abstract void onEndDoc(XmlPullParser paramXmlPullParser);

  protected abstract void onEndTag(String paramString, XmlPullParser paramXmlPullParser);

  protected abstract void onStartDoc(XmlPullParser paramXmlPullParser);

  protected abstract void onStartTag(String paramString, XmlPullParser paramXmlPullParser);

  protected void onStartText(XmlPullParser paramXmlPullParser)
  {
  }

  protected void parser(XmlPullParser paramXmlPullParser)
  {
    int i;
    if (paramXmlPullParser != null)
    {
      i = getEventType(paramXmlPullParser);
      if (i == 1)
        onEndDoc(paramXmlPullParser);
    }
    else
    {
      return;
    }
    String str = paramXmlPullParser.getName();
    switch (i)
    {
    case 1:
    default:
    case 2:
    case 3:
    case 0:
    case 4:
    }
    while (true)
    {
      i = nextEventType(paramXmlPullParser);
      break;
      onStartTag(str, paramXmlPullParser);
      continue;
      onEndTag(str, paramXmlPullParser);
      continue;
      onStartDoc(paramXmlPullParser);
      continue;
      onStartText(paramXmlPullParser);
    }
  }

  public abstract <T> T toParse(InputStream paramInputStream);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.parse.PullBase
 * JD-Core Version:    0.6.0
 */