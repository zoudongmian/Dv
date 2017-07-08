package android.com.myapplication.fragment;

import android.com.myapplication.News.Dog;
import android.com.myapplication.News.DogAdapter;
import android.com.myapplication.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */

public class Message_Fragment extends Fragment {
    View layout;
    private List<Dog> dogList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_message,container,false);
        initDogs();
        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        
        DogAdapter adapter = new DogAdapter(dogList);
        recyclerView.setAdapter(adapter);
        return layout;
    }

    private void initDogs() {
        Dog baxianjiquan = new Dog("巴仙吉犬",R.drawable.baxianjiquan);
        dogList.add(baxianjiquan);
        Dog bianmu = new Dog("边牧",R.drawable.bianmu);
        dogList.add(bianmu);
        Dog bomeiquan = new Dog("博美犬",R.drawable.bomeiquan);
        dogList.add(bomeiquan);
        Dog douniu = new Dog("斗牛犬", R.drawable.douniuquan);
        dogList.add(douniu);
        Dog dubin = new Dog("杜宾犬", R.drawable.dubinquan);
        dogList.add(dubin);
        Dog guibin = new Dog("贵宾犬", R.drawable.guibingquan);
        dogList.add(guibin);
        Dog hashiqi = new Dog("哈士奇", R.drawable.hashiqi);
        dogList.add(hashiqi);
        Dog hudiequn = new Dog("蝴蝶犬", R.drawable.hudiequan);
        dogList.add(hudiequn);
        Dog jinmao = new Dog("金毛犬", R.drawable.jinmao);
        dogList.add(jinmao);
        Dog jiwawa = new Dog("吉娃娃", R.drawable.jiwawa);
        dogList.add(jiwawa);
        Dog keji = new Dog("柯基犬", R.drawable.keji);
        dogList.add(keji);
        Dog labuladuo = new Dog("拉布拉多", R.drawable.labuladuo);
        dogList.add(labuladuo);
        Dog lachangquan = new Dog("腊肠犬", R.drawable.lachangquan);
        dogList.add(lachangquan);
        Dog qiutianquan = new Dog("秋田犬", R.drawable.qiutianquan);
        dogList.add(qiutianquan);
        Dog samoye = new Dog("萨摩耶", R.drawable.samoye);
        dogList.add(samoye);
        Dog shapiquan = new Dog("沙皮犬", R.drawable.shapiquan);
        dogList.add(shapiquan);
        Dog songshi = new Dog("松狮犬", R.drawable.songshi);
        dogList.add(songshi);
        Dog xuelarui = new Dog("雪纳瑞", R.drawable.xuenarui);
        dogList.add(xuelarui);
        Dog zangao = new Dog("藏獒", R.drawable.zangao);
        dogList.add(zangao);


    }
    }

