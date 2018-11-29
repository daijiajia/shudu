package supsudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class supsudoku extends JFrame{
	static int a;
	static int b;
	public void play(int level[][]){
	
		JFrame win2=new JFrame();//第二个窗口，既playing
		this.setSize(600,600);
		JPanel panel_p = new JPanel(new GridLayout(9,9,10,10));
		//JButton[][] bu=new JButton[9][9];

		for(int c=0;c<=8;c++){
			for(int cc=0;cc<=8;cc++){
				a+=level[c][cc];
				
				JButton bu=new JButton(""+level[c][cc]);//创建81个键空的即为0
				if(bu.getText().equals("0")){
					bu.setForeground(Color.WHITE);
				}
				panel_p.add(bu);
				bu.addActionListener(new ActionListener(){//打开一个选择数字的窗口
					@Override
					public void actionPerformed(ActionEvent ae) {
						// TODO Auto-generated method stub
					String kong=bu.getText();
					if(kong.equals("0")){
						
					
					JFrame choose=new JFrame();
					
					choose.setSize(300,120);
					String [] choose_n = new String [9];
					for(int i=0;i<9;i++){
						choose_n[i]=""+(i+1);
					}
					JComboBox ch=new JComboBox(choose_n);//选择数字
					JButton no=new JButton("no");
					no.addActionListener(new ActionListener(){//取消键功能的实现
						@Override
						public void actionPerformed(ActionEvent e){
							choose.dispose();
						}
					});
					
					JButton yes=new JButton("yes");
					yes.addActionListener(new ActionListener(){//确定键功能的实现
						@Override
						public void actionPerformed(ActionEvent e){
							String num =ch.getSelectedItem().toString();
						
							//level[c][cc]=Integer.parseInt(num) ;
							//System.out.print(a);
							a-=Integer.parseInt(bu.getText());
							bu.setText(num);//把数字写到键的text
							bu.setForeground(Color.BLUE);
							a+=Integer.parseInt(num);
							choose.dispose();//关闭选择数字的窗口
							if(a==405){//如果输入完全正确，跳出窗口
							JFrame win=new JFrame();
							win.setSize(300,200);
							JPanel wi=new JPanel();
							JTextField text3=new JTextField("you win!");
							text3.setForeground(Color.red);
							text3.setBounds(1, 1,100,100);
							
							text3.setEditable(false);
							wi.add(text3);
							win.add(wi);
							win.setVisible(true);}
							
						}
					}
					);
					choose.setVisible(true);
					JPanel panel4 = new JPanel(new GridLayout(1,2));
					panel4.add(no);
					panel4.add(yes);
					JPanel panel3 = new JPanel(new BorderLayout());
					JTextField text1=new JTextField("enter a number");
					text1.setEditable(false);
					panel3.add(text1,BorderLayout.NORTH);
					panel3.add(ch,BorderLayout.CENTER);
					panel3.add(panel4,BorderLayout.SOUTH);
					choose.add(panel3);
			
					}
					else{//如果想改变数独中原有的数字，则会阻止
						JFrame don=new JFrame();
						JPanel on=new JPanel(new BorderLayout());
						don.setSize(300, 200);
						JTextField text4=new JTextField("you can't change the number!!!");
						text4.setForeground(Color.red);
						text4.setEditable(false);
						JButton ok=new JButton("ok");
						
						ok.addActionListener(new ActionListener(){//取消键功能的实现
							@Override
							public void actionPerformed(ActionEvent e){
								don.dispose();
							}
						});
						on.add(text4,BorderLayout.CENTER);
						on.add(ok,BorderLayout.SOUTH);
						don.add(on);
						don.setVisible(true);
					}
					
					}
				});
				
				
				

		}
		}
		this.setTitle("playing");
		this.setContentPane(panel_p);
				
		}

	public int key[][]=//答案的数独
			{{8,3,7,4,6,1,5,2,9},
			{5,4,1,9,2,8,7,3,6},
			{2,6,9,5,3,7,4,1,8},
			{9,5,4,6,8,3,2,7,1},
			{7,2,8,1,9,5,3,6,4},
			{3,1,6,7,4,2,8,9,5},
			{4,7,5,3,1,9,6,8,2},
			{1,8,3,2,5,6,9,4,7},
			{6,9,2,8,7,4,1,5,3}};

	public supsudoku(){
		JFrame x=new JFrame();//开始界面的窗口
		this.setSize(300,90);
		this.setTitle("supsudokku");

		String[] levels={"easy","medium","hard"}; 
		JComboBox le=new JComboBox(levels);
			
		
		
		
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel(new BorderLayout());
		//JPanel panel3 = new JPanel(new GridLayout(9,9,10,10));//第一个窗口
		panel.add(panel2,BorderLayout.NORTH);
		JTextField text2=new JTextField("choose your level");
		
		text2.setEditable(false);
		JTextField text3=new JTextField("attention:change 0 to the true number");
		text3.setForeground(Color.red);
		text3.setEditable(false);
		panel2.add(text2,BorderLayout.WEST);	
		panel2.add(text3,BorderLayout.SOUTH);	
		panel2.add(le,BorderLayout.CENTER);
		
		x.add(panel);
		JButton gen=new JButton("generate");//gen键的功能
		panel2.add(gen,BorderLayout.EAST);
		gen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String level =le.getSelectedItem().toString();
				if(level.equals("easy")){
					int id[][]=
						{{8,3,7,4,6,1,5,2,9},
						{5,4,1,9,2,8,7,3,6},
						{2,6,9,5,3,7,4,1,8},
						{9,5,0,6,8,3,2,7,1},
						{0,2,8,1,0,5,0,6,4},
						{3,1,6,7,4,0,8,9,5},
						{0,7,0,3,1,9,6,0,2},
						{1,0,3,2,5,6,9,4,7},
						{6,9,2,0,7,0,1,5,3}};
					play(id);
				
				}
				else if(level.equals("medium")){
					int id[][]=
						{{8,3,7,4,6,1,5,2,9},
						{5,0,1,9,2,8,7,3,6},
						{2,6,9,5,0,7,4,1,8},
						{9,5,0,6,8,0,2,7,1},
						{0,2,8,1,0,5,0,6,4},
						{3,1,6,7,4,0,8,9,0},
						{0,7,0,3,1,9,6,0,2},
						{1,0,3,2,5,6,9,4,7},
						{6,9,2,0,7,0,1,5,3}};
					play(id);
				}
				else if(level.equals("hard")){
					int id[][]=
						{{0,0,0,4,0,1,5,0,9},
						{5,0,1,9,2,0,7,0,6},
						{2,6,9,5,0,7,4,1,8},
						{9,0,0,6,8,0,2,0,1},
						{0,2,8,1,0,5,0,6,4},
						{3,1,0,7,4,0,8,9,0},
						{0,7,0,3,0,9,6,0,2},
						{1,0,3,0,5,6,0,4,7},
						{0,9,0,0,7,0,1,5,0}};
					play(id);

				}
	
			}
		});this.setContentPane(panel);}
	}
		
