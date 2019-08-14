package com.withustudy.koudaizikao.fragment;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.http.e;
import com.example.test.FlowLayout;
import com.umeng.a.g;
import com.withustudy.koudaizikao.activity.KnowledgePointDetailActivity;
import com.withustudy.koudaizikao.activity.QuestionDetailActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Kpoint;
import com.withustudy.koudaizikao.entity.KpointDetails;
import com.withustudy.koudaizikao.g.h;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FragmentKPoint extends AbsBaseFragment
  implements View.OnClickListener
{
  public static final int a = 1;
  private KpointDetails F;
  private List<KpointDetails> G;
  private PopupWindow H;
  private ListView I;
  private a J;
  private LinearLayout K;
  private PopupWindow L;
  private Button M;
  private Button N;
  private Button O;
  private LinearLayout P;
  private ImageButton b;
  private TextView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private RelativeLayout g;
  private LinearLayout h;
  private LinearLayout i;
  private ImageButton j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private ImageView r;
  private ImageView s;
  private Button t;
  private RelativeLayout u;
  private FlowLayout v;
  private KnowledgePointDetailActivity w;

  private List<View> a(String paramString)
  {
    List localList = b(paramString);
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
          localImageView.setOnClickListener(new l(this, str2));
          this.D.a(str2, localImageView);
          continue;
        }
        localArrayList.addAll(a(str1, true));
      }
    }
    return null;
  }

  // ERROR //
  private List<View> a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +354 -> 355
    //   4: aload_1
    //   5: ldc 149
    //   7: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +345 -> 355
    //   13: aload_1
    //   14: invokevirtual 116	java/lang/String:length	()I
    //   17: ifle +338 -> 355
    //   20: new 73	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 74	java/util/ArrayList:<init>	()V
    //   27: astore_3
    //   28: ldc 149
    //   30: astore 4
    //   32: iconst_0
    //   33: istore 5
    //   35: iload 5
    //   37: aload_1
    //   38: invokevirtual 116	java/lang/String:length	()I
    //   41: if_icmplt +78 -> 119
    //   44: aload 4
    //   46: ldc 149
    //   48: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   51: ifne +66 -> 117
    //   54: new 154	android/widget/TextView
    //   57: dup
    //   58: aload_0
    //   59: getfield 158	com/withustudy/koudaizikao/fragment/FragmentKPoint:y	Landroid/content/Context;
    //   62: invokespecial 161	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   65: astore 16
    //   67: iload_2
    //   68: ifeq +257 -> 325
    //   71: aload 16
    //   73: iconst_2
    //   74: ldc 162
    //   76: invokevirtual 166	android/widget/TextView:setTextSize	(IF)V
    //   79: aload 16
    //   81: aload_0
    //   82: invokevirtual 170	com/withustudy/koudaizikao/fragment/FragmentKPoint:getResources	()Landroid/content/res/Resources;
    //   85: ldc 171
    //   87: invokevirtual 177	android/content/res/Resources:getColor	(I)I
    //   90: invokevirtual 181	android/widget/TextView:setTextColor	(I)V
    //   93: aload 16
    //   95: fconst_0
    //   96: ldc 182
    //   98: invokevirtual 186	android/widget/TextView:setLineSpacing	(FF)V
    //   101: aload 16
    //   103: aload 4
    //   105: invokevirtual 190	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   108: aload_3
    //   109: aload 16
    //   111: invokeinterface 113 2 0
    //   116: pop
    //   117: aload_3
    //   118: areturn
    //   119: iload 5
    //   121: iconst_1
    //   122: iadd
    //   123: istore 6
    //   125: aload_1
    //   126: iload 5
    //   128: iload 6
    //   130: invokevirtual 193	java/lang/String:substring	(II)Ljava/lang/String;
    //   133: astore 8
    //   135: aload 8
    //   137: ldc 195
    //   139: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifeq +101 -> 243
    //   145: new 154	android/widget/TextView
    //   148: dup
    //   149: aload_0
    //   150: invokevirtual 100	com/withustudy/koudaizikao/fragment/FragmentKPoint:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   153: invokespecial 161	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   156: astore 9
    //   158: iload_2
    //   159: ifeq +59 -> 218
    //   162: aload 9
    //   164: iconst_2
    //   165: ldc 162
    //   167: invokevirtual 166	android/widget/TextView:setTextSize	(IF)V
    //   170: aload 9
    //   172: aload_0
    //   173: invokevirtual 170	com/withustudy/koudaizikao/fragment/FragmentKPoint:getResources	()Landroid/content/res/Resources;
    //   176: ldc 171
    //   178: invokevirtual 177	android/content/res/Resources:getColor	(I)I
    //   181: invokevirtual 181	android/widget/TextView:setTextColor	(I)V
    //   184: aload 9
    //   186: fconst_0
    //   187: ldc 182
    //   189: invokevirtual 186	android/widget/TextView:setLineSpacing	(FF)V
    //   192: aload 9
    //   194: aload 4
    //   196: invokevirtual 190	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   199: aload_3
    //   200: aload 9
    //   202: invokeinterface 113 2 0
    //   207: pop
    //   208: ldc 149
    //   210: astore 4
    //   212: iinc 5 2
    //   215: goto +147 -> 362
    //   218: aload 9
    //   220: iconst_2
    //   221: ldc 196
    //   223: invokevirtual 166	android/widget/TextView:setTextSize	(IF)V
    //   226: aload 9
    //   228: aload_0
    //   229: invokevirtual 170	com/withustudy/koudaizikao/fragment/FragmentKPoint:getResources	()Landroid/content/res/Resources;
    //   232: ldc 197
    //   234: invokevirtual 177	android/content/res/Resources:getColor	(I)I
    //   237: invokevirtual 181	android/widget/TextView:setTextColor	(I)V
    //   240: goto -56 -> 184
    //   243: aload 8
    //   245: ldc 199
    //   247: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: istore 11
    //   252: iload 11
    //   254: ifeq +42 -> 296
    //   257: new 201	com/himamis/retex/renderer/android/LaTeXView
    //   260: dup
    //   261: aload_0
    //   262: invokevirtual 100	com/withustudy/koudaizikao/fragment/FragmentKPoint:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   265: invokespecial 202	com/himamis/retex/renderer/android/LaTeXView:<init>	(Landroid/content/Context;)V
    //   268: astore 13
    //   270: aload 13
    //   272: aload 4
    //   274: invokevirtual 206	com/himamis/retex/renderer/android/LaTeXView:setLatexText	(Ljava/lang/String;)V
    //   277: aload_3
    //   278: aload 13
    //   280: invokeinterface 113 2 0
    //   285: pop
    //   286: ldc 149
    //   288: astore 4
    //   290: iinc 5 2
    //   293: goto +69 -> 362
    //   296: new 208	java/lang/StringBuilder
    //   299: dup
    //   300: aload 4
    //   302: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   305: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload 8
    //   310: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 12
    //   318: aload 12
    //   320: astore 4
    //   322: goto +40 -> 362
    //   325: aload 16
    //   327: iconst_2
    //   328: ldc 196
    //   330: invokevirtual 166	android/widget/TextView:setTextSize	(IF)V
    //   333: aload 16
    //   335: aload_0
    //   336: invokevirtual 170	com/withustudy/koudaizikao/fragment/FragmentKPoint:getResources	()Landroid/content/res/Resources;
    //   339: ldc 197
    //   341: invokevirtual 177	android/content/res/Resources:getColor	(I)I
    //   344: invokevirtual 181	android/widget/TextView:setTextColor	(I)V
    //   347: goto -254 -> 93
    //   350: astore 17
    //   352: goto -235 -> 117
    //   355: aconst_null
    //   356: areturn
    //   357: astore 14
    //   359: goto -73 -> 286
    //   362: iinc 5 1
    //   365: goto -330 -> 35
    //   368: astore 7
    //   370: goto -8 -> 362
    //
    // Exception table:
    //   from	to	target	type
    //   54	67	350	java/lang/Exception
    //   71	93	350	java/lang/Exception
    //   93	117	350	java/lang/Exception
    //   325	347	350	java/lang/Exception
    //   257	286	357	java/lang/Exception
    //   125	158	368	java/lang/Exception
    //   162	184	368	java/lang/Exception
    //   184	208	368	java/lang/Exception
    //   218	240	368	java/lang/Exception
    //   243	252	368	java/lang/Exception
    //   296	318	368	java/lang/Exception
  }

  private List<String> b(String paramString)
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
      h.a("知识点和讲解的公式 图片混排切割=" + str);
    }
  }

  private void d()
  {
    if (this.H != null)
    {
      this.H.dismiss();
      this.H = null;
    }
    KnowledgePointDetailActivity localKnowledgePointDetailActivity = (KnowledgePointDetailActivity)getActivity();
    View localView = localKnowledgePointDetailActivity.getLayoutInflater().inflate(2130903223, null);
    this.I = ((ListView)localView.findViewById(2131296956));
    this.I.setOnItemClickListener(new m(this, localKnowledgePointDetailActivity));
    this.K = ((LinearLayout)localView.findViewById(2131297387));
    this.K.setOnClickListener(this);
    this.I.setAdapter(new a());
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.setOnFocusChangeListener(new n(this));
    this.H = new PopupWindow(localView, f.a(this.y).y(), com.withustudy.koudaizikao.g.n.a(getActivity(), 550.0F));
    this.H.setBackgroundDrawable(new BitmapDrawable());
    this.H.setOutsideTouchable(true);
    this.H.setFocusable(true);
    localView.setOnKeyListener(new o(this));
    this.H.showAtLocation(this.u, 80, 0, 0);
    a(1.0F);
  }

  private void e()
  {
    if (this.H != null)
    {
      this.H.dismiss();
      this.H = null;
    }
    a(1.0F);
    this.b.setBackgroundResource(2130837884);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return View.inflate(getActivity(), 2130903165, null);
  }

  public void a()
  {
  }

  public void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getActivity().getWindow().setAttributes(localLayoutParams);
  }

  public void a(View paramView)
  {
    this.v = ((FlowLayout)paramView.findViewById(2131297087));
    this.b = ((ImageButton)paramView.findViewById(2131297081));
    this.c = ((TextView)paramView.findViewById(2131297079));
    this.d = ((TextView)paramView.findViewById(2131297080));
    this.e = ((TextView)paramView.findViewById(2131297085));
    this.h = ((LinearLayout)paramView.findViewById(2131297084));
    this.g = ((RelativeLayout)paramView.findViewById(2131297083));
    this.f = ((ImageView)paramView.findViewById(2131297082));
    this.i = ((LinearLayout)paramView.findViewById(2131297086));
    this.j = ((ImageButton)paramView.findViewById(2131297063));
    this.k = ((TextView)paramView.findViewById(2131297064));
    this.l = ((TextView)paramView.findViewById(2131297088));
    this.m = ((TextView)paramView.findViewById(2131297065));
    this.n = ((TextView)paramView.findViewById(2131297066));
    this.o = ((ImageView)paramView.findViewById(2131297067));
    this.p = ((ImageView)paramView.findViewById(2131297068));
    this.q = ((ImageView)paramView.findViewById(2131297069));
    this.r = ((ImageView)paramView.findViewById(2131297070));
    this.s = ((ImageView)paramView.findViewById(2131297071));
    this.t = ((Button)paramView.findViewById(2131297089));
    this.u = ((RelativeLayout)paramView.findViewById(2131297078));
  }

  public void a(KpointDetails paramKpointDetails, List<KpointDetails> paramList)
  {
    try
    {
      this.F = paramKpointDetails;
      Iterator localIterator;
      String str4;
      if (paramKpointDetails != null)
      {
        String str1 = paramKpointDetails.getExplainText();
        if ((this.v == null) || (this.v.getChildCount() <= 0))
        {
          this.v.setOption(true);
          List localList = a("  " + str1);
          if ((localList != null) && (localList.size() > 0))
          {
            localIterator = localList.iterator();
            if (localIterator.hasNext())
              break label387;
            this.v.setVisibility(0);
          }
        }
        this.l.setVisibility(8);
        Kpoint localKpoint = paramKpointDetails.getKpoint();
        if (localKpoint != null)
        {
          String str2 = localKpoint.getName();
          this.d.setText(str2);
          String str3 = localKpoint.getSn();
          this.c.setText(str3);
        }
        str4 = paramKpointDetails.getGraspRequire();
        if ((str4 != null) && (!str4.equals("")))
          break label411;
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        label206: double d1 = paramKpointDetails.getErrorRate();
        double d2 = paramKpointDetails.getMyErrorRate();
        double d3 = d1 * 100.0D;
        String str5 = new DecimalFormat("0.0").format(d3);
        this.m.setText(str5 + "%");
        double d4 = d2 * 100.0D;
        String str6 = new DecimalFormat("0.0").format(d4);
        this.n.setText(str6 + "%");
        switch ((int)paramKpointDetails.getGraspLevel())
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
      }
      while (true)
      {
        if ((paramList == null) || (paramList.size() <= 0))
          break label625;
        this.G = paramList;
        return;
        label387: View localView = (View)localIterator.next();
        this.v.addView(localView);
        break;
        label411: this.e.setText(str4);
        this.h.setVisibility(0);
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        break label206;
        this.o.setBackgroundResource(2130837506);
        continue;
        this.o.setBackgroundResource(2130837710);
        continue;
        this.o.setBackgroundResource(2130837710);
        this.p.setBackgroundResource(2130837710);
        continue;
        this.o.setBackgroundResource(2130837710);
        this.p.setBackgroundResource(2130837710);
        this.q.setBackgroundResource(2130837710);
        continue;
        this.o.setBackgroundResource(2130837710);
        this.p.setBackgroundResource(2130837710);
        this.q.setBackgroundResource(2130837710);
        this.r.setBackgroundResource(2130837710);
        continue;
        this.o.setBackgroundResource(2130837710);
        this.p.setBackgroundResource(2130837710);
        this.q.setBackgroundResource(2130837710);
        this.r.setBackgroundResource(2130837710);
        this.s.setBackgroundResource(2130837710);
      }
      label625: return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b()
  {
  }

  public void c()
  {
    this.j.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297063:
    default:
    case 2131297387:
    case 2131297081:
    case 2131297089:
    }
    Kpoint localKpoint;
    do
    {
      do
      {
        return;
        e();
        return;
        d();
        this.b.setBackgroundResource(2130837889);
        return;
        g.b(this.y, "brush_k_exercise");
      }
      while (this.F == null);
      localKpoint = this.F.getKpoint();
    }
    while (localKpoint == null);
    String str = localKpoint.getId();
    Bundle localBundle = new Bundle();
    localBundle.putString("subjectId", ((KnowledgePointDetailActivity)getActivity()).a);
    localBundle.putString("kpointId", str);
    localBundle.putInt("FromPage", 1);
    a(QuestionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.H != null)
    {
      this.H.dismiss();
      this.H = null;
    }
    if (this.L != null)
    {
      this.L.dismiss();
      this.L = null;
    }
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (this.F != null))
      h.a("FragmentKpoint setUserVisibleHint  isVisibleToUser=" + paramBoolean);
  }

  class a extends BaseAdapter
  {
    a()
    {
    }

    public int getCount()
    {
      if ((FragmentKPoint.a(FragmentKPoint.this) == null) || (FragmentKPoint.a(FragmentKPoint.this).size() == 0))
        return 0;
      return FragmentKPoint.a(FragmentKPoint.this).size();
    }

    public Object getItem(int paramInt)
    {
      return null;
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      FragmentKPoint.b localb;
      if (paramView == null)
      {
        paramView = View.inflate(FragmentKPoint.this.getActivity(), 2130903224, null);
        localb = new FragmentKPoint.b(FragmentKPoint.this);
        FragmentKPoint.b.a(localb, (TextView)paramView.findViewById(2131296401));
        FragmentKPoint.b.b(localb, (TextView)paramView.findViewById(2131297388));
        paramView.setTag(localb);
      }
      while (true)
      {
        KpointDetails localKpointDetails = (KpointDetails)FragmentKPoint.a(FragmentKPoint.this).get(paramInt);
        if (localKpointDetails != null)
        {
          FragmentKPoint.b.a(localb).setText(localKpointDetails.getKpoint().getName());
          FragmentKPoint.b.b(localb).setText(localKpointDetails.getKpoint().getSn());
        }
        return paramView;
        localb = (FragmentKPoint.b)paramView.getTag();
      }
    }
  }

  class b
  {
    private TextView b;
    private TextView c;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.FragmentKPoint
 * JD-Core Version:    0.6.0
 */