package com.frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Main extends JFrame implements MouseListener{
	//���������ǩ
//	JLabel jlb;
    //�в�����  
	JPanel jp;
//	JComboBox cb;//��Ͽ� ����״̬�õ� 
	JLabel jp_jlb1,jp_jlb3,jp_jlb4,jp_jlb5,jp_jlb6;//��ǩurl���û���������
	JTextField jp_jtf,jp_usn;// url���û���  
	TextField jp_pw;//����  
	JCheckBox jp_jcb1,jp_jcb2,jp_jcb3;//��ѡ��
	JRadioButton jrb_1,jrb_2,jrb_3;
	Font f1=new Font("����", Font.PLAIN, 14);//��������  
	JButton jp_jb1,jp_jb2,jp_jb3;//��ť  
	 
	public static void main(String[] args) {
	   Main acl=new Main();
	  }
	public Main() {  
//		jlb=new JLabel(new ImageIcon("qqshow2_boy.gif")); //ͼƬ·����Ҫ��������õ�λ���޸�  ��Ȼ��ʾ������ ���Ǻ��ļ���ͬһ���ط� ��image/ ����ȥ��      
		jp=new JPanel();   
		jp.setLayout(null); 
//		jp_jlb1=new JLabel(new ImageIcon("qqshow2_boy.gif"));   
//		jp_jlb1.setBounds(18, 10, 85, 85); //���ñ�ǩλ�� ǰ����Ҫ�ղ���     
		jp_jtf=new JTextField("��������Ե�ַ"); 
		jp_jtf.setForeground(Color.LIGHT_GRAY);//������ɫ   
		jp_jtf.addMouseListener(this); 
		jp_jtf.setBounds(118, 70, 260, 24); 
		jp_usn=new JTextField("�������¼�˺�"); 
		jp_usn.setForeground(Color.LIGHT_GRAY);
		jp_usn.addMouseListener(this);
		jp_usn.setBounds(118, 100, 120, 24);
		jp_pw=new TextField("�������¼����",24); 
		jp_pw.setForeground(Color.LIGHT_GRAY);
		jp_pw.addMouseListener(this); 
		jp_pw.setBounds(118, 130, 120, 24);    
		jp_jlb3=new JLabel("���Ե�ַ��");   
		jp_jlb3.setFont(f1); 
		jp_jlb3.setForeground(Color.BLUE);   
		jp_jlb3.setBounds(50, 70, 70, 24);
		jp_jlb4=new JLabel("��¼�˺ţ�"); 
		jp_jlb4.setFont(f1);//�������� 
		jp_jlb4.setForeground(Color.BLUE); //����������ɫ 
		jp_jlb4.setBounds(50, 100, 70, 24);  
		jp_jlb5=new JLabel("�û����룺");   
		jp_jlb5.setFont(f1); 
		jp_jlb5.setForeground(Color.BLUE);   
		jp_jlb5.setBounds(50, 130, 70, 25);

		jp_jlb6=new JLabel("ѡ���������");   
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
		
	    ButtonGroup bg=new ButtonGroup();          //������ѡ��ť��
	    JRadioButton jrb_1=new JRadioButton("ie");     //������ѡ��ť
	    jrb_1.setFont(f1);
		jrb_1.setBounds(140, 30, 80, 20);	
	    JRadioButton jrb_2=new JRadioButton("chrome");
	    jrb_2.setFont(f1);
	    jrb_2.setBounds(220, 30, 80, 20);
	    JRadioButton jrb_3=new JRadioButton("firefox");
	    jrb_3.setFont(f1);
	    jrb_3.setBounds(300, 30, 80, 20);
	    bg.add(jrb_1);                                //�ѵ�ѡ��ť��ӵ�����
	    bg.add(jrb_2);
	    bg.add(jrb_3);	    
	    		
		jp_jb1=new JButton("��ʼ");
		jp_jb1.setFont(f1);
		jp_jb1.setBounds(90, 200, 65, 21);
		jp_jb2=new JButton("��ͣ");
		jp_jb2.setFont(f1);
		jp_jb2.setBounds(185, 200, 65, 21);
		jp_jb3=new JButton("ֹͣ");
		jp_jb3.setFont(f1);
		jp_jb3.setBounds(280, 200, 65, 21); 
		
 
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
		this.add(jp,BorderLayout.CENTER);// �ŵ��в�     
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
