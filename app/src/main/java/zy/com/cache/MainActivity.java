package zy.com.cache;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

	ImageView mImageView;
	TextView mTextView;
	String imgUrl="https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/728da9773912b31be94d5b4c8b18367adab4e1b6.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mImageView = findViewById(R.id.iv);
		mTextView = findViewById(R.id.tv);

		final String[] permissions={Manifest.permission.WRITE_EXTERNAL_STORAGE,
				Manifest.permission.READ_EXTERNAL_STORAGE};
		
		mTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ActivityCompat.requestPermissions(MainActivity.this,permissions,101);
			}
		});
	}


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		switch (requestCode) {
		    case 101:
		        if (grantResults[0]!= PackageManager.PERMISSION_GRANTED){
			        Toast.makeText(this, "权限已拒绝", Toast.LENGTH_SHORT).show();
		        }else {
		        	new MyBitmapUtils().disPlay(mImageView,imgUrl);
		        }
		        break;
		    default:
		
		        break;
		}
	}
}
