package ysg.gdcp.cn.a27.domain;

import ysg.gdcp.cn.a27.utils.PinYinUtil;

/**
 * Created by Administrator on 2017/3/23 09:55.
 *
 * @author ysg
 */

public class Friend implements  Comparable<Friend>{
    private  String name;
    private  String pinYin;



    public Friend(String name) {
        this.name = name;
         setPinYin(PinYinUtil.getPinYin(name));
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Friend another) {
        return getPinYin().compareTo(another.getPinYin());
    }
}
