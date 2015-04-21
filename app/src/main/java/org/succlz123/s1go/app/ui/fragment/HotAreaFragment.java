package org.succlz123.s1go.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.succlz123.s1go.app.R;
import org.succlz123.s1go.app.dao.Helper.S1FidHelper;
import org.succlz123.s1go.app.dao.Helper.S1FidImgHelper;
import org.succlz123.s1go.app.ui.activity.ThreadsActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by fashi on 2015/4/11.
 */
public class HotAreaFragment extends Fragment {
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.forum_base_fragment_listview);
        BaseAdapter mApdater = new AppAdapet();
        listView.setAdapter(mApdater);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] fid = {"134", "138", "118", "132", "105", "131", "69", "76", "111"};
                List<String> fideList = Arrays.asList(fid);
                Intent intent = new Intent(getActivity(), ThreadsActivity.class);
                intent.putExtra("fid", fideList.get(position));
                startActivity(intent);

            }
        });
        return view;
    }

    private class AppAdapet extends BaseAdapter {

        @Override
        public int getCount() {
            return 9;
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
            convertView = getActivity().getLayoutInflater().inflate(R.layout.forum_fragment_listview_item, parent, false);
            TextView textView = (TextView) convertView.findViewById(R.id.forum_base_fragment_listview_item_title);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.forum_base_fragment_listview_item_forum_img);
            imageView.setImageBitmap(S1FidImgHelper.getBitmap(new Random().nextInt(193)));
            switch (position) {
                case 0:
                    textView.setText(S1FidHelper.S134);
                    break;
                case 1:
                    textView.setText(S1FidHelper.S138);
                    break;
                case 2:
                    textView.setText(S1FidHelper.S118);
                    break;
                case 3:
                    textView.setText(S1FidHelper.S132);
                    break;
                case 4:
                    textView.setText(S1FidHelper.S105);
                    break;
                case 5:
                    textView.setText(S1FidHelper.S131);
                    break;
                case 6:
                    textView.setText(S1FidHelper.S69);
                    break;
                case 7:
                    textView.setText(S1FidHelper.S76);
                    break;
                case 8:
                    textView.setText(S1FidHelper.S111);
                    break;
            }
            return convertView;
        }
    }
}