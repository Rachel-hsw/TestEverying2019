package com.umeng.socialize.b;

import android.text.TextUtils;
import com.umeng.socialize.b.a.f;
import com.umeng.socialize.bean.bc;
import com.umeng.socialize.bean.bc.a;
import com.umeng.socialize.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class m extends f
{
  public List<bc> a;

  public m(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public static char a(char paramChar)
  {
    if ((paramChar >= 'a') && (paramChar <= 'z'))
      paramChar = (char)(paramChar - ' ');
    return paramChar;
  }

  public void a()
  {
    JSONObject localJSONObject1 = this.l;
    if (localJSONObject1 == null)
    {
      i.b(f.k, "data json is null....");
      return;
    }
    this.a = new ArrayList();
    Iterator localIterator = localJSONObject1.keys();
    label34: if (localIterator.hasNext());
    while (true)
    {
      String str2;
      try
      {
        String str1 = localIterator.next().toString();
        JSONObject localJSONObject2 = (JSONObject)this.l.get(str1);
        if (!localJSONObject2.has("name"))
          break label34;
        localObject = localJSONObject2.getString("name");
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject)))
          break label34;
        bc localbc = new bc();
        localbc.b(str1);
        localbc.c((String)localObject);
        str2 = localJSONObject2.optString("link_name", "");
        if (!TextUtils.isEmpty(str2))
          break label261;
        localbc.a((String)localObject);
        String str3 = localJSONObject2.optString("pinyin", "");
        if (TextUtils.isEmpty(str3))
          continue;
        bc.a locala = new bc.a();
        locala.b = String.valueOf(a(str3.charAt(0)));
        locala.a = str3;
        localbc.a(locala);
        if (!localJSONObject2.has("profile_image_url"))
          continue;
        localbc.d(localJSONObject2.getString("profile_image_url"));
        this.a.add(localbc);
      }
      catch (Exception localException)
      {
        i.b(k, "Parse friend data error", localException);
      }
      break label34;
      break;
      label261: Object localObject = str2;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.m
 * JD-Core Version:    0.6.0
 */