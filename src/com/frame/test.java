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
	//���������ǩ
//	JLabel jlb;
    //�в�����  
	JPanel jp;
//	JComboBox cb;//��Ͽ� ����״̬�õ� 
	JMenuBar jmb=new JMenuBar();//�����˵�������
	JMenu jm1,jm2,jm3;//�˵�
	JMenuItem jmi1,jmi2,jmi3,jmi4;//�˵���
	JLabel jp_jlb1,jp_jlb3,jp_jlb4,jp_jlb5,jp_jlb6;//��ǩurl���û���������
	JTextField jp_jtf,jp_usn;// url���û���  
	TextField jp_pw;//����  
	JCheckBox jp_jcb1,jp_jcb2,jp_jcb3;//��ѡ��
	JRadioButton jrb_1,jrb_2,jrb_3;
	Font f1=new Font("����", Font.PLAIN, 14);//��������  
	JButton jp_jb1,jp_jb2,jp_jb3;//��ť  
	JTextArea textArea;
		
	String browser,url,username,password;
	
	 
	public static void main(String[] args) {
	   
		test acl=new test();
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
		
		
//		jlb=new JLabel(new ImageIcon("qqshow2_boy.gif")); //ͼƬ·����Ҫ��������õ�λ���޸�  ��Ȼ��ʾ������ ���Ǻ��ļ���ͬһ���ط� ��image/ ����ȥ��      
		jp=new JPanel();   
		jp.setLayout(null); 
//		jp_jlb1=new JLabel(new ImageIcon("qqshow2_boy.gif"));   
//		jp_jlb1.setBounds(18, 10, 85, 85); //���ñ�ǩλ�� ǰ����Ҫ�ղ���     
		jp_jtf=new JTextField(""); 
		jp_jtf.setForeground(Color.LIGHT_GRAY);//������ɫ   
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
		jp_jlb3=new JLabel("���Ե�ַ��");   
		jp_jlb3.setFont(f1); 
		jp_jlb3.setForeground(Color.BLUE);   
		jp_jlb3.setBounds(275, 123, 70, 24);
		jp_jlb4=new JLabel("��¼�˺ţ�"); 
		jp_jlb4.setFont(f1);//�������� 
		jp_jlb4.setForeground(Color.BLUE); //����������ɫ 
		jp_jlb4.setBounds(275, 153, 70, 24);  
		jp_jlb5=new JLabel("�û����룺");   
		jp_jlb5.setFont(f1); 
		jp_jlb5.setForeground(Color.BLUE);   
		jp_jlb5.setBounds(275, 183, 70, 25);

		jp_jlb6=new JLabel("ѡ���������");   
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
		
	    ButtonGroup bg=new ButtonGroup();          //������ѡ��ť��
	    final JRadioButton jrb_1=new JRadioButton("ie");     //������ѡ��ť
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
	    bg.add(jrb_1);                                //�ѵ�ѡ��ť��ӵ�����
	    bg.add(jrb_2);
	    bg.add(jrb_3);	    
	    //�����ύ��ť�¼�
		jp_jb1=new JButton("��ʼ");
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
		jp_jb2=new JButton("��ͣ");
		jp_jb2.setFont(f1);
		jp_jb2.setBounds(365, 253, 65, 21);
		jp_jb3=new JButton("ֹͣ");
		jp_jb3.setFont(f1);
		jp_jb3.setBounds(538, 253, 65, 21); 
		
 
//��Ӹ������ 
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

//		this.add(jlb,"North");//��ǩ�ŵ���� 
		getContentPane().add(jp,BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u81EA\u52A8\u5316\u6D4B\u8BD5");
		label.setForeground(Color.RED);
		label.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label.setBounds(399, 23, 100, 24);
		jp.add(label);
		
		textArea = new JTextArea();
		textArea.setBounds(56, 338, 793, 291);
				
		
		jp.add(textArea);
		
		
		JLabel lblLog = new JLabel("\u6D4B\u8BD5\u65E5\u5FD7\uFF1A");
		lblLog.setBounds(57, 313, 120, 15);
		jp.add(lblLog);
//		this.setIconImage(new ImageIcon("image/qq.gif").getImage());//���ô����ϵ�СͼƬ   
		this.setResizable(false);//������Ŵ󣬸ı䴰�ڴ�С��  
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
		jp_pw.setEchoChar('��');   
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
