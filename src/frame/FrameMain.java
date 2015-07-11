package frame;

import java.awt.*;
//import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tests.test;

public class FrameMain extends JFrame implements MouseListener{


	JPanel jp;
	JMenuBar jmb=new JMenuBar();//创建菜单条对象
	JMenu jm1,jm2,jm3;//菜单
	JMenuItem jmi1,jmi2,jmi3,jmi4;//菜单项
	JLabel jp_path;
	JTextField jp_pathinput;
	Font f1=new Font("宋体", Font.PLAIN, 14);
	JButton jp_start,jp_pause,jp_end;
	JTextArea textArea;
	
	String path,caseList,runMethod,para_1,para_2;		
	 
	public static void main(String[] args) {
	   
		FrameMain acl=new FrameMain();
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
		
		//路径
		jp=new JPanel();   
		jp.setLayout(null); 
		jp_pathinput=new JTextField("D:/Autotest"); 
		jp_pathinput.setForeground(Color.LIGHT_GRAY);//设置颜色   
		jp_pathinput.addMouseListener(this); 
		jp_pathinput.setBounds(365, 123, 260, 24); 
		
		jp_path=new JLabel("测试包路径：");   
		jp_path.setFont(f1); 
		jp_path.setForeground(Color.BLUE);   
		jp_path.setBounds(275, 123, 100, 24);
		
		textArea = new JTextArea();
		textArea.setBounds(56, 338, 793, 291);
		
		jp_start=new JButton("开始");
		jp_start.addActionListener(new ActionListener() {
						
			public void actionPerformed(ActionEvent arg0) {
						
				path = jp_pathinput.getText();
				test a = new test();
				try {
					a.testcase();
				} catch(Exception e){
					
				}
				System.out.println("Start" + path);
			}
		});
		jp_start.setFont(f1);
		jp_start.setBounds(275, 253, 65, 21);
		
		jp_pause=new JButton("暂停");
		jp_pause.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
						
				path = jp_pathinput.getText();
				System.out.println("Pause" + path);
			}
		});
		jp_pause.setFont(f1);
		jp_pause.setBounds(365, 253, 65, 21);
		
		jp_end=new JButton("停止");
		jp_end.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
						
				path = jp_pathinput.getText();
				System.out.println("end" + path);
			}
		});
		jp_end.setFont(f1);
		jp_end.setBounds(538, 253, 65, 21); 
		
 		jp.add(jp_pathinput); 
		jp.add(jp_path);    
		jp.add(jp_start);   
		jp.add(jp_pause);   
		jp.add(jp_end);

		getContentPane().add(jp,BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u81EA\u52A8\u5316\u6D4B\u8BD5");
		label.setForeground(Color.RED);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label.setBounds(399, 23, 100, 24);
		jp.add(label);
						
		jp.add(textArea);
		
		
		JLabel lblLog = new JLabel("\u6D4B\u8BD5\u65E5\u5FD7\uFF1A");
		lblLog.setBounds(57, 313, 120, 15);
		jp.add(lblLog);
		this.setResizable(false);//不允许放大，改变窗口大小等  
		this.setSize(900,700); 

		this.setLocation(500,200); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		this.setVisible(true); 
		} 
	
	@Override 
  	public void mouseClicked(MouseEvent e) {
	  // TODO Auto-generated method stub   
	  if(e.getSource()==jp_pathinput)   { 
		 jp_pathinput.setText(""); 
		 jp_pathinput.setForeground(Color.BLACK);     
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
