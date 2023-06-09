package frame;


import bean.lessee;
import dao.ManageHelper;
import model.lesseemodel;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�޸��⻧��Ϣ����
public class ModifyFrame extends JDialog{
 	private JButton modify_Button;	//"�޸�"��ť��
    private JButton cancel_Button;	//"ȡ��"��ť��
    private JComboBox sex_Box;	//"�Ա�"ѡ�
    private JLabel lessee_ID; //"���"��ǩ��
    private JLabel lessee_Name;	//"����"��ǩ��
    private JLabel sex_Label;	//"�Ա�"��ǩ��
    private JLabel age_Label;	//"�����ǩ"��
	private JTextField age_Text;	//"���"�ı���
    private JLabel time_Label;	//"ʱ��"��ǩ��
	private JTextField time_Text;	//"ʱ��"�ı���
    private JLabel rent_Label;	//"���"��ǩ��
	private JTextField rent_Text;	//"���"�ı���
    private JTextField lessee_IDText;	//"���"�ı���
    private JTextField lessee_NameText;	//"����"�ı���
    private JDialog jd;	//��ǰ���ڡ�
    private lesseemodel sm;	//�⻧����ģ�Ͷ���
	private ManageHelper helper;
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public ModifyFrame(JDialog owner, String title, boolean modal, int rowNum, lesseemodel sm){
		super(owner, title, modal);
		helper = new ManageHelper();	//�������ݿ�ҵ�������
		this.jd = this;
		this.sm = sm;
		this.setSize(350,429);	//���ô����С��
		this.setLayout(null);	//���ÿղ��֡�
		//��ȡ��Ϣ
		String lessee_id = sm.getValueAt(rowNum, 0).toString();
		String lessee_name = sm.getValueAt(rowNum, 2).toString();
		String lessee_sex = sm.getValueAt(rowNum, 1).toString();
		String lessee_age = sm.getValueAt(rowNum, 3).toString();
		String lessee_rent = sm.getValueAt(rowNum, 4).toString();
		String lessee_time = sm.getValueAt(rowNum,5).toString();
		lessee_ID = new JLabel("���:");
		lessee_ID.setBounds(78, 48, 30, 20);	
		this.add(lessee_ID);	
		
		lessee_IDText = new JTextField();
		lessee_IDText.setBounds(116, 48, 150, 20);
		lessee_IDText.setText(lessee_id);	//��ȡ��Ų���ʾ
		this.add(lessee_IDText);
		
		lessee_Name = new JLabel("����:");
		lessee_Name.setBounds(78, 88, 30, 20);
		this.add(lessee_Name);
		
		
		lessee_NameText = new JTextField();
		lessee_NameText.setBounds(116, 88, 150, 20);
		lessee_NameText.setText(lessee_name);	//�����⻧��������ʾ
		this.add(lessee_NameText);
		
		sex_Label = new JLabel("�Ա�:");
		sex_Label.setBounds(78, 128, 30, 20);
		this.add(sex_Label);
		
		sex_Box = new JComboBox(new String[]{"","��","Ů"});
		sex_Box.setSelectedItem(sm.getValueAt(rowNum, 2));
		sex_Box.setBounds(116, 128, 60, 20);
		this.add(sex_Box);
		
		
		age_Label = new JLabel("����:");
		age_Label.setBounds(78, 168, 30, 20);
		this.add(age_Label);

		age_Text = new JTextField();
		age_Text.setBounds(116, 168, 150, 20);
		age_Text.setText(lessee_age);	//�����⻧���䲢��ʾ
		this.add(age_Text);

		rent_Label = new JLabel("���:");
		rent_Label.setBounds(78, 208, 30, 20);
		this.add(rent_Label);

		rent_Text = new JTextField();
		rent_Text.setBounds(116, 208, 150, 20);
		rent_Text.setText(lessee_rent);	//�����⻧�����ʾ
		this.add(rent_Text);

	
		time_Label = new JLabel("ʱ��:");
		time_Label.setBounds(78, 248, 30, 20);	
		this.add(time_Label);

		time_Text = new JTextField();
		time_Text.setBounds(116, 248, 150, 20);
		time_Text.setText(lessee_time);	//�����⻧ʱ�䲢��ʾ
		this.add(time_Text);

		modify_Button = new JButton("�޸�");
		modify_Button.setBounds(70, 330, 60, 25);
		
		
		//ע��"�޸�"��ť�¼�����
		modify_Button.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				lessee newlessee = new lessee();
				String id = lessee_IDText.getText().trim();
				String name = lessee_NameText.getText().trim();
				String sex = sex_Box.getSelectedItem().toString();
				String age = age_Text.getText().trim();
				String rent_Name = rent_Text.getText().trim();
				String time_Name = time_Text.getText().trim();
				//����У�鲿��
				if(id.equals("")){
					JOptionPane.showMessageDialog(jd, "��Ų���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(id.length()!=2){
					JOptionPane.showMessageDialog(jd, "��ű�������λ����", "", JOptionPane.WARNING_MESSAGE);
					lessee_IDText.setText("");
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

				if(rent_Name.equals("")){
					JOptionPane.showMessageDialog(jd, "�����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(time_Name.equals("")){
					JOptionPane.showMessageDialog(jd, "ʱ�䲻��Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}

				newlessee.setLesseeID(id);
				newlessee.setLesseeNAME(name);
				newlessee.setLesseeSEX(sex);
				newlessee.setLesseeAGE(age);
				newlessee.setlesseetime(time_Name);
				newlessee.setlesseeMoney(rent_Name);
				if(helper.updateSlessee(newlessee, lessee_id)){
					JOptionPane.showMessageDialog(jd, "�޸ĳɹ���");
					jd.dispose();	//�رյ�ǰ����
					return ;
				}else{
					JOptionPane.showMessageDialog(jd, "�޸�ʧ�ܣ�", "", JOptionPane.WARNING_MESSAGE);
					jd.dispose();	//�رյ�ǰ����
					return ;
				}
			}
			
		});
		this.add(modify_Button);
		
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
