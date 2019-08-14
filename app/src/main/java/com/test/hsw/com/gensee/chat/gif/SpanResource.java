package com.gensee.chat.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpanResource
{
  public static final int CONTEXT_AVATAR_MAX = 20;
  public static final int CONTEXT_MAX = 512;
  private static final String RICH_BROW = "<IMG src=\"emotion\\%s\" custom=\"false\">";
  private static Map<String, Integer> browMap;
  private static Html.ImageGetter extraImageGetter = null;
  public static String matchString;
  private static Map<String, String> richSendMap;
  private static Map<String, String> textMap;
  private static List<String> textTipList;
  private static Map<String, Drawable> uiMap;

  public static String convertToSendRichText(String paramString)
  {
    if ((textTipList == null) || (textTipList.size() <= 0) || (richSendMap == null) || (richSendMap.size() <= 0) || (textMap == null) || (textMap.size() <= 0))
      return paramString;
    String str1 = escapeStr(paramString);
    Matcher localMatcher = Pattern.compile(matchString).matcher(str1);
    String str2 = str1;
    while (true)
    {
      if (!localMatcher.find())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<SPAN>");
        localStringBuilder.append(str2);
        localStringBuilder.append("</SPAN>");
        return localStringBuilder.toString();
      }
      if ((textTipList.contains(localMatcher.group())) && (!str2.contains(localMatcher.group() + (String)textMap.get(localMatcher.group()))))
      {
        String str4 = localMatcher.group();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = richSendMap.get(localMatcher.group());
        str2 = str2.replace(str4, String.format("<IMG src=\"emotion\\%s\" custom=\"false\">", arrayOfObject2) + (String)textMap.get(localMatcher.group()));
        continue;
      }
      String str3 = localMatcher.group();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = richSendMap.get(localMatcher.group());
      str2 = str2.replace(str3, String.format("<IMG src=\"emotion\\%s\" custom=\"false\">", arrayOfObject1));
    }
  }

  public static String convertToSendText(String paramString)
  {
    if ((textMap == null) || (textMap.size() <= 0));
    while (true)
    {
      return paramString;
      Matcher localMatcher = Pattern.compile(matchString).matcher(paramString);
      while (localMatcher.find())
        paramString = paramString.replace(localMatcher.group(), (CharSequence)textMap.get(localMatcher.group()));
    }
  }

  public static Spanned convetRichToExpression(Context paramContext, String paramString, int paramInt, Map<Integer, Drawable> paramMap, Vector<Drawable> paramVector)
  {
    if ((browMap == null) || (browMap.size() <= 0))
      return new SpannableStringBuilder(paramString);
    return Html.fromHtml(paramString, new SpanResource.1(paramMap, paramContext, paramVector), null);
  }

  public static Spannable convetToSpan(String paramString, Context paramContext)
  {
    new StringBuilder().append(' ').append(paramString).toString();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    if ((uiMap == null) || (uiMap.size() <= 0))
      return localSpannableStringBuilder;
    Matcher localMatcher = Pattern.compile(matchString).matcher(paramString);
    while (true)
    {
      if (!localMatcher.find())
        return localSpannableStringBuilder;
      Drawable localDrawable = (Drawable)uiMap.get(localMatcher.group());
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localSpannableStringBuilder.setSpan(new ImageSpan(localDrawable, 0), localMatcher.start(), localMatcher.end(), 33);
    }
  }

  private static String escapeStr(String paramString)
  {
    if (paramString.contains("&"));
    for (String str = paramString.replace("&", "&amp;"); ; str = paramString)
    {
      if (str.contains("<"))
        str = str.replace("<", "&lt;");
      if (str.contains(">"))
        str = str.replace(">", "&gt;");
      if (str.contains(" "))
        str = str.replace(" ", "&nbsp;");
      if (paramString.contains("\n"))
        str = str.replace("\n", "<br>");
      return str;
    }
  }

  public static int[] getAvatarCount(String paramString)
  {
    int[] arrayOfInt = new int[3];
    Matcher localMatcher;
    if (matchString != null)
    {
      new StringBuilder().append(' ').append(paramString).toString();
      localMatcher = Pattern.compile(matchString).matcher(paramString);
    }
    while (true)
    {
      if (!localMatcher.find())
        return arrayOfInt;
      arrayOfInt[0] = (1 + arrayOfInt[0]);
      arrayOfInt[1] += localMatcher.group().length();
      arrayOfInt[2] = localMatcher.group().length();
    }
  }

  public static Map<String, Drawable> getBrowMap(Context paramContext)
  {
    return uiMap;
  }

  public static void initBrowSource(LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    if (browMap == null)
      browMap = new LinkedHashMap(18);
    browMap.clear();
    browMap.putAll(paramLinkedHashMap);
  }

  private static String initMachString(Set<String> paramSet)
  {
    monitorenter;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramSet.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          String str = localStringBuilder.toString();
          return str;
        }
        localStringBuilder.append((String)localIterator.next()).append('|');
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void initSendRichMap(HashMap<String, String> paramHashMap)
  {
    if (matchString == null)
    {
      matchString = initMachString(browMap.keySet());
      matchString = matchString.substring(0, -1 + matchString.length());
    }
    if (richSendMap == null)
      richSendMap = new HashMap(18);
    richSendMap.clear();
    richSendMap.putAll(paramHashMap);
  }

  public static void initTextMap(HashMap<String, String> paramHashMap)
  {
    if (textMap == null)
      textMap = new HashMap(18);
    textMap.clear();
    textMap.putAll(paramHashMap);
  }

  public static void initTextTipList(List<String> paramList)
  {
    if (textTipList == null)
      textTipList = new ArrayList();
    textTipList.clear();
    textTipList.addAll(paramList);
  }

  public static void initUiMap(HashMap<String, Drawable> paramHashMap)
  {
    if (uiMap == null)
      uiMap = new LinkedHashMap(18);
    uiMap.clear();
    uiMap.putAll(paramHashMap);
  }

  public static void setExtraImageGetter(Html.ImageGetter paramImageGetter)
  {
    extraImageGetter = paramImageGetter;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.gif.SpanResource
 * JD-Core Version:    0.6.0
 */