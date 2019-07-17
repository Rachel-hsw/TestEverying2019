package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity.b;
import com.withustudy.koudaizikao.e.a;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoChapter;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.VideoSection;
import com.withustudy.koudaizikao.entity.local.VideoDownLoadStatus;
import com.withustudy.koudaizikao.entity.local.VideoTapeLevel;
import com.withustudy.koudaizikao.entity.local.VideoWait;
import com.withustudy.koudaizikao.fragment.VideoListFragment.c;
import com.withustudy.koudaizikao.g.f;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.p;
import java.util.List;
import koudai.db.VideoInfroDao;
import koudai.db.VideoInfroDao.Properties;

public class am extends BaseAdapter
{
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public boolean a = false;
  private Context f;
  private VideoCourse g;
  private VideoListFragment.c h;
  private List<VideoTapeLevel> i;
  private List<VideoTapeLevel> j;
  private List<VideoDownLoadStatus> k;
  private List<VideoWait> l;
  private String m;
  private a n;

  public am(VideoListFragment.c paramc, List<VideoChapter> paramList, List<VideoDownLoadStatus> paramList1, List<VideoWait> paramList2, Context paramContext, VideoCourse paramVideoCourse, String paramString)
  {
    this.h = paramc;
    this.f = paramContext;
    this.g = paramVideoCourse;
    this.k = paramList1;
    this.l = paramList2;
    this.n = new a();
    this.i = p.a(paramList);
    this.j = p.b(this.i);
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.m = paramString;
      h.a("加载上次观看的视频");
    }
    do
      return;
    while (b() == null);
    this.m = b().getVideo_id();
    h.a("加载第一个视频");
  }

  private void a(Video paramVideo, int paramInt)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.l.size())
        return;
      if (!paramVideo.getVideo_id().equals(((VideoWait)this.l.get(i1)).getmVideo().getVideo_id()))
        continue;
      ((VideoWait)this.l.get(i1)).setIsPause(paramInt);
    }
  }

  private void a(Video paramVideo, Button paramButton1, Button paramButton2, TextView paramTextView)
  {
    paramTextView.setVisibility(0);
    paramTextView.setText(p.a(paramVideo.getDuration()));
    paramButton2.setVisibility(8);
    paramButton1.setVisibility(0);
    paramButton1.setBackgroundResource(2130837703);
    List localList = a.a(this.f).e().k().a(VideoInfroDao.Properties.b.a(paramVideo.getVideo_id()), new a.a.a.e.k[0]).d();
    int i2;
    if (localList.size() != 0)
      i2 = 0;
    int i1;
    while (true)
    {
      if (i2 >= localList.size())
      {
        boolean bool = a(paramVideo);
        i1 = 0;
        if (!bool)
          break;
        if (b(paramVideo).getIsPause() == 0)
        {
          paramButton1.setBackgroundResource(2130837769);
          return;
        }
      }
      else
      {
        koudai.db.i locali = (koudai.db.i)localList.get(i2);
        if ((locali.b().equals(paramVideo.getVideo_id())) && (f.a(this.f).d(locali.c())))
        {
          paramButton1.setVisibility(8);
          paramButton2.setVisibility(0);
          return;
        }
        i2++;
        continue;
      }
      paramButton1.setBackgroundResource(2130837768);
      return;
    }
    while (true)
    {
      VideoDownLoadStatus localVideoDownLoadStatus = (VideoDownLoadStatus)this.k.get(i1);
      if (paramVideo.getVideo_id().equals(localVideoDownLoadStatus.getVideoId()))
      {
        if (localVideoDownLoadStatus.getStatus() != 100)
          break label265;
        paramButton1.setBackgroundResource(2130837769);
      }
      while (true)
      {
        i1++;
        if (i1 < this.k.size())
          break;
        return;
        label265: if (localVideoDownLoadStatus.getStatus() == 300)
        {
          paramButton1.setBackgroundResource(2130837768);
          continue;
        }
        if (localVideoDownLoadStatus.getStatus() != 200)
          continue;
        p.a(localVideoDownLoadStatus.getProgress(), paramButton1);
      }
    }
  }

  private boolean a(Video paramVideo)
  {
    if (this.l.size() == 0);
    while (true)
    {
      return false;
      for (int i1 = 0; i1 < this.l.size(); i1++)
        if (((VideoWait)this.l.get(i1)).getmVideo().getVideo_id().equals(paramVideo.getVideo_id()))
          return true;
    }
  }

  private VideoWait b(Video paramVideo)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.l.size())
        return null;
      if (paramVideo.getVideo_id().equals(((VideoWait)this.l.get(i1)).getmVideo().getVideo_id()))
        return (VideoWait)this.l.get(i1);
    }
  }

  public Video a(String paramString)
  {
    return p.a(this.j, paramString);
  }

  public List<VideoTapeLevel> a()
  {
    return this.j;
  }

  public void a(List<VideoDownLoadStatus> paramList)
  {
    this.k = paramList;
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public Video b()
  {
    return p.c(this.j);
  }

  public void b(String paramString)
  {
    this.m = paramString;
    notifyDataSetChanged();
  }

  public void b(List<VideoWait> paramList)
  {
    this.l = paramList;
  }

  public int getCount()
  {
    return this.j.size();
  }

  public Object getItem(int paramInt)
  {
    return this.j.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (((VideoTapeLevel)this.j.get(paramInt)).getLevel().length == 1)
      return 0;
    if (((VideoTapeLevel)this.j.get(paramInt)).getLevel().length == 3)
      return 3;
    if ((((VideoTapeLevel)this.j.get(paramInt)).getData() instanceof VideoSection))
      return 1;
    return 2;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    int i1 = getItemViewType(paramInt);
    d locald;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
      switch (i1)
      {
      default:
        locald = null;
        localObject2 = null;
        localObject3 = null;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    while (true)
      switch (i1)
      {
      default:
        return paramView;
        paramView = LayoutInflater.from(this.f).inflate(2130903214, null);
        b localb = new b();
        localb.a = ((LinearLayout)paramView.findViewById(2131297356));
        localb.b = ((TextView)paramView.findViewById(2131297357));
        localb.c = ((Button)paramView.findViewById(2131297358));
        paramView.setTag(localb);
        localObject3 = localb;
        localObject1 = null;
        locald = null;
        localObject2 = null;
        continue;
        paramView = LayoutInflater.from(this.f).inflate(2130903215, null);
        c localc = new c();
        localc.a = ((LinearLayout)paramView.findViewById(2131297359));
        localc.b = ((TextView)paramView.findViewById(2131297360));
        localc.c = ((Button)paramView.findViewById(2131297361));
        paramView.setTag(localc);
        localObject2 = localc;
        localObject1 = null;
        locald = null;
        localObject3 = null;
        continue;
        paramView = LayoutInflater.from(this.f).inflate(2130903216, null);
        locald = new d();
        locald.a = ((LinearLayout)paramView.findViewById(2131297362));
        locald.b = ((TextView)paramView.findViewById(2131297363));
        locald.c = ((TextView)paramView.findViewById(2131297364));
        locald.d = ((TextView)paramView.findViewById(2131297365));
        locald.e = ((Button)paramView.findViewById(2131297366));
        locald.f = ((Button)paramView.findViewById(2131297367));
        paramView.setTag(locald);
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        continue;
        paramView = LayoutInflater.from(this.f).inflate(2130903217, null);
        e locale = new e();
        locale.a = ((LinearLayout)paramView.findViewById(2131297368));
        locale.b = ((TextView)paramView.findViewById(2131297369));
        locale.c = ((TextView)paramView.findViewById(2131297370));
        locale.d = ((TextView)paramView.findViewById(2131297371));
        locale.e = ((Button)paramView.findViewById(2131297372));
        locale.f = ((Button)paramView.findViewById(2131297373));
        paramView.setTag(locale);
        localObject1 = locale;
        locald = null;
        localObject2 = null;
        localObject3 = null;
        continue;
        switch (i1)
        {
        default:
          localObject1 = null;
          locald = null;
          localObject2 = null;
          localObject3 = null;
          break;
        case 0:
          localObject3 = (b)paramView.getTag();
          localObject1 = null;
          locald = null;
          localObject2 = null;
          break;
        case 1:
          localObject2 = (c)paramView.getTag();
          localObject1 = null;
          locald = null;
          localObject3 = null;
          break;
        case 2:
          locald = (d)paramView.getTag();
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
          break;
        case 3:
          localObject1 = (e)paramView.getTag();
          locald = null;
          localObject2 = null;
          localObject3 = null;
        }
      case 0:
      case 1:
      case 2:
      case 3:
      }
    VideoChapter localVideoChapter = (VideoChapter)((VideoTapeLevel)this.j.get(paramInt)).getData();
    if (this.g.getBuy_status() == 0)
      if (((VideoTapeLevel)this.j.get(paramInt)).getPreview() == 0)
      {
        ((b)localObject3).b.setTextColor(Color.parseColor("#cccccc"));
        ((b)localObject3).b.setText(localVideoChapter.getChapter_name());
        if (((VideoTapeLevel)this.j.get(paramInt)).getCover() != 1)
          break label866;
        LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(16, 30);
        ((b)localObject3).c.setLayoutParams(localLayoutParams3);
        ((b)localObject3).c.setBackgroundResource(2130837901);
      }
    while (true)
    {
      ((b)localObject3).a.setTag(Integer.valueOf(paramInt));
      ((b)localObject3).a.setOnClickListener(this.n);
      return paramView;
      ((b)localObject3).b.setTextColor(Color.parseColor("#333333"));
      break;
      ((b)localObject3).b.setTextColor(Color.parseColor("#333333"));
      break;
      label866: LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(30, 16);
      ((b)localObject3).c.setLayoutParams(localLayoutParams4);
      ((b)localObject3).c.setBackgroundResource(2130837902);
    }
    VideoSection localVideoSection = (VideoSection)((VideoTapeLevel)this.j.get(paramInt)).getData();
    if (this.g.getBuy_status() == 0)
      if (((VideoTapeLevel)this.j.get(paramInt)).getPreview() == 0)
      {
        ((c)localObject2).b.setTextColor(Color.parseColor("#cccccc"));
        ((c)localObject2).b.setText(localVideoSection.getSection_name());
        if (((VideoTapeLevel)this.j.get(paramInt)).getCover() != 1)
          break label1094;
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(16, 30);
        ((c)localObject2).c.setLayoutParams(localLayoutParams1);
        ((c)localObject2).c.setBackgroundResource(2130837901);
      }
    while (true)
    {
      ((c)localObject2).a.setTag(Integer.valueOf(paramInt));
      ((c)localObject2).a.setOnClickListener(this.n);
      return paramView;
      ((c)localObject2).b.setTextColor(Color.parseColor("#333333"));
      break;
      ((c)localObject2).b.setTextColor(Color.parseColor("#333333"));
      break;
      label1094: LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(30, 16);
      ((c)localObject2).c.setLayoutParams(localLayoutParams2);
      ((c)localObject2).c.setBackgroundResource(2130837902);
    }
    Video localVideo2 = (Video)((VideoTapeLevel)this.j.get(paramInt)).getData();
    locald.b.setText(localVideo2.getVideo_name());
    locald.a.setTag(localVideo2);
    locald.a.setOnClickListener(this.n);
    if (this.g.getBuy_status() == 0)
    {
      locald.f.setVisibility(8);
      locald.e.setVisibility(8);
      if (localVideo2.getIs_trail() == 1)
      {
        locald.c.setText(p.a(localVideo2.getDuration()));
        if (localVideo2.getVideo_id().equals(this.m))
        {
          locald.b.setTextColor(Color.parseColor("#00b8e6"));
          locald.c.setTextColor(Color.parseColor("#00b8e6"));
        }
        while (true)
        {
          locald.d.setVisibility(0);
          locald.d.setTag(((VideoTapeLevel)this.j.get(paramInt)).getData());
          locald.d.setOnClickListener(this.n);
          return paramView;
          locald.b.setTextColor(Color.parseColor("#333333"));
          locald.c.setTextColor(Color.parseColor("#333333"));
        }
      }
      locald.b.setTextColor(Color.parseColor("#cccccc"));
      locald.c.setTextColor(Color.parseColor("#cccccc"));
      locald.d.setVisibility(8);
      return paramView;
    }
    locald.d.setVisibility(8);
    if (localVideo2.getVideo_id().equals(this.m))
    {
      locald.b.setTextColor(Color.parseColor("#00b8e6"));
      locald.c.setTextColor(Color.parseColor("#00b8e6"));
    }
    while (true)
    {
      a(localVideo2, locald.f, locald.e, locald.c);
      locald.f.setTag(localVideo2);
      locald.f.setOnClickListener(this.n);
      locald.e.setTag(localVideo2);
      locald.e.setOnClickListener(this.n);
      return paramView;
      locald.b.setTextColor(Color.parseColor("#333333"));
      locald.c.setTextColor(Color.parseColor("#333333"));
    }
    Video localVideo1 = (Video)((VideoTapeLevel)this.j.get(paramInt)).getData();
    ((e)localObject1).b.setText(localVideo1.getVideo_name());
    ((e)localObject1).a.setTag(localVideo1);
    ((e)localObject1).a.setOnClickListener(this.n);
    if (this.g.getBuy_status() == 0)
    {
      ((e)localObject1).f.setVisibility(8);
      ((e)localObject1).e.setVisibility(8);
      if (localVideo1.getIs_trail() == 1)
      {
        ((e)localObject1).c.setText(p.a(localVideo1.getDuration()));
        if (localVideo1.getVideo_id().equals(this.m))
        {
          ((e)localObject1).b.setTextColor(Color.parseColor("#00b8e6"));
          ((e)localObject1).c.setTextColor(Color.parseColor("#00b8e6"));
        }
        while (true)
        {
          ((e)localObject1).d.setVisibility(0);
          ((e)localObject1).d.setTag(((VideoTapeLevel)this.j.get(paramInt)).getData());
          ((e)localObject1).d.setOnClickListener(this.n);
          return paramView;
          ((e)localObject1).b.setTextColor(Color.parseColor("#333333"));
          ((e)localObject1).c.setTextColor(Color.parseColor("#333333"));
        }
      }
      ((e)localObject1).b.setTextColor(Color.parseColor("#cccccc"));
      ((e)localObject1).c.setTextColor(Color.parseColor("#cccccc"));
      ((e)localObject1).d.setVisibility(8);
      return paramView;
    }
    ((e)localObject1).d.setVisibility(8);
    if (localVideo1.getVideo_id().equals(this.m))
    {
      ((e)localObject1).b.setTextColor(Color.parseColor("#00b8e6"));
      ((e)localObject1).c.setTextColor(Color.parseColor("#00b8e6"));
    }
    while (true)
    {
      a(localVideo1, ((e)localObject1).f, ((e)localObject1).e, ((e)localObject1).c);
      ((e)localObject1).f.setTag(localVideo1);
      ((e)localObject1).f.setOnClickListener(this.n);
      ((e)localObject1).e.setTag(localVideo1);
      ((e)localObject1).e.setOnClickListener(this.n);
      return paramView;
      ((e)localObject1).b.setTextColor(Color.parseColor("#333333"));
      ((e)localObject1).c.setTextColor(Color.parseColor("#333333"));
    }
  }

  public int getViewTypeCount()
  {
    return 4;
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      int i = 0;
      switch (paramView.getId())
      {
      case 2131297357:
      case 2131297358:
      case 2131297360:
      case 2131297361:
      case 2131297363:
      case 2131297364:
      case 2131297369:
      case 2131297370:
      default:
      case 2131297356:
      case 2131297359:
      case 2131297365:
      case 2131297371:
      case 2131297362:
      case 2131297368:
        do
        {
          while (true)
          {
            return;
            Object localObject3 = ((VideoTapeLevel)am.a(am.this).get(((Integer)paramView.getTag()).intValue())).getData();
            if (!(localObject3 instanceof VideoChapter))
              continue;
            VideoChapter localVideoChapter1 = (VideoChapter)localObject3;
            if (i >= am.b(am.this).size())
            {
              am.a(am.this).clear();
              am.a(am.this).addAll(p.b(am.b(am.this)));
              am.this.notifyDataSetChanged();
              return;
            }
            Object localObject4 = ((VideoTapeLevel)am.b(am.this).get(i)).getData();
            if ((localObject4 instanceof VideoChapter))
            {
              VideoChapter localVideoChapter2 = (VideoChapter)localObject4;
              if (localVideoChapter1.getChapter_name().equals(localVideoChapter2.getChapter_name()))
              {
                if (((VideoTapeLevel)am.b(am.this).get(i)).getCover() != 1)
                  break label298;
                ((VideoTapeLevel)am.b(am.this).get(i)).setCover(2);
              }
            }
            while (true)
            {
              i++;
              break;
              ((VideoTapeLevel)am.b(am.this).get(i)).setCover(1);
            }
            Object localObject1 = ((VideoTapeLevel)am.a(am.this).get(((Integer)paramView.getTag()).intValue())).getData();
            if (!(localObject1 instanceof VideoSection))
              continue;
            VideoSection localVideoSection1 = (VideoSection)localObject1;
            if (i >= am.b(am.this).size())
            {
              am.a(am.this).clear();
              am.a(am.this).addAll(p.b(am.b(am.this)));
              am.this.notifyDataSetChanged();
              return;
            }
            Object localObject2 = ((VideoTapeLevel)am.b(am.this).get(i)).getData();
            if ((localObject2 instanceof VideoSection))
            {
              VideoSection localVideoSection2 = (VideoSection)localObject2;
              if (localVideoSection1.getSection_name().equals(localVideoSection2.getSection_name()))
              {
                if (((VideoTapeLevel)am.b(am.this).get(i)).getCover() != 1)
                  break label526;
                ((VideoTapeLevel)am.b(am.this).get(i)).setCover(2);
              }
            }
            while (true)
            {
              i++;
              break;
              ((VideoTapeLevel)am.b(am.this).get(i)).setCover(1);
            }
            if (VideoTapePlayActivity.a == null)
              continue;
            VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(3, (Video)paramView.getTag()));
            am.this.b(((Video)paramView.getTag()).getVideo_id());
            return;
            if (am.c(am.this).getBuy_status() == 0)
            {
              if (((Video)paramView.getTag()).getIs_trail() == 1)
              {
                if (VideoTapePlayActivity.a == null)
                  continue;
                VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(3, (Video)paramView.getTag()));
                am.this.b(((Video)paramView.getTag()).getVideo_id());
                return;
              }
              Toast.makeText(am.d(am.this), "这个视频不提供试看哦", 0).show();
              return;
            }
            if (VideoTapePlayActivity.a == null)
              continue;
            VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(3, (Video)paramView.getTag()));
            am.this.b(((Video)paramView.getTag()).getVideo_id());
            return;
            if (am.c(am.this).getBuy_status() != 0)
              break label817;
            if (((Video)paramView.getTag()).getIs_trail() != 1)
              break;
            if (VideoTapePlayActivity.a == null)
              continue;
            VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(3, (Video)paramView.getTag()));
            am.this.b(((Video)paramView.getTag()).getVideo_id());
            return;
          }
          Toast.makeText(am.d(am.this), "这个视频不提供试看哦", 0).show();
          return;
        }
        while (VideoTapePlayActivity.a == null);
        VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(3, (Video)paramView.getTag()));
        am.this.b(((Video)paramView.getTag()).getVideo_id());
        return;
      case 2131297367:
      case 2131297373:
        label298: label817: Video localVideo = (Video)paramView.getTag();
        label526: if (am.a(am.this, localVideo))
        {
          if (am.b(am.this, localVideo).getIsPause() == 0)
          {
            am.a(am.this, localVideo, 1);
            paramView.setBackgroundResource(2130837768);
            am.e(am.this).sendMessage(am.e(am.this).obtainMessage(6, 1, 0, localVideo));
            return;
          }
          am.a(am.this, localVideo, 0);
          paramView.setBackgroundResource(2130837769);
          am.e(am.this).sendMessage(am.e(am.this).obtainMessage(6, 0, 0, localVideo));
          return;
        }
        for (int j = 0; ; j++)
        {
          if (j >= am.f(am.this).size())
          {
            if ((com.withustudy.koudaizikao.g.k.c(am.d(am.this))) || (am.this.a))
              break;
            am.e(am.this).sendEmptyMessage(9);
            return;
          }
          VideoDownLoadStatus localVideoDownLoadStatus = (VideoDownLoadStatus)am.f(am.this).get(j);
          if (!localVideo.getVideo_id().equals(localVideoDownLoadStatus.getVideoId()))
            continue;
          if (localVideoDownLoadStatus.getStatus() == 100)
          {
            h.a("队列中等待->暂停", localVideo.getVideo_id());
            am.e(am.this).sendMessage(am.e(am.this).obtainMessage(5, localVideo.getVideo_id()));
            paramView.setBackgroundResource(2130837768);
            return;
          }
          if (localVideoDownLoadStatus.getStatus() == 200)
          {
            h.a("正在下载->暂停", localVideo.getVideo_id());
            am.e(am.this).sendMessage(am.e(am.this).obtainMessage(5, localVideo.getVideo_id()));
            paramView.setBackgroundResource(2130837768);
            return;
          }
          if (localVideoDownLoadStatus.getStatus() != 300)
            continue;
          h.a("暂停下载->开始下载", localVideo.getVideo_id());
          am.e(am.this).sendMessage(am.e(am.this).obtainMessage(3, localVideo.getVideo_id()));
          p.a(localVideoDownLoadStatus.getProgress(), (Button)paramView);
          return;
        }
        am.this.a = false;
        am.e(am.this).sendMessage(am.e(am.this).obtainMessage(4, localVideo));
        paramView.setBackgroundResource(2130837769);
        return;
      case 2131297366:
      case 2131297372:
      }
      VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(7, paramView.getTag()));
    }
  }

  class b
  {
    public LinearLayout a;
    public TextView b;
    public Button c;

    b()
    {
    }
  }

  class c
  {
    public LinearLayout a;
    public TextView b;
    public Button c;

    c()
    {
    }
  }

  class d
  {
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public Button e;
    public Button f;

    d()
    {
    }
  }

  class e
  {
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public Button e;
    public Button f;

    e()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.am
 * JD-Core Version:    0.6.0
 */