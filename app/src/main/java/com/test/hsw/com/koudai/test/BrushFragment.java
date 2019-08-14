package com.koudai.test;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.http.e;
import com.example.test.FlowLayout;
import com.himamis.retex.renderer.android.LaTeXView;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.entity.Stem;
import com.withustudy.koudaizikao.g.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BrushFragment extends AbsBaseFragment
  implements View.OnClickListener
{
  protected int c = 0;
  protected Context d;
  protected View e;
  protected LinearLayout f;
  protected LinearLayout g;
  protected LinearLayout h;
  protected LinearLayout i;
  protected LinearLayout j;
  protected LinearLayout k;
  protected ImageView l;
  protected ImageView m;
  protected ImageView n;
  protected ImageView o;
  protected ImageView p;
  protected ImageView q;
  protected FlowLayout r;
  protected FlowLayout s;
  protected FlowLayout t;
  protected FlowLayout u;
  protected FlowLayout v;
  protected FlowLayout w;

  protected List<String> a(String paramString)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    int i2 = paramString.indexOf("[pic:", i1);
    Iterator localIterator;
    if (i2 == -1)
    {
      if (i1 + 1 < paramString.length())
        localArrayList.add(paramString.substring(i1 + 1, paramString.length()));
      localIterator = localArrayList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return localArrayList;
        if (i1 + 1 < i2)
        {
          localArrayList.add(paramString.substring(i1, i2));
          i1 = i2;
        }
        int i3 = paramString.indexOf("]", i1);
        if ((i3 == -1) || (i1 + 1 >= i3))
          break;
        localArrayList.add(paramString.substring(i1 + 1, i3));
        i1 = i3 + 1;
        break;
      }
      String str = (String)localIterator.next();
      h.a("知识点 讲解公式 文字 图片 混排切割 " + str);
    }
  }

  protected List<View> a(String paramString1, String paramString2)
  {
    List localList = a(paramString1);
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return localArrayList;
        String str1 = (String)localIterator.next();
        if (str1.contains("pic:"))
        {
          ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903182, null);
          localArrayList.add(localImageView);
          String str2 = str1.substring("pic:".length());
          localImageView.setOnClickListener(new k(this, str2));
          this.D.a(str2, localImageView);
          continue;
        }
        localArrayList.addAll(a(str1, true, paramString2));
      }
    }
    return null;
  }

  protected List<View> a(String paramString1, boolean paramBoolean, String paramString2)
  {
    ArrayList localArrayList;
    String str1;
    int i1;
    TextView localTextView3;
    if ((paramString1 != null) && (!paramString1.equals("")) && (paramString1.length() > 0))
    {
      localArrayList = new ArrayList();
      this.c = 0;
      str1 = "";
      i1 = 0;
      if (i1 >= paramString1.length())
        if (!str1.equals(""))
        {
          localTextView3 = new TextView(getActivity());
          if (!paramBoolean)
            break label938;
          localTextView3.setTextSize(2, 15.0F);
          localTextView3.setTextColor(getResources().getColor(2131034225));
        }
    }
    while (true)
    {
      localTextView3.setLineSpacing(0.0F, 1.3F);
      localTextView3.setText(str1);
      localArrayList.add(localTextView3);
      return localArrayList;
      String str2 = paramString1.substring(i1, i1 + 1);
      if (str2.equals("$"))
      {
        TextView localTextView1 = new TextView(getActivity());
        if (paramBoolean)
        {
          localTextView1.setTextSize(2, 15.0F);
          localTextView1.setTextColor(getResources().getColor(2131034225));
        }
        while (true)
        {
          localTextView1.setLineSpacing(0.0F, 1.3F);
          localTextView1.setText(str1);
          localArrayList.add(localTextView1);
          str1 = "";
          i1 += 2;
          label220: i1++;
          break;
          localTextView1.setTextSize(2, 17.0F);
          localTextView1.setTextColor(getResources().getColor(2131034226));
        }
      }
      if (str2.equals("#"));
      try
      {
        LaTeXView localLaTeXView = new LaTeXView(getActivity());
        localLaTeXView.setLatexText(str1);
        localArrayList.add(localLaTeXView);
        label291: str1 = "";
        i1 += 2;
        break label220;
        if ((str2.equals("_")) && (paramString2.equals("填空")))
        {
          if ((i1 + 1 < paramString1.length()) && (i1 + 2 < paramString1.length()) && (i1 + 3 < paramString1.length()) && (i1 + 4 <= paramString1.length()))
          {
            String str3 = paramString1.substring(i1 + 1, i1 + 2);
            String str4 = paramString1.substring(i1 + 2, i1 + 3);
            String str5 = paramString1.substring(i1 + 3, i1 + 4);
            if ((str3.equals("_")) && (str4.equals("_")) && (str5.equals("_")))
            {
              TextView localTextView2 = new TextView(getActivity());
              label475: ImageView localImageView;
              if (paramBoolean)
              {
                localTextView2.setTextSize(2, 15.0F);
                localTextView2.setTextColor(getResources().getColor(2131034225));
                localTextView2.setLineSpacing(0.0F, 1.3F);
                localTextView2.setText(str1);
                localArrayList.add(localTextView2);
                str1 = "";
                localImageView = new ImageView(getActivity());
                this.c = (1 + this.c);
                switch (this.c)
                {
                default:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                }
              }
              while (true)
              {
                localArrayList.add(localImageView);
                i1 += 3;
                break;
                localTextView2.setTextSize(2, 17.0F);
                localTextView2.setTextColor(getResources().getColor(2131034226));
                break label475;
                localImageView.setBackgroundResource(2130838082);
                localImageView.setTag("tk1");
                continue;
                localImageView.setBackgroundResource(2130838092);
                localImageView.setTag("tk2");
                continue;
                localImageView.setBackgroundResource(2130838094);
                localImageView.setTag("tk3");
                continue;
                localImageView.setBackgroundResource(2130838096);
                localImageView.setTag("tk4");
                continue;
                localImageView.setBackgroundResource(2130838098);
                localImageView.setTag("tk5");
                continue;
                localImageView.setBackgroundResource(2130838100);
                localImageView.setTag("tk6");
                continue;
                localImageView.setBackgroundResource(2130838102);
                localImageView.setTag("tk7");
                continue;
                localImageView.setBackgroundResource(2130838104);
                localImageView.setTag("tk8");
                continue;
                localImageView.setBackgroundResource(2130838106);
                localImageView.setTag("tk9");
                continue;
                localImageView.setBackgroundResource(2130838083);
                localImageView.setTag("tk10");
                continue;
                localImageView.setBackgroundResource(2130838085);
                localImageView.setTag("tk11");
                continue;
                localImageView.setBackgroundResource(2130838087);
                localImageView.setTag("tk12");
                continue;
                localImageView.setBackgroundResource(2130838089);
                localImageView.setTag("tk13");
              }
            }
            str1 = str1 + str2;
            break label220;
          }
          str1 = str1 + str2;
          break label220;
        }
        str1 = str1 + str2;
        break label220;
        label938: localTextView3.setTextSize(2, 17.0F);
        localTextView3.setTextColor(getResources().getColor(2131034226));
        continue;
        return null;
      }
      catch (Exception localException)
      {
        break label291;
      }
    }
  }

  protected void a(LinearLayout paramLinearLayout, Stem paramStem)
  {
    List localList = paramStem.getFigure();
    Iterator localIterator;
    if ((localList != null) && (localList.size() > 0))
    {
      paramLinearLayout.setVisibility(0);
      localIterator = localList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str = (String)localIterator.next();
      ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903182, null);
      paramLinearLayout.addView(localImageView);
      e.a(this.d).a(str, localImageView);
      localImageView.setOnClickListener(new j(this, str));
    }
  }

  protected void f()
  {
    this.f = ((LinearLayout)this.e.findViewById(2131297026));
    this.l = ((ImageView)this.e.findViewById(2131297027));
    this.r = ((FlowLayout)this.e.findViewById(2131297028));
    this.f.setOnClickListener(this);
    this.g = ((LinearLayout)this.e.findViewById(2131297029));
    this.m = ((ImageView)this.e.findViewById(2131297030));
    this.s = ((FlowLayout)this.e.findViewById(2131297031));
    this.g.setOnClickListener(this);
    this.h = ((LinearLayout)this.e.findViewById(2131297032));
    this.n = ((ImageView)this.e.findViewById(2131297033));
    this.t = ((FlowLayout)this.e.findViewById(2131297034));
    this.h.setOnClickListener(this);
    this.i = ((LinearLayout)this.e.findViewById(2131297035));
    this.o = ((ImageView)this.e.findViewById(2131297036));
    this.u = ((FlowLayout)this.e.findViewById(2131297037));
    this.i.setOnClickListener(this);
    this.j = ((LinearLayout)this.e.findViewById(2131297038));
    this.p = ((ImageView)this.e.findViewById(2131297039));
    this.v = ((FlowLayout)this.e.findViewById(2131297040));
    this.j.setOnClickListener(this);
    this.k = ((LinearLayout)this.e.findViewById(2131297041));
    this.q = ((ImageView)this.e.findViewById(2131297042));
    this.w = ((FlowLayout)this.e.findViewById(2131297043));
    this.k.setOnClickListener(this);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.d = paramActivity;
  }

  public void onClick(View paramView)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.BrushFragment
 * JD-Core Version:    0.6.0
 */