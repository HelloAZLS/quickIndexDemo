package ysg.gdcp.cn.a27;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ysg.gdcp.cn.a27.domain.Friend;

/**
 * Created by Administrator on 2017/3/23 09:58.
 *
 * @author ysg
 */
class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Friend> friends;

    public MyAdapter(Context context, ArrayList<Friend> friends) {
        this.context = context;
        this.friends = friends;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.activity_item, null);
        }
        ViewHolder holder = ViewHolder.getHolder(convertView);
        Friend friend = friends.get(position);
        holder.tvName.setText(friend.getName());
        String currentWord =friend.getPinYin().charAt(0)+"";
        if (position>0){
            String lastWord =friends.get(position-1).getPinYin().charAt(0)+"";
            if (currentWord.equals(lastWord)){
                holder.tvFirstWord.setVisibility(View.GONE);
            }else{
                holder.tvFirstWord.setVisibility(View.VISIBLE);
                holder.tvFirstWord.setText(currentWord);
            }
        }else{
            holder.tvFirstWord.setVisibility(View.VISIBLE);
            holder.tvFirstWord.setText(currentWord);
        }
        return convertView;
    }

    static class ViewHolder {
        TextView tvFirstWord;
        TextView tvName;

        public ViewHolder(View convertView) {
            tvName = (TextView) convertView.findViewById(R.id.tv_name);
            tvFirstWord = (TextView) convertView.findViewById(R.id.tv_firstword);
        }
        public static ViewHolder getHolder(View convertView) {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            if (holder == null) {
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }
            return holder;
        }
    }

}
