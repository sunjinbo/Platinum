package com.android.Platinum;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public abstract class DBHelper
{
	// SQLite数据库实例 
	 protected SQLiteDatabase mDb = null;

	 //数据库创建帮手
	 protected CreateDBHelper mDbHelper = null;

	 //获得当前数据库帮手类标识(一般是该类名称)，用于日志等的记录
	 protected abstract String getTag();

	 // 获得数据库名称
	 protected abstract String getDatabaseName();

	 /** 
	 * 获得数据库版本，值至少为1。
	 * 当数据库结构发生改变的时候，请将此值加1，系统会在初始化时自动调用
	 * createDBTables和dropDBTables方法更新数据库结构。
	 */
	 protected abstract int getDatabaseVersion();

	 // 创建数据库表的SQL语句，一个元素一条语句
	 protected abstract String[] createDBTables();

	 //删除数据库表的SQL语句，一个元素一条语句
	 protected abstract String[] dropDBTables();

	 // 内部数据库创建帮手类
	 private class CreateDBHelper extends SQLiteOpenHelper
	 {
	  public CreateDBHelper(Context ctx)
	  {
	      super(ctx, getDatabaseName(), null, getDatabaseVersion());
	  }
	  @Override
	  public void onCreate(SQLiteDatabase db)
	  {
	     executeBatch(createDBTables(), db);
	  }
	 
	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	  {
	   Log.w(getTag(), "Upgrading database '" + getDatabaseName() + "' from version " + oldVersion + " to " + newVersion);
	   executeBatch(dropDBTables(), db);
	   onCreate(db);
	  }
	 
	  //批量执行Sql语句
	  private void executeBatch(String[] sqls, SQLiteDatabase db)
	  {
	   if(sqls == null)
	   {
	     return;
	   }
	   
	   db.beginTransaction();
	   try
	   {
	       int len = sqls.length;
	    for(int i = 0; i < len; i++)
	    {
	       db.execSQL(sqls[i]);
	    }
	       db.setTransactionSuccessful();
	   }
	   catch(Exception e)
	   {
	       Log.e(getTag(), e.getMessage(), e);
	   }
	   finally
	   {
	       db.endTransaction();
	   }
	  }
	 }

	 // 打开或者创建一个指定名称的数据库
	 public void open(Context ctx)
	 {
	  Log.i(getTag(), "Open database '" + getDatabaseName() + "'");
	  try
	     {
	    mDbHelper = new CreateDBHelper(ctx);
	    if(mDbHelper!=null)
	    {
	     mDb = mDbHelper.getWritableDatabase();
	       } 
	     }
	     catch(SQLException e)
	     {
	         Log.e("open", e.getMessage());
	     }
	  
	 }

	 //关闭数据库
	 public void close()
	 {
	  try
	  {
	   if(mDbHelper != null)
	   {
	    Log.i(getTag(), "Close database '" + getDatabaseName() + "'");
	    mDbHelper.close();
	   }  
	  }
	  catch(SQLException e)
	     {
	         Log.e("close", e.getMessage());
	     }
	 }
	 
	 //执行sql
	 protected void executeSQL(String sql)
	 {
	  if(sql.equals(""))
	  {
	    return;
	  }
	  
	  try
	  {
	   mDb.execSQL(sql);
	  }
	  catch(SQLException e)
	  {
	   Log.i(getTag(),e.getMessage(),e);
	  }
	 }

	 protected Cursor Query(String sql,String[] strArgs)
	 {
	  return mDb.rawQuery(sql,strArgs);
	 }



}
