package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityChooserModel extends DataSetObservable
{
  private static final String ATTRIBUTE_ACTIVITY = "activity";
  private static final String ATTRIBUTE_TIME = "time";
  private static final String ATTRIBUTE_WEIGHT = "weight";
  private static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final String TAG_HISTORICAL_RECORD = "historical-record";
  private static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry;
  private static final Object sRegistryLock = new Object();
  private final List<ActivityResolveInfo> mActivities = new ArrayList();
  private OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivitySorter mActivitySorter = new DefaultSorter(null);
  private boolean mCanReadHistoricalData = true;
  private final Context mContext;
  private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  private final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  private boolean mReloadActivities = false;

  static
  {
    sDataModelRegistry = new HashMap();
  }

  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      this.mHistoryFileName = (paramString + ".xml");
      return;
    }
    this.mHistoryFileName = paramString;
  }

  private boolean addHisoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
    if (bool)
    {
      this.mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      persistHistoricalDataIfNeeded();
      sortActivitiesIfNeeded();
      notifyChanged();
    }
    return bool;
  }

  private void ensureConsistentState()
  {
    boolean bool = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
    pruneExcessiveHistoricalRecordsIfNeeded();
    if (bool)
    {
      sortActivitiesIfNeeded();
      notifyChanged();
    }
  }

  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      if (localActivityChooserModel == null)
      {
        localActivityChooserModel = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel);
      }
      return localActivityChooserModel;
    }
  }

  private boolean loadActivitiesIfNeeded()
  {
    boolean bool = this.mReloadActivities;
    int i = 0;
    if (bool)
    {
      Intent localIntent = this.mIntent;
      i = 0;
      if (localIntent != null)
      {
        this.mReloadActivities = false;
        this.mActivities.clear();
        List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int j = localList.size();
        for (int k = 0; k < j; k++)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(k);
          this.mActivities.add(new ActivityResolveInfo(localResolveInfo));
        }
        i = 1;
      }
    }
    return i;
  }

  private void persistHistoricalDataIfNeeded()
  {
    if (!this.mReadShareHistoryCalled)
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    if (!this.mHistoricalRecordsChanged);
    do
    {
      return;
      this.mHistoricalRecordsChanged = false;
    }
    while (TextUtils.isEmpty(this.mHistoryFileName));
    PersistHistoryAsyncTask localPersistHistoryAsyncTask = new PersistHistoryAsyncTask(null);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mHistoricalRecords;
    arrayOfObject[1] = this.mHistoryFileName;
    AsyncTaskCompat.executeParallel(localPersistHistoryAsyncTask, arrayOfObject);
  }

  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int i = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
    if (i <= 0);
    while (true)
    {
      return;
      this.mHistoricalRecordsChanged = true;
      for (int j = 0; j < i; j++)
        ((HistoricalRecord)this.mHistoricalRecords.remove(0));
    }
  }

  private boolean readHistoricalDataIfNeeded()
  {
    if ((this.mCanReadHistoricalData) && (this.mHistoricalRecordsChanged) && (!TextUtils.isEmpty(this.mHistoryFileName)))
    {
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = true;
      readHistoricalDataImpl();
      return true;
    }
    return false;
  }

  // ERROR //
  private void readHistoricalDataImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	android/support/v7/internal/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 147	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   8: invokevirtual 258	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 264	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore 11
    //   17: aload 11
    //   19: aload_2
    //   20: aconst_null
    //   21: invokeinterface 270 3 0
    //   26: iconst_0
    //   27: istore 12
    //   29: iload 12
    //   31: iconst_1
    //   32: if_icmpeq +21 -> 53
    //   35: iload 12
    //   37: iconst_2
    //   38: if_icmpeq +15 -> 53
    //   41: aload 11
    //   43: invokeinterface 273 1 0
    //   48: istore 12
    //   50: goto -21 -> 29
    //   53: ldc 40
    //   55: aload 11
    //   57: invokeinterface 276 1 0
    //   62: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifne +57 -> 122
    //   68: new 252	org/xmlpull/v1/XmlPullParserException
    //   71: dup
    //   72: ldc_w 281
    //   75: invokespecial 282	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: astore 8
    //   81: getstatic 75	android/support/v7/internal/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   84: new 137	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 284
    //   94: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 147	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   101: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload 8
    //   109: invokestatic 290	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   112: pop
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 295	java/io/FileInputStream:close	()V
    //   121: return
    //   122: aload_0
    //   123: getfield 98	android/support/v7/internal/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   126: astore 13
    //   128: aload 13
    //   130: invokeinterface 200 1 0
    //   135: aload 11
    //   137: invokeinterface 273 1 0
    //   142: istore 14
    //   144: iload 14
    //   146: iconst_1
    //   147: if_icmpne +15 -> 162
    //   150: aload_2
    //   151: ifnull -30 -> 121
    //   154: aload_2
    //   155: invokevirtual 295	java/io/FileInputStream:close	()V
    //   158: return
    //   159: astore 16
    //   161: return
    //   162: iload 14
    //   164: iconst_3
    //   165: if_icmpeq -30 -> 135
    //   168: iload 14
    //   170: iconst_4
    //   171: if_icmpeq -36 -> 135
    //   174: ldc 37
    //   176: aload 11
    //   178: invokeinterface 276 1 0
    //   183: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifne +60 -> 246
    //   189: new 252	org/xmlpull/v1/XmlPullParserException
    //   192: dup
    //   193: ldc_w 297
    //   196: invokespecial 282	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   199: athrow
    //   200: astore 5
    //   202: getstatic 75	android/support/v7/internal/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   205: new 137	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 284
    //   215: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 147	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   222: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: aload 5
    //   230: invokestatic 290	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: aload_2
    //   235: ifnull -114 -> 121
    //   238: aload_2
    //   239: invokevirtual 295	java/io/FileInputStream:close	()V
    //   242: return
    //   243: astore 7
    //   245: return
    //   246: aload 13
    //   248: new 245	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord
    //   251: dup
    //   252: aload 11
    //   254: aconst_null
    //   255: ldc 8
    //   257: invokeinterface 301 3 0
    //   262: aload 11
    //   264: aconst_null
    //   265: ldc 11
    //   267: invokeinterface 301 3 0
    //   272: invokestatic 307	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   275: aload 11
    //   277: aconst_null
    //   278: ldc 14
    //   280: invokeinterface 301 3 0
    //   285: invokestatic 313	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   288: invokespecial 316	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   291: invokeinterface 162 2 0
    //   296: pop
    //   297: goto -162 -> 135
    //   300: astore_3
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 295	java/io/FileInputStream:close	()V
    //   309: aload_3
    //   310: athrow
    //   311: astore 10
    //   313: return
    //   314: astore 4
    //   316: goto -7 -> 309
    //   319: astore_1
    //   320: return
    //
    // Exception table:
    //   from	to	target	type
    //   12	26	79	org/xmlpull/v1/XmlPullParserException
    //   41	50	79	org/xmlpull/v1/XmlPullParserException
    //   53	79	79	org/xmlpull/v1/XmlPullParserException
    //   122	135	79	org/xmlpull/v1/XmlPullParserException
    //   135	144	79	org/xmlpull/v1/XmlPullParserException
    //   174	200	79	org/xmlpull/v1/XmlPullParserException
    //   246	297	79	org/xmlpull/v1/XmlPullParserException
    //   154	158	159	java/io/IOException
    //   12	26	200	java/io/IOException
    //   41	50	200	java/io/IOException
    //   53	79	200	java/io/IOException
    //   122	135	200	java/io/IOException
    //   135	144	200	java/io/IOException
    //   174	200	200	java/io/IOException
    //   246	297	200	java/io/IOException
    //   238	242	243	java/io/IOException
    //   12	26	300	finally
    //   41	50	300	finally
    //   53	79	300	finally
    //   81	113	300	finally
    //   122	135	300	finally
    //   135	144	300	finally
    //   174	200	300	finally
    //   202	234	300	finally
    //   246	297	300	finally
    //   117	121	311	java/io/IOException
    //   305	309	314	java/io/IOException
    //   0	12	319	java/io/FileNotFoundException
  }

  private boolean sortActivitiesIfNeeded()
  {
    if ((this.mActivitySorter != null) && (this.mIntent != null) && (!this.mActivities.isEmpty()) && (!this.mHistoricalRecords.isEmpty()))
    {
      this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
      return true;
    }
    return false;
  }

  public Intent chooseActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == null)
        return null;
      ensureConsistentState();
      ActivityResolveInfo localActivityResolveInfo = (ActivityResolveInfo)this.mActivities.get(paramInt);
      ComponentName localComponentName = new ComponentName(localActivityResolveInfo.resolveInfo.activityInfo.packageName, localActivityResolveInfo.resolveInfo.activityInfo.name);
      Intent localIntent1 = new Intent(this.mIntent);
      localIntent1.setComponent(localComponentName);
      if (this.mActivityChoserModelPolicy != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent2))
          return null;
      }
      addHisoricalRecord(new HistoricalRecord(localComponentName, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }

  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }

  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mActivities.size();
      return i;
    }
  }

  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    while (true)
    {
      int j;
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        List localList = this.mActivities;
        int i = localList.size();
        j = 0;
        if (j >= i)
          continue;
        if (((ActivityResolveInfo)localList.get(j)).resolveInfo == paramResolveInfo)
        {
          return j;
          return -1;
        }
      }
      j++;
    }
  }

  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      if (!this.mActivities.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivities.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }

  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }

  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }

  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }

  public void setActivitySorter(ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter == paramActivitySorter)
        return;
      this.mActivitySorter = paramActivitySorter;
      if (sortActivitiesIfNeeded())
        notifyChanged();
      return;
    }
  }

  public void setDefaultActivity(int paramInt)
  {
    while (true)
    {
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        ActivityResolveInfo localActivityResolveInfo1 = (ActivityResolveInfo)this.mActivities.get(paramInt);
        ActivityResolveInfo localActivityResolveInfo2 = (ActivityResolveInfo)this.mActivities.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f = 5.0F + (localActivityResolveInfo2.weight - localActivityResolveInfo1.weight);
          addHisoricalRecord(new HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
  }

  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize == paramInt)
        return;
      this.mHistoryMaxSize = paramInt;
      pruneExcessiveHistoricalRecordsIfNeeded();
      if (sortActivitiesIfNeeded())
        notifyChanged();
      return;
    }
  }

  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == paramIntent)
        return;
      this.mIntent = paramIntent;
      this.mReloadActivities = true;
      ensureConsistentState();
      return;
    }
  }

  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener)
  {
    synchronized (this.mInstanceLock)
    {
      this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
      return;
    }
  }

  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }

  public final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;

    public ActivityResolveInfo(ResolveInfo arg2)
    {
      Object localObject;
      this.resolveInfo = localObject;
    }

    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      ActivityResolveInfo localActivityResolveInfo;
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localActivityResolveInfo = (ActivityResolveInfo)paramObject;
      }
      while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(localActivityResolveInfo.weight));
      return false;
    }

    public int hashCode()
    {
      return 31 + Float.floatToIntBits(this.weight);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1);
  }

  private final class DefaultSorter
    implements ActivityChooserModel.ActivitySorter
  {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
    private final Map<String, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

    private DefaultSorter()
    {
    }

    public void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
    {
      Map localMap = this.mPackageNameToActivityMap;
      localMap.clear();
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)paramList.get(j);
        localActivityResolveInfo2.weight = 0.0F;
        localMap.put(localActivityResolveInfo2.resolveInfo.activityInfo.packageName, localActivityResolveInfo2);
      }
      int k = -1 + paramList1.size();
      float f1 = 1.0F;
      int m = k;
      float f2;
      if (m >= 0)
      {
        ActivityChooserModel.HistoricalRecord localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)paramList1.get(m);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)localMap.get(localHistoricalRecord.activity.getPackageName());
        if (localActivityResolveInfo1 == null)
          break label178;
        localActivityResolveInfo1.weight += f1 * localHistoricalRecord.weight;
        f2 = 0.95F * f1;
      }
      while (true)
      {
        m--;
        f1 = f2;
        break;
        Collections.sort(paramList);
        return;
        label178: f2 = f1;
      }
    }
  }

  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;

    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.activity = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }

    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      HistoricalRecord localHistoricalRecord;
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localHistoricalRecord = (HistoricalRecord)paramObject;
        if (this.activity == null)
        {
          if (localHistoricalRecord.activity != null)
            return false;
        }
        else if (!this.activity.equals(localHistoricalRecord.activity))
          return false;
        if (this.time != localHistoricalRecord.time)
          return false;
      }
      while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(localHistoricalRecord.weight));
      return false;
    }

    public int hashCode()
    {
      if (this.activity == null);
      for (int i = 0; ; i = this.activity.hashCode())
        return 31 * (31 * (i + 31) + (int)(this.time ^ this.time >>> 32)) + Float.floatToIntBits(this.weight);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.activity);
      localStringBuilder.append("; time:").append(this.time);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }

  private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void>
  {
    private PersistHistoryAsyncTask()
    {
    }

    // ERROR //
    public Void doInBackground(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_1
      //   3: iconst_0
      //   4: aaload
      //   5: checkcast 32	java/util/List
      //   8: astore_3
      //   9: aload_1
      //   10: iconst_1
      //   11: aaload
      //   12: checkcast 34	java/lang/String
      //   15: astore 4
      //   17: aload_0
      //   18: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   21: invokestatic 40	android/support/v7/internal/widget/ActivityChooserModel:access$200	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Landroid/content/Context;
      //   24: aload 4
      //   26: iconst_0
      //   27: invokevirtual 46	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   30: astore 7
      //   32: invokestatic 52	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   35: astore 8
      //   37: aload 8
      //   39: aload 7
      //   41: aconst_null
      //   42: invokeinterface 58 3 0
      //   47: aload 8
      //   49: ldc 60
      //   51: iconst_1
      //   52: invokestatic 66	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   55: invokeinterface 70 3 0
      //   60: aload 8
      //   62: aconst_null
      //   63: ldc 72
      //   65: invokeinterface 76 3 0
      //   70: pop
      //   71: aload_3
      //   72: invokeinterface 80 1 0
      //   77: istore 25
      //   79: iload_2
      //   80: iload 25
      //   82: if_icmpge +133 -> 215
      //   85: aload_3
      //   86: iconst_0
      //   87: invokeinterface 84 2 0
      //   92: checkcast 86	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord
      //   95: astore 26
      //   97: aload 8
      //   99: aconst_null
      //   100: ldc 88
      //   102: invokeinterface 76 3 0
      //   107: pop
      //   108: aload 8
      //   110: aconst_null
      //   111: ldc 90
      //   113: aload 26
      //   115: getfield 93	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
      //   118: invokevirtual 99	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   121: invokeinterface 103 4 0
      //   126: pop
      //   127: aload 8
      //   129: aconst_null
      //   130: ldc 105
      //   132: aload 26
      //   134: getfield 108	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:time	J
      //   137: invokestatic 111	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   140: invokeinterface 103 4 0
      //   145: pop
      //   146: aload 8
      //   148: aconst_null
      //   149: ldc 113
      //   151: aload 26
      //   153: getfield 116	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:weight	F
      //   156: invokestatic 119	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   159: invokeinterface 103 4 0
      //   164: pop
      //   165: aload 8
      //   167: aconst_null
      //   168: ldc 88
      //   170: invokeinterface 122 3 0
      //   175: pop
      //   176: iinc 2 1
      //   179: goto -100 -> 79
      //   182: astore 5
      //   184: invokestatic 125	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   187: new 127	java/lang/StringBuilder
      //   190: dup
      //   191: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   194: ldc 130
      //   196: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   199: aload 4
      //   201: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   204: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   207: aload 5
      //   209: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   212: pop
      //   213: aconst_null
      //   214: areturn
      //   215: aload 8
      //   217: aconst_null
      //   218: ldc 72
      //   220: invokeinterface 122 3 0
      //   225: pop
      //   226: aload 8
      //   228: invokeinterface 146 1 0
      //   233: aload_0
      //   234: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   237: iconst_1
      //   238: invokestatic 150	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   241: pop
      //   242: aload 7
      //   244: ifnull -31 -> 213
      //   247: aload 7
      //   249: invokevirtual 155	java/io/FileOutputStream:close	()V
      //   252: aconst_null
      //   253: areturn
      //   254: astore 34
      //   256: aconst_null
      //   257: areturn
      //   258: astore 20
      //   260: invokestatic 125	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   263: new 127	java/lang/StringBuilder
      //   266: dup
      //   267: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   270: ldc 130
      //   272: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   275: aload_0
      //   276: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   279: invokestatic 159	android/support/v7/internal/widget/ActivityChooserModel:access$400	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
      //   282: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   285: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   288: aload 20
      //   290: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   293: pop
      //   294: aload_0
      //   295: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   298: iconst_1
      //   299: invokestatic 150	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   302: pop
      //   303: aload 7
      //   305: ifnull -92 -> 213
      //   308: aload 7
      //   310: invokevirtual 155	java/io/FileOutputStream:close	()V
      //   313: aconst_null
      //   314: areturn
      //   315: astore 23
      //   317: aconst_null
      //   318: areturn
      //   319: astore 16
      //   321: invokestatic 125	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   324: new 127	java/lang/StringBuilder
      //   327: dup
      //   328: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   331: ldc 130
      //   333: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   336: aload_0
      //   337: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   340: invokestatic 159	android/support/v7/internal/widget/ActivityChooserModel:access$400	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
      //   343: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   349: aload 16
      //   351: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   354: pop
      //   355: aload_0
      //   356: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   359: iconst_1
      //   360: invokestatic 150	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   363: pop
      //   364: aload 7
      //   366: ifnull -153 -> 213
      //   369: aload 7
      //   371: invokevirtual 155	java/io/FileOutputStream:close	()V
      //   374: aconst_null
      //   375: areturn
      //   376: astore 19
      //   378: aconst_null
      //   379: areturn
      //   380: astore 12
      //   382: invokestatic 125	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   385: new 127	java/lang/StringBuilder
      //   388: dup
      //   389: invokespecial 128	java/lang/StringBuilder:<init>	()V
      //   392: ldc 130
      //   394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   397: aload_0
      //   398: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   401: invokestatic 159	android/support/v7/internal/widget/ActivityChooserModel:access$400	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
      //   404: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   410: aload 12
      //   412: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   415: pop
      //   416: aload_0
      //   417: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   420: iconst_1
      //   421: invokestatic 150	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   424: pop
      //   425: aload 7
      //   427: ifnull -214 -> 213
      //   430: aload 7
      //   432: invokevirtual 155	java/io/FileOutputStream:close	()V
      //   435: aconst_null
      //   436: areturn
      //   437: astore 15
      //   439: aconst_null
      //   440: areturn
      //   441: astore 9
      //   443: aload_0
      //   444: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   447: iconst_1
      //   448: invokestatic 150	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   451: pop
      //   452: aload 7
      //   454: ifnull +8 -> 462
      //   457: aload 7
      //   459: invokevirtual 155	java/io/FileOutputStream:close	()V
      //   462: aload 9
      //   464: athrow
      //   465: astore 11
      //   467: goto -5 -> 462
      //
      // Exception table:
      //   from	to	target	type
      //   17	32	182	java/io/FileNotFoundException
      //   247	252	254	java/io/IOException
      //   37	79	258	java/lang/IllegalArgumentException
      //   85	176	258	java/lang/IllegalArgumentException
      //   215	233	258	java/lang/IllegalArgumentException
      //   308	313	315	java/io/IOException
      //   37	79	319	java/lang/IllegalStateException
      //   85	176	319	java/lang/IllegalStateException
      //   215	233	319	java/lang/IllegalStateException
      //   369	374	376	java/io/IOException
      //   37	79	380	java/io/IOException
      //   85	176	380	java/io/IOException
      //   215	233	380	java/io/IOException
      //   430	435	437	java/io/IOException
      //   37	79	441	finally
      //   85	176	441	finally
      //   215	233	441	finally
      //   260	294	441	finally
      //   321	355	441	finally
      //   382	416	441	finally
      //   457	462	465	java/io/IOException
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel
 * JD-Core Version:    0.6.0
 */