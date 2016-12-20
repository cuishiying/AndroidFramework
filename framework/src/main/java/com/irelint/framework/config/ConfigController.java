package com.irelint.framework.config;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 作者：当我遇上你 on 2016-12-20 17:06
 * 邮箱：cuishiying163@163.com
 */

public class ConfigController {
    public static boolean saveConfig(Context context, String file,
                                     Properties properties) {
        try {
            File fil = new File(file);
            if (!fil.exists())
                fil.createNewFile();
            FileOutputStream s = new FileOutputStream(fil);
            properties.store(s, "");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static Properties loadConfig(Context context) {
        Properties properties = new Properties();
        try {
            InputStream in = context.getAssets().open("config.properties");
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return properties;
    }
}
