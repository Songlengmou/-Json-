package com.example.syp.jsonjiexi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * json解析student属性
 * {student:{"name":"XiaoMing","age"：10}}
 * <p>
 * 这个效果是从studio下方的Android Monitor观看
 */

public class MainActivity extends AppCompatActivity {

    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//---------------------合成------------------------------------
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "syp");
            jsonObject.put("age", 10);

            JSONObject json = new JSONObject();
            json.put("student", jsonObject);

            str = String.valueOf(json);
            Log.e("json", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//-------------------解析--------------------------------------
        try {
            JSONObject jsonObject = new JSONObject(str);

            JSONObject student = jsonObject.getJSONObject("student");

            String name = student.getString("name");
            int age = student.getInt("age");

            Log.e("json1", "name:" + name + ",age:" + age);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
