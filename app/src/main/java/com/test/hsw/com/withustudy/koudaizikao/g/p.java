package com.withustudy.koudaizikao.g;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.withustudy.koudaizikao.entity.Video;
import com.withustudy.koudaizikao.entity.VideoChapter;
import com.withustudy.koudaizikao.entity.VideoSection;
import com.withustudy.koudaizikao.entity.local.VideoTapeLevel;
import java.util.ArrayList;
import java.util.List;

public class p
{
  public static RelativeLayout.LayoutParams a(boolean paramBoolean, double paramDouble, int paramInt1, int paramInt2, int paramInt3)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
      if (paramDouble > 1.777777777777778D)
        localLayoutParams = new RelativeLayout.LayoutParams(paramInt2, (int)(paramInt2 / paramDouble));
    while (true)
    {
      localLayoutParams.addRule(13);
      return localLayoutParams;
      if (paramDouble == 1.777777777777778D)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(paramInt2, paramInt1);
        continue;
      }
      localLayoutParams = new RelativeLayout.LayoutParams((int)(paramDouble * paramInt1), paramInt1);
      continue;
      if (paramDouble > paramInt3 / paramInt2)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, (int)(paramInt3 / paramDouble));
        continue;
      }
      if (paramDouble == paramInt3 / paramInt2)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt2);
        continue;
      }
      localLayoutParams = new RelativeLayout.LayoutParams((int)(paramDouble * paramInt2), paramInt2);
    }
  }

  public static Video a(List<VideoTapeLevel> paramList, String paramString)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return null;
      Object localObject = ((VideoTapeLevel)paramList.get(i)).getData();
      if (((localObject instanceof Video)) && (((Video)localObject).getVideo_id().equals(paramString)))
        return (Video)localObject;
    }
  }

  public static String a(int paramInt)
  {
    int i = paramInt / 60;
    String str1;
    int j;
    if (i < 10)
    {
      str1 = "0" + i;
      j = paramInt - i * 60;
      if (j >= 10)
        break label97;
    }
    label97: for (String str2 = "0" + j; ; str2 = String.valueOf(j))
    {
      return str1 + "'" + str2 + "\"";
      str1 = String.valueOf(i);
      break;
    }
  }

  public static String a(long paramLong)
  {
    int i = (int)(1.0D * paramLong / 1000.0D);
    int j = (int)(1.0D * i / 60.0D);
    int k = i - j * 60;
    try
    {
      String str1 = b.d(j);
      String str2 = b.d(k);
      String str3 = str1 + ":" + str2;
      return str3;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static List<VideoTapeLevel> a(List<VideoChapter> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int n;
    while (true)
      if (i >= paramList.size())
      {
        n = 0;
        if (n < localArrayList.size())
          break;
        return localArrayList;
      }
      else
      {
        VideoChapter localVideoChapter = (VideoChapter)paramList.get(i);
        VideoTapeLevel localVideoTapeLevel1 = new VideoTapeLevel();
        localVideoTapeLevel1.setData(localVideoChapter);
        localVideoTapeLevel1.setCover(2);
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = String.valueOf(i + 1);
        localVideoTapeLevel1.setLevel(arrayOfString1);
        localArrayList.add(localVideoTapeLevel1);
        int j = 0;
        if (j >= localVideoChapter.getSection_list().size())
        {
          i++;
          continue;
        }
        VideoSection localVideoSection = (VideoSection)localVideoChapter.getSection_list().get(j);
        int k;
        if (!localVideoSection.getSection_name().equals(""))
        {
          VideoTapeLevel localVideoTapeLevel2 = new VideoTapeLevel();
          localVideoTapeLevel2.setData(localVideoSection);
          localVideoTapeLevel2.setCover(2);
          String[] arrayOfString2 = new String[2];
          arrayOfString2[0] = String.valueOf(i + 1);
          arrayOfString2[1] = String.valueOf(j + 1);
          localVideoTapeLevel2.setLevel(arrayOfString2);
          localArrayList.add(localVideoTapeLevel2);
          k = 0;
          label220: if (k < localVideoSection.getVideo_list().size());
        }
        while (true)
        {
          j++;
          break;
          Video localVideo1 = (Video)localVideoSection.getVideo_list().get(k);
          VideoTapeLevel localVideoTapeLevel3 = new VideoTapeLevel();
          localVideoTapeLevel3.setData(localVideo1);
          localVideoTapeLevel3.setCover(0);
          String[] arrayOfString3 = new String[3];
          arrayOfString3[0] = String.valueOf(i + 1);
          arrayOfString3[1] = String.valueOf(j + 1);
          arrayOfString3[2] = String.valueOf(k + 1);
          localVideoTapeLevel3.setLevel(arrayOfString3);
          localArrayList.add(localVideoTapeLevel3);
          k++;
          break label220;
          for (int m = 0; m < localVideoSection.getVideo_list().size(); m++)
          {
            Video localVideo2 = (Video)localVideoSection.getVideo_list().get(m);
            VideoTapeLevel localVideoTapeLevel4 = new VideoTapeLevel();
            localVideoTapeLevel4.setData(localVideo2);
            localVideoTapeLevel4.setCover(0);
            String[] arrayOfString4 = new String[2];
            arrayOfString4[0] = String.valueOf(i + 1);
            arrayOfString4[1] = String.valueOf(j + 1);
            localVideoTapeLevel4.setLevel(arrayOfString4);
            localArrayList.add(localVideoTapeLevel4);
          }
        }
      }
    ((VideoTapeLevel)localArrayList.get(n)).setPreview(0);
    int i2;
    if ((((VideoTapeLevel)localArrayList.get(n)).getData() instanceof VideoChapter))
    {
      i2 = n + 1;
      label487: if (i2 < localArrayList.size());
    }
    label735: 
    while (true)
    {
      n++;
      break;
      if ((((VideoTapeLevel)localArrayList.get(i2)).getData() instanceof VideoChapter))
        continue;
      if (((((VideoTapeLevel)localArrayList.get(i2)).getData() instanceof Video)) && (((Video)((VideoTapeLevel)localArrayList.get(i2)).getData()).getIs_trail() == 1))
      {
        ((VideoTapeLevel)localArrayList.get(n)).setPreview(1);
        continue;
      }
      i2++;
      break label487;
      if (!(((VideoTapeLevel)localArrayList.get(n)).getData() instanceof VideoSection))
        continue;
      for (int i1 = n + 1; ; i1++)
      {
        if ((i1 >= localArrayList.size()) || ((((VideoTapeLevel)localArrayList.get(i1)).getData() instanceof VideoChapter)) || ((((VideoTapeLevel)localArrayList.get(i1)).getData() instanceof VideoSection)))
          break label735;
        if ((!(((VideoTapeLevel)localArrayList.get(i1)).getData() instanceof Video)) || (((Video)((VideoTapeLevel)localArrayList.get(i1)).getData()).getIs_trail() != 1))
          continue;
        ((VideoTapeLevel)localArrayList.get(n)).setPreview(1);
        break;
      }
    }
  }

  public static void a(int paramInt, Button paramButton)
  {
    if (paramInt < 10)
    {
      paramButton.setBackgroundResource(2130837769);
      return;
    }
    if ((paramInt >= 10) && (paramInt < 30))
    {
      paramButton.setBackgroundResource(2130837770);
      return;
    }
    if ((paramInt >= 30) && (paramInt < 40))
    {
      paramButton.setBackgroundResource(2130837771);
      return;
    }
    if ((paramInt >= 40) && (paramInt < 50))
    {
      paramButton.setBackgroundResource(2130837772);
      return;
    }
    if ((paramInt >= 50) && (paramInt < 60))
    {
      paramButton.setBackgroundResource(2130837773);
      return;
    }
    if ((paramInt >= 60) && (paramInt < 70))
    {
      paramButton.setBackgroundResource(2130837774);
      return;
    }
    if ((paramInt >= 70) && (paramInt < 80))
    {
      paramButton.setBackgroundResource(2130837775);
      return;
    }
    paramButton.setBackgroundResource(2130837776);
  }

  public static boolean a(Video paramVideo, List<Video> paramList)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return false;
      if (paramVideo.getVideo_id().equals(((Video)paramList.get(i)).getVideo_id()))
        return true;
    }
  }

  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case -201:
      return "没有调用getVodObject";
    case 14:
      return "点播初始化失败";
    case 15:
      return "点播编号不存在或点播不存在";
    case 16:
      return "点播密码错误";
    case 17:
      return "帐号或密码错误";
    case 18:
      return "不支持移动设备";
    case -100:
      return "域名不正确";
    case -101:
      return "超时";
    case -102:
      return "站点不可用";
    case -103:
      return "未知错误";
    case -104:
      return "请检查网络后重试";
    case -105:
      return "数据已过期";
    case -106:
      return "服务不正确";
    case -107:
      return "参数不正确";
    case -108:
    }
    return "第三方用户权限校验";
  }

  public static List<VideoTapeLevel> b(List<VideoTapeLevel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (true)
    {
      if (i >= paramList.size())
        return localArrayList;
      localArrayList.add((VideoTapeLevel)paramList.get(i));
      if ((((VideoTapeLevel)paramList.get(i)).getData() instanceof VideoChapter))
      {
        if (((VideoTapeLevel)paramList.get(i)).getCover() == 1)
          for (int k = i + 1; ; k++)
          {
            if (k >= paramList.size());
            do
            {
              i = k;
              break;
            }
            while (!((VideoTapeLevel)paramList.get(k)).getLevel()[0].equals(((VideoTapeLevel)paramList.get(i)).getLevel()[0]));
          }
        i++;
        continue;
      }
      if ((((VideoTapeLevel)paramList.get(i)).getData() instanceof VideoSection))
      {
        if (((VideoTapeLevel)paramList.get(i)).getCover() == 1)
          for (int j = i + 1; ; j++)
          {
            if (j >= paramList.size());
            do
            {
              i = j;
              break;
            }
            while (((((VideoTapeLevel)paramList.get(j)).getData() instanceof VideoChapter)) || (!((VideoTapeLevel)paramList.get(j)).getLevel()[1].equals(((VideoTapeLevel)paramList.get(i)).getLevel()[1])));
          }
        i++;
        continue;
      }
      i++;
    }
  }

  public static Video c(List<VideoTapeLevel> paramList)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramList.size())
        return null;
      Object localObject = ((VideoTapeLevel)paramList.get(i)).getData();
      if ((localObject instanceof Video))
        return (Video)localObject;
    }
  }

  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 12:
      return "播放人数已满";
    case 1:
      return "播放失败";
    case 2:
      h.a("暂停失败");
      return null;
    case 3:
      return "恢复失败";
    case 4:
      return "停止失败";
    case 5:
      return "设置进度失败";
    case -201:
      return "没有调用getVodObject";
    case 6:
      return "路径或点播id错误";
    case 7:
    }
    return "初始化错误";
  }

  public static String d(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return "该视频已经在下载队列中";
    case 2:
      return "排队中";
    case 3:
      return "SD卡异常";
    case 4:
      return "目标不存在";
    case 5:
      return "对象为空";
    case 6:
      return "下载地址为空";
    case 7:
      return "下载失败";
    case -201:
      return "没有调用getVodObject";
    case 12:
      return "服务器负荷过高，请稍后再试";
    case 8:
      return "下载参数初始化错误";
    case 9:
    }
    return "SD卡或文件夹不存在";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.p
 * JD-Core Version:    0.6.0
 */