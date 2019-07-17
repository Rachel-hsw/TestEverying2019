package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gensee.download.VodDownLoadEntity;
import com.gensee.download.VodDownLoadStatus;
import com.withustudy.koudaizikao.activity.VideoBoughtDetailActivity.c;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.k;
import com.withustudy.koudaizikao.g.p;
import java.util.List;

public class s extends BaseAdapter
{
  public boolean a = false;
  private List<Video> b;
  private Context c;
  private VideoBoughtDetailActivity.c d;
  private List<VodDownLoadEntity> e;
  private a f;

  public s(List<Video> paramList, List<VodDownLoadEntity> paramList1, VideoBoughtDetailActivity.c paramc, Context paramContext)
  {
    this.b = paramList;
    this.e = paramList1;
    this.d = paramc;
    this.c = paramContext;
    this.f = new a();
  }

  private void a(String paramString, Button paramButton1, Button paramButton2)
  {
    paramButton2.setVisibility(8);
    paramButton1.setVisibility(0);
    paramButton1.setText("");
    paramButton1.setBackgroundResource(2130837703);
    int i = 0;
    if (i >= this.e.size())
      return;
    VodDownLoadEntity localVodDownLoadEntity = (VodDownLoadEntity)this.e.get(i);
    if (paramString.equals(localVodDownLoadEntity.getDownLoadId()))
    {
      if (localVodDownLoadEntity.getnStatus() != VodDownLoadStatus.WAIT.getStatus())
        break label101;
      paramButton1.setBackgroundResource(2130837769);
      h.a("wait", paramString);
    }
    while (true)
    {
      i++;
      break;
      label101: if (localVodDownLoadEntity.getnStatus() == VodDownLoadStatus.BEGIN.getStatus())
      {
        paramButton1.setBackgroundResource(2130837769);
        h.a("begin", paramString);
        continue;
      }
      if (localVodDownLoadEntity.getnStatus() == VodDownLoadStatus.FAILED.getStatus())
      {
        paramButton1.setBackgroundResource(2130837703);
        h.a("failed", paramString);
        continue;
      }
      if (localVodDownLoadEntity.getnStatus() == VodDownLoadStatus.FINISH.getStatus())
      {
        h.a("finish", paramString);
        paramButton1.setVisibility(8);
        paramButton2.setVisibility(0);
        continue;
      }
      if (localVodDownLoadEntity.getnStatus() == VodDownLoadStatus.LICENSE.getStatus())
      {
        h.a("license", paramString);
        paramButton1.setBackgroundResource(2130837768);
        continue;
      }
      if (localVodDownLoadEntity.getnStatus() == VodDownLoadStatus.START.getStatus())
      {
        h.a("start", paramString);
        p.a(localVodDownLoadEntity.getnPercent(), paramButton1);
        continue;
      }
      if (localVodDownLoadEntity.getnStatus() == VodDownLoadStatus.STOP.getStatus())
      {
        h.a("stop", paramString);
        paramButton1.setBackgroundResource(2130837768);
        continue;
      }
      h.a("else", paramString);
      paramButton1.setBackgroundResource(2130837769);
    }
  }

  public void a(List<VodDownLoadEntity> paramList)
  {
    this.e = paramList;
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
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
    b localb;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2130903206, null);
      localb = new b();
      localb.a = ((LinearLayout)paramView.findViewById(2131297311));
      localb.b = ((TextView)paramView.findViewById(2131297312));
      localb.c = ((TextView)paramView.findViewById(2131297313));
      localb.d = ((Button)paramView.findViewById(2131297314));
      localb.e = ((Button)paramView.findViewById(2131297315));
      paramView.setTag(localb);
    }
    while (true)
    {
      localb.c.setText(((Video)this.b.get(paramInt)).getVideo_name());
      localb.b.setText(((Video)this.b.get(paramInt)).getLive_time());
      localb.a.setTag(Integer.valueOf(paramInt));
      localb.a.setOnClickListener(this.f);
      if (!((Video)this.b.get(paramInt)).getPlay_status().equals("转录中"))
        break;
      localb.d.setText("转录中");
      localb.d.setBackgroundResource(2131034189);
      return paramView;
      localb = (b)paramView.getTag();
    }
    a(((Video)this.b.get(paramInt)).getVideo_id(), localb.d, localb.e);
    localb.d.setTag(((Video)this.b.get(paramInt)).getVideo_id());
    localb.d.setOnClickListener(this.f);
    localb.e.setTag(this.b.get(paramInt));
    localb.e.setOnClickListener(this.f);
    return paramView;
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131297312:
      case 2131297313:
      default:
        return;
      case 2131297311:
        Video localVideo = (Video)s.a(s.this).get(((Integer)paramView.getTag()).intValue());
        if (localVideo.getPlay_status().equals("转录中"))
        {
          Toast.makeText(s.b(s.this), "这个视频还在转录中哦", 0).show();
          return;
        }
        s.c(s.this).sendMessage(s.c(s.this).obtainMessage(8, localVideo));
        return;
      case 2131297314:
        String str = (String)paramView.getTag();
        label548: for (int i = 0; ; i++)
        {
          if (i >= s.d(s.this).size());
          while (i == s.d(s.this).size())
          {
            if ((k.c(s.b(s.this))) || (s.this.a))
              break label554;
            s.c(s.this).sendMessage(s.c(s.this).obtainMessage(5));
            return;
            VodDownLoadEntity localVodDownLoadEntity1 = (VodDownLoadEntity)s.d(s.this).get(i);
            if (!str.equals(localVodDownLoadEntity1.getDownLoadId()))
              break label548;
            if (localVodDownLoadEntity1.getnStatus() == VodDownLoadStatus.WAIT.getStatus())
            {
              h.a("队列中等待->暂停", str);
              s.c(s.this).sendMessage(s.c(s.this).obtainMessage(6, str));
              paramView.setBackgroundResource(2130837768);
              continue;
            }
            if (localVodDownLoadEntity1.getnStatus() == VodDownLoadStatus.BEGIN.getStatus())
            {
              h.a("添加到队列->暂停", str);
              s.c(s.this).sendMessage(s.c(s.this).obtainMessage(6, str));
              paramView.setBackgroundResource(2130837768);
              continue;
            }
            if (localVodDownLoadEntity1.getnStatus() == VodDownLoadStatus.FAILED.getStatus())
            {
              h.a("下载失败->重新下载", str);
              s.c(s.this).sendMessage(s.c(s.this).obtainMessage(4, str));
              paramView.setBackgroundResource(2130837769);
              continue;
            }
            if (localVodDownLoadEntity1.getnStatus() == VodDownLoadStatus.START.getStatus())
            {
              h.a("下载中->暂停", str);
              s.c(s.this).sendMessage(s.c(s.this).obtainMessage(6, str));
              paramView.setBackgroundResource(2130837768);
              continue;
            }
            if (localVodDownLoadEntity1.getnStatus() == VodDownLoadStatus.STOP.getStatus())
            {
              h.a("暂停/停止下载->开始下载", str);
              s.c(s.this).sendMessage(s.c(s.this).obtainMessage(4, str));
              p.a(localVodDownLoadEntity1.getnPercent(), (Button)paramView);
              continue;
            }
            if (localVodDownLoadEntity1.getnStatus() != VodDownLoadStatus.LICENSE.getStatus())
              continue;
            Toast.makeText(s.b(s.this), "下载人数已满", 0).show();
          }
        }
        label554: h.a("未下载->开始下载", str);
        for (int j = 0; ; j++)
        {
          Object localObject;
          if (j >= s.a(s.this).size())
            localObject = null;
          while (true)
          {
            s.c(s.this).sendMessage(s.c(s.this).obtainMessage(3, localObject));
            Toast.makeText(s.b(s.this), "开始下载", 0).show();
            paramView.setBackgroundResource(2130837769);
            return;
            if (!((Video)s.a(s.this).get(j)).getVideo_id().equals(str))
              break;
            localObject = (Video)s.a(s.this).get(j);
            VodDownLoadEntity localVodDownLoadEntity2 = new VodDownLoadEntity();
            localVodDownLoadEntity2.setDownLoadId(((Video)localObject).getVideo_id());
            localVodDownLoadEntity2.setnStatus(VodDownLoadStatus.WAIT.getStatus());
            s.d(s.this).add(localVodDownLoadEntity2);
          }
        }
      case 2131297315:
      }
      s.c(s.this).sendMessage(s.c(s.this).obtainMessage(9, paramView.getTag()));
    }
  }

  class b
  {
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public Button d;
    public Button e;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.s
 * JD-Core Version:    0.6.0
 */