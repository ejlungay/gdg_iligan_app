package com.ejapp.tiles;

import android.app.*;
import android.content.*;
import android.media.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity
{
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	TextView showMoves;
	int arr_int[];
	Button[] arr;
	Context con;
	ProgressDialog d;
	int moves;
	MediaPlayer mp;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		//final Button btn1 = (Button)findViewById(
		con=this;
		mp=MediaPlayer.create(con, R.raw.keypress);
		showMoves=(TextView)findViewById(R.id.moves);
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		btn4 = (Button)findViewById(R.id.btn4);	
		btn5 = (Button)findViewById(R.id.btn5);
		btn6 = (Button)findViewById(R.id.btn6);
		btn7 = (Button)findViewById(R.id.btn7);
		btn8 = (Button)findViewById(R.id.btn8);	
		btn9 = (Button)findViewById(R.id.btn9);	
		moves=0;
		showMoves.setText("Moves: " + Integer.toString(moves).toString());
		arr_int=new int[9];
		arr = new Button[9];
		arr[0]=btn1;
		arr[1]=btn2;
		arr[2]=btn3;
		arr[3]=btn4;
		arr[4]=btn5;
		arr[5]=btn6;
		arr[6]=btn7;
		arr[7]=btn8;
		arr[8]=btn9;
		
		start();
    }
	public void start() {
		ini();
		Toast.makeText(con, "Game started!", Toast.LENGTH_SHORT).show();
		showMoves.setText("Move: 0");
		moves=0;
		int blank_btn=(int)(Math.random() * 8) + 1;
	    generate();
		int temp[]=arr_int;
		int index=blank_btn;
		
		String t="";
		for (int j=blank_btn-1; j<arr_int.length-1; j++) {
			t+=Integer.toString(arr_int[j]) + " ";
		}
		
		StringTokenizer st=new StringTokenizer(t, " ");
		temp[blank_btn-1]=0;
		while (st.hasMoreTokens()) {
			temp[blank_btn]=Integer.parseInt(st.nextToken());
			blank_btn++;
		}
		
		for (int i=0; i<arr_int.length;i++) {
			arr[i].setText(Integer.toString(temp[i]));
		}
		arr_int=temp;
		arr[index-1].setText(" ");
		arr[index-1].setBackgroundResource(R.drawable.btn_empty_background);
		//arr[index-1].setTextColor(Color.BLACK);
		btn1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				play();
				String str=btn1.getText().toString();
				String right=btn2.getText().toString();
				String bottom=btn4.getText().toString();
				if (right.equals(" ") || right == null) {
					btn2.setText(str);
					btn2.setBackgroundResource(R.drawable.btn_background);
					btn1.setText(" ");
					btn1.setBackgroundResource(R.drawable.btn_empty_background);
					moves++;
				}
				if (bottom.equals(" ") || bottom == null) {
					btn4.setText(str);
					btn4.setBackgroundResource(R.drawable.btn_background);
					btn1.setText(" ");
					btn1.setBackgroundResource(R.drawable.btn_empty_background);
					moves++;
				}
				showMoves.setText("Moves: " + Integer.toString(moves).toString());
				isSolve();
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn2.getText().toString();
					String left=btn1.getText().toString();
					String right=btn3.getText().toString();
					String bottom=btn5.getText().toString();
					if (left.equals(" ") || left == null) {
						btn1.setText(str);
						btn1.setBackgroundResource(R.drawable.btn_background);
						btn2.setText(" ");
						btn2.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (right.equals(" ") || right == null) {
						btn3.setText(str);
						btn3.setBackgroundResource(R.drawable.btn_background);
						btn2.setText(" ");
						btn2.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (bottom.equals(" ") || bottom == null) {
						btn5.setText(str);
						btn5.setBackgroundResource(R.drawable.btn_background);
						btn2.setText(" ");
						btn2.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
					isSolve();
				}
			});
			
		btn3.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn3.getText().toString();
					String left=btn2.getText().toString();
					String bottom=btn6.getText().toString();
					if (left.equals(" ") || left == null) {
						btn2.setText(str);
						btn2.setBackgroundResource(R.drawable.btn_background);
						btn3.setText(" ");
						btn3.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (bottom.equals(" ") || bottom == null) {
						btn6.setText(str);
						btn6.setBackgroundResource(R.drawable.btn_background);
						btn3.setText(" ");
						btn3.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
					isSolve();
				}
			});
			
		btn4.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn4.getText().toString();
					String top=btn1.getText().toString();
					String right=btn5.getText().toString();
					String bottom=btn7.getText().toString();
					if (top.equals(" ") || top == null) {
						btn1.setText(str);
						btn1.setBackgroundResource(R.drawable.btn_background);
						btn4.setText(" ");
						btn4.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (right.equals(" ") || right == null) {
						btn5.setText(str);
						btn5.setBackgroundResource(R.drawable.btn_background);
						btn4.setText(" ");
						btn4.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (bottom.equals(" ") || bottom == null) {
						btn7.setText(str);
						btn7.setBackgroundResource(R.drawable.btn_background);
						btn4.setText(" ");
						btn4.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
					isSolve();
				}
			});
			
		btn5.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn5.getText().toString();
					String top=btn2.getText().toString();
					String left=btn4.getText().toString();
					String right=btn6.getText().toString();
					String bottom=btn8.getText().toString();
					if (top.equals(" ") || top == null) {
						btn2.setText(str);
						btn2.setBackgroundResource(R.drawable.btn_background);
						btn5.setText(" ");
						btn5.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (left.equals(" ") || left == null) {
						btn4.setText(str);
						btn4.setBackgroundResource(R.drawable.btn_background);
						btn5.setText(" ");
						btn5.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (right.equals(" ") || right == null) {
						btn6.setText(str);
						btn6.setBackgroundResource(R.drawable.btn_background);
						btn5.setText(" ");
						btn5.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (bottom.equals(" ") || bottom == null) {
						btn8.setText(str);
						btn8.setBackgroundResource(R.drawable.btn_background);
						btn5.setText(" ");
						btn5.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
					isSolve();
				}
			});
			
		btn6.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn6.getText().toString();
					String top=btn3.getText().toString();
					String left=btn5.getText().toString();
					String bottom=btn9.getText().toString();
					if (top.equals(" ") || top == null) {
						btn3.setText(str);
						btn3.setBackgroundResource(R.drawable.btn_background);
						btn6.setText(" ");
						btn6.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (left.equals(" ") || left == null) {
						btn5.setText(str);
						btn5.setBackgroundResource(R.drawable.btn_background);
						btn6.setText(" ");
						btn6.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (bottom.equals(" ") || bottom == null) {
						btn9.setText(str);
						btn9.setBackgroundResource(R.drawable.btn_background);
						btn6.setText(" ");
						btn6.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
					isSolve();
				}
			});
			
		btn7.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn7.getText().toString();
					String right=btn8.getText().toString();
					String top=btn4.getText().toString();
					if (right.equals(" ") || right == null) {
						btn8.setText(str);
						btn8.setBackgroundResource(R.drawable.btn_background);
						btn7.setText(" ");
						btn7.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (top.equals(" ") || top == null) {
						btn4.setText(str);
						btn4.setBackgroundResource(R.drawable.btn_background);
						btn7.setText(" ");
						btn7.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
					isSolve();
				}
			});
			
		btn8.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn8.getText().toString();
					String top=btn5.getText().toString();
					String left=btn7.getText().toString();
					String right=btn9.getText().toString();
					if (top.equals(" ") || top == null) {
						btn5.setText(str);
						btn5.setBackgroundResource(R.drawable.btn_background);
						btn8.setText(" ");
						btn8.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (left.equals(" ") || left == null) {
						btn7.setText(str);
						btn7.setBackgroundResource(R.drawable.btn_background);
						btn8.setText(" ");
						btn8.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (right.equals(" ") || right == null) {
						btn9.setText(str);
						btn9.setBackgroundResource(R.drawable.btn_background);
						btn8.setText(" ");
						btn8.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
					isSolve();
				}
			});
			
		btn9.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					play();
					String str=btn9.getText().toString();
					String left=btn8.getText().toString();
					String top=btn6.getText().toString();
					if (top.equals(" ") || top == null) {
						btn6.setText(str);
						btn6.setBackgroundResource(R.drawable.btn_background);
						btn9.setText(" ");
						btn9.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					if (left.equals(" ") || left == null) {
						btn8.setText(str);
						btn8.setBackgroundResource(R.drawable.btn_background);
						btn9.setText(" ");
						btn9.setBackgroundResource(R.drawable.btn_empty_background);
						moves++;
					}
					showMoves.setText("Moves: " + Integer.toString(moves).toString());
			    	isSolve();
				}
			});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		menu.add("Hint");
		menu.add("Restart");
		menu.add("About");
		menu.add("Exit");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		// TODO: Implement this method
		String name=item.getTitle().toString();
		switch (name) {
			case "Restart":
				start();
			break;
			case "Hint":
				hint();
			//	Toast.makeText(con, "Hints", Toast.LENGTH_LONG).show();
			break;
			case "About":
				LayoutInflater l=LayoutInflater.from(con);
				View v=l.inflate(R.layout.name_entry, null);
				AlertDialog.Builder d=new AlertDialog.Builder(con);
				d.setView(v);
				d.setNeutralButton("Close", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							// TODO: Implement this method
						}

					
				});
				AlertDialog a=d.create();
				a.show();
			break;
			case "Exit":
				AlertDialog.Builder hint=new AlertDialog.Builder(con).setTitle("Confirm");
			hint.setMessage("Are you sure you want to exit?");
			hint.setPositiveButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface f, int b) {

					}
				});
			hint.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface f, int b) {
						  finish();
						}
			});
			hint.show();
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	public void generate() {
		d=new ProgressDialog(this);
		d.setMessage("Generating...");
		d.setCancelable(false);
		d.show();
		int i=0;
		while (true) {
			int n=(int)(Math.random() * 8) + 1;
			if (i == 0) {
				arr_int[i]=n;
				i++;
			}
			else {
				if (check(i, n)) {
					arr_int[i]=n;
					i++;
				}
			}
			if (i == 8) break;
		}
		d.hide();
	}
	public boolean check(int i, int n) {
		boolean s=true;
		for (int j=0; j<i;j++) {
			if (n == arr_int[j]) {
				s=false;
				break;
			}
		}
		return s;
	}
	
	public void isSolve() {
		boolean solved=true;
		for (int i=0; i<arr.length; i++) {
			if ((!(arr[i].getText().toString().equals(" "))) && (arr[i].getText().toString() != null)) {
		     	if (Integer.parseInt(arr[i].getText().toString()) != (i+1)) {
					solved=false;
				    break;
		    	}
				
			}
		}
		if (solved) {
			AlertDialog.Builder notif=new AlertDialog.Builder(con).setTitle("Congrats");
			notif.setMessage("Contratulations you solved the puzzle in " + Integer.toString(moves) + " moves. Amazing!");
			notif.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface f, int b) {

					}
				});
			notif.show();
			//Toast.makeText(con, "Contratulations you solve the puzzle in " + Integer.toString(moves) + " moves.", Toast.LENGTH_LONG).show();
		}
	}
	public void hint() {
		int board[][] = new int[3][3];
		int count=0;
		String g="";
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				String str=arr[count].getText().toString();
				if ((str.equals(" ")) || str == null) str="0";
				
				g+=str;
				int n=Integer.parseInt(str);
				board[i][j]=n;
				count++;
			}
		}
		// using manhattan distance
		int steps=0;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				int rs=(board[i][j] - 1)/3;
				int cs=(board[i][j] - 1)%3;
				steps+=Math.abs(rs - i) + Math.abs(cs -j);
			}
		}
		AlertDialog.Builder hint=new AlertDialog.Builder(con).setTitle("Hint");
		hint.setMessage("There are " + Integer.toString(steps) + " estimated moves to solve the puzzle!");
		hint.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface f, int b) {
				
			}
		});
	    hint.show();
	}
	public void ini() {
		for (int i=0; i<arr.length; i++) {
			arr[i].setBackgroundResource(R.drawable.btn_background);
		}
	}
	public void play() {
		mp.start();
	}
}
