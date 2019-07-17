package com.gensee.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
  static String REGULAR_EX = "#";

  public static boolean addStringToPre(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    if ((paramSharedPreferences == null) || (isEmpty(paramString1)) || (isEmpty(paramString2)));
    List localList;
    do
    {
      return false;
      localList = getListStr(paramSharedPreferences, paramString1);
    }
    while ((localList != null) && (localList.contains(paramString2)));
    String str = new StringBuilder(String.valueOf(paramSharedPreferences.getString(paramString1, ""))).append(paramString2).toString() + REGULAR_EX;
    return paramSharedPreferences.edit().putString(paramString1, str).commit();
  }

  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      return null;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte.length)
        return localStringBuilder.toString();
      String str = Integer.toHexString(0xFF & paramArrayOfByte[i]);
      if (str.length() < 2)
        localStringBuilder.append(0);
      localStringBuilder.append(str);
    }
  }

  public static boolean deleteString(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    List localList = getListStr(paramSharedPreferences, paramString1);
    if ((localList != null) && (localList.remove(paramString2)))
    {
      Iterator localIterator = localList.iterator();
      String str2;
      for (String str1 = ""; ; str1 = new StringBuilder(String.valueOf(str1)).append(str2).toString() + REGULAR_EX)
      {
        if (!localIterator.hasNext())
          return paramSharedPreferences.edit().putString(paramString1, str1).commit();
        str2 = (String)localIterator.next();
      }
    }
    return false;
  }

  public static List<String> getListStr(SharedPreferences paramSharedPreferences, String paramString)
  {
    ArrayList localArrayList = null;
    if (paramSharedPreferences != null)
    {
      boolean bool = isEmpty(paramString);
      localArrayList = null;
      if (!bool)
        break label19;
    }
    while (true)
    {
      return localArrayList;
      label19: String[] arrayOfString = paramSharedPreferences.getString(paramString, "").split(REGULAR_EX);
      localArrayList = null;
      if (arrayOfString == null)
        continue;
      int i = arrayOfString.length;
      localArrayList = null;
      if (i <= 0)
        continue;
      localArrayList = new ArrayList(arrayOfString.length);
      int j = arrayOfString.length;
      for (int k = 0; k < j; k++)
      {
        String str = arrayOfString[k];
        if (isEmpty(str))
          continue;
        localArrayList.add(str);
      }
    }
  }

  public static int hexStringToAlgorism(String paramString)
  {
    String str = paramString.toUpperCase();
    int i = str.length();
    int j = i;
    int k = 0;
    if (j <= 0)
      return k;
    int m = str.charAt(j - 1);
    if ((m >= 48) && (m <= 57));
    for (int n = m - 48; ; n = m - 55)
    {
      k = (int)(k + Math.pow(16.0D, i - j) * n);
      j--;
      break;
    }
  }

  public static String hexStringToString(String paramString, int paramInt)
  {
    String str = "";
    int i = paramString.length() / paramInt;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return str;
      char c = (char)hexStringToAlgorism(paramString.substring(j * paramInt, paramInt * (j + 1)));
      str = str + c;
    }
  }

  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
  }

  public static boolean isIPCorrect(String paramString)
  {
    return Pattern.compile("((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))").matcher(paramString).matches();
  }

  public static String toBinary(long paramLong, int paramInt)
  {
    String str = "";
    while (true)
    {
      if (paramLong == 0L)
        return str;
      str = paramLong % paramInt + str;
      paramLong /= paramInt;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.StringUtil
 * JD-Core Version:    0.6.0
 */