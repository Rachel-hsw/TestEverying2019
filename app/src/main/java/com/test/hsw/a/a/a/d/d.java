package a.a.a.d;

import a.a.a.i;

public class d
{
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
    localStringBuilder.append('"').append(paramString1).append('"').append(' ');
    if (paramString2 != null)
      localStringBuilder.append(paramString2).append(' ');
    return localStringBuilder.toString();
  }

  public static String a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    localStringBuilder.append('"').append(paramString2).append('"').append(" (");
    a(localStringBuilder, paramArrayOfString);
    localStringBuilder.append(") VALUES (");
    a(localStringBuilder, paramArrayOfString.length);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }

  public static String a(String paramString, String[] paramArrayOfString)
  {
    String str = '"' + paramString + '"';
    StringBuilder localStringBuilder = new StringBuilder("DELETE FROM ");
    localStringBuilder.append(str);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      localStringBuilder.append(" WHERE ");
      b(localStringBuilder, str, paramArrayOfString);
    }
    return localStringBuilder.toString();
  }

  public static String a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    String str = '"' + paramString + '"';
    StringBuilder localStringBuilder = new StringBuilder("UPDATE ");
    localStringBuilder.append(str).append(" SET ");
    b(localStringBuilder, paramArrayOfString1);
    localStringBuilder.append(" WHERE ");
    b(localStringBuilder, str, paramArrayOfString2);
    return localStringBuilder.toString();
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    if (i >= paramInt)
      return paramStringBuilder;
    if (i < paramInt - 1)
      paramStringBuilder.append("?,");
    while (true)
    {
      i++;
      break;
      paramStringBuilder.append('?');
    }
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"').append(paramString).append('"');
    return paramStringBuilder;
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString, i parami)
  {
    if (paramString != null)
      paramStringBuilder.append(paramString).append('.');
    paramStringBuilder.append('"').append(parami.e).append('"');
    return paramStringBuilder;
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1).append(".\"").append(paramString2).append('"');
    return paramStringBuilder;
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return paramStringBuilder;
      a(paramStringBuilder, paramString, paramArrayOfString[j]);
      if (j >= i - 1)
        continue;
      paramStringBuilder.append(',');
    }
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return paramStringBuilder;
      paramStringBuilder.append('"').append(paramArrayOfString[j]).append('"');
      if (j >= i - 1)
        continue;
      paramStringBuilder.append(',');
    }
  }

  public static String b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((paramString2 == null) || (paramString2.length() < 0))
      throw new a.a.a.d("Table alias required");
    StringBuilder localStringBuilder = new StringBuilder("SELECT ");
    a(localStringBuilder, paramString2, paramArrayOfString).append(" FROM ");
    localStringBuilder.append('"').append(paramString1).append('"').append(' ').append(paramString2).append(' ');
    return localStringBuilder.toString();
  }

  public static StringBuilder b(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfString.length)
        return paramStringBuilder;
      a(paramStringBuilder, paramString, paramArrayOfString[i]).append("=?");
      if (i >= -1 + paramArrayOfString.length)
        continue;
      paramStringBuilder.append(',');
    }
  }

  public static StringBuilder b(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfString.length)
        return paramStringBuilder;
      a(paramStringBuilder, paramArrayOfString[i]).append("=?");
      if (i >= -1 + paramArrayOfString.length)
        continue;
      paramStringBuilder.append(',');
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.d.d
 * JD-Core Version:    0.6.0
 */