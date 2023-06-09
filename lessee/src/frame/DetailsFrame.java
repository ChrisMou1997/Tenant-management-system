package frame;


import model.lesseemodel;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//��ϸ��Ϣ����
public class DetailsFrame extends JDialog{
	private JButton confirm_Button;	//"ȷ��"��ť��
    private JTextField sex_Text;	//"�Ա�"ѡ�
    private JTextField time_Text;	//"ʱ��"ѡ�
    private JTextField rent_Text;	//"���"ѡ�
    private JLabel lessee_ID;  //"���"��ǩ��
    private JLabel lessee_Name;	//"����"��ǩ��
    private JLabel sex_Label;	//"�Ա�"��ǩ��
    private JLabel age_Label;	//"�����ǩ"��
    private JLabel time_Label;	//"ʱ��"��ǩ��
    private JLabel rent_Label;	//"���"��ǩ��
    private JTextField lessee_IDText;	//"���"�ı���
    private JTextField lessee_NameText;	//"����"�ı���
    private JTextField age_Text;	//"����"�ı���
    private lesseemodel sm;	//������⻧����ģ��
    private JDialog jd;	//��ǰ���ڡ�
/**
 * 
 * @param owner ���ĸ�����
 * @param title ������
 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
 */
public DetailsFrame(JDialog owner, String title, boolean modal, int rowNum, lesseemodel sm){
	super(owner, title, modal);
	this.sm = sm;	//�����⻧����ģ��
	this.jd = this;
	this.setSize(350,429);	//���ô����С��
	this.setLayout(null);	//���ÿղ��֡�
	
	lessee_ID = new JLabel("���:");
	lessee_ID.setBounds(78, 48, 30, 20);	
	this.add(lessee_ID);	
	
	lessee_IDText = new JTextField();
	lessee_IDText.setEditable(false);	//���ɱ༭
	lessee_IDText.setText(sm.getValueAt(rowNum, 0).toString());	//��ȡ��Ų���ʾ
	lessee_IDText.setBounds(116, 48, 150, 20);
	this.add(lessee_IDText);
	
	lessee_Name = new JLabel("����:");
	lessee_Name.setBounds(78, 88, 30, 20);
	this.add(lessee_Name);
	
	
	lessee_NameText = new JTextField();
	lessee_NameText.setBounds(116, 88, 150, 20);
	lessee_NameText.setEditable(false);//���ɱ༭
	lessee_NameText.setText(sm.getValueAt(rowNum, 2).toString());	//�����⻧��������ʾ
	this.add(lessee_NameText);
	
	sex_Label = new JLabel("�Ա�:");
	sex_Label.setBounds(78, 128, 30, 20);
	this.add(sex_Label);
	
	sex_Text = new JTextField();
	sex_Text.setBounds(116, 128, 60, 20);
	sex_Text.setEditable(false);//���ɱ༭
	sex_Text.setText(sm.getValueAt(rowNum, 1).toString());	//�����⻧�Ա���ʾ
	this.add(sex_Text);
	
	age_Label = new JLabel("����:");
	age_Label.setBounds(78, 168, 30, 20);
	this.add(age_Label);
	
	age_Text = new JTextField();
	age_Text.setBounds(116, 168, 150, 20);
	age_Text.setEditable(false);
	age_Text.setText(sm.getValueAt(rowNum, 3).toString());	//�����⻧���䲢��ʾ
	this.add(age_Text);
		
	rent_Label = new JLabel("���:");
	rent_Label.setBounds(78, 208, 30, 20);
	
	this.add(rent_Label);
	
	rent_Text = new JTextField();
	rent_Text.setEditable(false);
	rent_Text.setText(sm.getValueAt(rowNum, 4).toString());
	rent_Text.setBounds(116, 208, 150, 20);
	this.add(rent_Text);

	time_Label = new JLabel("ʱ��:");

	time_Label.setBounds(78, 248, 30, 20);
	this.add(time_Label);
	
	time_Text = new JTextField();
	time_Text.setEditable(false);
	time_Text.setBounds(116, 248, 150, 20);
	time_Text.setText(sm.getValueAt(rowNum, 5).toString());
	this.add(time_Text);
	
	confirm_Button = new JButton("ȷ��");
	//ע��"ȷ��"��ť�¼�����
	confirm_Button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jd.dispose();//�رյ�ǰ����
		}
	});
	confirm_Button.setBounds(150, 330, 60, 25);
	
	this.add(confirm_Button);

	
	WindowUtil.setFrameCenter(this);
	this.setResizable(false);
	this.setVisible(true);
	}
}
