package frame;

import bean.lessee;
import dao.ManageHelper;
import util.Tools;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

//����⻧����
public class AddlesseeFrame extends JDialog{//JDialog����
	 	private JButton add_Button;	//"���"��ť��
	    private JButton cancel_Button;	//"ȡ��"��ť��
	    private JComboBox sex_Box;	//"�Ա�"ѡ�
	    private JLabel lessee_ID;    //"���"��ǩ��
	    private JLabel lessee_Name;	//"����"��ǩ��
	    private JLabel sex_Label;	//"�Ա�"��ǩ��
	    private JLabel age_Label;	//"�����ǩ"��
	    private JLabel time_Label;	//"ʱ��"��ǩ��
	    private JLabel rent_Label;	//"���"��ǩ��
	    private JTextField lessee_IDText;	//"���"�ı���
	    private JTextField lessee_NameText;	//"����"�ı���
	    private JTextField age_Box;	//"����"�ı���
	    private JTextField rentText; //����ı���
	    private JTextField time_Text;  //ʱ���ı���
	    private JDialog jd;	//��ǰ���ڡ�
	    private ManageHelper helper;	//���ݿ�ҵ�������
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public AddlesseeFrame(JFrame owner, String title, boolean modal){
		super(owner, title, modal);
		helper = new ManageHelper();	//�������ݿ�ҵ�������

		this.jd = this;
		this.setSize(350,429);	//���ô����С��
		this.setLayout(null);	//���ÿղ��֡�
		
		lessee_ID = new JLabel("���:");
		lessee_ID.setBounds(78, 48, 30, 20);	
		this.add(lessee_ID);	
		
		lessee_IDText = new JTextField();
		lessee_IDText.setBounds(116, 48, 150, 20);
		this.add(lessee_IDText);
		
		lessee_Name = new JLabel("����:");
		lessee_Name.setBounds(78, 88, 30, 20);
		this.add(lessee_Name);
		
		
		lessee_NameText = new JTextField();
		lessee_NameText.setBounds(116, 88, 150, 20);
		this.add(lessee_NameText);
		
		sex_Label = new JLabel("�Ա�:");
		sex_Label.setBounds(78, 128, 30, 20);
		this.add(sex_Label);
		
		sex_Box = new JComboBox(new String[]{"","��","Ů"});
		sex_Box.setBounds(116, 128, 60, 20);
		this.add(sex_Box);

		age_Label = new JLabel("����:");
		age_Label.setBounds(78, 168, 30, 20);
		this.add(age_Label);
		
		age_Box = new JTextField();
		age_Box.setBounds(116, 168, 150, 20);
		this.add(age_Box);


		rent_Label = new JLabel("���:");
		rent_Label.setBounds(78, 208, 30, 20);
		this.add(rent_Label);

		rentText = new JTextField();
		rentText.setBounds(116, 208, 150, 20);
		this.add(rentText);

		time_Label = new JLabel("ʱ��:");
		time_Label.setBounds(78, 248, 30, 20);
		this.add(time_Label);

		time_Text = new JTextField();
		time_Text.setBounds(116, 248, 150, 20);
		this.add(time_Text);
		
		add_Button = new JButton("���");
		add_Button.setBounds(70, 330, 60, 25);
		
		//ע��"ȷ��"��ť�¼�����
		add_Button.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				lessee _lessee = new lessee();
				String sid = lessee_IDText.getText().trim();
				String name = lessee_NameText.getText().trim();
				String sex = sex_Box.getSelectedItem().toString();
				String age = age_Box.getText().trim();
				String rent = rentText.getText().trim();
				String time = time_Text.getText().trim();
				//����У�鲿��
				if(sid.equals("")){
					JOptionPane.showMessageDialog(jd, "��Ų���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(name.equals("")){
					JOptionPane.showMessageDialog(jd, "��������Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(sex.equals("")){
					JOptionPane.showMessageDialog(jd, "�Ա���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(age.equals("")){
					JOptionPane.showMessageDialog(jd, "���䲻��Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(rent.equals("")){	//�ȼ������
					JOptionPane.showMessageDialog(jd, "�����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(time.equals("")){
					JOptionPane.showMessageDialog(jd, "ʱ�䲻��Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				_lessee.setLesseeID(sid);
				_lessee.setLesseeNAME(name);
				_lessee.setLesseeSEX(sex);
				_lessee.setLesseeAGE(age);
				_lessee.setlesseeMoney(rent);
				_lessee.setlesseetime(time);
				if(helper.addlessee(_lessee)){
					JOptionPane.showMessageDialog(jd, "��ӳɹ���");
					jd.dispose();	//�رյ�ǰ����
					return ;
				}else{
					JOptionPane.showMessageDialog(jd, "���ʧ�ܣ�", "", JOptionPane.WARNING_MESSAGE);
					jd.dispose();	//�رյ�ǰ����
					return ;
				}
				
				
			}
		});
		this.add(add_Button);
		
		cancel_Button = new JButton("ȡ��");
		cancel_Button.setBounds(230, 330, 60, 25);
		//ע��"ȡ��"��ť�¼�����
		cancel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jd.dispose();
				
			}
		});
		this.add(cancel_Button);
		
		WindowUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setVisible(true);
	}
}
