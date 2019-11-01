package zy.com.cache;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * 自定义的BitmapUtils,实现三级缓存
 */
public class MyBitmapUtils {

	private NetCacheUtils mNetCacheUtils;
	private LocalCacheUtils mLocalCacheUtils;
	//private MemoryCacheUtils mMemoryCacheUtils;

	public MyBitmapUtils() {
		//mMemoryCacheUtils = new MemoryCacheUtils();
		mLocalCacheUtils = new LocalCacheUtils();
		mNetCacheUtils = new NetCacheUtils(mLocalCacheUtils/*, mMemoryCacheUtils*/);
	}

	public void disPlay(ImageView ivPic, String url) {
		ivPic.setImageResource(R.mipmap.ic_launcher);
		Bitmap bitmap;
		//内存缓存
		//bitmap = mMemoryCacheUtils.getBitmapFromMemory(url);
		bitmap = MemoryCacheUtils.getInstance().getBitmapFromMemory(url);
		if (bitmap != null) {
			ivPic.setImageBitmap(bitmap);
			LogUtils.e("从内存获取图片啦.....");
			return;
		}

		//本地缓存
		bitmap = mLocalCacheUtils.getBitmapFromLocal(url);
		if (bitmap != null) {
			ivPic.setImageBitmap(bitmap);
			LogUtils.e("从本地获取图片啦.....");
			//从本地获取图片后,保存至内存中
			//mMemoryCacheUtils.setBitmapToMemory(url, bitmap);
			MemoryCacheUtils.getInstance().setBitmapToMemory(url, bitmap);
			return;
		}
		//网络缓存
		mNetCacheUtils.getBitmapFromNet(ivPic, url);
	}
}