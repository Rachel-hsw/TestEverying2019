package com.umeng.message.b;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URLDecoder;

public class ci
{
  private static final String[] a = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF" };
  private static final byte[] b = { 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 63, 63, 63, 63, 63, 63, 63, 10, 11, 12, 13, 14, 15, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 10, 11, 12, 13, 14, 15, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63 };

  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length();
    int j = 0;
    if (j < i)
    {
      char c = paramString.charAt(j);
      if (c == ' ')
        localStringBuffer.append('+');
      while (true)
      {
        j++;
        break;
        if (('A' <= c) && (c <= 'Z'))
        {
          localStringBuffer.append(c);
          continue;
        }
        if (('a' <= c) && (c <= 'z'))
        {
          localStringBuffer.append(c);
          continue;
        }
        if (('0' <= c) && (c <= '9'))
        {
          localStringBuffer.append(c);
          continue;
        }
        if ((c == '-') || (c == '_') || (c == '.') || (c == '!') || (c == '~') || (c == '*') || (c == '/') || (c == '(') || (c == ')'))
        {
          localStringBuffer.append(c);
          continue;
        }
        if (c <= '')
        {
          localStringBuffer.append('%');
          localStringBuffer.append(a[c]);
          continue;
        }
        localStringBuffer.append('%');
        localStringBuffer.append('u');
        localStringBuffer.append(a[(c >>> '\b')]);
        localStringBuffer.append(a[(c & 0xFF)]);
      }
    }
    return localStringBuffer.toString();
  }

  public static String b(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      char c = paramString.charAt(i);
      if (c == '+')
        localStringBuffer.append(' ');
      label192: 
      do
        while (true)
        {
          i++;
          break;
          if (('A' <= c) && (c <= 'Z'))
          {
            localStringBuffer.append(c);
            continue;
          }
          if (('a' <= c) && (c <= 'z'))
          {
            localStringBuffer.append(c);
            continue;
          }
          if (('0' <= c) && (c <= '9'))
          {
            localStringBuffer.append(c);
            continue;
          }
          if ((c != '-') && (c != '_') && (c != '.') && (c != '!') && (c != '~') && (c != '*') && (c != '/') && (c != '(') && (c != ')'))
            break label192;
          localStringBuffer.append(c);
        }
      while (c != '%');
      int k;
      if ('u' != paramString.charAt(i + 1))
      {
        k = (0x0 | b[paramString.charAt(i + 1)]) << 4 | b[paramString.charAt(i + 2)];
        i += 2;
      }
      while (true)
      {
        localStringBuffer.append((char)k);
        break;
        k = (((0x0 | b[paramString.charAt(i + 2)]) << 4 | b[paramString.charAt(i + 3)]) << 4 | b[paramString.charAt(i + 4)]) << 4 | b[paramString.charAt(i + 5)];
        i += 5;
      }
    }
    return localStringBuffer.toString();
  }

  public static String c(String paramString)
  {
    try
    {
      Uri.parse(paramString);
      return paramString;
    }
    catch (Throwable localThrowable)
    {
    }
    return e(paramString);
  }

  private static String d(String paramString)
  {
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString));
    try
    {
      String str3 = URLDecoder.decode(paramString, "utf-8");
      localObject = str3;
      label23: if (TextUtils.isEmpty((CharSequence)localObject));
      try
      {
        String str2 = URLDecoder.decode(paramString, "gbk");
        localObject = str2;
        label42: if (TextUtils.isEmpty((CharSequence)localObject));
        try
        {
          String str1 = b(paramString);
          localObject = str1;
          label58: if (TextUtils.isEmpty((CharSequence)localObject))
            localObject = paramString;
          return localObject;
        }
        catch (Throwable localThrowable2)
        {
          break label58;
        }
      }
      catch (Throwable localThrowable3)
      {
        break label42;
      }
    }
    catch (Throwable localThrowable1)
    {
      break label23;
    }
  }

  private static String e(String paramString)
  {
    int i = 0;
    if (paramString != null);
    while (true)
    {
      try
      {
        int j = paramString.indexOf("/");
        if (j <= -1)
          continue;
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramString.substring(0, j));
        int k = paramString.indexOf("?");
        if (k <= -1)
          continue;
        paramString.substring(j, k);
        String str1 = d(paramString.substring(j, k));
        String str2 = paramString.substring(k);
        if (TextUtils.isEmpty(str1))
          continue;
        localStringBuffer.append(str1);
        if (TextUtils.isEmpty(str2))
          continue;
        String[] arrayOfString1 = str2.split("&");
        if (arrayOfString1 == null)
          continue;
        int m = arrayOfString1.length;
        if (i >= m)
          continue;
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        if ((arrayOfString2 != null) && (arrayOfString2.length == 2))
        {
          String str4 = arrayOfString2[0];
          String str5 = d(arrayOfString2[1]);
          localStringBuffer.append(str4 + "=" + str5);
          if (i < m - 1)
          {
            localStringBuffer.append("&");
            break label255;
            str1 = d(paramString.substring(j));
            str2 = null;
            continue;
            String str3 = localStringBuffer.toString();
            paramString = str3;
            return paramString;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        return paramString;
      }
      label255: i++;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ci
 * JD-Core Version:    0.6.0
 */