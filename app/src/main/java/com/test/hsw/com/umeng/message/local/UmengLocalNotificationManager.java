package com.umeng.message.local;

import android.content.Context;
import android.content.Intent;
import com.umeng.b.a.a;
import java.util.Iterator;
import java.util.List;

public class UmengLocalNotificationManager
{
  public static final String ADD_LOCAL_NOTIFICATION = "add_local_notification";
  public static final String CLEAR_LOCAL_NOTIFICATION = "clear_local_notification";
  public static final String DELETE_LOCAL_NOTIFICATION = "delete_local_notification";
  public static final String DISPLAY_LOCAL_NOTIFICATION = "display_local_notification";
  public static final String LOCAL_NOTIFICATION_ID = "local_notification_id";
  public static final String LOCAL_NOTIFICATION_TYPE = "local_notification_type";
  public static final String UPDATE_LOCAL_NOTIFICATION = "update_local_notification";
  private static final String a = UmengLocalNotificationManager.class.getName();
  private static UmengLocalNotificationManager b;
  private Context c;

  private UmengLocalNotificationManager(Context paramContext)
  {
    this.c = paramContext;
  }

  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.c, UmengLocalNotificationService.class);
    localIntent.putExtra("local_notification_id", paramString1);
    localIntent.putExtra("local_notification_type", paramString2);
    this.c.startService(localIntent);
  }

  public static UmengLocalNotificationManager getInstance(Context paramContext)
  {
    monitorenter;
    try
    {
      if (b == null)
        b = new UmengLocalNotificationManager(paramContext);
      UmengLocalNotificationManager localUmengLocalNotificationManager = b;
      return localUmengLocalNotificationManager;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean addLocalNotification(UmengLocalNotification paramUmengLocalNotification)
  {
    int i = 0;
    monitorenter;
    if (paramUmengLocalNotification == null);
    while (true)
    {
      try
      {
        a.c(a, "localNotification is null");
        return i;
        if (!paramUmengLocalNotification.validateDateTime())
        {
          a.c(a, "Please reset date time for localNotification");
          i = 0;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (!paramUmengLocalNotification.validateData(this.c))
      {
        a.c(a, "Please reset relavent data for localNotification");
        i = 0;
        continue;
      }
      try
      {
        if (findLocalNotification(paramUmengLocalNotification.getId()) == null)
          break label116;
        a.c(a, "add local notification has exists");
        i = 0;
      }
      catch (Exception localException)
      {
        a.c(a, localException.toString());
        localException.printStackTrace();
        i = 0;
      }
      continue;
      label116: UmengLocalNotificationStore.getInstance(this.c).addLocalNotification(paramUmengLocalNotification);
      a(paramUmengLocalNotification.getId(), "add_local_notification");
      i = 1;
    }
  }

  public boolean deleteAllLocalNotifications()
  {
    monitorenter;
    while (true)
    {
      Iterator localIterator;
      try
      {
        List localList = findAllLocalNotifications();
        if ((localList != null) && (localList.size() != 0))
          continue;
        a.c(a, "list is empty");
        return false;
        UmengLocalNotificationStore.getInstance(this.c).deleteAllLocalNotifications();
        localIterator = localList.iterator();
        localObject2 = "";
        if (!localIterator.hasNext())
        {
          a(((String)localObject2).substring(0, -1 + ((String)localObject2).length()), "clear_local_notification");
          continue;
        }
      }
      catch (Exception localException)
      {
        a.c(a, localException.toString());
        localException.printStackTrace();
        continue;
      }
      finally
      {
        monitorexit;
      }
      UmengLocalNotification localUmengLocalNotification = (UmengLocalNotification)localIterator.next();
      String str = localObject2 + localUmengLocalNotification.getId() + ";";
      Object localObject2 = str;
    }
  }

  public boolean deleteLocalNotification(String paramString)
  {
    int i = 0;
    monitorenter;
    try
    {
      UmengLocalNotification localUmengLocalNotification = findLocalNotification(paramString);
      if (localUmengLocalNotification == null)
        a.c(a, "localNotification is null");
      while (true)
      {
        return i;
        UmengLocalNotificationStore.getInstance(this.c).deleteLocalNotification(paramString);
        a(localUmengLocalNotification.getId(), "delete_local_notification");
        i = 1;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.c(a, localException.toString());
        localException.printStackTrace();
        i = 0;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public List<UmengLocalNotification> findAllLocalNotifications()
  {
    monitorenter;
    try
    {
      List localList2 = UmengLocalNotificationStore.getInstance(this.c).findAllLocalNotifications();
      localList1 = localList2;
      return localList1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.c(a, localException.toString());
        localException.printStackTrace();
        List localList1 = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public UmengLocalNotification findLocalNotification(String paramString)
  {
    monitorenter;
    try
    {
      UmengLocalNotification localUmengLocalNotification2 = UmengLocalNotificationStore.getInstance(this.c).findLocalNotification(paramString);
      localUmengLocalNotification1 = localUmengLocalNotification2;
      return localUmengLocalNotification1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.c(a, localException.toString());
        localException.printStackTrace();
        UmengLocalNotification localUmengLocalNotification1 = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public List<UmengLocalNotification> findLocalNotifications(String paramString)
  {
    monitorenter;
    try
    {
      List localList2 = UmengLocalNotificationStore.getInstance(this.c).findLocalNotifications(paramString);
      localList1 = localList2;
      return localList1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.c(a, localException.toString());
        localException.printStackTrace();
        List localList1 = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void resetLocalNotifications()
  {
    Iterator localIterator = findAllLocalNotifications().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      a(((UmengLocalNotification)localIterator.next()).getId(), "update_local_notification");
    }
  }

  public boolean updateLocalNotification(UmengLocalNotification paramUmengLocalNotification)
  {
    int i = 0;
    monitorenter;
    if (paramUmengLocalNotification == null);
    while (true)
    {
      try
      {
        a.c(a, "localNotification is null");
        return i;
        if (!paramUmengLocalNotification.validateDateTime())
        {
          a.c(a, "Please reset date time for localNotification");
          i = 0;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (!paramUmengLocalNotification.validateData(this.c))
      {
        a.c(a, "Please reset relavent data for localNotification");
        i = 0;
        continue;
      }
      try
      {
        UmengLocalNotificationStore.getInstance(this.c).updateLocalNotification(paramUmengLocalNotification);
        a(paramUmengLocalNotification.getId(), "update_local_notification");
        i = 1;
      }
      catch (Exception localException)
      {
        a.c(a, localException.toString());
        localException.printStackTrace();
        i = 0;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.local.UmengLocalNotificationManager
 * JD-Core Version:    0.6.0
 */