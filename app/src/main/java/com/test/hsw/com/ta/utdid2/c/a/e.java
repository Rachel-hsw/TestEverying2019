package com.ta.utdid2.c.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

final class e
{
  public static final Object a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getEventType();
    while (true)
    {
      if (i == 2)
        return b(paramXmlPullParser, paramArrayOfString);
      if (i == 3)
        throw new XmlPullParserException("Unexpected end tag at: " + paramXmlPullParser.getName());
      if (i == 4)
        throw new XmlPullParserException("Unexpected text: " + paramXmlPullParser.getText());
      try
      {
        int j = paramXmlPullParser.next();
        i = j;
        if (i != 1)
          continue;
        throw new XmlPullParserException("Unexpected end of document");
      }
      catch (Exception localException)
      {
      }
    }
    throw new XmlPullParserException("Unexpected call next(): " + paramXmlPullParser.getName());
  }

  private static HashMap a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
    throws XmlPullParserException, IOException
  {
    HashMap localHashMap = new HashMap();
    int i = paramXmlPullParser.getEventType();
    if (i == 2)
    {
      Object localObject = b(paramXmlPullParser, paramArrayOfString);
      if (paramArrayOfString[0] != null)
        localHashMap.put(paramArrayOfString[0], localObject);
    }
    do
    {
      i = paramXmlPullParser.next();
      if (i != 1)
        break;
      throw new XmlPullParserException("Document ended before " + paramString + " end tag");
      throw new XmlPullParserException("Map value without name attribute: " + paramXmlPullParser.getName());
    }
    while (i != 3);
    if (paramXmlPullParser.getName().equals(paramString))
      return localHashMap;
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }

  private static void a(Object paramObject, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException
  {
    if (paramObject == null)
    {
      paramXmlSerializer.startTag(null, "null");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString);
      paramXmlSerializer.endTag(null, "null");
      return;
    }
    if ((paramObject instanceof String))
    {
      paramXmlSerializer.startTag(null, "string");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString);
      paramXmlSerializer.text(paramObject.toString());
      paramXmlSerializer.endTag(null, "string");
      return;
    }
    String str;
    if ((paramObject instanceof Integer))
      str = "int";
    while (true)
    {
      paramXmlSerializer.startTag(null, str);
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString);
      paramXmlSerializer.attribute(null, "value", paramObject.toString());
      paramXmlSerializer.endTag(null, str);
      return;
      if ((paramObject instanceof Long))
      {
        str = "long";
        continue;
      }
      if ((paramObject instanceof Float))
      {
        str = "float";
        continue;
      }
      if ((paramObject instanceof Double))
      {
        str = "double";
        continue;
      }
      if (!(paramObject instanceof Boolean))
        break;
      str = "boolean";
    }
    if ((paramObject instanceof byte[]))
    {
      byte[] arrayOfByte = (byte[])paramObject;
      if (arrayOfByte == null)
      {
        paramXmlSerializer.startTag(null, "null");
        paramXmlSerializer.endTag(null, "null");
        return;
      }
      paramXmlSerializer.startTag(null, "byte-array");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString);
      int i = arrayOfByte.length;
      paramXmlSerializer.attribute(null, "num", Integer.toString(i));
      StringBuilder localStringBuilder = new StringBuilder(2 * arrayOfByte.length);
      int j = 0;
      if (j < i)
      {
        int k = arrayOfByte[j];
        int m = k >> 4;
        int n;
        label349: int i1;
        if (m >= 10)
        {
          n = -10 + (m + 97);
          localStringBuilder.append(n);
          i1 = k & 0xFF;
          if (i1 < 10)
            break label406;
        }
        label406: for (int i2 = -10 + (i1 + 97); ; i2 = i1 + 48)
        {
          localStringBuilder.append(i2);
          j++;
          break;
          n = m + 48;
          break label349;
        }
      }
      paramXmlSerializer.text(localStringBuilder.toString());
      paramXmlSerializer.endTag(null, "byte-array");
      return;
    }
    if ((paramObject instanceof int[]))
    {
      a((int[])paramObject, paramString, paramXmlSerializer);
      return;
    }
    if ((paramObject instanceof Map))
    {
      a((Map)paramObject, paramString, paramXmlSerializer);
      return;
    }
    if ((paramObject instanceof List))
    {
      a((List)paramObject, paramString, paramXmlSerializer);
      return;
    }
    if ((paramObject instanceof CharSequence))
    {
      paramXmlSerializer.startTag(null, "string");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString);
      paramXmlSerializer.text(paramObject.toString());
      paramXmlSerializer.endTag(null, "string");
      return;
    }
    throw new RuntimeException("writeValueXml: unable to write value " + paramObject);
  }

  private static void a(List paramList, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException
  {
    if (paramList == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    }
    paramXmlSerializer.startTag(null, "list");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString);
    int i = paramList.size();
    for (int j = 0; j < i; j++)
      a(paramList.get(j), null, paramXmlSerializer);
    paramXmlSerializer.endTag(null, "list");
  }

  public static final void a(Map paramMap, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException
  {
    if (paramMap == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    paramXmlSerializer.startTag(null, "map");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString);
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a(localEntry.getValue(), (String)localEntry.getKey(), paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, "map");
  }

  private static void a(int[] paramArrayOfInt, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException
  {
    if (paramArrayOfInt == null)
    {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    }
    paramXmlSerializer.startTag(null, "int-array");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString);
    int i = paramArrayOfInt.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(i));
    for (int j = 0; j < i; j++)
    {
      paramXmlSerializer.startTag(null, "item");
      paramXmlSerializer.attribute(null, "value", Integer.toString(paramArrayOfInt[j]));
      paramXmlSerializer.endTag(null, "item");
    }
    paramXmlSerializer.endTag(null, "int-array");
  }

  // ERROR //
  private static int[] a(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: ldc 132
    //   4: invokeinterface 219 3 0
    //   9: invokestatic 223	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   12: istore 4
    //   14: iload 4
    //   16: newarray int
    //   18: astore 5
    //   20: aload_0
    //   21: invokeinterface 18 1 0
    //   26: istore 6
    //   28: iconst_0
    //   29: istore 7
    //   31: iload 6
    //   33: istore 8
    //   35: iload 8
    //   37: iconst_2
    //   38: if_icmpne +152 -> 190
    //   41: aload_0
    //   42: invokeinterface 33 1 0
    //   47: ldc 210
    //   49: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +109 -> 161
    //   55: aload 5
    //   57: iload 7
    //   59: aload_0
    //   60: aconst_null
    //   61: ldc 110
    //   63: invokeinterface 219 3 0
    //   68: invokestatic 223	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: iastore
    //   72: aload_0
    //   73: invokeinterface 49 1 0
    //   78: istore 8
    //   80: iload 8
    //   82: iconst_1
    //   83: if_icmpne -48 -> 35
    //   86: new 8	org/xmlpull/v1/XmlPullParserException
    //   89: dup
    //   90: new 23	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 65
    //   96: invokespecial 29	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_1
    //   100: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 67
    //   105: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 41	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   114: athrow
    //   115: astore_3
    //   116: new 8	org/xmlpull/v1/XmlPullParserException
    //   119: dup
    //   120: ldc 225
    //   122: invokespecial 41	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //   126: astore_2
    //   127: new 8	org/xmlpull/v1/XmlPullParserException
    //   130: dup
    //   131: ldc 227
    //   133: invokespecial 41	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    //   137: astore 10
    //   139: new 8	org/xmlpull/v1/XmlPullParserException
    //   142: dup
    //   143: ldc 229
    //   145: invokespecial 41	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   148: athrow
    //   149: astore 9
    //   151: new 8	org/xmlpull/v1/XmlPullParserException
    //   154: dup
    //   155: ldc 231
    //   157: invokespecial 41	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   160: athrow
    //   161: new 8	org/xmlpull/v1/XmlPullParserException
    //   164: dup
    //   165: new 23	java/lang/StringBuilder
    //   168: dup
    //   169: ldc 233
    //   171: invokespecial 29	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: invokeinterface 33 1 0
    //   180: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokespecial 41	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   189: athrow
    //   190: iload 8
    //   192: iconst_3
    //   193: if_icmpne -121 -> 72
    //   196: aload_0
    //   197: invokeinterface 33 1 0
    //   202: aload_1
    //   203: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifeq +6 -> 212
    //   209: aload 5
    //   211: areturn
    //   212: aload_0
    //   213: invokeinterface 33 1 0
    //   218: ldc 210
    //   220: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifeq +9 -> 232
    //   226: iinc 7 1
    //   229: goto -157 -> 72
    //   232: new 8	org/xmlpull/v1/XmlPullParserException
    //   235: dup
    //   236: new 23	java/lang/StringBuilder
    //   239: dup
    //   240: ldc 77
    //   242: invokespecial 29	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: aload_1
    //   246: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc 79
    //   251: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: invokeinterface 33 1 0
    //   260: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokespecial 41	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   269: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	115	java/lang/NullPointerException
    //   0	14	126	java/lang/NumberFormatException
    //   55	72	137	java/lang/NullPointerException
    //   55	72	149	java/lang/NumberFormatException
  }

  private static final Object b(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
    throws XmlPullParserException, IOException
  {
    String str1 = paramXmlPullParser.getAttributeValue(null, "name");
    String str2 = paramXmlPullParser.getName();
    boolean bool = str2.equals("null");
    Object localObject = null;
    if (bool);
    while (true)
    {
      int i = paramXmlPullParser.next();
      if (i == 1)
        break;
      if (i == 3)
      {
        if (paramXmlPullParser.getName().equals(str2))
        {
          paramArrayOfString[0] = str1;
          return localObject;
          if (str2.equals("string"))
          {
            String str3 = "";
            while (true)
            {
              int j = paramXmlPullParser.next();
              if (j == 1)
                break;
              if (j == 3)
              {
                if (paramXmlPullParser.getName().equals("string"))
                {
                  paramArrayOfString[0] = str1;
                  return str3;
                }
                throw new XmlPullParserException("Unexpected end tag in <string>: " + paramXmlPullParser.getName());
              }
              if (j == 4)
              {
                str3 = str3 + paramXmlPullParser.getText();
                continue;
              }
              if (j != 2)
                continue;
              throw new XmlPullParserException("Unexpected start tag in <string>: " + paramXmlPullParser.getName());
            }
            throw new XmlPullParserException("Unexpected end of document in <string>");
          }
          if (str2.equals("int"))
          {
            localObject = Integer.valueOf(Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value")));
            continue;
          }
          if (str2.equals("long"))
          {
            localObject = Long.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
            continue;
          }
          if (str2.equals("float"))
          {
            localObject = new Float(paramXmlPullParser.getAttributeValue(null, "value"));
            continue;
          }
          if (str2.equals("double"))
          {
            localObject = new Double(paramXmlPullParser.getAttributeValue(null, "value"));
            continue;
          }
          if (str2.equals("boolean"))
          {
            localObject = Boolean.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
            continue;
          }
          if (str2.equals("int-array"))
          {
            paramXmlPullParser.next();
            int[] arrayOfInt = a(paramXmlPullParser, "int-array");
            paramArrayOfString[0] = str1;
            return arrayOfInt;
          }
          if (str2.equals("map"))
          {
            paramXmlPullParser.next();
            HashMap localHashMap = a(paramXmlPullParser, "map", paramArrayOfString);
            paramArrayOfString[0] = str1;
            return localHashMap;
          }
          if (str2.equals("list"))
          {
            paramXmlPullParser.next();
            ArrayList localArrayList = b(paramXmlPullParser, "list", paramArrayOfString);
            paramArrayOfString[0] = str1;
            return localArrayList;
          }
          throw new XmlPullParserException("Unknown tag: " + str2);
        }
        throw new XmlPullParserException("Unexpected end tag in <" + str2 + ">: " + paramXmlPullParser.getName());
      }
      if (i == 4)
        throw new XmlPullParserException("Unexpected text in <" + str2 + ">: " + paramXmlPullParser.getName());
      if (i != 2)
        continue;
      throw new XmlPullParserException("Unexpected start tag in <" + str2 + ">: " + paramXmlPullParser.getName());
    }
    throw new XmlPullParserException("Unexpected end of document in <" + str2 + ">");
  }

  private static ArrayList b(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
    throws XmlPullParserException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramXmlPullParser.getEventType();
    if (i == 2)
      localArrayList.add(b(paramXmlPullParser, paramArrayOfString));
    do
    {
      i = paramXmlPullParser.next();
      if (i != 1)
        break;
      throw new XmlPullParserException("Document ended before " + paramString + " end tag");
    }
    while (i != 3);
    if (paramXmlPullParser.getName().equals(paramString))
      return localArrayList;
    throw new XmlPullParserException("Expected " + paramString + " end tag at: " + paramXmlPullParser.getName());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.c.a.e
 * JD-Core Version:    0.6.0
 */