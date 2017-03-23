package ysg.gdcp.cn.a27.utils;

import android.text.TextUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Administrator on 2017/3/23 10:44.
 * 这是一个汉字转拼音的工具类
 *
 * @author ysg
 */

public class PinYinUtil {
    public static String getPinYin(String chinese) {
        if (TextUtils.isEmpty(chinese)) {
            return null;
        }
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);//把拼音转换为大写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//不包含音调
        String pinYin = "";
        //把字符串变成单个汉字，
        char[] chars = chinese.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //过滤空格
            if (Character.isWhitespace(chars[i])) {
                continue;
            }
            //判断是否是汉字
            if (chars[i] > 127) {
                //可能是汉字
                try {
                    String[] pinYinArr = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                    if (pinYinArr != null) {
                        //找到拼音
                        pinYin += pinYinArr[0];
                    } else {
                        //没找到拼音
                    }
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
            } else {
                //不是汉字
                pinYin += chars[i];
            }
        }
        return pinYin;
    }
}
