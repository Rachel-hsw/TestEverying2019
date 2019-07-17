package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gensee.entity.ChatMsg;
import com.gensee.view.MyTextViewEx;
import java.util.List;

public class ag extends BaseAdapter
{
  private Context a;
  private List<ChatMsg> b;
  private int c;
  private final int d = 5;

  public ag(Context paramContext, List<ChatMsg> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public int getCount()
  {
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    label113: String str2;
    String str1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130903210, null);
      locala = new a();
      a.a(locala, (TextView)paramView.findViewById(2131297338));
      a.a(locala, (MyTextViewEx)paramView.findViewById(2131297339));
      paramView.setTag(locala);
      if (((ChatMsg)this.b.get(paramInt)).getSenderId() != this.c)
        break label248;
      a.a(locala).setTextColor(Color.parseColor("#00b8e6"));
      a.b(locala).setTextColor(Color.parseColor("#00b8e6"));
      if (((ChatMsg)this.b.get(paramInt)).getSender() == null)
        break label312;
      str2 = ((ChatMsg)this.b.get(paramInt)).getSender();
      if (str2.length() > 5)
        break label277;
      str1 = str2 + " : ";
    }
    while (true)
    {
      a.a(locala).setText(str1);
      if (((ChatMsg)this.b.get(paramInt)).getRichText() == null)
        break label319;
      a.b(locala).setRichText(((ChatMsg)this.b.get(paramInt)).getRichText());
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label248: a.a(locala).setTextColor(Color.parseColor("#19599b"));
      a.b(locala).setTextColor(Color.parseColor("#999999"));
      break label113;
      label277: str1 = str2.substring(0, 5) + "..." + " : ";
      continue;
      label312: str1 = "";
    }
    label319: if (((ChatMsg)this.b.get(paramInt)).getContent() != null)
    {
      a.b(locala).setText(((ChatMsg)this.b.get(paramInt)).getContent());
      return paramView;
    }
    a.b(locala).setText("");
    return paramView;
  }

  class a
  {
    private TextView b;
    private MyTextViewEx c;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ag
 * JD-Core Version:    0.6.0
 */