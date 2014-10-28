package com.ffc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class FlashCardsActivity extends Activity 
{
	String[] words;
	int wordNum = 0;
	int wordCnt = 0;
	Boolean isRandom = false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	
    	requestWindowFeature(Window.FEATURE_NO_TITLE); 
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	
        super.onCreate(savedInstanceState);
        
        
        Intent i = getIntent();
        
        int position = i.getIntExtra("cardNum", 0);
        
        switch (position)
        {
        	case 0:
        	{
        		words = getResources().getStringArray(R.array.lettersbig);
        		break;
        	}
        	case 1:
        	{
        		words = getResources().getStringArray(R.array.letterssmall);
        		break;
        	}       	
        	case 2:
        	{
        		words = getResources().getStringArray(R.array.bigword1);
        		break;
        	}
        	case 3:
        	{
        		words = getResources().getStringArray(R.array.numroc);
        		break;
        	}
        	case 4:
        	{
        		words = getResources().getStringArray(R.array.lettersbig);
        		shuffleArray(words);
        		break;
        	}
        	case 5:
        	{
        		words = getResources().getStringArray(R.array.letterssmall);
        		shuffleArray(words);
        		break;
        	}
        	case 6:
        	{
        		words = getResources().getStringArray(R.array.bigword1);
        		shuffleArray(words);
        		break;
        	}
        	case 7:
        	{
        		words = getResources().getStringArray(R.array.numroc);
        		shuffleArray(words);
        		break;
        	}
        	default:
        	{
        		words = getResources().getStringArray(R.array.numroc);
        		break;
        	}
        }
               
        wordNum = words.length;
        
        //String fontPath = "fonts/Flux_Architect_Bold.ttf";
        //String fontPath = "fonts/DN Manuscript.ttf";
        //String fontPath = "fonts/DN Manuscript Bold.ttf";
        //String fontPath = "fonts/Alido.otf";
        //String fontPath = "fonts/Zyia Learns Letters.TTF";
        String fontPath = "fonts/PRINC.TTF";
        
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        
        setContentView(R.layout.flashcardlayout);
        
        TextView wordView = (TextView)findViewById(R.id.word);
        
        wordView.setTypeface(tf);
        
        wordView.setGravity(Gravity.CENTER);
              
        wordView.setText(words[wordCnt]);

        
        final Button forwardBtn = (Button) findViewById(R.id.forward);
        
        forwardBtn.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {	
            		if(wordCnt < (wordNum - 1))
                	{
                		wordCnt = wordCnt + 1;
                		TextView wordView = (TextView)findViewById(R.id.word);
                    	wordView.setText(words[wordCnt]);
                	}
                	else
                	{
                		wordCnt = 0;
                	}     	
            }
        });

        final Button backwardBtn = (Button) findViewById(R.id.backward);
        
        backwardBtn.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	
            		if(wordCnt > 0)
                	{
                		wordCnt = wordCnt - 1;
                		TextView wordView = (TextView)findViewById(R.id.word);
                    	wordView.setText(words[wordCnt]);
                	}
                	else
                	{
                		wordCnt = 0;
                	} 

            }
        });
    }
  
 // Implementing FisherÐYates shuffle
    void shuffleArray(String[] ar)
    {
    	Random rnd = new Random();
        for (int i = ar.length - 1; i >= 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          String a = ar[index];
          ar[index] = ar[i];
          ar[i] = a;
        }
      }

    }
