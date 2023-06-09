package frame;

import dao.ManageHelper;
import model.lesseemodel;
import util.CreateSql;
import util.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//��������ѯ����
public class ConditionsQueryFrame extends JDialog{
    private JLabel lessee_ID;    //"���"��ǩ��
    private JLabel lessee_Name;	//"����"��ǩ��
    private JLabel sex_Label;	//"�Ա�"��ǩ��
    private JLabel age_Label;	//"�����ǩ"��
    private JLabel time_Label;	//"ʱ��"��ǩ��
    private JLabel rent_Label;	//"���"��ǩ��
    private JTextField lessee_IDText;	//"�����ı���
    private JTextField lessee_NameText;	//"����"�ı���
    private JTextField sex_Text;	//�Ա�ѡ��
    private JTextField age_Text;	//����ѡ��
    private JTextField rent_Text;	//���
    private JTextField time_Text;	//ʱ��
    private JButton conditions_button;	//��������ѯ��ť 
    private ManageHelper helper;
    private JDialog jd;	//��ǰ����
    /**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
    public ConditionsQueryFrame(JDialog owner, String title, boolean modal, JTable jt){
    	super(owner, title, modal);
    	this.jd = this;
    	this.setLayout(null);
    	
    	lessee_ID = new JLabel("���:");
    	lessee_ID.setBounds(29, 19, 30, 20);
    	this.add(lessee_ID);
    	
    	lessee_IDText = new JTextField();
    	lessee_IDText.setBounds(65, 19, 100, 20);
    	this.add(lessee_IDText);
    	
    	lessee_Name = new JLabel("����:");
    	lessee_Name.setBounds(200, 19, 30, 20);
    	this.add(lessee_Name);
    	
    	lessee_NameText = new JTextField();
    	lessee_NameText.setBounds(240, 19, 100, 20);
    	this.add(lessee_NameText);
    	
    	sex_Label = new JLabel("�Ա�:");
    	sex_Label.setBounds(29, 50, 30, 20);
    	this.add(sex_Label);
    	
    	sex_Text = new JTextField();
    	sex_Text.setBounds(65, 50, 100, 20);
    	this.add(sex_Text);
    	
    	age_Label = new JLabel("����:");
    	age_Label.setBounds(200, 50, 30, 20);
    	this.add(age_Label);
    	
    	age_Text = new JTextField();
    	age_Text.setBounds(240, 50, 100, 20);
    	this.add(age_Text);
    	
    	rent_Label = new JLabel("���:");
    	rent_Label.setBounds(29, 83, 30, 20);
    	this.add(rent_Label);
    	
    	rent_Text = new JTextField();
    	rent_Text.setBounds(65, 83, 100, 20);
    	this.add(rent_Text);
    	
    	time_Label = new JLabel("ʱ��:");
    	time_Label.setBounds(200, 83, 30, 20);
    	this.add(time_Label);
    	
    	time_Text = new JTextField();
    	time_Text.setBounds(240, 83, 100, 20);
    	this.add(time_Text);

    	conditions_button = new JButton("��������ѯ");
    	conditions_button.setBounds(230, 130, 100, 30);
    	//ע��"��������ѯ"��ť�¼�����
    	conditions_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = lessee_IDText.getText().trim();
				String name = lessee_NameText.getText().trim();
				String sex = sex_Text.getText().trim();
				String age = age_Text.getText().trim();
				String rent = rent_Text.getText().trim();
				String time = time_Text.getText().trim();
				if(id.equals("")&&name.equals("")&&sex.equals("")&&age.equals("")&&rent.equals("")&&time.equals("")){
					JOptionPane.showMessageDialog(jd, "��������Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}else{
					String sql = CreateSql.getConditions_Sql(id, name, sex, age, rent, time);
					lesseemodel sm = new lesseemodel(sql,jd);
					jt.setModel(sm);
					jd.dispose();
				}
				
			}
		});
    	this.add(conditions_button);
    	
    	
    	this.setSize(411, 222);
    	this.setResizable(false);
    	WindowUtil.setFrameCenter(this);
    	this.setVisible(true);
    }
}
