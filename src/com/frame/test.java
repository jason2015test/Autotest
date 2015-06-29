package com.frame;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.testmain.TestMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test extends JFrame implements MouseListener{
	public test() {
	}
	//北部区域标签
//	JLabel jlb;
    //中部区域  
	JPanel jp;
//	JComboBox cb;//组合框 设置状态用的 
	JMenuBar jmb=new JMenuBar();//创建菜单条对象
	JMenu jm1,jm2,jm3;//菜单
	JMenuItem jmi1,jmi2,jmi3,jmi4;//菜单项
	JLabel jp_jlb1,jp_jlb3,jp_jlb4,jp_jlb5,jp_jlb6;//标签url、用户名、密码
	JTextField jp_jtf,jp_usn;// url、用户名  
	TextField jp_pw;//密码  
	JCheckBox jp_jcb1,jp_jcb2,jp_jcb3;//复选框
	JRadioButton jrb_1,jrb_2,jrb_3;
	Font f1=new Font("宋体", Font.PLAIN, 14);//设置字体  
	JButton jp_jb1,jp_jb2,jp_jb3;//按钮  
	JTextArea textArea;
		
	String browser,url,username,password;
	
	 
	public static void main(String[] args) {
	   
		test acl=new test();
		acl.test();
		
  
	  }
	
	public void test() {  
		
		//定义菜单 
		jm1=new JMenu("文件"); 
		jm2=new JMenu("编辑"); 
		jm3=new JMenu("帮助"); 

		//添加到菜单条 
		jmb.add(jm1); 
		jmb.add(jm2); 
		jmb.add(jm3); 

		//添加菜单项 
		jm1.add(jmi1=new JMenuItem("打开")); 
		jm1.add(jmi2=new JMenuItem("退出")); 
		jm2.add(jmi3=new JMenuItem("复制")); 
		jm3.add(jmi4=new JMenuItem("关于")); 
		
		
//		jlb=new JLabel(new ImageIcon("qqshow2_boy.gif")); //图片路径可要根据你放置的位置修改  不然显示不出来 若是和文件放同一个地方 则image/ 可以去掉      
		jp=new JPanel();   
		jp.setLayout(null); 
//		jp_jlb1=new JLabel(new ImageIcon("qqshow2_boy.gif"));   
//		jp_jlb1.setBounds(18, 10, 85, 85); //设置标签位置 前提是要空布局     
		jp_jtf=new JTextField(""); 
		jp_jtf.setForeground(Color.LIGHT_GRAY);//设置颜色   
		jp_jtf.addMouseListener(this); 
		jp_jtf.setBounds(343, 123, 260, 24); 
		jp_usn=new JTextField(""); 
		jp_usn.setForeground(Color.LIGHT_GRAY);
		jp_usn.addMouseListener(this);
		jp_usn.setBounds(343, 153, 120, 24);
		jp_pw=new TextField("",24); 
		jp_pw.setForeground(Color.LIGHT_GRAY);
		jp_pw.addMouseListener(this); 
		jp_pw.setBounds(343, 183, 120, 24);    
		jp_jlb3=new JLabel("测试地址：");   
		jp_jlb3.setFont(f1); 
		jp_jlb3.setForeground(Color.BLUE);   
		jp_jlb3.setBounds(275, 123, 70, 24);
		jp_jlb4=new JLabel("登录账号："); 
		jp_jlb4.setFont(f1);//设置字体 
		jp_jlb4.setForeground(Color.BLUE); //设置字体颜色 
		jp_jlb4.setBounds(275, 153, 70, 24);  
		jp_jlb5=new JLabel("用户密码：");   
		jp_jlb5.setFont(f1); 
		jp_jlb5.setForeground(Color.BLUE);   
		jp_jlb5.setBounds(275, 183, 70, 25);

		jp_jlb6=new JLabel("选择浏览器：");   
		jp_jlb6.setFont(f1); 
		jp_jlb6.setForeground(Color.BLUE);   
		jp_jlb6.setBounds(275, 83, 100, 20);
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
	    final JRadioButton jrb_1=new JRadioButton("ie");     //创建单选按钮
	    jrb_1.setFont(f1);
		jrb_1.setBounds(365, 83, 80, 20);	
		jrb_1.setActionCommand("ie");
		
	    final JRadioButton jrb_2=new JRadioButton("chrome");
	    jrb_2.setFont(f1);
	    jrb_2.setBounds(445, 83, 80, 20);
	    jrb_2.setActionCommand("chrome");
	    final JRadioButton jrb_3=new JRadioButton("firefox");
	    jrb_3.setFont(f1);
	    jrb_3.setBounds(525, 83, 80, 20);
	    jrb_3.setActionCommand("firefox");
	    bg.add(jrb_1);                                //把单选按钮添加到组中
	    bg.add(jrb_2);
	    bg.add(jrb_3);	    
	    //监听提交按钮事件
		jp_jb1=new JButton("开始");
		jp_jb1.addActionListener(new ActionListener() {
						

			
			public void actionPerformed(ActionEvent arg0) {
				
				if(jrb_1.isSelected())
					browser = "ie";
				
				else if(jrb_2.isSelected())
					browser = "chrome";
				else if(jrb_3.isSelected())
					browser = "firefox";
			
				System.out.println(browser);
				
				url = jp_jtf.getText();
				username = jp_usn.getText();
				password = jp_pw.getText();
				
				TestMain a = new TestMain();
				
//				a.test(browser,url,username,password);
								
			}
		});
		jp_jb1.setFont(f1);
		jp_jb1.setBounds(275, 253, 65, 21);
		jp_jb2=new JButton("暂停");
		jp_jb2.setFont(f1);
		jp_jb2.setBounds(365, 253, 65, 21);
		jp_jb3=new JButton("停止");
		jp_jb3.setFont(f1);
		jp_jb3.setBounds(538, 253, 65, 21); 
		
 
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
		getContentPane().add(jp,BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u81EA\u52A8\u5316\u6D4B\u8BD5");
		label.setForeground(Color.RED);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label.setBounds(399, 23, 100, 24);
		jp.add(label);
		
		textArea = new JTextArea();
		textArea.setBounds(56, 338, 793, 291);
				
		
		jp.add(textArea);
		
		
		JLabel lblLog = new JLabel("\u6D4B\u8BD5\u65E5\u5FD7\uFF1A");
		lblLog.setBounds(57, 313, 120, 15);
		jp.add(lblLog);
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
	
	public void addLog(String log){
		textArea.append(log);
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
