package com.givemeaplus.bag.blockandgo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.logging.Handler;

public class MainActivity extends Activity implements View.OnClickListener {

    LinearLayout parentLayout;
<<<<<<< HEAD
    //View[] childViews;
=======
    View[] childViews;
    Thread timer;
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4

    BoardState mBoardState;

    Button[][] blockArr = new Button[11][7];
    Button[][] wall_hArr = new Button[10][7];
    Button[][] wall_vArr = new Button[11][6];

<<<<<<< HEAD

//////////////Singleton singleton;
=======
    PlayerInformation myPlayer;
    PlayerInformation enemy;
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLayout = (LinearLayout)findViewById(R.id.parent_layout);
<<<<<<< HEAD
/////////////////        setOnClickListener(parentLayout);
=======
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4
        makeBtnArr(parentLayout);

        mBoardState = BoardState.getInstance();

<<<<<<< HEAD
        mBoardState.showBlock();

        for(int i=0; i<11; i++){

            for(int j=0; j<7; j++){

                blockArr[i][j].setEnabled(false);
            }
        }

=======
        timer = new Thread(new Runnable() {
            @Override
            public void run() {
                // 1초 지날때마다 핸들러로 타이머 텍스트뷰 숫자 변경
            }
        });

        Button button = (Button)findViewById(R.id.block00);

        button.setEnabled(false);
//
//        for(int i=0; i<11; i++)
//            for(int j=0; j<7; j++)
//                blockArr[i][j].setEnabled(false);
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4

    }

    private void makeBtnArr(ViewGroup viewGroup){

        View[] childViews = getChildViews(viewGroup);

<<<<<<< HEAD
        for(int i=0;i<childViews.length; i++){
=======
        System.out.println(childViews.length);

        for(int i=0; i<childViews.length; i++){
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4

            if(childViews[i] instanceof LinearLayout ){

                makeBtnArr((ViewGroup)childViews[i]);

            }else if(childViews[i] instanceof Button) {

                if (childViews[i].getTag() != null) {

<<<<<<< HEAD
                    String tag = childViews[i].getTag().toString().trim();

                    int ii,ij;

                    if(tag.contains("block")){

                        //Log.d("dSJW", "\t\t\t tag  = "+tag);
                        tag = tag.replace("block", "");

                        int index = Integer.parseInt(tag);
=======
                    String tagTemp = childViews[i].getTag().toString();

                    System.out.println(tagTemp);

                    int ii, ij;
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4

                    if (tagTemp.contains("block")) {

<<<<<<< HEAD
                        blockArr[ii][ij] = (Button)childViews[i];

                    }else if(tag.contains("wall_h")){

                        //Log.d("dSJW", "\t\t\t tag  = "+tag);

                        tag = tag.replace("wall_h", "");
                        int index = Integer.parseInt(tag);
=======
                        String tmp = tagTemp.replace("block", "");
                        int index = Integer.parseInt(tmp);

                        ii = index / 10;
                        ij = index % 10;
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4

                        blockArr[ii][ij] = (Button) childViews[i];
                    } else if (tagTemp.contains("wall_h")) {

<<<<<<< HEAD
                        wall_hArr[ii][ij] = (Button)childViews[i];

                    }else if(tag.contains("wall_v")){

                        //Log.d("dSJW", "\t\t\t tag  = "+tag);
                        tag = tag.replace("wall_v", "");
                        int index = Integer.parseInt(tag);
=======
                        String tmp = tagTemp.replace("wall_h", "");
                        int index = Integer.parseInt(tmp);

                        ii = index / 10;
                        ij = index % 10;
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4

                        wall_hArr[ii][ij] = (Button) childViews[i];
                    } else if (tagTemp.contains("wall_v")) {

<<<<<<< HEAD
                        wall_vArr[ii][ij] = (Button)childViews[i];

=======
                        String tmp = tagTemp.replace("wall_v", "");
                        int index = Integer.parseInt(tmp);

                        ii = index / 10;
                        ij = index % 10;

                        wall_vArr[ii][ij] = (Button) childViews[i];
>>>>>>> 92f334940d6328074b665d01902e78adf9c327b4
                    }
                }
            }
        }
    }

    public void onClickBlock(View v){

        String id_index = v.getTag().toString();
        int index;

        id_index = id_index.replace("block","");
        index = Integer.parseInt(id_index);
        int i = index/10;
        int j = index%10;

        System.out.println(i+" "+j);

        mBoardState.setBlock(i, j, true);
    }

    public void onClickWall_h(View v){
        String id_index = v.getTag().toString();
        int index;

        id_index = id_index.replace("wall_h","");
        index = Integer.parseInt(id_index);
        int i = index/10;
        int j = index%10;

        System.out.println("wall_h "+i+" "+j);
        mBoardState.setWall_h(i, j, true);
    }

    public void onClickWall_v(View v){
        String id_index = v.getTag().toString();
        int index;

        id_index = id_index.replace("wall_v", "");
        index = Integer.parseInt(id_index);
        int i = index/10;
        int j = index%10;

        System.out.println("wall_v "+i+" "+j);
        mBoardState.setWall_v(i, j, true);
    }


    private View[] getChildViews(ViewGroup viewGroup){

        int childCnt = viewGroup.getChildCount();
        final View[] childViews = new View[childCnt];

        for(int i=0; i<childCnt; i++){
            childViews[i] = viewGroup.getChildAt(i);
        }

        return childViews;
    }

    @Override
    public void onClick(View v) {

        String id_index;
        int index;

        if(v.getTag() != null) {
            id_index = v.getTag().toString();
            //Log.d("dSJW", id_index);

            if(id_index.contains("block")){

                index = Integer.parseInt(id_index);
                int i = index/10;
                int j = index%10;

                mBoardState.setBlock(i, j, true);
            }
            else if(id_index.contains("wall_h")){

                index = Integer.parseInt(id_index);
                int i = index/10;
                int j = index%10;

                mBoardState.setWall_h(i, j, true);
            }
            else if(id_index.contains("wall_v")){

                index = Integer.parseInt(id_index);
                int i = index/10;
                int j = index%10;

                mBoardState.setWall_v(i, j, true);
            }
        }

        mBoardState.showBlock();

    }



}
