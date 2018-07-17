package com.example.boylucky.myfirst.view.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boylucky.myfirst.R;
import com.example.boylucky.myfirst.bean.FileBean;
import com.example.boylucky.myfirst.bean.NickBean;
import com.example.boylucky.myfirst.presenter.MePresenter;
import com.example.boylucky.myfirst.presenter.UserPresenter;
import com.example.boylucky.myfirst.utils.App;
import com.example.boylucky.myfirst.utils.ScreenSizeUtils;
import com.example.boylucky.myfirst.view.interfaces.IUserView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserActivity extends AppCompatActivity implements View.OnClickListener,IUserView {


    private SimpleDraweeView tou1;
    /**
     * 1
     */
    private TextView tv_nickname;
    private UserPresenter userPresenter;
    private String uid;
    private String token;
    private String nick;
    //本地相册图片选择
    private String[] mCustomItem = {"本地相册", "相机拍照"};
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    private File Defaltefile;
    private File file;
    private Uri tempUri;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initView();
        initData();
        //隐层App标题栏
        getSupportActionBar().hide();
        //设置状态栏的颜色
        StatusBarUtil.setColor(this, Color.YELLOW);
    }

    private void initData() {
        userPresenter = new UserPresenter(this);
    }

    private void initView() {
        tou1 = (SimpleDraweeView) findViewById(R.id.tou1);
        tou1.setOnClickListener(this);
        tv_nickname = (TextView) findViewById(R.id.tv_nickname);
        tv_nickname.setOnClickListener(this);
        sp = App.context.getSharedPreferences("User", MODE_PRIVATE);
        edit = sp.edit();

        String ret = sp.getString("ret", "1");
        String uid = sp.getString("uid", null);

        Intent intent = getIntent();
        Log.e("img-----------", "000000+" + uid + "-----" + token);
        if (!ret.equals("0")&&!uid.equals(null)){
            String icon = intent.getStringExtra("icon");
            String nikname = intent.getStringExtra("nikname");
            tou1.setImageURI(Uri.parse(icon));
            tv_nickname.setText(nikname);
        }else{
            String qq_2 = intent.getStringExtra("qq_2");
            String nickName = intent.getStringExtra("nickName");
            tou1.setImageURI(Uri.parse(qq_2));
            tv_nickname.setText(nickName);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tou1:
                showSingleChoiceDialog();
                break;
            case R.id.tv_nickname:
                final EditText editText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                                 .setTitle("修改后昵称")
                                .setView(editText)
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        nick = editText.getText().toString();
                                        Log.e("uid--====","*-*-*-*-*-*-"+uid+"-*-*-*-"+nick);
                                        userPresenter.getData(uid,nick);
                                    }
                                }).create();
                    dialog.show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取相机返回值
        if (resultCode == -1) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        Bundle extras = data.getExtras();
                        Bitmap parcelable = extras.getParcelable("data");
                        saveFile(parcelable, "head.jpg");
                        Log.e("图片路径", file.getName().trim());
//                        final Map<String, Object> map = new HashMap<>();
//                        map.put("uid", sp.getString("uid", "0"));
//                        map.put("file", file != null ? file : Defaltefile);
                        RequestBody filebody = RequestBody.create(MediaType.parse("application/octet-stream"), file != null ? file : Defaltefile);
                        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), filebody);

                        userPresenter.getDataFrom(uid,part);
                    }
                    break;
            }
        }
    }
    //判断sd卡是否存在
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
        }
        return sdDir.toString();
    }
    //将图片保存到本地，参数一个是bitmap,一个是文件名字
    public void saveFile(Bitmap bm, String fileName) {
        try {
            String path = getSDPath() + "/revoeye/";
            File dirFile = new File(path);
            if (!dirFile.exists()) {
                dirFile.mkdir();
            }
            file = new File(path + fileName);
            BufferedOutputStream bos;
            bos = new BufferedOutputStream(new FileOutputStream(file));
            bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
            bos.flush();
            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    public void showSingleChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择：");
        builder.setItems(mCustomItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        Defaltefile = new File(Environment.getExternalStorageDirectory() + "/revoeye/", "image.jpg");
                        tempUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }
    @Override
    public void onSuccess(NickBean nickBean) {
        if ("0".equals(nickBean.getCode())){
            tv_nickname.setText(nick);
        }
    }

    @Override
    public void onSuccess(FileBean fileBean) {
        if ("0".equals(fileBean.getCode())){
            Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userPresenter.deach();
    }
}
