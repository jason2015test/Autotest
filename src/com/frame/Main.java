package com.frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Main extends JFrame implements MouseListener{
	//北部区域标签
//	JLabel jlb;
    //中部区域  
	JPanel jp;
//	JComboBox cb;//组合框 设置状态用的 
	JLabel jp_jlb1,jp_jlb3,jp_jlb4,jp_jlb5,jp_jlb6;//标签url、用户名、密码
	JTextField jp_jtf,jp_usn;// url、用户名  
	TextField jp_pw;//密码  
	JCheckBox jp_jcb1,jp_jcb2,jp_jcb3;//复选框
	JRadioButton jrb_1,jrb_2,jrb_3;
	Font f1=new Font("宋体", Font.PLAIN, 14);//设置字体  
	JButton jp_jb1,jp_jb2,jp_jb3;//按钮  
	 
	public static void main(String[] args) {
	   Main acl=new Main();
	  }
	public Main() {  
//		jlb=new JLabel(new ImageIcon("qqshow2_boy.gif")); //图片路径可要根据你放置的位置修改  不然显示不出来 若是和文件放同一个地方 则image/ 可以去掉      
		jp=new JPanel();   
		jp.setLayout(null); 
//		jp_jlb1=new JLabel(new ImageIcon("qqshow2_boy.gif"));   
//		jp_jlb1.setBounds(18, 10, 85, 85); //设置标签位置 前提是要空布局     
		jp_jtf=new JTextField("请输入测试地址"); 
		jp_jtf.setForeground(Color.LIGHT_GRAY);//设置颜色   
		jp_jtf.addMouseListener(this); 
		jp_jtf.setBounds(118, 70, 260, 24); 
		jp_usn=new JTextField("请输入登录账号"); 
		jp_usn.setForeground(Color.LIGHT_GRAY);
		jp_usn.addMouseListener(this);
		jp_usn.setBounds(118, 100, 120, 24);
		jp_pw=new TextField("请输入登录密码",24); 
		jp_pw.setForeground(Color.LIGHT_GRAY);
		jp_pw.addMouseListener(this); 
		jp_pw.setBounds(118, 130, 120, 24);    
		jp_jlb3=new JLabel("测试地址：");   
		jp_jlb3.setFont(f1); 
		jp_jlb3.setForeground(Color.BLUE);   
		jp_jlb3.setBounds(50, 70, 70, 24);
		jp_jlb4=new JLabel("登录账号："); 
		jp_jlb4.setFont(f1);//设置字体 
		jp_jlb4.setForeground(Color.BLUE); //设置字体颜色 
		jp_jlb4.setBounds(50, 100, 70, 24);  
		jp_jlb5=new JLabel("用户密码：");   
		jp_jlb5.setFont(f1); 
		jp_jlb5.setForeground(Color.BLUE);   
		jp_jlb5.setBounds(50, 130, 70, 25);

		jp_jlb6=new JLabel("选择浏览器：");   
		jp_jlb6.setFont(f1); 
		jp_jlb6.setForeground(Color.BLUE);   
		jp_jlb6.setBounds(50, 30, 100, 20);
/*		
		jp_jcb1=new JCheckBox("IE");
		jp_jcb1.setFont(f1);
		jp_jcb1.setBounds(150, 30, 80, 20);
		
		jp_jcb2=new JCheckBox("Chrome");
		jp_jcb2.setFont(f1);
		jp_jcb2.setBounds(230, 30, 80, 20);
		
		jp_jcb3=new JCheckBox("FireFox");
		jp_jcb3.setFont(f1);
		jp_jcb3.setBounds(310, 30, 80, 20);
*/
		
	    ButtonGroup bg=new ButtonGroup();          //创建单选按钮组
	    JRadioButton jrb_1=new JRadioButton("ie");     //创建单选按钮
	    jrb_1.setFont(f1);
		jrb_1.setBounds(140, 30, 80, 20);	
	    JRadioButton jrb_2=new JRadioButton("chrome");
	    jrb_2.setFont(f1);
	    jrb_2.setBounds(220, 30, 80, 20);
	    JRadioButton jrb_3=new JRadioButton("firefox");
	    jrb_3.setFont(f1);
	    jrb_3.setBounds(300, 30, 80, 20);
	    bg.add(jrb_1);                                //把单选按钮添加到组中
	    bg.add(jrb_2);
	    bg.add(jrb_3);	    
	    		
		jp_jb1=new JButton("开始");
		jp_jb1.setFont(f1);
		jp_jb1.setBounds(90, 200, 65, 21);
		jp_jb2=new JButton("暂停");
		jp_jb2.setFont(f1);
		jp_jb2.setBounds(185, 200, 65, 21);
		jp_jb3=new JButton("停止");
		jp_jb3.setFont(f1);
		jp_jb3.setBounds(280, 200, 65, 21); 
		
 
//添加各个组件 
//		jp.add(jp_jlb1);
		jp.add(jp_jtf); 
		jp.add(jp_jlb4);
		jp.add(jp_jlb5);
		jp.add(jp_jlb6);
		jp.add(jp_usn);
		jp.add(jp_pw);   
		jp.add(jp_jlb3);    
//		jp.add(cb); 
		jp.add(jrb_1);   
		jp.add(jrb_2);
		jp.add(jrb_3);
		jp.add(jp_jb1);   
		jp.add(jp_jb2);   
		jp.add(jp_jb3);

//		this.add(jlb,"North");//标签放到最北部 
		this.add(jp,BorderLayout.CENTER);// 放到中部     
//		this.setIconImage(new ImageIcon("image/qq.gif").getImage());//设置窗口上的小图片   
		this.setResizable(false);//不允许放大，改变窗口大小等  
		this.setSize(900,700); 

		this.setLocation(500,200); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		this.setVisible(true); 
		} 
  @Override 
  	public void mouseClicked(MouseEvent e) {
	  // TODO Auto-generated method stub   
	  if(e.getSource()==jp_jtf)   { 
	  	jp_jtf.setText(""); 
	  	jp_jtf.setForeground(Color.BLACK);   
	  	} 
	  else if(e.getSource()==jp_usn)   { 
		jp_usn.setText(""); 
		jp_usn.setForeground(Color.BLACK);   
	  	} 
	  else if(e.getSource()==jp_pw)   { 
		jp_pw.setText(""); 
		jp_pw.setForeground(Color.BLACK);    
		jp_pw.setEchoChar('●');   
		}     
	  } 
  @Override 
  	public void mousePressed(MouseEvent e) {
	  // TODO Auto-generated method stub      
  	}
  @Override 
  	public void mouseReleased(MouseEvent e) {
	  // TODO Auto-generated method stub     
	} 
  @Override 
 	public void mouseEntered(MouseEvent e) {
	  // TODO Auto-generated method stub      
  	}
  @Override 
 	public void mouseExited(MouseEvent e) {
	  // TODO Auto-generated method stub     
  }
}
