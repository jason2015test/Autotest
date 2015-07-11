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
	JMenuBar jmb=new JMenuBar();//�����˵�������
	JMenu jm1,jm2,jm3;//�˵�
	JMenuItem jmi1,jmi2,jmi3,jmi4;//�˵���
	JLabel jp_path;
	JTextField jp_pathinput;
	Font f1=new Font("����", Font.PLAIN, 14);
	JButton jp_start,jp_pause,jp_end;
	JTextArea textArea;
	
	String path,caseList,runMethod,para_1,para_2;		
	 
	public static void main(String[] args) {
	   
		FrameMain acl=new FrameMain();
		acl.test();
  
	  }
	
	public void test() {  
		
		//����˵� 
		jm1=new JMenu("�ļ�"); 
		jm2=new JMenu("�༭"); 
		jm3=new JMenu("����"); 

		//��ӵ��˵��� 
		jmb.add(jm1); 
		jmb.add(jm2); 
		jmb.add(jm3); 

		//��Ӳ˵��� 
		jm1.add(jmi1=new JMenuItem("��")); 
		jm1.add(jmi2=new JMenuItem("�˳�")); 
		jm2.add(jmi3=new JMenuItem("����")); 
		jm3.add(jmi4=new JMenuItem("����")); 
		
		//·��
		jp=new JPanel();   
		jp.setLayout(null); 
		jp_pathinput=new JTextField("D:/Autotest"); 
		jp_pathinput.setForeground(Color.LIGHT_GRAY);//������ɫ   
		jp_pathinput.addMouseListener(this); 
		jp_pathinput.setBounds(365, 123, 260, 24); 
		
		jp_path=new JLabel("���԰�·����");   
		jp_path.setFont(f1); 
		jp_path.setForeground(Color.BLUE);   
		jp_path.setBounds(275, 123, 100, 24);
		
		textArea = new JTextArea();
		textArea.setBounds(56, 338, 793, 291);
		
		jp_start=new JButton("��ʼ");
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
		
		jp_pause=new JButton("��ͣ");
		jp_pause.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
						
				path = jp_pathinput.getText();
				System.out.println("Pause" + path);
			}
		});
		jp_pause.setFont(f1);
		jp_pause.setBounds(365, 253, 65, 21);
		
		jp_end=new JButton("ֹͣ");
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
		label.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label.setBounds(399, 23, 100, 24);
		jp.add(label);
						
		jp.add(textArea);
		
		
		JLabel lblLog = new JLabel("\u6D4B\u8BD5\u65E5\u5FD7\uFF1A");
		lblLog.setBounds(57, 313, 120, 15);
		jp.add(lblLog);
		this.setResizable(false);//������Ŵ󣬸ı䴰�ڴ�С��  
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
