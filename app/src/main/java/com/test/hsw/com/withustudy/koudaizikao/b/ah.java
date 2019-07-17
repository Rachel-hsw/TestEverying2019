package com.withustudy.koudaizikao.b;

import a.a.a.e.k;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.entity.VideoCourse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import koudai.db.CourseJiangYiInforDao;
import koudai.db.CourseJiangYiInforDao.Properties;
import koudai.db.b;

public class ah extends BaseAdapter
{
  c a = null;
  Handler b = new Handler(new ai(this));
  private Context c;
  private List<VideoCourse> d;
  private PullToRefreshListView e;
  private ListView f;
  private CourseJiangYiInforDao g;
  private a h;

  public ah(Context paramContext, List<VideoCourse> paramList, PullToRefreshListView paramPullToRefreshListView)
  {
    this.c = paramContext;
    this.d = paramList;
    this.e = paramPullToRefreshListView;
    this.f = ((ListView)paramPullToRefreshListView.getRefreshableView());
    this.g = com.withustudy.koudaizikao.e.a.a(paramContext).f();
  }

  private void a(int paramInt)
  {
    monitorenter;
    monitorexit;
  }

  private void a(int paramInt, String paramString)
  {
    new Thread(new al(this, paramString, paramInt)).start();
  }

  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    monitorenter;
    try
    {
      List localList = this.g.k().a(CourseJiangYiInforDao.Properties.c.a(paramString), new k[0]).d();
      b localb;
      int i;
      if ((localList != null) && (localList.size() > 0))
      {
        localb = (b)localList.get(0);
        i = paramInt3 + localb.e().intValue();
        localb.a(Integer.valueOf(i));
        if (i != paramInt2)
          break label167;
        localb.c(Integer.valueOf(2));
      }
      while (true)
      {
        localb.a(Boolean.valueOf(bool));
        this.g.i(localb);
        b localb1 = new b();
        b.a(localb1, i);
        b.a(localb1, paramString);
        b.b(localb1, paramInt2);
        b.c(localb1, paramInt1);
        this.b.obtainMessage(0, localb1).sendToTarget();
        return;
        label167: localb.c(Integer.valueOf(1));
        bool = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private String b(String paramString)
  {
    return paramString.substring(1 + paramString.lastIndexOf("/"));
  }

  public void a(a parama)
  {
    this.h = parama;
  }

  protected void a(String paramString)
  {
    List localList = this.g.k().a(CourseJiangYiInforDao.Properties.c.a(paramString), new k[0]).d();
    Intent localIntent;
    if ((localList != null) && (localList.size() > 0))
    {
      b localb = (b)localList.get(0);
      Boolean localBoolean = localb.d();
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        Uri localUri = Uri.fromFile(new File(localb.b()));
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(localUri, "application/pdf");
        localIntent.setFlags(67108864);
      }
    }
    try
    {
      this.c.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(this.c, "No Application Available to View PDF", 0).show();
    }
  }

  public int getCount()
  {
    return this.d.size();
  }

  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    VideoCourse localVideoCourse;
    String str3;
    label286: label369: b localb;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2130903213, null);
      this.a = new c();
      this.a.b = ((ImageView)paramView.findViewById(2131297347));
      this.a.c = ((TextView)paramView.findViewById(2131297348));
      this.a.d = ((TextView)paramView.findViewById(2131297349));
      this.a.e = ((TextView)paramView.findViewById(2131297354));
      this.a.f = ((TextView)paramView.findViewById(2131297350));
      this.a.g = ((TextView)paramView.findViewById(2131297355));
      this.a.a = ((ProgressBar)paramView.findViewById(2131297351));
      this.a.h = ((TextView)paramView.findViewById(2131297352));
      this.a.i = ((TextView)paramView.findViewById(2131297353));
      paramView.setTag(this.a);
      localVideoCourse = (VideoCourse)this.d.get(paramInt);
      if (localVideoCourse.getCategory() != 0)
        break label856;
      this.a.c.setText("直播课");
      this.a.c.setTextColor(Color.parseColor("#ed3d3d"));
      str3 = ((VideoCourse)this.d.get(paramInt)).getPlay_status();
      if (!str3.equals("已结课"))
        break label789;
      this.a.e.setText("直播回放");
      this.a.e.setTextColor(Color.parseColor((String)com.withustudy.koudaizikao.d.a.g.get(((VideoCourse)this.d.get(paramInt)).getPlay_status())));
      this.a.g.setText(((VideoCourse)this.d.get(paramInt)).getCourse_hour() + "个课时");
      if ((localVideoCourse.getPic_url() == null) || (localVideoCourse.getPic_url().equals("")))
        break label982;
      e.a(this.c).a(localVideoCourse.getPic_url(), this.a.b);
      label413: this.a.d.setText(localVideoCourse.getCourse_name());
      this.a.f.setText(localVideoCourse.getLive_time());
      this.a.h.setBackgroundResource(2130837766);
      this.a.h.setText("讲义下载");
      this.a.h.setVisibility(0);
      this.a.a.setVisibility(0);
      this.a.a.setProgress(0);
      String str1 = localVideoCourse.getHandout();
      if ((str1 == null) || (str1.equals("")))
        break label1155;
      List localList = this.g.k().a(CourseJiangYiInforDao.Properties.c.a(str1), new k[0]).d();
      if ((localList == null) || (localList.size() <= 0))
        break label1093;
      localb = (b)localList.get(0);
      Boolean localBoolean = localb.d();
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
        break label998;
      this.a.h.setText("查看讲义");
      this.a.h.setVisibility(0);
      this.a.h.setBackgroundResource(2130837766);
      this.a.a.setVisibility(8);
      label649: this.a.h.setTag(str1);
      this.a.a.setTag(str1);
      this.a.h.setOnClickListener(new aj(this, str1, paramInt));
    }
    while (true)
    {
      String str2 = localVideoCourse.getService_button_text();
      if ((str2 == null) || (str2.equals("")))
        break label1182;
      this.a.i.setText(str2);
      this.a.i.setOnClickListener(new ak(this, localVideoCourse));
      this.a.i.setVisibility(0);
      return paramView;
      this.a = ((c)paramView.getTag());
      break;
      label789: if ((str3.equals("即将开课")) || (str3.equals("即将直播")))
      {
        this.a.e.setText("即将直播");
        break label286;
      }
      this.a.e.setText(((VideoCourse)this.d.get(paramInt)).getPlay_status());
      break label286;
      label856: this.a.c.setText("视频课");
      this.a.c.setTextColor(this.c.getResources().getColor(2131034212));
      this.a.e.setText(((VideoCourse)this.d.get(paramInt)).getPlay_status());
      this.a.e.setTextColor(Color.parseColor("#32c605"));
      this.a.g.setText(((VideoCourse)this.d.get(paramInt)).getVideo_num() + "个视频");
      break label369;
      label982: this.a.b.setImageResource(2130837870);
      break label413;
      label998: this.a.h.setBackgroundResource(2130837767);
      this.a.h.setText("讲义下载");
      this.a.h.setVisibility(0);
      Integer localInteger1 = localb.f();
      Integer localInteger2 = localb.e();
      this.a.a.setMax(localInteger1.intValue());
      this.a.a.setProgress(localInteger2.intValue());
      this.a.a.setVisibility(0);
      break label649;
      label1093: this.a.h.setText("讲义下载");
      this.a.h.setBackgroundResource(2130837766);
      this.a.h.setVisibility(0);
      this.a.a.setVisibility(0);
      this.a.a.setProgress(0);
      break label649;
      label1155: this.a.h.setVisibility(8);
      this.a.a.setVisibility(8);
    }
    label1182: this.a.i.setVisibility(8);
    return paramView;
  }

  public static abstract interface a
  {
    public abstract void a(VideoCourse paramVideoCourse);
  }

  public class b
  {
    private int b;
    private int c;
    private String d;
    private int e;

    public b()
    {
    }
  }

  class c
  {
    public ProgressBar a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;

    c()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ah
 * JD-Core Version:    0.6.0
 */